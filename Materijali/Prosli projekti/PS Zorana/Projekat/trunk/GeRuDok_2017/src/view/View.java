package view;

import view.chooseWorkspace.WindowForChooseWorkspace;
import view.glavniProzor.MainWindow;

public class View
{
	static MainWindow mainWindow;
	
	public View()
	{
		dodajKomponente();
	}
	
	public void dodajKomponente()
	{
		mainWindow = new MainWindow();
	}

	public static MainWindow getMainWindow() {
		return mainWindow;
	}

	public static void setMainWindow(MainWindow mainWindow) {
		View.mainWindow = mainWindow;
	}

	
   
   
   
}