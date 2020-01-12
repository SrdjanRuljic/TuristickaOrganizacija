package model;

import java.io.File;
import java.util.Iterator;

import observerPattern.SubjectOfObserving;
/**
 * Workspace je Singleton 
 * u klasi postoje metode koje obezbjedjuju postojanje jednog i samo jednog workspace-a.
 * Klasa Workspace naslijeðuje klasu Observable kako bi se omoguæile promjene prikaza pri promjeni 
 * stanja objekta tipa Workspace.
 * getInstance i getInstance(String ime)
 * @author ZoranaS
 *
 */
public class Workspace extends SubjectOfObserving {

	/**
	 * Osigurava da postoji samo jedna klasna varijabla izmedju svih objekata
	 * instance Workspace
	 * @author ZoranaS
	 */
	private static Workspace instance = null;
	/**
	 * privatna varijabla
	 */
	public static String ime;
	public static File fajl;
	public static java.util.List<Projekat> projekti;
	public DefaultProjekat defaultProjekat;

	public Workspace() {
		super();
	}
	public Workspace(File fajl) {
		super();
		this.fajl = fajl;
		ime = fajl.getName();
		//dodajProjekte();
	}


	/**
	 * Javna staticka metoda, kojoj se moze pristupiti bez instanciranja klase
	 * zaduzena je za kreiranje instance klase. U slucaju da instanca ne
	 * postoji, kreira je. Ako instanca postoji, vraca se vec postojeca klasa.
	 * Unutar citave aplikacije moze postojati samo jedna ovakva klasa.
	 * 
	 * @return Vraca se prethodno kreirana instanca (pristupa se statickoj
	 *         varijabli)
	 * @author ZoranaS
	 */
	public static Workspace getInstance()
	{
		if(instance == null)
		{
			instance = new Workspace();
		}
		
		return instance;
	}
	/**
	 * Javna staticka metoda, kojoj se moze pristupiti bez instanciranja klase
	 * zaduzena je za kreiranje instance klase. U slucaju da instanca ne
	 * postoji, kreira je. Ako instanca postoji, vraca se vec postojeca klasa.
	 * Unutar citave aplikacije moze postojati samo jedna ovakva klasa.
	 * 
	 * @return Vraca se prethodno kreirana instanca (pristupa se statickoj
	 *         varijabli)
	 * @author ZoranaS
	 */
	public static Workspace getInstance(String path)
	{
		if(instance == null)
		{
			instance = new Workspace();
		}
		
		return instance;
	}
	
	
	/**
	 * Metoda getIme vraca vrijednost varijable ime
	 * 
	 * @return vraæa ime workspace-a
	 * @author ZoranaS
	 */
	public static String getIme() {
		return ime;
	}
	
	/**
	 * Metoda setIme postavlja vrijednost varijable na novu postavljenu
	 * vrijednost
	 * 
	 * @param ime Parametar kojim se prosljedjuje nova vrijednost varijable ime
	 */
	public static void setIme(String ime) {
		Workspace.ime = ime;
	}

	
	public static java.util.List<Projekat> getProjekti() {
		if (projekti == null)
			projekti = new java.util.Vector<Projekat>();
		return projekti;
	}

	
	public static Iterator<Projekat> getIteratorProjekti() {
		if (projekti == null)
			projekti = new java.util.Vector<Projekat>();
		return projekti.iterator();
	}

	
	public void setProjekti(java.util.List<Projekat> newProjekti) {
		removeAllProjekti();
		for (Iterator<Projekat> iter = newProjekti.iterator(); iter.hasNext();)
			addProjekti((Projekat) iter.next());
	}

	
	public static void addProjekti(Projekat newProjekat) {
		if (newProjekat == null)
			return;
		if (Workspace.projekti == null)
			Workspace.projekti = new java.util.Vector<Projekat>();
		if (!Workspace.projekti.contains(newProjekat))
			Workspace.projekti.add(newProjekat);
	}

	
	public void removeProjekti(Projekat oldProjekat) {
		if (oldProjekat == null)
			return;
		if (Workspace.projekti != null)
			if (Workspace.projekti.contains(oldProjekat))
				Workspace.projekti.remove(oldProjekat);
	}

	
	public void removeAllProjekti() {
		if (projekti != null)
			projekti.clear();
	}
	
	/**
	 * Metoda koja se poziva pri promjenama u workspace-u. 
	 * Najprije se isprazni lista
	 * @author ZoranaS
	 */
	public void dodajProjekte()
	{
		removeAllProjekti();
		for (File fajl1 : fajl.listFiles())
		{
			if(fajl1.isDirectory())
			{
				Projekat projekat = new Projekat(fajl1);
				addProjekti(projekat);
				projekat.dodajDokumente(projekat);
			}
		}
		setStateChanged(true);
	}


	public static File getFajl() {
		return fajl;
	}


	public static void setFajl(File fajl) {
		Workspace.fajl = fajl;
	}
	
	
}