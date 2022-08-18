package com.example.commodity_system.Servlet.Shop;

import com.example.commodity_system.Dao.GoodsDao;
import com.example.commodity_system.Dao.HisDao;
import com.example.commodity_system.Dao.ShopDao;
import com.example.commodity_system.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@WebServlet(name = "Shop_saleCartFinishServlet", value = "/Shop_saleCartFinishServlet")
public class Shop_saleCartFinishServlet extends HttpServlet {
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
        Cart2 cart =  (Cart2) request.getSession().getAttribute("cart2");
        Shop shop = (Shop) request.getSession().getAttribute("shop_all");
        ShopDao op_shop = new ShopDao();
        int id = (int) request.getSession().getAttribute("login_id");

        try {
                int sum = shop.getShop_money() + cart.getPrice();
                op_shop.updateMoney(con,sum,id);
                shop.setShop_money(sum);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        Date date = new Date();      // 获取当前时间
        String time = format.format(date);
        GoodsDao op_goods = new GoodsDao();
        HisDao op_his = new HisDao();

        try {
            int His_id = shop.getShop_number()+1;
            shop.setShop_number(His_id);
            op_shop.updateNumber(con,His_id,id);

            for(Map.Entry<String, Cartitem2> me: cart.getPromap().entrySet()){
                Cartitem2 cartitem = me.getValue();
                Goods goods = cartitem.getGoods();
                int number = cartitem.getNumber();
                int sum = cartitem.getPrice();
                int ans = goods.getGoods_number() - number;
                int goods_id = goods.getGoods_id();
                op_goods.updateNumber(con,ans,goods_id);
                if (Objects.equals(ans,0)){
                    op_goods.updateNow(con,0,goods_id);
                }
                goods.setGoods_number(ans);
                //记录交易记录
                int His_shopid = id; String His_shopname = shop.getShop_name();
                int His_goodsid = goods.getGoods_id();String His_goodsname = goods.getGoods_name();
                String His_goodstype = goods.getGoods_type();int His_goodsnumber = number;
                int His_price = sum;String His_time = time;

                int sta_header = (int) request.getSession().getAttribute("sta_header");
                String His_human = shop.getShop_boss();
                if(sta_header == 1){
                    Sta sta = (Sta) request.getSession().getAttribute("sta_all");
                    His_human = sta.getSta_name();
                }

                int His_fromid = goods.getGoods_from();
                String His_fromname = goods.getGoods_from2();int His_type = 2;
                History his = new History(His_id,His_shopid,His_shopname,His_goodsid,His_goodsname,
                        His_goodstype,His_goodsnumber,His_price,His_time,His_human,His_fromid,His_fromname,His_type);
                op_his.insert(con,his);
            }
            List<Goods> list = op_shop.findAllByid(con,id);
            request.getSession().setAttribute("goods_all",list);
            cart.getPromap().clear();
            request.setAttribute("shopmain_page",1);
            request.getRequestDispatcher("Shop_main.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
