package com.iu.test;

import java.util.ArrayList;

import com.iu.countries.CountriesDAO;
import com.iu.countries.CountriesDTO;
import com.iu.countries.CountriesView;
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
			countriesDAO.getList();
			countriesDAO.getDetail("AU");
			
			ArrayList<CountriesDTO> ar = countriesDAO.getList();
			countriesView.view(ar);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
