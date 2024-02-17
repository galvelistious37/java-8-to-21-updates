package com.johnny.collectionsandgenerics.collections.sorting;

public class Worker {
    private int id;

    public Worker(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Worker{" + "id=" + id + '}';
    }
}
