package com.johnny.streams.terminaloperations.collect;

import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Collect {
    public static void main(String[] args) {
        collectSupplerAccumulatorCombiner();
    }

    private static void collectSupplerAccumulatorCombiner(){
        //StringBuilder collect(Supplier<StringBuilder> suppler,
        //              BiConsumer<StringBuilder, String> accumulator,
        //              BiConsumer<StringBuilder, StringBuilder> combiner)
        // This version is used when you want complete control over
        // how collection should work. The accumulator adds an element
        // to the collection e.g. the next String to the StringBuilder.
        // The combiner takes two collections and merges them. It is useful
        // in parallel processing.
        StringBuilder word = Stream.of("ad", "jud", "i", "cate")
                .collect(() -> new StringBuilder(),
                        (sb , str) -> sb.append(str),
                        (sb1, sb2) -> sb1.append(sb2));
        System.out.println(word);
    }
}
