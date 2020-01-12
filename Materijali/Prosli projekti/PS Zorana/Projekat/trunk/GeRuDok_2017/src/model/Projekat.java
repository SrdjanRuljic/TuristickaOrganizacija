package model;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Iterator;

import XML.DomParserForDocuments;

public class Projekat {
 
public java.util.List<Dokument> dokumenti;
public File fajl;
private String ime;
private DomParserForDocuments domParserForDocuments;


	public Projekat()
	{
		
	}
	
   
   public Projekat(File fajl) {
		this.fajl = fajl;
		ime = fajl.getName();
		//dodajDokumente();
	}


   public void dodajDokumente(Projekat projekat)
   {
	   FileFilter filter = new FileFilter()
	   {
		@Override
			public boolean accept(File pathname)
			{
				// TODO Auto-generated method stub
				return pathname.toString().endsWith(".xml");
			}
	   };
	   
	   try
	   {
		   for(File file :  fajl.listFiles(filter))
		   {
			   domParserForDocuments = new DomParserForDocuments(projekat);
			   domParserForDocuments.citanje(file);
		   
		   }
	   }
	   catch (NullPointerException e) {
	}
   }



   public java.util.List<Dokument> getDokumenti() {
      if (dokumenti == null)
         dokumenti = new java.util.Vector<Dokument>();
      return dokumenti;
   }
   

   public Iterator<Dokument> getIteratorDokumenti() {
      if (dokumenti == null)
         dokumenti = new java.util.Vector<Dokument>();
      return dokumenti.iterator();
   }
   
   public void setDokumenti(java.util.List<Dokument> newDokumenti) {
      removeAllDokumenti();
      for (Iterator<Dokument> iter = newDokumenti.iterator(); iter.hasNext();)
         addDokumenti((Dokument)iter.next());
   }
   

   public void addDokumenti(Dokument newDokument) {
      if (newDokument == null)
         return;
      if (this.dokumenti == null)
         this.dokumenti = new java.util.Vector<Dokument>();
      if (!this.dokumenti.contains(newDokument))
         this.dokumenti.add(newDokument);
   }
   
  
   public void removeDokumenti(Dokument oldDokument) {
      if (oldDokument == null)
         return;
      if (this.dokumenti != null)
         if (this.dokumenti.contains(oldDokument))
            this.dokumenti.remove(oldDokument);
   }
   

   public void removeAllDokumenti() {
      if (dokumenti != null)
         dokumenti.clear();
   }


   public String getIme() {
	return ime;
   }

   public void setIme(String ime) {
	this.ime = ime;
   }
  
 
}