/***********************************************************************
 * Module:  Redo.java
 * Author:  draga_000
 * Purpose: Defines the Class Redo
 ***********************************************************************/

package command;

import java.util.*;

import applicationModel.URModel;

/** @pdOid 2f6c4eff-43f7-4463-979e-8b783f44e108 */
public class Redo implements Command {
	URModel model = null;
	
	public Redo(URModel model) {
		// TODO Auto-generated constructor stub
		this.model = model;
	}
   /** @pdOid 45f15e9e-3f21-4931-9790-e1ad1d316e97 */
   public void execute(Boolean b) {
      // TODO: implement
	   this.model.redo();
   }
   
   /** @pdOid 8b11f058-1831-43f7-a2df-9d3f9f10ccc8 */
   public void unexecute() {
      // TODO: implement
   }

}