package com.hakim.javase.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Hakim
 */
public class MagicSqare {

    public static void main(String[] args) {
        List<List<Integer>> s = new ArrayList<>();
        s.add(List.of(4, 8, 2));
        s.add(List.of(4, 5, 7));
        s.add(List.of(6, 1, 6));

        formingMagicSquare(s);

    }

    public static int formingMagicSquare(List<List<Integer>> s) {
        List<Integer> input = s.stream()
                .flatMap(e -> e.stream())
                .collect(Collectors.toList());

        // cost, location, index
        final int[] holders = new int[]{Integer.MAX_VALUE, -1, -1};

        Integer solution[][]
                = {
                    {4, 9, 2, 3, 5, 7, 8, 1, 6},
                    {4, 3, 8, 9, 5, 1, 2, 7, 6},
                    {2, 9, 4, 7, 5, 3, 6, 1, 8},
                    {2, 7, 6, 9, 5, 1, 4, 3, 8},
                    {8, 1, 6, 3, 5, 7, 4, 9, 2},
                    {8, 3, 4, 1, 5, 9, 6, 7, 2},
                    {6, 7, 2, 1, 5, 9, 8, 3, 4},
                    {6, 1, 8, 7, 5, 3, 2, 9, 4}
                };

        Arrays.stream(solution).forEach(arr -> {

            // map to cost
            int cost = 0;
            holders[2] = holders[2] + 1;
            for (int i = 0; i < arr.length; i++) {
                cost = cost + Math.abs(arr[i] - input.get(i));
            }

            if (cost < holders[0]) {
                holders[0] = cost;
                holders[1] = holders[2];
            }

        });

        return holders[0];
    }
}
