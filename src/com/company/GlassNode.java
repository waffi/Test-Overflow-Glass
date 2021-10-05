package com.company;

public class GlassNode {
    public float value;
    public GlassNode left;
    public GlassNode right;
    public GlassPosition position;

    public GlassNode(int i, int j)
    {
        this.position = new GlassPosition(i, j);
    }

    // search

    public GlassNode search(int i, int j)
    {
        return this.search(this, new GlassPosition(i, j));
    }

    private GlassNode search(GlassNode node, GlassPosition position)
    {
        if (node == null)
            return null;

        if (node.position.i == position.i && node.position.j == position.j)
            return node;

        GlassNode leftResult = this.search(node.left, position);
        if (leftResult != null)
            return leftResult;

        GlassNode rightResult = this.search(node.right, position);
        if (rightResult != null)
            return rightResult;

        return null;
    }

    // fill

    public void fill(float water)
    {
        this.value += water;

        if (this.value > 250)
        {
            float overflowWater = (this.value - 250) / 2;
            this.value = 250;

            if (this.left != null)
                this.left.fill(overflowWater);
            if (this.right != null)
                this.right.fill(overflowWater);
        }
    }

    // height

    int height(GlassNode root)
    {
        if (root == null)
            return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);

            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    // print

    void printLevelOrder()
    {
        int h = height(this);
        int i;
        for (i = 1; i <= h; i++)
        {
            System.out.println("level: " + i);
            printCurrentLevel(this, i);
        }
    }

    void printCurrentLevel(GlassNode node, int level)
    {
        if (node == null)
            return;
        if (level == 1)
            System.out.println("(" + node.position.i +"," + node.position.j + "):" + node.value);
        else if (level > 1) {
            if (node.position.j == 0)
                printCurrentLevel(node.left, level - 1);

            printCurrentLevel(node.right, level - 1);
        }
    }

}