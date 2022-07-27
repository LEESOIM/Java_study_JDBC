package com.iu.countries;

import java.util.ArrayList;

public class CountriesView {
	
	public void view(CountriesDTO countriesDTO) {
		System.out.print(countriesDTO.getCountry_id()+"\t\t");
		System.out.print(countriesDTO.getRegion_id()+"\t\t");
		System.out.println(countriesDTO.getCountry_name());
	}
	
	public void view(ArrayList<CountriesDTO> ar) {
		System.out.println("COUNTRY_ID\tREGION_ID\tCOUNTRY_NAME");
		for(CountriesDTO countriesDTO : ar) {
			this.view(countriesDTO);
		}
	}
}
