package com.johnny.collectionsandgenerics.collections.sorting;

import java.util.Objects;

public class Product implements Comparable<Product> {
    private Integer id;

    public Product(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + id;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Product){
            Product otherProduct = (Product) o;
            if(id == otherProduct.id){
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Product o) {
        // delegate to Integer which implements Comparable<Integer>
        return id.compareTo(o.getId());
    }
}
