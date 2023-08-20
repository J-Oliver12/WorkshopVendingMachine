package org.example.model;

public class PotatoChips extends Product {
    private String flavor;

    public PotatoChips(int id, double price, String productName, String flavor) {
        super(id, price, productName);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String examine() {
        return "Potato Chips - " + getProductName() + ", Flavor: " + flavor + ", Price: $" + getPrice();
    }

    @Override
    public String use() {
        return "Enjoy the crunchiness of potato chips!";
    }
}

