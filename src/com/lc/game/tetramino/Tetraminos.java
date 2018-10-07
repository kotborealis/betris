package com.lc.game.tetramino;

import com.lc.game.mino.Block;
import com.lc.game.mino.BlockType;
import com.lc.game.mino.Blocks;

public class Tetraminos {
    static Block tetraminos[][][] = new Block[8][4][4];
    static boolean init_done = false;

    public static void init(){
        init_done = true;
        tetraminos[BlockType.I.ordinal()] = new Block[][]{
                {Blocks.I, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.I, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.I, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.I, Blocks.Empty, Blocks.Empty, Blocks.Empty}
        };

        tetraminos[BlockType.O.ordinal()] = new Block[][]{
                {Blocks.O,     Blocks.O,     Blocks.Empty, Blocks.Empty},
                {Blocks.O,     Blocks.O,     Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty}
        };

        tetraminos[BlockType.T.ordinal()] = new Block[][]{
                {Blocks.Empty, Blocks.T,     Blocks.Empty, Blocks.Empty},
                {Blocks.T,     Blocks.T,     Blocks.T,     Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty}
        };

        tetraminos[BlockType.S.ordinal()] = new Block[][]{
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.S,     Blocks.S,     Blocks.Empty},
                {Blocks.S,     Blocks.S,     Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty}
        };

        tetraminos[BlockType.Z.ordinal()] = new Block[][]{
                {Blocks.Z,     Blocks.Z,     Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.Z,     Blocks.Z,     Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty}
        };

        tetraminos[BlockType.L.ordinal()] = new Block[][]{
                {Blocks.L,     Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.L,     Blocks.L,     Blocks.L,     Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty}
        };

        tetraminos[BlockType.J.ordinal()] = new Block[][]{
                {Blocks.J,     Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.J,     Blocks.J,     Blocks.J,     Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty}
        };
    }
}
