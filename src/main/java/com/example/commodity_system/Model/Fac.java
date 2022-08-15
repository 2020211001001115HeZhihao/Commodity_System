package com.example.commodity_system.Model;

public class Fac {
    int Fac_id;
    String Fac_address;
    String Fac_boss;
    String Fac_bossp;
    String Fac_phone;
    String Fac_message;
    String Fac_name;
    int Fac_goods;

    public int getFac_id() {
        return Fac_id;
    }

    public void setFac_id(int fac_id) {
        Fac_id = fac_id;
    }

    public String getFac_address() {
        return Fac_address;
    }

    public void setFac_address(String fac_address) {
        Fac_address = fac_address;
    }

    public String getFac_boss() {
        return Fac_boss;
    }

    public void setFac_boss(String fac_boss) {
        Fac_boss = fac_boss;
    }

    public String getFac_bossp() {
        return Fac_bossp;
    }

    public void setFac_bossp(String fac_bossp) {
        Fac_bossp = fac_bossp;
    }

    public String getFac_phone() {
        return Fac_phone;
    }

    public void setFac_phone(String fac_phone) {
        Fac_phone = fac_phone;
    }

    public String getFac_message() {
        return Fac_message;
    }

    public void setFac_message(String fac_message) {
        Fac_message = fac_message;
    }

    public String getFac_name() {
        return Fac_name;
    }

    public void setFac_name(String fac_name) {
        Fac_name = fac_name;
    }

    public int getFac_goods() {
        return Fac_goods;
    }

    public void setFac_goods(int fac_goods) {
        Fac_goods = fac_goods;
    }

    @Override
    public String toString() {
        return "Fac{" +
                "Fac_id=" + Fac_id +
                ", Fac_address='" + Fac_address + '\'' +
                ", Fac_boss='" + Fac_boss + '\'' +
                ", Fac_bossp='" + Fac_bossp + '\'' +
                ", Fac_phone='" + Fac_phone + '\'' +
                ", Fac_message='" + Fac_message + '\'' +
                ", Fac_name='" + Fac_name + '\'' +
                ", Fac_goods=" + Fac_goods +
                '}';
    }
}
