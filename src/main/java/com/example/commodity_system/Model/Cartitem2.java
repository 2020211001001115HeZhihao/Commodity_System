package com.example.commodity_system.Model;

public class Cartitem2 {
    Goods goods;
    int number;
    int price;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        int sum = number * goods.getGoods_price();
        return sum;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
