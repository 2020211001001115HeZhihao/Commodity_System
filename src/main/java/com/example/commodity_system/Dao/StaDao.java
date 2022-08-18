package com.example.commodity_system.Dao;

import com.example.commodity_system.Model.Shop;
import com.example.commodity_system.Model.Sta;
import com.example.commodity_system.Model.Sta;
import com.example.commodity_system.Model.Sta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public boolean updateShopByid(Connection con,int shopid,String staid) throws SQLException {
        String sql = "update Staff set Sta_shop='"+shopid+"' where Sta_id='"+ staid+"'";
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

    public boolean updateStaEmpAllZero(Connection con,String staid) throws SQLException {
        String sql = "update Staff_employ set Emp_now= '0' where Emp_staffid='"+ staid+"'";
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

    public boolean updateStaEmpZero(Connection con,int shopid,String staid) throws SQLException {
        String sql = "update Staff_employ set Emp_now= '0' where Emp_staffid='"+ staid+
                "' and Emp_shopid ='"+shopid+"'";
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

    public boolean FindWork(Connection con, String sta_id,String shop_id) throws SQLException {
        String sql = "insert into Staff_employ values ('"+sta_id+"','"+shop_id+"','" +1+"')";
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

    public boolean ifFindByid(Connection con, String sta_id,String shop_id) throws SQLException {
        String sql = "select * from Staff_employ where Emp_staffid = '"+sta_id+"' and Emp_shopid = '"+
                shop_id+"' and Emp_now = '1'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        if(rs.next()){
            return true;
        }
        return false;
    }

    public List<Sta> findAllStaff(Connection con ,int id) throws SQLException {
        String sql = "select * from Staff where Sta_shop = '"+id+ "'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<Sta> list =  new ArrayList<>();
        while (rs.next()){
            int Sta_id = rs.getInt("Sta_id");
            String Sta_name = rs.getString("Sta_name");
            String Sta_phone = rs.getString("Sta_phone");
            String Sta_sex = rs.getString("Sta_sex");
            String Sta_address = rs.getString("Sta_address");
            int Sta_shop = rs.getInt("Sta_shop");
            String Sta_message = rs.getString("Sta_message");

            Sta sta = new Sta(Sta_id,Sta_name,Sta_phone,Sta_sex,Sta_address,Sta_shop,Sta_message);
            list.add(sta);
        }
        return list;
    }

    public List<Sta> findAllStaffByName(Connection con ,String search,int id) throws SQLException {
        String sql = "select * from Staff where Sta_shop = '"+id+ "' and Sta_name like '%"+search+"%'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<Sta> list =  new ArrayList<>();
        while (rs.next()){
            int Sta_id = rs.getInt("Sta_id");
            String Sta_name = rs.getString("Sta_name");
            String Sta_phone = rs.getString("Sta_phone");
            String Sta_sex = rs.getString("Sta_sex");
            String Sta_address = rs.getString("Sta_address");
            int Sta_shop = rs.getInt("Sta_shop");
            String Sta_message = rs.getString("Sta_message");

            Sta sta = new Sta(Sta_id,Sta_name,Sta_phone,Sta_sex,Sta_address,Sta_shop,Sta_message);
            list.add(sta);
        }
        return list;
    }


    public List<Sta> findAllShop(Connection con ,int id) throws SQLException {
        String sql = "select * from Staff_employ,Staff where Emp_Shopid = '"+id+
                "' and Emp_now = '1' and Emp_staffid = Sta_id";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<Sta> list =  new ArrayList<>();
        while (rs.next()){
            int Sta_id = rs.getInt("Sta_id");
            String Sta_name = rs.getString("Sta_name");
            String Sta_phone = rs.getString("Sta_phone");
            String Sta_sex = rs.getString("Sta_sex");
            String Sta_address = rs.getString("Sta_address");
            int Sta_shop = rs.getInt("Sta_shop");
            String Sta_message = rs.getString("Sta_message");

            Sta sta = new Sta(Sta_id,Sta_name,Sta_phone,Sta_sex,Sta_address,Sta_shop,Sta_message);
            list.add(sta);
        }
        return list;
    }

    public List<Sta> findAllShopByName(Connection con ,String search,int id) throws SQLException {
        String sql = "select * from Staff_employ,Staff where Emp_Shopid = '"+id+
                "' and Emp_now = '1' and Emp_staffid = Sta_id and Sta_name like '%"+search+"%'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<Sta> list =  new ArrayList<>();
        while (rs.next()){
            int Sta_id = rs.getInt("Sta_id");
            String Sta_name = rs.getString("Sta_name");
            String Sta_phone = rs.getString("Sta_phone");
            String Sta_sex = rs.getString("Sta_sex");
            String Sta_address = rs.getString("Sta_address");
            int Sta_shop = rs.getInt("Sta_shop");
            String Sta_message = rs.getString("Sta_message");

            Sta sta = new Sta(Sta_id,Sta_name,Sta_phone,Sta_sex,Sta_address,Sta_shop,Sta_message);
            list.add(sta);
        }
        return list;
    }

}
