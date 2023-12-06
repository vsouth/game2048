package main.java.ru.vsouth;

import java.util.List;

public class GameHelper {
    public List<Integer> moveAndMergeEqual(List<Integer> list) {
        var firstPointerIndex = 0;
        var secondPointerIndex = 1;
        while (secondPointerIndex < list.size()) {
            var firstPointerValue = list.get(firstPointerIndex);
            var secondPointerValue = list.get(secondPointerIndex);
            if (firstPointerIndex == secondPointerIndex) {
                secondPointerIndex++;
            } else if (secondPointerValue == null) {
                secondPointerIndex++;
            } else if (firstPointerValue == null) {
                list.set(firstPointerIndex, secondPointerValue);
                list.set(secondPointerIndex, null);
            } else if (firstPointerValue.equals(secondPointerValue)) {
                list.set(firstPointerIndex, firstPointerValue * 2);
                list.set(secondPointerIndex, null);
                firstPointerIndex++;
            } else {
                firstPointerIndex++;
            }
        }
    return list;
    }
}
