package com.example.commodity_system.Servlet.Shop;

import com.example.commodity_system.Dao.ShopDao;
import com.example.commodity_system.Model.Goods;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Shop_saleGoods_firstServlet", value = "/Shop_saleGoods_firstServlet")
public class Shop_saleGoods_firstServlet extends HttpServlet {
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
        int id = (int) request.getSession().getAttribute("login_id");

        try {
            List<Goods> list = op_shop.findAllByid(con,id);
            request.getSession().setAttribute("goods_all",list);
            request.getRequestDispatcher("Shop_saleGoods.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
