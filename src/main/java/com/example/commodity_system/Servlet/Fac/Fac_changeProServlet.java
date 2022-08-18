package com.example.commodity_system.Servlet.Fac;

import com.example.commodity_system.Dao.FacDao;
import com.example.commodity_system.Dao.ProDao;
import com.example.commodity_system.Model.Product;
import com.example.commodity_system.Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Pro_changeProServlet", value = "/Change_pro")
public class Fac_changeProServlet extends HttpServlet {
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
        Product pro = (Product) request.getSession().getAttribute("changePro");

        String Pro_name = (String) request.getParameter("Pro_name");
        String Pro_type = (String) request.getParameter("Pro_type");
        int Pro_price = Integer.parseInt(request.getParameter("Pro_price"));
        pro.setPro_name(Pro_name);pro.setPro_type(Pro_type);
        pro.setPro_price(Pro_price);

        ProDao op_pro = new ProDao();
        try {
            op_pro.updatePro(con,pro);
            int id = (int) request.getSession().getAttribute("login_id");
            FacDao op_fac = new FacDao();
            List<Product> list = op_fac.AllPro(con,id);
            request.getSession().setAttribute("pro_all",list);
            request.getRequestDispatcher("Fac_main.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
