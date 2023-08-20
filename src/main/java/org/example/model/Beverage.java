package org.example.model;

public class Beverage extends Product {
    private String beverageType;

    public Beverage(int id, double price, String productName, String beverageType) {
        super(id, price, productName);
        this.beverageType = beverageType;
    }

    public String getBeverageType() {
        return beverageType;
    }

    public void setBeverageType(String beverageType) {
        this.beverageType = beverageType;
    }

    @Override
    public String examine() {
        return "Drink - " + getProductName() + ", Type: " + beverageType + ", Price: $" + getPrice();
    }

    @Override
    public String use() {
        return "Quench your thirst with a refreshing drink!";
    }
}

