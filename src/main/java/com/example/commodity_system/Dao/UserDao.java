package com.example.commodity_system.Dao;

import com.example.commodity_system.Model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
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

}
