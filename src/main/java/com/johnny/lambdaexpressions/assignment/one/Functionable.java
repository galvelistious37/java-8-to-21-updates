package com.johnny.lambdaexpressions.assignment.one;

@FunctionalInterface
public interface Functionable<T, R> {
    R applyThis(T t);
}
