package com.design.structural;

import java.util.ArrayList;
import java.util.List;

interface Department {
	void printDepartmentName();
}

class FinancialDepartment implements Department {
	
	private Integer id;
	private String name;
	
	public FinancialDepartment(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void printDepartmentName() {
		System.out.println("Financial Department ");

	}
}

class SalesDepartment implements Department {
	
	private Integer id;
	private String name;
	
	public SalesDepartment(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void printDepartmentName() {
		System.out.println("Sales Department  ");

	}
}

class HeadDepartment implements Department {
	private String name;
	private List<Department> childDepartments;
	private Integer id;
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Department> getChildDepartments() {
		return childDepartments;
	}


	public void setChildDepartments(List<Department> childDepartments) {
		this.childDepartments = childDepartments;
	}


	public HeadDepartment(Integer id,String name) {
		this.id=id;
		this.name=name;
		this.childDepartments=new ArrayList<>();
	}

	
	public void printDepartmentName() {
		childDepartments.forEach(Department::printDepartmentName);

	}
	
	public void addDepartment(Department department) {
		childDepartments.add(department);
	}
	
	public void removeDepartment(Department department) {
		childDepartments.remove(department);
	}
}

public class CompositeDP_DepartmentOffice {

	public static void main(String[] args) {
		Department finanDepartment=new FinancialDepartment(1,"finalcial Department");
		Department salesDepartment=new SalesDepartment(2,"Sales Department ");
		HeadDepartment head=new HeadDepartment(3, "Head Department");
		head.addDepartment(salesDepartment);
		head.addDepartment(finanDepartment);
		head.printDepartmentName();

	}

}
