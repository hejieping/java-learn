package chapter1;

import java.util.Scanner;

public class javaIO
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		Scanner inScanner = new Scanner(System.in);
		String readString = inScanner.next();
		System.out.println(readString); // 从console读取字符串
		inScanner.close();

	}
}
