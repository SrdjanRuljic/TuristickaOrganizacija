/***********************************************************************
 * Module:  Document.java
 * Author:  Natasa
 * Purpose: Defines the Class Document
 ***********************************************************************/

package documentModel;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.filechooser.FileNameExtensionFilter;

import applicationModel.CanvasModel;
import applicationModel.PageModel;
import controller.PageController;
import localization.Localization;
import main.MainClass;
import xml.DocumentWriter;
import xml.ParserHandlerDOM;

public class Document extends Apstraktnidokument {
	private static Localization local = Localization.getInstance();
	private String documentName;
	private String location;
	private Date created;
	private Date modified;
	private Page page;
	
	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	 
	public String getLocation() {
			return location;
		}

	public void setLocation(String location) {
		this.location = location;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	public Document(String title){
		documentName = title;
		PageModel model = new PageModel();
		page = new Page(model);
		PageController controller = new PageController(page,model);
	}
	
	public Document(String title, int i){
		documentName = title;
		PageModel model = new PageModel();
		page = new Page(model, i);
		PageController controller = new PageController(page,model);
	}
   
	//kreiramo dokument sa imenom i lokacijom
   public void createDocument(String newDocumentName, String newLocation) {
	   setDocumentName(newDocumentName);
	   setLocation(newLocation);

	   try{
    	   File file = new File(location);
    	   
    	   if(file.exists()){
    		   JOptionPane.showMessageDialog(null, local.getString("popup.message"), local.getString("popup.title"), JOptionPane.INFORMATION_MESSAGE);
    		   saveAs();
    	   }
    	   else{
    		   file.createNewFile();
    	   		//nakon kreiranja fajla upisati u njega sadrzaj koji treba
   				writeToFile();
    	   }
       }
	   catch(Exception e)
       {
		   e.printStackTrace();
       }
   }

   public Boolean saveAs() {
	 //odaberemo lokaciju pa pozovemo konstruktor i onda upisemo u fajl
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle(local.getString("fileChooser.documentSaveAs"));
		fileChooser.setFileFilter(new FileNameExtensionFilter(".xml", "xml"));
		fileChooser.setCurrentDirectory(new File(Workspace.getLocation()));
		int userSelection = fileChooser.showSaveDialog(null);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			createDocument(fileToSave.getName()+ ".xml",fileToSave.getAbsolutePath()+".xml");
		}
		return null;
   }
   
   //moze biti staticka jer ce sama kreirati komponentu
   public static void open() {
	   JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle(local.getString("fileChooser.documentOpen"));
		fileChooser.setFileFilter(new FileNameExtensionFilter(".xml", "xml"));
		int userSelection = fileChooser.showOpenDialog(null);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToOpen = fileChooser.getSelectedFile();
			MainClass.mf.mainPanel.canvasModel.openNewTab(fileToOpen.getName(), fileToOpen.getAbsolutePath());
			//ovdje treba prosljedjivati lokaciju kasnije kada se bude stvarno ucitavala stranica na tab
		}
   }
   
   public static void importDocument() {
	   JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle(local.getString("fileChooser.documentOpen"));
		fileChooser.setFileFilter(new FileNameExtensionFilter(".xml", "xml"));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int userSelection = fileChooser.showOpenDialog(null);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToOpen = fileChooser.getSelectedFile();
			try{		
				if(MainClass.mf.mainPanel.projectBrowserModel.checkForName(fileToOpen.getName()))
				{
					MainClass.mf.mainPanel.canvasModel.openNewTab(fileToOpen.getName(), fileToOpen.getAbsolutePath());	
					MainClass.mf.mainPanel.canvasModel.addTabToTree(fileToOpen.getName());
				}
				else
					JOptionPane.showMessageDialog(null, local.getString("popup.message"), local.getString("popup.title"), JOptionPane.INFORMATION_MESSAGE);
	 		   
			}
			catch(Exception e){
					
				}
			}
   }
   
   public Boolean save() {
	   //samo upisati u postojeci xml fajl ili ako nije prethodno snimano kreiramo
	   writeToFile();
	   return null;
   }
   
   
   public void writeToFile(){
	   DocumentWriter writer = new DocumentWriter();
	   writer.createDocument(this.getPage(), this.getPage().model, this.getDocumentName(), this.getLocation());
   }
   
   @Override
   public void rename() {
	// TODO Auto-generated method stub
	   //setDocumentName("");
	   writeToFile();
   }
         
   public Boolean delete() {
	   //ova metoda se trenutno nigdje ne poziva
	   Path path = Paths.get(location);
	   try {
		Files.delete(path);
	   } catch (IOException e) {
		   e.printStackTrace();
	   }
      return null;
   }
   
   public void close() {
      save();
      //ovdje pozovemo kanvas i zatvorimo tab
   }
   
   public void undo() {
      // TODO: implement
   }
   
   public void redo() {
      // TODO: implement
   }




}