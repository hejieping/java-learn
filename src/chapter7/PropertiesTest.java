package chapter7;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PropertiesTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				PropertiesFrame frame = new PropertiesFrame();
				frame.setVisible(true);
			}
		});

	}

}

class PropertiesFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	private File propertiesFile;
	private Properties settings;

	public PropertiesFrame()
	{
		String userDir = System.getProperty("user.home");
		File propertiesDir = new File(userDir, ".corejava");
		if (!propertiesDir.exists())
		{
			propertiesDir.mkdir();
		}
		propertiesFile = new File(propertiesDir, "program.properties");

		Properties defualtSettings = new Properties();
		defualtSettings.put("left", "0");
		defualtSettings.put("top", "0");
		defualtSettings.put("width", "" + DEFAULT_WIDTH);
		defualtSettings.put("height", "" + DEFAULT_WIDTH);
		defualtSettings.put("title", "");

		settings = (Properties) defualtSettings.clone();
		if (propertiesFile.exists())
			try
			{
				FileInputStream in = new FileInputStream(propertiesFile);
				settings.load(in);
			} catch (Exception e)
			{
				// TODO: handle exception
				e.printStackTrace();
			}

		int left = Integer.parseInt(settings.getProperty("left"));
		int top = Integer.parseInt(settings.getProperty("top"));
		int width = Integer.parseInt(settings.getProperty("width"));
		int height = Integer.parseInt(settings.getProperty("height"));
		setBounds(left, top, width, height);
		String title = settings.getProperty("title");
		if (title.equals(""))
		{
			title = JOptionPane.showInputDialog("please supply a frame title");

		}
		if (title == null)
		{
			title = "";
		}
		setTitle(title);

		addWindowListener(new WindowAdapter()
		{

			public void windowClosing(WindowEvent e)
			{
				// TODO Auto-generated method stub
				settings.put("left", "" + getX());
				settings.put("top", "" + getY());
				settings.put("width", "" + getWidth());
				settings.put("height", "" + getHeight());
				settings.put("title", getTitle());
				try
				{
					FileOutputStream out = new FileOutputStream(propertiesFile);
					settings.store(out, "program properties");
				} catch (Exception e2)
				{
					// TODO: handle exception
					e2.printStackTrace();
				}
				System.exit(0);

			}

		});

	}
}
