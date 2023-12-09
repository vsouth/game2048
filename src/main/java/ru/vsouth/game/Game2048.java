package ru.vsouth.game;

import ru.vsouth.board.Board;
import ru.vsouth.board.SquareBoard;
import ru.vsouth.exception.NotEnoughSpace;
import ru.vsouth.util.Direction;
import ru.vsouth.util.GameHelper;
import ru.vsouth.util.Key;

import java.util.*;


public class Game2048 implements Game {

    public static final int GAME_SIZE = 4;
    private final Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);
    private final GameHelper helper = new GameHelper();
    private final Random random = new Random();


    @Override
    public void init() {
        var nullList = new ArrayList<Integer>();
        for (int i = 0; i < GAME_SIZE*GAME_SIZE; i++) {
            nullList.add(null);
        }
        board.fillBoard(nullList);
        try {
            addItem();
            addItem();
        } catch (NotEnoughSpace e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public boolean canMove() {
        if (board.availableSpace().isEmpty()) {
            for (var i = 0; i < GAME_SIZE; i++) {
                var row = board.getValues(board.getRow(i));
                var column = board.getValues(board.getColumn(i));
                for (var j = 1; j < GAME_SIZE; j++) {
                    if (row.get(j-1).equals(row.get(j)) || column.get(j-1).equals(column.get(j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }


    @Override
    public boolean move(Direction direction) {
        if (!canMove()) {
            return false;
        }
        String state = board.toString();
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
        try {
            if (!Objects.equals(state, board.toString())) {
                addItem();
            }
        } catch (NotEnoughSpace e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    private void makeShift(List<Key> keys) {
        var newValues = helper.moveAndMergeEqual(board.getValues(keys)).listIterator();
        for (var key : keys) {
            board.addItem(key, newValues.next());
        }
    }
    @Override
    public void addItem() throws NotEnoughSpace {
        var availableSpace = board.availableSpace();
        if (availableSpace.isEmpty()) {
            throw new NotEnoughSpace("No available space on the board");
        }

        var target = random.nextInt(availableSpace.size());
        var item = (random.nextInt(10) < 8) ? 2 : 4;
        board.addItem(availableSpace.get(target), item);
    }

    @Override
    public Board<Key, Integer> getGameBoard() {
        return board;
    }

    @Override
    public boolean hasWin() {
        return board.hasValue(2048);
    }
}
