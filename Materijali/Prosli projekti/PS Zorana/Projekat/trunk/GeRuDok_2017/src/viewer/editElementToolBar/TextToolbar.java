package viewer.editElementToolBar;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.text.StyledEditorKit;
import javax.swing.undo.UndoManager;

import controller.editElement.FontListener;
import controller.editElement.TextToolbarCopyListener;
import controller.editElement.TextToolbarCutListener;
import controller.editElement.TextToolbarPasteListener;
import controller.editElement.VelicinaFontaListener;
import viewer.editElement.UndoManagerHelper;

public class TextToolbar extends JToolBar
{

	private static final long serialVersionUID = 1L;
	
	JButton cut;
	JButton copy;
	JButton paste;
	
	JToggleButton bold;
	JToggleButton italic;
	JToggleButton underline;
	
	public static JComboBox<String> fontovi;
	public static JComboBox<Integer> velicinaFonta;
	JButton boja;
	
	JButton undo;
	JButton redo;
	
	public static UndoManager manager;
	
	public TextToolbar()
	{
		setName("Text Toolbar");
		setRollover(true);
		dodajKomponente();
	}
	
	public void dodajKomponente()
	{
		//mozda se ovdje jos sta da pojednostaviti
		cut = new JButton(new ImageIcon("slike/EditElement/TextToolbar/cut.png"));
		cut.setToolTipText("Cut");
		StyledEditorKit styledEditorKit = new StyledEditorKit();
		
		cut.addActionListener(new TextToolbarCutListener());
		add(cut);
		
		copy = new JButton(new ImageIcon("slike/EditElement/TextToolbar/copy.png"));
		copy.setToolTipText("Copy");
		copy.addActionListener(new TextToolbarCopyListener());
		add(copy);
		
		paste = new JButton(new ImageIcon("slike/EditElement/TextToolbar/paste.png"));
		paste.setToolTipText("Paste");
		paste.addActionListener(new TextToolbarPasteListener());
		add(paste);
		addSeparator();
		
		bold = new JToggleButton(new ImageIcon("slike/EditElement/TextToolbar/bold.png"));
		bold.setToolTipText("Bold");
		bold.addActionListener(new StyledEditorKit.BoldAction());
		add(bold);
		
		italic = new JToggleButton(new ImageIcon("slike/EditElement/TextToolbar/italic.png"));
		italic.setToolTipText("Italic");
		italic.addActionListener(new StyledEditorKit.ItalicAction());
		add(italic);
		
		underline = new JToggleButton(new ImageIcon("slike/EditElement/TextToolbar/underline.png"));
		underline.setToolTipText("Underline");
		underline.addActionListener(new StyledEditorKit.UnderlineAction());
		add(underline);
		addSeparator();
		
		boja = new JButton(new ImageIcon("slike/EditElement/TextToolbar/color.png"));
		boja.setToolTipText("Color");
		
		//add(boja);
		addSeparator();
		
		fontovi = new JComboBox<String>();
		listaFontova();
		fontovi.addItemListener(new FontListener());
		
		add(fontovi);
		addSeparator();
		
		velicinaFonta = new JComboBox<Integer>();
		velicinaFonta.addItem(8);
		velicinaFonta.addItem(10);
		velicinaFonta.addItem(12);
		velicinaFonta.addItem(14);
		velicinaFonta.addItem(16);
		velicinaFonta.addItem(22);
		velicinaFonta.addItem(26);
		velicinaFonta.addItem(32);
		velicinaFonta.addItem(40);
		velicinaFonta.addItemListener(new VelicinaFontaListener());
		add(velicinaFonta);
		addSeparator();
		
		manager  = new UndoManager();
		 add(UndoManagerHelper.getUndoAction(manager));
		 add(UndoManagerHelper.getRedoAction(manager));
	}

	public JButton getCut() {
		return cut;
	}

	public void setCut(JButton cut) {
		this.cut = cut;
	}

	public JButton getCopy() {
		return copy;
	}

	public void setCopy(JButton copy) {
		this.copy = copy;
	}

	public JButton getPaste() {
		return paste;
	}

	public void setPaste(JButton paste) {
		this.paste = paste;
	}

	public JToggleButton getBold() {
		return bold;
	}

	public void setBold(JToggleButton bold) {
		this.bold = bold;
	}

	public JToggleButton getItalic() {
		return italic;
	}

	public void setItalic(JToggleButton italic) {
		this.italic = italic;
	}

	public JToggleButton getUnderline() {
		return underline;
	}

	public void setUnderline(JToggleButton underline) {
		this.underline = underline;
	}

	public JComboBox<Integer> getVelicinaFonta() {
		return velicinaFonta;
	}

	public void setVelicinaFonta(JComboBox<Integer> velicinaFonta) {
		this.velicinaFonta = velicinaFonta;
	}

	public JButton getBoja() {
		return boja;
	}

	public void setBoja(JButton boja) {
		this.boja = boja;
	}
	
	public void listaFontova()
	{
		String[] fontoviLista;
		fontoviLista = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for (String string : fontoviLista) {
			fontovi.addItem(string);
		}
		
	}
	
}
