package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import applicationModel.MenuBarModel;
import applicationModel.StatusBarModel;
import controller.CustomWindowListener;
import controller.MenuBarController;
import controller.StatusBarController;
import localization.Localization;
import state.StateInterface;

public class MainFrame extends JFrame {
	public static StateInterface state = null;
   public MainPanel mainPanel = new MainPanel();
   
   public MenuBarModel menuBarModel = new MenuBarModel();
   public MenuBar menuBar = new MenuBar(menuBarModel);
   public MenuBarController menuBarController = new MenuBarController(menuBarModel, menuBar);
   
   public StatusBarModel statusBarModel = new StatusBarModel();
   public StatusBar statusBar = new StatusBar(statusBarModel);
   public StatusBarController statusBarController = new StatusBarController(statusBarModel, statusBar);
   
   Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
   Dimension minSize = new Dimension(1000,600);
  
	private static Localization local = Localization.getInstance();
	
	public MainFrame()
	{
		//Osnovni prozor - naziv, ikoniza, velièina, listener
		super(local.getString("mainframe.title"));
		local.registerComponent("mainframe.title", this);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(minSize);
	
		Image ikonica = Toolkit.getDefaultToolkit().getImage("Icons/Icon.png");
		setIconImage(ikonica);
		
		addWindowListener(new CustomWindowListener());
		
		/****************** Menu Bar *********************/
		
		setJMenuBar(menuBar);
		
		/****************** StatusBar i MainPanel *********************/
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setTopComponent(mainPanel);
		splitPane.setBottomComponent(statusBar);
		splitPane.setResizeWeight(1.0);//status bar ostaje iste velièine pri resize
		
		splitPane.setDividerLocation(25*scrSize.height/30);
		splitPane.setEnabled(false);//status bar ne moze mijenjati velièinu
		splitPane.setVisible(true);
		add(splitPane, BorderLayout.CENTER);
		
		setResizable(true);
		setVisible(true);
	}
	
	
	//***************metode stanja *************************
	
	public StateInterface returnState() {
		return state;
	}

	public void setState(StateInterface state) {
		this.state = state;
		statusBarModel.setWestCell(state.getStateName());
		statusBar.Update();
	}
	
	public void gotoEdit() {
	 	this.state.edit(this);
	 	statusBar.Update();
	}
	public void gotoCloseEditor() {
	 	this.state.closing(this);
	 	statusBar.Update();
	}
	public void gotoSelect() {
	 	this.state.selection(this);
	 	statusBar.Update();
	}
	public void gotoSave() {
	 	this.state.save(this);
	 	statusBar.Update();
	}
	public void gotoUpdate() {
	 	this.state.update(this);
	 	statusBar.Update();
	}
	public void gotoIdle() {
	 	this.state.idle(this);
	 	statusBar.Update();
	}

}
