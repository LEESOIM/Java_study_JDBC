package com.iu.test;

import com.iu.countries.CountriesDAO;
import com.iu.regions.RegionsDAO;
import com.iu.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {

//		try {
//			DBConnector.getConnection();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		RegionsDAO regionsDAO = new RegionsDAO();
//		try {
//			regionsDAO.getList();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		CountriesDAO countriesDAO = new CountriesDAO();
		try {
			countriesDAO.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
