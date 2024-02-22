package com.johnny.collectionsandgenerics.generics.equalsandhashcode;

class Foo {
    private int fooValue;

    Foo(int val){
        this.fooValue = val;
    }

    int getFooValue(){
        return fooValue;
    }

    @Override
    public boolean equals(Object o){
        return (o instanceof Foo) && (((Foo) o).getFooValue() == this.getFooValue());
    }

    @Override
    public int hashCode(){
        return fooValue * 17;
    }
}

class EqualTest{
    public static void main(String[] args) {
        Foo f1 = new Foo(2);
        Foo f2 = new Foo(2);
        Foo f3 = new Foo(3);
        System.out.println(f1.equals(f2));
        System.out.println(f1.equals("JKR"));

        System.out.println(f1.hashCode());
        System.out.println(f2.hashCode());
        System.out.println(f3.hashCode());
    }
}