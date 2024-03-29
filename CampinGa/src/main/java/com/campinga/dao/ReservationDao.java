package com.campinga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.campinga.dto.FavoritesVO;
import com.campinga.dto.ReservationVO;
import com.campinga.util.Dbman;
import com.campinga.util.Paging;

public class ReservationDao {
	private ReservationDao() {
	}

	private static ReservationDao itc = new ReservationDao();

	public static ReservationDao getInstance() {
		return itc;
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ArrayList<ReservationVO> getReservateList(Paging paging, String mid) {
		ArrayList<ReservationVO> list = new ArrayList<ReservationVO>();
		con = Dbman.getConnection();
		String sql = "select * from ( "
				+ " select * from ( "
				+ " select rownum as rn, re. * from "
				+ " (( select * from reservate_view where mid=? order by reseq desc) re) "
				+ " ) where rn >=? "
				+ " ) where rn <=? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReservationVO revo = new ReservationVO();
				revo.setReseq(rs.getInt("reseq"));
				revo.setBseq(rs.getInt("bseq"));
				revo.setCseq(rs.getInt("cseq"));
				revo.setMid(rs.getString("mid"));
				revo.setRes_date(rs.getTimestamp("res_date"));
				revo.setPrice(rs.getInt("price"));
				revo.setPeople(rs.getInt("people"));
				revo.setChk_in(rs.getString("chk_in"));
				revo.setChk_out(rs.getString("chk_out"));
				revo.setCname(rs.getString("cname"));
				revo.setC_class(rs.getString("c_class"));
				revo.setRes_sta(rs.getString("res_sta"));
				list.add(revo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public void cancelReservate(int reseq) {
		String sql = "delete from reservation where reseq=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}

	}

	public ArrayList<ReservationVO> getBusinessRestList(String bid, Paging paging) {
		ArrayList<ReservationVO> list = new ArrayList<ReservationVO>();
		con = Dbman.getConnection();
		String sql = "select * from(" 
			  	+ "select * from(" 
			  	+ "select rownum as rn, re.* from("
			  	+ "(select * from reservate_view where bid=? order by res_date) re)" 
			  	+ ")where rn>=?" 
			  	+ ") where rn<=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bid);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReservationVO revo = new ReservationVO();
				revo.setReseq(rs.getInt("reseq"));
				revo.setCname(rs.getString("cname"));
				revo.setC_class(rs.getString("c_class"));
				revo.setRes_sta(rs.getString("res_sta"));
				revo.setMid(rs.getString("mid"));
				revo.setPrice(rs.getInt("price"));
				revo.setPeople(rs.getInt("people"));
				revo.setRes_date(rs.getTimestamp("res_date"));
				revo.setChk_in(rs.getString("chk_in"));
				revo.setChk_out(rs.getString("chk_out"));
				list.add(revo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
  }
	public void insertReservation(ReservationVO rvo) {
		String sql = "insert into reservation( reseq, cseq, mid, price, people, chk_in, chk_out )"
	     		+ " values( reservation_seq.nextval, ?, ?, ?, ?, ?, ? )";
			con = Dbman.getConnection();
			try {			
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, rvo.getCseq());
				pstmt.setString(2, rvo.getMid());
				pstmt.setInt(3, rvo.getPrice());
				pstmt.setInt(4, rvo.getPeople());
				pstmt.setString(5, rvo.getChk_in());
				pstmt.setString(6, rvo.getChk_out());
			    pstmt.executeUpdate();
			} catch (SQLException e) {e.printStackTrace();
			} finally { Dbman.close(con, pstmt, rs);  
			}
			
	
	}

	public ArrayList<ReservationVO> selectReserveCheckDate(int cseq) {
		ArrayList<ReservationVO> list = new ArrayList<ReservationVO>();
		con = Dbman.getConnection();
		String sql = "select to_char(chk_in,'yyyy-mm-dd') as cin,"
				+ " to_char(chk_out,'yyyy-mm-dd') as cout from reservation "
				+ "where cseq=? and chk_out>=sysdate order by chk_in";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cseq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReservationVO revo = new ReservationVO();
				revo.setChk_in(rs.getString("cin"));
				revo.setChk_out(rs.getString("cout"));
				list.add(revo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public int getCount(String bid) {
		int count = 0;
		con = Dbman.getConnection();
		String sql = "select count(*) as cnt from reservate_view where bid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt("cnt");
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return count;
	}


	
}
