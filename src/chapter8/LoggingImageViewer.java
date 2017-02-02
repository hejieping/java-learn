package chapter8;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

public class LoggingImageViewer
{
	public static void main(String[] args)
	{
		if (System.getProperty("java.util.logging.config.class") == null
				&& System.getProperty("java.util.logging.config.file") == null)
		{
			try
			{
				Logger.getLogger("com.horstman.corejava").setLevel(Level.ALL);
				final int LOG_ROTATION_COUNT = 10;
				Handler handler = new FileHandler("%h/LoggingImageViewer.log",
						0, LOG_ROTATION_COUNT);
				Logger.getLogger("com.horstman.corejava").addHandler(handler);

			} catch (IOException e)
			{
				// TODO: handle exception
				Logger.getLogger("com.horstman.corejava").log(Level.SEVERE,
						"can't create log file handler", e);
			}
		}

		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				Handler windowHandler = new WindowHandler();
				windowHandler.setLevel(Level.ALL);
				Logger.getLogger("com.horstman.corejava")
						.addHandler(windowHandler);
				JFrame frame = new ImageViewerFrame();
				frame.setTitle("LogingImageViewer");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Logger.getLogger("com.horstman.corejava")
						.fine("showing a frame");
				frame.setVisible(true);
			}
		});
	}
}

class ImageViewerFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	private JLabel label;
	private static Logger logger = Logger.getLogger("com.horstman.corejava");

	public ImageViewerFrame()
	{
		logger.entering("imageViewerFrame", "<init>");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		JMenuItem openitem = new JMenuItem("open");
		menu.add(openitem);
		openitem.addActionListener(new FileOpenListener());

		JMenuItem exititem = new JMenuItem("exit");
		menu.add(exititem);
		exititem.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				logger.fine("exiting : ");
				System.exit(0);

			}
		});
		label = new JLabel();
		add(label);
		logger.exiting("imageViewerFrame", "<init>");
	}

	private class FileOpenListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			logger.entering("ImageViewerFrame.FileOpenListener",
					"actionPerformed", e);

			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("."));
			chooser.setFileFilter(new FileFilter()
			{

				@Override
				public String getDescription()
				{
					// TODO Auto-generated method stub
					return "GIF IMAGE";
				}

				@Override
				public boolean accept(File f)
				{
					// TODO Auto-generated method stub
					return f.getName().toLowerCase().endsWith(".gif")
							|| f.isDirectory();
				}
			});

			int r = chooser.showOpenDialog(ImageViewerFrame.this);
			if (r == JFileChooser.APPROVE_OPTION)
			{
				String name = chooser.getSelectedFile().getPath();
				logger.log(Level.FINE, "Reading file{0}", name);
				label.setIcon(new ImageIcon(name));
			} else
			{
				logger.fine("File open dialog canceled");
			}
			logger.exiting("ImageViewerFrame.FileOpenListener",
					"actionPerformed");
		}
	}

}

class WindowHandler extends StreamHandler
{
	private JFrame frame;

	public WindowHandler()
	{
		frame = new JFrame();
		final JTextArea output = new JTextArea();
		output.setEditable(false);
		frame.setSize(200, 200);
		frame.add(new JScrollPane(output));
		frame.setFocusableWindowState(false);
		frame.setVisible(true);
		setOutputStream(new OutputStream()
		{

			@Override
			public void write(int b)
			{
				// TODO Auto-generated method stub

			}

			public void write(byte[] b, int off, int len)
			{
				// TODO Auto-generated method stub
				output.append(new String(b, off, len));

			}
		});
	}

	public void publish(LogRecord record)
	{
		if (!frame.isVisible())
			return;
		super.publish(record);
		flush();
	}
}
