package com.niliv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.niliv.dao.AreaDao;
import com.niliv.pojo.Area;
import com.niliv.util.DBUtil;

public class AreaDaoImpl implements AreaDao {

	@Override
	public List<Area> getAreaInfoDao(String pid) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Area> areas = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from area where parentid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, pid);
			rs=ps.executeQuery();
			areas = new ArrayList<>();
			while(rs.next()) {
				Area area=new Area();
				area.setAreaid(rs.getInt("areaid"));
				area.setAreaname(rs.getString("areaname"));
				area.setParentid(rs.getInt("parentid"));
				area.setArealevel(rs.getInt("arealevel"));
				area.setStatus(rs.getInt("status"));
				areas.add(area);
			}
			System.out.println(areas);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return areas;
	}

	@Override
	public List<Area> getAreaInfoByNameDao(String areaName,String parentId) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Area> areas = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from area where (areaname like concat('%',?,'%') || spell like concat('%',?,'%')) and parentid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, areaName);
			ps.setString(2, areaName);
			ps.setString(3, parentId);
			rs=ps.executeQuery();
			areas = new ArrayList<>();
			while(rs.next()) {
				Area area=new Area();
				area.setAreaid(rs.getInt("areaid"));
				area.setAreaname(rs.getString("areaname"));
				area.setParentid(rs.getInt("parentid"));
				area.setArealevel(rs.getInt("arealevel"));
				area.setStatus(rs.getInt("status"));
				area.setSpell(rs.getString("spell"));
				areas.add(area);
			}
			System.out.println(areas);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return areas;
	}

}
