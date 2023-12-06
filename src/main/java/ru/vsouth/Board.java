package main.java.ru.vsouth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Board<K, V> {
    private int width;
    private int height;
    protected Map<K, V> board = new HashMap<>();
    Board(int width, int height) {
        this.width = width;
        this.height = height;
    }
    abstract void fillBoard(List<V> list);
    abstract List<K> availableSpace();
    abstract void addItem(K key, V value);
    abstract K getKey(int i, int j);
    abstract V getValue(K key);
    abstract List<K> getColumn(int j);
    abstract List<K> getRow(int i);
    abstract  boolean hasValue(V value);
    abstract List<V> getValues(List<K> keys);
}
