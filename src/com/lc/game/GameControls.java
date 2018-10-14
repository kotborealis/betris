package com.lc.game;

import org.lwjgl.glfw.GLFW;

import static org.lwjgl.glfw.GLFW.*;

class GameControls {
    int moveLR = 0;
    int moveDown = 0;
    int rotateRight = 0;
    int rotateLeft = 0;
    private Game game;

    GameControls(Game game) {
        this.game = game;
    }

    void handleKey(int key, int action) {
        if (action == GLFW_PRESS || action == GLFW_REPEAT) {
            if (key == GLFW.GLFW_KEY_LEFT) moveLR--;
            if (key == GLFW_KEY_RIGHT) moveLR++;
            if (key == GLFW_KEY_DOWN) moveDown++;
            if (key == GLFW_KEY_SPACE) moveDown += 24;
            if (key == GLFW_KEY_Z) rotateLeft++;
            if (key == GLFW_KEY_X || key == GLFW_KEY_UP) rotateRight++;
            if (key == GLFW_KEY_C) {
                game.bag.stash();
            }
        }
    }
}
