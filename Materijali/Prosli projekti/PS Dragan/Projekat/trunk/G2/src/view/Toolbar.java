/***********************************************************************
 * Module:  Toolbar.java
 * Author:  Ivana
 * Purpose: Defines the Class Toolbar
 ***********************************************************************/

package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.event.ChangeListener;

import org.openide.awt.DropDownButtonFactory;

import applicationModel.ToolbarModel;
import localization.Localization;
import main.MainClass;
import popups.PopupNew;
import popups.PopupOpen;

public class Toolbar extends JToolBar{
	
	private static final long serialVersionUID = 1L;
	private static Localization local = Localization.getInstance();
	public ToolbarModel model;
	
	private JButton btnNew, btnOpen, btnExport, btnImport, btnSave, btnSaveAs;
	public JButton btnUndo;
	public JButton btnRedo;
	private JButton btnZoomIn, btnZoomOut, btnHelp;
	private PopupNew popupNew = new PopupNew();
	private PopupOpen popupOpen = new PopupOpen();
	private JSeparator spr1, spr2, spr3;
	
	public Toolbar(ToolbarModel model)
	{
		this.model = model;
		setRollover(true);
		setBorderPainted(true);
		setFloatable(true);
		setOrientation(JToolBar.HORIZONTAL);
		
		Dimension btnDimension = new Dimension(30,30);
		
		btnNew = DropDownButtonFactory.createDropDownButton(new ImageIcon("icons/new.png"), popupNew);
		add(btnNew);
		btnNew.setPreferredSize(btnDimension);
		btnNew.setMinimumSize(btnDimension);
		btnNew.setToolTipText(local.getString("toolbarTip.new"));
		local.registerComponent("toolbarTip.new", btnNew);
		add(btnNew);
		
		btnOpen = DropDownButtonFactory.createDropDownButton(new ImageIcon("icons/Open.png"), popupOpen);
		btnOpen.setPreferredSize(btnDimension);
		btnOpen.setMinimumSize(btnDimension);
		btnOpen.setToolTipText(local.getString("toolbarTip.open"));
		local.registerComponent("toolbarTip.open", btnOpen);
		add(btnOpen);
		
		
		btnExport = new JButton(new ImageIcon("icons/export.png"));
		btnExport.getPressedIcon();
		btnExport.setPreferredSize(btnDimension);
		btnExport.setMinimumSize(btnDimension);
		btnExport.setActionCommand("Export");
		btnExport.setToolTipText(local.getString("toolbarTip.export"));
		local.registerComponent("toolbarTip.export", btnExport);
		add(btnExport);
		
		btnImport = new JButton(new ImageIcon("icons/import.png"));
		btnImport.getPressedIcon();
		btnImport.setPreferredSize(btnDimension);
		btnImport.setMinimumSize(btnDimension);
		btnImport.setActionCommand("Import");
		btnImport.setToolTipText(local.getString("toolbarTip.import"));
		local.registerComponent("toolbarTip.import", btnImport);
		add(btnImport);
		
		btnSave = new JButton(new ImageIcon("icons/save.png"));
		btnSave.setPreferredSize(btnDimension);
		btnSave.setMinimumSize(btnDimension);
		btnSave.setActionCommand("Save");
		btnSave.setToolTipText(local.getString("toolbarTip.save"));
		local.registerComponent("toolbarTip.save", btnSave);
		add(btnSave);
		
		btnSaveAs = new JButton(new ImageIcon("icons/save_as.png"));
		btnSaveAs.setPreferredSize(btnDimension);
		btnSaveAs.setMinimumSize(btnDimension);
		btnSaveAs.setActionCommand("SaveAs");
		btnSaveAs.setToolTipText(local.getString("toolbarTip.saveAs"));
		local.registerComponent("toolbarTip.saveAs", btnSaveAs);
		add(btnSaveAs);
		
		spr1 = new Separator();
		add(spr1);
		
		btnUndo = new JButton(new ImageIcon("icons/undo.png"));
		btnUndo.setPreferredSize(btnDimension);
		btnUndo.setMinimumSize(btnDimension);
		btnUndo.setActionCommand("Undo");
		btnUndo.setToolTipText(local.getString("toolbarTip.undo"));
		local.registerComponent("toolbarTip.undo", btnUndo);
		add(btnUndo);
		
		btnRedo = new JButton(new ImageIcon("icons/redo.png"));
		btnRedo.setPreferredSize(btnDimension);
		btnRedo.setMinimumSize(btnDimension);
		btnRedo.setActionCommand("Redo");
		btnRedo.setToolTipText(local.getString("toolbarTip.redo"));
		local.registerComponent("toolbarTip.redo", btnRedo);
		add(btnRedo);
		
		spr2 = new Separator();
		add(spr2);
		
		btnZoomIn = new JButton(new ImageIcon("icons/zoom_in.png"));
		btnZoomIn.setPreferredSize(btnDimension);
		btnZoomIn.setMinimumSize(btnDimension);
		btnZoomIn.setActionCommand("ZoomIn");
		btnZoomIn.setToolTipText(local.getString("toolbarTip.zoomIn"));
		local.registerComponent("toolbarTip.zoomIn", btnZoomIn);
		add(btnZoomIn);
		
		btnZoomOut = new JButton(new ImageIcon("icons/zoom_out.png"));
		btnZoomOut.setPreferredSize(btnDimension);
		btnZoomOut.setMinimumSize(btnDimension);
		btnZoomOut.setActionCommand("ZoomOut");
		btnZoomOut.setToolTipText(local.getString("toolbarTip.zoomOut"));
		local.registerComponent("toolbarTip.zoomOut", btnZoomOut);
		add(btnZoomOut);
		
		spr3 = new Separator();
		add(spr3);
		
		btnHelp= new JButton(new ImageIcon("icons/help.png"));
		btnHelp.setPreferredSize(btnDimension);
		btnHelp.setMinimumSize(btnDimension);
		btnHelp.setActionCommand("Help");
		btnHelp.setToolTipText(local.getString("toolbarTip.help"));
		local.registerComponent("toolbarTip.help", btnHelp);
		add(btnHelp);
	}
	
