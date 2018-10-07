package com.lc.game.tetramino;

import com.lc.game.mino.Block;
import com.lc.game.mino.BlockType;
import com.lc.game.mino.Blocks;

public class Tetramino {
    private BlockType type;
    public Block[][] value;
    private int n;

    public void render(float x, float y, float left_edge, float top_edge){
        for(int i = 0; i < 4; i++)
            for(int j =0; j < 4; j++){
                value[i][j].render(x + i, y + j, left_edge, top_edge);
            }
    }

    public int minX(){
        int val = 9999;
        for(int x = 0; x < 4; x++)
            for(int y = 0; y < 4; y++)
                if(value[x][y] != Blocks.E && val > x)
                    val = x;
        return val;
    }

    public int maxX(){
        int val = -999;
        for(int x = 0; x < 4; x++)
            for(int y = 0; y < 4; y++)
                if(value[x][y] != Blocks.E && val < x)
                    val = x;
        return val;
    }

    public int minY(){
        int val = 9999;
        for(int x = 0; x < 4; x++)
            for(int y = 0; y < 4; y++)
                if(value[x][y] != Blocks.E && val > y)
                    val = y;
        return val;
    }

    public int maxY(){
        int val = -999;
        for(int x = 0; x < 4; x++)
            for(int y = 0; y < 4; y++)
                if(value[x][y] != Blocks.E && val < y)
                    val = y;
        return val;
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
