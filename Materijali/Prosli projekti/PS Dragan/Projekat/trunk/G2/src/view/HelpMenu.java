/***********************************************************************
 * Module:  HelpMenu.java
 * Author:  Natasa
 * Purpose: Defines the Class HelpMenu
 ***********************************************************************/

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import localization.Localization;

/** @pdOid 36a8e751-02fa-4569-920d-15a27beea65c */
public class HelpMenu extends JMenu{
	
	private static Localization local = Localization.getInstance();
	private static final long serialVersionUID = 1L;
	public JMenu mnuHelp = new JMenu(local.getString("mnuHelp.title"));
	
	private  JMenuItem mnuItemViewHelp;
	private  JMenuItem mnuItemTutorials;
	private  JMenuItem mnuItemCheckForUpdates;
	private  JMenuItem mnuItemAbout;
	
	public HelpMenu()
	{
		local.registerComponent("mnuHelp.title", mnuHelp);
		add(mnuHelp);
		mnuHelp.setMnemonic(KeyEvent.VK_H);
		
		mnuItemViewHelp = new JMenuItem(local.getString("mnuHelp.viewHelp"));
		local.registerComponent("mnuHelp.viewHelp", mnuItemViewHelp);
		mnuItemViewHelp.setMnemonic(KeyEvent.VK_H);
		mnuItemViewHelp.setIcon(new ImageIcon("Icons/help.png"));
		mnuItemViewHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, ActionEvent.CTRL_MASK));
		mnuHelp.add(mnuItemViewHelp);
		
		mnuItemTutorials = new JMenuItem(local.getString("mnuHelp.tutorials"));
		local.registerComponent("mnuHelp.tutorials", mnuItemTutorials);
		mnuItemTutorials.setMnemonic(KeyEvent.VK_H);
		mnuHelp.add(mnuItemTutorials);
		
		mnuHelp.addSeparator();
		
		mnuItemCheckForUpdates = new JMenuItem(local.getString("mnuHelp.checkForUpdates"));
		local.registerComponent("mnuHelp.checkForUpdates", mnuItemCheckForUpdates);
		mnuItemCheckForUpdates.setMnemonic(KeyEvent.VK_U);
		mnuItemCheckForUpdates.setIcon(new ImageIcon("Icons/check_for_updates.png"));
		mnuHelp.add(mnuItemCheckForUpdates);
		
		mnuHelp.addSeparator();
		
		mnuItemAbout = new JMenuItem(local.getString("mnuHelp.about"));
		local.registerComponent("mnuHelp.about", mnuItemAbout);
		mnuItemAbout.setMnemonic(KeyEvent.VK_B);
		mnuItemAbout.setIcon(new ImageIcon("Icons/information.png"));
		mnuHelp.add(mnuItemAbout);
	}
	public void AddListener(ActionListener listener)
	{
		mnuItemViewHelp.addActionListener(listener);
		mnuItemViewHelp.setActionCommand("ViewHelp");
		
		mnuItemTutorials.addActionListener(listener);
		mnuItemTutorials.setActionCommand("Tutorials");
		
		mnuItemCheckForUpdates.addActionListener(listener);
		mnuItemCheckForUpdates.setActionCommand("CheckForUpdates");
		
		mnuItemAbout.addActionListener(listener);
		mnuItemAbout.setActionCommand("About");
	}
	

}