	public void Update()
	{
		MainClass.mf.statusBar.Update();
	}
	
	public void setActionListener(ActionListener listener) {
		popupNew.mnuNewProject.addActionListener(listener);
		popupNew.mnuNewDocument.addActionListener(listener);
		popupOpen.mnuOpenProject.addActionListener(listener);
		popupOpen.mnuOpenDocument.addActionListener(listener);
		btnSave.addActionListener(listener);
		btnImport.addActionListener(listener);
		btnExport.addActionListener(listener);
		btnSaveAs.addActionListener(listener);
		btnUndo.addActionListener(listener);
		btnRedo.addActionListener(listener);
		btnZoomIn.addActionListener(listener);
		btnZoomOut.addActionListener(listener);
		btnHelp.addActionListener(listener);
	}

	public void setChangeListener(ChangeListener listener) {
		popupNew.mnuNewProject.addChangeListener(listener);
		popupNew.mnuNewDocument.addChangeListener(listener);
		popupOpen.mnuOpenProject.addChangeListener(listener);
		popupOpen.mnuOpenDocument.addChangeListener(listener);
		btnSave.addChangeListener(listener);
		btnImport.addChangeListener(listener);
		btnExport.addChangeListener(listener);
		btnSaveAs.addChangeListener(listener);
		btnUndo.addChangeListener(listener);
		btnRedo.addChangeListener(listener);
		btnZoomIn.addChangeListener(listener);
		btnZoomOut.addChangeListener(listener);
		btnHelp.addChangeListener(listener);
	}
	
	public void setIdleState(){
		popupNew.mnuNewProject.setVisible(true);
		popupNew.mnuNewDocument.setVisible(true);
		popupOpen.mnuOpenProject.setVisible(true);
		popupOpen.mnuOpenDocument.setVisible(true);
		btnSave.setVisible(false);
		btnImport.setVisible(true);
		btnExport.setVisible(true);
		btnSaveAs.setVisible(false);
		btnUndo.setVisible(false);
		btnRedo.setVisible(false);
		btnZoomIn.setVisible(false);
		btnZoomOut.setVisible(false);
		btnHelp.setVisible(true);
		spr1.setVisible(false);
		spr2.setVisible(false);
    }
	
	public void setEditState(){
		popupNew.mnuNewProject.setVisible(true);
		popupNew.mnuNewDocument.setVisible(true);
		popupOpen.mnuOpenProject.setVisible(true);
		popupOpen.mnuOpenDocument.setVisible(true);
		btnSave.setVisible(true);
		btnImport.setVisible(true);
		btnExport.setVisible(true);
		btnSaveAs.setVisible(true);
		btnUndo.setVisible(true);
		btnRedo.setVisible(true);
		btnZoomIn.setVisible(true);
		btnZoomOut.setVisible(true);
		btnHelp.setVisible(true);
		spr1.setVisible(true);
		spr2.setVisible(true);
    }
}