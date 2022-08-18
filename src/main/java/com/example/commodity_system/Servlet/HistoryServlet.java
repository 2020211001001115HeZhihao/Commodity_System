package com.example.commodity_system.Servlet;

import com.example.commodity_system.Dao.*;
import com.example.commodity_system.Model.Goods;
import com.example.commodity_system.Model.History;
import com.example.commodity_system.Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "HistoryServlet", value = "/HistoryServlet")
public class HistoryServlet extends HttpServlet {
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
        String flag = request.getParameter("flag");
        int id = (int) request.getSession().getAttribute("login_id");
        HisDao op_his = new HisDao();
        ShopDao op_shop = new ShopDao();
        FacDao op_fac = new FacDao();
        String fir = request.getParameter("fir");
        int page = Integer.parseInt(request.getParameter("page"));
        try {
            if (flag.equals("shop")){

                if (Objects.equals(fir,"0")){
                    List<History> list = op_his.findAllByShop(con,id);
                    request.getSession().setAttribute("his_all",list);
                }
                request.setAttribute("shop_history_page",page);
                request.getRequestDispatcher("Shop_history.jsp").forward(request,response);
            }
            else if(flag.equals("factory")){
                if (Objects.equals(fir,"0")) {
                    List<History> list = op_his.findAllByFac(con, id);
                    request.getSession().setAttribute("his_all", list);
                }
                request.setAttribute("fac_history_page",page);
                request.getRequestDispatcher("Fac_history.jsp").forward(request,response);
            }
            else if(flag.equals("shopmain")){
                if (Objects.equals(fir,"0")) {
                    List<Goods> list = op_shop.findAllByid(con,id);
                    request.getSession().setAttribute("goods_all",list);
                }
                request.setAttribute("shopmain_page",page);
                request.getRequestDispatcher("Shop_main.jsp").forward(request,response);
            }
            else if(flag.equals("facmain")){
                if (Objects.equals(fir,"0")) {
                    List<Product> list = op_fac.AllPro(con, id);
                    request.getSession().setAttribute("pro_all",list);
                }
                request.setAttribute("facmain_page",page);
                request.getRequestDispatcher("Fac_main.jsp").forward(request,response);
            }
            else if(flag.equals("addProduct")){
                request.setAttribute("add_pro_page",page);
                request.getRequestDispatcher("Shop_addProduct.jsp").forward(request,response);
            }
            else if(flag.equals("saleProduct")){
                request.setAttribute("sale_goods_page",page);
                request.getRequestDispatcher("Shop_saleGoods.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
