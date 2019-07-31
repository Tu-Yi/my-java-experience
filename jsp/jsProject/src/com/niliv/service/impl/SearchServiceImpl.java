package com.niliv.service.impl;

import java.util.List;

import com.niliv.dao.SearchDao;
import com.niliv.dao.impl.SearchDaoImpl;
import com.niliv.pojo.Data;
import com.niliv.service.SearchService;
import com.sun.xml.internal.ws.api.server.SDDocument;

public class SearchServiceImpl implements SearchService {
	
	SearchDao sd = new SearchDaoImpl();

	@Override
	public List<Data> getSearchInfoService(String sdata) {
		
		return sd.getSearchInfoDao(sdata);
	}

}
