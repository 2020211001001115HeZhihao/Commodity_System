package com.example.commodity_system.Servlet.Sta;

import com.example.commodity_system.Dao.ShopDao;
import com.example.commodity_system.Model.Shop;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "Sta_findWorkSearchServlet", value = "/Sta_findWorkSearch")
public class Sta_findWorkSearchServlet extends HttpServlet {
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
        ShopDao op_shop = new ShopDao();
        String flag = request.getParameter("flag");

        try {
            if (Objects.equals(flag,"0")){
                List<Shop> list = op_shop.findAllShop(con);
                request.setAttribute("searchShop_all",list);
            }
            else {
                String search = request.getParameter("value");
                if (search == "") {
                    List<Shop> list = op_shop.findAllShop(con);
                    request.setAttribute("searchShop_all",list);
                }
                else {
                    List<Shop> list = op_shop.findAllShopName(con,search);
                    request.setAttribute("searchShop_all",list);
                }
            }

            request.getRequestDispatcher("Sta_findWork.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
