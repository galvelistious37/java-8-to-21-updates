package com.johnny.collectionsandgenerics.collections.sorting;

public class Boss implements Comparable<Boss>{
    private int id;

    public Boss(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Boss{" + "id=" + id + '}';
    }

    @Override
    public int compareTo(Boss o) {
        // ascending id order
        return this.id - o.getId();
    }
}
