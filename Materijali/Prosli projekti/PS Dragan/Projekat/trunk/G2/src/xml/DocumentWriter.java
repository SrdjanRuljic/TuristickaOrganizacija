/***********************************************************************
 * Module:  DocumentWriter.java
 * Author:  draga_000
 * Purpose: Defines the Class DocumentWriter
 ***********************************************************************/

package xml;


import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.io.File;
import java.util.ArrayList;
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
import applicationModel.PageModel;
import controller.SlotController;
import documentModel.Graphics2d;
import documentModel.Page;
import documentModel.Slot;
import documentModel.Text;


/** @pdOid ffab4e16-e1d7-4742-bd3d-0743cdbc5494 */
public class DocumentWriter {
	public void createDocument(Page page, PageModel pageModel, String name, String location)
	{
		try //PROSLIJEDITI I DOKUMENT, PA UMJESTO IMENA I LOKACIJE DATUM KREIRANJA I MODIFIKACIJE
		{
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			
			Document document = builder.newDocument();
			
			Element dokumentElement = document.createElement("document");
			Attr imeDokumenta = document.createAttribute("name");//treba created umjesto ovoga
			imeDokumenta.setValue(name);
			dokumentElement.setAttributeNode(imeDokumenta);
			Attr lokacijaDokumenta = document.createAttribute("location");//treba modified
			lokacijaDokumenta.setValue(location);
			dokumentElement.setAttributeNode(lokacijaDokumenta);
			document.appendChild(dokumentElement); 
			
			Element stranicaElement = document.createElement("page");
			Attr bojaStranice = document.createAttribute("color");
			bojaStranice.setValue(Integer.toString(page.color.getRGB())); 
			stranicaElement.setAttributeNode(bojaStranice);
			Attr gridStranice = document.createAttribute("grid");
			gridStranice.setValue(Integer.toString(page.grid));
			stranicaElement.setAttributeNode(gridStranice);
			Attr gridVidljivostStranice = document.createAttribute("gridVisible");
			gridVidljivostStranice.setValue(page.gridVisible.toString());
			stranicaElement.setAttributeNode(gridVidljivostStranice);
			Attr heightStranice = document.createAttribute("height");
			heightStranice.setValue(Integer.toString(page.size.height));
			stranicaElement.setAttributeNode(heightStranice);
			Attr widthStranice = document.createAttribute("width");
			widthStranice.setValue(Integer.toString(page.size.height));
			stranicaElement.setAttributeNode(widthStranice);
			dokumentElement.appendChild(stranicaElement); 
			
			ArrayList<SlotController> nizSlotova = pageModel.getNizSlotova();
			for (SlotController slot : nizSlotova) 
			{
				Element slotElement=getSlotParameters(document,slot.view);
				stranicaElement.appendChild(slotElement);
			}
			
			saveToXMLFile(document, location);
		} 
		catch (ParserConfigurationException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public Element getSlotParameters(Document document, Slot slot)
	{
		String slotX=Integer.toString(slot.getPositionX());
		String slotY=Integer.toString(slot.getPositionY());
		String slotHeight=Integer.toString(slot.getHeight());
		String slotWidth=Integer.toString(slot.getWidth());
		
		Element slotElement = document.createElement("slot");
		
		Attr x = document.createAttribute("x");
		Attr y = document.createAttribute("y");
		Attr height = document.createAttribute("height");
		Attr width = document.createAttribute("width");
				
		x.setValue(slotX);
		y.setValue(slotY);
		height.setValue(slotHeight);
		width.setValue(slotWidth);
		
		slotElement.setAttributeNode(x);
		slotElement.setAttributeNode(y);
		slotElement.setAttributeNode(height);
		slotElement.setAttributeNode(width);
		
		Element contentElement=getSlotContent(document,slot); //slot.getContent();
		
		slotElement.appendChild(contentElement);
		
		return slotElement;
	}
	
	public Element getSlotContent(Document document, Slot slot)
	{
		Element contentElement = document.createElement("content");
		
		Attr type=document.createAttribute("type");
		type.setValue(Integer.toString(slot.contentType));
		contentElement.setAttributeNode(type);
		if(slot.contentType==1)
		{
			//text
			Text text= (Text)slot.slotContent;
			Element textElement = document.createElement("text");
			
			Attr backgroundColorAttr = document.createAttribute("backgroundColor");
			backgroundColorAttr.setValue(Integer.toString(text.getTextBackgroundColor().getRGB()));
			textElement.setAttributeNode(backgroundColorAttr);
			
			Attr colorAttr = document.createAttribute("color");
			colorAttr.setValue(Integer.toString(text.getTextColor().getRGB()));
			textElement.setAttributeNode(colorAttr);
			
			Attr fontAttr = document.createAttribute("font");
			fontAttr.setValue(text.getTextFont());
			textElement.setAttributeNode(fontAttr);
			
			Attr sizeAttr = document.createAttribute("size");
			sizeAttr.setValue(Integer.toString(text.getTextSize()));
			textElement.setAttributeNode(sizeAttr);
			
			Attr typeAttr = document.createAttribute("type");
			typeAttr.setValue(Integer.toString(text.getTextType()));
			textElement.setAttributeNode(typeAttr);
			
			textElement.appendChild(document.createTextNode(text.textPane.getText()));//Ubaciti pravi tekst
			
			contentElement.appendChild(textElement);
		}
		else if (slot.contentType==2)
		{
			//2d
			Graphics2d graphics2d = (Graphics2d)slot.slotContent;
			Element graphics2dElement = document.createElement("graphics2d");
			
			ArrayList<Shape> shapes = graphics2d.shapes;
			ArrayList<Point> points = graphics2d.points;
			int count=0;
			int countShapes=0;
			for(Shape shape:shapes)
			{
				Rectangle rect = shape.getBounds();
				int x=(int)points.get(countShapes).getX();
				int y=(int)points.get(countShapes).getY();
				countShapes++;
				int height=(int) shapes.get(count).getBounds().getHeight();
				int width=(int)shapes.get(count).getBounds().getWidth();
				count++;
				
				String typeShape="";
				if(shape.getClass().toString().contains("Line"))
				{
					typeShape="2";
				}
				else if(shape.getClass().toString().contains("Rectangle"))
				{
					typeShape="3";
				}
				else if(shape.getClass().toString().contains("Ellipse"))	
				{
					
					if(height==7 && width==7)
						typeShape="1";
					else
						typeShape="4";
				}
				
				height=(int)points.get(countShapes).getX();
				width=(int)points.get(countShapes).getY();
				countShapes++;
				Element shapeElement=document.createElement("shape");
				
				Attr typeShapeAttr = document.createAttribute("shapeType");
				typeShapeAttr.setNodeValue(typeShape);
				shapeElement.setAttributeNode(typeShapeAttr);
				
				Attr xAttr = document.createAttribute("x");
				xAttr.setNodeValue(Integer.toString(x));
				shapeElement.setAttributeNode(xAttr);
				
				Attr yAttr = document.createAttribute("y");
				yAttr.setNodeValue(Integer.toString(y));
				shapeElement.setAttributeNode(yAttr);
				
				Attr heightAttr = document.createAttribute("sheight");
				heightAttr.setNodeValue(Integer.toString(height));
				shapeElement.setAttributeNode(heightAttr);
				
				Attr widthAttr = document.createAttribute("swidth");
				widthAttr.setNodeValue(Integer.toString(width));
				shapeElement.setAttributeNode(widthAttr);
				
				graphics2dElement.appendChild(shapeElement);
			}
			Attr countAttr=document.createAttribute("count");
			countAttr.setValue(Integer.toString(count));
			graphics2dElement.setAttributeNode(countAttr);
			contentElement.appendChild(graphics2dElement);
		}
		return contentElement;
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