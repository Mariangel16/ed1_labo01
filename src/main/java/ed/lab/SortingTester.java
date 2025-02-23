package ed.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SortingTester<T extends Comparable<T>> {
    private static final int ARRAY_SIZE = 10000;
    private static final int TEST_SIZE = 1000;

    public void testSorting(ArrayGenerator<T> generator, QuickSort<T> quickSort) {
        System.out.println("Ejecutando pruebas de ordenamiento...");

        List<Long> durations = new ArrayList<>(TEST_SIZE);

        for (int i = 0; i < TEST_SIZE; i++) {
            T[] array = generator.generate(ARRAY_SIZE); // Generar nuevo array en cada iteración
            long start = System.nanoTime();

            quickSort.sort(array);

            long end = System.nanoTime();
            durations.add(end - start);
        }

        double average = durations.stream()
                .mapToLong(Long::longValue)
                .average()
                .orElse(0);

        // 🔹 Corregido: Usar %d para imprimir long en milisegundos
        System.out.printf("\t\tTiempo promedio: %d ms\n", TimeUnit.NANOSECONDS.toMillis((long) average));
    }
}
