package com.lc.game.tetramino;

import com.lc.game.mino.Block;
import com.lc.game.mino.BlockType;
import com.lc.game.mino.Blocks;

public class Tetramino {
    private BlockType type;
    private Block[][] value;
    private int n;

    private Block[][] well;

    private int[][][] rightWallKickData = {
            { { 0, 0 }, { -1, 0 }, { -1, +1 }, { 0, -2 }, { -1, -2 } },
            { { 0, 0 }, { +1, 0 }, { +1, -1 }, { 0, +2 }, { +1, +2 } },
            { { 0, 0 }, { +1, 0 }, { +1, +1 }, { 0, -2 }, { +1, -2 } },
            { { 0, 0 }, { -1, 0 }, { -1, -1 }, { 0, +2 }, { -1, +2 } } };
    private int[][][] leftWallKickData = {
            { { 0, 0 }, { +1, 0 }, { +1, +1 }, { 0, -2 }, { +1, -2 } },
            { { 0, 0 }, { +1, 0 }, { +1, -1 }, { 0, +2 }, { +1, +2 } },
            { { 0, 0 }, { -1, 0 }, { -1, +1 }, { 0, -2 }, { -1, -2 } },
            { { 0, 0 }, { -1, 0 }, { -1, -1 }, { 0, +2 }, { -1, +2 } } };

    private final static int[][][] rightWallKickDataI = {
            { { 0, 0 }, { -2, 0 }, { +1, 0 }, { -2, -1 }, { +1, +2 } },
            { { 0, 0 }, { -1, 0 }, { +2, 0 }, { -1, +2 }, { +2, -1 } },
            { { 0, 0 }, { +2, 0 }, { -1, 0 }, { +2, +1 }, { -1, -2 } },
            { { 0, 0 }, { +1, 0 }, { -2, 0 }, { +1, -2 }, { -2, +1 } } };

    private final static int[][][] leftWallKickDataI = {
            { { 0, 0 }, { -1, 0 }, { +2, 0 }, { -1, +2 }, { +2, -1 } },
            { { 0, 0 }, { +2, 0 }, { -1, 0 }, { +2, +1 }, { -1, -2 } },
            { { 0, 0 }, { +1, 0 }, { -2, 0 }, { +1, -2 }, { -2, +1 } },
            { { 0, 0 }, { -2, 0 }, { +1, 0 }, { -2, -1 }, { +1, +2 } } };

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

    private int minY(){
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
        if(checkCollision()){
            int wallKickData[][][];
            if(type == BlockType.I)
                wallKickData = rightWallKickDataI;
            else
                wallKickData = rightWallKickData;

            if(!wallKickTest(wallKickData))
                rotateLeft();
        }
    }

    public void rotateLeft(){
        n = (n+4-1)%4;
        value = Tetraminos.tetraminos[n%4][type.ordinal()];
        if(checkCollision()){
            int wallKickData[][][];
            if(type == BlockType.I)
                wallKickData = leftWallKickDataI;
            else
                wallKickData = leftWallKickData;

            if(!wallKickTest(wallKickData))
                rotateRight();
        }
    }

    private boolean wallKickTest(int[][][] wallKickData) {
        boolean success = false;
        for(int i = 0; i < 5; i++){
            x += wallKickData[(n+4-1)%4][i][0];
            y += wallKickData[(n+4-1)%4][i][1];

            if(!checkCollision()){
                success = true;
                break;
            }
        }
        return success;
    }

    public void moveRight(){
        x++;
        shouldStop(1, 0);
    }

    public void moveLeft(){
        x--;
        shouldStop(-1, 0);
    }

    public boolean moveDown(){
        y++;

        boolean shouldStop = shouldStop(0, 1);

        if(shouldStop){
            for(int i = minX(); i <= maxX(); i++)
                for(int j = minY(); j <= maxY(); j++){
                    if(value[i][j] != Blocks.E)
                        well[x + i][y + j] = value[i][j];
                }
        }

        return shouldStop;
    }

    private boolean checkCollision(){
        if(x + minX() < 0){
            return true;
        }
        if(x + maxX() >= well.length){
            return true;
        }
        if(y + maxY() >= well[0].length){
            return true;
        }

        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                if(value[i][j] != Blocks.E && (well[x + i][y + j] != Blocks.E))
                    return true;

        return false;
    }

    private boolean shouldStop(float dx, float dy){
        boolean shouldStop = false;

        if(x + minX() < 0){
            x -= x + minX();
        }
        if(x + maxX() >= well.length){
            x += 10 - (x + maxX()) - 1;
        }
        if(y + maxY() >= well[0].length){
            y--;
            shouldStop = true;
        }

        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                if(value[i][j] != Blocks.E && (well[x + i][y + j] != Blocks.E)) {
                    if(dy > 0){
                        y--;
                        shouldStop = true;
                    }
                    if(dx != 0)
                        x -= dx;
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
