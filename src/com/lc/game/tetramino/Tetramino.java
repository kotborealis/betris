package com.lc.game.tetramino;

import com.lc.game.mino.Block;
import com.lc.game.mino.BlockType;
import com.lc.game.mino.Blocks;

public class Tetramino {
    public BlockType type;
    public Block[][] value;
    public int n = 0;

    public void render(float x, float y, float left_edge, float top_edge){
        for(int i = 0; i < 4; i++)
            for(int j =0; j < 4; j++){
                value[j][i].render(x + i, y + j, left_edge, top_edge);
            }
    }

    public int minX(){
        return 0;
    }

    public int maxX(){
        return 1;
    }

    public int minY(){
        return 0;
    }

    public int maxY(){
        return 1;
    }

    public void rotateRight(){
        n = (n+1)%4;
        value = Tetraminos.tetraminos[n%4][type.ordinal()];
    }

    public void rotateLeft(){
        n = (n+4-1)%4;
        value = Tetraminos.tetraminos[n%4][type.ordinal()];
    }

    public Tetramino(BlockType type){
        if(!Tetraminos.init_done) Tetraminos.init();

        this.type = type;

        n = 0;
        value = Tetraminos.tetraminos[n][type.ordinal()];
    }
}
