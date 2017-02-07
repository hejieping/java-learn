package chapter10;

import java.util.Iterator;
import java.util.LinkedList;

public class iteratorTest
{
	public static void main(String[] args)
	{
		LinkedList<String> list = new LinkedList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");

		Iterator<String> i = list.iterator();
		// iterator在调用remove之前需要调用next
		i.next();
		i.remove();
		i.next();
		i.remove();

		for (String temp : list)
		{
			System.out.println(temp);
		}

	}
}
