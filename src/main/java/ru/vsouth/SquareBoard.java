package main.java.ru.vsouth;
import java.util.*;

public class SquareBoard extends Board{
    private int size;

    SquareBoard(int size) {
        super(size, size);
        this.size = size;
    }

    @Override
    void fillBoard(List<Integer> list) {
        Iterator<Integer> listIt = list.listIterator();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Integer value = listIt.next();
                Key key = new Key(i, j);
                addItem(key, value);
            }
        }
    }

    @Override
    List<Key> availableSpace() {
        var availableSpace = new ArrayList<Key>();
        var keyIt = board.entrySet().iterator();
        while (keyIt.hasNext()) {
            var pair = keyIt.next();
            if (pair.getValue() == null) {
                availableSpace.add(pair.getKey());
            }
        }
        return availableSpace;
    }

    @Override
    void addItem(Key key, Integer value) {
        board.put(key, value);
    }

    @Override
    Key getKey(int i, int j) {
        /*
        var key = new main.java.ru.vsouth.Key(i,j);
        return board.containsKey(key) ? key : null;
         */
        var key = new Key(i,j);
        var keys = board.keySet();
        for (Key existingKey : keys) {
            if (key.equals(existingKey)) {
                return existingKey;
            }
        }
        return null;
    }

    @Override
    Integer getValue(Key key) {
        return board.get(key);
    }

    @Override
    List<Key> getColumn(int j) {
        List<Key> keys = new ArrayList<>();
        for (var i = 0; i < size; i++) {
            keys.add(getKey(i,j));
        }
        return keys;
    }

    @Override
    List<Key> getRow(int i) {
        List<Key> keys = new ArrayList<>();
        for (var j = 0; j < size; j++) {
            keys.add(getKey(i,j));
        }
        return keys;
    }

    @Override
    boolean hasValue(Integer value) {
        return board.containsValue(value);
    }

    @Override
    List<Integer> getValues(List<Key> keys) {
        List<Integer> values = new ArrayList<>();
        for (Key key : keys) {
            values.add(getValue(key));
        }
        return values;
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Key key : board.keySet()) {
            str.append("key: ").append(key.toString()).append(" value: ").append(board.get(key)).append("\n");
        }
        return str.toString();
    }
}
