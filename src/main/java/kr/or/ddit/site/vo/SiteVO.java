package kr.or.ddit.site.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SiteVO {

	private int siteNum;
	private String siteNm;
	private String addr;
	private String phnNum;
	private long contAmt;
	private long inPeo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date stDt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date exComDt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date comDt;
	private String etc;
	
	public int getSiteNum() {
		return siteNum;
	}
	public void setSiteNum(int siteNum) {
		this.siteNum = siteNum;
	}
	public String getSiteNm() {
		return siteNm;
	}
	public void setSiteNm(String siteNm) {
		this.siteNm = siteNm;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhnNum() {
		return phnNum;
	}
	public void setPhnNum(String phnNum) {
		this.phnNum = phnNum;
	}
	public long getContAmt() {
		return contAmt;
	}
	public void setContAmt(long contAmt) {
		this.contAmt = contAmt;
	}
	public long getInPeo() {
		return inPeo;
	}
	public void setInPeo(long inPeo) {
		this.inPeo = inPeo;
	}
	public Date getStDt() {
		return stDt;
	}
	public void setStDt(Date stDt) {
		this.stDt = stDt;
	}
	public Date getExComDt() {
		return exComDt;
	}
	public void setExComDt(Date exComDt) {
		this.exComDt = exComDt;
	}
	public Date getComDt() {
		return comDt;
	}
	public void setComDt(Date comDt) {
		this.comDt = comDt;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	@Override
	public String toString() {
		return "SiteVO [siteNum=" + siteNum + ", siteNm=" + siteNm + ", addr=" + addr + ", phnNum=" + phnNum
				+ ", contAmt=" + contAmt + ", inPeo=" + inPeo + ", stDt=" + stDt + ", exComDt=" + exComDt + ", comDt="
				+ comDt + ", etc=" + etc + "]";
	}
	
	
	
	
	
}
