package com.niliv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.niliv.dao.SearchDao;
import com.niliv.pojo.Area;
import com.niliv.pojo.Data;
import com.niliv.util.DBUtil;

public class SearchDaoImpl implements SearchDao {

	@Override
	public List<Data> getSearchInfoDao(String sdata) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Data> datas = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_data where title like concat(?,'%')";
			ps=conn.prepareStatement(sql);
			ps.setString(1, sdata);
			rs=ps.executeQuery();
			datas = new ArrayList<>();
			while(rs.next()) {
				Data data=new Data();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setRemark(rs.getString("remark"));
				datas.add(data);
			}
			System.out.println(datas);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return datas;
	}

}
