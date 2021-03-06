package chapter9;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Scanner;

public class GenericReflectionTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String name;
		if (args.length > 0)
		{
			name = args[0];

		} else
		{
			Scanner in = new Scanner(System.in);
			System.out
					.println("enter a class name(e.g java.util.Collections) :");
			name = in.next();
		}
		try
		{
			Class<?> cl = Class.forName(name);
			printClass(cl);
			for (Method m : cl.getDeclaredMethods())
			{
				printMethod(m);
			}
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void printClass(Class<?> cl)
	{
		System.out.print(cl);
		printTypes(cl.getTypeParameters(), "<", ", ", ">", true);
		Type sc = cl.getGenericSuperclass();
		if (sc != null)
		{
			System.out.print(" extends ");
			printType(sc, false);
		}
		printTypes(cl.getGenericInterfaces(), " implements", ", ", "", false);
		System.out.println();
	}

	public static void printMethod(Method m)
	{
		String name = m.getName();
		System.out.print(Modifier.toString(m.getModifiers()));
		System.out.print(" ");
		printTypes(m.getTypeParameters(), "<", ", ", "> ", true);
		printType(m.getGenericReturnType(), false);
		System.out.print(" ");
		System.out.print(name);
		System.out.print("(");
		printTypes(m.getGenericParameterTypes(), "", ", ", "", false);
		System.out.println(")");

	}

	public static void printTypes(java.lang.reflect.Type[] types, String pre,
			String seq, String suf, boolean isDefinition)
	{
		if (pre.equals(" extends ")
				&& Arrays.equals(types, new java.lang.reflect.Type[]
				{ Object.class }))
		{
			return;
		}
		if (types.length > 0)
		{
			System.out.print(pre);
		}
		for (int i = 0; i < types.length; i++)
		{
			if (i > 0)
			{
				System.out.print(seq);
			}
			printType(types[i], isDefinition);
		}
		if (types.length > 0)
		{
			System.out.print(suf);
		}

	}

	public static void printType(java.lang.reflect.Type type,
			boolean isDefinition)
	{
		if (type instanceof Class)
		{
			Class<?> t = (Class<?>) type;
			System.out.print(t.getName());

		} else if (type instanceof TypeVariable)
		{
			TypeVariable<?> t = (TypeVariable<?>) type;
			System.out.print(t.getName());
			if (isDefinition)
			{
				printTypes(t.getBounds(), " extends ", " & ", "", false);
			}
		} else if (type instanceof WildcardType)
		{
			WildcardType t = (WildcardType) type;
			System.out.print("?");
			printTypes(t.getUpperBounds(), " extends ", " & ", "", false);
			printTypes(t.getLowerBounds(), " super ", " & ", "", false);
		} else if (type instanceof ParameterizedType)
		{
			ParameterizedType t = (ParameterizedType) type;
			Type owner = t.getOwnerType();
			if (owner != null)
			{
				printType(owner, false);
				System.out.print(".");
			}
			printType(t.getRawType(), false);
			printTypes(t.getActualTypeArguments(), "<", ", ", ">", false);
		} else if (type instanceof GenericArrayType)
		{
			GenericArrayType t = (GenericArrayType) type;
			System.out.print("");
			printType(t.getGenericComponentType(), isDefinition);
			System.out.print("[]");
		}
	}
}
