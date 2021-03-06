package com.lzy.o2o.dao;

import com.lzy.o2o.BestTest;
import com.lzy.o2o.entity.Area;
import com.lzy.o2o.entity.PersonInfo;
import com.lzy.o2o.entity.Shop;
import com.lzy.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

public class ShopDaoTest extends BestTest {

    @Autowired
    private ShopDao shopDao;

    @Test
    public void insertShop() {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();

        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);

        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("test");
        shop.setShopDesc("TEST");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");

        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1,effectedNum);
    }

    @Test
    public void update(){
        Shop shop = new Shop();
        shop.setShopId(1l);
        shop.setShopDesc("test");

        int effectedNum = shopDao.updateShop(shop);
        assertEquals(1,effectedNum);
    }
}