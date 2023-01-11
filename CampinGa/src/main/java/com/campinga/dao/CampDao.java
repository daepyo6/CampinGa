package com.campinga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.campinga.dto.BusinessmanVO;
import com.campinga.dto.CampingVO;
import com.campinga.util.Dbman;
import com.campinga.util.Paging;

public class CampDao {
	private CampDao() {
	}

	private static CampDao itc = new CampDao();

	public static CampDao getInstance() {
		return itc;
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ArrayList<BusinessmanVO> selectCategory(String category) {
		ArrayList<BusinessmanVO> list = new ArrayList<BusinessmanVO>();
		con = Dbman.getConnection();
		String sql = "SELECT bseq, cname, category, facilities, caddress1, caddress2, caddress3, phone, image"
				+ " FROM businessman where category=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BusinessmanVO bmvo = new BusinessmanVO();
				bmvo.setBseq(rs.getInt("bseq"));
				bmvo.setCategory(rs.getString("category"));
				bmvo.setCname(rs.getString("cname"));
				bmvo.setFacilities(rs.getString("facilities"));
				bmvo.setCaddress1(rs.getString("caddress1"));
				bmvo.setCaddress2(rs.getString("caddress2"));
				bmvo.setCaddress3(rs.getString("caddress3"));
				bmvo.setImage(rs.getString("image"));
				bmvo.setPhone(rs.getString("phone"));
				list.add(bmvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public ArrayList<BusinessmanVO> selectName(String key) {
		ArrayList<BusinessmanVO> list = new ArrayList<BusinessmanVO>();
		con = Dbman.getConnection();
		String sql = "SELECT bseq, cname, category, facilities, caddress1, caddress2, caddress3, phone, image"
				+ " FROM businessman where cname like '%'||?||'%'";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BusinessmanVO bmvo = new BusinessmanVO();
				bmvo.setBseq(rs.getInt("bseq"));
				bmvo.setCategory(rs.getString("category"));
				bmvo.setCname(rs.getString("cname"));
				bmvo.setFacilities(rs.getString("facilities"));
				bmvo.setCaddress1(rs.getString("caddress1"));
				bmvo.setCaddress2(rs.getString("caddress2"));
				bmvo.setCaddress3(rs.getString("caddress3"));
				bmvo.setImage(rs.getString("image"));
				bmvo.setPhone(rs.getString("phone"));
				list.add(bmvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public ArrayList<BusinessmanVO> selectAll() {
		ArrayList<BusinessmanVO> list = new ArrayList<BusinessmanVO>();
		con = Dbman.getConnection();
		String sql = "SELECT bseq, cname, category, facilities, caddress1, caddress2, caddress3, phone, image"
				+ " FROM businessman";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BusinessmanVO bmvo = new BusinessmanVO();
				bmvo.setBseq(rs.getInt("bseq"));
				bmvo.setCategory(rs.getString("category"));
				bmvo.setCname(rs.getString("cname"));
				bmvo.setFacilities(rs.getString("facilities"));
				bmvo.setCaddress1(rs.getString("caddress1"));
				bmvo.setCaddress2(rs.getString("caddress2"));
				bmvo.setCaddress3(rs.getString("caddress3"));
				bmvo.setImage(rs.getString("image"));
				bmvo.setPhone(rs.getString("phone"));
				list.add(bmvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public ArrayList<BusinessmanVO> selectCamping(Paging paging) {
		ArrayList<BusinessmanVO> list = new ArrayList<BusinessmanVO>();
		con = Dbman.getConnection();
		String sql = "select * from ( "
					+ "select * from ("
					+ "select rownum as rn, b.* from ((select * from businessman) b)) "
					+ "where rn>=?) "
					+ "where rn<=?";	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2, paging.getEndNum());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BusinessmanVO cvo = new BusinessmanVO();
				cvo.setBseq(rs.getInt("bseq"));
				cvo.setCname(rs.getString("cname"));
				cvo.setCaddress1(rs.getString("caddress1"));
				cvo.setCaddress2(rs.getString("caddress2"));
				cvo.setCaddress3(rs.getString("caddress3"));
				cvo.setPhone(rs.getString("phone"));
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public ArrayList<CampingVO> selectCampingList(int bseq) {
		ArrayList<CampingVO> list = new ArrayList<CampingVO>();
		con = Dbman.getConnection();
		String sql = "select * from camping_view where bseq=? order by cseq desc";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CampingVO cvo = new CampingVO();
				cvo.setCseq(rs.getInt("cseq"));
				cvo.setBseq(rs.getInt("bseq"));
				cvo.setCname(rs.getString("cname"));
				cvo.setFacilities(rs.getString("facilities"));
				cvo.setC_image(rs.getString("c_image"));
				cvo.setC_content(rs.getString("c_content"));
				cvo.setCategory(rs.getString("category"));
				cvo.setC_class(rs.getString("c_class"));
				cvo.setRes_sta(rs.getString("res_sta"));
				cvo.setPrice(rs.getInt("price"));
				cvo.setMin_people(rs.getInt("min_people"));
				cvo.setMax_people(rs.getInt("max_people"));
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public ArrayList<BusinessmanVO> selectNewCampList() {
		ArrayList<BusinessmanVO> list = new ArrayList<BusinessmanVO>();
		con = Dbman.getConnection();
		String sql = "select bseq, cname, content, image from "
					+ "(select * from businessman order by bseq desc) "
					+ "where rownum<=4";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BusinessmanVO bmvo = new BusinessmanVO();
				bmvo.setBseq(rs.getInt("bseq"));
				bmvo.setCname(rs.getString("cname"));
				bmvo.setContent(rs.getString("content"));
				bmvo.setImage(rs.getString("image"));
				list.add(bmvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}
	
	public ArrayList<BusinessmanVO> selectRecoCampList() {
		ArrayList<BusinessmanVO> list = new ArrayList<BusinessmanVO>();
		con = Dbman.getConnection();
		String sql = "select bseq, cname, content, image from "
				+ "(select * from businessman order by bseq desc) "
				+ "where rownum<=8";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BusinessmanVO bmvo = new BusinessmanVO();
				bmvo.setBseq(rs.getInt("bseq"));
				bmvo.setCname(rs.getString("cname"));
				bmvo.setContent(rs.getString("content"));
				bmvo.setImage(rs.getString("image"));
				list.add(bmvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public ArrayList<BusinessmanVO> selectAddress(String address1, String address2) {
		ArrayList<BusinessmanVO> list = new ArrayList<BusinessmanVO>();
		con = Dbman.getConnection();
		String sql = "select * from("
					+ "select * from("
					+ "SELECT * FROM businessman)"
					+ "where caddress1 like '%'||?||'%')"
					+ "where caddress2 like '%'||?||'%'";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address1);
			pstmt.setString(2, address2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BusinessmanVO bmvo = new BusinessmanVO();
				bmvo.setBseq(rs.getInt("bseq"));
				bmvo.setCategory(rs.getString("category"));
				bmvo.setCname(rs.getString("cname"));
				bmvo.setFacilities(rs.getString("facilities"));
				bmvo.setCaddress1(rs.getString("caddress1"));
				bmvo.setCaddress2(rs.getString("caddress2"));
				bmvo.setCaddress3(rs.getString("caddress3"));
				bmvo.setImage(rs.getString("image"));
				bmvo.setPhone(rs.getString("phone"));
				list.add(bmvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public CampingVO selectOne(int bseq) {
		CampingVO cvo = null;
		con = Dbman.getConnection();
		String sql = "select * from (select * from camping_view where ROWID "
				+ "IN (SELECT MAX(ROWID) FROM camping_view GROUP BY bseq)) where bseq=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cvo = new CampingVO();
				cvo.setBseq(rs.getInt("bseq"));
				cvo.setCategory(rs.getString("category"));
				cvo.setCname(rs.getString("cname"));
				cvo.setFacilities(rs.getString("facilities"));
				cvo.setCaddress1(rs.getString("caddress1"));
				cvo.setCaddress2(rs.getString("caddress2"));
				cvo.setCaddress3(rs.getString("caddress3"));
				cvo.setC_content(rs.getString("c_content"));
				cvo.setImage(rs.getString("image"));
				cvo.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return cvo;
	}

	public void deleteBusinessman(int bseq) {
		String sql = "delete from businessman where bseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
	}
  
	public void insertList(BusinessmanVO bmvo) {
		
		String sql = " insert into businessman (cseq, cname, caddress1, caddress2, caddress3, category, facilities) " 
		+ " values(camping_seq.nextval, ? , ? , ? , ? , ? , ?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bmvo.getCname());
			pstmt.setString(2, bmvo.getCaddress1());
			pstmt.setString(3, bmvo.getCaddress2());
			pstmt.setString(4, bmvo.getCaddress3());
			pstmt.setString(5, bmvo.getCategory());
			pstmt.setString(6, bmvo.getFacilities());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
	         Dbman.close(con, pstmt, rs);
	    }
		
	}

	public CampingVO selectOneInfo(int cseq) {
		CampingVO cvo = null;
		con = Dbman.getConnection();
		String sql = "select * from camping where cseq=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cseq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cvo = new CampingVO();
				cvo.setCseq(rs.getInt("cseq"));
				cvo.setBseq(rs.getInt("bseq"));
				cvo.setCname(rs.getString("cname"));
				cvo.setC_class(rs.getString("c_class"));
				cvo.setPrice(rs.getInt("price"));
				cvo.setMin_people(rs.getInt("min_people"));
				cvo.setMax_people(rs.getInt("max_people"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return cvo;
	}

	public int getAllCount() {
		int count = 0;
		con = Dbman.getConnection();
		String sql = "select count(*) as cnt from businessman";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt("cnt");
		} catch (SQLException e) { e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs);
		}
		return count;
	}

	public void updateCampingList(BusinessmanVO bmvo) {
		// TODO Auto-generated method stub
		
	}

	public void deleteCampingRoom(int cseq) {
		String sql = "delete from camping where cseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cseq);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}		
	}
}
