package com.johnny.annotations.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@interface DataItem{}

@DataItem class X{}
@DataItem interface Y{}
class Z{
    @DataItem int a;
    @DataItem static int b;

    @DataItem Z(){}
    void m1(@DataItem int a){}
}

@Target(ElementType.TYPE_USE)
@interface Wildcard{}

class X1{
    @Wildcard int x;
    @Wildcard static int y;

    void m1(@Wildcard int a){
        @Wildcard int z=0;
        var X1 = new @Wildcard X1();

        int n = (@Wildcard int) 23.9;
    }
}

public class TargetExample {
    public static void main(String[] args) {

    }
}
