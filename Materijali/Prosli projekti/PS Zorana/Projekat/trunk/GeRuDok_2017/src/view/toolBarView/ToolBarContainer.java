package view.toolBarView;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ToolBarContainer extends JPanel {

	ToolBarFile toolBarFile;
	ToolBarEdit toolBarEdit;
	
	private static final long serialVersionUID = 1L;
	
	public ToolBarContainer()
	{
		super(new BorderLayout());
		dodajKomponente();
		setVisible(true);
		
	}
	
	public void dodajKomponente()
	{
		ArrayList<JToolBar> lista = new ArrayList<JToolBar>() ;
		
		toolBarFile = new ToolBarFile();
		lista.add(toolBarFile);
		add(toolBarFile);
		
	/*	toolBarEdit = new ToolBarEdit();
		lista.add(toolBarEdit);
		add(toolBarEdit);*/
		
		createLayout(lista);
	}
	
	public void createLayout(ArrayList<JToolBar> lista)
	{
		//poravnavanje
		FlowLayout toolBarLayout = new FlowLayout();
		toolBarLayout.setAlignment((int) Component.LEFT_ALIGNMENT);

		this.setLayout(toolBarLayout);
		for(int i=0; i<lista.size(); i++)
		{	
			this.add(lista.get(i));
		}

	}
	

	public ToolBarFile getToolBarFile() {
		return toolBarFile;
	}

	public void setToolBarFile(ToolBarFile toolBarFile) {
		this.toolBarFile = toolBarFile;
	}

	public ToolBarEdit getToolBarEdit() {
		return toolBarEdit;
	}

	public void setToolBarEdit(ToolBarEdit toolBarEdit) {
		this.toolBarEdit = toolBarEdit;
	}

}
