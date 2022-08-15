package com.example.commodity_system.Servlet;

import com.example.commodity_system.Dao.StaDao;
import com.example.commodity_system.Model.Sta;
import com.example.commodity_system.Model.Sta;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "Sta_changeServlet", value = "/Change_sta")
public class Sta_changeServlet extends HttpServlet {
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
        Sta sta = new Sta();
        sta = (Sta) request.getSession().getAttribute("sta_all");

        String Sta_name = (String) request.getParameter("Sta_name");
        String Sta_address = (String) request.getParameter("Sta_address");
        String Sta_sex = (String) request.getParameter("Sta_sex");
        String Sta_phone = (String) request.getParameter("Sta_phone");
        String Sta_message = (String) request.getParameter("Sta_message");
        sta.setSta_name(Sta_name);sta.setSta_address(Sta_address);
        sta.setSta_phone(Sta_phone);sta.setSta_message(Sta_message);
        sta.setSta_sex(Sta_sex);

        StaDao op_sta = new StaDao();
        try {
            op_sta.updateAll(con,sta);
            request.getSession().setAttribute("sta_all",sta);
            request.getRequestDispatcher("Sta_my.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
