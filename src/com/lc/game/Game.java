package com.lc.game;

import com.lc.Main;
import com.lc.Texture;
import com.lc.game.mino.Block;
import com.lc.game.mino.Blocks;
import com.lc.game.tetramino.Tetramino;

import static org.lwjgl.opengl.GL11.*;

public class Game {
    @SuppressWarnings("FieldCanBeLocal")
    private float drop_ratio = 2.5f;
    private long lastNanos = System.nanoTime();

    private Texture background;
    private float w_width;
    private float w_height;

    TetraminoBag bag;
    private GameControls gameControls;

    private Block well[][] = new Block[10][24];

    public Game() {
        gameControls = new GameControls(this);
        bag = new TetraminoBag(well);

        w_height = Main.window_height;
        w_width = Main.window_width;

        for (int i = 0; i < well.length; i++)
            for (int j = 0; j < well[0].length; j++)
                well[i][j] = Blocks.E;

        bag.spawnTetramino();

        background = Texture.loadTexture("res/select00.jpg");
    }

    public void handleKey(int key, int action) {
        gameControls.handleKey(key, action);
    }


    public void update() {
        long targetNanos = lastNanos + (long) (1_000_000_000.0f / drop_ratio) - 1_000_000L;
        if (System.nanoTime() >= targetNanos) {
            lastNanos = System.nanoTime();
            if (bag.current.moveDown())
                bag.spawnTetramino();
        }

        for (int i = 0; i < gameControls.rotateLeft; i++)
            bag.current.rotateLeft(true);
        gameControls.rotateLeft = 0;
        for (int i = 0; i < gameControls.rotateRight; i++)
            bag.current.rotateRight(true);
        gameControls.rotateRight = 0;
        for (int i = 0; i < gameControls.moveDown; i++)
            if (bag.current.moveDown()) {
                bag.spawnTetramino();
                break;
            }
        gameControls.moveDown = 0;

        if (gameControls.moveLR > 0)
            for (int i = 0; i < gameControls.moveLR; i++)
                bag.current.moveRight();
        if (gameControls.moveLR < 0)
            for (int i = 0; i > gameControls.moveLR; i--)
                bag.current.moveLeft();
        gameControls.moveLR = 0;

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

        glColor3f(1.f, 1.f, 1.f);

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
        glVertex2f(150, 0);
        glVertex2f(150, 500);
        glVertex2f(150 + Block.size * 10, 500);
        glVertex2f(150 + Block.size * 10, 0);
        glEnd();

        glColor3f(137 / 255.f, 42 / 255.f, 118 / 225.f);
        glBegin(GL_LINES);
        for (int i = 1; i < 20; i++) {
            glVertex2f(150, i * Block.size);
            glVertex2f(150 + Block.size * 10, i * Block.size);
        }
        for (int j = 1; j < 10; j++) {
            glVertex2f(150 + j * Block.size, 0);
            glVertex2f(150 + j * Block.size, 500);
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
        bag.current.renderShadow();
        bag.current.render();
    }

    private void renderTetraminoPool() {
        for(int i = 0; i < Math.min(bag.size(), 4); i++){
            Tetramino t = new Tetramino(null, bag.get(i));
            t.x = 12;
            t.y = 5 + i*5;
            t.render();
        }
    }

    private void renderTetraminoStash() {
        if (bag.stash == null) return;
        Tetramino t = new Tetramino(null, bag.stash);
        t.x = -4;
        t.y = 5;
        t.render();
    }

    public void render() {
        renderProjection();
        renderBackground();
        renderField();
        renderWell();
        renderTetramino();
        renderTetraminoPool();
        renderTetraminoStash();
    }
}
