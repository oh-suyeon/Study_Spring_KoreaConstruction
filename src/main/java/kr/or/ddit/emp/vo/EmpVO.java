package kr.or.ddit.emp.vo;

public class EmpVO {

	private int empNum;
	private String empNm;
	private String zipCode;
	private String addr1;
	private String addr2;
    private String phnNum;
	private String pos;
	private String deptNm;
	
	public int getEmpNum() {
		return empNum;
	}
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}
	public String getEmpNm() {
		return empNm;
	}
	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getPhnNum() {
		return phnNum;
	}
	public void setPhnNum(String phnNum) {
		this.phnNum = phnNum;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getDeptNm() {
		return deptNm;
	}
	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}
	
	@Override
	public String toString() {
		return "EmpVO [empNum=" + empNum + ", empNm=" + empNm + ", addr1=" + addr1 + ", zipCode=" + zipCode + ", addr2="
				+ addr2 + ", phnNum=" + phnNum + ", pos=" + pos + ", deptNm=" + deptNm + "]";
	}
}
