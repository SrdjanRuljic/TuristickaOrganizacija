package viewer.iteratorPattern;

import java.util.Iterator;
import java.util.List;

import viewer.editAndPreviewArea.EditProjectArea;
import viewer.element.ElementArea;

/**
 * Klasa CompositeOfElementsIterator koja naslijeðuje {@link Iterator}. Objekti kroz koje prolazi Iterator su tipa {@link EditProjectArea}.
 * Implementirane su metode {@link hasNext()} i {@link next()}.
 * @author ZoranaS
 *
 */
public class ProjectsAreaIterator implements Iterator<EditProjectArea>
{
	List<EditProjectArea> lista;
	int pozicija=0;
	
	public ProjectsAreaIterator(List<EditProjectArea> lista)
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
	public EditProjectArea next()
	{
		return lista.get(pozicija++);
	}

}
