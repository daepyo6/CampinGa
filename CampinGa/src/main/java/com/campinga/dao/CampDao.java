package com.campinga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.campinga.dto.CampingVO;
import com.campinga.util.Dbman;

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

	public ArrayList<CampingVO> selectCategory(String category) {
		ArrayList<CampingVO> list = new ArrayList<CampingVO>();
		con = Dbman.getConnection();
		String sql = "SELECT bseq, cname, category, facilities," + " caddress1, caddress2, caddress3, phone, image"
				+ " FROM camping_view where " + " ROWID IN (SELECT MAX(ROWID) FROM camping_view GROUP BY bseq)"
				+ "	and category=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CampingVO cvo = new CampingVO();
				cvo.setBseq(rs.getInt("bseq"));
				cvo.setCategory(rs.getString("category"));
				cvo.setCname(rs.getString("cname"));
				cvo.setFacilities(rs.getString("facilities"));
				cvo.setCaddress1(rs.getString("caddress1"));
				cvo.setCaddress2(rs.getString("caddress2"));
				cvo.setCaddress3(rs.getString("caddress3"));
				cvo.setImage(rs.getString("image"));
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

	public ArrayList<CampingVO> selectName(String key) {
		ArrayList<CampingVO> list = new ArrayList<CampingVO>();
		con = Dbman.getConnection();
		String sql = "SELECT bseq, cname, category, facilities," + " caddress1, caddress2, caddress3, phone, image"
				+ " FROM camping_view where ROWID " + " IN (SELECT MAX(ROWID) FROM camping_view GROUP BY bseq)"
				+ " and cname like '%'||?||'%'";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CampingVO cvo = new CampingVO();
				cvo.setBseq(rs.getInt("bseq"));
				cvo.setCategory(rs.getString("category"));
				cvo.setCname(rs.getString("cname"));
				cvo.setFacilities(rs.getString("facilities"));
				cvo.setCaddress1(rs.getString("caddress1"));
				cvo.setCaddress2(rs.getString("caddress2"));
				cvo.setCaddress3(rs.getString("caddress3"));
				cvo.setImage(rs.getString("image"));
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

	public ArrayList<CampingVO> selectAll() {
		ArrayList<CampingVO> list = new ArrayList<CampingVO>();
		con = Dbman.getConnection();
		String sql = "SELECT bseq, cname, category, facilities," + " caddress1, caddress2, caddress3, phone, image"
				+ " FROM camping_view where ROWID IN (SELECT MAX(ROWID)" + " FROM camping_view GROUP BY bseq)";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CampingVO cvo = new CampingVO();
				cvo.setBseq(rs.getInt("bseq"));
				cvo.setCategory(rs.getString("category"));
				cvo.setCname(rs.getString("cname"));
				cvo.setFacilities(rs.getString("facilities"));
				cvo.setCaddress1(rs.getString("caddress1"));
				cvo.setCaddress2(rs.getString("caddress2"));
				cvo.setCaddress3(rs.getString("caddress3"));
				cvo.setImage(rs.getString("image"));
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

	public ArrayList<CampingVO> selectCamping() {
		ArrayList<CampingVO> list = new ArrayList<CampingVO>();
		con = Dbman.getConnection();
		String sql = "select * from camping_view order by cseq desc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CampingVO cvo = new CampingVO();
				cvo.setCseq(rs.getInt("cseq"));
				cvo.setBseq(rs.getInt("bseq"));
				cvo.setCname(rs.getString("cname"));
				cvo.setCaddress1(rs.getString("caddress1"));
				cvo.setCaddress2(rs.getString("caddress2"));
				cvo.setCaddress3(rs.getString("caddress3"));
				cvo.setPhone(rs.getString("phone"));
				cvo.setC_indate(rs.getTimestamp("c_indate"));
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
		String sql = "select * from camping where bseq=? order by cseq desc";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CampingVO cvo = new CampingVO();
				cvo.setCseq(rs.getInt("cseq"));
				cvo.setCname(rs.getString("cname"));
				cvo.setFacilities(rs.getString("facilities"));
				cvo.setImage(rs.getString("image"));
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

	public ArrayList<CampingVO> selectNewCampList() {
		ArrayList<CampingVO> list = new ArrayList<CampingVO>();
		con = Dbman.getConnection();
		String sql = "select bseq, cname, content, image " + "from (select * from camping_view order by c_indate desc) "
				+ "where rownum<=4";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CampingVO cvo = new CampingVO();
				cvo.setBseq(rs.getInt("bseq"));
				cvo.setCname(rs.getString("cname"));
				cvo.setContent(rs.getString("content"));
				cvo.setImage(rs.getString("image"));
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public ArrayList<CampingVO> selectAddress(String address1, String address2) {
		ArrayList<CampingVO> list = new ArrayList<CampingVO>();
		con = Dbman.getConnection();
		String sql = "select*from(" + "select*from(" + "SELECT*FROM camping_view where ROWID "
				+ "IN (SELECT MAX(ROWID) FROM camping_view GROUP BY bseq)" + ")where caddress1 like '%'||?||'%'"
				+ ")where caddress2 like '%'||?||'%'";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address1);
			pstmt.setString(2, address2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CampingVO cvo = new CampingVO();
				cvo.setBseq(rs.getInt("bseq"));
				cvo.setCategory(rs.getString("category"));
				cvo.setCname(rs.getString("cname"));
				cvo.setFacilities(rs.getString("facilities"));
				cvo.setCaddress1(rs.getString("caddress1"));
				cvo.setCaddress2(rs.getString("caddress2"));
				cvo.setCaddress3(rs.getString("caddress3"));
				cvo.setImage(rs.getString("image"));
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
				cvo.setContent(rs.getString("content"));
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

	public void deleteCamping(int cseq) {
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
				cvo.setCategory(rs.getString("category"));
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

}
