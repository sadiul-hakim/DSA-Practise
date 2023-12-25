package com.hakim.javase.sorting;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] arr) {
        sort(arr, new int[arr.length], 0, arr.length - 1);
    }
    private void sort(int[] arr, int[] temp, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            sort(arr, temp, low, mid);
            sort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    // In the merge method we merge two sorted array (two sorted part of an array).
    private void merge(int[] arr, int[] temp, int low, int mid, int high) {

        // Copy arr into temp
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }

        // First index of firs array (sorted part). 'i' is used to traverse first sorted array.
        int i = low;

        // First index of second array (sorted part). 'j' is used to traverse second sorted array.
        int j = mid + 1;

        // First index of the array. 'k' is used to set sorted values in the array.
        int k = low;

        // Traverse two arrays (sorted parts) and marge them (and sort them while merging)
        // This is ascending sorting (small comes first)
        while (i <= mid && j <= high) {

            // Small element comes first
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }

            k++;
        }

        // Add left items of the first array (sorted part)
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }

        // Add left items of the second array (sorted part)
        while (j <= high) {
            arr[k] = temp[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {

        int[] arr = {5, 7, 1, 2, 9, 4, 3, 8, 12, 56, 23, 78, 32, 34, 21};

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
