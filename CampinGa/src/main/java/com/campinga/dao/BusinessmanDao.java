package com.campinga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.campinga.dto.BusinessmanVO;
import com.campinga.util.Dbman;

public class BusinessmanDao {

   private BusinessmanDao() {}
   private static BusinessmanDao itc = new BusinessmanDao();
   public static BusinessmanDao getInstance() {return itc;}
   
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
         if(rs.next()) {
            bvo = new BusinessmanVO();
            bvo.setBid(rs.getString("bid"));
            bvo.setName(rs.getString("name"));
            bvo.setPwd(rs.getString("pwd"));
            bvo.setEmail(rs.getString("email"));
            bvo.setPhone(rs.getString("phone"));
            bvo.setBseq(rs.getInt("bseq"));
         }
      } catch (SQLException e) { e.printStackTrace();
      } finally {Dbman.close(con, pstmt, rs);}
      return bvo;
   }

   public void insertBusiness(BusinessmanVO bvo) {
	   con = Dbman.getConnection();
	   String sql = "insert into businessman(bseq, bid, pwd, name, phone, email, cname,"
	   		      + " caddress1, caddress2, caddress3)"
	   		      + " values(businessman_seq.nextval,?,?,?,?,?,?,?,?,?)";
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
	   } catch (SQLException e) {e.printStackTrace();
	   } finally {Dbman.close(con, pstmt, rs);}	
   }
}