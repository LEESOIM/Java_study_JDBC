package com.iu.employees;

import java.util.ArrayList;

public class EmployeesView {
	
	public void view(ArrayList<EmployeesDTO> ar) {
		
		for(EmployeesDTO employeesDTO : ar) {
			this.view(employeesDTO);;
		}
	}
	
	public void view(EmployeesDTO employeesDTO) {
		System.out.print(employeesDTO.getEmployee_id()+"\t");
		System.out.print(employeesDTO.getFirst_name()+" ");
		System.out.print(employeesDTO.getLast_name()+"\t");
		System.out.print(employeesDTO.getEmail()+"\t");
		System.out.println(employeesDTO.getPhon_number());
		System.out.print(employeesDTO.getHire_date()+"\t");
		System.out.print(employeesDTO.getJob_id()+"\t");
		System.out.print(employeesDTO.getSalary()+"\t");
		System.out.print(employeesDTO.getCommission_pct()+"\t");
		System.out.print(employeesDTO.getManager_id()+"\t");
		System.out.println(employeesDTO.getDepartment_id()+"\t");
		System.out.println("--------------------------------------------------------------------");
	
	}

}
