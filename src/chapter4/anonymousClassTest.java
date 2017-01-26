package chapter4;

import java.util.ArrayList;

public class anonymousClassTest
{

	/**
	 * @param args
	 */
	public static void Print(ArrayList<String> list)
	{
		for (String s : list)
		{
			System.out.println(s);
		}
	}

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		Print(new ArrayList<String>() // 匿名类
		{
			{
				add("jabe");
				add("mack");
			}
		});

	}
}
