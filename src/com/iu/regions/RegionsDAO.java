package com.iu.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.util.DBConnector;

public class RegionsDAO {
	
	// 1. Regions 테이블의 모든 데이터 가져오기
	public void getList() throws Exception {
	
		// 1. DB 연결
		Connection con = DBConnector.getConnection();
		
		// 2. Query문 작성
		String sql = "SELECT * FROM REGIONS";
		
		// 3. Query문 미리 전송(준비 단계)
		PreparedStatement st = con.prepareStatement(sql);
		
		// 4. (지금은 쿼리문이라 할게없음)
		
		// 5. 최종 전송 후 결과를 처리
		ResultSet rs = st.executeQuery();
		
		//한줄 읽으세요(데이터가 있으면 true, 없으면 false)
		while(rs.next()) {//.next() : return타입 boolean
			int id = rs.getInt("Region_id"); //이 컬럼에 있는 데이터를 한줄씩 꺼내오겠다
			String name = rs.getString("Region_name");
			System.out.println(id);
			System.out.println(name);
		}
		
	}

}
