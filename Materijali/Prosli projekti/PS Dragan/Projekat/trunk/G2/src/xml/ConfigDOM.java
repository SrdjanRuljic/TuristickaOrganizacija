/***********************************************************************
 * Module:  ConfigDOM.java
 * Author:  draga_000
 * Purpose: Defines the Class ConfigDOM
 ***********************************************************************/

package xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import documentModel.Workspace;


/** @pdOid 9fbea7d8-7dbb-4900-b117-8d6cc1bad793 */

public class ConfigDOM {
	public void WriteConfig(String lookAndFeel)
	{
		
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.newDocument();
			
			Element applicationElement = document.createElement("application");
			Attr lookAndFeelAttr = document.createAttribute("lookAndFeel");//treba created umjesto ovoga
			lookAndFeelAttr.setValue(lookAndFeel);
			applicationElement.setAttributeNode(lookAndFeelAttr);
			
			String location=Workspace.getLocation()+"\\config.xml";
			document.appendChild(applicationElement);
			saveToXMLFile(document, location);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String ReadConfig()
	{
		String lookAndFeel="";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			File file=new File(Workspace.getLocation()+"\\config.xml");
			if(file.exists())
			{
				org.w3c.dom.Document document = builder.parse(Workspace.getLocation()+"\\config.xml");
				Node nodeApplication = document.getDocumentElement();
				lookAndFeel=((Element)nodeApplication).getAttribute("lookAndFeel");
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lookAndFeel;
	}
	public boolean saveToXMLFile(Document doc, String filePath)
	{
		if (doc != null)
	    {
			try
			{
				TransformerFactory tFactory = TransformerFactory.newInstance();
				Transformer transformer = tFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(filePath));
				transformer.transform(source, result);
				return true;
			}
			catch (TransformerConfigurationException ex)
			{
				return false;
			}
			catch (TransformerException ex)
			{
				return false;
			}
			catch (TransformerFactoryConfigurationError ex)
			{
				return false;
			}
	    }
	    else
	    {
	      return false;
	    }
	}
}




