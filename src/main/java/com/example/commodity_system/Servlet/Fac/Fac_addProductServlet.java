package com.example.commodity_system.Servlet.Fac;

import com.example.commodity_system.Dao.FacDao;
import com.example.commodity_system.Dao.ProDao;
import com.example.commodity_system.Model.Fac;
import com.example.commodity_system.Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Fac_addProductServlet", value = "/Add_pro")
public class Fac_addProductServlet extends HttpServlet {
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
        Product pro = new Product();

        String pro_name = (String) request.getParameter("Pro_name");
        String pro_type = (String) request.getParameter("Pro_type");
        int pro_price = Integer.parseInt(request.getParameter("Pro_price"));
        pro.setPro_name(pro_name);
        pro.setPro_type(pro_type);
        pro.setPro_price(pro_price);
        pro.setPro_now(1);
        int id = (int) request.getSession().getAttribute("login_id");
        pro.setPro_father(id);

        ProDao proDao = new ProDao();
        try {
            proDao.insert(con,pro);
            FacDao op_fac = new FacDao();
            List<Product> list = op_fac.AllPro(con,id);
            request.getSession().setAttribute("pro_all",list);
            request.getRequestDispatcher("Fac_main.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
