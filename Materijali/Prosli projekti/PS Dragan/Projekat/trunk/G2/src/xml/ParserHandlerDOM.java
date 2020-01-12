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
		//pribavimo dokument kao osnovni �vor
		Node nodeRoot = document.getDocumentElement();
		niz.addElement(nodeRoot.getNodeName());
		niz.addElement(((Element) nodeRoot).getAttribute("name"));
		niz.addElement(((Element) nodeRoot).getAttribute("location"));
		
		//pribavimo listu svih ostalih �vorova koji su potomci osnovnog �vora
		NodeList nodeList = nodeRoot.getChildNodes();
		//kre�emo se kroz �vorove i na osnovu tipa �vora vr�imo neke akcije
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			switch (node.getNodeType()) {
			//ako je �vor element tipa �vora on ima svoje pod�vorove koje treba ponovo obraditi na isti na�in
			case Node.ELEMENT_NODE:
				niz.addElement(node.getNodeName());
				niz.addElement(((Element) node).getAttribute("name"));
				niz.addElement(((Element) node).getAttribute("type"));
				try //****************BITNO*************
				{
				//smjestimo taj �vor u neku promjenljivu element koju cemo koristiti za ispis imena i atributa
				Element element = (Element) node;
				
				//smjestimo sve atribute elementa u neku listu atributa
				NamedNodeMap attributes = element.getAttributes();
				
				//ako �vor opet ima svoje potomke na isti na�in prolazimo kroz njih
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
			//ako je �vor tipa atributa ispi�emo njegovo ime
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