package com.example.commodity_system.Model;

public class Sta_emp {
    int Emp_id;
    int Emp_staffid;
    int Emp_shopid;
    int Emp_now;

    public Sta_emp(){}

    public Sta_emp(int emp_id, int emp_staffid, int emp_shopid, int emp_now) {
        Emp_id = emp_id;
        Emp_staffid = emp_staffid;
        Emp_shopid = emp_shopid;
        Emp_now = emp_now;
    }

    @Override
    public String toString() {
        return "Sta_emp{" +
                "Emp_id=" + Emp_id +
                ", Emp_staffid=" + Emp_staffid +
                ", Emp_shopid=" + Emp_shopid +
                ", Emp_now=" + Emp_now +
                '}';
    }

    public int getEmp_id() {
        return Emp_id;
    }

    public void setEmp_id(int emp_id) {
        Emp_id = emp_id;
    }

    public int getEmp_staffid() {
        return Emp_staffid;
    }

    public void setEmp_staffid(int emp_staffid) {
        Emp_staffid = emp_staffid;
    }

    public int getEmp_shopid() {
        return Emp_shopid;
    }

    public void setEmp_shopid(int emp_shopid) {
        Emp_shopid = emp_shopid;
    }

    public int getEmp_now() {
        return Emp_now;
    }

    public void setEmp_now(int emp_now) {
        Emp_now = emp_now;
    }
}
