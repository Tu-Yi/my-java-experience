package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.IncomeDao;
import com.bjsxt.dao.impl.IncomDaoImpl;
import com.bjsxt.service.InOutService;

public class InOutServiceImpl implements InOutService {

	@Override
	public String getBarData() {
		//调用DAO层获取收入数据（List）
		IncomeDao  icDao = new IncomDaoImpl();
		List<Object []> list = icDao.findStaticsData();
		
		//将List转换成jsonStr 
		StringBuilder icTypeArr = new StringBuilder("[");//['Mon1', 'Tue2', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
		StringBuilder amountArr = new StringBuilder("[");//[120, 200, 1500, 800, 70, 110, 130]
		for(int i=0;i<list.size();i++){
			Object [] arr = list.get(i);// {项目开发,400}
			if(i<list.size()-1){
				icTypeArr.append("\""+arr[0]+"\",");
				amountArr.append(arr[1]+",");
			}else{
				icTypeArr.append("\""+arr[0]+"\"");
				amountArr.append(arr[1]);
			}
		}
		icTypeArr.append("]");
		amountArr.append("]");
		
		//"[['Mon1', 'Tue2', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],[120, 200, 1500, 800, 70, 110, 130]]";
		String jsonStr = "["+icTypeArr.toString()+","+amountArr.toString()+"]";
		//返回jsonStr
		return jsonStr;
	}

}
