/***********************************************************************
 * Module:  ToolbarController.java
 * Author:  Ivana
 * Purpose: Defines the Class ToolbarController
 ***********************************************************************/

package controller;

import view.Toolbar;
import applicationModel.ToolbarModel;
import localization.Localization;
import main.MainClass;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ToolbarController {
	public Toolbar view;
	public ToolbarModel model;
	
	private Localization local = Localization.getInstance();
	
	public ToolbarController(ToolbarModel model, Toolbar view) {
		this.model = model;
		this.view = view;
		this.view.setActionListener(al);
		this.view.setChangeListener(cl);
	}
	
	ActionListener al = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent event) {
				switch (event.getActionCommand())
				{
				case "NewProject":
					model.NewProject();
					break;
				case "NewDocument":
					model.NewDocument();
					break;
				case "OpenProject":
					model.OpenProject();
					MainClass.mf.gotoEdit();
					break;
				case "OpenDocument":
					model.OpenDocument();
					MainClass.mf.gotoEdit();
					break;
				case "Save":
					model.Save();
					MainClass.mf.gotoSave();
					break;
				case "SaveAs":
					model.SaveAs();
					MainClass.mf.gotoSave();
					break;
				case "Export":
					model.Export();
					MainClass.mf.gotoEdit();
					break;
				case "Import":
					model.Import();
					MainClass.mf.gotoEdit();
					break;
				case "Undo":
					model.Undo();
					MainClass.mf.gotoEdit();
					break;
				case "Redo":
					model.Redo();
					MainClass.mf.gotoEdit();
					break;
				case "ZoomIn":
					model.ZoomIncrement();
					MainClass.mf.gotoEdit();
					break;
				case "ZoomOut":
					model.ZoomDecrement();
					MainClass.mf.gotoEdit();
					break;
				case "Help":
					model.ViewHelp();
					MainClass.mf.gotoEdit();
					break;
				}
			
			local.updateAll();
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