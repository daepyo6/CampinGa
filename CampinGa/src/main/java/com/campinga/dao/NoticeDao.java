package com.campinga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.campinga.dto.Camp_qnaVO;
import com.campinga.dto.NoticeVO;
import com.campinga.util.Dbman;
import com.campinga.util.Paging;

public class NoticeDao {

	private NoticeDao() {}
	private static NoticeDao itc = new NoticeDao();
	public static NoticeDao getInstance() { return itc; }
	
	Connection con=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public ArrayList<NoticeVO> selectAll() {
      ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		
		String sql = "select * from notice order by nseq desc";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				NoticeVO nVO = new NoticeVO();
				nVO.setNseq( rs.getInt("nseq") );
				nVO.setAid( rs.getString("aid") );
				nVO.setSubject( rs.getString("subject") );
				nVO.setContent( rs.getString("content") );
				nVO.setIndate(rs.getTimestamp("indate"));
				list.add( nVO );
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally {   Dbman.close(con, pstmt, rs);   }
		
		return list;
		
	}


	public NoticeVO getNotice(int nseq) {
		NoticeVO nvo = null;
		String sql = "select * from notice where nseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nseq);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				nvo = new NoticeVO();
				nvo.setNseq(rs.getInt("nseq"));
				nvo.setAid(rs.getString("Aid"));
				nvo.setContent(rs.getString("content"));
				nvo.setSubject(rs.getString("subject"));
				nvo.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  }
		return nvo;
		
	}


	public void deleteQna(int nseq) {
		 String sql = "delete from notice where nseq=?";
	      con = Dbman.getConnection();
	      try {
	            pstmt = con.prepareStatement(sql); 
	            pstmt.setInt(1, nseq);
	            pstmt.executeUpdate();
	      } catch (Exception e) { e.printStackTrace();
	      } finally { Dbman.close(con, pstmt, rs); }
		
	}

	public int getCount() {
		int count = 0;
		con = Dbman.getConnection();
		String sql = "select count(*) as cnt from notice";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt("cnt");
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return count;
	}


	public ArrayList<NoticeVO> selectAll(Paging paging) {
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		String sql = "select*from("
					+ "select*from("
					+ "select rownum as rn, n.*from("
					+ "(select*from notice order by nseq desc)n)"
					+ ")where rn>=?"
					+ ")where rn<=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2, paging.getEndNum());
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				NoticeVO nVO = new NoticeVO();
				nVO.setNseq( rs.getInt("nseq") );
				nVO.setAid( rs.getString("aid") );
				nVO.setSubject( rs.getString("subject") );
				nVO.setContent( rs.getString("content") );
				nVO.setIndate(rs.getTimestamp("indate"));
				list.add( nVO );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}
}
