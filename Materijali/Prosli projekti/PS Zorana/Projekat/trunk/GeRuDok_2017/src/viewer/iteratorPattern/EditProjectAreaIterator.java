package viewer.iteratorPattern;

import java.util.Iterator;
import java.util.List;

import viewer.editAndPreviewArea.DocumentsArea;
import viewer.element.ElementArea;

/**
 * Klasa CompositeOfElementsIterator koja naslijeðuje {@link Iterator}. Objekti kroz koje prolazi Iterator su tipa {@link DocumentsArea}.
 * Implementirane su metode {@link hasNext()} i {@link next()}.
 * @author ZoranaS
 *
 */
public class EditProjectAreaIterator implements Iterator<DocumentsArea>
{
	List<DocumentsArea> lista;
	int pozicija=0;
	
	public EditProjectAreaIterator(List<DocumentsArea> lista)
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
	public DocumentsArea next()
	{
		return lista.get(pozicija++);
	}

}
