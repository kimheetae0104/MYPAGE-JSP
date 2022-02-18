package mypage.model;

public class JjimListSelectDTO {
	private String nick; // 이름을 저장할 필드 선언
	private String dr_id; // 상품명을 저정할 필드선언
	private String dr_des; // 상품 설명을 저장할 필드 선언
	private int count; // 카운트를 저장할 필드 선언 
	
	// 유질 필드가 사용자가 정한 생성자 
	public JjimListSelectDTO(String nick, String dr_id, String dr_des, int count) {
	//배열은 같은 데이터 타입으로 들어가야하는데 int 라서 서로 다르기 때문에 DTO 타입으로 가져온다 
		this.nick = nick;
		this.dr_id = dr_id;
		this.dr_des = dr_des;
		this.count = count;
	}
	
	//기본 생성자 
	public JjimListSelectDTO() {};
	
	public String getNick() {
		return nick; // 회원의 별명을 알려줌 
	}
	public void setNick(String nick) {
		this.nick = nick; // 회원의 별멸을 전달받은 값으로 변경함
	}
	public String getDr_id() {
		return dr_id;
	}
	public void setDr_id(String dr_id) {
		this.dr_id = dr_id;
	}
	public String getDr_des() {
		return dr_des;
	}
	public void setDr_des(String dr_des) {
		this.dr_des = dr_des;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
