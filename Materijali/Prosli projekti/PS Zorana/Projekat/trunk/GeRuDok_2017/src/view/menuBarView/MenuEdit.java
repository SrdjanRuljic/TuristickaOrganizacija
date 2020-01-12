package view.menuBarView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuEdit extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JMenuItem undo;
	JMenuItem redo;
	JMenuItem cut;
	JMenuItem copy;
	JMenuItem paste;
	JMenuItem delete;
	JMenuItem find;
	
	public JMenuItem getUndo() {
		return undo;
	}
	public void setUndo(JMenuItem undo) {
		this.undo = undo;
	}
	
	public JMenuItem getRedo() {
		return redo;
	}
	public void setRedo(JMenuItem redo) {
		this.redo = redo;
	}
	
	public JMenuItem getCut() {
		return cut;
	}
	public void setCut(JMenuItem cut) {
		this.cut = cut;
	}
	
	public JMenuItem getCopy() {
		return copy;
	}
	public void setCopy(JMenuItem copy) {
		this.copy = copy;
	}
	
	public JMenuItem getPaste() {
		return paste;
	}
	public void setPaste(JMenuItem paste) {
		this.paste = paste;
	}
	
	public JMenuItem getDelete() {
		return delete;
	}
	public void setDelete(JMenuItem delete) {
		this.delete = delete;
	}
	
	public JMenuItem getFind() {
		return find;
	}
	public void setFind(JMenuItem find) {
		this.find = find;
	}
	
	public MenuEdit()
	{
		setText("Edit");
		setMnemonic('E');
		setBackground(Color.blue);
		setBorder(BorderFactory.createEmptyBorder(2, 5, 5, 8));
		dodajKomponente();
		setVisible(true);
		
		
	}
	
	public void dodajKomponente()
	{
		undo = new JMenuItem("Undo", new ImageIcon("slike/menuEditIcons/undo.png"));
		undo.setMnemonic(KeyEvent.VK_Z);
		undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		undo.setActionCommand("undo");
		add(undo);
		
		redo = new JMenuItem("Redo", new ImageIcon("slike/menuEditIcons/redo.png"));
		redo.setMnemonic(KeyEvent.VK_Y);
		redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		redo.setActionCommand("redo");
		add(redo);
		addSeparator();
		
		cut = new JMenuItem("Cut", new ImageIcon("slike/menuEditIcons/cut.png"));
		cut.setMnemonic(KeyEvent.VK_CUT);
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		cut.setActionCommand("cut");
		add(cut);
		
		copy = new JMenuItem("Copy", new ImageIcon("slike/menuEditIcons/copy.png"));
		copy.setMnemonic(KeyEvent.VK_COPY);
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		copy.setActionCommand("copy");
		add(copy);
		
		paste = new JMenuItem("Paste", new ImageIcon("slike/menuEditIcons/paste.png"));
		paste.setMnemonic(KeyEvent.VK_PASTE);
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		paste.setActionCommand("paste");
		add(paste);
		addSeparator();
		
		delete = new JMenuItem("Delete", new ImageIcon("slike/menuEditIcons/delete.png"));
		delete.setMnemonic(KeyEvent.VK_DELETE);
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK));
		delete.setActionCommand("delete");
		add(delete);
		addSeparator();
		
		find = new JMenuItem("Find", new ImageIcon("slike/menuEditIcons/find.png"));
		find.setMnemonic(KeyEvent.VK_FIND);
		find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		find.setActionCommand("find");
		add(find);
	}
	
}
