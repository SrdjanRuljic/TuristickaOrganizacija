
package main;

import java.io.File;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import documentModel.Workspace;
import localization.Localization;
import state.IdleState;
import view.MainFrame;
import view.StatusBar;
import xml.WriterDOM;

public class MainClass {
	
	private static Localization local = Localization.getInstance();
	public static MainFrame mf;
	
	public static void main(String[] args) 
	{
		new SplashScreen();
		new WorkspaceChooser();

		mf = new MainFrame();	
		mf.setState(new IdleState());
	}
}