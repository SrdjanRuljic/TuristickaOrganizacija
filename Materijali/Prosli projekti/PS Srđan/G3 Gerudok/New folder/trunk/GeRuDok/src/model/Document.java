package model;

/**
 * Klasa {@link Document} predstavlja osnovni model dokumenta
 * 
 * 
 * @author Milos Nikolic
 */
public class Document
{
	public String name;

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
	 * @param name
	 */
	public Document(String name)
	{
		this.name = name;
	}

}