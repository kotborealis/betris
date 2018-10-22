package com.lc.game.mino;

import com.lc.Texture;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;

public class Block {
    public static final float size = 25;
    private Texture tex;

    private static FloatBuffer texture_coords;
    private FloatBuffer vertices = BufferUtils.createFloatBuffer(4 * 2);

    Block(BlockType type) {
        BlockTextures.init();
        init_tex_coords();

        switch (type) {
            case I:
                tex = BlockTextures.I;
                break;
            case O:
                tex = BlockTextures.O;
                break;
            case T:
                tex = BlockTextures.T;
                break;
            case S:
                tex = BlockTextures.S;
                break;
            case Z:
                tex = BlockTextures.Z;
                break;
            case J:
                tex = BlockTextures.J;
                break;
            case L:
                tex = BlockTextures.L;
                break;
            case Empty:
                tex = null;
                break;
        }
    }

    private void init_tex_coords() {
        if (texture_coords != null) return;

        texture_coords = BufferUtils.createFloatBuffer(4 * 2);
        texture_coords.put(new float[]{0, 1});
        texture_coords.put(new float[]{1, 1});
        texture_coords.put(new float[]{1, 0});
        texture_coords.put(new float[]{0, 0});
        texture_coords.flip();
    }

    public void render(float x, float y, boolean shadow) {
        if (tex == null) return;

        float top_edge = -100;
        float left_edge = 150;

        tex.bind();

        if (shadow)
            glColor3f(.5f, .5f, .5f);
        else
            glColor3f(1.f, 1.f, 1.f);

        vertices.clear();
        vertices.put(new float[]{left_edge + x * Block.size, top_edge + y * Block.size});
        vertices.put(new float[]{left_edge + x * Block.size + Block.size, top_edge + y * Block.size});
        vertices.put(new float[]{left_edge + x * Block.size + Block.size, top_edge + y * Block.size + Block.size});
        vertices.put(new float[]{left_edge + x * Block.size, top_edge + y * Block.size + Block.size});
        vertices.flip();

        glEnableClientState(GL_VERTEX_ARRAY);
        glVertexPointer(2, GL_FLOAT, 0, vertices);
        glEnableClientState(GL_TEXTURE_COORD_ARRAY);
        glTexCoordPointer(2, GL_FLOAT, 0, texture_coords);

        glEnable(GL_TEXTURE_2D);
        glDrawArrays(GL_QUADS, 0, 4);
        glDisable(GL_TEXTURE_2D);

        glDisable(GL_BLEND);
    }

    public void render(float x, float y){
        render(x, y, false);
    }
}
