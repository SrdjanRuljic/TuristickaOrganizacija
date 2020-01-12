package dbConnection;

import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dbType.DatabaseType;

/**
 * Apstraktna klasa koja je zaslužena za kreiranje i implementaciju osnovnih podataka koji su
 * potrebni za konekciju na bazu.
 * @author ZoranaS
 *
 */
public abstract class DBConnection {

	protected Connection conn = null;
	
	DatabaseType type = null;
	String address = null;
	String fullAddress = null;
	String dbName = null;
	String port = null;
	String driver = null;
	String url = null;
	String user = null;
	String password = null;
	
	public DBConnection(DatabaseType dbType, String address,String port, String dbName, String username, String password)
	{
		this.type = dbType;
		this.address = address;
		this.port = port;
		this.dbName = dbName;
		this.user = username;
		this.password = password;
		
	}
	
	/**
	 * Metoda {@link #closeConnection()} sluzi za zatvaranje konekcije. Nakon zatvaranja objekat tipa {@link Connection}
	 * postavlja se na vrijednost <code>null</code>.
	 */
	public void closeConnection()
	{
		if (conn == null)
			return;

		try
		{
			conn.close();
		}
		catch (SQLException e)
		{
			ErrorHandlerFunction(null, e.getMessage());
		}
		finally
		{
			conn = null;
		}
	}

	/**
	 * Metoda kreira konekciju sa zadatim parametrima.
	 * 
	 * @param adress
	 *            URL adresa baze podataka
	 * @param port
	 *            Port na kojem se nalazi baza podataka. Ako je <code>null</code> uzima se predodredjeni port
	 * @param dbName
	 *            Ime baze podataka na koju se konektuje
	 * @param user
	 *            Ime korisnika
	 * @param password
	 *            Lozinka korisnika
	 * @return Ako je konekcija uspjesna vraca se kao parametar, ako nije onda se vraca null vrijednost.
	 */
	public abstract Connection getConnection(String adress, String port, String dbName, String user, String password);

	/**
	 * Metoda {@link #isConnectionOpen()} provjerava da li je konekcija otvorena.
	 * 
	 * @return <code>True</code> ako je konekcija otvorena u suprotnom <code>False</code>.
	 */
	public Boolean isConnectionOpen()
	{
		if (conn != null)
		{
			return true;
		}

		return false;
	}
	
	/**
	 * Metoda {@link #isConnectionValid(int)} provjerava da li je konekcija validna.
	 * 
	 * @return <code>True</code> ako je konekcija validna u suprotnom <code>False</code>.
	 */
	public Boolean isConnectionValid(int timeout)
	{
		if (conn != null)
		{
			try
			{
				return conn.isValid(timeout);
			}
			catch (SQLException e)
			{
				ErrorHandlerFunction(null, e.getMessage());
			}
		}

		return false;
	}

	/**
	 * Metoda {@link #getConnection()} sluzi za pribavljanje konekcije. Ako konekcija postoji, onda se prosljedjuje ona,
	 * u suprotnom se prosjedjuje null vrijednost.
	 * 
	 * @return Ako je konekcija otvorena, onda vraca tu, vec postojecu konekciju. U protivnom vraca null vrijednost.
	 */
	public Connection getConnection()
	{
		if (conn != null)
		{
			return conn;
		}

		return null;
	}
	
	/**
	 * {@link #ErrorHandlerFunction(Component, String)}, funkcija je koja odgovara na sve greske koje nastanu u sistemu
	 * konekcije na bazu. Ova funkcija ima dva parametra:
	 * 
	 * @param comp
	 *            Komponenta koja je roditeljska komponenta za prikaz obavijesti o gresci
	 * @param errorMessage
	 *            Poruka koju ce prikazati dijalog za obavijest
	 */
	protected void ErrorHandlerFunction(Component comp, String errorMessage)
	{
		JOptionPane.showMessageDialog(comp, errorMessage, "Error", 0);
	}

	
	public DatabaseType getType() {
		return type;
	}
	public void setType(DatabaseType type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFullAdress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
