package com.johnny.lambdaexpressions.assignment.one;

@FunctionalInterface
public interface Evaluate<T> {
    boolean isNegative(T t);
}
