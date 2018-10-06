package com.lc.game;

import com.lc.Main;
import com.lc.texture.Texture;

import static org.lwjgl.opengl.GL11.*;

public class Game {
    Texture background;
    float w_width;
    float w_height;

    float block_size = 25;

    public void update(){
    }


    void renderProjection(){
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0.0f, w_width, w_height, 0.0f, 0.0f, 1.0f);
    }

    void renderBackground(){
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

    void renderField(){
        glColor3f(1, 1, 1);
        glBegin(GL_LINE_STRIP);
            glVertex2f(w_width/2 - block_size * 10 / 2, 100);
            glVertex2f(w_width/2 - block_size * 10 / 2, 500);
            glVertex2f(w_width/2 + block_size * 10 / 2, 500);
            glVertex2f(w_width/2 + block_size * 10 / 2, 100);
        glEnd();

        glColor3f(137/255.f, 42/255.f, 118/225.f);
        glBegin(GL_LINES);
            for(int i = 1; i < 16; i++){
                glVertex2f(w_width/2 - block_size * 10 / 2, 100 + i * block_size);
                glVertex2f(w_width/2 + block_size * 10 / 2, 100 + i * block_size);
            }
            for(int j = 1; j < 10; j++){
                glVertex2f(w_width/2 - block_size * 10 / 2 + j * block_size, 100);
                glVertex2f(w_width/2 - block_size * 10 / 2 + j * block_size, 500);
            }
        glEnd();
    }

    public void render(){
        renderProjection();
        renderBackground();
        renderField();
    }

    public Game(){
        w_height = Main.window_height;
        w_width = Main.window_width;
        background = Texture.loadTexture("res/select00.jpg");
    }
}
