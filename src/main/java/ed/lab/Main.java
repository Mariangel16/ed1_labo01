package ed.lab;

import java.util.Random;
import ed.lab.SortingAlgorithms;

public class Main {
    private static final ArrayGenerator<Integer> sortedArrayGenerator = length -> {
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = i + 1; // Llenar el arreglo de forma ascendente
        }
        return array;

    };

    private static final ArrayGenerator<Integer> invertedArrayGenerator = length ->{
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = length - i; // Llenar el arreglo de forma descendente
        }
        return array;

    };

    private static final ArrayGenerator<Integer> randomArrayGenerator = length ->{
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * length); // Llenar con valores aleatorios
        }
        return array;
    };

    private static final QuickSort<Integer> highPivotQuickSort = SortingAlgorithms::highPivotQuickSort; // Reemplácelo por una referencia a un método

    private static final QuickSort<Integer> lowPivotQuickSort = SortingAlgorithms::lowPivotQuickSort; // Reemplácelo por una referencia a un método

    private static final QuickSort<Integer> randomPivotQuickSort = SortingAlgorithms::randomPivotQuickSort; // Reemplácelo por una referencia a un método

    public static QuickSort<Integer> getHighPivotQuickSort() {
        return highPivotQuickSort;
    }


    public static QuickSort<Integer> getLowPivotQuickSort() {
        return lowPivotQuickSort;
    }

    public static QuickSort<Integer> getRandomPivotQuickSort() {
        return randomPivotQuickSort;
    }

    public static ArrayGenerator<Integer> getSortedArrayGenerator() {
        return sortedArrayGenerator;
    }

    public static ArrayGenerator<Integer> getInvertedArrayGenerator() {
        return invertedArrayGenerator;
    }

    public static ArrayGenerator<Integer> getRandomArrayGenerator() {
        return randomArrayGenerator;
    }

    public static void main(String[] args) {
        System.out.println("Iniciando el programa...");
        final SortingTester<Integer> tester = new SortingTester<>();

        System.out.println("Ordenando un arreglo ordenado:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(sortedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo invertido:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(invertedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo aleatorio:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(randomArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");
    }

    public static class SortingAlgorithms {
        public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
            quickSort(array, 0, array.length - 1, "high");
        }

        public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
            quickSort(array, 0, array.length - 1, "low");
        }

        public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
            quickSort(array, 0, array.length - 1, "random");
        }

        private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high, String pivotType) {
            if (low < high) {
                int pivotIndex = partition(array, low, high, pivotType);
                quickSort(array, low, pivotIndex - 1, pivotType);
                quickSort(array, pivotIndex + 1, high, pivotType);
            }
        }

        private static <T extends Comparable<T>> int partition(T[] array, int low, int high, String pivotType) {
            int pivotIndex = switch (pivotType) {
                case "low" -> low;
                case "random" -> new Random().nextInt(high - low + 1) + low;
                default -> high;
            };

            T pivot = array[pivotIndex];
            swap(array, pivotIndex, high);
            int i = low;

            for (int j = low; j < high; j++) {
                if (array[j].compareTo(pivot) <= 0) {
                    swap(array, i, j);
                    i++;
                }
            }
            swap(array, i, high);
            return i;
        }

        private static <T> void swap(T[] array, int i, int j) {
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}