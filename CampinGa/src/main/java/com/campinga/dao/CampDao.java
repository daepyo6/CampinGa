package com.campinga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.campinga.dto.CampingVO;
import com.campinga.util.Dbman;

public class CampDao {
	private CampDao() {}
	private static CampDao itc = new CampDao();
	public static CampDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<CampingVO> selectCategory(String category) {
		ArrayList<CampingVO> list = new ArrayList<CampingVO>();
		con = Dbman.getConnection();
		String sql = "select*from camping where category=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CampingVO cvo = new CampingVO();
				cvo.setBseq(rs.getInt("bseq"));
				cvo.setCseq(rs.getInt("cseq"));
				cvo.setC_class(rs.getString("c_class"));
				cvo.setCategory(rs.getString("category"));
				cvo.setCname(rs.getString("cname"));
				cvo.setFacilities(rs.getString("facilities"));
				cvo.setImage(rs.getString("image"));
				cvo.setMax_people(rs.getInt("max_people"));
				cvo.setMin_people(rs.getInt("min_people"));
				cvo.setPrice(rs.getInt("price"));
				cvo.setRes_sta(rs.getString("res_sta"));
				list.add(cvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);}		
		return list;
	}

	public ArrayList<CampingVO> selectName(String key) {
		ArrayList<CampingVO> list = new ArrayList<CampingVO>();
		con = Dbman.getConnection();
		String sql = "select*from camping where cname like '%'||?||'%'";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CampingVO cvo = new CampingVO();
				cvo.setBseq(rs.getInt("bseq"));
				cvo.setCseq(rs.getInt("cseq"));
				cvo.setC_class(rs.getString("c_class"));
				cvo.setCategory(rs.getString("category"));
				cvo.setCname(rs.getString("cname"));
				cvo.setFacilities(rs.getString("facilities"));
				cvo.setImage(rs.getString("image"));
				cvo.setMax_people(rs.getInt("max_people"));
				cvo.setMin_people(rs.getInt("min_people"));
				cvo.setPrice(rs.getInt("price"));
				cvo.setRes_sta(rs.getString("res_sta"));
				list.add(cvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);			
		}
		System.out.println(rs!=null);
		return list;
	}
}
