package com.example.commodity_system.Servlet.Shop;

import com.example.commodity_system.Dao.ProDao;
import com.example.commodity_system.Model.Cart;
import com.example.commodity_system.Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "Shop_addCartServlet", value = "/Shop_addCartServlet")
public class Shop_addCartServlet extends HttpServlet {
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
        String id = request.getParameter("id");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        ProDao op_pro = new ProDao();
        try {
            Product product = op_pro.findAllProByid(con,id);
            cart.addProduct(product);
            request.getRequestDispatcher("Shop_addListCart.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
