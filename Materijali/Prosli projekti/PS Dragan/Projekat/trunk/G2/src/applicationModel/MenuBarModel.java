/***********************************************************************
 * Module:  MenuBarModel.java
 * Author:  draga_000
 * Purpose: Defines the Class MenuBarModel
 ***********************************************************************/

package applicationModel;

import javax.swing.JOptionPane;

import dialogs.PageDialog;
import dialogs.AboutDialog;
import dialogs.Configure;
import dialogs.TextDialog;
import documentModel.Document;
import documentModel.Page;
import documentModel.Project;
import documentModel.Text;
import localization.Localization;
import main.MainClass;
import xml.WriterDOM;
import command.Undo;
import controller.SlotController;
import command.Redo;


public class MenuBarModel {
	
	private static Localization local = Localization.getInstance();
	
	TextDialog textDialog;
	Page page;
	Undo undo=null;
	Redo redo=null;
	/****File menu****/
	public void NewProject()
	{
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
	
	public void NewDocument()
	{
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
	public void OpenProject()
	{
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
	public void SaveAll()
	{
		MainClass.mf.mainPanel.canvasModel.saveAllTabs();	
	}
	public void Print()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);								
	}
	public void PrintPreview()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);						
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
	public void Exit()
	{
		Object[] opcije = {local.getString("options.yes"), local.getString("options.no")};
		
		int retVal = JOptionPane.showOptionDialog(null, 
				local.getString("close.message"), 
				local.getString("close.title"), 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, opcije, opcije[1]);
		
		if(retVal == JOptionPane.YES_OPTION)
		{
			WriterDOM writer = new WriterDOM();
			writer.createContext(MainClass.mf.mainPanel.projectBrowser.tree);
			System.exit(0); 
		}
		else if(retVal == JOptionPane.NO_OPTION)
		{
		 
		}
	}
	
	/****Edit Menu****/
	public void Undo()
	{
		page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
		undo = new Undo(page.urmodel);
		undo.execute(false);
	}
	public void Redo()
	{
		page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
		redo = new Redo(page.urmodel);
		redo.execute(false);
	}
	public void Cut()
	{
		if(MainClass.mf.mainPanel.canvasModel.kanvas.getSelectedIndex() != -1){
			Page page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
			page.model.cutSlot();
			page.Update();
		}
	}
	public void Copy()
	{
		if(MainClass.mf.mainPanel.canvasModel.kanvas.getSelectedIndex() != -1){
			Page page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
			page.model.copySlot();
			page.Update();
		}
	}
	public void Paste()
	{
		if(MainClass.mf.mainPanel.canvasModel.kanvas.getSelectedIndex() != -1){
			Page page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
			page.model.pasteSlot();
			page.Update();
		}
	}
	public void Rename()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void Delete()
	{
		if(MainClass.mf.mainPanel.canvasModel.kanvas.getSelectedIndex() != -1){
			Page page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
			page.model.deleteSlot();
			page.Update();
		}
		else
			MainClass.mf.mainPanel.projectBrowserModel.removeCurrentNode();
	}
	public void SelectAll()
	{
		if(MainClass.mf.mainPanel.canvasModel.kanvas.getSelectedIndex() != -1){
			Page page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
			page.model.selectAll();
			page.Update();
		}	
	}
	
	/****View Menu****/
	public void ZoomIncrement()
	{
		MainClass.mf.statusBarModel.ZoomIncrement();
		MainClass.mf.statusBar.Update();
	}
	
	public void ZoomDecrement()
	{
		MainClass.mf.statusBarModel.ZoomDecrement();
		MainClass.mf.statusBar.Update();
	}
	
	/****Insert Menu****/
	public void NewSlot()
	{
		if(MainClass.mf.mainPanel.canvasModel.kanvas.getSelectedIndex() != -1){
			Page page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
			page.addingSlots = true;
		}
	}
	public void NewText()
	{
		if(MainClass.mf.mainPanel.canvasModel.kanvas.getSelectedIndex() != -1){
			Page page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
			for (SlotController s : page.model.nizSlotova) {
				if(s.view.selected == true)
					s.view.makeText();
			}
			page.Update();
		}			
	}
	public void New2dGraphics()
	{
		if(MainClass.mf.mainPanel.canvasModel.kanvas.getSelectedIndex() != -1){
			Page page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
			for (SlotController s : page.model.nizSlotova) {
				if(s.view.selected == true)
					s.view.make2D();
			}
			page.Update();
		}
	}
	public void NewImage()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void NewAudio()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void NewVideo()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void NewChart()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	
	/****Format Menu****/
	public void PageFormat()
	{
		int index = MainClass.mf.mainPanel.canvasModel.kanvas.getSelectedIndex();
		if(index != -1)
			new PageDialog(MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage());
		
	}
	public void TextFormat()
	{
		textDialog = new TextDialog();
	}
	public void Paragraph()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void TextColor()
	{
		Document doc = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz());
		for (SlotController s  : doc.getPage().model.getNizSlotova()) {
            if(s.view.selected)
            ((Text) s.view.slotContent).SetTextColor();
		}
	}
	public void TextBackgroundColor()
	{
		Document doc = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz());
		for (SlotController s  : doc.getPage().model.getNizSlotova()) {
            if(s.view.selected)
            ((Text) s.view.slotContent).SetTextBackgroundColor();
		}
	}
	public void TextFind()
	{
		Document doc = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz());
        for (SlotController s  : doc.getPage().model.getNizSlotova()) {
            if(s.view.selected)
            ((Text) s.view.slotContent).Find();
        }	
    }
	public void TextReplace()
	{
		Document doc = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz());
        for (SlotController s  : doc.getPage().model.getNizSlotova()) {
            if(s.view.selected)
            ((Text) s.view.slotContent).Replace();
        }	
    }
	public void TextLink()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void GraphicsColor()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void GraphicsRotation()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void ImageCrop()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void ImageFormat()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void ImageFrame()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void Play()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void Pause()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void Stop()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void Rewind()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void Forward()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void ChartDataEnter()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void ChartType()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	public void ChartFormat()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);
	}
	
	/****Options Menu****/
	public void Customize()
	{
		new Configure();
	}
	public void English()
	{
		local.setLocal("en", "US");
		local.updateAll();
	}
	public void Serbian()
	{
		local.setLocal("sr", "RS");
		local.updateAll();
	}
	public void Bosnian()
	{
		local.setLocal("sr", "BA");
		local.updateAll();
	}
	
	/****Help Menu****/
	public void ViewHelp() 
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);						
	}
	public void Tutorials()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);				
	}
	public void CheckForUpdates()
	{
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);				
	}
	public void About()
	{
		new AboutDialog(MainClass.mf);
	}
	
	/******************Ostalo******************/
	public void SlotsUndo(){
		if(MainClass.mf.mainPanel.canvasModel.kanvas.getSelectedIndex() != -1){
			Page page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
			page.model.SlotUndo();
			page.Update();
		}
	}
	public void SlotsRedo(){
		if(MainClass.mf.mainPanel.canvasModel.kanvas.getSelectedIndex() != -1){
			Page page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
			page.model.SlotRedo();
			page.Update();
		}
	}
	public void pasteSlotsUndo(){
		if(MainClass.mf.mainPanel.canvasModel.kanvas.getSelectedIndex() != -1){
			Page page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
			page.model.pasteSlotUndo();
			page.Update();
		}
	}

	public void pasteSlotsRedo(){
		if(MainClass.mf.mainPanel.canvasModel.kanvas.getSelectedIndex() != -1){
			Page page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
			page.model.pasteSlotRedo();
			page.Update();
		}
	}
}