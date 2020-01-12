package view.glavniProzor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import view.menuBarView.*;
import view.objectBrowser.ObjectBrowser;
import view.toolBarView.ToolBarContainer;
import viewer.editAndPreviewArea.ProjectsArea;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import controller.mainWindow.MainWindowListener;
import view.StatusBarView;


/**
 * Klasa koja predstavlja glavni prozor, u koji se smještaju ostale komponente.
 * Naslijeðuje klasu JFrame.
 * @author ZoranaS
 *
 */
public class MainWindow extends JFrame
{

	private static final long serialVersionUID = 1L;
	
	MenuBarView menuBarView;
	ToolBarContainer toolBarContainer;
	static ProjectsArea projectsArea;
	static ObjectBrowser objectBrowser;
	public static Dimension screenSize;
	JSplitPane jSplitPaneObjectBrowserEditorArea;
	

	/**
	 * Javni konstruktor klase GlavniProzor. Poziva metode {@link podesiParametreProzora()} i {@link dodavanjeKomponenti}.
	 * @author ZoranaS
	 */
	public MainWindow()
	{
		super();
		podesiParamtereProzora();
		dodavanjeKomponenti();
		setVisible(true);
		
	}
	
	/**
	 * Metoda koja vrši podešavanje osnovnog izleda prozora: velièina, naslov, postavljanje ikonice, i izlaza.
	 */
	public void podesiParamtereProzora()
	{
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height-100);
		setTitle("GERUDOK");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new MainWindowListener());
		setIconImage(Toolkit.getDefaultToolkit().getImage("slike/secret-book-icon.png"));
		
	}
	
	/**
	 * Metoda za dodavanje komponenti u glavni prozor.
	 * Dodaje se {@link MenuBarView}, {@link ToolBarContainer}, {@link ObjectBrowser}, {@link StatusBarView}.
	 * @author ZoranaS
	 */

	public void dodavanjeKomponenti()
	{
		
		//dodavanje menu bar-a
		menuBarView = new MenuBarView();
		setJMenuBar(menuBarView);
		
		//dodavanje toolbar-a
		toolBarContainer = new ToolBarContainer();
		toolBarContainer.setSize(screenSize.width,50);
		add(toolBarContainer, BorderLayout.NORTH);
		
		//dodavanje kontejnera za projekte
		projectsArea = new ProjectsArea();
		
		//dodavanje preglednika fajlova
		objectBrowser = new ObjectBrowser();
	
		
		//dodavanje "razdvajaèa" izmeðu preglenika fajlova i kontejnera za projekte 
		jSplitPaneObjectBrowserEditorArea = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, objectBrowser, projectsArea);
		jSplitPaneObjectBrowserEditorArea.setBounds(0, 50, screenSize.width-10, screenSize.height-50);
		add(jSplitPaneObjectBrowserEditorArea);
		
		
		
	}

	public void obnoviStablo()
	{
		
		//objectBrowser.stablo.setTree();
		//Workspace.getInstance().attach(objectBrowser.stablo);
		objectBrowser.revalidate();
		objectBrowser.repaint();
		
	}

	

	public MenuBarView getMenuBarView() {
		return menuBarView;
	}

	public void setMenuBarView(MenuBarView menuBarView) {
		this.menuBarView = menuBarView;
	}

	public ToolBarContainer getToolBarContainer() {
		return toolBarContainer;
	}


	public void setToolBarContainer(ToolBarContainer toolBarContainer) {
		this.toolBarContainer = toolBarContainer;
	}


	public static ProjectsArea getProjectsArea() {
		return projectsArea;
	}

	public void setProjectsArea(ProjectsArea projectsArea) {
		this.projectsArea = projectsArea;
	}

	public static ObjectBrowser getObjectBrowser() {
		return objectBrowser;
	}

	public void setObjectBrowser(ObjectBrowser objectBrowser) {
		this.objectBrowser = objectBrowser;
	}

	//TextArea aaa = new TextArea();
	
	public static Dimension getScreenSize() {
		return screenSize;
	}

	public static void setScreenSize(Dimension screenSize) {
		MainWindow.screenSize = screenSize;
	}

	public JSplitPane getjSplitPaneObjectBrowserEditorArea() {
		return jSplitPaneObjectBrowserEditorArea;
	}

	public void setjSplitPaneObjectBrowserEditorArea(JSplitPane jSplitPaneObjectBrowserEditorArea) {
		this.jSplitPaneObjectBrowserEditorArea = jSplitPaneObjectBrowserEditorArea;
	}
	
}
