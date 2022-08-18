package com.example.commodity_system.Servlet.Shop;

import com.example.commodity_system.Model.Cart;
import com.example.commodity_system.Model.Cart2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.Objects;

@WebServlet(name = "Shop_saleCartupdateNumsServlet", value = "/Shop_saleCartupdateNumsServlet")
public class Shop_saleCartupdateNumsServlet extends HttpServlet {
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
        String symbol = request.getParameter("symbol");
        Cart2 cart = (Cart2) request.getSession().getAttribute("cart2");

        if ("add".equals(symbol)){
            int sum = cart.getPromap().get(id).getGoods().getGoods_number();
            if(Objects.equals(sum,cart.getPromap().get(id).getNumber())){
                request.setAttribute("add_message","操作无效,数量超出库存");
                request.getRequestDispatcher("Shop_saleListCart.jsp").forward(request,response);
            }
            else cart.getPromap().get(id).setNumber(cart.getPromap().get(id).getNumber()+1);
        }else if ("sub".equals(symbol)){
            int fan = cart.getPromap().get(id).getNumber()-1;
            if (Objects.equals(fan,0)){//如果删除后数量为---0
                cart.getPromap().remove(id);
            }else {
                cart.getPromap().get(id).setNumber(cart.getPromap().get(id).getNumber()-1);
            }
        }
        response.sendRedirect("Shop_saleListCart.jsp");
    }
}
