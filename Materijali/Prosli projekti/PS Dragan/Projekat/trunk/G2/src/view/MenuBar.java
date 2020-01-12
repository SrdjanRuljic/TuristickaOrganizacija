/***********************************************************************
 * Module:  MenuBar.java
 * Author:  Natasa
 * Purpose: Defines the Class MenuBar
 ***********************************************************************/

package view;

import java.util.*;

import javax.swing.JMenuBar;

import applicationModel.MenuBarModel;
import localization.Localization;

/** @pdOid ff562764-19a0-459e-8c3d-8d37f7f6dcb4 */
public class MenuBar extends JMenuBar{
	public static MenuBarModel model;
   /** @pdRoleInfo migr=no name=FileMenu assc=association8 mult=1..1 type=Composition */
   public static FileMenu fileMenu = new FileMenu();
   /** @pdRoleInfo migr=no name=EditMenu assc=association9 mult=1..1 type=Composition */
   public static EditMenu editMenu = new EditMenu();
   /** @pdRoleInfo migr=no name=ViewMenu assc=association10 mult=1..1 type=Composition */
   public static ViewMenu viewMenu = new ViewMenu();
   
   public static InsertMenu insertMenu = new InsertMenu();
   
   public static FormatMenu formatMenu = new FormatMenu();
   /** @pdRoleInfo migr=no name=OptionsMenu assc=association11 mult=1..1 type=Composition */
   public static OptionsMenu optionsMenu = new OptionsMenu();
   /** @pdRoleInfo migr=no name=HelpMenu assc=association12 mult=1..1 type=Composition */
   public static HelpMenu helpMenu = new HelpMenu();
   
	public MenuBar(MenuBarModel model)
	{
		this.model=model;
		add(fileMenu.mnuFile);		
		add(editMenu.mnuEdit);
		add(viewMenu.mnuView);
		add(insertMenu.mnuInsert);
		add(formatMenu.mnuFormat);
		add(optionsMenu.mnuOptions);
		add(helpMenu.mnuHelp);
	}
	
}