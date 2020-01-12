package observerPattern;
/**
 * Klasa Observer(posmatra�) je apstrakta klasa. Nju �e da naslijede sve klase �iji objekti su posmatra�i.
 * Klasa posjeduje promjenljivu SubjectOfObserving(objekat posmatranja) i metodu update() koja �e se u 
 * zavisnoti od posmatra�a razli�ito implementirati.
 * Objekti koji naslije�uju ovu klasu �e biti obavje�teni kada nastanu promjene u objektima koje posmatraju. 
 * Pogledati:
 * {@link SubjectOfObserving}
 * @author ZoranaS
 *
 */
public abstract class Observer
{
	/**
	 * Promjenjliva u kojoj se �uva objekat posmatranja datog Observer-a.
	 * @author ZoranaS
	 */
	protected SubjectOfObserving subjectOfObserving;
	
	/**
	 * Abstraktna metoda koju trebaju da implementiraju sve klase koje naslije�uju Observer, na sebi svojstven na�in.
	 * @author ZoranaS
	 */
	public abstract void update();
	
}
