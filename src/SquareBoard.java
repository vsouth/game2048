import java.util.List;

public class SquareBoard extends Board{

    public SquareBoard(int size) {
        super(size, size);
    }

    @Override
    void fillBoard(List<Integer> list) {

    }

    @Override
    List<Key> availableSpace() {
        return null;
    }

    @Override
    void addItem(Key key, Integer value) {

    }

    @Override
    Key getKey(int i, int j) {
        return null;
    }

    @Override
    Integer getValue(Key key) {
        return null;
    }

    @Override
    List<Key> getColumn(int j) {
        return null;
    }

    @Override
    List<Key> getRow(int i) {
        return null;
    }

    @Override
    boolean hasValue(Integer value) {
        return false;
    }

    @Override
    List<Integer> getValues(List<Key> keys) {
        return null;
    }
}
