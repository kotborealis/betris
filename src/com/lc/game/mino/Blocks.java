package com.lc.game.mino;

import com.lc.game.mino.BlockType;

public class Blocks {
    public static Block I = new Block(BlockType.I, false);
    public static Block O = new Block(BlockType.O, false);
    public static Block T = new Block(BlockType.T, false);
    public static Block S = new Block(BlockType.S, false);
    public static Block Z = new Block(BlockType.Z, false);
    public static Block J = new Block(BlockType.J, false);
    public static Block L = new Block(BlockType.L, false);

    public static Block I_shadow = new Block(BlockType.I, true);
    public static Block O_shadow = new Block(BlockType.O, true);
    public static Block T_shadow = new Block(BlockType.T, true);
    public static Block S_shadow = new Block(BlockType.S, true);
    public static Block Z_shadow = new Block(BlockType.Z, true);
    public static Block J_shadow = new Block(BlockType.J, true);
    public static Block L_shadow = new Block(BlockType.L, true);
}
