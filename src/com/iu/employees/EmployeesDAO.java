package com.iu.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

import com.iu.countries.CountriesDTO;
import com.iu.departments.DepartmentsDTO;
import com.iu.util.DBConnector;

public class EmployeesDAO {
	
	public void getSalaryInfo() throws Exception {
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		//2. SQL문 작성
		String sql = "SELECT SUM(SALARY), AVG(SALARY), MAX(SALARY) 최대값 FROM EMPLOYEES";
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4. ? 있으면 값 세팅
		//5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		if(rs.next()) { //먼저 한줄을 꺼내와야 데이터에 값을 넣을 수 있음
			int sum = rs.getInt("SUM(SALARY)");
			double avg = rs.getDouble(2);
			int max = rs.getInt("최대값");
			System.out.println(sum);
			System.out.println(avg);
			System.out.println(max);
		}
		
		//6. 자원 해제
		DBConnector.disConnect(rs, st, con);
	}
	
	
	public ArrayList<EmployeesDTO> getList() throws Exception {
		
		ArrayList<EmployeesDTO> ar = new ArrayList();
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeesDTO employeesDTO = new EmployeesDTO();
			employeesDTO.setEmployee_id(rs.getInt(1));
			employeesDTO.setFirst_name(rs.getString(2));
			employeesDTO.setLast_name(rs.getString(3));
			employeesDTO.setEmail(rs.getString(4));
			employeesDTO.setPhon_number(rs.getString(5));
			employeesDTO.setHire_date(rs.getDate(6));
			employeesDTO.setJob_id(rs.getString(7));
			employeesDTO.setSalary(rs.getInt(8));
			employeesDTO.setCommission_pct(rs.getDouble(9));
			employeesDTO.setManager_id(rs.getInt(10));
			employeesDTO.setDepartment_id(rs.getInt(11));
			
			ar.add(employeesDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		return ar;
	}

	
	public EmployeesDTO getDetail(Integer employee_id) throws Exception {
		
		EmployeesDTO employeesDTO = null;
		
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, employee_id);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			employeesDTO = new EmployeesDTO();
			employeesDTO.setEmployee_id(rs.getInt(1));
			employeesDTO.setFirst_name(rs.getString(2));
			employeesDTO.setLast_name(rs.getString(3));
			employeesDTO.setEmail(rs.getString(4));
			employeesDTO.setPhon_number(rs.getString(5));
			employeesDTO.setHire_date(rs.getDate(6));
			employeesDTO.setJob_id(rs.getString(7));
			employeesDTO.setSalary(rs.getInt(8));
			employeesDTO.setCommission_pct(rs.getDouble(9));
			employeesDTO.setManager_id(rs.getInt(10));
			employeesDTO.setDepartment_id(rs.getInt(11));
		}
		
		DBConnector.disConnect(rs, st, con);
		return employeesDTO;
	}
	
	public ArrayList getJoinTest(EmployeesDTO employeesDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "SELECT E.LAST_NAME, E.SALARY, D.DEPARTMENT_NAME "
				+ "FROM employees E "
				+ "    INNER JOIN "
				+ "    departments D "
				+ "    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID "
				+ "WHERE E.EMPLOYEE_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, employeesDTO.getEmployee_id());
		ResultSet rs = st.executeQuery();
		ArrayList ar = new ArrayList();
		if(rs.next()) { //한줄이 있다면
			employeesDTO = new EmployeesDTO(); //더이상 안쓰는 변수에 새객체를 덮어씌움
			employeesDTO.setLast_name(rs.getString("LAST_NAME"));
			employeesDTO.setSalary(rs.getInt("SALARY"));
			ar.add(employeesDTO);
			
			DepartmentsDTO departmentsDTO = new DepartmentsDTO();
			departmentsDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			ar.add(departmentsDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
}
