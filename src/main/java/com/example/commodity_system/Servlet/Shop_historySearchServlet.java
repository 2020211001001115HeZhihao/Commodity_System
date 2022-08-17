package com.example.commodity_system.Servlet;

import com.example.commodity_system.Dao.HisDao;
import com.example.commodity_system.Model.History;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Shop_historySearchServlet", value = "/Shop_historySearch")
public class Shop_historySearchServlet extends HttpServlet {
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
        String key = request.getParameter("key");
        String search = request.getParameter("value");
        int id = (int) request.getSession().getAttribute("login_id");
        HisDao op_his = new HisDao();

        try {
            if (search == ""){
                List<History> list = op_his.findAllByShop(con,id);
                request.setAttribute("his_all",list);
                request.getRequestDispatcher("Shop_history.jsp").forward(request,response);
            }
            else if(key.equals("id")){
                List<History> list = op_his.findAllByShopHistoryid(con,search,id);
                request.setAttribute("his_all",list);
                request.getRequestDispatcher("Shop_history.jsp").forward(request,response);
            }
            else if(key.equals("name")){
                List<History> list = op_his.findAllByShopGoodsName(con,search,id);
                request.setAttribute("his_all",list);
                request.getRequestDispatcher("Shop_history.jsp").forward(request,response);
            }
            else if(key.equals("type")){
                List<History> list = op_his.findAllByShopGoodsType(con,search,id);
                request.setAttribute("his_all",list);
                request.getRequestDispatcher("Shop_history.jsp").forward(request,response);
            }
            else if(key.equals("factory")){
                List<History> list = op_his.findAllByShopFactoryName(con,search,id);
                request.setAttribute("his_all",list);
                request.getRequestDispatcher("Shop_history.jsp").forward(request,response);
            }
            else if(key.equals("human")){
                List<History> list = op_his.findAllByShopHuman(con,search,id);
                request.setAttribute("his_all",list);
                request.getRequestDispatcher("Shop_history.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
