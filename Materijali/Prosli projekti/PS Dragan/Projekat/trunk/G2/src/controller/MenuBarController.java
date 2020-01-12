/***********************************************************************
 * Module:  MenuBarController.java
 * Author:  draga_000
 * Purpose: Defines the Class MenuBarController
 ***********************************************************************/

package controller;

import view.Canvas;
import view.MenuBar;
import applicationModel.CanvasModel;
import applicationModel.MenuBarModel;
import command.Cut;
import command.Delete;
import command.Paste;
import documentModel.Document;
import documentModel.Page;
import documentModel.Project;
import localization.Localization;
import main.MainClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.print.attribute.standard.DocumentName;
import javax.swing.JOptionPane;

/** @pdOid f607f584-ddca-4d7d-bb2c-8fdb7f0f8b85 */
public class MenuBarController {
   /** @pdOid b6505a72-2dd4-41e0-994a-c43769f271bc */
   public MenuBarModel model;
   /** @pdOid f3aaceb7-87e4-4acb-a0eb-da08645a4a3a */
   public MenuBar view;
 
   Page page;
   public Cut cut=null;
   public Paste paste=null;
   public Delete delete=null;
   /** @param model 
    * @param view
    * @pdOid c8c42bc0-d5d7-43b9-8511-3701f1118123 */
   public MenuBarController(MenuBarModel model, MenuBar view) {
      this.model=model;
      this.view=view;
      
      cut=new Cut(model);
      paste=new Paste(model);
      delete=new Delete(model);
      //Dodajemo action listenere na menu item-e
      this.view.fileMenu.AddListener(al);
      this.view.editMenu.AddListener(al);
      this.view.viewMenu.AddListener(al);
      this.view.insertMenu.AddListener(al);
      this.view.formatMenu.AddListener(al);
      this.view.optionsMenu.AddListener(al);
      this.view.helpMenu.AddListener(al);
   }
   private Localization local = Localization.getInstance();
   ActionListener al = new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub
			switch (e.getActionCommand())
			{
				
			/******************* FileMenu **************************/
			case "NewProject":
				model.NewProject();
				break;
			case "NewDocument":
				model.NewDocument();
				break;
			case "OpenProject":
				model.OpenProject();
				break;
			case "OpenDocument":
				model.OpenDocument();
				break;
			case "Save":
				model.Save();
				break;
			case "SaveAs":
				model.SaveAs();
				break;
			case "SaveAll":
				model.SaveAll();
				break;
			case "Print":
				model.Print();
				break;
			case "PrintPreview":
				model.PrintPreview();
				break;	
			case "Import":
				model.Import();
				break;
			case "Export":
				model.Export();
				break;
			case "Exit":
				MainClass.mf.gotoCloseEditor();
				model.Exit();				
				break;
			
			/******************* EditMenu **************************/
			case "Undo":
				model.Undo();
				break;
			case "Redo":
				model.Redo();
				break;
			case "Cut":
				//model.Cut();
				page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
				cut.execute(false);
				page.urmodel.addCommand(cut);
				break;
			case "Copy":
				model.Copy();
				break;
			case "Paste":
				//model.Paste();
				page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
				paste.execute(false);
				page.urmodel.addCommand(paste);
				break;
			case "Rename":
				model.Rename();
				break;	
			case "Delete":
				page = MainClass.mf.mainPanel.canvasModel.nizAktivnihDokumenata.get(MainClass.mf.mainPanel.canvasModel.getSelectedNiz()).getPage();
				delete.execute(false);
				page.urmodel.addCommand(delete);
				break;			
			case "SelectAll":
				model.SelectAll();
				break;
			
			/******************* ViewMenu **************************/
			case "ZoomIn":
				model.ZoomIncrement();				
				break;
			case "ZoomOut":
				model.ZoomDecrement();				
				break;
			
			/******************* InsertMenu **************************/
			case "NewSlot":
				model.NewSlot();
				break;	
			case "NewText":
				model.NewText();
				break;
			case "New2dGraphics":
				model.New2dGraphics();
				break;				
			case "NewImage":
				model.NewImage();
				break;
			case "NewAudio":
				model.NewAudio();
				break;			
			case "NewVideo":
				model.NewVideo();
				break;
			case "NewChart":
				model.NewChart();
				break;			

			/******************* FormatMenu **************************/
			case "PageFormat":
				model.PageFormat();
				break;
			case "TextFormat":
				model.TextFormat();
				break;
			case "Paragraph":
				model.Paragraph();
				break;	
			case "TextColor":
				model.TextColor();
				break;
			case "TextBackgroundColor":
				model.TextBackgroundColor();
				break;	
			case "TextFind":
				model.TextFind();
				break;	
			case "TextReplace":
				model.TextReplace();
				break;	
			case "TextLink":
				model.TextLink();
				break;	
			case "GraphicsColor":
				model.GraphicsColor();
				break;	
			case "GraphicsRotation":
				model.GraphicsRotation();
				break;	
			case "ImageCrop":
				model.ImageCrop();
				break;	
			case "ImageFormat":
				model.ImageFormat();
				break;	
			case "ImageFrame":
				model.ImageFrame();
				break;	
			case "Play":
				model.Play();
				break;	
			case "Pause":
				model.Pause();
				break;	
			case "Stop":
				model.Stop();
				break;	
			case "Rewind":
				model.Rewind();
				break;	
			case "Forward":
				model.Forward();
				break;	
			case "ChartDataEnter":
				model.ChartDataEnter();
				break;	
			case "ChartType":
				model.ChartType();
				break;	
			case "ChartFormat":
				model.ChartFormat();
				break;	
			
			/******************* OptionsMenu **************************/
			case "Customize":
				model.Customize();
				break;
			case "English":
				model.English();				
				break;	
			case "Serbian":
				model.Serbian();				
				break;	
			case "Bosnian":
				model.Bosnian();				
				break;	

			/******************* HelpMenu **************************/
			case "ViewHelp":
				model.ViewHelp();
				break;
			case "Tutorials":
				model.Tutorials();
				break;
			case "CheckForUpdates":
				model.CheckForUpdates();
				break;	
			case "About":
				model.About();
				break;	
			}

			MainClass.mf.statusBar.Update();
		}
   };
}