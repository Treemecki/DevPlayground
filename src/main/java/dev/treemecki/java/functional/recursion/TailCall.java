package dev.treemecki.java.functional.recursion;

import java.util.stream.Stream;

@FunctionalInterface
public interface TailCall<T> {

    TailCall<T> apply();

    default boolean isComplete() {
        return false;
    }

    default T result() {
        throw new RuntimeException("not implemented");
    }

    default T invoke() {
        return Stream.iterate(this, TailCall<T>::apply)
                .filter(TailCall<T>::isComplete)
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .result();
    }

}
