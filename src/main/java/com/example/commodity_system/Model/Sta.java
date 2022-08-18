package com.example.commodity_system.Model;

public class Sta {
    int Sta_id;
    String Sta_name;
    String Sta_phone;
    String Sta_sex;
    String Sta_address;
    int Sta_shop;
    String Sta_message;

    public Sta(){}
    public Sta(int sta_id, String sta_name, String sta_phone, String sta_sex, String sta_address, int sta_shop, String sta_message) {
        Sta_id = sta_id;
        Sta_name = sta_name;
        Sta_phone = sta_phone;
        Sta_sex = sta_sex;
        Sta_address = sta_address;
        Sta_shop = sta_shop;
        Sta_message = sta_message;
    }

    @Override
    public String toString() {
        return "Sta{" +
                "Sta_id=" + Sta_id +
                ", Sta_name='" + Sta_name + '\'' +
                ", Sta_phone='" + Sta_phone + '\'' +
                ", Sta_sex='" + Sta_sex + '\'' +
                ", Sta_address='" + Sta_address + '\'' +
                ", Sta_shop='" + Sta_shop + '\'' +
                ", Sta_message='" + Sta_message + '\'' +
                '}';
    }

    public int getSta_id() {
        return Sta_id;
    }

    public void setSta_id(int sta_id) {
        Sta_id = sta_id;
    }

    public String getSta_name() {
        return Sta_name;
    }

    public void setSta_name(String sta_name) {
        Sta_name = sta_name;
    }

    public String getSta_phone() {
        return Sta_phone;
    }

    public void setSta_phone(String sta_phone) {
        Sta_phone = sta_phone;
    }

    public String getSta_sex() {
        return Sta_sex;
    }

    public void setSta_sex(String sta_sex) {
        Sta_sex = sta_sex;
    }

    public String getSta_address() {
        return Sta_address;
    }

    public void setSta_address(String sta_address) {
        Sta_address = sta_address;
    }

    public int getSta_shop() {
        return Sta_shop;
    }

    public void setSta_shop(int sta_shop) {
        Sta_shop = sta_shop;
    }

    public String getSta_message() {
        return Sta_message;
    }

    public void setSta_message(String sta_message) {
        Sta_message = sta_message;
    }
}
