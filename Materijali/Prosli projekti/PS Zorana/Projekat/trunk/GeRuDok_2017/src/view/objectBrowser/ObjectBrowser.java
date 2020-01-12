package view.objectBrowser;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class ObjectBrowser extends JPanel {

	private JScrollPane jScrollPane;
	private Stablo stablo;
	private static final long serialVersionUID = 1L;
	
	public ObjectBrowser() {
		super();
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 5, 5, 5));
		stablo= new Stablo();
		add(stablo);
		jScrollPane = new JScrollPane(stablo);
		setBackground(Color.WHITE);
		add(jScrollPane, BorderLayout.CENTER);
		
	}

	public Stablo getStablo() {
		return stablo;
	}

	public void setStablo(Stablo stablo) {
		this.stablo = stablo;
	}
	

}
