package com.example.commodity_system.Servlet;

import com.example.commodity_system.Dao.FacDao;
import com.example.commodity_system.Dao.ProDao;
import com.example.commodity_system.Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "delProServlet", value = "/delProServlet")
public class delProServlet extends HttpServlet {
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
        try {
            ProDao op_pro = new ProDao();
            op_pro.delByid(con,id);
            FacDao op_fac = new FacDao();
            int idd = (int) request.getSession().getAttribute("login_id");
            List<Product> list = op_fac.AllPro(con,idd);
            request.getSession().setAttribute("pro_all",list);
            request.setAttribute("facmain_page",1);
            request.getRequestDispatcher("Fac_main.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
