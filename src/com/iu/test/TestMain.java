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
		
		
		RegionsDAO regionsDAO = new RegionsDAO();
		RegionsView regionsView = new RegionsView();
		CountriesView countriesView = new CountriesView();
		
		try {
			
//			RegionsDTO regionsDTO = regionsDAO.getDetail(1);
//			regionsView.view(regionsDTO);
			
//			ArrayList<RegionsDTO> ar = regionsDAO.getList();
//			regionsView.view(ar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		CountriesDAO countriesDAO = new CountriesDAO();
		try {
			
//			CountriesDTO countriesDTO = countriesDAO.getDetail("JP");
//			countriesView.view(countriesDTO);
			
//			ArrayList<CountriesDTO> ar = countriesDAO.getList();
//			countriesView.view(ar);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EmployeesDAO employeesDAO = new EmployeesDAO();
		EmployeesView employeesView = new EmployeesView();
		ArrayList<EmployeesDTO> ar = new ArrayList();
		
		try {
//			ar = employeesDAO.getList();
//			employeesView.view(ar);
			
			EmployeesDTO employeesDTO = employeesDAO.getDetail(105);
			employeesView.view(employeesDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
