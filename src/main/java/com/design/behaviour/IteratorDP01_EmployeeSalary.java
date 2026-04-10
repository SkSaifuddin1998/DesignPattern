package com.design.behaviour;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

//Employee class
class Employee {
	private String name;
	private double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}
}

//Iterator interface
interface Iterator<T> {
	boolean hasNext();
	T next();
}

//Aggregate interface
interface Aggregate<T> {
	Iterator<T> createIterator();
}

//Concrete Iterator
class EmployeeIterator implements Iterator<Employee> {
	private int currentIndex = 0;
	private List<Employee> employees;

	public EmployeeIterator(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public boolean hasNext() {
		return currentIndex < employees.size();
	}

	@Override
	public Employee next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return employees.get(currentIndex++);
	}
}

//Concrete Aggregate
class Company implements Aggregate<Employee> {
	private List<Employee> employees;

	public Company(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public Iterator<Employee> createIterator() {
		return new EmployeeIterator(employees);
	}
}

public class IteratorDP01_EmployeeSalary {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 50000));
        employees.add(new Employee("Bob", 60000));
        employees.add(new Employee("Charlie", 70000));
        
        Company company=new Company(employees);
        
        Iterator<Employee> itarator=company.createIterator();
        int totalSalary=0;
        
        while(itarator.hasNext()) {
        	totalSalary+=itarator.next().getSalary();
        }
        
        System.out.println("Total Salary is :"+totalSalary);

	}

}
