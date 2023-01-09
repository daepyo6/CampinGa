package com.campinga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.campinga.dto.ReviewVO;
import com.campinga.util.Dbman;
import com.campinga.util.Paging;

public class ReviewDao {

	private ReviewDao() {
	}

	private static ReviewDao itc = new ReviewDao();

	public static ReviewDao getInstance() {
		return itc;
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void insertReview(ReviewVO rvo) {

		String sql = "insert into review (rseq, mid, bseq, content) " + " values(review_seq.nextval , ? , ? , ?) ";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rvo.getMid());
			pstmt.setInt(2, rvo.getBseq());
			pstmt.setString(3, rvo.getContent());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}

	}

	public ArrayList<ReviewVO> selectReview(int bseq, Paging paging2) {

		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();

		String sql = "select*from("
				+ "select*from("
				+ "select rownum as rn, r.*from("
				+ "(select*from review where bseq=? order by rseq desc)r)"
				+ ")where rn>=?"
				+ ")where rn<=?";

		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			pstmt.setInt(2, paging2.getStartNum());
			pstmt.setInt(3, paging2.getEndNum());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReviewVO rvo = new ReviewVO();
				rvo.setRseq(rs.getInt("rseq"));
				rvo.setBseq(rs.getInt("bseq"));
				rvo.setMid(rs.getString("mid"));
				rvo.setContent(rs.getString("content"));
				rvo.setIndate(rs.getTimestamp("indate"));
				list.add(rvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}

		return list;
	}

	public int getCount(int bseq) {
		int count = 0;
		con = Dbman.getConnection();
		String sql = "select count(*) as cnt from review where bseq=?";
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

	public void updateReview(ReviewVO rvo) {

		String sql = "update review set content=? where rseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rvo.getContent());
			pstmt.setInt(2, rvo.getRseq());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}

	}

	public void deleteReview(int rseq) {
		String sql = "delete from review where rseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rseq);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
	}
}
