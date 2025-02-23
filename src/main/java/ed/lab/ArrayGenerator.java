package ed.lab;

@FunctionalInterface
public interface ArrayGenerator<T> {
    T[] generate(int length);
}
