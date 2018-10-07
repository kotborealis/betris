package com.lc.game.mino;

import com.lc.texture.Texture;

import static org.lwjgl.opengl.GL11.*;

public class Block {
    public static final float size = 25;

    private float x;
    private float y;
    private Texture tex;
    private boolean shadow;

    public void render(){
        if(shadow)
            glColor4f(.5f,.5f,.5f, 1);
        else
            glColor4f(1,1,1, 1);

        tex.bind();
        glEnable(GL_TEXTURE_2D);
        glBegin(GL_QUADS);
            glTexCoord2f(0,1);
            glVertex2f(x, y);
            glTexCoord2f(1,1);
            glVertex2f(x + size, y);
            glTexCoord2f(1,0);
            glVertex2f(x + size, y + size);
            glTexCoord2f(0,0);
            glVertex2f(x, y + size);
        glEnd();
    }

    public Block(BlockType type, float x, float y, boolean shadow){
        BlockTextures.init();

        this.x = x;
        this.y = y;

        this.shadow = shadow;

        switch (type){
            case I: tex = BlockTextures.I; break;
            case O: tex = BlockTextures.O; break;
            case T: tex = BlockTextures.T; break;
            case S: tex = BlockTextures.S; break;
            case Z: tex = BlockTextures.Z; break;
            case J: tex = BlockTextures.J; break;
            case L: tex = BlockTextures.L; break;
        }
    }
}
