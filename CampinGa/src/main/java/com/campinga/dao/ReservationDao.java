package com.campinga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.campinga.dto.FavoritesVO;
import com.campinga.dto.ReservationVO;
import com.campinga.util.Dbman;

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

	public ArrayList<ReservationVO> getReservateList(String mid) {
		ArrayList<ReservationVO> list = new ArrayList<ReservationVO>();
		con = Dbman.getConnection();
		String sql = "select * from reservate_view where mid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
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
				revo.setChk_in(rs.getTimestamp("chk_in"));
				revo.setChk_out(rs.getTimestamp("chk_out"));
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

	public void cancelReservate(String mid) {
		String sql = "delete from reservation where mid=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}

	}
}
