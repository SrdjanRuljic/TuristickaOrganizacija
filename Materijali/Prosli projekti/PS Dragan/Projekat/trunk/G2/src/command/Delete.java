/***********************************************************************
 * Module:  Delete.java
 * Author:  draga_000
 * Purpose: Defines the Class Delete
 ***********************************************************************/

package command;

import java.util.*;

import applicationModel.FloatingToolbarModel;
import applicationModel.MenuBarModel;

/** @pdOid 8fa7f981-9c5b-45fc-898f-331d51411870 */
public class Delete implements Command {
	FloatingToolbarModel ftmodel = null;
	MenuBarModel mbmodel = null;
	int model=0;
	
	public Delete(FloatingToolbarModel ftmodel) {
		// TODO Auto-generated constructor stub
		this.ftmodel = ftmodel;
		model=1;
	}
	public Delete(MenuBarModel mbmodel)
	{
		this.mbmodel = mbmodel;
		model=2;
	}
   /** @pdOid 002a3bff-e698-4218-91ce-95f81937552e */
   public void execute(Boolean b) {
      // TODO: implement
	   if(model==1)
	   {
		   if(b==true)
			   ftmodel.SlotsRedo();
		   else
			   ftmodel.deleteSlots();
	   }
	   else if(model==2)
	   {
		   if(b==true)
			   mbmodel.SlotsRedo();
		   else
			   mbmodel.Delete();
	   }
   }
   
   /** @pdOid c2dfcc63-7672-44da-97b3-0f3b549632b3 */
   public void unexecute() {
      // TODO: implement
	   if(model==1)
		   ftmodel.SlotsUndo();   
	   else if(model==2)
		   mbmodel.SlotsUndo();
   }

}