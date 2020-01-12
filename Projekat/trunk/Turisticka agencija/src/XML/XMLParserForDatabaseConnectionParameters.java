package XML;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import dbConnection.DBConnection;
import dbConnection.MySQLConnection;
import dbType.DatabaseType;

public class XMLParserForDatabaseConnectionParameters {

	File file;
	DocumentBuilderFactory factory;
    DocumentBuilder builder;
    Document document;
    
    DatabaseType type = null;
	String address = null;
	String dbName = null;
	String port = null;
	String user = null;
	String password = null;
    
    public XMLParserForDatabaseConnectionParameters(File file) {
		this.file = file;
	}
    
    public void citanje() {
		Node root = null;
		
        {
       	 if(file.length() == 0)
       	 {
       		 
       	 }
       	 else
       	 {
       		try
    		{
    			 factory=DocumentBuilderFactory.newInstance();
    	         builder = factory.newDocumentBuilder();
    	         
    	         document = builder.parse(file.toString());
    	         
    	         root = (Node) document.getDocumentElement();	         
    		}
    		 catch (IOException | ParserConfigurationException | SAXException ex)
            {
                //JOptionPane.showMessageDialog(null,"Unable to parse file!","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    		
       		citanjePodatakaOKonekciji(root);
       	 }
        }
		
	}

	private void citanjePodatakaOKonekciji(Node root)
	{
		Element elementKonekcija = (Element)root;
		
		type = DatabaseType.valueOf(elementKonekcija.getAttribute("Tip_konekcije"));
		address = elementKonekcija.getAttribute("Adresa");
		port = elementKonekcija.getAttribute("Port");
		dbName = elementKonekcija.getAttribute("Ime_baze");
		user = elementKonekcija.getAttribute("Korisnik");
		password = elementKonekcija.getAttribute("Sifra");
		
		//provjeri popunjenost
		if(ProvjeraPopunjenostiPodatakaZaKonekcijuSaBazom())
		{
			MySQLConnection mySQLConnection = new MySQLConnection(type, address, port, dbName, user, password);
		
		}
		//JOptionPane.showConfirmDialog(null, type+" "+address+" "+port+" "+ dbName+" "+user +" "+password);
		
	}
	
	private Boolean ProvjeraPopunjenostiPodatakaZaKonekcijuSaBazom()
	{
		if(type != null && address != null && port != null && dbName  != null && user != null && password  != null)
			return true;
		return false;
	}
}
