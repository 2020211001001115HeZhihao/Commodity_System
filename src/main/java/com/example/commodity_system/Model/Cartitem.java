package com.example.commodity_system.Model;

public class Cartitem {
    Product product;
    int number;
    int price; //总价

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        int unitprice = product.getPro_price();
        int sum = unitprice * number;
        return sum;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
