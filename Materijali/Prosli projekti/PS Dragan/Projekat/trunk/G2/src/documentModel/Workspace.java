package documentModel;

import java.io.File;
import java.util.*;

import main.WorkspaceChooser;
import xml.WriterDOM;

public class Workspace extends Apstraktnidokument {
   private String documentName; 
   private Date created;
   private Date modified;
   
   private static Workspace instance = null;
   static String name;
   
   private static String location="C:\\GeRuDok\\DefaultWorkspace";
   public static String getLocation() {
		return location;
	}

	public static void setLocation(String location) {
		Workspace.location = location;
	}
	
   public static Workspace getInstance(String WL, String WN) {
	   if(instance == null) {
	         instance = new Workspace();
	         location = WL + "\\" + WN;
	         name = WN;
	         File file = new File(location);
	         file.mkdir();
	         WriterDOM dom= new WriterDOM();
	         dom.defaultContext();
	      }
	      return instance;
	   }
	   
   public static Workspace getDefaultInstance() {
	   File file = new File("C:\\GeRuDok");
	   if(instance == null && file.exists()) {
	         name = "DefaultWorkspace";
	         location = "C:\\GeRuDok" + "\\" + name;
	         instance = new Workspace();
	         file = new File("C:\\GeRuDok");
	         File file2 = new File(location + "\\context.xml");
	         if(!file.exists()){
		         file.mkdir();
		         file = new File(location);
		         file.mkdir();
		         WriterDOM dom= new WriterDOM();
		         dom.defaultContext();
	         }
		     else if (file.exists() && !file2.exists()){
		    	 instance = null;
		    	 new WorkspaceChooser(); 
		     }	    	 
	      }
	   else{
		   file.mkdir();
		   name = "DefaultWorkspace";
	       location = "C:\\GeRuDok";
		   getInstance(location, name);
	   }
	    	  
	return instance;
   }
	   
   public static void setInstance(String newLocation, String newName){
	   instance = new Workspace();
	   name = newName;
	   location = newLocation;
	   File file = new File(location + "\\context.xml");
	     if(!file.exists()){
	    	 instance = null;
	    	 new WorkspaceChooser();
	     }
	     
   }

	@Override
	public void rename() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Boolean delete() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Boolean save() {
		// TODO Auto-generated method stub
		return null;
	}
}