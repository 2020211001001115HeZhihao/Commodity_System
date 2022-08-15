package com.example.commodity_system.Servlet;

import com.example.commodity_system.Dao.FacDao;
import com.example.commodity_system.Model.Fac;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "Fac_changeServlet", value = "/Change_fac")
public class Fac_changeServlet extends HttpServlet {
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
        Fac fac = new Fac();
        fac = (Fac) request.getSession().getAttribute("fac_all");

        String Fac_name = (String) request.getParameter("Fac_name");
        String Fac_address = (String) request.getParameter("Fac_address");
        String Fac_boss = (String) request.getParameter("Fac_boss");
        String Fac_bossp = (String) request.getParameter("Fac_bossp");
        String Fac_phone = (String) request.getParameter("Fac_phone");
        String Fac_message = (String) request.getParameter("Fac_message");
        fac.setFac_name(Fac_name);fac.setFac_address(Fac_address);
        fac.setFac_boss(Fac_boss);fac.setFac_bossp(Fac_bossp);
        fac.setFac_phone(Fac_phone);fac.setFac_message(Fac_message);

        FacDao op_fac = new FacDao();
        try {
            op_fac.updateAll(con,fac);
            request.getSession().setAttribute("fac_all",fac);
            request.getRequestDispatcher("Fac_my.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
