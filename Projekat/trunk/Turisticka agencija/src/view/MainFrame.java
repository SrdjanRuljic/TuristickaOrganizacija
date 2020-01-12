/***********************************************************************
 * Module:  MainFrame.java
 * Author:  draga_000
 * Purpose: Defines the Class MainFrame
 ***********************************************************************/

package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;

import model.StatusBarModel;

import java.util.*;

public class MainFrame 
{
   public MainPanel mainPanel;
   public MenuBar menuBar = null;
   public StatusBar statusBar;
   public Toolbar toolbar;
   
   private static final long serialVersionUID = 1L;
	public static JPanel mainUp;
	public static JPanel mainDown;
	JPanel left,up,main,down;
	JFrame frame;
	int x,y;
	Border border;
	JScrollPane scrollPane;

	
	public MainFrame()
	{
		frame = new JFrame("Ad Astra");
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {}
	
		frame.setSize(new Dimension(850,640));	
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
	
		frame.addComponentListener(new ComponentListener() 
		{
		
			@Override
			public void componentShown(ComponentEvent e)
			{
			// TODO Auto-generated method stub
			
			}
		
			@Override
			public void componentResized(ComponentEvent e)
			{
				x=main.getWidth();
				y=main.getHeight()/2;
				mainUp.setPreferredSize(new Dimension(x,y));
				mainDown.setPreferredSize(new Dimension(x,y));
			}
		
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
			}
		
			@Override
			public void componentHidden(ComponentEvent e) {
			// TODO Auto-generated method stub
			}
	});
	
	WindowStateListener windowListener=new WindowAdapter()
	{
		public void windowStateChanged(WindowEvent arg0) 
		{
			int oldState=arg0.getOldState();
			int newState=arg0.getNewState();
			 if ((oldState & Frame.MAXIMIZED_BOTH) == 0 && (newState & Frame.MAXIMIZED_BOTH) != 0)
			 {
				x=main.getWidth();
				y=frame.getHeight()-down.getHeight()-up.getHeight()-40;
				y/=2;
				System.out.println(""+y);
				mainUp.setPreferredSize(new Dimension(x,y));
				mainDown.setPreferredSize(new Dimension(x,y));
				
			 }
			
		}
	};
	
	menuBar = new MenuBar();
	StatusBarModel statusBarModel=new StatusBarModel();
	statusBar=new StatusBar(statusBarModel);
	toolbar = new Toolbar();
	left=new JPanel();
	up=new JPanel();
	main=new JPanel();
	down=new JPanel();
	mainUp =new JPanel();
	mainDown =new JPanel();
	
	//ovdje se dodaje Database Browser
	scrollPane=new JScrollPane(left,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	frame.add(scrollPane);
	
	left.setBackground(Color.BLUE);
	up.setBackground(Color.RED);
	main.setBackground(Color.GREEN);
	mainUp.setBackground(Color.YELLOW);
	mainDown.setBackground(Color.WHITE);
	
	border = BorderFactory.createLineBorder(Color.BLACK);
	mainDown.setBorder(border);
	main.setLayout(new BorderLayout());
	
	left.setPreferredSize(new Dimension(150,0));
	up.setPreferredSize(new Dimension(0,30));
	down.setPreferredSize(new Dimension(0,20));
	mainUp.setPreferredSize(new Dimension(0,284));
	mainDown.setPreferredSize(new Dimension(0,284));
	
	
	
	frame.getContentPane().add(left,BorderLayout.WEST);
	frame.setJMenuBar(menuBar);
	frame.getContentPane().add(toolbar, BorderLayout.NORTH);
	frame.getContentPane().add(main,BorderLayout.CENTER);
	frame.getContentPane().add(statusBar,BorderLayout.SOUTH);
	main.add(mainUp,BorderLayout.NORTH);
	main.add(mainDown,BorderLayout.SOUTH);

	frame.addWindowStateListener(windowListener);
	frame.setVisible(true);
	}

}