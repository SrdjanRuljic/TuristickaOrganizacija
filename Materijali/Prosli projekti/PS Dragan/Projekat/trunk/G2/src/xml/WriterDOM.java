package xml;

import java.io.File;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
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
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import documentModel.Workspace;

public class WriterDOM {
		private String location="";
		int prvi=1;
		private Vector niz;
		public void defaultContext()
		{
			try {
				DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = builderFactory.newDocumentBuilder();
		
				Document document = builder.newDocument();
	
				Element workspace = document.createElement("workspace");
				Attr attribute = document.createAttribute("name");
				attribute.setValue("workspace");
				workspace.setAttributeNode(attribute);
				Attr lokacija = document.createAttribute("location");
				location = Workspace.getLocation();
				lokacija.setValue(location);
				workspace.setAttributeNode(lokacija);
				document.appendChild(workspace);
				saveToXMLFile(document, location+"\\context.xml");
			}
			catch (ParserConfigurationException e) {
				e.printStackTrace();
			} 
			catch (DOMException e)
			{
				e.printStackTrace(System.err);
			}
		}
		public void createContext(JTree browser)
		{
			try {
				//this.location=location+"\\context.xml";
				DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = builderFactory.newDocumentBuilder();
		
				Document document = builder.newDocument();

				Element workspace = document.createElement("workspace");
				Attr attribute = document.createAttribute("name");
				attribute.setValue("workspace");
				workspace.setAttributeNode(attribute);
				Attr lokacija = document.createAttribute("location");
				location = Workspace.getLocation();
				lokacija.setValue(location);
				workspace.setAttributeNode(lokacija);
				document.appendChild(workspace);
				
		
				TreeNode node = (DefaultMutableTreeNode)browser.getModel().getRoot();
				int broj= node.getChildCount();

				for(int i=0;i<broj;i++)
				{
					TreeNode node2 = (TreeNode) node.getChildAt(i);
					Element element = saveAllTreeNodes(document, node2);
					document.getDocumentElement().appendChild(element);
				}

				saveToXMLFile(document, location+"\\context.xml");
			} 
			catch (ParserConfigurationException e) {
				e.printStackTrace();
			} 
			catch (DOMException e)
			{
				e.printStackTrace(System.err);
			}
		}
		
		
		public Element saveAllTreeNodes (Document thisDoc, TreeNode thisTreeNode)
		{
		    Element thisElement = null;
		    String nodeName = ((DefaultMutableTreeNode)thisTreeNode).getUserObject().toString();
		    Attr nivo= null;
		    Attr nivo2 = null;
		    Attr attribute = null;
		    Attr attr=null;
		    if (thisTreeNode.getChildCount() >= 0)//Nije rijesen problem slobodnih dokumenata
		    {
		    	if(nodeName.contains(".xml"))
		    	{
		    		thisElement = thisDoc.createElement("document");
		    		attribute = thisDoc.createAttribute("name");
			    	attribute.setValue(nodeName);
			    	thisElement.setAttributeNode(attribute);
		    		if(thisTreeNode.getChildCount()==0)
		    		{
		    			nivo= thisDoc.createAttribute("type");
		    			nivo.setValue("freedocument");
		    			thisElement.setAttributeNode(nivo);
		    		}
		    	}
		    	else
		    	{
		    		thisElement = thisDoc.createElement("project");
		    		attribute = thisDoc.createAttribute("name");
			    	attribute.setValue(nodeName);
			    	thisElement.setAttributeNode(attribute);
		    		if(thisTreeNode.getChildCount()>0)
		    		{
		    			nivo= thisDoc.createAttribute("type");
		    			nivo.setValue("project");
		    			thisElement.setAttributeNode(nivo);
		    		}
		    		else
		    		{
		    			nivo= thisDoc.createAttribute("type");
		    			nivo.setValue("freeproject");
		    			thisElement.setAttributeNode(nivo);
		    		}
		    	}
		    	
		    	for (Enumeration e = thisTreeNode.children(); e.hasMoreElements(); )
		      	{
		    	  	TreeNode n = (TreeNode) e.nextElement();
		    	  	String documentName=((DefaultMutableTreeNode)n).getUserObject().toString();
		    	  	Element documentElement=thisDoc.createElement("document");
		    	  	attr= thisDoc.createAttribute("name");
		    	  	attr.setValue(documentName);
		    	  	documentElement.setAttributeNode(attr);
		    	  	nivo2 = thisDoc.createAttribute("type");
		    	  	nivo2.setValue("document");
		    	  	documentElement.setAttributeNode(nivo2);
		        	thisElement.appendChild(documentElement);
		      	}
		    }
		    return thisElement;
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

