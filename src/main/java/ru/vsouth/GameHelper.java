package main.java.ru.vsouth;

import java.util.List;

public class GameHelper {

    public List<Integer> moveAndMergeEqual(List<Integer> list) {
        var leftPointerIndex = 0;
        var rightPointerIndex = 1;
        while (rightPointerIndex < list.size()) {
            var leftPointerValue = list.get(leftPointerIndex);
            var rightPointerValue = list.get(rightPointerIndex);
            if ((leftPointerIndex == rightPointerIndex) || (rightPointerValue == null)) {
                rightPointerIndex++;
            } else if (leftPointerValue == null) {
                list.set(leftPointerIndex, rightPointerValue);
                list.set(rightPointerIndex, null);
            } else if (leftPointerValue.equals(rightPointerValue)) {
                list.set(leftPointerIndex, leftPointerValue * 2);
                list.set(rightPointerIndex, null);
                leftPointerIndex++;
            } else {
                leftPointerIndex++;
            }
        }
        return list;
    }
}
