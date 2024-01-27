package com.johnny.lambdaexpressions.practice;

@FunctionalInterface
public interface MyFunction<T, R> {
    R doIt(T t);
}
