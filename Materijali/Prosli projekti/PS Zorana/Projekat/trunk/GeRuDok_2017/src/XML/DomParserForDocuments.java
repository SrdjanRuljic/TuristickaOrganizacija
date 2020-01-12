package XML;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.tree.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import model.Dokument;
import model.Elemenat;
import model.Projekat;
import model.Slot;
import model.Stranica;

public class DomParserForDocuments {
	
	
	DocumentBuilderFactory documentBuilderFactory;
    DocumentBuilder documentBuilder;
	Document document;
	DefaultTreeModel dtModel=null;
	Projekat projekat;
	Dokument dokument;
	Stranica stranica;
	Slot slot;
	Elemenat elemenat, elemenat2;
	String visina, sirina;
	File file;
 

    public DomParserForDocuments(Projekat projekat)
    {
    	this.projekat = projekat;
    }

    public void citanje(File file){
        Node root = null;
        /*
            Parse the xml file
        */
        try {
        
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file.getPath());
            
            root = (Node) doc.getDocumentElement();
            
            dokument = new Dokument();
            dokument.setImeDokumenta(file.getName().replaceAll(".xml", ""));
            projekat.getDokumenti().add(dokument);
            
        } 
        catch (IOException | ParserConfigurationException | SAXException ex)
        {
            JOptionPane.showMessageDialog(null,"Nije moguæe parsirati fajl!",
                            "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        citanjeDokumenta(root);
        
    }

    /**
     * fullTreeNode Method
     * construct the full jTree from any xml file
     * this method is recursive
     * @param root
     */
    private void citanjeDokumenta(Node root)
    {
       
    	
    	Element elementDokument = (Element) root;
        sirina = elementDokument.getAttribute("Sirina_stranice");
		visina = elementDokument.getAttribute("Visina_stranice");
		dokument.setSirinaStranice(Integer.parseInt(sirina.toString()));
		dokument.setVisinaStranice(Integer.parseInt(visina.toString()));
	
		if(elementDokument.hasChildNodes())
		{
			dodavanjeStranica(elementDokument.getChildNodes());
		 }
 
    }
    
    private void dodavanjeStranica(NodeList stranice)
    {
    	for (int count = 0; count < stranice.getLength(); count++)
    	{
            Node nodeStranica = stranice.item(count);
            if(nodeStranica.getNodeType() == Node.ELEMENT_NODE)
    		{
            	stranica = new Stranica(count);
            	if(nodeStranica.hasChildNodes())
            	{	
            		dodavanjeSlotova(nodeStranica.getChildNodes());
            	}
            	dokument.getStranice().add(stranica);
    		}
    	}
    }
    
    private void dodavanjeSlotova(NodeList slotovi)
    {
    	 for(int i =0; i<slotovi.getLength(); i++)
    	 {
    		 Node nodeSlot = slotovi.item(i);
    		 Element elementSlot = (Element) nodeSlot;
    		 if(nodeSlot.getNodeType() == Node.ELEMENT_NODE)
 			{
 				slot = new Slot();
 				sirina = elementSlot.getAttribute("Sirina_slota");
 				visina = elementSlot.getAttribute("Visina_slota");

 	        	slot.setSirinaSlota(Integer.parseInt(sirina.toString()));
 	        	slot.setVisinaSlota(Integer.parseInt(visina.toString()));
 	        	if(nodeSlot.hasChildNodes())
 	        	{
 	        		if(nodeSlot.getChildNodes().getLength() > 1)
 	        		{
 	        			JOptionPane.showMessageDialog(null,"Dati dokument ne zadovoljava strukturu!",
 	                            "Error", JOptionPane.ERROR_MESSAGE);
 	        		}
 	        		else
 	        		{	
 	        			dodavanjeElementa(nodeSlot.getFirstChild());
 	        		}
 	        	}
 	        	stranica.getSlotovi().add(slot);	
 			}
    		 
    	 }
    }
    
    private void dodavanjeElementa(Node nodeElement)
    {
    	 if(nodeElement.getNodeType() == Node.ELEMENT_NODE)
    	 {
    		 elemenat = new Elemenat();
    		 slot.setElemenat(elemenat);
    		 if(nodeElement.hasChildNodes())
    		 {
    			 dodavanjeElemenataUElemenat(nodeElement.getChildNodes(), elemenat);
    		 }
    	 }
    }
    
    private void dodavanjeElemenataUElemenat(NodeList elementi, Elemenat elemenat)
    {
    	for(int j=0; j<elementi.getLength(); j++)
    	{
    		Node elementNode = elementi.item(j);
    		if(elementNode.getNodeType() == Node.ELEMENT_NODE)
    		{
    			elemenat2 = new Elemenat();
    			elemenat.getListaElemenata().add(elemenat2);
    			if(elementNode.hasChildNodes())
    			{
    				dodavanjeElemenataUElemenat(elementNode.getChildNodes(), elemenat2);
    			}
    		}
    	}
    }
    
    public void sacuvajDokument(Dokument dokument, Path path) throws Exception
   	{
    	
          documentBuilderFactory=DocumentBuilderFactory.newInstance();
            documentBuilder= documentBuilderFactory.newDocumentBuilder();
            document =documentBuilder.newDocument();
  
            /**
             * Glavni root element koji predstavlja dokument u kojem se nalazi ime dokumenta
    	     * i stranice dokumenta
             * @author Darko
             */
    	
            
            Element elementDokument = document.createElement("Dokument");
            document.appendChild(elementDokument);
    	
            /**
             * pages predstavlja novi root element-cvor(Stranice).
             * Unutra ovog root elementa se nalaze stranice(dodavane jedna po jedna metodom 
             * VratiXML i njihove dimenzije)
             * Na kraju se pages root element(Stranice) u kojem se nalaze sve stranice
             *  se dodaje u glavni root element(element)Dokumenta
             * @author Darko
             */
    	
            Attr width = document.createAttribute("Sirina_stranice");
            width.setValue(Integer.toString(dokument.getSirinaStranice()));
            elementDokument.setAttributeNode(width);
            Attr height = document.createAttribute("Visina_stranice");
            height.setValue(Integer.toString(dokument.getVisinaStranice()));
            elementDokument.setAttributeNode(height);
	    	for (Stranica stranica : dokument.getStranice())
	    	{
	    		elementDokument.appendChild(stranica.vratiStranicu(document)); 
	    	}
    	
            TransformerFactory transformerFactory= TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            
            File file = new File(path+"/"+dokument.getImeDokumenta()+".xml");
            if(!file.exists())
            {
            	file.createNewFile();
            }
            StreamResult streamResult= new StreamResult(file); 
    	
            //mora postojati putanja u koju ce se smjestiti
    	
            transformer.transform(source, streamResult);
    	
            }

}
