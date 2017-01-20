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
		// TODO �Զ����ɵĹ��캯�����
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
		// TODO �Զ����ɵķ������
		int value = 666;
		methodpParameter m1 = new methodpParameter(666);
		methodpParameter m2 = new methodpParameter(666);
		System.out.println("before change basis data");
		System.out.println(value);
		methodpParameter.changeBasisData(value); // һ���������ܸı�һ�������������͵Ĳ���
		System.out.println("after change basis data");
		System.out.println(value);

		System.out.println("before change class data");
		System.out.println(m1.getValue());
		methodpParameter.changeClassData(m1); // һ���������Ըı�һ�����������״̬
		System.out.println("after change class data");
		System.out.println(m1.getValue());

		System.out.println("before change class reference");
		System.out.println(m2.getValue());
		methodpParameter.changeClassReference(m2);// һ�����������ö����������һ���µĶ���
		System.out.println("after change class reference");
		System.out.println(m2.getValue());

	}
}
