package kr.or.ddit.board.vo;

public class BoardVO {
	private int board_no;
	private String  board_title;
	private String  board_writer;
	private String board_date;  //String..?
	private int board_cnt;
	private String board_content;
	
	public int getBoard_no() {
		return board_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public String getBoard_date() {
		return board_date;
	}
	public int getBoard_cnt() {
		return board_cnt;
	}
	public String getBoard_content() {
		return board_content;
	}
	
	@Override
	public String toString() {
		return "BoardVO [board_no=" + board_no + ", board_title=" + board_title + ", board_writer=" + board_writer
				+ ", board_date=" + board_date + ", board_cnt=" + board_cnt + ", board_content=" + board_content + "]";
	}
	
	
	

}
