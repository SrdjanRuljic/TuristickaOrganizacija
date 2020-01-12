package model.iteratorPattern;

import java.util.Iterator;
import java.util.List;

import model.Elemenat;

public class ElementiIterator implements Iterator<Elemenat> {

	List<Elemenat> lista;
	int pozicija=0;
	
	public ElementiIterator(List<Elemenat> lista)
	{
		this.lista = lista;
	}
	
	@Override
	public boolean hasNext()
	{
		if(pozicija >= lista.size() || lista.get(pozicija)==null)
		{
			return false;
		}
		return true;
	}

	@Override
	public Elemenat next() 
	{
		return lista.get(pozicija++);
	}


}
