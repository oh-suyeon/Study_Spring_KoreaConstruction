package kr.or.ddit.util;

// 페이징 처리 전용 클래스
public class Pagination {
	private int total; // 전체 게시글의 개수
	private int currentPage; // 사용자가 요청한 페이지 번호 (사용자가 몇 번 페이지를 클릭했는가)
	private int size; // 한 화면에 보여질 게시글 행의 개수
	private int totalPages; // 전체 페이지의 개수
	private int startPage; // 페이지 이동 링크의 시작번호
	private int endPage;  // 페이지 이동링크의 끝 번호
	
	// 생성자
	public Pagination(int total, int currentPage, int size) {
		this.total = total;
		this.currentPage = currentPage;
		this.size = 3; 
		
		if(total==0) { // 게시글이 없을 경우
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		}else {
			totalPages = total / size;
			if(total % size > 0) {
				totalPages += 1;
			}
			
			// 시작 페이지 번호 공식 : 사용자 현재 페이지 / 페이징 크기 * 페이징 크기 + 1 
			// 사용자 현재 페이지가 페이징 크기의 배수 일경우 -1
			startPage = currentPage / size * size + 1;  // 3-4 1
			if(currentPage % size == 0) startPage -= size;
			
			// 종료 페이지 번호 구하는 공식 : 시작 페이지 번호 + 페이징 크기
			// 종료 페이지가 전체 페이지 수보다 클 경우 종료 페이지는 전체 페이지와 같음
			endPage = startPage + size - 1;
			if(endPage > totalPages) endPage = totalPages;
		}
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "Pagination [total=" + total + ", currentPage=" + currentPage + ", size=" + size + ", totalPages="
				+ totalPages + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
	// 게시글 없을 경우 true
	public boolean hasNoArticles() {
		return total == 0;
	}
	
	// 게시글 있을 경우 true
	public boolean hasArticles() {
		return total > 0;
	}
}

