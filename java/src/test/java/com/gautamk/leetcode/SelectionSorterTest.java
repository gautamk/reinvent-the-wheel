package com.gautamk.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSorterTest {
    private SelectionSorter sorter;

    @BeforeEach
    void setUp() {
        this.sorter = new SelectionSorter();
    }

    @Test
    void testSortingSimple() {
        List<Integer> unsorted = Arrays.asList(3, 2, 1);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> actual = sorter.sort(unsorted);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void testSortingDuplicates() {
        List<Integer> unsorted = Arrays.asList(3, 7, 3, 2, 1);
        List<Integer> expected = new ArrayList<>(unsorted);
        Collections.sort(expected);
        List<Integer> actual = sorter.sort(unsorted);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void testFindSmallestValueLargerThan() {
        List<Integer> unsorted = Arrays.asList(5, 9, 7, 4, 1);
        int actual = this.sorter.findSmallestValueLargerThan(5, unsorted);
        assertEquals(2, actual);
    }

    @Test
    void testFindSmallestValueLargerThanEmptyInput() {
        List<Integer> unsorted = new ArrayList<>();
        assertThrows(IllegalArgumentException.class,
                () -> this.sorter.findSmallestValueLargerThan(5, unsorted));
    }

    @Test
    void testFindSmallestValueLargerThanNotAvailable() {
        List<Integer> unsorted = Arrays.asList(5, 9, 7, 4, 1);
        int actual = this.sorter.findSmallestValueLargerThan(9, unsorted);
        assertEquals(-1, actual);
    }
}