/***********************************************************************
 * Module:  ParserHandlerDOM.java
 * Author:  draga_000
 * Purpose: Defines the Class ParserHandlerDOM
 ***********************************************************************/

package xml;

import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParserHandlerDOM {
	public Vector niz = new Vector();
	
	public ParserHandlerDOM(Document document)
	{
		//pribavimo dokument kao osnovni èvor
		Node nodeRoot = document.getDocumentElement();
		niz.addElement(nodeRoot.getNodeName());
		niz.addElement(((Element) nodeRoot).getAttribute("name"));
		niz.addElement(((Element) nodeRoot).getAttribute("location"));
		
		//pribavimo listu svih ostalih èvorova koji su potomci osnovnog èvora
		NodeList nodeList = nodeRoot.getChildNodes();
		//kreæemo se kroz èvorove i na osnovu tipa èvora vršimo neke akcije
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			switch (node.getNodeType()) {
			//ako je èvor element tipa èvora on ima svoje podèvorove koje treba ponovo obraditi na isti naèin
			case Node.ELEMENT_NODE:
				niz.addElement(node.getNodeName());
				niz.addElement(((Element) node).getAttribute("name"));
				niz.addElement(((Element) node).getAttribute("type"));
				try //****************BITNO*************
				{
				//smjestimo taj èvor u neku promjenljivu element koju cemo koristiti za ispis imena i atributa
				Element element = (Element) node;
				
				//smjestimo sve atribute elementa u neku listu atributa
				NamedNodeMap attributes = element.getAttributes();
				
				//ako èvor opet ima svoje potomke na isti naèin prolazimo kroz njih
				NodeList childnodes = element.getChildNodes();
				
				for (int j = 0; j < nodeList.getLength(); j++) {
					
					switch (childnodes.item(j).getNodeType()) {
					case Node.ELEMENT_NODE:
						niz.addElement(childnodes.item(j).getNodeName());
						niz.addElement(((Element) childnodes.item(j)).getAttribute("name"));
						niz.addElement(((Element) childnodes.item(j)).getAttribute("type"));
						break;
					case Node.ATTRIBUTE_NODE:
						break;
					case Node.TEXT_NODE:
						break;
					default:
						break;
					}
				}
				}
				catch(Exception ex)
				{
					
				}
				break;
			//ako je èvor tipa atributa ispišemo njegovo ime
			case Node.ATTRIBUTE_NODE:
				niz.addElement(node.getNodeName());
				niz.addElement(((Element) node).getAttribute("name"));
				niz.addElement(((Element) node).getAttribute("type"));
				break;
			case Node.TEXT_NODE:
				break;
			default:
				break;
			}
		}
	}
	
	public Vector getNiz()
	{
		return niz;
	}
}