package com.example.commodity_system.Servlet;

import com.example.commodity_system.Dao.GoodsDao;
import com.example.commodity_system.Dao.ProDao;
import com.example.commodity_system.Model.Cart;
import com.example.commodity_system.Model.Cart2;
import com.example.commodity_system.Model.Goods;
import com.example.commodity_system.Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "Shop_saleCartServlet", value = "/Shop_saleCartServlet")
public class Shop_saleCartServlet extends HttpServlet {
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
        int id = Integer.parseInt(request.getParameter("id"));
        Cart2 cart = (Cart2) request.getSession().getAttribute("cart2");
        if (cart == null) {
            cart = new Cart2();
            request.getSession().setAttribute("cart2", cart);
        }
        GoodsDao op_goods = new GoodsDao();
        try {
            Goods goods = op_goods.findByGoodsid(con,id);
            cart.addGoods(goods);
            request.getRequestDispatcher("Shop_saleListCart.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
