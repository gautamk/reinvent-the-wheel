package com.gautamk.leetcode;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;


public class SelectionSorter implements OutOfPlaceSorter {


    /**
     * Find index of the smallest value which is larger than the given parameter
     *
     * @param largerThan the min value
     * @param unsorted   the list of unsorted elements
     * @return indexOf the smallest value
     */
    int findSmallestValueLargerThan(int largerThan, List<Integer> unsorted) {
        Preconditions.checkNotNull(unsorted);
        Preconditions.checkArgument(unsorted.size() > 0);
        int smallestIndex = -1;
        int smallestValue = Integer.MAX_VALUE;

        for (int i = 0; i < unsorted.size(); i++) {
            int current = unsorted.get(i);
            if (current > largerThan && current < smallestValue) {
                smallestValue = current;
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }


    int countDuplicates(int duplicateOf, List<Integer> unsorted) {
        int duplicateCount = 0;
        for (int current : unsorted) {
            if (current == duplicateOf) {
                duplicateCount += 1;
            }
        }
        return duplicateCount;
    }

    @Override
    public List<Integer> sort(List<Integer> unsorted) {
        List<Integer> result = new ArrayList<>(unsorted.size());
        int smallestValue = Integer.MIN_VALUE;
        do {
            int smallestIndex = findSmallestValueLargerThan(smallestValue, unsorted);
            if (smallestIndex == -1) {
                int duplicates = countDuplicates(smallestValue, unsorted);
                for (int i = 0; i < duplicates - 1; i++) {
                    result.add(smallestValue);
                }
            } else {
                smallestValue = unsorted.get(smallestIndex);
                result.add(smallestValue);
            }

        } while (result.size() < unsorted.size());
        return result;
    }
}
