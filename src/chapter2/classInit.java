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
	// ��ʼ���� ��id��ʼ��Ϊ1
	{
		id = 1;
	}

	public int getId()
	{
		return id;
	}

	public classInit()
	{
		// TODO �Զ����ɵĹ��캯�����
	}

	public static void main(String[] args)
	{
		// TODO �Զ����ɵķ������
		classInit c = new classInit();
		System.out.println(c.getId());

	}

}
