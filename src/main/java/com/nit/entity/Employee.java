package com.nit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
public class Employee {
	@Id
	@GenericGenerator(name = "gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")
	@Column(name="ID")
	private Integer empId;
	@Column(length = 30,name="Name")
	private String empName;
	@Column(length = 50,name="Address")
	private String empAddress;
	@Column(name = "Salary")
	private Double empSalary;
	@Column(name = "Designation")
	private String empDesg;
	@Column(name = "Gender",length = 10)
	private String empGender;
	@Column(name="Timings",length = 20)
	private String[] empTimings;
}
