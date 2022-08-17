package com.example.commodity_system.Servlet;

import com.example.commodity_system.Dao.FacDao;
import com.example.commodity_system.Dao.ShopDao;
import com.example.commodity_system.Dao.StaDao;
import com.example.commodity_system.Dao.UserDao;
import com.example.commodity_system.Model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/index_login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    public void init()  {
        con = (Connection)getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = (String) request.getParameter("username");
        String pas = (String) request.getParameter("password");

        UserDao op = new UserDao();
        User user = null;
        try {
            user = op.findByUsername(con,name);
            if(user == null){
                request.setAttribute("usernameError","账号不存在");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
            else if(!user.getPassword().equals(pas)){
                request.setAttribute("passwordError","密码错误");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
            else {  int type = user.getType();
                    int id = user.getUser_id();
                request.getSession().setAttribute("login_id",id);
                request.getSession().setAttribute("login_name",name);
                request.getSession().setAttribute("login_type",type);

                if(type == 1){
                    ShopDao op_shop = new ShopDao();
                    Shop shop = op_shop.findByid(con,id);
                    request.getSession().setAttribute("shop_all",shop);
                    List<Goods> list = op_shop.findAllByid(con,id);
                    request.getSession().setAttribute("goods_all",list);
                    request.getRequestDispatcher("Shop_main.jsp").forward(request,response);
                }
                else if(type == 2){
                    FacDao op_fac = new FacDao();
                    Fac fac = op_fac.findByid(con,id);
                    request.getSession().setAttribute("fac_all",fac);
                    List<Product> list = op_fac.AllPro(con,id);
                    request.getSession().setAttribute("pro_all",list);
                    request.getRequestDispatcher("Fac_main.jsp").forward(request,response);
                }
                else if(type == 3){
                    request.getSession().setAttribute("staff_id",id);
                    StaDao op_sta = new StaDao();
                    Sta sta = op_sta.findByid(con,id);
                    request.getSession().setAttribute("sta_all",sta);
                    request.getRequestDispatcher("Sta_my.jsp").forward(request,response);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
