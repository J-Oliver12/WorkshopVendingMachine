package org.example.model;

public class VendingMachineImpl implements VendingMachine {

    private Product[] products;
    private int depositPool;

    public VendingMachineImpl(Product[] products) {
        this.products = products;
        this.depositPool = 0;
    }

    /*
    @Override
    public void addCurrency(int amount) {
        if (amount > 0) {
            depositPool += amount;
        }
    }
    */

    public void addCurrency(int amount) {
        int[] validValues = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};

        for (int validValue : validValues) {
            if (amount == validValue) {
                depositPool += amount;
                return;
            }
        }

        System.out.println("Invalid currency value. Accepted values: 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000");
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        for (Product product : products) {
            if (product.getId() == id && depositPool >= product.getPrice()) {
                depositPool -= product.getPrice();
                return product;
            }
        }
        return null; // Product not available or insufficient balance
    }

    @Override
    public int endSession() {
        int remainingBalance = depositPool;
        depositPool = 0;
        return remainingBalance;
    }

    @Override
    public String getDescription(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product.examine();
            }
        }
        return "Product not found.";
    }

    /*
    @Override
    public String[] getProducts() {
        String[] productInfo = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            productInfo[i] = products[i].getProductName();
        }
        return productInfo;
    }
    */

    /*

    public String[] getProducts() {
        String[] productInfo = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            productInfo[i] = "ID: " + product.getId() + ", Name: " + product.getProductName() + ", Price: $" + String.format("%.2f", product.getPrice());
        }
        return productInfo;
    }
    */

    /*
    public String[] getProducts() {
        String[] productInfo = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            productInfo[i] = String.format("ID: %d, Name: %s, Price: $%.2f", product.getId(), product.getProductName(), product.getPrice());
        }
        return productInfo;
    }
    */

    public String[] getProducts() {
        String[] productNames = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            productNames[i] = "ID: " + product.getId() + ", Name: " + product.getProductName() + ", Price: $" + formatPrice(product.getPrice());
        }
        return productNames;
    }

    // Helper method to format price
    private String formatPrice(double price) {
        return Double.toString(price);
    }

}
