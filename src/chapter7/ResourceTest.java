package chapter7;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;

class ResourceTestFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HIEGHT = 300;

	public ResourceTestFrame()
	{
		setSize(DEFAULT_HIEGHT, DEFAULT_WIDTH);

		URL abountUrl = getClass().getResource("about.jpg");// 从找到该类的地方查找about.jpg
		Image img = new ImageIcon(abountUrl).getImage();
		setIconImage(img);

		JTextArea textArea = new JTextArea();
		InputStream stream = getClass().getResourceAsStream("about.txt");
		Scanner in = new Scanner(stream);
		while (in.hasNext())
		{
			textArea.append(in.nextLine() + "\n");
		}
		add(textArea);
		setTitle("resourceTest");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

	}
}

public class ResourceTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		EventQueue.invokeLater(new Runnable()
		{

			public void run()
			{
				// TODO 自动生成的方法存根
				ResourceTestFrame frame = new ResourceTestFrame();

			}
		});

	}
}
