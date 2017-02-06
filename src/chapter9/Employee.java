package chapter9;

public class Employee
{
	private int bonus;
	private String name;

	public Employee(String name, int bonus, int year, int month, int day)
	{
		this.bonus = bonus;
		this.name = name;
	}

	public void setBonus(int bonus)
	{
		this.bonus = bonus;
	}

	public int getBonus()
	{
		return bonus;
	}

	public String getName()
	{
		return name;
	}

}
