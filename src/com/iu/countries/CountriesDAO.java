package com.iu.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class CountriesDAO {

	public ArrayList<CountriesDTO> getList(String search) throws Exception {
		ArrayList<CountriesDTO> ar = new ArrayList<>();
		
		// 1. DB 연결
		Connection con = DBConnector.getConnection();
		// 2. SQL 작성
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_NAME LIKE '%'||?||'%'"; // (1) '%'||?||'%'
		// 3. 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);
		// 4. ? 있으면 값 세팅
		st.setString(1, search); //(2) "%"+search+"%"
		// 5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			CountriesDTO countriesDTO = new CountriesDTO();
			countriesDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			countriesDTO.setCountry_name(rs.getString("COUNTRY_NAME"));
			countriesDTO.setRegion_id(rs.getInt("region_id"));
			
			ar.add(countriesDTO);
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
			countriesDTO.setRegion_id(rs.getInt("region_id"));
			countriesDTO.setCountry_name(rs.getString("COUNTRY_NAME"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return countriesDTO;
	}
	
	public int setCountry(CountriesDTO countriesDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO countries VALUES (?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, countriesDTO.getCountry_id());
		st.setString(2, countriesDTO.getCountry_name());
		st.setInt(3, countriesDTO.getRegion_id());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
}
