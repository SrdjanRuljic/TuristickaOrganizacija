package viewer.iteratorPattern;

import java.util.Iterator;
import java.util.List;

import viewer.editAndPreviewArea.EditPageArea;
import viewer.editAndPreviewArea.PagesArea;
import viewer.element.ElementArea;

/**
 * Klasa CompositeOfElementsIterator koja naslijeðuje {@link Iterator}. Objekti kroz koje prolazi Iterator su tipa {@link EditPageArea}.
 * Implementirane su metode {@link hasNext()} i {@link next()}.
 * @author ZoranaS
 *
 */
public class PagesAreaIterator implements Iterator<EditPageArea>
{
	List<EditPageArea> lista;
	int pozicija=0;

	public PagesAreaIterator(List<EditPageArea> lista)
	{
		this.lista=lista;
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
	public EditPageArea next() {
		
		return lista.get(pozicija++);
	}

}
