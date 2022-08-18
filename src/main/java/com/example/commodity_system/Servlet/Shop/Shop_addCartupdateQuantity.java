package com.example.commodity_system.Servlet.Shop;

import com.example.commodity_system.Model.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "Shop_addCartupdateQuantity", value = "/Shop_addCartupdateQuantity")
public class Shop_addCartupdateQuantity extends HttpServlet {
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
        String quantity = request.getParameter("quantity");
        Cart cart =(Cart) request.getSession().getAttribute("cart");

        cart.getPromap().get(id).setNumber(Integer.parseInt(quantity));
        response.sendRedirect("Shop_addListCart.jsp");
    }
}
