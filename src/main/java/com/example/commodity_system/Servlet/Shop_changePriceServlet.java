package com.example.commodity_system.Servlet;

import com.example.commodity_system.Dao.GoodsDao;
import com.example.commodity_system.Dao.ShopDao;
import com.example.commodity_system.Model.Goods;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Shop_changePriceServlet", value = "/Shop_changePriceServlet")
public class Shop_changePriceServlet extends HttpServlet {
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
        String sum = request.getParameter("bn");
        String id = request.getParameter("bi");
        int idd = (int) request.getSession().getAttribute("login_id");
        GoodsDao op_goods = new GoodsDao();
        ShopDao op_shop = new ShopDao();

        try {
            op_goods.updatePrice(con,sum,id);
            List<Goods> list = op_shop.findAllByid(con,idd);
            request.getSession().setAttribute("goods_all",list);
            response.sendRedirect("Shop_main.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
