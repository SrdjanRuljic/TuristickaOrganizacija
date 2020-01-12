package XML;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import view.chooseWorkspace.WindowForChooseWorkspace;

public class DomParserForRecentWorkspace {

	File file;
	DocumentBuilderFactory factory;
    DocumentBuilder builder;
    Document document;
 
     
	public DomParserForRecentWorkspace() {
	}
	

	public void citanje() {
		Node root = null;
		file = new File("Vazno/RecentWorkspace.txt");
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
    		
    		citanjeDokumenta(root);
       	 }
        }
		
	}

	private void citanjeDokumenta(Node root) {
		NodeList nodeList = root.getChildNodes();
		for(int i=0; i< nodeList.getLength(); i++)
		{
			File file = new File(nodeList.item(i).getTextContent());
			if(file.exists())
			{	
				WindowForChooseWorkspace.getjComboBox().addItem(file.toString());
			}
		}
	}
	
	
	 public void sacuvaj() throws Exception
	 {
		 factory = DocumentBuilderFactory.newInstance();
		 builder = factory.newDocumentBuilder();
		 document = builder.newDocument();

		 Element elementRoot = document.createElement("Workspaces");
		 
		 document.appendChild(elementRoot);
		 
		 for(int i =0; i < WindowForChooseWorkspace.getjComboBox().getItemCount(); i++)
		 {
			 Element element = document.createElement("Workspace");
			 element.setTextContent(WindowForChooseWorkspace.getjComboBox().getItemAt(i));
			 elementRoot.appendChild(element);
		 }
		 TransformerFactory transformerFactory= TransformerFactory.newInstance();
		 Transformer transformer = transformerFactory.newTransformer();
		 DOMSource source = new DOMSource(document);
		 StreamResult streamResult= new StreamResult(new File("Vazno/RecentWorkspace.txt")); 
	
		 //mora postojati putanja u koju ce se smjestiti
	
		 transformer.transform(source, streamResult);
	
     }

}

