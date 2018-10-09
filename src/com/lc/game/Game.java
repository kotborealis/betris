package com.lc.game;

import com.lc.Main;
import com.lc.game.mino.Block;
import com.lc.game.mino.BlockType;
import com.lc.game.mino.Blocks;
import com.lc.game.tetramino.Tetramino;
import com.lc.texture.Texture;

import java.util.ArrayList;
import java.util.Collections;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Game {
    private Texture background;
    private float w_width;
    private float w_height;

    private Tetramino cur;
    private int queuedMove = 0;
    private int queuedMoveDown = 0;
    private int queuedRotateRight = 0;
    private int queuedRotateLeft = 0;

    private ArrayList<BlockType> bag;

    private Block well[][] = new Block[10][24];

    private long lastNanos = System.nanoTime();

    public Game() {
        w_height = Main.window_height;
        w_width = Main.window_width;

        bag = new ArrayList<>();

        for (int i = 0; i < well.length; i++)
            for (int j = 0; j < well[0].length; j++)
                well[i][j] = Blocks.E;

//        well[0][0] = Blocks.I;
//        well[0][1] = Blocks.I;
//        well[0][2] = Blocks.I;
//        well[0][3] = Blocks.I;
//        well[1][0] = Blocks.I_shadow;
//        well[2][0] = Blocks.I_shadow;
//        well[3][0] = Blocks.E;


        spawnTetramino();

        background = Texture.loadTexture("res/select00.jpg");
    }

    public void handleKey(int key, int action) {
        if (action == GLFW_PRESS || action == GLFW_REPEAT) {
            if (key == GLFW_KEY_LEFT) queuedMove--;
            if (key == GLFW_KEY_RIGHT) queuedMove++;
            if (key == GLFW_KEY_DOWN) queuedMoveDown++;
            if (key == GLFW_KEY_SPACE) queuedMoveDown += 24;
            if (key == GLFW_KEY_Z) queuedRotateLeft++;
            if (key == GLFW_KEY_X) queuedRotateRight++;
        }
    }

    public void update() {
        float drop_ps = 2.5f;
        long targetNanos = lastNanos + (long) (1_000_000_000.0f / drop_ps) - 1_000_000L;
        if (System.nanoTime() >= targetNanos) {
            lastNanos = System.nanoTime();
            if (cur.moveDown())
                spawnTetramino();
        }

        for (int i = 0; i < queuedRotateLeft; i++)
            cur.rotateLeft(true);
        queuedRotateLeft = 0;
        for (int i = 0; i < queuedRotateRight; i++)
            cur.rotateRight(true);
        queuedRotateRight = 0;
        for (int i = 0; i < queuedMoveDown; i++)
            if (cur.moveDown()) {
                spawnTetramino();
                break;
            }
        queuedMoveDown = 0;

        if (queuedMove > 0)
            for (int i = 0; i < queuedMove; i++)
                cur.moveRight();
        if (queuedMove < 0)
            for (int i = 0; i > queuedMove; i--)
                cur.moveLeft();
        queuedMove = 0;

        for (int j = 0; j < well[0].length; j++) {
            int empty = 10;
            for (Block[] aWell : well)
                if (aWell[j] != Blocks.E)
                    empty--;
            if (empty == 0)
                destroyRow(j);
        }
    }

    private void destroyRow(int row) {
        for (int j = row; j > 0; j--) {
            for (int i = 0; i < well.length; i++)
                well[i][j] = well[i][j - 1];
        }
        for (int i = 0; i < well.length; i++)
            well[i][0] = Blocks.E;
    }

    private void spawnTetramino() {
        if (bag.size() <= 7) {
            ArrayList<BlockType> new_bag = new ArrayList<BlockType>() {{
                add(BlockType.I);
                add(BlockType.O);
                add(BlockType.T);
                add(BlockType.S);
                add(BlockType.Z);
                add(BlockType.J);
                add(BlockType.L);
            }};
            Collections.shuffle(new_bag);
            bag.addAll(new_bag);
        }
        BlockType type = bag.get(0);
        bag.remove(0);
        cur = new Tetramino(well, type);
    }

    private void renderProjection() {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0.0f, w_width, w_height, 0.0f, 0.0f, 1.0f);
    }

    private void renderBackground() {
        glMatrixMode(GL_PROJECTION);
        glPushMatrix();
        glLoadIdentity();
        glMatrixMode(GL_MODELVIEW);
        glPushMatrix();
        glLoadIdentity();

        background.bind();

        glEnable(GL_TEXTURE_2D);
        glBegin(GL_QUADS);
        glTexCoord2f(0, 0);
        glVertex2f(-1.0f, -1.0f);
        glTexCoord2f(1, 0);
        glVertex2f(1.0f, -1.0f);
        glTexCoord2f(1, 1);
        glVertex2f(1.0f, 1.0f);
        glTexCoord2f(0, 1);
        glVertex2f(-1.0f, 1.0f);
        glEnd();

        glDisable(GL_TEXTURE_2D);

        glPopMatrix();
        glMatrixMode(GL_PROJECTION);
        glPopMatrix();
        glMatrixMode(GL_MODELVIEW);
    }

    private void renderField() {
        glColor3f(1, 1, 1);
        glBegin(GL_LINE_STRIP);
        glVertex2f(w_width / 2 - Block.size * 10 / 2, 0);
        glVertex2f(w_width / 2 - Block.size * 10 / 2, 500);
        glVertex2f(w_width / 2 + Block.size * 10 / 2, 500);
        glVertex2f(w_width / 2 + Block.size * 10 / 2, 0);
        glEnd();

        glColor3f(137 / 255.f, 42 / 255.f, 118 / 225.f);
        glBegin(GL_LINES);
        for (int i = 1; i < 20; i++) {
            glVertex2f(w_width / 2 - Block.size * 10 / 2, i * Block.size);
            glVertex2f(w_width / 2 + Block.size * 10 / 2, i * Block.size);
        }
        for (int j = 1; j < 10; j++) {
            glVertex2f(w_width / 2 - Block.size * 10 / 2 + j * Block.size, 0);
            glVertex2f(w_width / 2 - Block.size * 10 / 2 + j * Block.size, 500);
        }
        glEnd();
    }

    private void renderWell() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 24; y++) {
                if (well[x][y] != null) {
                    Block b = well[x][y];
                    b.render(x, y);
                }
            }
        }
    }

    private void renderTetramino() {
        cur.render();
    }

    public void render() {
        renderProjection();
        renderBackground();
        renderField();
        renderWell();
        renderTetramino();
    }
}
