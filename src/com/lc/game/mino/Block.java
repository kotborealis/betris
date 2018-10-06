package com.lc.game.mino;

import com.lc.texture.Texture;

import static org.lwjgl.opengl.GL11.*;

public class Block {
    public static final float size = 25;

    private float x;
    private float y;
    private block_type type;
    private Texture tex;

    private static boolean init_done = false;
    private static Texture texI;
    private static Texture texO;
    private static Texture texT;
    private static Texture texS;
    private static Texture texZ;
    private static Texture texJ;
    private static Texture texL;
    private static Texture texPlaceholder;

    static public void init(){
        texI = Texture.loadTexture("res/b7.png");
        texO = Texture.loadTexture("res/b5.png");
        texT = Texture.loadTexture("res/b9.png");
        texS = Texture.loadTexture("res/b6.png");
        texZ = Texture.loadTexture("res/b3.png");
        texJ = Texture.loadTexture("res/b8.png");
        texL = Texture.loadTexture("res/b4.png");
        texPlaceholder = Texture.loadTexture("res/placeholder.png");
        init_done = true;
    }

    public void render(){
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
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

    public Block(block_type type, float x, float y){
        if(!init_done) init();

        this.x = x;
        this.y = y;
        this.type = type;

        switch (type){
            case I: tex = texI; break;
            case O: tex = texO; break;
            case T: tex = texT; break;
            case S: tex = texS; break;
            case Z: tex = texZ; break;
            case J: tex = texJ; break;
            case L: tex = texL; break;
            case Placeholder: tex = texPlaceholder; break;
        }
    }
}
