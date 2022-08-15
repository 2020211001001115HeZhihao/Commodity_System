package com.example.commodity_system.Dao;

import com.example.commodity_system.Model.Fac;
import com.example.commodity_system.Model.Fac;
import com.example.commodity_system.Model.Fac;
import com.example.commodity_system.Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacDao {
    //新建账号
    public boolean insert(Connection con, Fac fac) throws SQLException {
        int Fac_id = fac.getFac_id();
        String Fac_name = fac.getFac_name();
        String Fac_address = fac.getFac_address();
        String Fac_boss = fac.getFac_boss();
        String Fac_bossp = fac.getFac_bossp();
        String Fac_phone = fac.getFac_phone();
        String Fac_message = fac.getFac_message();
        int Fac_goods = fac.getFac_goods();
        String sql = "insert into Factory values('"+Fac_id+"','"+Fac_address+"','"
                +Fac_boss+"','"+Fac_bossp+"','"+Fac_phone+"','"+Fac_message+"','"
                +Fac_name+"','"+Fac_goods+"')";
        try {
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //修改全部
    public boolean updateAll(Connection con, Fac fac) throws SQLException {
        int Fac_id = fac.getFac_id();
        String Fac_name = fac.getFac_name();
        String Fac_address = fac.getFac_address();
        String Fac_boss = fac.getFac_boss();
        String Fac_bossp = fac.getFac_bossp();
        String Fac_phone = fac.getFac_phone();
        String Fac_message = fac.getFac_message();
        int Fac_goods = fac.getFac_goods();
        String sql = "update Factory set Fac_name='"+Fac_name+"',Fac_address='"+Fac_address+
                "',Fac_boss='"+Fac_boss+"',Fac_bossp='"+Fac_bossp+"',Fac_phone='"+
                Fac_phone+"',Fac_message='"+Fac_message +"',Fac_goods='"+Fac_goods+
                "' where Fac_id='"+ Fac_id+"'";
        try {
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //通过id寻找全部
    public Fac findByid(Connection con, int id) throws SQLException {
        String sql = "select * from Factory where Fac_id = '"+id+"'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        Fac fac = null;
        if(rs.next()){
            fac = new Fac();
            fac.setFac_id(rs.getInt("Fac_id"));
            fac.setFac_name(rs.getString("Fac_name"));
            fac.setFac_address(rs.getString("Fac_address"));
            fac.setFac_boss(rs.getString("Fac_boss"));
            fac.setFac_bossp(rs.getString("Fac_bossp"));
            fac.setFac_phone(rs.getString("Fac_phone"));
            fac.setFac_message(rs.getString("Fac_message"));
            fac.setFac_goods(rs.getInt("Fac_goods"));
        }
        return fac;
    }

    //所有产品
    public List<Product> AllPro(Connection con,int id) throws SQLException {
        String sql = "select * from Fac_product where Pro_father = '"+id+"'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<Product> list = new ArrayList<>();

        while (rs.next()){
            int Pro_id = rs.getInt(1);
            String Pro_name = rs.getString(2);
            String Pro_type = rs.getString(3);
            int Pro_father = rs.getInt(4);
            int Pro_price = rs.getInt(5);
            int Pro_now = rs.getInt(6);

            Product pro = new Product();
            pro.setPro_id(Pro_id);pro.setPro_name(Pro_name);pro.setPro_type(Pro_type);
            pro.setPro_father(Pro_father);pro.setPro_price(Pro_price);pro.setPro_now(Pro_now);
            list.add(pro);
        }

        return list;
    }
}
