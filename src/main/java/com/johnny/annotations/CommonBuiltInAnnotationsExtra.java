package com.johnny.annotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Book{
    /**
     * @deprecated Use readOnline() instead.
     */
    @Deprecated(since="2.0", forRemoval = true)
    public static void print(){}
    public static void readOnline(){}
    public static Integer preview(List<String> pages){
        return pages.size();
    }
}

public class CommonBuiltInAnnotationsExtra {
    public static void main(String[] args) {
        var ann = new CommonBuiltInAnnotationsExtra();
        ann.testDeprecated();
        ann.testUnchecked();
        abuseVarargs(new ArrayList<>());
    }

    @SuppressWarnings("deprecation")
    private void testDeprecated(){
        Book.print();
    }

    @SuppressWarnings("unchecked")
    private void testUnchecked(){
//        Book.preview(new ArrayList<>());
        Book.preview(new ArrayList());
    }

    @SafeVarargs
    static int abuseVarargs(List<Integer>... list){
        Object[] oa = list;
        oa[0] = Arrays.asList("Uh-oh!");
        return list[0].get(0);
    }
}
