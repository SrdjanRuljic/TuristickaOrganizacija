package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Dokument
{
	public java.util.List<Stranica> stranice= new ArrayList<Stranica>();
	private int sirinaStranice = 800;
	private int visinaStranice = 1200;
	private String imeDokumenta;
	public int brojStranice=1;
	
   public Dokument()
   {
	 
   }
   

   public java.util.List<Stranica> getStranice() {
      if (stranice == null)
         stranice = new ArrayList<Stranica>();
      return stranice;
   }
   
 
   public Iterator<Stranica> getIteratorStranice() {
      if (stranice == null)
         stranice = new ArrayList<Stranica>();
      return stranice.iterator();
   }

   public void setStranice(java.util.List<Stranica> newStranice) {
      removeAllStranice();
      for (Iterator<Stranica> iter = newStranice.iterator(); iter.hasNext();)
         addStranice((Stranica)iter.next());
   }

   public void addStranice(Stranica newStranica) {
      if (newStranica == null)
         return;
      if (!this.stranice.contains(newStranica))
      {
    	  this.stranice.add(newStranica);
      }
         
   }
   
  
   public void removeStranice(Stranica oldStranica) {
      if (oldStranica == null)
         return;
      if (this.stranice != null)
         if (this.stranice.contains(oldStranica))
            this.stranice.remove(oldStranica);
   }
   
  
   public void removeAllStranice() {
      if (stranice != null)
         stranice.clear();
   }

public String getImeDokumenta() {
	return imeDokumenta;
}
public void setImeDokumenta(String imeDokumenta) {
	this.imeDokumenta = imeDokumenta;
}


public int getVisinaStranice() {
	return visinaStranice;
}


public void setVisinaStranice(int visinaStranice) {
	this.visinaStranice = visinaStranice;
}


public int getSirinaStranice() {
	return sirinaStranice;
}


public void setSirinaStranice(int sirinaStranice) {
	this.sirinaStranice = sirinaStranice;
}


	public int getBrojStranice() {
		return brojStranice;
	}


	public void setBrojStranice(int brojStranice) {
		this.brojStranice = brojStranice;
	}
}