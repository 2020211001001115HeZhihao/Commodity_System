package com.example.commodity_system.Servlet;

import com.example.commodity_system.Dao.ShopDao;
import com.example.commodity_system.Model.Shop;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "Shop_changeServlet", value = "/Change_shop")
public class Shop_changeServlet extends HttpServlet {
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
        Shop shop = new Shop();
        shop = (Shop) request.getSession().getAttribute("shop_all");

        String Shop_name = (String) request.getParameter("Shop_name");
        String Shop_address = (String) request.getParameter("Shop_address");
        String Shop_boss = (String) request.getParameter("Shop_boss");
        String Shop_bossp = (String) request.getParameter("Shop_bossp");
        String Shop_phone = (String) request.getParameter("Shop_phone");
        String Shop_message = (String) request.getParameter("Shop_message");
        int Shop_money = Integer.parseInt(request.getParameter("Shop_money"));
        shop.setShop_name(Shop_name);shop.setShop_address(Shop_address);
        shop.setShop_boss(Shop_boss);shop.setShop_bossp(Shop_bossp);
        shop.setShop_phone(Shop_phone);shop.setShop_message(Shop_message);
        shop.setShop_money(Shop_money);
        ShopDao op_shop = new ShopDao();
        try {
            op_shop.updateAll(con,shop);
            request.getSession().setAttribute("shop_all",shop);
            request.getRequestDispatcher("Shop_my.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
