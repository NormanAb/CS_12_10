package com.example.hl12_10;

import java.util.Collections;
import java.util.List;

public class AlgorithmLibrary {

    public void bubbleSort(List<String> arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j).compareTo(arr.get(j + 1)) > 0) {
                    // Swap arr[j] and arr[j+1]
                    Collections.swap(arr, j, j + 1);
                }
            }
        }
    }

    // Merge Sort Implementation
    public void mergeSort(List<String> arr) {
        if (arr.size() < 2) {
            return;
        }

        int mid = arr.size() / 2;
        List<String> left = arr.subList(0, mid);
        List<String> right = arr.subList(mid, arr.size());

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private void merge(List<String> arr, List<String> left, List<String> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                arr.set(k++, left.get(i++));
            } else {
                arr.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            arr.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            arr.set(k++, right.get(j++));
        }
    }

    // Quick Sort Implementation
    public void quickSort(List<String> arr) {
        quickSortHelper(arr, 0, arr.size() - 1);
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
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr.get(j).compareTo(pivot) <= 0) {
                i++;
                Collections.swap(arr, i, j);
            }
        }
        Collections.swap(arr, i + 1, high);
        return i + 1;
    }

    // Insertion Sort Implementation
    public void insertionSort(List<String> arr) {
        for (int i = 1; i < arr.size(); i++) {
            String key = arr.get(i);
            int j = i - 1;

            while (j >= 0 && arr.get(j).compareTo(key) > 0) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, key);
        }
    }

    // Selection Sort Implementation
    public void selectionSort(List<String> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j).compareTo(arr.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            Collections.swap(arr, i, minIndex);
        }
    }

    // Heap Sort Implementation
    public void heapSort(List<String> arr) {
        int n = arr.size();

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap
        for (int i = n - 1; i >= 0; i--) {
            Collections.swap(arr, 0, i);

            // Heapify root element
            heapify(arr, i, 0);
        }
    }

    private void heapify(List<String> arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr.get(left).compareTo(arr.get(largest)) > 0) {
            largest = left;
        }

        if (right < n && arr.get(right).compareTo(arr.get(largest)) > 0) {
            largest = right;
        }

        if (largest != i) {
            Collections.swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
}