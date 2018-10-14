package com.lc.game;

import com.lc.game.mino.Block;
import com.lc.game.mino.BlockType;
import com.lc.game.tetramino.Tetramino;

import java.util.ArrayList;
import java.util.Collections;

class TetraminoBag {
    Tetramino current;
    BlockType stash = null;
    private boolean stashedOnThisTurn = false;
    private ArrayList<BlockType> bag;
    private Block well[][];

    TetraminoBag(Block[][] well) {
        bag = new ArrayList<>();
        this.well = well;
    }

    int size() {
        return bag.size();
    }

    BlockType get(int i) {
        return bag.get(i);
    }


    void stash() {
        if (stashedOnThisTurn) return;
        stashedOnThisTurn = true;

        if (stash == null) {
            stash = current.type;
            spawnTetramino();
        } else {
            BlockType type = current.type;
            spawnTetramino(stash);
            stash = type;
        }
    }

    void spawnTetramino() {
        stashedOnThisTurn = false;

        if (bag.size() <= 7) {
            ArrayList<BlockType> new_bag = new ArrayList<BlockType>() {{
                add(BlockType.I);
                add(BlockType.O);
                add(BlockType.T);
                add(BlockType.S);
                add(BlockType.Z);
                add(BlockType.J);
                add(BlockType.L);
            }};
            Collections.shuffle(new_bag);
            bag.addAll(new_bag);
        }
        BlockType type = bag.get(0);
        bag.remove(0);
        current = new Tetramino(well, type);
    }

    private void spawnTetramino(BlockType type) {
        current = new Tetramino(well, type);
    }


}
