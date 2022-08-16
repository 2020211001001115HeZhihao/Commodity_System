package com.example.commodity_system.Model;

public class Goods {
    int Goods_id;
    String Goods_name;
    String Goods_type;
    int Goods_number;
    int Goods_price;
    int Goods_father;
    int Goods_now;
    int Goods_from;
    String Goods_from2;
    public  Goods(){

    }
    public void Goods2(String goods_name, String goods_type, int goods_number, int goods_price, int goods_father, int goods_now, int goods_from, String goods_from2) {
        Goods_name = goods_name;
        Goods_type = goods_type;
        Goods_number = goods_number;
        Goods_price = goods_price;
        Goods_father = goods_father;
        Goods_now = goods_now;
        Goods_from = goods_from;
        Goods_from2 = goods_from2;
    }
    public Goods(int goods_id, String goods_name, String goods_type, int goods_number, int goods_price, int goods_father, int goods_now, int goods_from, String goods_from2) {
        Goods_id = goods_id;
        Goods_name = goods_name;
        Goods_type = goods_type;
        Goods_number = goods_number;
        Goods_price = goods_price;
        Goods_father = goods_father;
        Goods_now = goods_now;
        Goods_from = goods_from;
        Goods_from2 = goods_from2;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "Goods_id=" + Goods_id +
                ", Goods_name='" + Goods_name + '\'' +
                ", Goods_type='" + Goods_type + '\'' +
                ", Goods_number=" + Goods_number +
                ", Goods_price=" + Goods_price +
                ", Goods_father=" + Goods_father +
                ", Goods_now=" + Goods_now +
                ", Goods_from=" + Goods_from +
                ", Goods_from2='" + Goods_from2 + '\'' +
                '}';
    }

    public int getGoods_id() {
        return Goods_id;
    }

    public void setGoods_id(int goods_id) {
        Goods_id = goods_id;
    }

    public String getGoods_name() {
        return Goods_name;
    }

    public void setGoods_name(String goods_name) {
        Goods_name = goods_name;
    }

    public String getGoods_type() {
        return Goods_type;
    }

    public void setGoods_type(String goods_type) {
        Goods_type = goods_type;
    }

    public int getGoods_number() {
        return Goods_number;
    }

    public void setGoods_number(int goods_number) {
        Goods_number = goods_number;
    }

    public int getGoods_price() {
        return Goods_price;
    }

    public void setGoods_price(int goods_price) {
        Goods_price = goods_price;
    }

    public int getGoods_father() {
        return Goods_father;
    }

    public void setGoods_father(int goods_father) {
        Goods_father = goods_father;
    }

    public int getGoods_now() {
        return Goods_now;
    }

    public void setGoods_now(int goods_now) {
        Goods_now = goods_now;
    }

    public int getGoods_from() {
        return Goods_from;
    }

    public void setGoods_from(int goods_from) {
        Goods_from = goods_from;
    }

    public String getGoods_from2() {
        return Goods_from2;
    }

    public void setGoods_from2(String goods_from2) {
        Goods_from2 = goods_from2;
    }
}
