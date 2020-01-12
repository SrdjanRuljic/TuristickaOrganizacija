/***********************************************************************
 * Module:  Cut.java
 * Author:  draga_000
 * Purpose: Defines the Class Cut
 ***********************************************************************/

package command;

import java.util.*;
import applicationModel.FloatingToolbarModel;
import applicationModel.MenuBarModel;

/** @pdOid 6fb78a39-f7d0-4cae-b36c-6a13b7d360e7 */
public class Cut implements Command {
	FloatingToolbarModel ftmodel = null;
	MenuBarModel mbmodel = null;
	int model=0;
	
	public Cut(FloatingToolbarModel ftmodel) {
		// TODO Auto-generated constructor stub
		this.ftmodel = ftmodel;
		model=1;
	}
	public Cut(MenuBarModel mbmodel)
	{
		this.mbmodel = mbmodel;
		model=2;
	}
   /** @pdOid fdc54e4b-924a-4717-8e33-98e8c440f10e */
   public void execute(Boolean b) {
      // TODO: implement
	   if(model==1)
	   {
		   if(b==true)
			   ftmodel.SlotsRedo();
		   else
			   ftmodel.cutSlots();
	   }
	   else if(model==2)
	   {
		   if(b==true)
			   mbmodel.SlotsRedo();
		   else
			   mbmodel.Cut();
	   }
   }
   
   /** @pdOid 039379df-bd0d-4526-b7b3-596c8364ec6a */
   public void unexecute() {
      // TODO: implement
	   if(model==1)
		   ftmodel.SlotsUndo();
	   else if(model==2)
		   mbmodel.SlotsUndo();
   }

}