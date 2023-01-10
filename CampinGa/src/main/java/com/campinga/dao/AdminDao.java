package com.campinga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.campinga.dto.CampingVO;
import com.campinga.dto.MemberVO;
import com.campinga.dto.NoticeVO;
import com.campinga.dto.ReservationVO;
import com.campinga.dto.ReviewVO;
import com.campinga.util.Dbman;
import com.campinga.util.Paging;

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

	public ArrayList<MemberVO> selectMember(Paging paging, String key) {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		con = Dbman.getConnection();
		String sql = " select * from ( "
				+ " select * from ( "
				+ " select rownum as rn, m. * from "
				+ " ((select * from member where name like '%'||?||'%' order by mid desc) m)"
				+ " ) where rn>=?"
				+ " ) where rn<=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum() );
			pstmt.setInt(3, paging.getEndNum() );
			rs = pstmt.executeQuery();
			while(rs.next() ) {
				MemberVO mvo = new MemberVO();
				mvo.setMid(rs.getString("mid") );
				mvo.setPwd(rs.getString("pwd") );
				mvo.setName(rs.getString("name") );
				mvo.setMphone(rs.getString("mphone") );
				mvo.setEmail(rs.getString("email") );
				list.add(mvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);
		}
		return list;
	}

	public int getAllCount(String tableName, String fieldName, String key) {
		int count = 0;
		con = Dbman.getConnection();
		String sql = "select count(*) as cnt from " + tableName + " where " + fieldName + " like '%'||?||'%'";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			if(rs.next() )
				count = rs.getInt("cnt");
		} catch (SQLException e) { e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs);
		}
		return count;
	}

	public int getAllCountReview(String key) {
		int count=0;
		String sql = "select count(*) as cnt from review "
				+ " where content like '%'||?||'%'";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			if( rs.next() )
				count = rs.getInt("cnt");
		} catch (SQLException e) {	e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);}
		return count;
	}

	public ArrayList<ReviewVO> selectReview(Paging paging, String key) {
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		String sql = " select * from ( "
				+ " select * from ( "
				+ " select rownum as rn, r. * from "
				+ " (( select * from review where content like '%'||?||'%' order by rseq desc) r) "
				+ " ) where rn>=? "
				+ " ) where rn<=? ";
		con = Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum() );
			pstmt.setInt(3, paging.getEndNum() );
			rs = pstmt.executeQuery();
			while(rs.next() ) {
				ReviewVO rvo = new ReviewVO();
				rvo.setRseq(rs.getInt("rseq") );
				rvo.setBseq(rs.getInt("bseq") );
				rvo.setMid(rs.getString("mid") );
				rvo.setContent(rs.getString("content") );
				rvo.setIndate(rs.getTimestamp("indate") );
				list.add(rvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		}finally { Dbman.close(con, pstmt, rs);}
		return list;
	}

	public ArrayList<ReservationVO> selectRest(Paging paging, String key) {
		ArrayList<ReservationVO> list = new ArrayList<ReservationVO>();
		String sql = "select * from ( "
				+ " select * from ( "
				+ " select rownum as rn, re.* from "
				+ " ((select * from reservate_view where cname like '%'||?||'%' order by reseq desc) re) "
				+ " ) where rn>=? "
				+ " ) where rn<=? ";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2,  paging.getStartNum()) ;
			pstmt.setInt(3,  paging.getEndNum() );
			rs = pstmt.executeQuery();
			while(rs.next() ) {
				ReservationVO revo = new ReservationVO();
				revo.setReseq(rs.getInt("reseq") );
				revo.setMid(rs.getString("mid") );
				revo.setRes_date(rs.getTimestamp("res_date") );
				revo.setPrice(rs.getInt("price") );
				revo.setPeople(rs.getInt("people") );
				revo.setChk_in(rs.getString("chk_in") );
				revo.setChk_out(rs.getString("chk_out") );
				revo.setCname(rs.getString("cname") );
				revo.setC_class(rs.getString("c_class") );
				revo.setRes_sta(rs.getString("res_sta") );
				list.add(revo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {  Dbman.close(con, pstmt, rs);}
		return list;
	}

	
	
	
	
	
	public void updateNotice(NoticeVO nvo) {
		String sql = "update notice set  subject=?, content=? where nseq=?";
		
		con = Dbman.getConnection();
		try {			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nvo.getSubject());
		    pstmt.setString(2, nvo.getContent());
		    pstmt.setInt(3,nvo.getNseq());
		    pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  
		}
		
	}

	public void insertNotice(NoticeVO nvo) {
     String sql = "insert into notice( nseq, subject, content ,aid)"
     		+ " values( notice_seq.nextval, ?, ?, ? )";
		
		con = Dbman.getConnection();
		try {			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nvo.getSubject());
		    pstmt.setString(2, nvo.getContent());
		    pstmt.setString(3, nvo.getAid());
		    pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { Dbman.close(con, pstmt, rs);  
		}
		
	}

	public ArrayList<CampingVO> selectCamping(Paging paging) {
		ArrayList<CampingVO> list = new ArrayList<CampingVO>();
		con = Dbman.getConnection();
		String sql = " select + from ( "
				+ " select + from ( "
				+ " select rownum as rn p.* from "
				+ " (( select * from camping where cname like '%'||?||'%' order by cseq desc) p) "
				+ " ) where rn>=? "
				+ " ) where rn<=? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2, paging.getEndNum());
			rs = pstmt.executeQuery();
			while(rs.next() ) {
				CampingVO cvo = new CampingVO();
				cvo.setCseq(rs.getInt("cseq"));
				cvo.setBseq(rs.getInt("bseq"));
				cvo.setCname(rs.getString("cname"));
				cvo.setFacilities(rs.getString("facilities"));
				cvo.setImage(rs.getString("image"));
				cvo.setC_content(rs.getString("c_content"));
				cvo.setCategory(rs.getString("category"));
				cvo.setC_class(rs.getString("c_class"));
				cvo.setRes_sta(rs.getString("res_sta"));
				cvo.setPrice(rs.getInt("price"));
				cvo.setMin_people(rs.getInt("min_people"));
				cvo.setMax_people(rs.getInt("max_people"));
				cvo.setC_indate(rs.getTimestamp("c_indate"));
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);
		}
		return list;
	}
}
