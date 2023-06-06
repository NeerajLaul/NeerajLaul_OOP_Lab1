package com.admin.service;

import java.util.Random;
import com.admin.employee.EmployeeDetails;

public class EmpServImpl implements EmpServ{

	@Override
	public String generateEmail(String firstname, String lastname, String dept) {
		
		return firstname+lastname+"@"+dept+"company.com";
	}

	@Override
	public String generatePassword() {
		String caps="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lows="abcdefghijklmnopqrstuvwxyz";
		String num="0123456789";
		String spl="!@#$%^&*()";
		
		String combined=caps+lows+num+spl;
		
		String genPass="";
		Random random=new Random();
		
		for(int i=0;i<8;i++)
		{
			genPass=genPass+String.valueOf(combined.charAt(random.nextInt(combined.length())));
		}
		
		return genPass;
	}

	@Override
	public void showDetails(EmployeeDetails e1) {
		System.out.println("Employee First Name is "+ e1.getFirstname());
		System.out.println("Employee Last Name is "+ e1.getLastname());
		System.out.println("Employee E-mail ID is "+ e1.getEmail());
		System.out.println("Employee Password is "+ e1.getPassword());
		
	}
	public String generateEmailID(EmployeeDetails e1, String dept) {
		String genEmail=e1.getFirstname().toLowerCase()+e1.getLastname().toLowerCase()+"@"+dept+"company.com";
		return genEmail;
	}

}
