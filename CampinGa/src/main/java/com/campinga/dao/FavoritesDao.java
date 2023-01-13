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

public class FavoritesDao {
	private FavoritesDao() {}
	private static FavoritesDao itc = new FavoritesDao();
	public static FavoritesDao getInstance() {
		return itc;
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<FavoritesVO> getFavoritesList(Paging paging, String mid) {
		ArrayList<FavoritesVO> list = new ArrayList<FavoritesVO>();
		con = Dbman.getConnection();
		String sql = "select * from ( "
				+ " select * from ( "
				+ " select rownum as rn, f.fseq, f.bseq, f.mid, f.cname, f.fav_check, f.phone from "
				+ " (( select * from favorites_view where mid=? order by fseq desc) f) "
				+ " ) where rn>=? "
				+ " ) where rn<=? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FavoritesVO fvo = new FavoritesVO();
				fvo.setRn(rs.getInt("rn"));
				fvo.setFseq(rs.getInt("fseq"));
				fvo.setBseq(rs.getInt("bseq"));
				fvo.setMid(rs.getString("mid"));
				fvo.setCname(rs.getString("cname"));
				fvo.setFav_check(rs.getString("fav_check"));
				fvo.setPhone(rs.getString("phone"));
				list.add(fvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public void deleteFavorites(String fieldName, int seq) {
		String sql = "delete from favorites where "+ fieldName +"=?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
	}

	public void insertFavorites(FavoritesVO fvo) {
		String sql = "insert into favorites(fseq, bseq, mid, fav_check) "
				+ "values(favorites_seq.nextVal, ?, ?, ?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, fvo.getBseq());
			pstmt.setString(2, fvo.getMid());
			pstmt.setString(3, "y");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		
	}

	public String checkFav(int bseq, String mid) {
		String check = "";
		con = Dbman.getConnection();
		String sql = "select * from favorites where bseq=? and mid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bseq);
			pstmt.setString(2, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = rs.getString("fav_check");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return check;
	}

}
