package kr.or.ddit.wk.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class WkVO {
	
	private int wkNum;
	private int empNum;
	private int siteNum;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date wkStartDt;
	
	public int getWkNum() {
		return wkNum;
	}
	public void setWkNum(int wkNum) {
		this.wkNum = wkNum;
	}
	public int getEmpNum() {
		return empNum;
	}
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}
	public int getSiteNum() {
		return siteNum;
	}
	public void setSiteNum(int siteNum) {
		this.siteNum = siteNum;
	}
	public Date getWkStartDt() {
		return wkStartDt;
	}
	public void setWkStartDt(Date wkStartDt) {
		this.wkStartDt = wkStartDt;
	}
	@Override
	public String toString() {
		return "WkVO [wkNum=" + wkNum + ", empNum=" + empNum + ", siteNum=" + siteNum + ", wkStartDt=" + wkStartDt
				+ "]";
	}
}
