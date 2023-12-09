package main.java.ru.vsouth.game;

import main.java.ru.vsouth.util.Direction;
import main.java.ru.vsouth.board.Board;

public interface Game {
    void init();
    boolean canMove();
    boolean move(Direction direction);
    void addItem();
    Board getGameBoard();
    boolean hasWin();
}
