package kr.or.ddit.conMatInfo.vo;

public class ConMatInfoVO {

	private String matNmCd;
	private String itemNm;
	
	public String getMatNmCd() {
		return matNmCd;
	}
	public void setMatNmCd(String matNmCd) {
		this.matNmCd = matNmCd;
	}
	public String getItemNm() {
		return itemNm;
	}
	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
	}

	@Override
	public String toString() {
		return "ConMatInfoVO [matNmCd=" + matNmCd + ", itemNm=" + itemNm + "]";
	}
}
