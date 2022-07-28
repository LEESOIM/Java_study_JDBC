package com.iu.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class RegionsDAO {
	
	// 1. Regions 테이블의 모든 데이터 가져오기
	public ArrayList<RegionsDTO> getList() throws Exception {
		 ArrayList<RegionsDTO> ar = new ArrayList();
		 
		// 1) DB 연결
		Connection con = DBConnector.getConnection();
		
		// 2) Query문 작성
		String sql = "SELECT * FROM REGIONS";
		
		// 3) Query문 미리 전송(준비 단계)
		PreparedStatement st = con.prepareStatement(sql);
		
		// 4) (지금은 쿼리문이라 할게없음)
		
		// 5) 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		//한줄 읽으세요(데이터가 있으면 true, 없으면 false) -> .next() : 먼저 한줄을 꺼내와야 데이터에 값을 넣을 수 있음!
		while(rs.next()) {//.next() : return타입 boolean
			RegionsDTO regionsDTO = new RegionsDTO();
			regionsDTO.setRegion_id(rs.getInt("Region_id"));
			regionsDTO.setRegion_name(rs.getString("Region_name"));
			ar.add(regionsDTO);
		}
		
		// 6) 자원 해제
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
	
	// 2. Regions 테이블에서 하나의 결과 가져오기(row)
	public RegionsDTO getDetail(int regionId) throws Exception {
		
		RegionsDTO regionsDTO = null;
		
		// 1) DB 연결
		Connection con = new DBConnector().getConnection();
		// 2) Query문 작성
		String sql = "SELECT * FROM REGIONS WHERE REGION_ID = ?"; //변수로 들어갈 값을 ?로 처리
		// 3) 미리 전송(준비 단계)
		PreparedStatement st = con.prepareStatement(sql);
		// 4) ? 값 세팅
		st.setInt(1, regionId); //첫번째 인자값 : 물음표의 순서(몇번째 인덱스냐? 오라클은 1번부터 셈)
								 //두번째 인자값 : 매개변수
							     // ex) WHERE NUM BETWEEN ?(1) AND ?(2)
		// 5) 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			regionsDTO = new RegionsDTO();
			regionsDTO.setRegion_id(rs.getInt("region_id"));
			regionsDTO.setRegion_name(rs.getString("REGION_NAME"));
		}
		
		// 6) 자원해제
		DBConnector.disConnect(rs, st, con);
		
		return regionsDTO;
	}
	
	
	public int setRegion(RegionsDTO regionsDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO REGIONS VALUES(?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, regionsDTO.getRegion_id());
		st.setString(2, regionsDTO.getRegion_name());
		//5) 최종 전송 후 결과 처리(1이면 성공, 0이면 실패)
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}

}
