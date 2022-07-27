package com.iu.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.util.DBConnector;

public class CountriesDAO {

	public void getList() throws Exception {
		// 1. DB 연결
		Connection con = DBConnector.getConnection();
		// 2. SQL 작성
		String sql = "SELECT * FROM countries";
		// 3. 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);
		// 4. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String id = rs.getString("COUNTRY_ID");
			String name = rs.getString("COUNTRY_NAME");
			int r_id = rs.getInt("REGION_ID");
			System.out.println(id+"\t"+name+"\t"+r_id);
		}
	}
}
