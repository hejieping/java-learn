package chapter2;

/**
 * 
 * @author jieping
 * 
 */
public class classInit
{

	/**
	 * @param args
	 */
	private int id;
	// 初始化块 将id初始化为1
	{
		id = 1;
	}

	public int getId()
	{
		return id;
	}

	public classInit()
	{
		// TODO 自动生成的构造函数存根
	}

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		classInit c = new classInit();
		System.out.println(c.getId());

	}

}
