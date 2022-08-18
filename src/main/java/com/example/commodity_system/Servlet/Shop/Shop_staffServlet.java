package com.example.commodity_system.Servlet.Shop;

import com.example.commodity_system.Dao.ShopDao;
import com.example.commodity_system.Dao.StaDao;
import com.example.commodity_system.Model.Sta;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "Shop_staffServlet", value = "/Shop_staff")
public class Shop_staffServlet extends HttpServlet {
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
        ShopDao op_shop = new ShopDao();
        StaDao op_sta = new StaDao();
        String flag = request.getParameter("flag");
        int id = (int) request.getSession().getAttribute("login_id");

        try {
            if (Objects.equals(flag,"0")){
                List<Sta> list = op_sta.findAllStaff(con,id);
                request.setAttribute("shop_sta_all",list);
            }
            else {
                String search = request.getParameter("value");
                if (search == "") {
                    List<Sta> list = op_sta.findAllStaff(con,id);
                    request.setAttribute("shop_sta_all",list);
                }
                else {
                    List<Sta> list = op_sta.findAllStaffByName(con,search,id);
                    request.setAttribute("shop_sta_all",list);
                }
            }
            request.getRequestDispatcher("Shop_staff.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
