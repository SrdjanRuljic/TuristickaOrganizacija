/***********************************************************************
 * Module:  DocumentReader.java
 * Author:  draga_000
 * Purpose: Defines the Class DocumentReader
 ***********************************************************************/

package xml;

import java.util.*;
import java.util.Vector;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;

/** @pdOid 59010333-8162-44a9-8a2a-cfb1b37f60c7 */
public class DocumentReader {
	public Vector nizSlotova = new Vector();
	private String documentName;
	private String documentLocation;
	private String pageGrid;
	private String pageColor;
	private String pageHeight;
	private String pageWidth;
	private String contentType;
	public DocumentReader(Document document)
	{
		Node nodeDocument = document.getDocumentElement();
		documentName=((Element)nodeDocument).getAttribute("name");//created
		documentLocation=((Element)nodeDocument).getAttribute("location");//modified
		
		Node nodePage = nodeDocument.getFirstChild();
		nizSlotova.addElement(((Element)nodePage).getAttribute("color"));
		nizSlotova.addElement(((Element)nodePage).getAttribute("grid"));
		nizSlotova.addElement(((Element)nodePage).getAttribute("height"));
		nizSlotova.addElement(((Element)nodePage).getAttribute("width"));
		nizSlotova.addElement(((Element)nodePage).getAttribute("gridVisible"));
		
		NodeList nodeListSlot=nodePage.getChildNodes();
		for(int i=0; i<nodeListSlot.getLength(); i++)
		{
			Node nodeSlot=nodeListSlot.item(i);
			nizSlotova.addElement(((Element)nodeSlot).getAttribute("x"));
			nizSlotova.addElement(((Element)nodeSlot).getAttribute("y"));
			nizSlotova.addElement(((Element)nodeSlot).getAttribute("height"));
			nizSlotova.addElement(((Element)nodeSlot).getAttribute("width"));
			
			if(nodeSlot.hasChildNodes())
			{
				Node nodeSlotContent = nodeSlot.getFirstChild();
				contentType=((Element)nodeSlotContent).getAttribute("type");
				nizSlotova.addElement(((Element)nodeSlotContent).getAttribute("type"));
				if(contentType.contains("1"))
				{
					Node nodeText = nodeSlotContent.getFirstChild();
					nizSlotova.addElement(((Element)nodeText).getAttribute("color"));
					nizSlotova.addElement(((Element)nodeText).getAttribute("font"));
					nizSlotova.addElement(((Element)nodeText).getAttribute("size"));
					nizSlotova.addElement(((Element)nodeText).getAttribute("type"));
					nizSlotova.addElement(((Element)nodeText).getAttribute("backgroundColor"));
					nizSlotova.addElement(((Element)nodeText).getTextContent());
				}
				else if(contentType.contains("2"))
				{
					Node nodeGraphics=nodeSlotContent.getFirstChild();
					nizSlotova.addElement(((Element)nodeGraphics).getAttribute("count"));
					if(nodeGraphics.hasChildNodes())
					{
						NodeList nodeListShapes = nodeGraphics.getChildNodes();
						for(int j=0; j<nodeListShapes.getLength(); j++)
						{
							Node nodeShape = nodeListShapes.item(j);
							nizSlotova.addElement(((Element)nodeShape).getAttribute("shapeType"));
							nizSlotova.addElement(((Element)nodeShape).getAttribute("sheight"));
							nizSlotova.addElement(((Element)nodeShape).getAttribute("swidth"));
							nizSlotova.addElement(((Element)nodeShape).getAttribute("x"));
							nizSlotova.addElement(((Element)nodeShape).getAttribute("y"));
							
						}
					}
				}
			}
		}
	}
	public Vector getNizSlotova()
	{
		return nizSlotova;
	}
}