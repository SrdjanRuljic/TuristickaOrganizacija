package model;

import java.util.ArrayList;
import java.util.Iterator;

import org.w3c.dom.Element;

/**
 * Klasa koja odgovara jednoj stranici. Sadrži listu slotova koji se na njoj nalaze.
 * @author ZoranaS
 *
 */
public class Stranica 
{
   public java.util.List<Slot> slotovi = new ArrayList<Slot>();
   public java.util.List<Dokument> dokumenti = new ArrayList<Dokument>();
   private int redniBroj;
 
   public Stranica(Integer broj)
   {
	   redniBroj = broj;
   }
   /**
	 * Metoda koja kao parametar prima Document i u njega dodaje jednu stranicu
	 * U root element Stranice se dodaje jedna Stranica kao njen novi root element.
	 * @author Darko
	 */
	
   public Element vratiStranicu(org.w3c.dom.Document document)
	{
		Element elementStranica = document.createElement("Stranica");
		
	    for (Slot slot : getSlotovi()) {
	    	elementStranica.appendChild(slot.vratiSlot(document));
	    }
	      
		return elementStranica;
		
	}
   

   public java.util.List<Slot> getSlotovi() {
      if (slotovi == null)
         slotovi = new java.util.Vector<Slot>();
      return slotovi;
   }
   

   public Iterator<Slot> getIteratorSlotovi() {
      if (slotovi == null)
         slotovi = new java.util.Vector<Slot>();
      return slotovi.iterator();
   }
   
   
   public void setSlotovi(java.util.List<Slot> newSlotovi) {
      removeAllSlotovi();
      for (Iterator<Slot> iter = newSlotovi.iterator(); iter.hasNext();)
         addSlotovi((Slot)iter.next());
   }
   
  
   public void addSlotovi(Slot newSlot) {
      if (newSlot == null)
         return;
      if (this.slotovi == null)
         this.slotovi = new java.util.Vector<Slot>();
      if (!this.slotovi.contains(newSlot))
         this.slotovi.add(newSlot);
   }
   
   
   public void removeSlotovi(Slot oldSlot) {
      if (oldSlot == null)
         return;
      if (this.slotovi != null)
         if (this.slotovi.contains(oldSlot))
            this.slotovi.remove(oldSlot);
   }
   
   
   public void removeAllSlotovi() {
      if (slotovi != null)
         slotovi.clear();
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
public int getRedniBroj() {
	return redniBroj;
}
public void setRedniBroj(int redniBroj) {
	this.redniBroj = redniBroj;
}


}