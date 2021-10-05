package com.company.overflowglass.test;

import com.company.overflowglass.main.model.GlassNode;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class GlassNodeTest {

    GlassNode createGlassTree(int level){

        // Arrange glass tree object

        GlassNode glassTree = new GlassNode(0, 0);

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

        return glassTree;
    }

    @Test
    void search() {
        // Arrange
        int level = 4;
        GlassNode glassTree = createGlassTree(level);
        int i = 3;
        int j = 2;

        // Act
        GlassNode result = glassTree.search(i, j);

        // Assert
        Assert.assertNotNull(result);
    }

    @Test
    void getHeight() {
        // Arrange
        int level = 4;
        GlassNode glassTree = createGlassTree(level);

        // Act
        int result = glassTree.getHeight();

        // Assert
        Assert.assertEquals(level, result);
    }

}