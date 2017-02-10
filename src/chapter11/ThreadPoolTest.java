package chapter11;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out
				.println("enter base directory (e.g. /usr/local/jdk1.6.0/src)");
		String directory = in.nextLine();
		System.out.println("enter keyword (e.g. volatile):");
		String keyword = in.nextLine();

		ExecutorService pool = Executors.newCachedThreadPool();
		MatchCounter counter = new MatchCounter(new File(directory), keyword,
				pool);
		Future<Integer> result = pool.submit(counter);
		try
		{
			System.out.println(result.get() + " matching files.");

		} catch (ExecutionException e)
		{
			// TODO: handle exception
		} catch (InterruptedException e)
		{
			// TODO: handle exception
		}
		pool.shutdown();
		int largestPoolsize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
		System.out.println("largest pool size = " + largestPoolsize);
	}
}

/**
 * @author jieping
 *
 */
/**
 * @author jieping
 *
 */
class MatchCounter implements Callable<Integer>
{
	private File directory;
	private String keyword;
	private ExecutorService pool;
	private int count;

	public MatchCounter(File directory, String keyword, ExecutorService pool)
	{
		this.keyword = keyword;
		this.pool = pool;
		this.directory = directory;
	}

	@Override
	public Integer call() throws Exception
	{
		count = 0;
		try
		{
			File[] files = directory.listFiles();
			ArrayList<Future<Integer>> results = new ArrayList<>();
			for (File file : files)
			{
				if (file.isDirectory())
				{
					MatchCounter counter = new MatchCounter(file, keyword,
							pool);
					Future<Integer> result = pool.submit(counter);
					results.add(result);
				} else
				{
					if (search(file))
					{
						count++;
					}
					// search(file);
				}
			}
			for (Future<Integer> result : results)
			{
				try
				{
					count += result.get();
				} catch (ExecutionException e)
				{
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e)
		{
			// TODO: handle exception
		}
		return count;
	}

	public boolean search(File file)
	{
		try (Scanner in = new Scanner(file))
		{
			boolean found = false;
			while (!found && in.hasNextLine())
			{

				String line = in.nextLine();
				if (line.contains(keyword))
				{
					found = true;
				}
			}
			return found;
		} catch (IOException e)
		{

			return false;
		}
	}
	// public void search(File file) throws IOException
	// {
	// try (Scanner in = new Scanner(file))
	// {
	// int lineNumber = 0;
	// while (in.hasNextLine())
	// {
	// lineNumber++;
	// String line = in.nextLine();
	// if (line.contains(keyword))
	// {
	// System.out.printf("%s : %d ; %s %n", file.getPath(),
	// lineNumber, line);
	// }
	// }
	// }
	// }
}