package controller.pageProperties;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import view.pageProperties.PageProperties;
import viewer.editAndPreviewArea.DocumentsArea;
import viewer.editAndPreviewArea.PagesArea;

public class btnOKListener implements ActionListener {

	private int width, height;
	private boolean izlaz = true;
	Object[] options = {"OK"};
	PagesArea pagesArea;
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		pagesArea = DocumentsArea.getActivePagesArea();
		
		podesiBojuStranice();
		podesiVelicinuStranice();
		podesiPozicijuBrojaNaStr();
	}
	
	public void podesiBojuStranice()
	{
		if(PageProperties.background != null)
		{	
			pagesArea.bojaStranice = PageProperties.background;
			DocumentsArea.getActivePagesArea().promijeniBojuStranica(PageProperties.background);
		}
	}
	
	public void podesiVelicinuStranice()
	{
		try
		{
			width = Integer.parseInt(PageProperties.textWidth.getText());
		}
		catch(NumberFormatException nfe)
		{
			JOptionPane.showOptionDialog(null, "Value in fields width is not a number.", "Number error", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, new ImageIcon("slike/error.png"), options, options[0]);
			PageProperties.textWidth.setText("");
			izlaz = false;
		}
		try
		{
			height = Integer.parseInt(PageProperties.textHeight.getText());
		}
		catch(NumberFormatException nfe)
		{
		    JOptionPane.showOptionDialog(null, "Value in fields height is not a number.", "Number error", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, new ImageIcon("slike/error.png"), options, options[0]);
			PageProperties.textHeight.setText("");
			izlaz = false;
		}
		
		if(izlaz)
		{
			pagesArea.setVisinaStranice(height);
			pagesArea.setSirinaStranice(width);
			DocumentsArea.getActivePagesArea().promijeniVelicnuStranica(width, height);
		}
	}
	
	public void podesiPozicijuBrojaNaStr()
	{
		if(PageProperties.textHeight.getText().length() > 0 && PageProperties.textWidth.getText().length() > 0 )
		{
			String position = (String) PageProperties.positionPageNumber.getSelectedItem();
			DocumentsArea.getActivePagesArea().pozicioniranjeBrojaNaStr(position);
			
		}
	}
	
}
