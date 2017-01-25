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
		// TODO �Զ����ɵķ������
		TalkingClock talkingClock = new TalkingClock(1000, true);
		talkingClock.start();

		JOptionPane.showMessageDialog(null, "quit program");
		System.exit(0);

	}

}

class TalkingClock
{
	private int interval;
	private boolean beep;

	public TalkingClock(int interval, boolean beep)
	{
		this.interval = interval;
		this.beep = beep;
	}

	public void start()
	{
		ActionListener listener = new TimePrinter();
		Timer timer = new Timer(interval, listener);
		timer.start();

	}

	public class TimePrinter implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			// TODO �Զ����ɵķ������
			Date now = new Date();
			System.out.println("at the tone,the time is " + now);
			if (beep)
			{
				Toolkit.getDefaultToolkit().beep();
			}

		}
	}
}
