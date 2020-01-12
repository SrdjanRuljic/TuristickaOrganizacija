/***********************************************************************
 * Module:  Paste.java
 * Author:  draga_000
 * Purpose: Defines the Class Paste
 ***********************************************************************/

package command;

import java.util.*;
import applicationModel.FloatingToolbarModel;
import applicationModel.MenuBarModel;

/** @pdOid 4ea6a9d7-c35e-476c-a6ea-5a32433f0ea8 */
public class Paste implements Command {
	FloatingToolbarModel ftmodel = null;
	MenuBarModel mbmodel = null;
	int model=0;
	public Paste(FloatingToolbarModel ftmodel) {
		// TODO Auto-generated constructor stub
		this.ftmodel = ftmodel;
		model=1;
	}
	public Paste(MenuBarModel mbmodel)
	{
		this.mbmodel = mbmodel;
		model=2;
	}
   /** @pdOid 9e77f391-3b16-450d-8c6e-d9754fe2ffd7 */
   public void execute(Boolean b) {
      // TODO: implement
	   if(model==1)
	   {
		   if(b==true)
			   ftmodel.pasteSlotsRedo();
		   else
			   ftmodel.pasteSlots();
	   }
	   else if(model==2)
	   {
		   if(b==true)
			   mbmodel.pasteSlotsRedo();
		   else
			   mbmodel.Paste();
	   }
   }
   
   /** @pdOid b6cee54a-bae4-424a-b300-3c79de9228cb */
   public void unexecute() {
      // TODO: implement
	   if(model==1)
		   ftmodel.pasteSlotsUndo();
	   else if(model==2)
		   mbmodel.pasteSlotsUndo();
   }

}