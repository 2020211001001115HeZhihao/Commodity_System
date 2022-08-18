package com.example.commodity_system.Servlet.Shop;

import com.example.commodity_system.Model.Cart;
import com.example.commodity_system.Model.Cart2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "Shop_saleCartdeleteServlet", value = "/Shop_saleCartdeleteServlet")
public class Shop_saleCartdeleteServlet extends HttpServlet {
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
        Cart2 cart = (Cart2) request.getSession().getAttribute("cart2");
        try {
            cart.getPromap().remove(id);
            request.getRequestDispatcher("Shop_saleListCart.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
