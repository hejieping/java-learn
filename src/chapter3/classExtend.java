package chapter3;

class parent
{
	private String name;
	private String id;

	public parent(String aname, String aid)
	{
		// TODO 自动生成的构造函数存根
		name = aname;
		id = aid;
	}

	public String getname()
	{
		return name;
	}

	public String getid()
	{
		return id;
	}
}

class son extends parent
{
	private int salary;

	public son(String aname, String aid, int asalary)
	{
		// TODO 自动生成的构造函数存根
		super(aname, aid);
		salary = asalary;
	}

	public int getsalary()
	{
		return salary;
	}
}

final class boss // 不能被扩展的类
{

}

abstract class person
{
	private String name;

	public person(String aname)
	{
		name = aname;
	}

	public abstract String getDescription();

	public String getName()
	{
		return name;
	}
}

class lady extends person
{
	public lady(String aname)
	{
		super(aname);
		// TODO 自动生成的构造函数存根
	}

	final void method() // 不能被子类覆盖的方法
	{

	}

	public String getDescription()
	{
		return "this is lady";
	}
}

class gentleman extends person
{

	public gentleman(String aname)
	{
		super(aname);
		// TODO 自动生成的构造函数存根
	}

	public String getDescription()
	{
		return "this is  gentleman";
	}

}

public class classExtend
{

	/**
	 * @param args
	 */

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根

		// son s = new son("jane", "213", 10000);
		// System.out.println(s.getname());
		// System.out.println(s.getid());
		// System.out.println(s.getsalary());
		lady l = new lady("jane");
		gentleman g = new gentleman("jack");
		System.out.println(l.getDescription());
		System.out.println(g.getDescription());

	}

}
