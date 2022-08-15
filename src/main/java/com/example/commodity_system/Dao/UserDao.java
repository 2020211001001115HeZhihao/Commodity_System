package com.example.commodity_system.Dao;

import com.example.commodity_system.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    //通过username查找整体
    public User findByUsername(Connection con,String username) throws SQLException {
        String sql = "select * from Login_user where Username = '"+username+"'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        User user = null;
        if(rs.next()){
            user = new User();
            user.setUser_id(rs.getInt("User_id"));
            user.setUsername(rs.getString("Username"));
            user.setPassword(rs.getString("Password"));
            user.setType(rs.getInt("Type"));
        }
        return user;
    }

    //通过username查找编号
    public int findIdByUsername(Connection con,String username) throws SQLException {
        String sql = "select User_id from Login_user where Username = '"+username+"'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        int id = 0;
        if(rs.next()){
           id = rs.getInt("User_id");
        }
        return id;
    }

    //新建账号
    public boolean insert(Connection con,User user) throws SQLException {
        String username = user.getUsername();
        String password = user.getPassword();
        int type = user.getType();
        String sql = "insert into Login_user values('"+username+"','"+password+"','"+type+"')";
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

    //是否存在username的账号
    public boolean ifHaveUsername(Connection con,String username) throws SQLException {
        String sql = "select * from Login_user where Username = '"+username+"'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        boolean ans = false;
        if(rs.next()){
            ans = true;
        }
        return ans;
    }
}
