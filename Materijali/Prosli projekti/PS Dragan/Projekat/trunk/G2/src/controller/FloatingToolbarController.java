/***********************************************************************
 * Module:  FloatingToolbarController.java
 * Author:  srdjan
 * Purpose: Defines the Class FloatingToolbarController
 ***********************************************************************/

package controller;

import view.FloatingToolbar;
import applicationModel.FloatingToolbarModel;
import command.Cut;
import command.Delete;
import command.Paste;
import documentModel.Page;
import localization.Localization;
import main.MainClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class FloatingToolbarController {
  
   public FloatingToolbar FloatingToolbarView;   
   public FloatingToolbarModel FloatingToolbarModel;
   private Localization local = Localization.getInstance();
   
   public Cut cut=null;
   public Paste paste=null;
   public Delete delete = null;
   Page page;
   
   public FloatingToolbarController(FloatingToolbarModel FloatingToolbarModel, FloatingToolbar FloatingToolbarView) {
		this.FloatingToolbarModel = FloatingToolbarModel;
		this.FloatingToolbarView = FloatingToolbarView;
		
		cut=new Cut(FloatingToolbarModel);
		paste=new Paste(FloatingToolbarModel);
		delete=new Delete(FloatingToolbarModel);
		
		this.FloatingToolbarView.setActionListener(al);
		this.FloatingToolbarView.setChangeListener(cl);
	}
   
   ActionListener al = new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand())
		{
			case "Cut":
				//FloatingToolbarModel.cutSlots();
				page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
				cut.execute(false);
				page.urmodel.addCommand(cut);
				break;
			case "Copy":
				FloatingToolbarModel.copySlots();
				break;
			case "Paste":
				//FloatingToolbarModel.pasteSlots();
				page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
				paste.execute(false);
				page.urmodel.addCommand(paste);
				break;
			case "Delete":
				page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
				delete.execute(false);
				page.urmodel.addCommand(delete);
				break;			
			case "SelectAll":
				FloatingToolbarModel.selectAll();
				break;
			case "AddContent":
				FloatingToolbarModel.addContent();
				break;
		}
		
		MainClass.mf.statusBar.Update();
	}
};

   ChangeListener cl = new ChangeListener(){
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
	}
	};
}