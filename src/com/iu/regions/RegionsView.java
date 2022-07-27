package com.iu.regions;

import java.util.ArrayList;

public class RegionsView {

	//view
	public void view(RegionsDTO regionsDTO) throws Exception {			
		System.out.println("Region_ID\tRegion_name");
		System.out.print(regionsDTO.getRegion_id()+"\t\t");
		System.out.println(regionsDTO.getRegion_name());
		System.out.println("----------------------------");
	}
	
	public void view(ArrayList<RegionsDTO> ar) throws Exception {
		
		for(RegionsDTO regionsDTO : ar) {
			this.view(regionsDTO);
		}
	}
}
