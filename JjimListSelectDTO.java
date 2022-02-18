package mypage.model;

public class JjimListSelectDTO {
	private String nick; // �̸��� ������ �ʵ� ����
	private String dr_id; // ��ǰ���� ������ �ʵ弱��
	private String dr_des; // ��ǰ ������ ������ �ʵ� ����
	private int count; // ī��Ʈ�� ������ �ʵ� ���� 
	
	// ���� �ʵ尡 ����ڰ� ���� ������ 
	public JjimListSelectDTO(String nick, String dr_id, String dr_des, int count) {
	//�迭�� ���� ������ Ÿ������ �����ϴµ� int �� ���� �ٸ��� ������ DTO Ÿ������ �����´� 
		this.nick = nick;
		this.dr_id = dr_id;
		this.dr_des = dr_des;
		this.count = count;
	}
	
	//�⺻ ������ 
	public JjimListSelectDTO() {};
	
	public String getNick() {
		return nick; // ȸ���� ������ �˷��� 
	}
	public void setNick(String nick) {
		this.nick = nick; // ȸ���� ������ ���޹��� ������ ������
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
