package chapter3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @version 1.1 2017-01-23
 * @author jieping
 * 
 */
public class ReflectionTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		String name;
		if (args.length > 0)
		{
			name = args[0];
		} else
		{
			Scanner in = new Scanner(System.in);
			System.out.println("enter class name (e.g java.util.Date): ");
			name = in.next();
		}

		try
		{
			Class cl = Class.forName(name);
			Class supercl = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());
			if (modifiers.length() > 0)
			{
				System.out.println(modifiers + " ");
			}
			System.out.println("class " + name);
			if (supercl != null && supercl != Object.class)
			{
				System.out.println(" extends " + supercl.getName());
			}

			System.out.println("\n{\n");
			printConstructors(cl);
			System.out.println();
			printMethods(cl);
			System.out.println();
			printFields(cl);
			System.out.println();
			System.out.println("}");
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		System.exit(0);
	}

	/**
	 * print all methods of a class
	 * 
	 * @param cl
	 */
	public static void printMethods(Class cl)
	{
		Method[] methods = cl.getMethods();
		for (Method m : methods)
		{
			Class retType = m.getReturnType();
			String name = m.getName();
			System.out.println("   ");
			String modfiers = Modifier.toString(m.getModifiers());
			if (modfiers.length() > 0)
			{
				System.out.print(modfiers + "  ");
			}
			System.out.print(retType.getName() + " " + name + "(");

			Class[] paramType = m.getParameterTypes();
			for (int i = 0; i < paramType.length; i++)
			{
				if (i > 0)
				{
					System.out.print(", ");
				}
				System.out.print(paramType[i].getName());
			}
			System.out.println(");");
		}
	}

	public static void printConstructors(Class cl)
	{
		Constructor[] constructors = cl.getConstructors();
		for (Constructor c : constructors)
		{
			String name = c.getName();
			System.out.println("   ");
			String modifiers = Modifier.toString(c.getModifiers());
			if (modifiers.length() > 0)
			{
				System.out.println(modifiers + " ");
			}
			System.out.print(name + "(");

			Class[] paramType = c.getParameterTypes();
			for (int i = 0; i < paramType.length; i++)
			{
				if (i > 0)
				{
					System.out.print(", ");
				}
				System.out.print(paramType[i].getName());
			}
			System.out.println(");");

		}
	}

	public static void printFields(Class cl)
	{
		Field[] fields = cl.getFields();
		for (Field f : fields)
		{
			Class type = f.getType();
			String name = f.getName();
			System.out.print("   ");
			String modifiers = Modifier.toString(f.getModifiers());
			if (modifiers.length() > 0)
			{
				System.out.print(modifiers + " ");

			}
			System.out.println(type.getName() + " " + name + ";");
		}
	}
}
