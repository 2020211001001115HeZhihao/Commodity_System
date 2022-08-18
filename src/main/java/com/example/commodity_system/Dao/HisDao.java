package com.example.commodity_system.Dao;

import com.example.commodity_system.Model.History;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HisDao {
    public boolean insert(Connection con, History his) throws SQLException {
        int His_id = his.getHis_id();
        int His_shopid = his.getHis_shopid(); String His_shopname = his.getHis_shopname();
        int His_goodsid = his.getHis_goodsid();String His_goodsname = his.getHis_goodsname();
        String His_goodstype = his.getHis_goodstype();int His_goodsnumber = his.getHis_goodsnumber();
        int His_price = his.getHis_price();String His_time = his.getHis_time();
        String His_human = his.getHis_human();int His_fromid = his.getHis_fromid();
        String His_fromname = his.getHis_fromname();int His_type = his.getHis_type();
        String sql = "insert into Shop_history values('"+His_id+"','"+His_shopid+"','"
                +His_shopname+"','"+His_goodsid+"','"+His_goodsname+"','"+His_goodstype+"','"
                +His_goodsnumber+"','"+His_price+"','"+His_time+"','"+His_human+"','"+His_fromid+
                "','"+His_fromname+"','"+His_type+"')";
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

    public List<History> findAllByShop(Connection con,int id) throws SQLException {
        String sql = "select * from Shop_history where His_shopid = '"+id+"' order by His_time desc";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<History> list =  new ArrayList<>();
        while (rs.next()){
            int His_id = rs.getInt(1);
            int His_shopid = rs.getInt(2);
            String His_shopname = rs.getString(3);
            int His_goodsid = rs.getInt(4);
            String His_goodsname = rs.getString(5);
            String His_goodstype = rs.getString(6);
            int His_goodsnumber = rs.getInt(7);
            int His_price = rs.getInt(8);
            String His_time = rs.getString(9);
            String His_human = rs.getString(10);
            int His_fromid = rs.getInt(11);
            String His_fromname = rs.getString(12);
            int His_type = rs.getInt(13);
            History his = new History(His_id,His_shopid,His_shopname,His_goodsid,His_goodsname,
                    His_goodstype,His_goodsnumber,His_price,His_time,His_human,His_fromid,His_fromname,
                    His_type);
            list.add(his);
        }
        return list;
    }

    public List<History> findAllByShopHistoryid(Connection con,String search,int id) throws SQLException {
        String sql = "select * from Shop_history where His_shopid = '"+id+"' and His_id = '"+search+
                "' order by His_time desc";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<History> list =  new ArrayList<>();
        while (rs.next()){
            int His_id = rs.getInt(1);
            int His_shopid = rs.getInt(2);
            String His_shopname = rs.getString(3);
            int His_goodsid = rs.getInt(4);
            String His_goodsname = rs.getString(5);
            String His_goodstype = rs.getString(6);
            int His_goodsnumber = rs.getInt(7);
            int His_price = rs.getInt(8);
            String His_time = rs.getString(9);
            String His_human = rs.getString(10);
            int His_fromid = rs.getInt(11);
            String His_fromname = rs.getString(12);
            int His_type = rs.getInt(13);
            History his = new History(His_id,His_shopid,His_shopname,His_goodsid,His_goodsname,
                    His_goodstype,His_goodsnumber,His_price,His_time,His_human,His_fromid,His_fromname,
                    His_type);
            list.add(his);
        }
        return list;
    }

    public List<History> findAllByShopGoodsName(Connection con,String search,int id) throws SQLException {
        String sql = "select * from Shop_history where His_shopid = '"+id+"' and His_goodsname like '%"+search+
                "%' order by His_time desc";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<History> list =  new ArrayList<>();
        while (rs.next()){
            int His_id = rs.getInt(1);
            int His_shopid = rs.getInt(2);
            String His_shopname = rs.getString(3);
            int His_goodsid = rs.getInt(4);
            String His_goodsname = rs.getString(5);
            String His_goodstype = rs.getString(6);
            int His_goodsnumber = rs.getInt(7);
            int His_price = rs.getInt(8);
            String His_time = rs.getString(9);
            String His_human = rs.getString(10);
            int His_fromid = rs.getInt(11);
            String His_fromname = rs.getString(12);
            int His_type = rs.getInt(13);
            History his = new History(His_id,His_shopid,His_shopname,His_goodsid,His_goodsname,
                    His_goodstype,His_goodsnumber,His_price,His_time,His_human,His_fromid,His_fromname,
                    His_type);
            list.add(his);
        }
        return list;
    }

    public List<History> findAllByShopGoodsType(Connection con,String search,int id) throws SQLException {
        String sql = "select * from Shop_history where His_shopid = '"+id+"' and His_goodstype like '%"+search+
                "%' order by His_time desc";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<History> list =  new ArrayList<>();
        while (rs.next()){
            int His_id = rs.getInt(1);
            int His_shopid = rs.getInt(2);
            String His_shopname = rs.getString(3);
            int His_goodsid = rs.getInt(4);
            String His_goodsname = rs.getString(5);
            String His_goodstype = rs.getString(6);
            int His_goodsnumber = rs.getInt(7);
            int His_price = rs.getInt(8);
            String His_time = rs.getString(9);
            String His_human = rs.getString(10);
            int His_fromid = rs.getInt(11);
            String His_fromname = rs.getString(12);
            int His_type = rs.getInt(13);
            History his = new History(His_id,His_shopid,His_shopname,His_goodsid,His_goodsname,
                    His_goodstype,His_goodsnumber,His_price,His_time,His_human,His_fromid,His_fromname,
                    His_type);
            list.add(his);
        }
        return list;
    }

    public List<History> findAllByShopHuman(Connection con,String search,int id) throws SQLException {
        String sql = "select * from Shop_history where His_shopid = '"+id+"' and His_human like '%"+search+
                "%' order by His_time desc";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<History> list =  new ArrayList<>();
        while (rs.next()){
            int His_id = rs.getInt(1);
            int His_shopid = rs.getInt(2);
            String His_shopname = rs.getString(3);
            int His_goodsid = rs.getInt(4);
            String His_goodsname = rs.getString(5);
            String His_goodstype = rs.getString(6);
            int His_goodsnumber = rs.getInt(7);
            int His_price = rs.getInt(8);
            String His_time = rs.getString(9);
            String His_human = rs.getString(10);
            int His_fromid = rs.getInt(11);
            String His_fromname = rs.getString(12);
            int His_type = rs.getInt(13);
            History his = new History(His_id,His_shopid,His_shopname,His_goodsid,His_goodsname,
                    His_goodstype,His_goodsnumber,His_price,His_time,His_human,His_fromid,His_fromname,
                    His_type);
            list.add(his);
        }
        return list;
    }

    public List<History> findAllByShopFactoryName(Connection con,String search,int id) throws SQLException {
        String sql = "select * from Shop_history where His_shopid = '"+id+"' and His_fromname like '%"+search+
                "%' order by His_time desc";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<History> list =  new ArrayList<>();
        while (rs.next()){
            int His_id = rs.getInt(1);
            int His_shopid = rs.getInt(2);
            String His_shopname = rs.getString(3);
            int His_goodsid = rs.getInt(4);
            String His_goodsname = rs.getString(5);
            String His_goodstype = rs.getString(6);
            int His_goodsnumber = rs.getInt(7);
            int His_price = rs.getInt(8);
            String His_time = rs.getString(9);
            String His_human = rs.getString(10);
            int His_fromid = rs.getInt(11);
            String His_fromname = rs.getString(12);
            int His_type = rs.getInt(13);
            History his = new History(His_id,His_shopid,His_shopname,His_goodsid,His_goodsname,
                    His_goodstype,His_goodsnumber,His_price,His_time,His_human,His_fromid,His_fromname,
                    His_type);
            list.add(his);
        }
        return list;
    }

    public List<History> findAllByFac(Connection con,int id) throws SQLException {
        String sql = "select * from Shop_history where His_fromid = '"+id+"' and His_type = '1' order by His_time desc";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<History> list =  new ArrayList<>();
        while (rs.next()){
            int His_id = rs.getInt(1);
            int His_shopid = rs.getInt(2);
            String His_shopname = rs.getString(3);
            int His_goodsid = rs.getInt(4);
            String His_goodsname = rs.getString(5);
            String His_goodstype = rs.getString(6);
            int His_goodsnumber = rs.getInt(7);
            int His_price = rs.getInt(8);
            String His_time = rs.getString(9);
            String His_human = rs.getString(10);
            int His_fromid = rs.getInt(11);
            String His_fromname = rs.getString(12);
            int His_type = rs.getInt(13);
            History his = new History(His_id,His_shopid,His_shopname,His_goodsid,His_goodsname,
                    His_goodstype,His_goodsnumber,His_price,His_time,His_human,His_fromid,His_fromname,
                    His_type);
            list.add(his);
        }
        return list;
    }

    public List<History> findAllByShopFacGoodsName(Connection con,String search,int id) throws SQLException {
        String sql = "select * from Shop_history where His_fromid = '"+id+"' and His_goodsname like '%"+search+
                "%' and His_type = '1' order by His_time desc";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<History> list =  new ArrayList<>();
        while (rs.next()){
            int His_id = rs.getInt(1);
            int His_shopid = rs.getInt(2);
            String His_shopname = rs.getString(3);
            int His_goodsid = rs.getInt(4);
            String His_goodsname = rs.getString(5);
            String His_goodstype = rs.getString(6);
            int His_goodsnumber = rs.getInt(7);
            int His_price = rs.getInt(8);
            String His_time = rs.getString(9);
            String His_human = rs.getString(10);
            int His_fromid = rs.getInt(11);
            String His_fromname = rs.getString(12);
            int His_type = rs.getInt(13);
            History his = new History(His_id,His_shopid,His_shopname,His_goodsid,His_goodsname,
                    His_goodstype,His_goodsnumber,His_price,His_time,His_human,His_fromid,His_fromname,
                    His_type);
            list.add(his);
        }
        return list;
    }

    public List<History> findAllByShopFacGoodsType(Connection con,String search,int id) throws SQLException {
        String sql = "select * from Shop_history where His_fromid = '"+id+"' and His_goodstype like '%"+search+
                "%'  and His_type = '1' order by His_time desc";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<History> list =  new ArrayList<>();
        while (rs.next()){
            int His_id = rs.getInt(1);
            int His_shopid = rs.getInt(2);
            String His_shopname = rs.getString(3);
            int His_goodsid = rs.getInt(4);
            String His_goodsname = rs.getString(5);
            String His_goodstype = rs.getString(6);
            int His_goodsnumber = rs.getInt(7);
            int His_price = rs.getInt(8);
            String His_time = rs.getString(9);
            String His_human = rs.getString(10);
            int His_fromid = rs.getInt(11);
            String His_fromname = rs.getString(12);
            int His_type = rs.getInt(13);
            History his = new History(His_id,His_shopid,His_shopname,His_goodsid,His_goodsname,
                    His_goodstype,His_goodsnumber,His_price,His_time,His_human,His_fromid,His_fromname,
                    His_type);
            list.add(his);
        }
        return list;
    }

    public List<History> findAllByShopFacShopName(Connection con,String search,int id) throws SQLException {
        String sql = "select * from Shop_history where His_fromid = '"+id+"' and His_shopname like '%"+search+
                "%' and His_type = '1'  order by His_time desc";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<History> list =  new ArrayList<>();
        while (rs.next()){
            int His_id = rs.getInt(1);
            int His_shopid = rs.getInt(2);
            String His_shopname = rs.getString(3);
            int His_goodsid = rs.getInt(4);
            String His_goodsname = rs.getString(5);
            String His_goodstype = rs.getString(6);
            int His_goodsnumber = rs.getInt(7);
            int His_price = rs.getInt(8);
            String His_time = rs.getString(9);
            String His_human = rs.getString(10);
            int His_fromid = rs.getInt(11);
            String His_fromname = rs.getString(12);
            int His_type = rs.getInt(13);
            History his = new History(His_id,His_shopid,His_shopname,His_goodsid,His_goodsname,
                    His_goodstype,His_goodsnumber,His_price,His_time,His_human,His_fromid,His_fromname,
                    His_type);
            list.add(his);
        }
        return list;
    }


}
