package com.greatlearning.assignment.algorithms.utils;

/**
 * @author rajatjain on - 28-12-2021
 * @project AlgorithmsAssignment
 */
public class MergeSort {

    public void mergeSort(double[] array, boolean ascending) {
        mergeSort(array, 0, array.length - 1, ascending);
    }

    public void mergeSort(double[] array, int left, int right, boolean ascending) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid, ascending);
            mergeSort(array, mid + 1, right, ascending);

            merge(array, left, mid, right, ascending);
        }
    }

    private void merge(double[] array, int left, int mid, int right, boolean ascending) {
        int leftArrayLen = mid - left + 1;
        int rightArrayLen = right - mid;

        double[] leftArray = new double[leftArrayLen];
        double[] rightArray = new double[rightArrayLen];

        for (int i = 0; i < leftArrayLen; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < rightArrayLen; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int arrayIndex = left;
        while (i < leftArrayLen && j < rightArrayLen) {
            if (ascending) {
                if (leftArray[i] <= rightArray[j]) {
                    array[arrayIndex] = leftArray[i];
                    i++;
                } else {
                    array[arrayIndex] = rightArray[j];
                    j++;
                }
            } else {
                if (leftArray[i] >= rightArray[j]) {
                    array[arrayIndex] = leftArray[i];
                    i++;
                } else {
                    array[arrayIndex] = rightArray[j];
                    j++;
                }
            }
            arrayIndex++;
        }
        while (i < leftArrayLen) {
            array[arrayIndex] = leftArray[i];
            i++;
            arrayIndex++;
        }

        while (j < rightArrayLen) {
            array[arrayIndex] = rightArray[j];
            j++;
            arrayIndex++;
        }
    }

}
