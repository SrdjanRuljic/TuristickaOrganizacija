/***********************************************************************
 * Module:  MainPanel.java
 * Author:  srdjan
 * Purpose: Defines the Class MainPanel
 ***********************************************************************/

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import applicationModel.CanvasModel;
import applicationModel.FloatingToolbarModel;
import applicationModel.ProjectBrowserModel;
import applicationModel.ToolbarModel;
import controller.CanvasController;
import controller.FloatingToolbarController;
import controller.ProjectBrowserController;
import controller.ToolbarController;


public class MainPanel extends JPanel{

		private static final long serialVersionUID = 1L;
		public ProjectBrowserModel projectBrowserModel = new ProjectBrowserModel();
		public ProjectBrowser projectBrowser = new ProjectBrowser(projectBrowserModel);
		public ProjectBrowserController projectBrowserController = new ProjectBrowserController(projectBrowserModel, projectBrowser);
		
		/** Postavljanje Canvas-a na Main Panel */
		public CanvasModel canvasModel = new CanvasModel();
		public Canvas canvas = new Canvas(canvasModel);
		public CanvasController canvasController =new CanvasController(canvasModel, canvas);
	   
		/** Postavljanje Toolbar-a na Main Panel */
		public ToolbarModel toolbarModel = new ToolbarModel();
		public Toolbar toolbar = new Toolbar(toolbarModel);
		public ToolbarController toolbarController = new ToolbarController(toolbarModel, toolbar);
  
		/** Postavljanje FloatingToolbar-a na Main Panel */
		public FloatingToolbarModel floatingToolbarModel = new FloatingToolbarModel();
		public FloatingToolbar floatingToolbar = new FloatingToolbar(floatingToolbarModel);
		public FloatingToolbarController floatingToolbarController = new FloatingToolbarController(floatingToolbarModel, floatingToolbar);

		Dimension ekran = Toolkit.getDefaultToolkit().getScreenSize();
	
		public MainPanel()
		{
			setOpaque(false);
			setBackground(Color.BLACK);
		
			setLayout(new BorderLayout());
		
			add(toolbar, BorderLayout.NORTH);
			add(floatingToolbar, BorderLayout.EAST);
		
			JSplitPane split = new JSplitPane();
			split.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
			split.setLeftComponent(projectBrowser);
			split.setRightComponent(canvas);
		
			split.setDividerLocation(ekran.width/4);
			add(split, BorderLayout.CENTER);
		
			setVisible(true);
		}
}