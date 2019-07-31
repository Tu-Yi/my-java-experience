package com.niliv.service;

import java.util.List;

import com.niliv.pojo.Area;

public interface AreaService {

	List<Area> getAreaInfoService(String pid);

	List<Area> getAreaInfoByNameService(String areaName, String parentId);

}
