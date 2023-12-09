package ru.vsouth.game;

import ru.vsouth.exception.NotEnoughSpace;
import ru.vsouth.util.Direction;
import ru.vsouth.board.Board;

public interface Game {
    void init();
    boolean canMove();
    boolean move(Direction direction);
    void addItem() throws NotEnoughSpace;
    Board getGameBoard();
    boolean hasWin();
}
