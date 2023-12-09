package main.java.ru.vsouth.game;

import main.java.ru.vsouth.board.Board;
import main.java.ru.vsouth.board.SquareBoard;
import main.java.ru.vsouth.util.Direction;
import main.java.ru.vsouth.util.GameHelper;
import main.java.ru.vsouth.util.Key;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Game2048 implements Game {

    public static final int GAME_SIZE = 4;
    private Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);
    private GameHelper helper = new GameHelper();
    private Random random = new Random();


    @Override
    public void init() {
        var nullList = new ArrayList<Integer>();
        for (int i = 0; i < GAME_SIZE*GAME_SIZE; i++) {
            nullList.add(null);
        }
        board.fillBoard(nullList);
        addItem();
        addItem();
    }

    @Override
    public boolean canMove() {
        return !board.availableSpace().isEmpty();
        // Добавить проверку на наличие повторяющихся элементов
    }

    @Override
    public boolean move(Direction direction) {
        if (!canMove()) {
            return false;
        }
        switch (direction) {
            case UP:
                for (int i = 0; i < GAME_SIZE; i++) {
                    var keys = board.getColumn(i);
                    makeShift(keys);
                }
                break;
            case DOWN:
                for (int i = 0; i < GAME_SIZE; i++) {
                    var keys = board.getColumn(i);
                    Collections.reverse(keys);
                    makeShift(keys);
                }
                break;
            case LEFT:
                for (int i = 0; i < GAME_SIZE; i++) {
                    var keys = board.getRow(i);
                    makeShift(keys);
                }
                break;
            case RIGHT:
                for (int i = 0; i < GAME_SIZE; i++) {
                    var keys = board.getRow(i);
                    Collections.reverse(keys);
                    makeShift(keys);
                }
                break;
        }
        addItem();
        return true;
    }
    private void makeShift(List<Key> keys) {
        var newValues = helper.moveAndMergeEqual(board.getValues(keys)).listIterator();
        for (var key : keys) {
            board.addItem(key, newValues.next());
        }
    }
    @Override
    public void addItem() {
        var availableSpace = board.availableSpace();
        if (!availableSpace.isEmpty()) {
            var target = random.nextInt(availableSpace.size()-1);
            var item = (random.nextInt(10) < 8) ? 2 : 4;
            board.addItem(availableSpace.get(target), item);
        }
    }

    @Override
    public Board getGameBoard() {
        return board;
    }

    @Override
    public boolean hasWin() {
        return board.hasValue(2048);
    }
}
