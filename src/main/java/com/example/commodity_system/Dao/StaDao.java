package com.example.commodity_system.Dao;

import com.example.commodity_system.Model.Sta;
import com.example.commodity_system.Model.Sta;
import com.example.commodity_system.Model.Sta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaDao {
    //新建账号
    public boolean insert(Connection con, Sta sta) throws SQLException {
        int Sta_id = sta.getSta_id();
        String Sta_name = sta.getSta_name();
        String Sta_address = sta.getSta_address();
        String Sta_phone = sta.getSta_phone();
        String Sta_message = sta.getSta_message();
        String Sta_sex = sta.getSta_sex();
        int Sta_shop = sta.getSta_shop();
        String sql = "insert into Staff values('"+Sta_id+"','"+Sta_name+"','"
                +Sta_phone+"','"+Sta_sex+"','"+Sta_address+"','"+Sta_shop+"','"
                +Sta_message+"')";
        System.out.println(sql);
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
    public boolean updateAll(Connection con, Sta sta) throws SQLException {
        int Sta_id = sta.getSta_id();
        String Sta_name = sta.getSta_name();
        String Sta_address = sta.getSta_address();
        String Sta_sex = sta.getSta_sex();
        String Sta_phone = sta.getSta_phone();
        String Sta_message = sta.getSta_message();
        int Sta_shop = sta.getSta_shop();
        String sql = "update Staff set Sta_name='"+Sta_name+"',Sta_address='"+Sta_address+
                "',Sta_sex='"+Sta_sex+"',Sta_shop='"+Sta_shop+"',Sta_phone='"+
                Sta_phone+"',Sta_message='"+Sta_message+
                "' where Sta_id='"+ Sta_id+"'";
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
        
    //查找id的账号
    public Sta findByid(Connection con, int id) throws SQLException {
        String sql = "select * from Staff where Sta_id = '"+id+"'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        Sta sta = null;
        if(rs.next()){
            sta = new Sta();
            sta.setSta_id(rs.getInt("Sta_id"));
            sta.setSta_name(rs.getString("Sta_name"));
            sta.setSta_address(rs.getString("Sta_address"));
            sta.setSta_sex(rs.getString("Sta_sex"));
            sta.setSta_shop(rs.getInt("Sta_shop"));
            sta.setSta_phone(rs.getString("Sta_phone"));
            sta.setSta_message(rs.getString("Sta_message"));
        }
        return sta;
    }
}
