package view.menuBarView;

import javax.swing.JMenuBar;

public class MenuBarView extends JMenuBar
{
  
	private static final long serialVersionUID = 1L;
	
	MenuFile menuFile;
	MenuEdit menuEdit;
	MenuView menuView;
	MenuOptions menuOptions;
	MenuHelp menuHelp;
	
	public MenuFile getMenuFile() {
		return menuFile;
	}
	

	public void setMenuFile(MenuFile menuFile) {
		this.menuFile = menuFile;
	}

	public MenuEdit getMenuEdit() {
		return menuEdit;
	}

	public void setMenuEdit(MenuEdit menuEdit) {
		this.menuEdit = menuEdit;
	}

	public MenuView getMenuView() {
		return menuView;
	}

	public void setMenuView(MenuView menuView) {
		this.menuView = menuView;
	}

	public MenuOptions getMenuOptions() {
		return menuOptions;
	}

	public void setMenuOptions(MenuOptions menuOptions) {
		this.menuOptions = menuOptions;
	}

	public MenuHelp getMenuHelp() {
		return menuHelp;
	}

	public void setMenuHelp(MenuHelp menuHelp) {
		this.menuHelp = menuHelp;
	}



	public MenuBarView()
	{
		super();
		menuFile = new MenuFile();
		add(menuFile);
		menuEdit = new MenuEdit();
		add(menuEdit);
		menuView = new MenuView();
		add(menuView);
		menuOptions = new MenuOptions();
		add(menuOptions);
		menuHelp = new MenuHelp();
		add(menuHelp);
		setVisible(true);
	}
	
	public void update() {
      // TODO: implement
   }
   
   
}