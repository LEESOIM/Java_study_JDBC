package com.iu.test;

import java.util.ArrayList;

import com.iu.countries.CountriesDAO;
import com.iu.countries.CountriesDTO;
import com.iu.countries.CountriesView;
import com.iu.employees.EmployeesDAO;
import com.iu.employees.EmployeesDTO;
import com.iu.employees.EmployeesView;
import com.iu.regions.RegionsDAO;
import com.iu.regions.RegionsDTO;
import com.iu.regions.RegionsView;
import com.iu.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {

//		try {
//			DBConnector.getConnection();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		
		RegionsDAO regionsDAO = new RegionsDAO();
		RegionsView regionsView = new RegionsView();
		
		try {
			
//			RegionsDTO regionsDTO = regionsDAO.getDetail(1);
//			regionsView.view(regionsDTO);
			
//			ArrayList<RegionsDTO> ar = regionsDAO.getList();
//			regionsView.view(ar);
			
			RegionsDTO regionsDTO = new RegionsDTO();
//			regionsDTO.setRegion_id(6);
//			regionsDTO.setRegion_name("Mars");
//
//			int result = regionsDAO.setRegion(regionsDTO);
//			if(result > 0) {
//				System.out.println("성공"); //자바는 AutoCommit
//			} else { 
//				System.out.println("실패");
//			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		
		CountriesDAO countriesDAO = new CountriesDAO();
		CountriesView countriesView = new CountriesView();
		try {
			
//			CountriesDTO countriesDTO = countriesDAO.getDetail("JP");
//			countriesView.view(countriesDTO);
			
//			ArrayList<CountriesDTO> ar = countriesDAO.getList("M");
//			countriesView.view(ar);
			
			CountriesDTO countriesDTO = new CountriesDTO(); 
			countriesDTO.setCountry_id("MA");
			countriesDTO.setCountry_name("Mars");
			countriesDTO.setRegion_id(6);
			
			int result = countriesDAO.setCountry(countriesDTO);
			if(result > 0 ) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		
		EmployeesDAO employeesDAO = new EmployeesDAO();
		EmployeesView employeesView = new EmployeesView();
		
		try {
			
//			employeesDAO.getSalaryInfo();
			
//			EmployeesDTO employeesDTO = employeesDAO.getDetail(105);
//			employeesView.view(employeesDTO);

//			ArrayList<EmployeesDTO> ar = employeesDAO.getList();
//			employeesView.view(ar);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
