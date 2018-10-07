package com.lc.game.tetramino;

import com.lc.game.mino.Block;
import com.lc.game.mino.BlockType;
import com.lc.game.mino.Blocks;

public class Tetraminos {
    public static Tetramino I = new Tetramino();
    public static Tetramino O = new Tetramino();
    public static Tetramino T = new Tetramino();
    public static Tetramino S = new Tetramino();
    public static Tetramino Z = new Tetramino();
    public static Tetramino L = new Tetramino();
    public static Tetramino J = new Tetramino();

    public static void init(){
        I.value = new Block[][]{
                {Blocks.I, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.I, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.I, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.I, Blocks.Empty, Blocks.Empty, Blocks.Empty}
        };

        O.value = new Block[][]{
                {Blocks.O,     Blocks.O,     Blocks.Empty, Blocks.Empty},
                {Blocks.O,     Blocks.O,     Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty}
        };

        T.value = new Block[][]{
                {Blocks.Empty, Blocks.T,     Blocks.Empty, Blocks.Empty},
                {Blocks.T,     Blocks.T,     Blocks.T,     Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty}
        };

        S.value = new Block[][]{
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.S,     Blocks.S,     Blocks.Empty},
                {Blocks.S,     Blocks.S,     Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty}
        };

        Z.value = new Block[][]{
                {Blocks.Z,     Blocks.Z,     Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.Z,     Blocks.Z,     Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty}
        };

        L.value = new Block[][]{
                {Blocks.L,     Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.L,     Blocks.L,     Blocks.L,     Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty}
        };

        J.value = new Block[][]{
                {Blocks.J,     Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.J,     Blocks.J,     Blocks.J,     Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty},
                {Blocks.Empty, Blocks.Empty, Blocks.Empty, Blocks.Empty}
        };
    }
}
