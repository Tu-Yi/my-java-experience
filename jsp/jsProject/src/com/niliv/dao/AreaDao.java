package com.niliv.dao;

import java.util.List;

import com.niliv.pojo.Area;

public interface AreaDao {

	List<Area> getAreaInfoDao(String pid);

	List<Area> getAreaInfoByNameDao(String areaName, String parentId);

}
