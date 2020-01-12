package observerPattern;
/**
 * Klasa Observer(posmatraè) je apstrakta klasa. Nju æe da naslijede sve klase èiji objekti su posmatraèi.
 * Klasa posjeduje promjenljivu SubjectOfObserving(objekat posmatranja) i metodu update() koja æe se u 
 * zavisnoti od posmatraèa razlièito implementirati.
 * Objekti koji naslijeðuju ovu klasu æe biti obavješteni kada nastanu promjene u objektima koje posmatraju. 
 * Pogledati:
 * {@link SubjectOfObserving}
 * @author ZoranaS
 *
 */
public abstract class Observer
{
	/**
	 * Promjenjliva u kojoj se èuva objekat posmatranja datog Observer-a.
	 * @author ZoranaS
	 */
	protected SubjectOfObserving subjectOfObserving;
	
	/**
	 * Abstraktna metoda koju trebaju da implementiraju sve klase koje naslijeðuju Observer, na sebi svojstven naèin.
	 * @author ZoranaS
	 */
	public abstract void update();
	
}
