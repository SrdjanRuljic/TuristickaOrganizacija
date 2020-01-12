package view.DatabaseBrowser;

public class TableInTree {

	private String procedura = null;
	private String naziv = null;
	
	public TableInTree(String procedura, String naziv)
	{
		setProcedura(procedura);
		setNaziv(naziv);
	}
	
	public String getProcedura()
	{
		return procedura;
	}
	public void setProcedura(String procedura)
	{
		this.procedura = procedura;
	}
	public String getNaziv()
	{
		return naziv;
	}
	public void setNaziv(String naziv)
	{
		this.naziv = naziv;
	}
	
	@Override
	public String toString()
	{
		return this.naziv;
	}
}
