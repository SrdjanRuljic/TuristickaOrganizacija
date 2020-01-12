package viewer.editElement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.Border;

import controller.editElement.EditElementClosingListener;
import controller.editElement.PopupMenuEditElementListener;
import model.Elemenat;
import viewer.editAndPreviewArea.PagesArea;
import viewer.editAndPreviewArea.slot.EditSlot;
import viewer.editElementToolBar.ElementToolbarContainer;
import viewer.editElementToolBar.TextToolbar;
import viewer.element.ElementArea;


//da li da bude JFrame ili JDialog
public class WindowEditElement extends JFrame
{
	private static final long serialVersionUID = 1L;

	JButton btnNewTextElement;
	JButton btnNewGraphicsElement;
	JPanel jPanelButtons;
	JPanel jPanel;
	public static TextArea textArea;
	EditElementClosingListener editElementClosingListener;

	public static ElementArea elementArea;
	
	public WindowEditElement()
	{
		super();
	
		Elemenat elemenat = new Elemenat();
		
		elementArea = new ElementArea(elemenat);
		elementArea.setPreferredSize(new Dimension(PagesArea.activeEditSlot.getWidth()-20, PagesArea.activeEditSlot.getHeight()-20));
		elementArea.setBackground(new Color(240, 255, 240));
		
		podesiParametreProzora();
		
		jPanel = new JPanel();
		jPanel.setPreferredSize(new Dimension(650, 650));
		jPanel.setBackground(Color.WHITE);
		
		textArea = new TextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setPreferredSize(new Dimension(PagesArea.activeEditSlot.getWidth()-30, PagesArea.activeEditSlot.getHeight()-30));
		textArea.getDocument().addUndoableEditListener(TextToolbar.manager);
		
		elementArea.add(textArea);
		
		jPanel.add(elementArea);
		add(jPanel);
		
		editElementClosingListener = new EditElementClosingListener();
		addWindowListener(editElementClosingListener);
		setVisible(true);
	}
	
	public void podesiParametreProzora()
	{
		setTitle("Edit Element");
		setBounds(200,200,800,600);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("slike/ElementPopupMenu/edit.png"));
		add(new ElementToolbarContainer(), BorderLayout.NORTH);
	}
	
	public void unknownElement(){}
	
	/*public WindowEditElement(ElementArea elementArea)
	{
		podesiParametreProzora();
		jPanelButtons = new JPanel();
		
		btnNewTextElement = new JButton("New Text Element");
		btnNewTextElement.setBounds(100, 200, 100, 100);
		
		btnNewGraphicsElement = new JButton("New Graphics Element");
		btnNewGraphicsElement.setBounds(250, 200, 100, 100);
		
		jPanelButtons.add(btnNewTextElement);
		jPanelButtons.add(btnNewGraphicsElement);
		
		add(jPanelButtons);
		setVisible(true);
		
		
	}*/
	


	public JButton getBtnNewTextElement() {
		return btnNewTextElement;
	}

	public void setBtnNewTextElement(JButton btnNewTextElement) {
		this.btnNewTextElement = btnNewTextElement;
	}

	public JButton getBtnNewGraphicsElement() {
		return btnNewGraphicsElement;
	}

	public void setBtnNewGraphicsElement(JButton btnNewGraphicsElement) {
		this.btnNewGraphicsElement = btnNewGraphicsElement;
	}

	public JPanel getjPanelButtons() {
		return jPanelButtons;
	}

	public void setjPanelButtons(JPanel jPanelButtons) {
		this.jPanelButtons = jPanelButtons;
	}


	public JPanel getjPanel() {
		return jPanel;
	}

	public void setjPanel(JPanel jPanel) {
		this.jPanel = jPanel;
	}

	public TextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(TextArea textArea) {
		this.textArea = textArea;
	}

	public ElementArea getElementArea() {
		return elementArea;
	}

	public void setElementArea(ElementArea elementArea) {
		this.elementArea = elementArea;
	}
}
