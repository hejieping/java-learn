package chapter6;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LabelHtml
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO �Զ����ɵķ������
		// label�ı�����ʹ��html�ı�
		JLabel label = new JLabel("<html><b>Required</b><br>entry :</html>");
		JFrame frame = new JFrame();
		frame.add(label);
		frame.setSize(200, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);

	}
}
