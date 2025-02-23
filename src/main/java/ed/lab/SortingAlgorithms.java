package ed.lab;

import java.util.Random;

public class SortingAlgorithms {
    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, "high");
    }

    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, "low");
    }

    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, "random");
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int left, int right, String pivotType) {
        if (left >= right) return; // Condición de corte correcta

        int pivotIndex = getPivotIndex(left, right, pivotType);
        int partitionIndex = partition(array, left, right, pivotIndex);

        quickSort(array, left, partitionIndex - 1, pivotType);
        quickSort(array, partitionIndex + 1, right, pivotType);
    }

    private static int getPivotIndex(int left, int right, String pivotType) {
        Random random = new Random();
        return switch (pivotType) {
            case "low" -> left;
            case "high" -> right;
            case "random" -> random.nextInt(right - left + 1) + left;
            default -> throw new IllegalArgumentException("Invalid pivot type");
        };
    }

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right, int pivotIndex) {
        T pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right); // Mueve el pivote al final
        int partitionIndex = left;

        for (int i = left; i < right; i++) {
            if (array[i].compareTo(pivotValue) < 0) { // Solo mover si es menor
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(array, partitionIndex, right);
        return partitionIndex;
    }

    private static <T> void swap(T[] array, int i, int j) {
        if (i != j) {
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
