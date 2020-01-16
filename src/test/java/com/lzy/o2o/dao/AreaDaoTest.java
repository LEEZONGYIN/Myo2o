package com.lzy.o2o.dao;

import com.lzy.o2o.BestTest;
import com.lzy.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class AreaDaoTest extends BestTest {
    @Autowired
    private AreaDao areaDao;
    @Test
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2,areaList.size());
    }
}