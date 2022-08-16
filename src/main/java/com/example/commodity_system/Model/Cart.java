package com.example.commodity_system.Model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    Map<String,Cartitem> promap = new LinkedHashMap<>();
    int price;//合计价格

    public void addProduct(Product product){
        String id = String.valueOf(product.getPro_id());
        Cartitem cartitem = promap.get(id);
        if (cartitem == null){
            cartitem = new Cartitem();
            cartitem.setProduct(product);
            cartitem.setNumber(1);
            promap.put(id,cartitem);
        }
        else {
            cartitem.setNumber(cartitem.getNumber()+1);
        }
    }
    public Map<String, Cartitem> getPromap() {
        return promap;
    }

    public void setPromap(Map<String, Cartitem> promap) {
        this.promap = promap;
    }

    public int getPrice() {
        int sum = 0;
        for(Map.Entry<String,Cartitem> me:promap.entrySet()){
            Cartitem cartitem = me.getValue();
            sum += cartitem.getPrice();
        }
        return sum;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
