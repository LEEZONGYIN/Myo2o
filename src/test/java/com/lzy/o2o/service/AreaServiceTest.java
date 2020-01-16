package com.lzy.o2o.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.lzy.o2o.BestTest;
import com.lzy.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class AreaServiceTest extends BestTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void getAreaList() {
        List<Area> list = areaService.getAreaList();
        assertEquals(2,list.size());
    }
}