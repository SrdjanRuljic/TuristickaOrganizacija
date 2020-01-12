package viewer.editElement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

import javax.swing.JTextPane;

import controller.editElement.PopupMenuEditElementListener;

public class TextArea extends JTextPane 
{
	private static final long serialVersionUID = 1L;
	
	float angle=0;
	
	public TextArea() {
		super();
		setEditable(true);
		setPreferredSize(new Dimension(300, 300));
		setLocation(300, 300);
		addMouseListener(new PopupMenuEditElementListener());
		setBackground(Color.YELLOW);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform tr = g2d.getTransform();
		 g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                 RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.rotate(angle, this.getX(), this.getY());
		
		
		//g2d.setTransform(tr);
		super.paintComponent(g);
		this.getParent().repaint();
		this.getParent().revalidate();
		this.repaint();
		this.revalidate();
		
		
	}

}
