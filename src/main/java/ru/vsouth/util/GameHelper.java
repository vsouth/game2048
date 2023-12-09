package ru.vsouth.util;

import java.util.List;

public class GameHelper {

    public List<Integer> moveAndMergeEqual(List<Integer> list) {
        var leftIndex = 0;
        var rightIndex = 1;
        while (rightIndex < list.size()) {
            var leftValue = list.get(leftIndex);
            var rightValue = list.get(rightIndex);
            if ((leftIndex == rightIndex) || (rightValue == null)) {
                rightIndex++;
            } else if (leftValue == null) {
                list.set(leftIndex, rightValue);
                list.set(rightIndex, null);
            } else if (leftValue.equals(rightValue)) {
                list.set(leftIndex, leftValue * 2);
                list.set(rightIndex, null);
                leftIndex++;
            } else {
                leftIndex++;
            }
        }
        return list;
    }
}
