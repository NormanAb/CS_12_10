package com.example.hl12_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlgorithmLibrary {

    public List<String> bubbleSort(List<String> arr) {
        List<String> sortedArr = new ArrayList<>(arr); // Create a copy to sort
        int n = sortedArr.size();
        System.out.println("Initial input: " + sortedArr);  // Print the initial input

        for (int i = 0; i < n - 1; i++) {
            System.out.println("Iteration " + (i + 1) + " - Start: " + sortedArr);  // Print list before this iteration

            for (int j = 0; j < n - i - 1; j++) {
                // Print out the current pair being compared
                System.out.println("Comparing: " + sortedArr.get(j) + " and " + sortedArr.get(j + 1));

                // Parse both strings to integers
                int num1 = Integer.parseInt(sortedArr.get(j).trim());
                int num2 = Integer.parseInt(sortedArr.get(j + 1).trim());

                System.out.println("Parsed values: " + num1 + " and " + num2);  // Debugging parsed values

                // If the current element is greater than the next, swap them
                if (num1 > num2) {
                    System.out.println("Swapping: " + sortedArr.get(j) + " and " + sortedArr.get(j + 1));
                    Collections.swap(sortedArr, j, j + 1);
                }
            }
            System.out.println("Iteration " + (i + 1) + " - End: " + sortedArr);  // Print list after this iteration
        }

        System.out.println("Sorted result: " + sortedArr);  // Print sorted list
        return sortedArr;
    }



    public List<String> mergeSort(List<String> arr) {
        if (arr.size() < 2) return new ArrayList<>(arr); // Return a copy of the single-element array

        int mid = arr.size() / 2;
        List<String> left = mergeSort(new ArrayList<>(arr.subList(0, mid)));
        List<String> right = mergeSort(new ArrayList<>(arr.subList(mid, arr.size())));

        return merge(left, right);
    }

    private List<String> merge(List<String> left, List<String> right) {
        List<String> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }
        while (i < left.size()) merged.add(left.get(i++));
        while (j < right.size()) merged.add(right.get(j++));

        return merged;
    }

    public List<String> quickSort(List<String> arr) {
        List<String> sortedArr = new ArrayList<>(arr);
        quickSortHelper(sortedArr, 0, sortedArr.size() - 1);
        return sortedArr;
    }

    private void quickSortHelper(List<String> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }

    private int partition(List<String> arr, int low, int high) {
        String pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j).compareTo(pivot) <= 0) {
                i++;
                Collections.swap(arr, i, j);
            }
        }
        Collections.swap(arr, i + 1, high);
        return i + 1;
    }

    public List<String> insertionSort(List<String> arr) {
        List<String> sortedArr = new ArrayList<>(arr);
        for (int i = 1; i < sortedArr.size(); i++) {
            String key = sortedArr.get(i);
            int j = i - 1;
            while (j >= 0 && sortedArr.get(j).compareTo(key) > 0) {
                sortedArr.set(j + 1, sortedArr.get(j));
                j--;
            }
            sortedArr.set(j + 1, key);
        }
        return sortedArr;
    }

    public List<String> selectionSort(List<String> arr) {
        List<String> sortedArr = new ArrayList<>(arr);
        for (int i = 0; i < sortedArr.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortedArr.size(); j++) {
                if (sortedArr.get(j).compareTo(sortedArr.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Collections.swap(sortedArr, i, minIndex);
        }
        return sortedArr;
    }

    public List<String> heapSort(List<String> arr) {
        List<String> sortedArr = new ArrayList<>(arr);
        int n = sortedArr.size();

        for (int i = n / 2 - 1; i >= 0; i--) heapify(sortedArr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            Collections.swap(sortedArr, 0, i);
            heapify(sortedArr, i, 0);
        }
        return sortedArr;
    }

    private void heapify(List<String> arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr.get(left).compareTo(arr.get(largest)) > 0) largest = left;
        if (right < n && arr.get(right).compareTo(arr.get(largest)) > 0) largest = right;

        if (largest != i) {
            Collections.swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
}
