package com.sshres.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private Integer emp_id;
	private String first_name;
	private String last_name;
	private String gender;	

}
