package com.example.commodity_system.Servlet.Shop;

import com.example.commodity_system.Dao.ShopDao;
import com.example.commodity_system.Dao.StaDao;
import com.example.commodity_system.Model.Sta;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "Shop_findWorkServlet", value = "/Shop_findWork")
public class Shop_findWorkServlet extends HttpServlet {
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
        ShopDao op_shop = new ShopDao();
        StaDao op_sta = new StaDao();
        int id = (int) request.getSession().getAttribute("login_id");
        String staid = request.getParameter("val");
        String flag = request.getParameter("flag");

        try {

            if(Objects.equals(flag,"1")){   //应聘员工
                op_sta.updateShopByid(con,id,staid); //设置员工所在的商店
                op_sta.updateStaEmpAllZero(con,staid);//员工的其他应聘失效
                List<Sta> list = op_sta.findAllShop(con,id);
                request.setAttribute("searchSta_all",list);
            }
            else {                              //拒绝员工
                op_sta.updateStaEmpZero(con,id,staid);  //此条应聘失效
                List<Sta> list = op_sta.findAllShop(con,id);
                request.setAttribute("searchSta_all",list);
            }
            request.getRequestDispatcher("Shop_findWork.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
