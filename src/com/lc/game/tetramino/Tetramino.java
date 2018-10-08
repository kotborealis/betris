package com.lc.game.tetramino;

import com.lc.game.mino.Block;
import com.lc.game.mino.BlockType;
import com.lc.game.mino.Blocks;

public class Tetramino {
    private BlockType type;
    public Block[][] value;
    private int n;

    private Block[][] well;

    private int x = 0;
    private int y = 0;

    public void render(){
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++){
                value[i][j].render(x + i, y + j);
            }
    }

    private int minX(){
        int val = 9999;
        for(int x = 0; x < 4; x++)
            for(int y = 0; y < 4; y++)
                if(value[x][y] != Blocks.E && val > x)
                    val = x;
        return val;
    }

    private int maxX(){
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

    private int maxY(){
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
        collision();
    }

    public void rotateLeft(){
        n = (n+4-1)%4;
        value = Tetraminos.tetraminos[n%4][type.ordinal()];
        collision();
    }

    public void moveRight(){
        x++;
        collision();
    }

    public void moveLeft(){
        x--;
        collision();
    }

    public boolean moveDown(){
        y++;

        boolean shouldStop = collision();

        if(shouldStop){
//            for(int i = minX(); i < maxY(); i++)
//                for(int j = minY(); j < maxX(); j++){
//                    if(value[i][j] != Blocks.E)
//                        well[x + minX() + i][y + minY() + j] = value[i][j];
//                }
        }

        return shouldStop;
    }

    public boolean collision(){
        boolean shouldStop = false;

        if(x + minX() < 0){
            x -= x + minX();
        }
        if(x + maxX() >= well.length){
            x += 10 - (x + maxX()) - 1;
        }
        if(y + maxY() >= well[0].length){
            y += 21 - (y + maxY());
            shouldStop = true;
        }

        return shouldStop ;
    }

    public Tetramino(Block[][] well, BlockType type){
        if(!Tetraminos.init_done) Tetraminos.init();

        this.well = well;

        this.type = type;

        n = 0;
        value = Tetraminos.tetraminos[n][type.ordinal()];
    }
}
