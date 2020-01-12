/***********************************************************************
 * Module:  Text.java
 * Author:  Ivana
 * Purpose: Defines the Class Text
 ***********************************************************************/

package documentModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import applicationModel.TextModel;
import dialogs.FindAndReplace;
import localization.Localization;
import main.MainClass;

public class Text extends SlotContent{

	private static final long serialVersionUID = 1L;
	private static Localization local = Localization.getInstance();

	private String content = "";
	private String textFont = "Arial";
	private int textType = Font.PLAIN;
	private int textSize = 12;
	private Color textColor = Color.black;
	private Color textBackgroundColor = Color.white;
	boolean textChanged = false;
	
	public JPanel panel;
	public JScrollPane scrollPane;
	public JTextPane textPane;
	
	TextModel model;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getTextFont() {
		return textFont;
	}
	
	public void setTextFont(String textFont) {
		this.textFont = textFont;
	}
	
	public int getTextType() {
		return textType;
	}

	public void setTextType(int textType) {
		this.textType = textType;
	}
	
	public int getTextSize() {
		return textSize;
	}

	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}

	public Color getTextColor() {
		return textColor;
	}

	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}
	
	public Color getTextBackgroundColor() {
		return textBackgroundColor;
	}

	public void setTextBackgroundColor(Color textBackgroundColor) {
		this.textBackgroundColor = textBackgroundColor;
	} 

	public Text(Dimension dimension){
		this.add(initComponent(dimension));
	}
	
	public JTextPane getPane(){
		return textPane;
	}
	
	public Component initComponent(Dimension dimension){
		textPane = new JTextPane();
		textPane.setPreferredSize(dimension);
		textPane.setMaximumSize(dimension);
		textPane.setMinimumSize(dimension);
		textPane.setEditable(true);
		textPane.setAutoscrolls(true);
		textPane.setBackground(getTextBackgroundColor());
		textPane.setLayout(new BorderLayout());
		textPane.setBorder(BorderFactory.createLineBorder(Color.black));
		textPane.setOpaque(true);
		textPane.setVisible(true);
		scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(dimension);
		scrollPane.createVerticalScrollBar();
		scrollPane.setVisible(true);
		scrollPane.getBaselineResizeBehavior();
		return scrollPane;
	}
	
	public void changeDimension(Dimension dimension){
		removeAll();
		textPane.setPreferredSize(dimension);
		textPane.setMaximumSize(dimension);
		textPane.setMinimumSize(dimension);
		textPane.setEditable(true);
		textPane.setAutoscrolls(true);
		textPane.setBackground(getTextBackgroundColor());
		textPane.setLayout(new BorderLayout());
		textPane.setBorder(BorderFactory.createLineBorder(Color.black));
		textPane.setOpaque(true);
		textPane.setVisible(true);
		scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(dimension);
		scrollPane.createVerticalScrollBar();
		scrollPane.setVisible(true);
		scrollPane.getBaselineResizeBehavior();
		add(scrollPane);
	}
	
	public void SetFont(Font font) {
		textFont = font.getFamily();
		textType = font.getStyle();
		textSize = font.getSize();
		textPane.setFont(font);
	}

	public void SetTextSize(int fontSize) {
		Font f = new Font(textPane.getFont().getFamily(), textPane.getFont().getStyle(), fontSize);
		textFont = textPane.getFont().getFamily();
		textType = textPane.getFont().getStyle();
		textSize = fontSize;
		textPane.setFont(f);
	}
	
	public void SetTextBold() {
		if(textType == Font.BOLD)
		{
			textPane.setFont(new Font(textPane.getFont().getFamily(), Font.PLAIN, textPane.getFont().getSize()));
			textType = Font.PLAIN;
		}
		else if(textType == Font.ITALIC)
		{
			textPane.setFont(new Font(textPane.getFont().getFamily(), Font.BOLD | Font.ITALIC, textPane.getFont().getSize()));
			textType = Font.BOLD | Font.ITALIC;
		}
		else if(textType == (Font.BOLD | Font.ITALIC))
		{
			textPane.setFont(new Font(textPane.getFont().getFamily(), Font.ITALIC, textPane.getFont().getSize()));	//BOLD I ITALIC
			textType = Font.ITALIC;
		}
		else
		{
			textPane.setFont(new Font(textPane.getFont().getFamily(), Font.BOLD, textPane.getFont().getSize()));
			textType = Font.BOLD;
		}
	}
	
	public void SetTextItalic() {
		if(textType == Font.ITALIC)
		{
			textPane.setFont(new Font(textPane.getFont().getFamily(), Font.PLAIN, textPane.getFont().getSize()));
			textType = Font.PLAIN;
		}
		else if(textType == Font.BOLD)
		{
			textPane.setFont(new Font(textPane.getFont().getFamily(), Font.BOLD | Font.ITALIC, textPane.getFont().getSize()));
			textType = Font.ITALIC | Font.BOLD;
		}
		else if(textType == (Font.BOLD | Font.ITALIC))
		{
			textPane.setFont(new Font(textPane.getFont().getFamily(), Font.BOLD, textPane.getFont().getSize()));	//BOLD I ITALIC
			textType = Font.BOLD;
		}
		else
		{
			textPane.setFont(new Font(textPane.getFont().getFamily(), Font.ITALIC, textPane.getFont().getSize()));	
			textType = Font.ITALIC;
		}	
	}
	
	public void SetTextUnderline() {
		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);				
	}
	
	public void SetTextColor() {
		Color color = JColorChooser.showDialog(null, "Select  a  color", null);
		textColor = color;
		this.textPane.setForeground(color);
	}

	public void SetTextBackgroundColor() {
		Color color = JColorChooser.showDialog(null, "Select  a  color", null);
		textBackgroundColor = color;
		this.textPane.setBackground(color);
	}
	
	public void SetTextAlignment(String alignment) {
		if(alignment == "left")
	      {
			JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);				
	      }
	      else if(alignment == "right")
	      {
	  		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);				
	      }
	      else
	      {
	  		JOptionPane.showMessageDialog(null, local.getString("menuBar.message"), local.getString("menuBar.title"), JOptionPane.INFORMATION_MESSAGE);				
	      }
	}
	
	public void Find() {
		new FindAndReplace(MainClass.mf, false);
	}
	
	public void Replace() {
		new FindAndReplace(MainClass.mf, true);
	}
   
	public void Link() {
      // TODO: implement
	}
	
	public void setTextComponent(Color textColor, String font, int size, int type, Color textBackgroundColor, String textContent)
	{
		setTextFont(font);
		setTextSize(size);
		setTextType(type);
		setTextColor(textColor);
		setContent(textContent);
		setTextBackgroundColor(textBackgroundColor);
		textPane.setText(textContent);
		textPane.setFont(new Font(font, type, size));
		textPane.setForeground(textColor);
		textPane.setBackground(textBackgroundColor);
	}
}