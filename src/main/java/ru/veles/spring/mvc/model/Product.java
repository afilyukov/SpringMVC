package ru.veles.spring.mvc.model;

public class Product {
    private int id;
    private String title;
    private float cost;

    public Product(int id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("Product: [%d %s %f]", id, title, cost);
    }
}
