package kr.or.ddit.wk.vo;

import java.util.Date;

public class WkVO {
	
	private int wkNum;
	private int empNum;
	private int siteNum;
	private Date inDt;
	private Date outDt;
	
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
	public Date getInDt() {
		return inDt;
	}
	public void setInDt(Date inDt) {
		this.inDt = inDt;
	}
	public Date getOutDt() {
		return outDt;
	}
	public void setOutDt(Date outDt) {
		this.outDt = outDt;
	}

	@Override
	public String toString() {
		return "WkVO [wkNum=" + wkNum + ", empNum=" + empNum + ", siteNum=" + siteNum + ", inDt=" + inDt + ", outDt="
				+ outDt + "]";
	}
	
	
}
