/***********************************************************************
 * Module:  Canvas.java
 * Author:  Srdjan
 * Purpose: Defines the Class Canvas
 ***********************************************************************/

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import applicationModel.CanvasModel;
import controller.CanvasController;

public class Canvas extends JTabbedPane
{
		
	public static JTabbedPane kanvas = new JTabbedPane();
	JButton btnClose = new CloseButton();
	public CanvasModel model;
	MouseListener ml;
	MouseMotionListener mml;
	
	public Canvas(CanvasModel model)
	{
		this.model = model; 
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));		
		setPreferredSize(new Dimension(370,330));
		kanvas.setBackground(Color.white);
			
		setTabPlacement(SwingConstants.TOP);
		JScrollPane skrol = new JScrollPane(kanvas);
		skrol.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		skrol.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(skrol,BorderLayout.CENTER);
		
		setVisible(true);	
	}
	
	public void addListeners(MouseListener ml){
		this.ml = ml;
	}
	
	public void Update()
	{
		kanvas.addMouseListener(ml);
	}
}