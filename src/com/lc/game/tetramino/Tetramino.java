package com.lc.game.tetramino;

import com.lc.game.mino.Block;
import com.lc.game.mino.BlockType;

public class Tetramino {
    public Block value[][] = new Block[4][4];

    public void render(float x, float y, float left_edge, float top_edge){
        for(int i = 0; i < 4; i++)
            for(int j =0; j < 4; j++){
                value[j][i].render(x + i, y + j, left_edge, top_edge);
            }
    }

    public Tetramino(BlockType type){
        if(!Tetraminos.init_done) Tetraminos.init();

        for(int x = 0; x < 4; x++)
            System.arraycopy(Tetraminos.tetraminos[type.ordinal()][x], 0, value[x], 0, 4);
    }
}
