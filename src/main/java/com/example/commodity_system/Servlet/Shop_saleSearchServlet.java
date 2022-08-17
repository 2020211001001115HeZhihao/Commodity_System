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

@WebServlet(name = "Shop_saleSearchServlet", value = "/Shop_salesearch")
public class Shop_saleSearchServlet extends HttpServlet {
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
        String key = request.getParameter("key");
        String search = request.getParameter("value");
        ShopDao op_shop = new ShopDao();
        GoodsDao op_goods = new GoodsDao();

        int id = (int) request.getSession().getAttribute("login_id");
        try {
            if (search == "") {
                List<Goods> list = null;
                list = op_shop.findAllByid(con, id);
                request.getSession().setAttribute("goods_all",list);
                request.getRequestDispatcher("Shop_saleGoods.jsp").forward(request,response);
            }
            else if(key.equals("name")){
                List<Goods> list = null;
                list = op_goods.findAllByName(con,search,id);
                request.getSession().setAttribute("goods_all",list);
                request.getRequestDispatcher("Shop_saleGoods.jsp").forward(request,response);
            }
            else if(key.equals("type")){
                List<Goods> list = null;
                list = op_goods.findAllByType(con,search,id);
                request.getSession().setAttribute("goods_all",list);
                request.getRequestDispatcher("Shop_saleGoods.jsp").forward(request,response);
            }
            else if(key.equals("price")){
                List<Goods> list = null;
                list = op_goods.findAllByPrice(con,search,id);
                request.getSession().setAttribute("goods_all",list);
                request.getRequestDispatcher("Shop_saleGoods.jsp").forward(request,response);
            }
            else if(key.equals("factory")){
                List<Goods> list = null;
                list = op_goods.findAllByFrom2(con,search,id);
                request.getSession().setAttribute("goods_all",list);
                request.getRequestDispatcher("Shop_saleGoods.jsp").forward(request,response);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
