package com.company;

public class Main {

    public static void main(String[] args) {

        // Stack the glasses

        GlassNode glassTree = new GlassNode(0, 0);

        int level = 4;
        System.out.println("level: " + level);

        for (int i = 0; i < level-1; i++) {
            for (int j = 0; j <= i; j++) {

                GlassNode existingLeftGlass = glassTree.search(i + 1, j);

                if (existingLeftGlass == null)
                {
                    glassTree.search(i,j).left = new GlassNode(i + 1, j);
                    glassTree.search(i,j).right = new GlassNode(i + 1, j + 1);
                }
                else{
                    glassTree.search(i,j).left = existingLeftGlass;
                    glassTree.search(i,j).right = new GlassNode(i + 1, j + 1);
                }
            }
        }

        // Fill the glasses

        int water = 2000;
        System.out.println("water: " + water);

        glassTree.fill(water);

        // Print the glasses

        System.out.println("\nresult: ");
        glassTree.printLevelOrder();
    }
}
