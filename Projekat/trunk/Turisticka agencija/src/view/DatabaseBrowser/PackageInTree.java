package view.DatabaseBrowser;

import java.util.Vector;

public class PackageInTree
{
	private String ime = null;
	private Vector<TableInTree> tabele = new Vector<>();
	
	public PackageInTree()
	{
		
	}

	public PackageInTree(String ime, Vector<TableInTree> tabele)
	{
		setIme(ime);
		setTabele(tabele);
	}
	
	public String getIme()
	{
		return ime;
	}

	public void setIme(String ime)
	{
		this.ime = ime;
	}
	
	@Override
	public String toString()
	{
		return ime;
	}

	public Vector<TableInTree> getTabele()
	{
		return tabele;
	}

	public void setTabele(Vector<TableInTree> tabele)
	{
		this.tabele = tabele;
	}

}
