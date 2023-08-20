package org.example.model;

public class Chocolate extends Product {
    private String type;

    public Chocolate(int id, double price, String productName, String type) {
        super(id, price, productName);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String examine() {
        return "Chocolate - " + getProductName() + ", Type: " + type + ", Price: $" + getPrice();
    }

    @Override
    public String use() {
        return "Indulge in the delicious chocolate!";
    }
}
