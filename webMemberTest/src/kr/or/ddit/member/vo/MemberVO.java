package kr.or.ddit.member.vo;

public class MemberVO {

	private String mem_id; //컬럼 아이디와 똑같이 해주는것이 좋음, 나중에 조인한 컬럼도 추가할수있다
	private String mem_pass;
	private String mem_name;
	private String mem_tel;
	private String mem_addr;
	private String mem_photo;
	
	//VO클래스에서 별도의 생성자를 만들때에는 기본생성자도 반드시 같이 만들어 준다.
	//getter,setter는 필수로 만들어주기
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	
	public String getMem_photo() {
		return mem_photo;
	}
	public void setMem_photo(String mem_photo) {
		this.mem_photo = mem_photo;
	}
	@Override
	public String toString() {
		return "MemberVO [mem_id=" + mem_id + ", mem_pass=" + mem_pass + ", mem_name=" + mem_name + ", mem_tel="
				+ mem_tel + ", mem_addr=" + mem_addr + "]";
	}
	
	
	

	
	
}
