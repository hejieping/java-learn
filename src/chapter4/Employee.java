package chapter4;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable
{
	private String name;
	private double salary;
	private Date hireday;

	public Employee(String aname, double asalary)
	{
		name = aname;
		salary = asalary;
		hireday = new Date();
	}

	public Employee clone() throws CloneNotSupportedException
	{
		Employee cloned = (Employee) super.clone();
		cloned.hireday = (Date) hireday.clone();
		return cloned;
	}

	public void setHireDay(int year, int month, int day)
	{
		Date newhireday = new GregorianCalendar(year, month - 1, day).getTime();
		hireday.setTime(newhireday.getTime());
	}

	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public String toString()
	{
		return "Employee[name=" + name + ",salary=" + salary + ",hireDay="
				+ hireday + "]";
	}
}
