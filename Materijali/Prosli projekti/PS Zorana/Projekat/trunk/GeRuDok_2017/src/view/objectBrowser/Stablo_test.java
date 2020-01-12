package view.objectBrowser;


import java.io.IOException;
import java.util.Observable;

import javax.swing.JOptionPane;

import javax.swing.JTree;

import javax.swing.tree.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import observerPattern.Observer;


/**
 * XmlJTree class
 * @author Ibrabel
 */
public final class Stablo_test extends JTree implements java.util.Observer {
    DefaultTreeModel dtModel=null;
   

    /**
     * XmlJTree constructor
     * @param filePath
     */
    
    
    public Stablo_test(String filePath){
        if(filePath!=null)
        setPath(filePath);
     }
    
    public  void setPath(String filePath){
        Node root = null;
        /*
            Parse the xml file
        */
        try {
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(filePath);
            root = (Node) doc.getDocumentElement();
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            JOptionPane.showMessageDialog(null,"Can't parse file",
                            "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        /*
            if any result set the appropriate model to the jTree
        */
        if(root!=null){
            dtModel= new DefaultTreeModel(builtTreeNode(root));
            this.setModel(dtModel);
        }
    }

    /**
     * fullTreeNode Method
     * construct the full jTree from any xml file
     * this method is recursive
     * @param root
     * @return DefaultMutableTreeNode
     */
    private DefaultMutableTreeNode builtTreeNode(Node root){
        DefaultMutableTreeNode dmtNode;

        dmtNode = new DefaultMutableTreeNode(root.getNodeName());
            NodeList nodeList = root.getChildNodes();
            for (int count = 0; count < nodeList.getLength(); count++) {
                Node tempNode = nodeList.item(count);
                // make sure it's element node.
                if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                    if (tempNode.hasChildNodes()) {
                        // loop again if has child nodes
                        dmtNode.add(builtTreeNode(tempNode));
                    }
                }
            }
        return dmtNode;
    }





	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
    
}