package com.admin.driver;

import java.util.Scanner;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.admin.employee.EmployeeDetails;
import com.admin.service.EmpServImpl;

public class DriverApp {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter First Name");
		String fname=sc.next();
		System.out.println("Please Enter Last Name");
		String lname=sc.next();
		EmployeeDetails e1=new EmployeeDetails();
		
		e1.setFirstname(fname);
		e1.setLastname(lname);
		
		EmpServImpl cs=new EmpServImpl();
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. HR");
		System.out.println("4. Legal");
		System.out.println("Please Enter Choice");
		int choice=sc.nextInt();
		String genemail="";
		String genpass="";
		switch(choice)
		{
			case 1:
				genemail=cs.generateEmail(e1.getFirstname().toLowerCase(), e1.getLastname().toLowerCase(), "tech");
				break;
			case 2:
				genemail=cs.generateEmail(e1.getFirstname().toLowerCase(), e1.getLastname().toLowerCase(), "admin");
				break;	
			case 3:
				genemail=cs.generateEmail(e1.getFirstname().toLowerCase(), e1.getLastname().toLowerCase(), "HR");
				break;
			case 4:
				genemail=cs.generateEmail(e1.getFirstname().toLowerCase(), e1.getLastname().toLowerCase(), "legal");
				break;
			default:
				System.out.println("Please Enter A Valid Choice");
		}
		genpass=cs.generatePassword();
		
		e1.setEmail(genemail);
		e1.setPassword(genpass);
		
		cs.showDetails(e1);
		
		String regex = "^(?=.*[a-z])(/=.*[A-Z])(?=.*\\d)"+"(?=.*[_!@#$%^&*.,?]).+$";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(genpass);
		if(m.matches())
			System.out.println("Access Granted.");
		else
			System.out.println("Invalid Password");
		
		
	}

}
