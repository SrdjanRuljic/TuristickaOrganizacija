/***********************************************************************
 * Module:  Project.java
 * Author:  Ivana
 * Purpose: Defines the Class Project
 ***********************************************************************/

package documentModel;

import java.io.File;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import localization.Localization;
import main.MainClass;

public class Project extends Apstraktnidokument {
	private static Localization local = Localization.getInstance();
	private String projectName;
	private String location;
	private Date created;
	private Date modified;
	private int numberOfDocuments;
	private Document document;
	List<Document> documents = null;
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean checkName(String name){
		if(name.contains("\\") || name.contains("/") || name.contains(":") || name.contains("*") || name.contains("?") || name.contains("<") || name.contains(">") || name.contains("|")){
			JOptionPane.showMessageDialog(null, local.getString("popup.invalidCharsInName"));
			return false;
		}
		else
			return true;
	}
	
   public Project() {
	   try
	   {
		   projectName = JOptionPane.showInputDialog(local.getString("popup.enterName"));
		   if(projectName.length() > 0 && checkName(projectName)==true)
		   {
			   location = Workspace.getLocation();
			   location = location + "\\" + projectName;
	
	    	   File folder = new File(location);
	    	   if(!folder.exists())
	    	   {
	    		   folder.mkdir();
	    		   MainClass.mf.mainPanel.projectBrowserModel.addObject(null, projectName, true);
	    		   numberOfDocuments = 0;
	    	   }
	    	   else
	    	   {
	    		   JOptionPane.showMessageDialog(null, local.getString("popup.message"));
	    		   new Project();
	    	   }
		   }
		   else
		   {
			   JOptionPane.showMessageDialog(null, local.getString("popup.messageEnterName"));
			   new Project();
		   }
	   }
	   catch(Exception e)
	   {
		   
	   }
   }
   
   public static void open() {
	   JFileChooser fileChooser = new JFileChooser();
	   fileChooser.setDialogTitle(local.getString("fileChooser.projectOpen"));
	   fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	   int userSelection = fileChooser.showOpenDialog(null);
	   	if(userSelection == JFileChooser.APPROVE_OPTION)
	   	{
	   		File projectOpen =  fileChooser.getSelectedFile();
	   		if(MainClass.mf.mainPanel.projectBrowserModel.checkForName(projectOpen.getName()))
	   		{
	   			MainClass.mf.mainPanel.projectBrowserModel.addObject(null, projectOpen.getName(), true);
	   		}
	   		else
	   		{
	   			JOptionPane.showMessageDialog(null, local.getString("popup.nameConflictMessage"));
	   			Project.open();
	   		}
	   	}
   }
   
   public Boolean save() {
      // TODO: implement
      return null;
   }
   
   public Boolean saveAs(String name, String location) {
      // TODO: implement
      return null;
   }
   
   public void importing(String name, String location) {
      // TODO: implement
   }
   
   public void exporting(String name, String location) {
      // TODO: implement
   }
   
   public void rename() {
	   // TODO: implement
   }
   
   public Boolean delete() {
      // TODO: implement
      return null;
   }
   
   public void close() {
      // TODO: implement
   }
   
   public void createNewDocument(String location) {
	   //document = new Document();
       //documents.add(document);
   }
   
   public Boolean deleteDocument() {
      // TODO: implement
      return null;
   }
}