package algorithms;


public class SortingAlgorithms {

    /*
     *
     * ALGORITHM : BUBBLE SORT
     * TIME COMPLEXITY : O(N^2)
     * SPACE COMPLEXITY : O(1)
     *
     * */
    public void bubbleSort(int[] array) {
        if (array == null || array.length == 0) return;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, i, j);
                    flag = true;
                }
            }
            if (!flag) return;
        }
    }

    private static void swap(int[] array, int i, int j) {
        if (array == null || array.length == 0) return;
        int temporary = array[i];
        array[i] = array[j];
        array[j] = temporary;
    }

    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /*
     *
     * ALGORITHM : SELECTION SORT
     * TIME COMPLEXITY : O(N^2)
     * SPACE COMPLEXITY : O(1)
     *
     * */
    public static void selectionSort(int[] array) {
        if (array == null || array.length == 0) return;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[minIndex] > array[j]) {
                    array[minIndex] = array[j];
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    /*
     *
     * ALGORITHM : INSERTION SORT
     * TIME COMPLEXITY : O(N^2)
     * SPACE COMPLEXITY : O(1)
     *
     * */
    public static void insertionSort(int[] array) {
        if (array == null || array.length == 0) return;
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i], j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }


    /*
     *
     * ALGORITHM : QUICK SORT
     * TIME COMPLEXITY : O(N^2) [O(N^2) rarely occurs!!]
     * SPACE COMPLEXITY : O(1)
     *
     * */
    public static void quickSort(int[] array) {
        if (array == null || array.length == 0) return;
        int low = 0, high = array.length - 1;
        quickSort(array, low, high);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionPoint = getPivot(array, low, high);
            quickSort(array, low, partitionPoint - 1);
            quickSort(array, partitionPoint + 1, high);
        }
    }

    private static int getPivot(int[] array, int low, int high) {
        int pivot = array[high], topIndex = low - 1;

        for (int i = low; i <= high - 1; i++) {
            if (array[i] < pivot) {
                topIndex++;
                swap(array, i, topIndex);
            }
        }
        topIndex++;
        swap(array, topIndex, high);

        return topIndex;
    }

    public static void mergeSort(int[] array) {
        if (array == null || array.length == 0) return;
        int low = 0, high = array.length;
        mergeSort(array, low, high - 1);
    }

    private static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(array, low, middle);
            mergeSort(array, middle + 1, high);
            mergeArray(array, low, middle, high);
        }
    }

    private static void mergeArray(int[] array, int low, int middle, int high) {
        int m = middle - low + 1, n = high - middle;
        int[] L = new int[m];
        int[] R = new int[n];

        for (int i = 0; i < m; i++)
            L[i] = array[low + i];

        for (int i = 0; i < n; i++)
            R[i] = array[middle + i + 1];

        int i = 0, j = 0, k = low;
        while (i < m && j < n) {
            if (L[i] < R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            array[k++] = L[i++];
        }
        while (j < n) {
            array[k++] = R[j++];
        }

    }

    /*
     *
     * ALGORITHM : HEAP SORT (MAX HEAP)
     * TIME COMPLEXITY : O(N^Log(N))
     * SPACE COMPLEXITY : O(1)
     *
     * */


    public static void heapSort(int[] array) {
        if (array == null || array.length == 0) return;
        heapSort(array, array.length);
    }

    private static void heapSort(int[] array, int length) {
        for (int index = length / 2 - 1; index >= 0; index--)
            heapifyArray(array, length, index);

        for (int index = length - 1; index >= 0; index--) {
            swap(array, 0, index);
            heapifyArray(array, index, 0);
        }

    }

    private static void heapifyArray(int[] array, int length, int index) {
        int largestValueIndex = index;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        if (leftChildIndex < length && array[leftChildIndex] > array[largestValueIndex])
            largestValueIndex = leftChildIndex;

        if (rightChildIndex < length && array[rightChildIndex] > array[largestValueIndex])
            largestValueIndex = rightChildIndex;

        if (index != largestValueIndex) {
            swap(array, largestValueIndex, index);
            heapifyArray(array, length, largestValueIndex);
        }
    }


}