package com.admin.service;

import com.admin.employee.EmployeeDetails;
public interface EmpServ {
	String generateEmail(String firstname, String lastname, String dept);
	String generatePassword();
	void showDetails(EmployeeDetails e1);
}
