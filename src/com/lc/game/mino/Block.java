package com.lc.game.mino;

import com.lc.texture.Texture;

import static org.lwjgl.opengl.GL11.*;

public class Block {
    public static final float size = 25;
    private Texture tex;

    public void render(float x, float y, float left_edge, float top_edge){
        if(tex == null) return;

        tex.bind();

        if(shadow)
            glColor4f(.5f,.5f,.5f, 1);
        else
            glColor4f(1,1,1, 1);

        glEnable(GL_TEXTURE_2D);
        glBegin(GL_QUADS);
        glTexCoord2f(0,1);
        glVertex2f(left_edge + x * Block.size, top_edge + y * Block.size);
        glTexCoord2f(1,1);
        glVertex2f(left_edge + x * Block.size + Block.size, top_edge + y * Block.size);
        glTexCoord2f(1,0);
        glVertex2f(left_edge + x * Block.size + Block.size, top_edge + y * Block.size + Block.size);
        glTexCoord2f(0,0);
        glVertex2f(left_edge + x * Block.size, top_edge + y * Block.size + Block.size);
        glEnd();
    }

    private boolean shadow;

    Block(BlockType type, boolean shadow){
        BlockTextures.init();

        this.shadow = shadow;

        switch (type){
            case I: tex = BlockTextures.I; break;
            case O: tex = BlockTextures.O; break;
            case T: tex = BlockTextures.T; break;
            case S: tex = BlockTextures.S; break;
            case Z: tex = BlockTextures.Z; break;
            case J: tex = BlockTextures.J; break;
            case L: tex = BlockTextures.L; break;
            case Empty: tex = null; break;
        }
    }
}
