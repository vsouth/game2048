package ru.vsouth.test;

import ru.vsouth.game.Game;
import ru.vsouth.game.Game2048;

public class TestClass {
    public static void main(String[] args) {
        Game game2048 = new Game2048();
        game2048.init();
        System.out.println(game2048.getGameBoard());
        System.out.println(game2048.canMove());
        System.out.println();
    }
}

