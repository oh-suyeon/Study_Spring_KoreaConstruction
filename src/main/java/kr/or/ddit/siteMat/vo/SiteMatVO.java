package kr.or.ddit.siteMat.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SiteMatVO {

	private int siteNum;
	private String matNmCd;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date purDt;
	private long cnt;
	private long purPri;
	
	public int getSiteNum() {
		return siteNum;
	}
	public void setSiteNum(int siteNum) {
		this.siteNum = siteNum;
	}
	public String getMatNmCd() {
		return matNmCd;
	}
	public void setMatNmCd(String matNmCd) {
		this.matNmCd = matNmCd;
	}
	public Date getPurDt() {
		return purDt;
	}
	public void setPurDt(Date purDt) {
		this.purDt = purDt;
	}
	public long getCnt() {
		return cnt;
	}
	public void setCnt(long cnt) {
		this.cnt = cnt;
	}
	public long getPurPri() {
		return purPri;
	}
	public void setPurPri(long purPri) {
		this.purPri = purPri;
	}
	
	@Override
	public String toString() {
		return "SiteMatVO [siteNum=" + siteNum + ", matNmCd=" + matNmCd + ", purDt=" + purDt
				+ ", cnt=" + cnt + ", purPri=" + purPri + "]";
	}
	
	
	
}
