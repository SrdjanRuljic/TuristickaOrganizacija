/***********************************************************************
 * Module:  MenuBar.java
 * Author:  draga_000
 * Purpose: Defines the Class MenuBar
 ***********************************************************************/

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controller.MenuBarListener;

public class MenuBar extends javax.swing.JMenuBar
{
	private static final long serialVersionUID = 1L;
	
	public JMenuItem helpAbout = null;
	public JMenuItem helpHelp = null;
	public JMenuItem fileSwitchXML = null;
	public JMenuItem fileSave = null;
	public JMenuItem fileSaveAs = null;
	public JMenuItem fileExit = null;
	public JMenuItem editNew = null;
	public JMenuItem editEdit = null;
	public JMenuItem editDelete = null;
	public JMenuItem editFirst = null;
	public JMenuItem editNext = null;
	public JMenuItem editPrevious = null;
	public JMenuItem editLast = null;
	public JMenuItem editAccept = null;
	public JMenuItem editCancel = null;
	public JMenuItem editReport = null;
	
	MenuBarListener menuBarListener;
	
	public MenuBar()
	{
		Dimension dim = new Dimension(40, 32);
		Dimension dimItem = new Dimension(220, 40);
		Dimension dimMenu = new Dimension(40, 32);
		setPreferredSize(dim);
		
		menuBarListener = new MenuBarListener();
		
		JMenu menuFile = new JMenu("File");
		menuFile.setForeground(Color.gray);
		menuFile.setPreferredSize(dimMenu);
		menuFile.setMnemonic(KeyEvent.VK_F);
		
		add(menuFile);
		
		fileSwitchXML = new JMenuItem("Switch XML");
		fileSwitchXML.setPreferredSize(dimItem);
		fileSwitchXML.setIcon(new ImageIcon("ikonice/switch-icon.png"));
		fileSwitchXML.setActionCommand("SwitchXML");
		fileSwitchXML.addActionListener(menuBarListener);
		
		fileSave = new JMenuItem("Save");
		fileSave.setPreferredSize(dimItem);
		fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		fileSave.setIcon(new ImageIcon("ikonice/save-icon.png"));
		fileSave.setActionCommand("Save");
		fileSave.addActionListener(menuBarListener);
		
		fileSaveAs = new JMenuItem("Save As");
		fileSaveAs.setPreferredSize(dimItem);
		fileSaveAs.setIcon(new ImageIcon("ikonice/save-as-icon.png"));
		fileSaveAs.setActionCommand("SaveAs");
		fileSaveAs.addActionListener(menuBarListener);
		
		fileExit = new JMenuItem("Exit");
		fileExit.setPreferredSize(dimItem);
		fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		fileExit.setIcon(new ImageIcon("ikonice/exit-icon.png"));
		fileExit.setActionCommand("Exit");
		fileExit.addActionListener(menuBarListener);
		
		menuFile.add(fileSwitchXML);
		menuFile.addSeparator();
		menuFile.add(fileSave);
		menuFile.add(fileSaveAs);
		menuFile.addSeparator();
		menuFile.add(fileExit);
		
		JMenu menuEdit = new JMenu("Edit");
		menuEdit.setMnemonic(KeyEvent.VK_E);
		menuEdit.setForeground(Color.gray);
		menuEdit.setPreferredSize(dimMenu);
		
		add(menuEdit);
		
		editNew = new JMenuItem("New");
		editNew.setPreferredSize(dimItem);
		editNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK + ActionEvent.SHIFT_MASK));
		editNew.setIcon(new ImageIcon("ikonice/new-2-icon.png"));
		editNew.setActionCommand("New");
		editNew.addActionListener(menuBarListener);
		
		editEdit = new JMenuItem("Edit");
		editEdit.setPreferredSize(dimItem);
		editEdit.setIcon(new ImageIcon("ikonice/edit-icon.png"));
		editEdit.setActionCommand("Edit");
		editEdit.addActionListener(menuBarListener);
		
		editDelete = new JMenuItem("Delete");
		editDelete.setPreferredSize(dimItem);
		editDelete.setIcon(new ImageIcon("ikonice/delete-icon.png"));
		editDelete.setActionCommand("Delete");
		editDelete.addActionListener(menuBarListener);
		
		editFirst = new JMenuItem("First");
		editFirst.setPreferredSize(dimItem);
		editFirst.setIcon(new ImageIcon("ikonice/first-icon.png"));
		editFirst.setActionCommand("First");
		editFirst.addActionListener(menuBarListener);
		
		editNext = new JMenuItem("Next");
		editNext.setPreferredSize(dimItem);
		editNext.setIcon(new ImageIcon("ikonice/next-icon.png"));
		editNext.setActionCommand("Next");
		editNext.addActionListener(menuBarListener);
		
		editPrevious = new JMenuItem("Previous");
		editPrevious.setPreferredSize(dimItem);
		editPrevious.setIcon(new ImageIcon("ikonice/previous-icon.png"));
		editPrevious.setActionCommand("Previous");
		editPrevious.addActionListener(menuBarListener);
		
		editLast = new JMenuItem("Last");
		editLast.setPreferredSize(dimItem);
		editLast.setIcon(new ImageIcon("ikonice/last-icon.png"));
		editLast.setActionCommand("Last");
		editLast.addActionListener(menuBarListener);
		
		editAccept = new JMenuItem("Accept");
		editAccept.setPreferredSize(dimItem);
		editAccept.setIcon(new ImageIcon("ikonice/accept-icon.png"));
		editAccept.setActionCommand("Accept");
		editAccept.addActionListener(menuBarListener);
		
		editCancel = new JMenuItem("Cancel");
		editCancel.setPreferredSize(dimItem);
		editCancel.setIcon(new ImageIcon("ikonice/cancel-icon.png"));
		editCancel.setActionCommand("Cancel");
		editCancel.addActionListener(menuBarListener);
		
		editReport = new JMenuItem("Report");
		editReport.setPreferredSize(dimItem);
		editReport.setIcon(new ImageIcon("ikonice/report-icon.png"));
		editReport.setActionCommand("Report");
		editReport.addActionListener(menuBarListener);
		
		menuEdit.add(editNew);
		menuEdit.add(editEdit);
		menuEdit.add(editDelete);
		menuEdit.addSeparator();
		menuEdit.add(editFirst);
		menuEdit.add(editNext);
		menuEdit.add(editPrevious);
		menuEdit.add(editLast);
		menuEdit.addSeparator();
		menuEdit.add(editAccept);
		menuEdit.add(editCancel);
		menuEdit.addSeparator();
		menuEdit.add(editReport);
		
		JMenu menuHelp = new JMenu("Help");
		menuHelp.setMnemonic(KeyEvent.VK_H);
		menuHelp.setForeground(Color.gray);
		menuHelp.setPreferredSize(dimMenu);
		
		add(menuHelp);
		
		helpHelp = new JMenuItem("Help");
		helpHelp.setPreferredSize(dimItem);
		helpHelp.setIcon(new ImageIcon("ikonice/help-icon.png"));
		helpHelp.setActionCommand("Help");
		helpHelp.addActionListener(menuBarListener);
		
		
		helpAbout = new JMenuItem("About");
		helpAbout.setPreferredSize(dimItem);
		helpAbout.setIcon(new ImageIcon("ikonice/information-icon.png"));
		helpAbout.setActionCommand("About");
		helpAbout.addActionListener(menuBarListener);
		
		menuHelp.add(helpHelp);
		menuHelp.add(helpAbout);
	}
}