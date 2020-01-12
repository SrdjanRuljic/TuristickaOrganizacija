package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.w3c.dom.Element;

import model.iteratorPattern.ElementiIterator;

public class Elemenat {
	
	private List<Elemenat> listaElemenata  = new ArrayList<Elemenat>();
	private String tekst;
	
	public Elemenat() {
		// TODO Auto-generated constructor st
	}
	
	public Element vratiElement(org.w3c.dom.Document document)
	{
		org.w3c.dom.Element elementElement = document.createElement("Element");
		for (Elemenat elemenat : listaElemenata) 
		{
			elementElement.appendChild(elemenat.vratiElement(document));	
		}
		return elementElement;
				
	}
	
	public Iterator<Elemenat> createIterator()
	{
		return new ElementiIterator(listaElemenata);
	}
	
   public List<Elemenat> getListaElemenata() {
		return listaElemenata;
	}

	public void setListaElemenata(List<Elemenat> listaElemenata) {
		this.listaElemenata = listaElemenata;
	}

public void rotacija() {
      // TODO: implement
   }
   
   public void cut() {
      // TODO: implement
   }
   
   public void copy() {
      // TODO: implement
   }
   
   public void paste() {
      // TODO: implement
   }

public String getTekst() {
	return tekst;
}

public void setTekst(String tekst) {
	this.tekst = tekst;
}

}