package com.lc.game.mino;

import com.lc.texture.Texture;

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
        I = Texture.loadTexture("res/block/I.png");
        O = Texture.loadTexture("res/block/O.png");
        T = Texture.loadTexture("res/block/T.png");
        S = Texture.loadTexture("res/block/S.png");
        Z = Texture.loadTexture("res/block/Z.png");
        J = Texture.loadTexture("res/block/J.png");
        L = Texture.loadTexture("res/block/L.png");
        init_done = true;
    }
}
