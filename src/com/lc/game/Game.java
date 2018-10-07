package com.lc.game;

import com.lc.Main;
import com.lc.game.mino.Block;
import com.lc.game.mino.BlockType;
import com.lc.texture.Texture;

import static org.lwjgl.opengl.GL11.*;

public class Game {
    private Texture background;
    private float w_width;
    private float w_height;

    private Block[][] well;

    public void update(){
    }


    private void renderProjection(){
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0.0f, w_width, w_height, 0.0f, 0.0f, 1.0f);
    }

    private void renderBackground(){
        glMatrixMode(GL_PROJECTION);
        glPushMatrix();
        glLoadIdentity();
        glMatrixMode(GL_MODELVIEW);
        glPushMatrix();
        glLoadIdentity();

        background.bind();

        glEnable(GL_TEXTURE_2D);
        glBegin(GL_QUADS);
            glTexCoord2f(0,0);
            glVertex2f(-1.0f, -1.0f);
            glTexCoord2f(1,0);
            glVertex2f(1.0f, -1.0f);
            glTexCoord2f(1,1);
            glVertex2f(1.0f, 1.0f);
            glTexCoord2f(0,1);
            glVertex2f(-1.0f, 1.0f);
        glEnd();

        glDisable(GL_TEXTURE_2D);

        glPopMatrix();
        glMatrixMode(GL_PROJECTION);
        glPopMatrix();
        glMatrixMode(GL_MODELVIEW);
    }

    private void renderField(){
        glColor3f(1, 1, 1);
        glBegin(GL_LINE_STRIP);
            glVertex2f(w_width/2 - Block.size * 10 / 2, 100);
            glVertex2f(w_width/2 - Block.size * 10 / 2, 500);
            glVertex2f(w_width/2 + Block.size * 10 / 2, 500);
            glVertex2f(w_width/2 + Block.size * 10 / 2, 100);
        glEnd();

        glColor3f(137/255.f, 42/255.f, 118/225.f);
        glBegin(GL_LINES);
            for(int i = 1; i < 16; i++){
                glVertex2f(w_width/2 - Block.size * 10 / 2, 100 + i * Block.size);
                glVertex2f(w_width/2 + Block.size * 10 / 2, 100 + i * Block.size);
            }
            for(int j = 1; j < 10; j++){
                glVertex2f(w_width/2 - Block.size * 10 / 2 + j * Block.size, 100);
                glVertex2f(w_width/2 - Block.size * 10 / 2 + j * Block.size, 500);
            }
        glEnd();
    }

    private void renderWell(){
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 16; y++){
                if(well[x][y] != null){
                    well[x][y].render();
                }
            }
        }
    }

    public void render(){
        renderProjection();
        renderBackground();
        renderField();
        renderWell();
    }

    public Game(){
        w_height = Main.window_height;
        w_width = Main.window_width;

        well = new Block[10][16];
        well[0][1] = new Block(BlockType.I, 25, 0, false);
        well[0][2] = new Block(BlockType.J, 50, 0, false);
        well[0][3] = new Block(BlockType.L, 75, 0, false);
        well[0][4] = new Block(BlockType.Z, 100, 0, false);
        well[0][5] = new Block(BlockType.S, 125, 0, false);
        well[0][6] = new Block(BlockType.O, 150, 0, false);
        well[0][7] = new Block(BlockType.T, 175, 0, false);
        well[1][1] = new Block(BlockType.I, 25, 25, true);
        well[1][2] = new Block(BlockType.J, 50, 25, true);
        well[1][3] = new Block(BlockType.L, 75, 25, true);
        well[1][4] = new Block(BlockType.Z, 100, 25, true);
        well[1][5] = new Block(BlockType.S, 125, 25, true);
        well[1][6] = new Block(BlockType.O, 150, 25, true);
        well[1][7] = new Block(BlockType.T, 175, 25, true);

        background = Texture.loadTexture("res/select00.jpg");
    }
}
