package com.iu.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class CountriesDAO {

	public ArrayList<CountriesDTO> getList() throws Exception {
		ArrayList<CountriesDTO> ar = new ArrayList<>();
		
		// 1. DB 연결
		Connection con = DBConnector.getConnection();
		// 2. SQL 작성
		String sql = "SELECT * FROM COUNTRIES";
		// 3. 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);
		// 4. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			CountriesDTO countriesDTO = new CountriesDTO();
			countriesDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			countriesDTO.setCountry_name(rs.getString("COUNTRY_NAME"));
			countriesDTO.setRegion_id(rs.getInt("region_id"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return ar;
	}
	
	
	public CountriesDTO getDetail(String countryId) throws Exception {
		CountriesDTO countriesDTO = null;
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, countryId);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			countriesDTO = new CountriesDTO();
			countriesDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			countriesDTO.setCountry_name(rs.getString("COUNTRY_NAME"));
			countriesDTO.setRegion_id(rs.getInt("region_id"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return countriesDTO;
	}
}
