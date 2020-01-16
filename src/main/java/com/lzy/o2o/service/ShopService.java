package com.lzy.o2o.service;

import com.lzy.o2o.dto.ShopExecution;
import com.lzy.o2o.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


public interface ShopService {
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);
}
