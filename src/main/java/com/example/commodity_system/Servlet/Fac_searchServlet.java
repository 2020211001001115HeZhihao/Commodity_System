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

@WebServlet(name = "Fac_searchServlet", value = "/Fac_search")
public class Fac_searchServlet extends HttpServlet {
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
        FacDao op_fac = new FacDao();
        ProDao op_pro = new ProDao();
        int id = (int) request.getSession().getAttribute("login_id");
        try {
            if (search == "") {
                List<Product> list = null;
                list = op_fac.AllPro(con, id);
                request.getSession().setAttribute("pro_all",list);
                request.getRequestDispatcher("Fac_main.jsp").forward(request,response);
            }
            else if(key.equals("name")){
                List<Product> list = null;
                list = op_pro.findByName(con,search,id);
                request.getSession().setAttribute("pro_all",list);
                request.getRequestDispatcher("Fac_main.jsp").forward(request,response);
            }
            else if(key.equals("type")){
                List<Product> list = null;
                list = op_pro.findByType(con,search,id);
                request.getSession().setAttribute("pro_all",list);
                request.getRequestDispatcher("Fac_main.jsp").forward(request,response);
            }
            else if(key.equals("price")){
                List<Product> list = null;
                list = op_pro.findByprice(con,search,id);
                request.getSession().setAttribute("pro_all",list);
                request.getRequestDispatcher("Fac_main.jsp").forward(request,response);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
