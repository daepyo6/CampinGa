package com.campinga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.campinga.dto.Camp_qnaVO;
import com.campinga.util.Dbman;
import com.campinga.util.Paging;

public class Camp_qnaDao {

	private Camp_qnaDao() {
	}

	private static Camp_qnaDao itc = new Camp_qnaDao();

	public static Camp_qnaDao getInstance() {
		return itc;
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void deleteQna(int qseq) {

		String sql = "delete from camp_qna where qseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qseq);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}

	}

	public ArrayList<Camp_qnaVO> selectAllQna(int bseq, Paging paging1) {
		ArrayList<Camp_qnaVO> list = new ArrayList<Camp_qnaVO>();

		String sql = "select*from(" + 
					 "select*from(" + 
					 "select rownum as rn, q.*from(" + 
					 "(select*from camp_qna where bseq=? order by qseq desc)q)" 
					 + ")where rn>=?" 
					 + ")where rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			pstmt.setInt(2, paging1.getStartNum());
			pstmt.setInt(3, paging1.getEndNum());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Camp_qnaVO qvo = new Camp_qnaVO();
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setBseq(rs.getInt("bseq"));
				qvo.setMid(rs.getString("mid"));
				qvo.setContent(rs.getString("content"));
				qvo.setIndate(rs.getTimestamp("indate"));
				qvo.setReply(rs.getString("reply"));
				qvo.setRepyn(rs.getString("repyn"));
				list.add(qvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public void insertQna(Camp_qnaVO qvo) {

		String sql = "insert into camp_qna (qseq, content, mid, bseq) " + " values(qna_seq.nextval , ? , ? , ? )";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qvo.getContent());
			pstmt.setString(2, qvo.getMid());
			pstmt.setInt(3, qvo.getBseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}

	}
	
	public int getCount(int bseq) {
		int count = 0;
		con = Dbman.getConnection();
		String sql = "select count(*) as cnt from camp_qna where bseq=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt("cnt");
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return count;
	}

	public void updateQna(Camp_qnaVO qnaVo) {
		String sql = "update camp_qna set content=? where qseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qnaVo.getContent());
			pstmt.setInt(2, qnaVo.getQseq());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}

	}

}
