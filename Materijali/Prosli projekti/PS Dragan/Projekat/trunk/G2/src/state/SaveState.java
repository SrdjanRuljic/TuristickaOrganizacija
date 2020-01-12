package state;

import view.MainFrame;
import view.MenuBar;

import java.util.*;

import localization.Localization;
import main.MainClass;

public class SaveState implements StateInterface {
	public static Localization local = Localization.getInstance();
	
	public void idle(MainFrame context) {
      // TODO: implement
   }
   
   public void edit(MainFrame context) {
	   if(MainClass.mf.mainPanel.canvas.kanvas.getTabCount()==0)
		   context.setState(new IdleState());
	   else
	   {
		   context.setState(new EditState());
		   MenuBar.fileMenu.setEditState();
		   MenuBar.editMenu.setEditState();
		   MenuBar.viewMenu.setEditState();
		   MenuBar.formatMenu.setEditState();
		   MenuBar.insertMenu.setEditState();
		   MainClass.mf.mainPanel.toolbar.setEditState();
		   MainClass.mf.mainPanel.floatingToolbar.setEditState();
	   }

   }
   
   public void save(MainFrame context) {
      // TODO: implement
   }
   
   public void update(MainFrame context) {
      // TODO: implement
   }
   
   public void selection(MainFrame context) {
      // TODO: implement
   }
   
   public void closing(MainFrame context) {
      // TODO: implement
	   context.setState(new ClosingState());
   }
   
   public String getStateName() {
      // TODO: implement
	   return local.getString("state.save");
   }

}