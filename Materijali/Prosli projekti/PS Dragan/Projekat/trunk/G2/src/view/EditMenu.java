/***********************************************************************
 * Module:  EditMenu.java
 * Author:  Natasa
 * Purpose: Defines the Class EditMenu
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

/** @pdOid 0c928acd-1fd3-4ce9-b600-ef08a9eb8818 */
public class EditMenu extends JMenu{
	
	private static Localization local = Localization.getInstance();
	private static final long serialVersionUID = 1L;
	public JMenu mnuEdit = new JMenu(local.getString("mnuEdit.title"));
	public JMenuItem mnuItemUndo;
	public JMenuItem mnuItemRedo;
	private JMenuItem mnuItemCut;
	private JMenuItem mnuItemCopy;
	private JMenuItem mnuItemPaste;
	private JMenuItem mnuItemRename;
	private JMenuItem mnuItemDelete;
	private JMenuItem mnuItemSelectAll;
	
	public EditMenu()
	{
		local.registerComponent("mnuEdit.title", mnuEdit);
		add(mnuEdit);
		mnuEdit.setMnemonic(KeyEvent.VK_E);
		
		mnuItemUndo = new JMenuItem(local.getString("mnuEdit.undo"));
		local.registerComponent("mnuEdit.undo", mnuItemUndo);
		mnuItemUndo.setMnemonic(KeyEvent.VK_U);
		mnuItemUndo.setIcon(new ImageIcon("Icons/undo.png"));
		mnuItemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		mnuEdit.add(mnuItemUndo);
		
		mnuItemRedo = new JMenuItem(local.getString("mnuEdit.redo"));
		local.registerComponent("mnuEdit.redo", mnuItemRedo);
		mnuItemRedo.setMnemonic(KeyEvent.VK_R);
		mnuItemRedo.setIcon(new ImageIcon("Icons/redo.png"));
		mnuItemRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		mnuEdit.add(mnuItemRedo);
		
		mnuEdit.addSeparator();
		
		mnuItemCut = new JMenuItem(local.getString("mnuEdit.cut"));
		local.registerComponent("mnuEdit.cut", mnuItemCut);
		mnuItemCut.setMnemonic(KeyEvent.VK_T);
		mnuItemCut.setIcon(new ImageIcon("Icons/cut.png"));
		mnuItemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		mnuEdit.add(mnuItemCut);
		
		mnuItemCopy = new JMenuItem(local.getString("mnuEdit.copy"));
		local.registerComponent("mnuEdit.copy", mnuItemCopy);
		mnuItemCopy.setMnemonic(KeyEvent.VK_C);
		mnuItemCopy.setIcon(new ImageIcon("Icons/copy.png"));
		mnuItemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		mnuEdit.add(mnuItemCopy);
		
		mnuItemPaste = new JMenuItem(local.getString("mnuEdit.paste"));
		local.registerComponent("mnuEdit.paste", mnuItemPaste);
		mnuItemPaste.setMnemonic(KeyEvent.VK_P);
		mnuItemPaste.setIcon(new ImageIcon("Icons/paste.png"));
		mnuItemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		mnuEdit.add(mnuItemPaste);
		
		mnuEdit.addSeparator();
		
		mnuItemRename = new JMenuItem(local.getString("mnuEdit.rename"));
		local.registerComponent("mnuEdit.rename", mnuItemRename);
		mnuItemRename.setMnemonic(KeyEvent.VK_N);
		mnuItemRename.setIcon(new ImageIcon("Icons/rename.png"));
		mnuEdit.add(mnuItemRename);
		
		mnuItemDelete = new JMenuItem(local.getString("mnuEdit.delete"));
		local.registerComponent("mnuEdit.delete", mnuItemDelete);
		mnuItemDelete.setMnemonic(KeyEvent.VK_D);
		mnuItemDelete.setIcon(new ImageIcon("Icons/delete.png"));
		mnuItemDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		mnuEdit.add(mnuItemDelete);
		
		mnuEdit.addSeparator();
		
		mnuItemSelectAll = new JMenuItem(local.getString("mnuEdit.selectAll"));
		local.registerComponent("mnuEdit.selectAll", mnuItemSelectAll);
		mnuItemSelectAll.setMnemonic(KeyEvent.VK_L);
		mnuItemSelectAll.setIcon(new ImageIcon("Icons/select_all.png"));
		mnuItemSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		mnuEdit.add(mnuItemSelectAll);
	}
	public void AddListener(ActionListener listener)
	{
		mnuItemUndo.addActionListener(listener);
		mnuItemUndo.setActionCommand("Undo");
		
		mnuItemRedo.addActionListener(listener);
		mnuItemRedo.setActionCommand("Redo");
		
		mnuItemCut.addActionListener(listener);
		mnuItemCut.setActionCommand("Cut");
		
		mnuItemCopy.addActionListener(listener);
		mnuItemCopy.setActionCommand("Copy");
		
		mnuItemPaste.addActionListener(listener);
		mnuItemPaste.setActionCommand("Paste");
		
		mnuItemRename.addActionListener(listener);
		mnuItemRename.setActionCommand("Rename");
		
		mnuItemDelete.addActionListener(listener);
		mnuItemDelete.setActionCommand("Delete");
		
		mnuItemSelectAll.addActionListener(listener);
		mnuItemSelectAll.setActionCommand("SelectAll");
	}
	
	public void setIdleState() {
        mnuItemUndo.setEnabled(false);
        mnuItemRedo.setEnabled(false);
        mnuItemCut.setEnabled(false);
        mnuItemCopy.setEnabled(false);
        mnuItemPaste.setEnabled(false);
        mnuItemDelete.setEnabled(false);
        mnuItemSelectAll.setEnabled(false);
    }
 
    public void setEditState() {
        //mnuItemUndo.setEnabled(true);
        //mnuItemRedo.setEnabled(true);
        mnuItemCut.setEnabled(true);
        mnuItemCopy.setEnabled(true);
        mnuItemPaste.setEnabled(true);
        mnuItemDelete.setEnabled(true);
        mnuItemSelectAll.setEnabled(true);
    }

}