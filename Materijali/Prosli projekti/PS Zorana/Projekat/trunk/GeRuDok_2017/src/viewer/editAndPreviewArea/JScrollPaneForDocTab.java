package viewer.editAndPreviewArea;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

import model.Dokument;

public class JScrollPaneForDocTab extends JScrollPane {

	private static final long serialVersionUID = 1L;
	
	private PagesArea pagesArea;
	private Dokument dokument;
	private Boolean aktivan = false;
	
	public JScrollPaneForDocTab(Dokument dokument)
	{
		super();
		
		this.dokument = dokument;
		
		pagesArea = new PagesArea(dokument);
		add(pagesArea);
		setViewportView(pagesArea);
	
		this.setLayout(new ScrollPaneLayout());
		
	}

	public PagesArea getPagesArea() {
		return pagesArea;
	}

	public void setPagesArea(PagesArea pagesArea) {
		this.pagesArea = pagesArea;
	}

	public Dokument getDokument() {
		return dokument;
	}

	public void setDokument(Dokument dokument) {
		this.dokument = dokument;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}
