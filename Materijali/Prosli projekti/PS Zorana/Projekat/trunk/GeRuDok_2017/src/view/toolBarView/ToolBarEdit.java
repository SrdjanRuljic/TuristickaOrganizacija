package view.toolBarView;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBarEdit extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton undo;
	JButton redo;
	JButton cut;
	JButton copy;
	JButton paste;
	JButton delete;
	JButton find;
	
	public JButton getUndo() {
		return undo;
	}

	public void setUndo(JButton undo) {
		this.undo = undo;
	}

	public JButton getRedo() {
		return redo;
	}

	public void setRedo(JButton redo) {
		this.redo = redo;
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

	public JButton getDelete() {
		return delete;
	}

	public void setDelete(JButton delete) {
		this.delete = delete;
	}

	public JButton getFind() {
		return find;
	}

	public void setFind(JButton find) {
		this.find = find;
	}

	public ToolBarEdit()
	{
		setName("Edit");
		setRollover(true);
		dodajKomponente();
	}
	
	public void dodajKomponente()
	{
		undo = new JButton(new ImageIcon("slike/ToolBarIcons/ToolBarEditIcons/undo.png"));
		undo.setToolTipText("Undo");
		add(undo);
		
		redo = new JButton(new ImageIcon("slike/ToolBarIcons/ToolBarEditIcons/redo.png"));
		redo.setToolTipText("Redo");
		add(redo);
		addSeparator();
		
		cut = new JButton(new ImageIcon("slike/ToolBarIcons/ToolBarEditIcons/cut.png"));
		cut.setToolTipText("Cut");
		add(cut);
		
		copy = new JButton(new ImageIcon("slike/ToolBarIcons/ToolBarEditIcons/copy.png"));
		copy.setToolTipText("Copy");
		add(copy);
		
		paste = new JButton(new ImageIcon("slike/ToolBarIcons/ToolBarEditIcons/paste.png"));
		paste.setToolTipText("Paste");
		add(paste);
		addSeparator();
		
		delete = new JButton(new ImageIcon("slike/ToolBarIcons/ToolBarEditIcons/delete.png"));
		delete.setToolTipText("Delete");
		add(delete);
		addSeparator();
		
		find = new JButton(new ImageIcon("slike/ToolBarIcons/ToolBarEditIcons/find.png"));
		find.setToolTipText("Find");
		add(find);
		
	}

}
