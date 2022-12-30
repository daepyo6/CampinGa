package com.campinga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.campinga.dto.ReviewVO;
import com.campinga.util.Dbman;

public class ReviewDao {

	private ReviewDao() {}
	private static ReviewDao itc = new ReviewDao();
	public static ReviewDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	  public void insertReview(ReviewVO rvo, String mid) {

	      String sql = "insert into review (rseq, mid, bseq, content) " + " values(review_seq.nextval , ? , ? , ?) ";
	      con = Dbman.getConnection();
	      try {
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, mid);
	         pstmt.setInt(2, 1);
	         pstmt.setString(3, rvo.getContent());

	         pstmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         Dbman.close(con, pstmt, rs);
	      }

	   }

	   public ArrayList<ReviewVO> selectReview() {

	      ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();

	      String sql = "select * from review order by rseq desc ";

	      con = Dbman.getConnection();
	      try {
	         pstmt = con.prepareStatement(sql);
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

	   

	   public void updateReview(ReviewVO rvo) {

	      String sql = "update review set indate=sysdate, content=? where rseq=?";
	      con = Dbman.getConnection();
	      try {
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, rvo.getContent());
	         pstmt.setInt(2, rvo.getRseq());
	         pstmt.executeUpdate();

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally { Dbman.close(con, pstmt, rs);}
	     
	      
	      }


	
	public void deleteReview(int rseq) {
		  String sql = "delete from review where rseq=?";
	      con = Dbman.getConnection();
	      try {
	            pstmt = con.prepareStatement(sql); 
	            pstmt.setInt(1, rseq);
	            pstmt.executeUpdate();
	      } catch (Exception e) { e.printStackTrace();
	      } finally { Dbman.close(con, pstmt, rs); }		
	}
}
