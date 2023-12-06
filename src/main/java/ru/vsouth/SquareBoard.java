package main.java.ru.vsouth;
import java.util.*;

public class SquareBoard<V> extends Board<Key, V>{
    private int size;

    SquareBoard(int size) {
        super(size, size);
        this.size = size;
    }

    @Override
    void fillBoard(List<V> list) {
        Iterator<V> listIt = list.listIterator();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                V value = listIt.next();
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
    void addItem(Key key, V value) {
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
    V getValue(Key key) {
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
    boolean hasValue(V value) {
        return board.containsValue(value);
    }

    @Override
    List<V> getValues(List<Key> keys) {
        List<V> values = new ArrayList<>();
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
