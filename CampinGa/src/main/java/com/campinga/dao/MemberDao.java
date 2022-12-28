package com.campinga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.campinga.dto.MemberVO;
import com.campinga.util.Dbman;

public class MemberDao {
	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberVO getMember(String mid) {
		MemberVO mvo = null;
		con = Dbman.getConnection();
		String sql = "select * from member where mid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mvo = new MemberVO();
				mvo.setMid(rs.getString("mid"));
				mvo.setName(rs.getString("name"));
				mvo.setPwd(rs.getString("pwd"));
				mvo.setEmail(rs.getString("email"));
				mvo.setMphone(rs.getString("mphone"));
				mvo.setMseq(rs.getInt("mseq"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return mvo;
	}
}
