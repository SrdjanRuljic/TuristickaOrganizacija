package viewer.iteratorPattern;

import java.util.Iterator;
import java.util.List;

import viewer.element.ElementArea;

/**
 * Klasa CompositeOfElementsIterator koja naslijeðuje {@link Iterator}. Objekti kroz koje prolazi Iterator su tipa {@link ElementArea}.
 * Implementirane su metode {@link hasNext()} i {@link next()}.
 * @author ZoranaS
 *
 */
public class ElementAreaIterator implements Iterator<ElementArea> {

	List<ElementArea> lista;
	int pozicija=0;
	
	public ElementAreaIterator(List<ElementArea> lista)
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
	public ElementArea next()
	{
		return lista.get(pozicija++);
	}

}
