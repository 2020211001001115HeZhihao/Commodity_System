package com.example.commodity_system.Servlet;

import com.example.commodity_system.Dao.FacDao;
import com.example.commodity_system.Dao.ShopDao;
import com.example.commodity_system.Dao.StaDao;
import com.example.commodity_system.Dao.UserDao;
import com.example.commodity_system.Model.Fac;
import com.example.commodity_system.Model.Shop;
import com.example.commodity_system.Model.Sta;
import com.example.commodity_system.Model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = "/index_register")
public class RegisterServlet extends HttpServlet {
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
        //接受表单数据
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        int type = Integer.parseInt(request.getParameter("type"));
        //新建User对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setType(type);

        UserDao op = new UserDao();
        try {
            if(op.ifHaveUsername(con,username)){    //输入的账号重名
                request.setAttribute("usernameError","账号已存在");
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }
            else {
                op.insert(con,user);
                int id = op.findIdByUsername(con, username);
                request.getSession().setAttribute("login_id",id);
                request.getSession().setAttribute("login_name",user.getUsername());
                request.getSession().setAttribute("login_type",user.getType());
                if(type == 1){
                    Shop shop = new Shop();
                    shop.setShop_id(id);
                    shop.setShop_name("商店");
                    shop.setShop_money(0);
                    shop.setShop_number(0);
                    shop.setShop_goods(0);
                    ShopDao op_shop = new ShopDao();
                    op_shop.insert(con,shop);
                    request.getSession().setAttribute("shop_all",shop);
                    request.getRequestDispatcher("Shop_change.jsp").forward(request,response);
                }
                else if(type == 2){
                    Fac fac = new Fac();
                    fac.setFac_id(id);
                    fac.setFac_name("厂商");
                    fac.setFac_goods(0);
                    FacDao op_fac = new FacDao();
                    op_fac.insert(con,fac);
                    request.getSession().setAttribute("fac_all",fac);
                    request.getRequestDispatcher("Fac_change.jsp").forward(request,response);
                }
                else if(type == 3){
                    Sta sta = new Sta();
                    sta.setSta_id(id);
                    sta.setSta_name("员工");
                    sta.setSta_sex("男");
                    sta.setSta_shop(0);
                    StaDao op_sta = new StaDao();
                    System.out.println(sta.toString());
                    op_sta.insert(con,sta);
                    request.getSession().setAttribute("sta_all",sta);
                    request.getRequestDispatcher("Sta_change.jsp").forward(request,response);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
