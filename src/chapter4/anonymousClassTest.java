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
		// TODO �Զ����ɵķ������
		Print(new ArrayList<String>() // ������
		{
			{
				add("jabe");
				add("mack");
			}
		});

	}
}
