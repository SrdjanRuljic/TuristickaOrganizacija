package viewer.editElementToolBar;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class ElementToolbarContainer extends JPanel {

	private static final long serialVersionUID = 1L;
	
	TextToolbar textToolbar;
	
	public ElementToolbarContainer()
	{
		super(new BorderLayout());
		textToolbar = new TextToolbar();
		add(textToolbar);
		setVisible(true);
	}

	public TextToolbar getTextToolbar() {
		return textToolbar;
	}

	public void setTextToolbar(TextToolbar textToolbar) {
		this.textToolbar = textToolbar;
	}

}
