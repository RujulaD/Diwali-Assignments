package com.demo.sort;

public class QuickSortStrings {

    // Partition function
    private static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];  // choose last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Compare lexicographically
            if (arr[j].compareToIgnoreCase(pivot) <= 0) {
                i++;
                // swap arr[i] and arr[j]
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in correct position
        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Recursive QuickSort
    private static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            // Recursively sort left and right subarrays
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

   
    public static void sortStrings(String[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }
}
