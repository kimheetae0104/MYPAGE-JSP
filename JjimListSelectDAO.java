package mypage.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JjimListSelectDAO {
	//1.db에 연결을 해야한다
	private Connection conn;
	//PreparedStatement란 객체 statement를 상속받는 인터페이스로 SQL구문을 실행시키는 기능을 갖는 객체
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
	
	//찜리스트 불러오기 기능
	public int JjimSelect(JjimListSelectDTO JjimList) {
		
		connect();
		
		sql = "select dr_id, dr_des from drinkInfo where count = ? and nick = ? ";
		//닉네임과 카운트가 올라간 찜목록을 술테이블에서 술정보와 술 설명만 가져와라 
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

//	update 는 수정 , query는 조회 라는 의미
//	execute : 수행결과 Boolean 타입의 값을 반환하고 모든 구문을 수행할 수 있습니다.
//
//	executeUpdate : 수행 결과 int type으로 반환을 합니다 즉 수정(update)해서 성공하면 1을 반환해줍니다 create , drop 구문에서는 -1을 반환해준다? 
//	수행구문은 create,updated,delete에 해당합니다.
//
//	executeQuery : 수행결과 ResultSet 객체의 값을 반환합니다.
//	select 구문을 수행할 때만 사용할 수 있습니다.
//
//	여기서 ResultSet 객체란 Select(조회)기능을 가지고 있는 인터페이스를 말합니다.
//	ResultSet은 Select와 친구인 것 같습니다 
//	Select문의 결과를 저장하는 하나의 객체로서 저장된 데이터를 한행 단위로 불러 올 수 있게 되고 값을 가져올 때 타입을 지정해 불러올 수 있다는 특징도 있다고 합니다. 
	// rs.next() ResultSet 값이 존재하면 True 값을 반환하고 다음 행에 값이 존재하면 True를 반환하고 그 값을 타입에 맞춰 반환해주게 된다. 

	public ArrayList<JjimListSelectDTO> Select(String nick, int cnt) {
		
		ArrayList<JjimListSelectDTO> list = new ArrayList<JjimListSelectDTO>();
		
			
		sql = "select dr_id , dr_des from drinkInfo where nick=? and cnt=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, nick);
			psmt.setInt(2, cnt);

			rs = psmt.executeQuery(); 
			
			//ResultSet의 get 계열의 메서드는 현재 커서에서 데이터를 읽어온다. 
			//ResultSet은 처음에 첫 번째 행 이전에 커서가 위치하기 때문에 첫 번째 행에 저장된 데이터를 읽으려면
			//아래와 같이 next()메서드를 사용해서 커서를 이동시켜야 한다. 
			
			//if(rs.next()){//다음 행이 존재하면 rs.next()는 true를 리턴
			//rs.next()에 의해 다음 행으로 이동 
			//String name = rs.getString("NAME");
			//~~~
			//}else{
			//첫 번째 행이 존재하지 않는다. 즉 ,결과가 없다
			//~~~~
			//}
			
			//1개 이상의 행을 처리할 때에는 while 구문이나 do-while 구문을 사용한다.
			//먼저 while 구문을 사용할 때에는 아래와 같은 형태를 띠게 된다.
			//rs = stmt.executeQuery();
			//while(rs.next()){
			//한행씩 반복 처리
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
