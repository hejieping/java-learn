package chapter1;

import java.util.Scanner;

public class javaIO
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO �Զ����ɵķ������
		Scanner inScanner = new Scanner(System.in);
		String readString = inScanner.next();
		System.out.println(readString); // ��console��ȡ�ַ���
		inScanner.close();

	}
}
