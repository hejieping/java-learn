package chapter2;

/**
 * 
 * @author jieping
 * 
 */
public class classReference
{

	/**
	 * @param args
	 */

	String nameString;

	public classReference()
	{

	}

	public static void main(String[] args)
	{
		// TODO �Զ����ɵķ������
		// java�Ķ����������������һ���������Ը�ֵ������������һ���������Ҳ������ͬ����
		classReference c1 = new classReference();
		c1.nameString = "name_one";
		System.out.println(c1.nameString);
		classReference c2 = c1; // c1 c2����ͬһ����
		c2.nameString = "name_two";
		// c1.nameString = "name_two"; //c1 c2�����ԶԸö�������޸�
		System.out.println(c1.nameString);

	}

}
