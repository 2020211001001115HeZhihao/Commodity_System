package com.example.commodity_system.Servlet.Shop;

import com.example.commodity_system.Dao.ProDao;
import com.example.commodity_system.Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Shop_addGoods_firstServlet", value = "/Shop_addGoods_firstServlet")
public class Shop_addGoods_firstServlet extends HttpServlet {
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
        ProDao op_pro = new ProDao();
        try {
            List<Product> list = op_pro.findAllPro(con);
            request.getSession().setAttribute("addGoods",list);
            request.setAttribute("add_pro_page",1);
            request.getRequestDispatcher("Shop_addProduct.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
