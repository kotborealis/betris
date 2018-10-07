package com.lc.game.mino;

import com.lc.texture.Texture;

import static org.lwjgl.opengl.GL11.*;

public class Block {
    public static final float size = 25;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    private float x;
    private float y;

    public Texture getTex() {
        return tex;
    }

    private Texture tex;

    public boolean isShadow() {
        return shadow;
    }

    private boolean shadow;

    public Block(BlockType type, boolean shadow){
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
