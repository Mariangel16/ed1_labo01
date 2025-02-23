package ed.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final ArrayGenerator<String> sortedArrayGenerator = length -> {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = String.format("Item%02d", i + 1); // Formato con ceros a la izquierda
        }
        return array;
    };

    private static final ArrayGenerator<String> invertedArrayGenerator = length -> {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = String.format("Item%02d", length - i); // Formato con ceros a la izquierda
        }
        return array;
    };

    private static final ArrayGenerator<String> randomArrayGenerator = length -> {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = String.format("Item%02d", list.get(i)); // Formato con ceros a la izquierda
        }
        return array;
    };

    private static final QuickSort<String> highPivotQuickSort = SortingAlgorithms::highPivotQuickSort;
    private static final QuickSort<String> lowPivotQuickSort = SortingAlgorithms::lowPivotQuickSort;
    private static final QuickSort<String> randomPivotQuickSort = SortingAlgorithms::randomPivotQuickSort;

    public static ArrayGenerator<String> getSortedArrayGenerator() {
        return sortedArrayGenerator;
    }

    public static ArrayGenerator<String> getInvertedArrayGenerator() {
        return invertedArrayGenerator;
    }

    public static ArrayGenerator<String> getRandomArrayGenerator() {
        return randomArrayGenerator;
    }

    public static QuickSort<String> getHighPivotQuickSort() {
        return highPivotQuickSort;
    }

    public static QuickSort<String> getLowPivotQuickSort() {
        return lowPivotQuickSort;
    }

    public static QuickSort<String> getRandomPivotQuickSort() {
        return randomPivotQuickSort;
    }

    public static void main(String[] args) {
        System.out.println("Iniciando el programa...");
        final SortingTester<String> tester = new SortingTester<>();

        System.out.println("Ordenando un arreglo ordenado:");
        tester.testSorting(sortedArrayGenerator, highPivotQuickSort);
        tester.testSorting(sortedArrayGenerator, lowPivotQuickSort);
        tester.testSorting(sortedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo invertido:");
        tester.testSorting(invertedArrayGenerator, highPivotQuickSort);
        tester.testSorting(invertedArrayGenerator, lowPivotQuickSort);
        tester.testSorting(invertedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo aleatorio:");
        tester.testSorting(randomArrayGenerator, highPivotQuickSort);
        tester.testSorting(randomArrayGenerator, lowPivotQuickSort);
        tester.testSorting(randomArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");
    }
}
