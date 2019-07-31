package com.niliv.service.impl;

import java.util.List;

import com.niliv.dao.AreaDao;
import com.niliv.dao.impl.AreaDaoImpl;
import com.niliv.pojo.Area;
import com.niliv.service.AreaService;

public class AreaServiceImpl implements AreaService {

	AreaDao ad = new AreaDaoImpl();
	
	@Override
	public List<Area> getAreaInfoService(String pid) {
		
		return ad.getAreaInfoDao(pid);
	}

	@Override
	public List<Area> getAreaInfoByNameService(String areaName,String parentId) {
		
		return ad.getAreaInfoByNameDao(areaName,parentId);
	}

}
