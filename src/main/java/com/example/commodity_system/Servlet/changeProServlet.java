package com.example.commodity_system.Servlet;

import com.example.commodity_system.Dao.ProDao;
import com.example.commodity_system.Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "changeProServlet", value = "/changeProServlet")
public class changeProServlet extends HttpServlet {
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

        ProDao op_pro = new ProDao();
        try {
            Product pro = op_pro.findByid(con,id);
            request.getSession().setAttribute("changePro",pro);
            request.getRequestDispatcher("Fac_ProChange.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
