package com.example.commodity_system.Model;

public class Shop {
    int Shop_id;
    String Shop_name;
    String Shop_address;
    String Shop_boss;
    String Shop_bossp;
    String Shop_phone;
    String Shop_message;
    int Shop_money;
    int Shop_number;
    int Shop_goods;
    public Shop(){}

    public Shop(int shop_id, String shop_name, String shop_address, String shop_boss, String shop_bossp, String shop_phone, String shop_message, int shop_money, int shop_number, int shop_goods) {
        Shop_id = shop_id;
        Shop_name = shop_name;
        Shop_address = shop_address;
        Shop_boss = shop_boss;
        Shop_bossp = shop_bossp;
        Shop_phone = shop_phone;
        Shop_message = shop_message;
        Shop_money = shop_money;
        Shop_number = shop_number;
        Shop_goods = shop_goods;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "Shop_id=" + Shop_id +
                ", Shop_name='" + Shop_name + '\'' +
                ", Shop_address='" + Shop_address + '\'' +
                ", Shop_boss='" + Shop_boss + '\'' +
                ", Shop_bossp='" + Shop_bossp + '\'' +
                ", Shop_phone='" + Shop_phone + '\'' +
                ", Shop_message='" + Shop_message + '\'' +
                ", Shop_money=" + Shop_money +
                ", Shop_number=" + Shop_number +
                ", Shop_goods=" + Shop_goods +
                '}';
    }

    public int getShop_id() {
        return Shop_id;
    }

    public void setShop_id(int shop_id) {
        Shop_id = shop_id;
    }

    public String getShop_name() {
        return Shop_name;
    }

    public void setShop_name(String shop_name) {
        Shop_name = shop_name;
    }

    public String getShop_address() {
        return Shop_address;
    }

    public void setShop_address(String shop_address) {
        Shop_address = shop_address;
    }

    public String getShop_boss() {
        return Shop_boss;
    }

    public void setShop_boss(String shop_boss) {
        Shop_boss = shop_boss;
    }

    public String getShop_bossp() {
        return Shop_bossp;
    }

    public void setShop_bossp(String shop_bossp) {
        Shop_bossp = shop_bossp;
    }

    public String getShop_phone() {
        return Shop_phone;
    }

    public void setShop_phone(String shop_phone) {
        Shop_phone = shop_phone;
    }

    public String getShop_message() {
        return Shop_message;
    }

    public void setShop_message(String shop_message) {
        Shop_message = shop_message;
    }

    public int getShop_money() {
        return Shop_money;
    }

    public void setShop_money(int shop_money) {
        Shop_money = shop_money;
    }

    public int getShop_number() {
        return Shop_number;
    }

    public void setShop_number(int shop_number) {
        Shop_number = shop_number;
    }

    public int getShop_goods() {
        return Shop_goods;
    }

    public void setShop_goods(int shop_goods) {
        Shop_goods = shop_goods;
    }
}
