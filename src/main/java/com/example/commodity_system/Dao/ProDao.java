package com.example.commodity_system.Dao;

import com.example.commodity_system.Model.Fac;
import com.example.commodity_system.Model.Product;
import com.example.commodity_system.Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProDao {
    
    public boolean insert(Connection con, Product pro) throws SQLException {
        int Pro_now = pro.getPro_now();
        String Pro_name = pro.getPro_name();
        String Pro_type = pro.getPro_type();
        int Pro_father = pro.getPro_father();
        int Pro_price = pro.getPro_price();
        String sql = "insert into Fac_product values('"+Pro_name+"','"+Pro_type+"','"
                +Pro_father+"','"+Pro_price+"','"+Pro_now+"')";
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
    public boolean updatePro(Connection con, Product pro) throws SQLException {
        int Pro_id = pro.getPro_id();
        String Pro_name = pro.getPro_name();
        String Pro_type = pro.getPro_type();
        int Pro_father = pro.getPro_father();
        int Pro_price = pro.getPro_price();
        int Pro_now = pro.getPro_now();
        String sql = "update Fac_product set Pro_name='"+Pro_name+"',Pro_type='"+Pro_type+
                "',Pro_father='"+Pro_father+"',Pro_price='"+Pro_price+"',Pro_now='"+
                Pro_now+ "' where Pro_id='"+ Pro_id+"'";
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
    
    public boolean delByid(Connection con,String id) throws SQLException {
        String sql = "delete from Fac_product where Pro_id = '"+id+"'";
        PreparedStatement ps = null;
        ps = con.prepareStatement(sql);
        ps.executeUpdate();
        return true;
    }
    //通过编号查找
    public Product findByid(Connection con,String id) throws SQLException {
        String sql = "select * from Fac_product where Pro_id = '"+id+"'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        Product pro = new Product();

        if(rs.next()){
            int Pro_id = rs.getInt(1);
            String Pro_name = rs.getString(2);
            String Pro_type = rs.getString(3);
            int Pro_father = rs.getInt(4);
            int Pro_price = rs.getInt(5);
            int Pro_now = rs.getInt(6);

            pro.setPro_id(Pro_id);pro.setPro_name(Pro_name);pro.setPro_type(Pro_type);
            pro.setPro_father(Pro_father);pro.setPro_price(Pro_price);pro.setPro_now(Pro_now);
        }

        return pro;
    }
    //通过姓名查找
    public List<Product> findByName(Connection con,String name, int id) throws SQLException {
        String sql = "select * from Fac_product where Pro_father = '"+id+"' and Pro_name like '%"+name+"%'";
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
    //通过类型查找
    public List<Product> findByType(Connection con,String type, int id) throws SQLException {
        String sql = "select * from Fac_product where Pro_father = '"+id+"' and Pro_type like '%"+type+"%'";
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
    //通过价格查找
    public List<Product> findByprice(Connection con,String price, int id) throws SQLException {
        String sql = "select * from Fac_product where Pro_father = '"+id+"' and Pro_price = '"+price+"'";
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
    //所有的全部的产品
    public List<Product> findAllPro(Connection con) throws SQLException {
        String sql = "select Pro_id,Pro_name,Pro_type,Pro_father,Pro_price,Pro_now,Fac_name from Fac_product,Factory " +
                "where Pro_father = Fac_id";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<Product> list = new ArrayList<>();

        while (rs.next()){
            int Pro_id = rs.getInt(1);
            String Pro_name = rs.getString(2);
            String Pro_type = rs.getString(3);
            int Pro_father = rs.getInt(4);
            int Pro_price = rs.getInt(5);
            int Pro_now = rs.getInt(6);
            String Pro_father2 = rs.getString(7);
            Product pro = new Product();
            pro.setPro_id(Pro_id);pro.setPro_name(Pro_name);pro.setPro_type(Pro_type);
            pro.setPro_father(Pro_father);pro.setPro_price(Pro_price);pro.setPro_now(Pro_now);
            pro.setPro_father2(Pro_father2);
            list.add(pro);
        }
        return list;
    }

    public Product findAllProByid(Connection con,String id) throws SQLException {
        String sql = "select Pro_id,Pro_name,Pro_type,Pro_father,Pro_price,Pro_now,Fac_name from Fac_product,Factory " +
                "where Pro_father = Fac_id and Pro_id = '"+id+"'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        Product pro = new Product();

        if(rs.next()){
            int Pro_id = rs.getInt(1);
            String Pro_name = rs.getString(2);
            String Pro_type = rs.getString(3);
            int Pro_father = rs.getInt(4);
            int Pro_price = rs.getInt(5);
            int Pro_now = rs.getInt(6);
            String Pro_father2 = rs.getString(7);
            pro.setPro_id(Pro_id);pro.setPro_name(Pro_name);pro.setPro_type(Pro_type);
            pro.setPro_father(Pro_father);pro.setPro_price(Pro_price);pro.setPro_now(Pro_now);
            pro.setPro_father2(Pro_father2);
        }
        return pro;
    }

    public List<Product> findAllProByName(Connection con,String name) throws SQLException {
        String sql = "select Pro_id,Pro_name,Pro_type,Pro_father,Pro_price,Pro_now,Fac_name from Fac_product,Factory " +
                "where Pro_father = Fac_id and Pro_name like '%"+name+"%'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<Product> list = new ArrayList<>();

        while (rs.next()){
            int Pro_id = rs.getInt(1);
            String Pro_name = rs.getString(2);
            String Pro_type = rs.getString(3);
            int Pro_father = rs.getInt(4);
            int Pro_price = rs.getInt(5);
            int Pro_now = rs.getInt(6);
            String Pro_father2 = rs.getString(7);
            Product pro = new Product();
            pro.setPro_id(Pro_id);pro.setPro_name(Pro_name);pro.setPro_type(Pro_type);
            pro.setPro_father(Pro_father);pro.setPro_price(Pro_price);pro.setPro_now(Pro_now);
            pro.setPro_father2(Pro_father2);
            list.add(pro);
        }
        return list;
    }

    public List<Product> findAllProByType(Connection con,String type) throws SQLException {
        String sql = "select Pro_id,Pro_name,Pro_type,Pro_father,Pro_price,Pro_now,Fac_name from Fac_product,Factory " +
                "where Pro_father = Fac_id and Pro_type like '%"+type+"%'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<Product> list = new ArrayList<>();

        while (rs.next()){
            int Pro_id = rs.getInt(1);
            String Pro_name = rs.getString(2);
            String Pro_type = rs.getString(3);
            int Pro_father = rs.getInt(4);
            int Pro_price = rs.getInt(5);
            int Pro_now = rs.getInt(6);
            String Pro_father2 = rs.getString(7);
            Product pro = new Product();
            pro.setPro_id(Pro_id);pro.setPro_name(Pro_name);pro.setPro_type(Pro_type);
            pro.setPro_father(Pro_father);pro.setPro_price(Pro_price);pro.setPro_now(Pro_now);
            pro.setPro_father2(Pro_father2);
            list.add(pro);
        }
        return list;
    }

    public List<Product> findAllProByPrice(Connection con,String price) throws SQLException {
        String sql = "select Pro_id,Pro_name,Pro_type,Pro_father,Pro_price,Pro_now,Fac_name from Fac_product,Factory " +
                "where Pro_father = Fac_id and Pro_price = '"+price+"'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<Product> list = new ArrayList<>();

        while (rs.next()){
            int Pro_id = rs.getInt(1);
            String Pro_name = rs.getString(2);
            String Pro_type = rs.getString(3);
            int Pro_father = rs.getInt(4);
            int Pro_price = rs.getInt(5);
            int Pro_now = rs.getInt(6);
            String Pro_father2 = rs.getString(7);
            Product pro = new Product();
            pro.setPro_id(Pro_id);pro.setPro_name(Pro_name);pro.setPro_type(Pro_type);
            pro.setPro_father(Pro_father);pro.setPro_price(Pro_price);pro.setPro_now(Pro_now);
            pro.setPro_father2(Pro_father2);
            list.add(pro);
        }
        return list;
    }

    public List<Product> findAllProByfather2(Connection con,String father2) throws SQLException {
        String sql = "select Pro_id,Pro_name,Pro_type,Pro_father,Pro_price,Pro_now,Fac_name from Fac_product,Factory " +
                "where Pro_father = Fac_id and Fac_name like '%"+father2+"%'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<Product> list = new ArrayList<>();

        while (rs.next()){
            int Pro_id = rs.getInt(1);
            String Pro_name = rs.getString(2);
            String Pro_type = rs.getString(3);
            int Pro_father = rs.getInt(4);
            int Pro_price = rs.getInt(5);
            int Pro_now = rs.getInt(6);
            String Pro_father2 = rs.getString(7);
            Product pro = new Product();
            pro.setPro_id(Pro_id);pro.setPro_name(Pro_name);pro.setPro_type(Pro_type);
            pro.setPro_father(Pro_father);pro.setPro_price(Pro_price);pro.setPro_now(Pro_now);
            pro.setPro_father2(Pro_father2);
            list.add(pro);
        }
        return list;
    }
}
