package chapter7;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;

import javax.swing.JApplet;
import javax.swing.JComponent;

/**
 * 
 * @author jieping
 *
 */

public class Chart extends JApplet
{
	public void init()
	{
		EventQueue.invokeLater(new Runnable()
		{

			public void run()
			{
				// TODO Auto-generated method stub
				String v = getParameter("values");
				if (v == null)
				{
					return;
				}
				int n = Integer.parseInt(v);
				double[] values = new double[n];
				String[] names = new String[n];
				for (int i = 0; i < n; i++)
				{
					values[i] = Double
							.parseDouble(getParameter("value." + (i + 1)));
					names[i] = getParameter("name." + (i + 1));
				}
				add(new ChartComponent(values, names, getParameter("title")));

			}
		});
	}

}

class ChartComponent extends JComponent
{
	private double[] values;
	private String[] names;
	private String title;

	public ChartComponent(double[] v, String[] n, String t)
	{
		// TODO Auto-generated constructor stub
		values = v;
		names = n;
		title = t;

	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		if (values == null)
			return;
		double minvalue = 0;
		double maxvalue = 0;
		for (double v : values)
		{
			if (minvalue > v)
				minvalue = v;
			if (maxvalue < v)
				maxvalue = v;
		}
		if (maxvalue == minvalue)
			return;
		int panelWidth = getWidth();
		int panelHeight = getHeight();
		Font titleFont = new Font("SansSerif", Font.BOLD, 20);
		Font labelFont = new Font("SansSerif", Font.PLAIN, 10);

		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D titleBounds = titleFont.getStringBounds(title, context);
		double titleWidth = titleBounds.getWidth();
		double top = titleBounds.getHeight();

		double y = titleBounds.getY();
		double x = (panelWidth - titleWidth) / 2;
		g2.setFont(titleFont);
		g2.drawString(title, (float) x, (float) y);

		LineMetrics labelMetrics = labelFont.getLineMetrics("", context);
		double buttom = labelMetrics.getHeight();

		y = panelHeight - labelMetrics.getDescent();
		g2.setFont(labelFont);

		double scale = (panelHeight - top - buttom) / (maxvalue - minvalue);
		int barWidth = panelWidth / values.length;
		for (int i = 0; i < values.length; i++)
		{
			double x1 = i * barWidth + 1;
			double y1 = top;
			double height = values[i] * scale;
			if (values[i] >= 0)
			{
				y1 += (maxvalue - values[i]) * scale;
			} else
			{
				y1 += maxvalue * scale;
				height = -height;
			}

			Rectangle2D rect = new Rectangle2D.Double(x1, y1, barWidth - 2,
					height);
			g2.setPaint(Color.RED);
			g2.fill(rect);
			g2.setPaint(Color.blue);
			g2.fill(rect);
			Rectangle2D labelBounds = labelFont.getStringBounds(names[i],
					context);

			double labelWidth = labelBounds.getWidth();
			x = x1 + (barWidth - labelWidth) / 2;
			g2.drawString(names[i], (float) x, (float) y);
		}

	}

}
