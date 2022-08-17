package com.example.commodity_system.Model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart2 {
    Map<String,Cartitem2> promap = new LinkedHashMap<>();
    int price;//合计价格

    public void addGoods(Goods goods){
        String id = String.valueOf(goods.getGoods_id());
        Cartitem2 cartitem2 = promap.get(id);
        if (cartitem2 == null){
            cartitem2 = new Cartitem2();
            cartitem2.setGoods(goods);
            cartitem2.setNumber(1);
            promap.put(id,cartitem2);
        }
        else {
            cartitem2.setNumber(cartitem2.getNumber()+1);
        }
    }
    public Map<String, Cartitem2> getPromap() {
        return promap;
    }

    public void setPromap(Map<String, Cartitem2> promap) {
        this.promap = promap;
    }

    public int getPrice() {
        int sum = 0;
        for(Map.Entry<String,Cartitem2> me:promap.entrySet()){
            Cartitem2 cartitem2 = me.getValue();
            sum += cartitem2.getPrice();
        }
        return sum;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
