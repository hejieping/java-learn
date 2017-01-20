package chapter2;

/**
 * 
 * @author jieping
 * 
 * 
 */
public class methodpParameter
{

	/**
	 * @param args
	 */
	private int value;

	public int getValue()
	{
		return value;
	}

	public methodpParameter(int a)
	{
		// TODO 自动生成的构造函数存根
		value = a;
	}

	public static void changeBasisData(int value)
	{
		value = 777;
	}

	public static void changeClassData(methodpParameter m)
	{
		m.value = 777;
	}

	public static void changeClassReference(methodpParameter m)
	{
		m = new methodpParameter(777);
	}

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		int value = 666;
		methodpParameter m1 = new methodpParameter(666);
		methodpParameter m2 = new methodpParameter(666);
		System.out.println("before change basis data");
		System.out.println(value);
		methodpParameter.changeBasisData(value); // 一个方法不能改变一个基本数据类型的参数
		System.out.println("after change basis data");
		System.out.println(value);

		System.out.println("before change class data");
		System.out.println(m1.getValue());
		methodpParameter.changeClassData(m1); // 一个方法可以改变一个对象参数的状态
		System.out.println("after change class data");
		System.out.println(m1.getValue());

		System.out.println("before change class reference");
		System.out.println(m2.getValue());
		methodpParameter.changeClassReference(m2);// 一个方法不能让对象参数引用一个新的对象
		System.out.println("after change class reference");
		System.out.println(m2.getValue());

	}
}
