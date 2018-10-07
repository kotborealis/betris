package com.lc.game.tetramino;

import com.lc.game.mino.Block;
import com.lc.game.mino.BlockType;
import com.lc.game.mino.Blocks;

public class Tetramino {
    private BlockType type;
    public Block[][] value;
    private int n;

    Block[][] well;

    int x = 0;
    int y = 2;

    public void render(float left_edge, float top_edge){
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

    public void moveRight(){
        x++;
        afterMove();
    }

    public void moveLeft(){
        x--;
        afterMove();
    }

    public boolean moveDown(){
        boolean r = false;
        y++;

        if(y + maxY() >= 21){
            for(int i = 0; i < 4; i++)
                for(int j = 0; j < 4; j++){
                    if(value[i][j] != Blocks.E)
                        well[x+i][y+j] = value[i][j];
                }
            r = true;
        }

        afterMove();
        return r;
    }

    public void afterMove(){
        if(x + minX() < 0) x = 0;
        if(x + maxX() >= 10) x = x - (x + maxX() - 9);
    }

    public Tetramino(Block[][] well, BlockType type){
        if(!Tetraminos.init_done) Tetraminos.init();

        this.well = well;

        this.type = type;

        n = 0;
        value = Tetraminos.tetraminos[n][type.ordinal()];
    }
}
