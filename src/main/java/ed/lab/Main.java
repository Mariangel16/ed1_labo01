package ed.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final ArrayGenerator<Integer> sortedArrayGenerator = length -> {
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = i + 1;
        }
        return array;
    };

    private static final ArrayGenerator<Integer> invertedArrayGenerator = length -> {
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = length - i;
        }
        return array;
    };

    private static final ArrayGenerator<Integer> randomArrayGenerator = length -> {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list.toArray(new Integer[0]);
    };

    private static final QuickSort<Integer> highPivotQuickSort = SortingAlgorithms::highPivotQuickSort;
    private static final QuickSort<Integer> lowPivotQuickSort = SortingAlgorithms::lowPivotQuickSort;
    private static final QuickSort<Integer> randomPivotQuickSort = SortingAlgorithms::randomPivotQuickSort;

    public static ArrayGenerator<Integer> getSortedArrayGenerator() {
        return sortedArrayGenerator;
    }

    public static ArrayGenerator<Integer> getInvertedArrayGenerator() {
        return invertedArrayGenerator;
    }

    public static ArrayGenerator<Integer> getRandomArrayGenerator() {
        return randomArrayGenerator;
    }

    public static QuickSort<Integer> getHighPivotQuickSort() {
        return highPivotQuickSort;
    }

    public static QuickSort<Integer> getLowPivotQuickSort() {
        return lowPivotQuickSort;
    }

    public static QuickSort<Integer> getRandomPivotQuickSort() {
        return randomPivotQuickSort;
    }

    public static void main(String[] args) {
        System.out.println("Iniciando el programa...");
        final SortingTester<Integer> tester = new SortingTester<>();

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
