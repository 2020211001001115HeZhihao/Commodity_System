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

@WebServlet(name = "Shop_staffDelServlet", value = "/Shop_staffDel")
public class Shop_staffDelServlet extends HttpServlet {
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
        int id = (int) request.getSession().getAttribute("login_id");
        String staid = request.getParameter("val");

        try {

                op_sta.updateShopByid(con,0,staid); //设置员工所在的商店
                List<Sta> list = op_sta.findAllStaff(con,id);
                request.setAttribute("shop_sta_all",list);

            request.getRequestDispatcher("Shop_staff.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
