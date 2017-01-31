package chapter7;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.prefs.Preferences;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class PreferenceTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				PreferenceFrame frame = new PreferenceFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

}

class PreferenceFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;

	public PreferenceFrame()
	{
		// TODO Auto-generated constructor stub
		Preferences root = Preferences.userRoot();
		final Preferences node = root.node("/com/horstman/corejava");
		int left = node.getInt("left", 0);
		int top = node.getInt("top", 0);
		int width = node.getInt("width", DEFAULT_WIDTH);
		int height = node.getInt("height", DEFAULT_HEIGHT);
		setBounds(left, top, width, height);

		String title = node.get("title", "");
		if (title.equals(""))
		{
			title = JOptionPane.showInputDialog("please supply a frame title");
		}
		if (title == null)
		{
			title = "";
		}
		setTitle(title);

		final JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setFileFilter(new FileFilter()
		{

			@Override
			public String getDescription()
			{
				// TODO Auto-generated method stub
				return "xml file";
			}

			@Override
			public boolean accept(File f)
			{
				// TODO Auto-generated method stub
				return f.getName().toLowerCase().endsWith(".xml")
						|| f.isDirectory();
			}
		});

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("File ");
		menuBar.add(menu);

		JMenuItem exportItem = new JMenuItem("export preference");
		menu.add(exportItem);
		exportItem.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				if (chooser.showSaveDialog(
						PreferenceFrame.this) == JFileChooser.APPROVE_OPTION)
				{
					try
					{
						File temp = chooser.getSelectedFile();
						OutputStream out = new FileOutputStream(
								chooser.getSelectedFile());
						node.exportSubtree(out);
						out.close();

					} catch (Exception e2)
					{
						// TODO: handle exception
						e2.printStackTrace();
					}
				}

			}
		});

		JMenuItem importItem = new JMenuItem("import preference");
		menu.add(importItem);
		importItem.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				if (chooser.showSaveDialog(
						PreferenceFrame.this) == JFileChooser.APPROVE_OPTION)
				{
					try
					{
						InputStream in = new FileInputStream(
								chooser.getSelectedFile());
						Preferences.importPreferences(in);
						in.close();
					} catch (Exception e2)
					{
						// TODO: handle exception
						e2.printStackTrace();
					}
				}

			}
		});

		JMenuItem exitItem = new JMenuItem("exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				node.putInt("left", getX());
				node.putInt("top", getY());
				node.putInt("width", getWidth());
				node.putInt("height", getHeight());
				node.put("title", getTitle());
				System.exit(0);

			}
		});

	}

}
