package com.example.commodity_system.Dao;

import com.example.commodity_system.Model.History;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
