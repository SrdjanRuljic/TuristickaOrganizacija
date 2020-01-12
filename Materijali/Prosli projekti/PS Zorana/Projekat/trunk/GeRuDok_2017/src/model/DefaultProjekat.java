package model;

import java.util.Iterator;

public class DefaultProjekat {
   public java.util.List<Dokument> dokumenti;
   
 
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

}