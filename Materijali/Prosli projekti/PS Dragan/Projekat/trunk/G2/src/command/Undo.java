/***********************************************************************
 * Module:  Undo.java
 * Author:  draga_000
 * Purpose: Defines the Class Undo
 ***********************************************************************/

package command;

import java.util.*;

import applicationModel.URModel;

/** @pdOid aeb1a5cd-1a79-4f5d-bda4-c90d07dec5d8 */
public class Undo implements Command {
	URModel model = null;
	
	public Undo(URModel model) {
		// TODO Auto-generated constructor stub
		this.model = model;
	}
   /** @pdOid 7fe71bbc-3830-46ea-a3ea-d57069969325 */
   public void execute(Boolean b) {
      // TODO: implement
	   this.model.undo();
   }
   
   /** @pdOid 4b953ead-5d1f-4751-834c-6d784533aa95 */
   public void unexecute() {
      // TODO: implement
   }

}