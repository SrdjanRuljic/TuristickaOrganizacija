
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa predstavlja model projekta, sa svim potrebnim paramterima
 * 
 * 
 * @author Milos Nikolic
 */
public class ProjectModel
{
	// ArrayList<Document> documetns = new ArrayList<Document>();

	public String name;

	public List<Document> document;

	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Konstruktor klase {@link ProjectModel}
	 * 
	 * 
	 * @param documents
	 *            Lista dokumenata koja se postavlja u projekat
	 * @author Milos Nikolic
	 */
	public ProjectModel(List<Document> documents)
	{
		this.document = documents;
		// Zbog testiranja postavljeno rucno
		name = "Nesto";
	}

	/**
	 * Metoda dohvata dokumetne koji se nalaze u datom projektu
	 * 
	 * 
	 * @return {@link ArrayList} dokumenata
	 * @author Milos Nikolic
	 */
	public List<Document> getDocuments()
	{
		return document;
	}

	/**
	 * Metoda postavlja dokumetne u projektni model
	 * 
	 * 
	 * @param documents
	 *            Dokumenti koji se postavljaju
	 * @author Milos Nikolic
	 */
	public void setDocuments(List<Document> documents)
	{
		this.document = documents;
	}

	/**
	 * Metoda vraca broj dokumenata u okviru projekta
	 * 
	 * 
	 * @return {@link Integer} broj dokumenata
	 */
	public int countDocument()
	{
		return document.size();
	}

	/** @pdGenerated default getter */
	public List<Document> getDocument()
	{
		if (document == null)
			document = new java.util.Vector<Document>();
		return document;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorDocument()
	{
		if (document == null)
			document = new java.util.Vector<Document>();
		return document.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newDocument
	 */
	public void setDocument(List<Document> newDocument)
	{
		removeAllDocument();
		for (java.util.Iterator iter = newDocument.iterator(); iter.hasNext();)
			addDocument((Document) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newDocument
	 */
	public void addDocument(Document newDocument)
	{
		if (newDocument == null)
			return;
		if (this.document == null)
			this.document = new java.util.Vector<Document>();
		if (!this.document.contains(newDocument))
			this.document.add(newDocument);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldDocument
	 */
	public void removeDocument(Document oldDocument)
	{
		if (oldDocument == null)
			return;
		if (this.document != null)
			if (this.document.contains(oldDocument))
				this.document.remove(oldDocument);
	}

	/** @pdGenerated default removeAll */
	public void removeAllDocument()
	{
		if (document != null)
			document.clear();
	}

}