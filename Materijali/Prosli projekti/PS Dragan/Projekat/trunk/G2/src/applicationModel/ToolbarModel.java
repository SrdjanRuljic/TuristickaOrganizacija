/***********************************************************************
 * Module:  ToolbarModel.java
 * Author:  Ivana
 * Purpose: Defines the Class ToolbarModel
 ***********************************************************************/

package applicationModel;

import javax.swing.JOptionPane;

import command.Undo;
import command.Redo;
import documentModel.Document;
import documentModel.Page;
import documentModel.Project;
import localization.Localization;
import main.MainClass;

public class ToolbarModel {
	private Localization local = Localization.getInstance();
	Page page;
	Undo undo;
	Redo redo;
	public void NewProject(){
		new Project();
	}
	
	public boolean checkName(String name){
		if(name.contains("\\") || name.contains("/") || name.contains(":") || name.contains("*") || name.contains("?") || name.contains("<") || name.contains(">") || name.contains("|")){
			JOptionPane.showMessageDialog(null, local.getString("popup.invalidCharsInName"));
			return false;
		}
		else
			return true;
	}
	public void NewDocument(){
		String documentName;
		do{
			documentName = JOptionPane.showInputDialog(null,local.getString("popup.insertName"),local.getString("popup.input"),JOptionPane.QUESTION_MESSAGE);
			documentName = documentName + ".xml";
		}
		while(MainClass.mf.mainPanel.projectBrowserModel.checkForName(documentName)==false || documentName.equals(".xml") || documentName.equals("context.xml") || documentName.equals("config.xml") || checkName(documentName)==false);		
		if(!documentName.equals("null.xml"))
		{
			Document doc = new Document(documentName);
			MainClass.mf.mainPanel.canvasModel.addTabToTree(doc.getDocumentName());
			MainClass.mf.mainPanel.canvasModel.openNewDocument(doc);
		}
	}
	
	public void OpenProject(){
		Project.open();
	}
	
	public void OpenDocument()
	{
		Document.open();
	}
	public void Save()
	{
		int index = MainClass.mf.mainPanel.canvasModel.kanvas.getSelectedIndex();
		if(index != -1)
			MainClass.mf.mainPanel.canvasModel.saveTab();
	}
	public void SaveAs()
	{
		if(MainClass.mf.mainPanel.canvasModel.kanvas.getSelectedIndex() != -1)
			MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).saveAs();
	}
	
	
	public void Import()
	{
		Document.importDocument();
	}
	public void Export()
	{
		if(MainClass.mf.mainPanel.canvasModel.kanvas.getSelectedIndex() != -1)
			MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).saveAs();
	}
	
	public void Undo(){
		page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
		undo = new Undo(page.urmodel);
		undo.execute(false);
	}
		
	public void Redo(){
		page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
		redo = new Redo(page.urmodel);
		redo.execute(false);
	}
	
	public void ZoomIncrement(){
		MainClass.mf.statusBarModel.ZoomIncrement();
		MainClass.mf.statusBar.Update();
	}
	
	public void ZoomDecrement(){
		MainClass.mf.statusBarModel.ZoomDecrement();
		MainClass.mf.statusBar.Update();
	}
	
	public void ViewHelp() {
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);						
	}
}