package chapter9;

public class PairTest2
{
	public static void main(String[] args)
	{
		Manager ceo = new Manager("cus greedy", 80000, 2003, 8, 15);
		Manager cfo = new Manager("sid sneaky", 60000, 2003, 8, 15);
		Pair<Manager> buddies = new Pair<Manager>(ceo, cfo);
		printBUddies(buddies);

		ceo.setBonus(100000);
		cfo.setBonus(50000);
		Manager[] managers =
		{ ceo, cfo };
		Pair<Employee> result = new Pair<Employee>();
		minmaxBonus(managers, result);
		System.out.println("first : " + result.getFirst().getName()
				+ ", second: " + result.getSecond().getName());
		maxminBonus(managers, result);
	}

	public static void printBUddies(Pair<? extends Employee> p)
	{
		Employee first = p.getFirst();
		Employee second = p.getSecond();
		System.out.println(
				first.getName() + " and " + second.getName() + "are buddies");
	}

	public static void minmaxBonus(Manager[] a, Pair<? super Manager> result)
	{
		if (a == null || a.length == 0)
		{
			return;
		}
		Manager min = a[0];
		Manager max = a[0];
		for (int i = 0; i < a.length; i++)
		{
			if (min.getBonus() > a[i].getBonus())
			{
				min = a[i];
			}
			if (max.getBonus() < a[i].getBonus())
			{
				max = a[i];
			}
		}
		result.setFirst(min);
		result.setSecond(max);
	}

	public static void maxminBonus(Manager[] a, Pair<? super Manager> result)
	{
		minmaxBonus(a, result);
		PairAlg.swapHelper(result);
	}
}

class PairAlg
{
	public static boolean hasNull(Pair<?> p)
	{
		return p.getFirst() == null || p.getSecond() == null;
	}

	public static void swap(Pair<?> p)
	{
		swapHelper(p);
	}

	public static <T> void swapHelper(Pair<T> p)
	{
		T t = p.getFirst();
		p.setFirst(p.getSecond());
		p.setSecond(t);
	}
}
