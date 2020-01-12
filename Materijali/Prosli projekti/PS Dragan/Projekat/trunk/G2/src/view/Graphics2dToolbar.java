/***********************************************************************
 * Module:  Graphics2dToolbar.java
 * Author:  srdjan
 * Purpose: Defines the Class Graphics2dToolbar
 ***********************************************************************/

package view;

import java.awt.Dimension;
import java.util.*;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.event.ChangeListener;
import applicationModel.Graphics2dToolbarModel;
import localization.Localization;


public class Graphics2dToolbar extends JToolBar
{
	private static final long serialVersionUID = 1L;
	private static Localization local = Localization.getInstance();
	public Graphics2dToolbarModel model;
	private JButton btnDot, btnLine, btnCircle, btnTriangle, btnRectangle;
	
	public Graphics2dToolbar(Graphics2dToolbarModel model)
	{
		this.model = model;
		setRollover(true);
		setBorderPainted(true);
		setFloatable(false);
		setOrientation(JToolBar.HORIZONTAL);
		
		Dimension btnDimension = new Dimension(30,30);
		
		btnDot = new JButton(new ImageIcon("icons/dot.png"));
		btnDot.getPressedIcon();
		btnDot.setPreferredSize(btnDimension);
		btnDot.setMinimumSize(btnDimension);
		btnDot.setActionCommand("Dot");		
		add(btnDot);
		
		btnLine = new JButton(new ImageIcon("icons/line.png"));
		btnLine.getPressedIcon();
		btnLine.setPreferredSize(btnDimension);
		btnLine.setMinimumSize(btnDimension);
		btnLine.setActionCommand("Line");		
		add(btnLine);
		
		btnCircle = new JButton(new ImageIcon("icons/circle.png"));
		btnCircle.getPressedIcon();
		btnCircle.setPreferredSize(btnDimension);
		btnCircle.setMinimumSize(btnDimension);
		btnCircle.setActionCommand("Circle");		
		add(btnCircle);
		
		btnTriangle = new JButton(new ImageIcon("icons/triangle.png"));
		btnTriangle.getPressedIcon();
		btnTriangle.setPreferredSize(btnDimension);
		btnTriangle.setMinimumSize(btnDimension);
		btnTriangle.setActionCommand("Triangle");		
		add(btnTriangle);
		
		btnRectangle = new JButton(new ImageIcon("icons/rectangle.png"));
		btnRectangle.getPressedIcon();
		btnRectangle.setPreferredSize(btnDimension);
		btnRectangle.setMinimumSize(btnDimension);
		btnRectangle.setActionCommand("Rectangle");		
		add(btnRectangle);
	}
	
	public void setActionListener(ActionListener listener) {
		btnDot.addActionListener(listener);
		btnLine.addActionListener(listener);
		btnCircle.addActionListener(listener);
		btnTriangle.addActionListener(listener);
		btnRectangle.addActionListener(listener);
	
	}
	public void setChangeListener(ChangeListener listener) {
	
	}
}