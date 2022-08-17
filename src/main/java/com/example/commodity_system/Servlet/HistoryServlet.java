package com.example.commodity_system.Servlet;

import com.example.commodity_system.Dao.GoodsDao;
import com.example.commodity_system.Dao.HisDao;
import com.example.commodity_system.Model.History;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

        try {

            if (flag.equals("shop")){
                List<History> list = op_his.findAllByShop(con,id);
                request.setAttribute("his_all",list);
                request.getRequestDispatcher("Shop_history.jsp").forward(request,response);
            }
            else if(flag.equals("factory")){
                List<History> list = op_his.findAllByFac(con,id);
                request.setAttribute("his_all",list);
                request.getRequestDispatcher("Fac_history.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
