package com.campinga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.campinga.util.Dbman;

public class AdminDao {
	
	private AdminDao() {}
	private static AdminDao itc = new AdminDao();
	public static AdminDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public String workerCheck(String adminId) {
		String pwd = null;
		
		String sql = "select * from admin where aid = ?";
		con = Dbman.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adminId);
			rs = pstmt.executeQuery();
			if( rs.next() )
				pwd = rs.getString("pwd");
		} catch (SQLException e) { e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);
		}
		return pwd;
	}

}
