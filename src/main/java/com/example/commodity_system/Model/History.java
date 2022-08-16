package com.example.commodity_system.Model;

import java.util.Date;

public class History {
    int His_id;
    int His_shopid;
    String His_shopname;
    int His_goodsid;
    String His_goodsname;
    String His_goodstype;
    int His_goodsnumber;
    int His_price;
    String His_time;
    String His_human;
    int His_fromid;
    String His_fromname;
    int His_type;
    public History(){}
    public History(int his_id, int his_shopid, String his_shopname, int his_goodsid, String his_goodsname, String his_goodstype, int his_goodsnumber, int his_price, String his_time, String his_human, int his_fromid, String his_fromname, int his_type) {
        His_id = his_id;
        His_shopid = his_shopid;
        His_shopname = his_shopname;
        His_goodsid = his_goodsid;
        His_goodsname = his_goodsname;
        His_goodstype = his_goodstype;
        His_goodsnumber = his_goodsnumber;
        His_price = his_price;
        His_time = his_time;
        His_human = his_human;
        His_fromid = his_fromid;
        His_fromname = his_fromname;
        His_type = his_type;
    }

    @Override
    public String toString() {
        return "History{" +
                "His_id=" + His_id +
                ", His_shopid=" + His_shopid +
                ", His_shopname='" + His_shopname + '\'' +
                ", His_goodsid=" + His_goodsid +
                ", His_goodsname='" + His_goodsname + '\'' +
                ", His_goodstype='" + His_goodstype + '\'' +
                ", His_goodsnumber=" + His_goodsnumber +
                ", His_price=" + His_price +
                ", His_time=" + His_time +
                ", His_human='" + His_human + '\'' +
                ", His_fromid=" + His_fromid +
                ", His_fromname='" + His_fromname + '\'' +
                ", His_type=" + His_type +
                '}';
    }

    public int getHis_id() {
        return His_id;
    }

    public void setHis_id(int his_id) {
        His_id = his_id;
    }

    public int getHis_shopid() {
        return His_shopid;
    }

    public void setHis_shopid(int his_shopid) {
        His_shopid = his_shopid;
    }

    public String getHis_shopname() {
        return His_shopname;
    }

    public void setHis_shopname(String his_shopname) {
        His_shopname = his_shopname;
    }

    public int getHis_goodsid() {
        return His_goodsid;
    }

    public void setHis_goodsid(int his_goodsid) {
        His_goodsid = his_goodsid;
    }

    public String getHis_goodsname() {
        return His_goodsname;
    }

    public void setHis_goodsname(String his_goodsname) {
        His_goodsname = his_goodsname;
    }

    public String getHis_goodstype() {
        return His_goodstype;
    }

    public void setHis_goodstype(String his_goodstype) {
        His_goodstype = his_goodstype;
    }

    public int getHis_goodsnumber() {
        return His_goodsnumber;
    }

    public void setHis_goodsnumber(int his_goodsnumber) {
        His_goodsnumber = his_goodsnumber;
    }

    public int getHis_price() {
        return His_price;
    }

    public void setHis_price(int his_price) {
        His_price = his_price;
    }

    public String getHis_time() {
        return His_time;
    }

    public void setHis_time(String his_time) {
        His_time = his_time;
    }

    public String getHis_human() {
        return His_human;
    }

    public void setHis_human(String his_human) {
        His_human = his_human;
    }

    public int getHis_fromid() {
        return His_fromid;
    }

    public void setHis_fromid(int his_fromid) {
        His_fromid = his_fromid;
    }

    public String getHis_fromname() {
        return His_fromname;
    }

    public void setHis_fromname(String his_fromname) {
        His_fromname = his_fromname;
    }

    public int getHis_type() {
        return His_type;
    }

    public void setHis_type(int his_type) {
        His_type = his_type;
    }
}
