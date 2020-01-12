package main;

import java.io.File;
import XML.XMLParserForDatabaseConnectionParameters;
import view.MainFrame;

public class MainClass {
	public static void main(String[] args) 
	{
		XMLParserForDatabaseConnectionParameters parser = new XMLParserForDatabaseConnectionParameters(new File("F:/baza.txt"));
		
		parser.citanje();
		

		MainFrame mainFrame=new MainFrame();
	}
}