package com.example.commodity_system.Servlet.Fac;

import com.example.commodity_system.Dao.HisDao;
import com.example.commodity_system.Model.History;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Fac_historySearchServlet", value = "/Fac_historySearch")
public class Fac_historySearchServlet extends HttpServlet {
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
                List<History> list = op_his.findAllByFac(con,id);
                request.getSession().setAttribute("his_all",list);
                request.setAttribute("fac_history_page",1);
                request.getRequestDispatcher("Fac_history.jsp").forward(request,response);
            }
            else if(key.equals("name")){
                List<History> list = op_his.findAllByShopFacGoodsName(con,search,id);
                request.getSession().setAttribute("his_all",list);
                request.setAttribute("fac_history_page",1);
                request.getRequestDispatcher("Fac_history.jsp").forward(request,response);
            }
            else if(key.equals("type")){
                List<History> list = op_his.findAllByShopFacGoodsType(con,search,id);
                request.getSession().setAttribute("his_all",list);
                request.setAttribute("fac_history_page",1);
                request.getRequestDispatcher("Fac_history.jsp").forward(request,response);
            }
            else if(key.equals("shop")){
                List<History> list = op_his.findAllByShopFacShopName(con,search,id);
                request.getSession().setAttribute("his_all",list);
                request.setAttribute("fac_history_page",1);
                request.getRequestDispatcher("Fac_history.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
