package com.example.commodity_system.Model;

public class Product {
    int Pro_id;
    String Pro_name;
    String Pro_type;
    int Pro_father;
    int Pro_price;
    int Pro_now;
    String Pro_father2;

    public String getPro_father2() {
        return Pro_father2;
    }

    public void setPro_father2(String pro_father2) {
        Pro_father2 = pro_father2;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Pro_id=" + Pro_id +
                ", Pro_name='" + Pro_name + '\'' +
                ", Pro_type='" + Pro_type + '\'' +
                ", Pro_father=" + Pro_father +
                ", Pro_price=" + Pro_price +
                ", Pro_now=" + Pro_now +
                '}';
    }

    public int getPro_id() {
        return Pro_id;
    }

    public void setPro_id(int pro_id) {
        Pro_id = pro_id;
    }

    public String getPro_name() {
        return Pro_name;
    }

    public void setPro_name(String pro_name) {
        Pro_name = pro_name;
    }

    public String getPro_type() {
        return Pro_type;
    }

    public void setPro_type(String pro_type) {
        Pro_type = pro_type;
    }

    public int getPro_father() {
        return Pro_father;
    }

    public void setPro_father(int pro_father) {
        Pro_father = pro_father;
    }

    public int getPro_price() {
        return Pro_price;
    }

    public void setPro_price(int pro_price) {
        Pro_price = pro_price;
    }

    public int getPro_now() {
        return Pro_now;
    }

    public void setPro_now(int pro_now) {
        Pro_now = pro_now;
    }
}
