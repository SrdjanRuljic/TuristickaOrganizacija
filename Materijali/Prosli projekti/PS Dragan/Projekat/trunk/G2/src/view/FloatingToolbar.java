package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.event.ChangeListener;

import applicationModel.FloatingToolbarModel;
import localization.Localization;
import main.MainClass;



public class FloatingToolbar extends JToolBar {
	
	
	private static final long serialVersionUID = 1L;
	private static Localization local = Localization.getInstance();
	public FloatingToolbarModel model;	
	private JButton btnCut, btnCopy, btnPaste,  btnSelectAll, btnDelete, btnAddContent;

	public FloatingToolbar(FloatingToolbarModel model)
	{
		this.model = model;
		setRollover(true);
		setBorderPainted(true);
		setFloatable(true);
		setOrientation(JToolBar.VERTICAL);
		
		Dimension btnDimension = new Dimension(30,30);
		
		btnCut = new JButton(new ImageIcon("icons/cut.png"));
		btnCut.setPreferredSize(btnDimension);
		btnCut.setMinimumSize(btnDimension);
		btnCut.setActionCommand("Cut");
		btnCut.setToolTipText(local.getString("toolbarTip.cut"));
		local.registerComponent("toolbarTip.cut", btnCut);
		add(btnCut);
		
		btnCopy = new JButton(new ImageIcon("icons/copy.png"));
		btnCopy.setPreferredSize(btnDimension);
		btnCopy.setMinimumSize(btnDimension);
		btnCopy.setActionCommand("Copy");
		btnCopy.setToolTipText(local.getString("toolbarTip.copy"));
		local.registerComponent("toolbarTip.copy", btnCopy);
		add(btnCopy);
		
		btnPaste = new JButton(new ImageIcon("icons/paste.png"));
		btnPaste.setPreferredSize(btnDimension);
		btnPaste.setMinimumSize(btnDimension);
		btnPaste.setActionCommand("Paste");
		btnPaste.setToolTipText(local.getString("toolbarTip.paste"));
		local.registerComponent("toolbarTip.paste", btnPaste);
		add(btnPaste);
		
		btnSelectAll = new JButton(new ImageIcon("icons/select_all.png"));
		btnSelectAll.setPreferredSize(btnDimension);
		btnSelectAll.setMinimumSize(btnDimension);
		btnSelectAll.setActionCommand("SelectAll");
		btnSelectAll.setToolTipText(local.getString("toolbarTip.selectAll"));
		local.registerComponent("toolbarTip.selectAll", btnSelectAll);
		add(btnSelectAll);
		
		btnDelete = new JButton(new ImageIcon("icons/delete.png"));
		btnDelete.setPreferredSize(btnDimension);
		btnDelete.setMinimumSize(btnDimension);
		btnDelete.setActionCommand("Delete");
		btnDelete.setToolTipText(local.getString("toolbarTip.delete"));
		local.registerComponent("toolbarTip.delete", btnDelete);
		add(btnDelete);
		
		btnAddContent = new JButton(new ImageIcon("icons/addcontent.png"));
		btnAddContent.setPreferredSize(btnDimension);
		btnAddContent.setMinimumSize(btnDimension);
		btnAddContent.setActionCommand("AddContent");
		btnAddContent.setToolTipText(local.getString("toolbarTip.addContent"));
		local.registerComponent("toolbarTip.addContent", btnAddContent);
		add(btnAddContent);
	}
	
	public void setActionListener(ActionListener listener) {
		btnCut.addActionListener(listener);
		btnCopy.addActionListener(listener);
		btnPaste.addActionListener(listener);
		btnDelete.addActionListener(listener);
		btnSelectAll.addActionListener(listener);
		btnAddContent.addActionListener(listener);
	}
	
	public void setChangeListener(ChangeListener listener) {
		btnCut.addChangeListener(listener);
		btnCopy.addChangeListener(listener);
		btnPaste.addChangeListener(listener);
		btnDelete.addChangeListener(listener);
		btnSelectAll.addChangeListener(listener);
		btnAddContent.addChangeListener(listener);
	}
	
	public void setEditState(){
		btnCut.setVisible(true);
		btnCopy.setVisible(true);
		btnPaste.setVisible(true);
		btnDelete.setVisible(true);
		btnSelectAll.setVisible(true);
		btnAddContent.setVisible(true);
	}
	
	public void setIdleState(){
		btnCut.setVisible(false);
		btnCopy.setVisible(false);
		btnPaste.setVisible(false);
		btnDelete.setVisible(false);
		btnSelectAll.setVisible(false);
		btnAddContent.setVisible(false);
	}
}
