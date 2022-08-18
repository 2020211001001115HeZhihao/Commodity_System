package com.example.commodity_system.Servlet.Shop;

import com.example.commodity_system.Model.Cart;
import com.example.commodity_system.Model.Cart2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.Objects;

@WebServlet(name = "Shop_saleCartupdateQuantity", value = "/Shop_saleCartupdateQuantity")
public class Shop_saleCartupdateQuantity extends HttpServlet {
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
        Cart2 cart =(Cart2) request.getSession().getAttribute("cart2");
        int sum = cart.getPromap().get(id).getGoods().getGoods_number();
        int sum2 = Integer.parseInt(quantity);
        if(sum < sum2){
            request.setAttribute("add_message","操作无效,数量超出库存");
            request.getRequestDispatcher("Shop_saleListCart.jsp").forward(request,response);
        }
        else {
            cart.getPromap().get(id).setNumber(sum2);
            response.sendRedirect("Shop_saleListCart.jsp");
        }

    }
}
