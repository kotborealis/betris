package com.lc.game.mino;

import com.lc.Texture;

class BlockTextures {
    static Texture I;
    static Texture O;
    static Texture T;
    static Texture S;
    static Texture Z;
    static Texture J;
    static Texture L;
    private static boolean init_done = false;

    static void init() {
        if (init_done) return;
        I = new Texture("res/block/I.png");
        O = new Texture("res/block/O.png");
        T = new Texture("res/block/T.png");
        S = new Texture("res/block/S.png");
        Z = new Texture("res/block/Z.png");
        J = new Texture("res/block/J.png");
        L = new Texture("res/block/L.png");
        init_done = true;
    }
}
