package com.lc.game.tetramino;

import com.lc.game.mino.Block;
import com.lc.game.mino.BlockType;
import com.lc.game.mino.Blocks;

class Tetraminos {
    static Block tetraminos[][][][];
    static boolean init_done = false;
    private static Block tetraminos0[][][] = new Block[8][4][4];
    private static Block tetraminos1[][][] = new Block[8][4][4];
    private static Block tetraminos2[][][] = new Block[8][4][4];
    private static Block tetraminos3[][][] = new Block[8][4][4];

    static void init() {
        init_done = true;

        Block e = Blocks.E;
        Block o = Blocks.O;
        Block i = Blocks.I;
        Block j = Blocks.J;
        Block t = Blocks.T;
        Block l = Blocks.L;
        Block s = Blocks.S;
        Block z = Blocks.Z;

        tetraminos0[BlockType.I.ordinal()] = new Block[][]{
                {e, e, e, e},
                {i, i, i, i},
                {e, e, e, e},
                {e, e, e, e}
        };
        tetraminos1[BlockType.I.ordinal()] = new Block[][]{
                {e, e, i, e},
                {e, e, i, e},
                {e, e, i, e},
                {e, e, i, e}
        };
        tetraminos2[BlockType.I.ordinal()] = new Block[][]{
                {e, e, e, e},
                {e, e, e, e},
                {i, i, i, i},
                {e, e, e, e}
        };
        tetraminos3[BlockType.I.ordinal()] = new Block[][]{
                {e, i, e, e},
                {e, i, e, e},
                {e, i, e, e},
                {e, i, e, e}
        };

        tetraminos0[BlockType.O.ordinal()] = new Block[][]{
                {e, o, o, e},
                {e, o, o, e},
                {e, e, e, e},
                {e, e, e, e}
        };
        tetraminos1[BlockType.O.ordinal()] = new Block[][]{
                {e, o, o, e},
                {e, o, o, e},
                {e, e, e, e},
                {e, e, e, e}
        };
        tetraminos2[BlockType.O.ordinal()] = new Block[][]{
                {e, o, o, e},
                {e, o, o, e},
                {e, e, e, e},
                {e, e, e, e}
        };
        tetraminos3[BlockType.O.ordinal()] = new Block[][]{
                {e, o, o, e},
                {e, o, o, e},
                {e, e, e, e},
                {e, e, e, e}
        };

        tetraminos0[BlockType.T.ordinal()] = new Block[][]{
                {e, t, e, e},
                {t, t, t, e},
                {e, e, e, e},
                {e, e, e, e}
        };
        tetraminos1[BlockType.T.ordinal()] = new Block[][]{
                {e, t, e, e},
                {e, t, t, e},
                {e, t, e, e},
                {e, e, e, e}
        };
        tetraminos2[BlockType.T.ordinal()] = new Block[][]{
                {e, e, e, e},
                {t, t, t, e},
                {e, t, e, e},
                {e, e, e, e}
        };
        tetraminos3[BlockType.T.ordinal()] = new Block[][]{
                {e, t, e, e},
                {t, t, e, e},
                {e, t, e, e},
                {e, e, e, e}
        };

        tetraminos0[BlockType.S.ordinal()] = new Block[][]{
                {e, s, s, e},
                {s, s, e, e},
                {e, e, e, e},
                {e, e, e, e}
        };
        tetraminos1[BlockType.S.ordinal()] = new Block[][]{
                {e, s, e, e},
                {e, s, s, e},
                {e, e, s, e},
                {e, e, e, e}
        };
        tetraminos2[BlockType.S.ordinal()] = new Block[][]{
                {e, e, e, e},
                {e, s, s, e},
                {s, s, e, e},
                {e, e, e, e}
        };
        tetraminos3[BlockType.S.ordinal()] = new Block[][]{
                {s, e, e, e},
                {s, s, e, e},
                {e, s, e, e},
                {e, e, e, e}
        };

        tetraminos0[BlockType.Z.ordinal()] = new Block[][]{
                {z, z, e, e},
                {e, z, z, e},
                {e, e, e, e},
                {e, e, e, e}
        };
        tetraminos1[BlockType.Z.ordinal()] = new Block[][]{
                {e, e, z, e},
                {e, z, z, e},
                {e, z, e, e},
                {e, e, e, e}
        };
        tetraminos2[BlockType.Z.ordinal()] = new Block[][]{
                {e, e, e, e},
                {z, z, e, e},
                {e, z, z, e},
                {e, e, e, e}
        };
        tetraminos3[BlockType.Z.ordinal()] = new Block[][]{
                {e, z, e, e},
                {z, z, e, e},
                {z, e, e, e},
                {e, e, e, e}
        };

        tetraminos0[BlockType.L.ordinal()] = new Block[][]{
                {e, e, l, e},
                {l, l, l, e},
                {e, e, e, e},
                {e, e, e, e}
        };
        tetraminos1[BlockType.L.ordinal()] = new Block[][]{
                {e, l, e, e},
                {e, l, e, e},
                {e, l, l, e},
                {e, e, e, e}
        };
        tetraminos2[BlockType.L.ordinal()] = new Block[][]{
                {e, e, e, e},
                {l, l, l, e},
                {l, e, e, e},
                {e, e, e, e}
        };
        tetraminos3[BlockType.L.ordinal()] = new Block[][]{
                {l, l, e, e},
                {e, l, e, e},
                {e, l, e, e},
                {e, e, e, e}
        };

        tetraminos0[BlockType.J.ordinal()] = new Block[][]{
                {j, e, e, e},
                {j, j, j, e},
                {e, e, e, e},
                {e, e, e, e}
        };
        tetraminos1[BlockType.J.ordinal()] = new Block[][]{
                {e, j, j, e},
                {e, j, e, e},
                {e, j, e, e},
                {e, e, e, e}
        };
        tetraminos2[BlockType.J.ordinal()] = new Block[][]{
                {e, e, e, e},
                {j, j, j, e},
                {e, e, j, e},
                {e, e, e, e}
        };
        tetraminos3[BlockType.J.ordinal()] = new Block[][]{
                {e, j, e, e},
                {e, j, e, e},
                {j, j, e, e},
                {e, e, e, e}
        };

        tetraminos = new Block[][][][]{tetraminos0, tetraminos1, tetraminos2, tetraminos3};
    }
}
