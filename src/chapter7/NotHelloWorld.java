package chapter7;

import java.awt.EventQueue;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class NotHelloWorld extends JApplet
{
	public void init()
	{
		EventQueue.invokeLater(new Runnable()
		{

			public void run()
			{
				// TODO Auto-generated method stub
				JLabel label = new JLabel("not a hello world ,applet",
						SwingConstants.CENTER);
				add(label);

			}
		});
	}

}
