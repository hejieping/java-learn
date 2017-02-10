package chapter11;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueneTest
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out
				.println("enter base directory (e.g. /usr/local/jdk1.6.0/src)");
		String directory = in.nextLine();
		System.out.println("enter keyword (e.g. volatile):");
		String keyword = in.nextLine();
		final int FILE_QUEUE_SIZE = 10;
		final int SEARCH_THREADS = 100;
		BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
		FileEnumerationTask enumerator = new FileEnumerationTask(queue,
				new File(directory));
		new Thread(enumerator).start();
		for (int i = 0; i <= SEARCH_THREADS; i++)
		{
			new Thread(new SearchTask(queue, keyword)).start();
		}

	}
}

class FileEnumerationTask implements Runnable
{
	public static File DUMY = new File("");
	private BlockingQueue<File> queue;
	private File startingDirectory;

	public FileEnumerationTask(BlockingQueue<File> queue,
			File startingDirectoryz)
	{
		this.queue = queue;
		this.startingDirectory = startingDirectoryz;
	}

	public void run()
	{
		// TODO Auto-generated method stub
		try
		{
			enumerate(startingDirectory);
			queue.put(DUMY);
		} catch (Exception e)
		{
			// TODO: handle exception
		}

	}

	public void enumerate(File directory) throws InterruptedException
	{
		File[] files = directory.listFiles();
		for (File file : files)
		{
			if (file.isDirectory())
			{
				enumerate(file);
			} else
			{
				queue.put(file);
			}
		}
	}
}

class SearchTask implements Runnable
{
	private BlockingQueue<File> queue;
	private String keyword;

	public SearchTask(BlockingQueue<File> queue, String keyword)
	{
		this.keyword = keyword;
		this.queue = queue;
	}

	public void run()
	{
		// TODO Auto-generated method stub
		try
		{
			boolean done = false;
			while (!done)
			{
				File file = queue.take();
				if (file == FileEnumerationTask.DUMY)
				{
					queue.put(file);
					done = true;
				} else
				{
					search(file);
				}
			}
		} catch (IOException e)
		{
			// TODO: handle exception
			e.printStackTrace();
		} catch (InterruptedException e)
		{
			// TODO: handle exception
		}
	}

	public void search(File file) throws IOException
	{
		try (Scanner in = new Scanner(file))
		{
			int lineNumber = 0;
			while (in.hasNextLine())
			{
				lineNumber++;
				String line = in.nextLine();
				if (line.contains(keyword))
				{
					System.out.printf("%s : %d ; %s %n", file.getPath(),
							lineNumber, line);
				}
			}
		}
	}

}
