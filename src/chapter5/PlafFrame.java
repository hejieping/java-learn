package chapter5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class PlafFrame extends JFrame
{

	/**
	 * @param args
	 */
	private JPanel buttonPanel;

	public PlafFrame()
	{
		setSize(200, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		buttonPanel = new JPanel();
		UIManager.LookAndFeelInfo[] infos = UIManager
				.getInstalledLookAndFeels();
		for (UIManager.LookAndFeelInfo info : infos)
		{
			makebutton(info.getName(), info.getClassName());
		}
		add(buttonPanel);
		pack();
	}

	void makebutton(String name, final String plafName)
	{
		JButton button = new JButton(name);
		buttonPanel.add(button);
		button.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0)
			{
				// TODO 自动生成的方法存根
				try
				{
					UIManager.setLookAndFeel(plafName);
					SwingUtilities.updateComponentTreeUI(PlafFrame.this);
					pack();
				} catch (Exception e)
				{
					// TODO: handle exception
					e.printStackTrace();
				}

			}
		});
	}

	public static void main(String[] args)
	{
		new PlafFrame();

	}

}
