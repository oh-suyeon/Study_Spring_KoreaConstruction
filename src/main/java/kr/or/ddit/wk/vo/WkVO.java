package kr.or.ddit.wk.vo;

public class WkVO {
	
	private int empNum;
	private int siteNum;
	
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

	@Override
	public String toString() {
		return "WkVO [empNum=" + empNum + ", siteNum=" + siteNum + "]";
	}
	
	
}
