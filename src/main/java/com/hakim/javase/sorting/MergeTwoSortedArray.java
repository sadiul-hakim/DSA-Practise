package com.hakim.javase.sorting;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9, 10, 11, 12};
        int[] arr2 = {2, 4, 6, 8, 15, 17, 19};

        System.out.println(Arrays.toString(merge(arr1, arr2)));
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int n = 0;
        int m = 0;
        int k = 0;

        while (n < arr1.length && m < arr2.length) {
            if (arr1[n] < arr2[m]) {
                result[k] = arr1[n];
                n++;
            } else {
                result[k] = arr2[m];
                m++;
            }

            k++;
        }

        while (n < arr1.length) {
            result[k] = arr1[n];
            n++;
            k++;
        }

        while (m < arr2.length) {
            result[k] = arr2[m];
            m++;
            k++;
        }

        return result;
    }
}
