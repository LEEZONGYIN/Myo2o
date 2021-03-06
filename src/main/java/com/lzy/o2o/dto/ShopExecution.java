package com.lzy.o2o.dto;

import com.lzy.o2o.entity.Shop;
import com.lzy.o2o.enums.ShopStateEnum;
import lombok.Data;

import java.util.List;

@Data
public class ShopExecution {

    //结果状态
    private int state;

    //状态标识
    private String stateInfo;

    //店铺数量
    private int  count;

    //操作的shop(增删改店铺的时候用
    private Shop shop;

    //shop列表（查询店铺列表的时候使用）
    private List<Shop> shopList;

    public ShopExecution(){

    }

    //店铺操作失败的时候使用的构造器
    public ShopExecution(ShopStateEnum shopStateEnum){
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
    }

    //店铺操作成功的时候使用的构造器
    public ShopExecution(ShopStateEnum shopStateEnum,Shop shop){
        this.state  = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
        this.shop = shop;
    }

    //店铺操作成功的时候使用的构造器
    public ShopExecution(ShopStateEnum shopStateEnum,List<Shop> shopList){
        this.state  = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
        this.shopList = shopList;
    }

}
