/***********************************************************************
 * Module:  FileMenu.java
 * Author:  Natasa
 * Purpose: Defines the Class FileMenu
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

import applicationModel.MenuBarModel;
import controller.MenuBarController;
import localization.Localization;

/** @pdOid 73fe1f9c-980f-4301-91a6-bdda1a1f84d8 */
public class FileMenu extends JMenu{

	private static Localization local = Localization.getInstance();
	private static final long serialVersionUID = 1L;
	public JMenu mnuFile = new JMenu(local.getString("mnuFile.title"));
	
	private JMenuItem mnuItemNewProject;
	private JMenuItem mnuItemNewDocument;
	private JMenuItem mnuItemOpenProject;
	private JMenuItem mnuItemOpenDocument;
	private JMenuItem mnuItemSave;
	private JMenuItem mnuItemSaveAs;
	private JMenuItem mnuItemSaveAll;
	private JMenuItem mnuItemPrint;
	private JMenuItem mnuItemPrintPreview;
	private JMenuItem mnuItemImport;
	private JMenuItem mnuItemExport;
	private JMenuItem mnuItemExit;
	
	public FileMenu()
	{

		local.registerComponent("mnuFile.title", mnuFile);
		mnuFile.setMnemonic(KeyEvent.VK_F);
		add(mnuFile);	
		
		JMenu mnuNew = new JMenu (local.getString("mnuFile.mnuNew.title"));
		local.registerComponent("mnuFile.mnuNew.title", mnuNew);
		mnuNew.setMnemonic(KeyEvent.VK_N);
		mnuNew.setIcon(new ImageIcon("Icons/new.png"));
		
		
		mnuItemNewProject = new JMenuItem(local.getString("mnuFile.mnuNew.project"));
		local.registerComponent("mnuFile.mnuNew.project", mnuItemNewProject);
		mnuItemNewProject.setMnemonic(KeyEvent.VK_P);
		mnuItemNewProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));
		mnuNew.add(mnuItemNewProject);
		
		mnuItemNewDocument = new JMenuItem(local.getString("mnuFile.mnuNew.document"));
		local.registerComponent("mnuFile.mnuNew.document", mnuItemNewDocument);
		mnuItemNewDocument.setMnemonic(KeyEvent.VK_D);
		mnuItemNewDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		mnuNew.add(mnuItemNewDocument);
		
		mnuFile.add(mnuNew);
				
		JMenu mnuOpen = new JMenu (local.getString("mnuFile.mnuOpen.title"));
		local.registerComponent("mnuFile.mnuOpen.title", mnuOpen);
		mnuOpen.setMnemonic(KeyEvent.VK_O);
		mnuOpen.setIcon(new ImageIcon("Icons/open.png"));
		
		mnuItemOpenProject = new JMenuItem(local.getString("mnuFile.mnuOpen.project"));
		local.registerComponent("mnuFile.mnuOpen.project", mnuItemOpenProject);
		mnuItemOpenProject.setMnemonic(KeyEvent.VK_P);
		mnuItemOpenProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));
		mnuOpen.add(mnuItemOpenProject);
		
		mnuItemOpenDocument = new JMenuItem(local.getString("mnuFile.mnuOpen.document"));
		local.registerComponent("mnuFile.mnuOpen.document", mnuItemOpenDocument);
		mnuItemOpenDocument.setMnemonic(KeyEvent.VK_D);
		mnuItemOpenDocument.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		mnuOpen.add(mnuItemOpenDocument);
		
		mnuFile.add(mnuOpen);
		
		mnuFile.addSeparator();
				
		mnuItemSave = new JMenuItem(local.getString("mnuFile.save"));
		local.registerComponent("mnuFile.save", mnuItemSave);
		mnuItemSave.setMnemonic(KeyEvent.VK_S);
		mnuItemSave.setIcon(new ImageIcon("Icons/save.png"));
		mnuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		mnuFile.add(mnuItemSave);
				
		mnuItemSaveAs = new JMenuItem(local.getString("mnuFile.saveAs"));
		local.registerComponent("mnuFile.saveAs", mnuItemSaveAs);
		mnuItemSaveAs.setMnemonic(KeyEvent.VK_V);
		mnuItemSaveAs.setIcon(new ImageIcon("Icons/save_as.png"));
		mnuFile.add(mnuItemSaveAs);
				
		mnuItemSaveAll = new JMenuItem(local.getString("mnuFile.saveAll"));
		local.registerComponent("mnuFile.saveAll", mnuItemSaveAll);
		mnuItemSaveAll.setMnemonic(KeyEvent.VK_A);
		mnuItemSaveAll.setIcon(new ImageIcon("Icons/save_all.png"));
		mnuFile.add(mnuItemSaveAll);
		
		mnuFile.addSeparator();
		
		mnuItemPrint = new JMenuItem(local.getString("mnuFile.print"));
		local.registerComponent("mnuFile.print", mnuItemPrint);
		mnuItemPrint.setMnemonic(KeyEvent.VK_P);
		mnuItemPrint.setIcon(new ImageIcon("Icons/print.png"));
		mnuFile.add(mnuItemPrint);
		
		mnuItemPrintPreview = new JMenuItem(local.getString("mnuFile.printPreview"));
		local.registerComponent("mnuFile.printPreview", mnuItemPrintPreview);
		mnuItemPrintPreview.setMnemonic(KeyEvent.VK_W);
		mnuItemPrintPreview.setIcon(new ImageIcon("Icons/preview.png"));
		mnuFile.add(mnuItemPrintPreview);
		
		mnuFile.addSeparator();
		
		mnuItemImport = new JMenuItem(local.getString("mnuFile.import"));
		local.registerComponent("mnuFile.import", mnuItemImport);
		mnuItemImport.setMnemonic(KeyEvent.VK_I);
		mnuItemImport.setIcon(new ImageIcon("Icons/import.png"));
		mnuFile.add(mnuItemImport);
		
		mnuItemExport = new JMenuItem(local.getString("mnuFile.export"));
		local.registerComponent("mnuFile.export", mnuItemExport);
		mnuItemExport.setMnemonic(KeyEvent.VK_E);
		mnuItemExport.setIcon(new ImageIcon("Icons/export.png"));
		mnuFile.add(mnuItemExport);
		
		mnuFile.addSeparator();
		
		mnuItemExit = new JMenuItem(local.getString("mnuFile.exit"));
		local.registerComponent("mnuFile.exit", mnuItemExit);
		mnuItemExit.setMnemonic(KeyEvent.VK_X);
		mnuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		mnuItemExit.setIcon(new ImageIcon("Icons/exit.png"));
		mnuFile.add(mnuItemExit);		
	}
	public void AddListener(ActionListener listener)
	{
		mnuItemNewProject.addActionListener(listener);
		mnuItemNewProject.setActionCommand("NewProject");
		
		mnuItemNewDocument.addActionListener(listener);
		mnuItemNewDocument.setActionCommand("NewDocument");
		
		mnuItemOpenProject.addActionListener(listener);
		mnuItemOpenProject.setActionCommand("OpenProject");
		
		mnuItemOpenDocument.addActionListener(listener);
		mnuItemOpenDocument.setActionCommand("OpenDocument");
		
		mnuItemSave.addActionListener(listener);
		mnuItemSave.setActionCommand("Save");
		
		mnuItemSaveAs.addActionListener(listener);
		mnuItemSaveAs.setActionCommand("SaveAs");
		
		mnuItemSaveAll.addActionListener(listener);
		mnuItemSaveAll.setActionCommand("SaveAll");
		
		mnuItemImport.addActionListener(listener);
		mnuItemImport.setActionCommand("Import");
		
		mnuItemExport.addActionListener(listener);
		mnuItemExport.setActionCommand("Export");
		
		mnuItemPrint.addActionListener(listener);
		mnuItemPrint.setActionCommand("Print");
		
		mnuItemPrintPreview.addActionListener(listener);
		mnuItemPrintPreview.setActionCommand("PrintPreview");
		
		mnuItemExit.addActionListener(listener);
		mnuItemExit.setActionCommand("Exit");
	}
	
	public void setIdleState(){
        mnuItemSave.setEnabled(false);
        mnuItemSaveAs.setEnabled(false);
        mnuItemSaveAll.setEnabled(false);
        mnuItemPrint.setEnabled(false);
        mnuItemPrintPreview.setEnabled(false);
    }
     
    public void setEditState() {
        mnuItemSave.setEnabled(true);
        mnuItemSaveAs.setEnabled(true);
        mnuItemSaveAll.setEnabled(true);
        mnuItemPrint.setEnabled(true);
        mnuItemPrintPreview.setEnabled(true);
    }
	
}