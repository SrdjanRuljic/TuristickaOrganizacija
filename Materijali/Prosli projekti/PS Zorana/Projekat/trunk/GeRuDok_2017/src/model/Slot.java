package model;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;

public class Slot
{
	private Elemenat elemenat;
	private int sirinaSlota;
	private int visinaSlota;
	private int redniBroj; 
	
	public Slot()
	{
		
	}
	public Element vratiSlot(org.w3c.dom.Document document)
	{
		Element elementSlot = document.createElement("Slot");
		
		 Attr width = document.createAttribute("Sirina_slota");
	      width.setValue(Integer.toString(getSirinaSlota()));
	      elementSlot.setAttributeNode(width);
	        
	      Attr height = document.createAttribute("Visina_slota");
	      height.setValue(Integer.toString(getVisinaSlota()));
	      elementSlot.setAttributeNode(height);
	     
	      if(elementSlot != null)
	      { 
	    	  try
	    	  { 
	    		  elementSlot.appendChild(elemenat.vratiElement(document)); 
	    	  }
	    	  catch (NullPointerException e) {
				
			}
	      }
		
		return elementSlot;
		
	}

	public Elemenat getElemenat() {
		return elemenat;
	}

	public void setElemenat(Elemenat elemenat) {
		this.elemenat = elemenat;
	}

	public int getSirinaSlota() {
		return sirinaSlota;
	}

	public void setSirinaSlota(int sirinaSlota) {
		this.sirinaSlota = sirinaSlota;
	}

	public int getVisinaSlota() {
		return visinaSlota;
	}

	public void setVisinaSlota(int visinaSlota) {
		this.visinaSlota = visinaSlota;
	}
	public int getRedniBroj() {
		return redniBroj;
	}
	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}


}