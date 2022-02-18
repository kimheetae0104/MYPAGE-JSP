package mypage.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JjimListSelectDAO {
	//1.db�� ������ �ؾ��Ѵ�
	private Connection conn;
	//PreparedStatement�� ��ü statement�� ��ӹ޴� �������̽��� SQL������ �����Ű�� ����� ���� ��ü
	private PreparedStatement psmt;
	private ResultSet rs;
	private int cnt;
	private String sql;

	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1524:xe";
			String user = "campus_f_4_0115";
			String password = "smhrd4";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			

			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//�򸮽�Ʈ �ҷ����� ���
	public int JjimSelect(JjimListSelectDTO JjimList) {
		
		connect();
		
		sql = "select dr_id, dr_des from drinkInfo where count = ? and nick = ? ";
		//�г��Ӱ� ī��Ʈ�� �ö� ������ �����̺��� �������� �� ���� �����Ͷ� 
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, JjimList.getCount());
			psmt.setString(2, JjimList.getNick());
			
			cnt = psmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}

//	update �� ���� , query�� ��ȸ ��� �ǹ�
//	execute : ������ Boolean Ÿ���� ���� ��ȯ�ϰ� ��� ������ ������ �� �ֽ��ϴ�.
//
//	executeUpdate : ���� ��� int type���� ��ȯ�� �մϴ� �� ����(update)�ؼ� �����ϸ� 1�� ��ȯ���ݴϴ� create , drop ���������� -1�� ��ȯ���ش�? 
//	���౸���� create,updated,delete�� �ش��մϴ�.
//
//	executeQuery : ������ ResultSet ��ü�� ���� ��ȯ�մϴ�.
//	select ������ ������ ���� ����� �� �ֽ��ϴ�.
//
//	���⼭ ResultSet ��ü�� Select(��ȸ)����� ������ �ִ� �������̽��� ���մϴ�.
//	ResultSet�� Select�� ģ���� �� �����ϴ� 
//	Select���� ����� �����ϴ� �ϳ��� ��ü�μ� ����� �����͸� ���� ������ �ҷ� �� �� �ְ� �ǰ� ���� ������ �� Ÿ���� ������ �ҷ��� �� �ִٴ� Ư¡�� �ִٰ� �մϴ�. 
	// rs.next() ResultSet ���� �����ϸ� True ���� ��ȯ�ϰ� ���� �࿡ ���� �����ϸ� True�� ��ȯ�ϰ� �� ���� Ÿ�Կ� ���� ��ȯ���ְ� �ȴ�. 

	public ArrayList<JjimListSelectDTO> Select(String nick, int cnt) {
		
		ArrayList<JjimListSelectDTO> list = new ArrayList<JjimListSelectDTO>();
		
			
		sql = "select dr_id , dr_des from drinkInfo where nick=? and cnt=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, nick);
			psmt.setInt(2, cnt);

			rs = psmt.executeQuery(); 
			
			//ResultSet�� get �迭�� �޼���� ���� Ŀ������ �����͸� �о�´�. 
			//ResultSet�� ó���� ù ��° �� ������ Ŀ���� ��ġ�ϱ� ������ ù ��° �࿡ ����� �����͸� ��������
			//�Ʒ��� ���� next()�޼��带 ����ؼ� Ŀ���� �̵����Ѿ� �Ѵ�. 
			
			//if(rs.next()){//���� ���� �����ϸ� rs.next()�� true�� ����
			//rs.next()�� ���� ���� ������ �̵� 
			//String name = rs.getString("NAME");
			//~~~
			//}else{
			//ù ��° ���� �������� �ʴ´�. �� ,����� ����
			//~~~~
			//}
			
			//1�� �̻��� ���� ó���� ������ while �����̳� do-while ������ ����Ѵ�.
			//���� while ������ ����� ������ �Ʒ��� ���� ���¸� ��� �ȴ�.
			//rs = stmt.executeQuery();
			//while(rs.next()){
			//���྿ �ݺ� ó��
			//String name = rs.getString(1);
			//}
			while(rs.next()) {
				String nick1 = rs.getString(1);
				int cnt1 = rs.getInt(2);
			}
			list.add(new JjimListSelectDTO(nick, null, null, cnt));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return list;
	}
	
	
}
