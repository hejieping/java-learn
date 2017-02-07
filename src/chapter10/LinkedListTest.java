package chapter10;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest
{
	public static void main(String[] args)
	{
		java.util.List<String> a = new LinkedList<String>();
		a.add("Amy");
		a.add("Carl");
		a.add("Erica");

		List<String> b = new LinkedList<String>();
		b.add("Bob");
		b.add("Doug");
		b.add("Frances");
		b.add("GLoria");

		ListIterator<String> aIterator = a.listIterator();
		Iterator<String> bIterator = b.iterator();

		while (bIterator.hasNext())
		{
			if (aIterator.hasNext())
			{
				aIterator.next();
			}
			aIterator.add(bIterator.next());
		}
		System.out.println(a);

		bIterator = b.iterator();
		while (bIterator.hasNext())
		{
			bIterator.next();
			if (bIterator.hasNext())
			{
				bIterator.next();
				bIterator.remove();
			}
		}
		System.out.println(b);
		a.removeAll(b);
		System.out.println(a);

	}
}
