package com.example.commodity_system.Dao;

import com.example.commodity_system.Model.Goods;
import com.example.commodity_system.Model.Shop;
import com.example.commodity_system.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopDao {
    //新建账号
    public boolean insert(Connection con, Shop shop) throws SQLException {
        int Shop_id = shop.getShop_id();
        String Shop_name = shop.getShop_name();
        String Shop_address = shop.getShop_address();
        String Shop_boss = shop.getShop_boss();
        String Shop_bossp = shop.getShop_bossp();
        String Shop_phone = shop.getShop_phone();
        String Shop_message = shop.getShop_message();
        int Shop_money = shop.getShop_money();
        int Shop_number = shop.getShop_number();
        int Shop_goods = shop.getShop_goods();
        String sql = "insert into Shop values('"+Shop_id+"','"+Shop_name+"','"+Shop_address+
                "','"+Shop_boss+"','"+Shop_bossp+"','"+Shop_phone+"','"+Shop_message+"','"
                +Shop_money+"','"+Shop_number+"','"+Shop_goods+"')";
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
    public boolean updateAll(Connection con, Shop shop) throws SQLException {
        int Shop_id = shop.getShop_id();
        String Shop_name = shop.getShop_name();
        String Shop_address = shop.getShop_address();
        String Shop_boss = shop.getShop_boss();
        String Shop_bossp = shop.getShop_bossp();
        String Shop_phone = shop.getShop_phone();
        String Shop_message = shop.getShop_message();
        int Shop_money = shop.getShop_money();
        int Shop_number = shop.getShop_number();
        int Shop_goods = shop.getShop_goods();
        String sql = "update Shop set Shop_name='"+Shop_name+"',Shop_address='"+Shop_address+
                "',Shop_boss='"+Shop_boss+"',Shop_bossp='"+Shop_bossp+"',Shop_phone='"+
                Shop_phone+"',Shop_message='"+Shop_message+"',Shop_money='"+Shop_money+
                "',Shop_number='"+Shop_number+"',Shop_goods='"+Shop_goods+"' where Shop_id='"+
                Shop_id+"'";
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
    //修改资金
    public boolean updateMoney(Connection con,int sum, int id) throws SQLException {
        String sql = "update Shop set Shop_money='"+sum+ "' where Shop_id='"+ id+"'";
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
    //修改账单数量
    public boolean updateNumber(Connection con,int sum, int id) throws SQLException {
        String sql = "update Shop set Shop_number='"+sum+ "' where Shop_id='"+ id+"'";
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
    //通过id寻找个体
    public Shop findByid(Connection con,int id) throws SQLException {
        String sql = "select * from Shop where Shop_id = '"+id+"'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        Shop shop = null;
        if(rs.next()){
            shop = new Shop();
            shop.setShop_id(rs.getInt("Shop_id"));
            shop.setShop_name(rs.getString("Shop_name"));
            shop.setShop_address(rs.getString("Shop_address"));
            shop.setShop_boss(rs.getString("Shop_boss"));
            shop.setShop_bossp(rs.getString("Shop_bossp"));
            shop.setShop_phone(rs.getString("Shop_phone"));
            shop.setShop_message(rs.getString("Shop_message"));
            shop.setShop_money(rs.getInt("Shop_money"));
            shop.setShop_number(rs.getInt("Shop_number"));
            shop.setShop_goods(rs.getInt("Shop_goods"));
        }
        return shop;
    }

    public List<Shop> findAllShop(Connection con) throws SQLException {
        String sql = "select * from Shop";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<Shop> list =  new ArrayList<>();
        while (rs.next()){
            int Shop_id = rs.getInt("Shop_id");
            String Shop_name = rs.getString("Shop_name");
            String Shop_address = rs.getString("Shop_address");
            String Shop_boss = rs.getString("Shop_boss");
            String Shop_bossp = rs.getString("Shop_bossp");
            String Shop_phone = rs.getString("Shop_phone");
            String Shop_message = rs.getString("Shop_message");
            int Shop_money = rs.getInt("Shop_money");
            int Shop_number = rs.getInt("Shop_number");
            int Shop_goods = rs.getInt("Shop_goods");
            Shop shop = new Shop(Shop_id,Shop_name,Shop_address,Shop_boss,Shop_bossp,Shop_phone,Shop_message,Shop_money
            ,Shop_number,Shop_goods);
            list.add(shop);
        }
        return list;
    }

    public List<Shop> findAllShopName(Connection con,String search) throws SQLException {
        String sql = "select * from Shop where Shop_name like '%"+search+"%'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<Shop> list =  new ArrayList<>();
        while (rs.next()){
            int Shop_id = rs.getInt("Shop_id");
            String Shop_name = rs.getString("Shop_name");
            String Shop_address = rs.getString("Shop_address");
            String Shop_boss = rs.getString("Shop_boss");
            String Shop_bossp = rs.getString("Shop_bossp");
            String Shop_phone = rs.getString("Shop_phone");
            String Shop_message = rs.getString("Shop_message");
            int Shop_money = rs.getInt("Shop_money");
            int Shop_number = rs.getInt("Shop_number");
            int Shop_goods = rs.getInt("Shop_goods");
            Shop shop = new Shop(Shop_id,Shop_name,Shop_address,Shop_boss,Shop_bossp,Shop_phone,Shop_message,Shop_money
                    ,Shop_number,Shop_goods);
            list.add(shop);
        }
        return list;
    }
    //通过id寻找全部
    public List<Goods> findAllByid(Connection con, int id) throws SQLException {
        String sql = "select * from Shop_goods where Goods_father = '"+id+"' order by Goods_now desc";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<Goods> list =  new ArrayList<>();
        while (rs.next()){
            int Goods_id = rs.getInt(1);
            String Goods_name = rs.getString(2);
            String Goods_type = rs.getString(3);
            int Goods_number = rs.getInt(4);
            int Goods_price = rs.getInt(5);
            int Goods_father = rs.getInt(6);
            int Goods_now = rs.getInt(7);
            int Goods_from = rs.getInt(8);
            String Goods_from2 = rs.getString(9);
            Goods goods = new Goods(Goods_id,Goods_name,Goods_type,Goods_number,Goods_price,
                    Goods_father,Goods_now,Goods_from,Goods_from2);
            list.add(goods);
        }
        return list;
    }
}
