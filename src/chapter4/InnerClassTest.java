package chapter4;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class InnerClassTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		TalkingClock talkingClock = new TalkingClock();
		talkingClock.start(1000, true);

		JOptionPane.showMessageDialog(null, "quit program");
		System.exit(0);

	}
}

class TalkingClock
{
	private int interval;
	private boolean beep;

	public TalkingClock()
	{

	}

	public void start(int interval, final boolean beep)
	{

		class TimePrinter implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO 自动生成的方法存根
				Date now = new Date();
				System.out.println("at the tone,the time is " + now);
				if (beep) // 局部变量只能引用final的局部变量
				{
					Toolkit.getDefaultToolkit().beep();
				}

			}
		}
		ActionListener listener = new TimePrinter();
		Timer timer = new Timer(interval, listener);
		timer.start();

	}

	public class TimePrinter implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			// TODO 自动生成的方法存根
			Date now = new Date();
			System.out.println("at the tone,the time is " + now);
			if (beep)
			{
				Toolkit.getDefaultToolkit().beep();
			}

		}
	}
}
