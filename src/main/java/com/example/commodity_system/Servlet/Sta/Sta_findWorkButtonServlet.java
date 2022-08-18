package com.example.commodity_system.Servlet.Sta;

import com.example.commodity_system.Dao.ShopDao;
import com.example.commodity_system.Dao.StaDao;
import com.example.commodity_system.Model.Shop;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Sta_findWorkButtonServlet", value = "/Sta_findWorkButton")
public class Sta_findWorkButtonServlet extends HttpServlet {
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
        String shopid = request.getParameter("shop");
        String staid = request.getParameter("sta");
        StaDao op_sta = new StaDao();
        ShopDao op_shop = new ShopDao();

        try {
            if(op_sta.ifFindByid(con,staid,shopid)){
                List<Shop> list = op_shop.findAllShop(con);
                request.setAttribute("searchShop_all",list);
                request.getRequestDispatcher("Sta_findWork.jsp").forward(request,response);
                System.out.println(11);
            }
            else {
                op_sta.FindWork(con,staid,shopid);
                List<Shop> list = op_shop.findAllShop(con);
                request.setAttribute("searchShop_all",list);
                request.getRequestDispatcher("Sta_findWork.jsp").forward(request,response);
                System.out.println(22);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
