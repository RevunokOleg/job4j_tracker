package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        List<String> splitLeft = Arrays.asList(left.split("/"));
        List<String> splitRight = Arrays.asList(right.split("/"));
        if (splitRight.get(0).compareTo(splitLeft.get(0)) == 0) {
            int strLength = Math.min(splitLeft.size(), splitRight.size());
            for (int i = 1; i < strLength; i++) {
                int result = splitLeft.get(i).compareTo(splitRight.get(i));
                if (result != 0) {
                    return result;
                }
            }
            return Integer.compare(splitLeft.size(), splitRight.size());
        }
        return right.compareTo(left);
    }
}