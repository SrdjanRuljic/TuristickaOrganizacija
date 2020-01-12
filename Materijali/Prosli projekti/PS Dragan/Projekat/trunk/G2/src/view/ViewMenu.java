/***********************************************************************
 * Module:  ViewMenu.java
 * Author:  Natasa
 * Purpose: Defines the Class ViewMenu
 ***********************************************************************/

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import localization.Localization;

/** @pdOid 41185a09-5e25-421d-92f1-7e91ce06de6b */
public class ViewMenu extends JMenu{
	
	private static Localization local = Localization.getInstance();
	private static final long serialVersionUID = 1L;
	public JMenu mnuView = new JMenu(local.getString("mnuView.title"));
	
	private JMenuItem mnuItemZoomIn;
	private JMenuItem mnuItemZoomOut;
	
	public ViewMenu()
	{
		local.registerComponent("mnuView.title", mnuView);
		add(mnuView);
		mnuView.setMnemonic(KeyEvent.VK_V);
		
		mnuItemZoomIn = new JMenuItem(local.getString("mnuView.zoomIn"));
		local.registerComponent("mnuView.zoomIn", mnuItemZoomIn);
		mnuItemZoomIn.setMnemonic(KeyEvent.VK_I);
		mnuItemZoomIn.setIcon(new ImageIcon("Icons/zoom_in.png"));
		mnuItemZoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, ActionEvent.CTRL_MASK));
		mnuView.add(mnuItemZoomIn);
		
		mnuItemZoomOut = new JMenuItem(local.getString("mnuView.zoomOut"));
		local.registerComponent("mnuView.zoomOut", mnuItemZoomOut);
		mnuItemZoomOut.setMnemonic(KeyEvent.VK_O);
		mnuItemZoomOut.setIcon(new ImageIcon("Icons/zoom_out.png"));
		mnuItemZoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, ActionEvent.CTRL_MASK));
		mnuView.add(mnuItemZoomOut);
	}
	
	public void AddListener(ActionListener listener)
	{
		mnuItemZoomIn.addActionListener(listener);
		mnuItemZoomIn.setActionCommand("ZoomIn");
		
		mnuItemZoomOut.addActionListener(listener);
		mnuItemZoomOut.setActionCommand("ZoomOut");
	}
	
	public void setIdleState() {
        mnuItemZoomIn.setEnabled(false);
        mnuItemZoomOut.setEnabled(false);       
    }

	public void setEditState() {
		mnuItemZoomIn.setEnabled(true);
        mnuItemZoomOut.setEnabled(true);
	}

}