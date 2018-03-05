package com.hiynn.test.dao;

import java.util.List;

import com.hiynn.test.pojo.JzxManage;

public interface PoiTestDao {

    void insertInfoBatch(List<JzxManage> list);

    List<Object> selectApartInfo();

    List<Object> selectApartInfoId(List<String> id);
}
