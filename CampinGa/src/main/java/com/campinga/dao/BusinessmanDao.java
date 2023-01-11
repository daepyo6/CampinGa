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

public class BusinessmanDao {

	private BusinessmanDao() {
	}

	private static BusinessmanDao itc = new BusinessmanDao();

	public static BusinessmanDao getInstance() {
		return itc;
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public BusinessmanVO getBusinessman(String bid) {
		BusinessmanVO bvo = null;
		con = Dbman.getConnection();
		String sql = "select * from businessman where bid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bvo = new BusinessmanVO();
				bvo.setBid(rs.getString("bid"));
				bvo.setName(rs.getString("name"));
				bvo.setPwd(rs.getString("pwd"));
				bvo.setEmail(rs.getString("email"));
				bvo.setPhone(rs.getString("phone"));
				bvo.setBseq(rs.getInt("bseq"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return bvo;
	}

	public void insertBusiness(BusinessmanVO bvo) {
		con = Dbman.getConnection();
		String sql = "insert into businessman(bseq, bid, pwd, name, phone, email, cname,"
				+ " caddress1, caddress2, caddress3)" + " values(businessman_seq.nextval,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bvo.getBid());
			pstmt.setString(2, bvo.getPwd());
			pstmt.setString(3, bvo.getName());
			pstmt.setString(4, bvo.getPhone());
			pstmt.setString(5, bvo.getEmail());
			pstmt.setString(6, bvo.getCname());
			pstmt.setString(7, bvo.getCaddress1());
			pstmt.setString(8, bvo.getCaddress2());
			pstmt.setString(9, bvo.getCaddress3());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
	}

	public void updateUserInfo(BusinessmanVO bvo) {
		String sql = "update businessman set name=?, phone=?, email=? where bid=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bvo.getName());
			pstmt.setString(2, bvo.getPhone());
			pstmt.setString(3, bvo.getEmail());
			pstmt.setString(4, bvo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
	}

	public void deletebusinessman(String bid) {
		String sql = "delete from businessman where bid=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}

	}

	public int getAllCount(String tableName, String fieldName, Integer bseq) {
		int count = 0;
		con = Dbman.getConnection();
		String sql = "select count(*) as cnt from " + tableName + " where " + fieldName + "=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			rs = pstmt.executeQuery();
			if (rs.next())
				count = rs.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return count;
	}

	public ArrayList<CampingVO> selectCamping(Paging paging, Integer bseq) {
		ArrayList<CampingVO> list = new ArrayList<CampingVO>();
		con = Dbman.getConnection();
		String sql = " select * from ( " + " select * from ( " + " select rownum as rn, p.* from "
				+ " (( select * from camping where bseq=? order by cseq desc) p) " + " ) where rn>=? "
				+ " ) where rn<=? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CampingVO cvo = new CampingVO();
				cvo.setCseq(rs.getInt("cseq"));
				cvo.setBseq(rs.getInt("bseq"));
				cvo.setCname(rs.getString("cname"));
				cvo.setFacilities(rs.getString("facilities"));
				cvo.setImage(rs.getString("image"));
				cvo.setC_content(rs.getString("c_content"));
				cvo.setCategory(rs.getString("category"));
				cvo.setC_class(rs.getString("c_class"));
				cvo.setRes_sta(rs.getString("res_sta"));
				cvo.setPrice(rs.getInt("price"));
				cvo.setMin_people(rs.getInt("min_people"));
				cvo.setMax_people(rs.getInt("max_people"));
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

	public int getAllCountForQna() {
		int count = 0;
		String sql = "select count(*)as cnt from camp_qna";
		con = Dbman.getConnection();
		try {

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return count;

	}

	public int getBseq(String bid) {
		int bseq = 0;
		String sql = "select *from businessman where bid=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bseq = rs.getInt("bseq");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return bseq;

	}

	public void updateQna(int qseq, String reply) {
		String sql = "update camp_qna set reply=?, repyn='y' where qseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reply);

			pstmt.setInt(2, qseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}

	}

	public void insertRoom(CampingVO cvo) {
		String sql = "insert into camping( cseq, bseq, cname, facilities, image, c_content, category, c_class )"
				+ "	values( camping_seq.nextval, ? , ? , ? , ? , ? , ? , ?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, cvo.getBseq());
			pstmt.setString(2, cvo.getCname());
			pstmt.setString(3, cvo.getFacilities());
			pstmt.setString(4, cvo.getImage());
			pstmt.setString(5, cvo.getC_content());
			pstmt.setString(6, cvo.getCategory());
			pstmt.setString(7, cvo.getC_class());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}

	}
	
	public BusinessmanVO selectOne(int bseq) {
		BusinessmanVO bmvo = null;
		con = Dbman.getConnection();
		String sql = "select * from businessman where bseq=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bmvo = new BusinessmanVO();
				bmvo.setBseq(rs.getInt("bseq"));
				bmvo.setCategory(rs.getString("category"));
				bmvo.setCname(rs.getString("cname"));
				bmvo.setFacilities(rs.getString("facilities"));
				bmvo.setCaddress1(rs.getString("caddress1"));
				bmvo.setCaddress2(rs.getString("caddress2"));
				bmvo.setCaddress3(rs.getString("caddress3"));
				bmvo.setContent(rs.getString("content"));
				bmvo.setImage(rs.getString("image"));
				bmvo.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return bmvo;
	}
	
}