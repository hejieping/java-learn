package chapter3;

class parent
{
	private String name;
	private String id;

	public parent(String aname, String aid)
	{
		// TODO �Զ����ɵĹ��캯�����
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
		// TODO �Զ����ɵĹ��캯�����
		super(aname, aid);
		salary = asalary;
	}

	public int getsalary()
	{
		return salary;
	}
}

final class boss // ���ܱ���չ����
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
		// TODO �Զ����ɵĹ��캯�����
	}

	final void method() // ���ܱ����า�ǵķ���
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
		// TODO �Զ����ɵĹ��캯�����
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
		// TODO �Զ����ɵķ������

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
