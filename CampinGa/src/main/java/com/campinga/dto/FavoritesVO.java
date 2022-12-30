package com.campinga.dto;

public class FavoritesVO {
	private Integer fseq;
	private String mid;
	private Integer bseq;
	private String fav_check;
	private String cname;
	private String phone;
	private Integer rn;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFav_check() {
		return fav_check;
	}
	public void setFav_check(String fav_check) {
		this.fav_check = fav_check;
	}
	public Integer getFseq() {
		return fseq;
	}
	public void setFseq(Integer fseq) {
		this.fseq = fseq;
	}
	public Integer getBseq() {
		return bseq;
	}
	public void setBseq(Integer bseq) {
		this.bseq = bseq;
	}
	public Integer getRn() {
		return rn;
	}
	public void setRn(Integer rn) {
		this.rn = rn;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
}
