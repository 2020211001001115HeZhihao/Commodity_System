package com.example.commodity_system.Servlet;

import com.example.commodity_system.Model.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "Shop_addCartdeleteServlet", value = "/Shop_addCartdeleteServlet")
public class Shop_addCartdeleteServlet extends HttpServlet {
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
        try {
            cart.getPromap().remove(id);
            request.getRequestDispatcher("Shop_addListCart.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
