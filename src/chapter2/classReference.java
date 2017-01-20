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
		// TODO 自动生成的方法存根
		// java的对象变量仅仅是引用一个对象，所以赋值操作会让另外一个对象变量也引用相同对象
		classReference c1 = new classReference();
		c1.nameString = "name_one";
		System.out.println(c1.nameString);
		classReference c2 = c1; // c1 c2引用同一对象
		c2.nameString = "name_two";
		// c1.nameString = "name_two"; //c1 c2都可以对该对象进行修改
		System.out.println(c1.nameString);

	}

}
