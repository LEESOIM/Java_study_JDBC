package com.iu.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

import com.iu.countries.CountriesDTO;
import com.iu.util.DBConnector;

public class EmployeesDAO {
	
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
			employeesDTO.setHire_date(rs.getString(6));
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
			employeesDTO.setHire_date(rs.getString(6));
			employeesDTO.setJob_id(rs.getString(7));
			employeesDTO.setSalary(rs.getInt(8));
			employeesDTO.setCommission_pct(rs.getDouble(9));
			employeesDTO.setManager_id(rs.getInt(10));
			employeesDTO.setDepartment_id(rs.getInt(11));
		}
		
		DBConnector.disConnect(rs, st, con);
		return employeesDTO;
	}
}
