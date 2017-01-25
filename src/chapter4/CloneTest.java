package chapter4;

public class CloneTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		try
		{
			Employee original = new Employee("jane", 50000);
			original.setHireDay(2000, 1, 1);
			Employee copy = original.clone();
			copy.raiseSalary(10);
			copy.setHireDay(2002, 12, 31);
			System.out.println("original = " + original);
			System.out.println("copy = " + copy);
		} catch (Exception e)
		{
			// TODO: handle exception
		}

	}
}
