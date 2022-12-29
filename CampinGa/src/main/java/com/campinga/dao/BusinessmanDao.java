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
}