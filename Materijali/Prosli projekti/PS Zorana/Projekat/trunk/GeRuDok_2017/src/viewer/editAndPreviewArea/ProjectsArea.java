package viewer.editAndPreviewArea;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JDesktopPane;
import model.Projekat;
import model.Workspace;
import viewer.iteratorPattern.ProjectsAreaIterator;

/**
 * Klasa omoguæava prikaz projekata. Unutar nje mogu da se naðu primjerci klase {@link EditProjectArea}. 
 * Naslijeðuje klasu JPanel.
 * @author ZoranaS
 *
 */
public class ProjectsArea extends JDesktopPane
{
	private static final long serialVersionUID = 1L;
	
	private  boolean drag = false;
	private  Point dragLocation  = new Point();
	private int Visina=300;
	private int Sirina=300;
	private String ime;
	
	private static int bound=0;
	
	List<EditProjectArea> listOfEditProjectArea = new ArrayList<EditProjectArea>();
	
	public List<EditProjectArea> getListOfEditProjectArea() 
	{
		return listOfEditProjectArea;
	}

	public void setListOfEditProjectArea(List<EditProjectArea> listOfEditProjectArea) 
	{
		this.listOfEditProjectArea = listOfEditProjectArea;
	}
	
	public Iterator<EditProjectArea> createIterator()
	{
		return new ProjectsAreaIterator(listOfEditProjectArea);
	}
	

	public ProjectsArea()
	{
		
		super();
		setBackground(new Color(240, 255, 240));
		//dodavanjeProjekata();
		
		/* KOD ZA DA SE EDITPROJECTAREA OTVORI U MAX DIMENZIJI
		try
		{
			
			editProjectArea.setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		*/

	}

	/*public void dodavanjeProjekata()
	{
		//da cita odmah dodate projekte
		this.removeAll();
		this.repaint();
		bound=0;
		Iterator<Projekat> listaProjekata = Workspace.getInstance().getIteratorProjekti();
		
		while(listaProjekata.hasNext())
		{
			Projekat projekat= listaProjekata.next();
			setIme(projekat.getIme());
			EditProjectArea editProjectArea = new EditProjectArea(getIme(), projekat);
			listOfEditProjectArea.add(editProjectArea);
			add(editProjectArea);
			editProjectArea.setBounds(bound, bound,800,400);
			bound+=100;
		}
	}*/
	
	public void dodajProjekatUPrikaz(Projekat projekat)
	{
		EditProjectArea editProjectArea = new EditProjectArea(projekat.getIme(), projekat);
		listOfEditProjectArea.add(editProjectArea);
		add(editProjectArea);
		editProjectArea.setBounds(bound, bound, 800, 400);
		if(bound>300)
		{
			bound=0;
		}
		bound+=50;
		
	}
	

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
		
}
	   

