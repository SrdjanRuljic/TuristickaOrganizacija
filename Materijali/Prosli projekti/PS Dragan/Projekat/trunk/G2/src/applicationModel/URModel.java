/***********************************************************************
 * Module:  URModel.java
 * Author:  draga_000
 * Purpose: Defines the Class URModel
 ***********************************************************************/

package applicationModel;

import java.util.*;

import javax.swing.ImageIcon;

import command.Command;
import main.MainClass;

/** @pdOid 3d5ff7f3-9c7e-4ff6-bae7-55958c0463b0 */
public class URModel {
	Vector<Command>  execute = null;
	Vector<Command>  unexecute = null;
	
	public URModel()
	{
		execute = new Vector<>();
		unexecute = new Vector<>();
	}
	
	//dodaje komande na vektor izvrsenih komandi
	public void addCommand(Command command)
	{
		this.execute.addElement(command);
		MainClass.mf.menuBar.editMenu.mnuItemUndo.setEnabled(true);
		//print();
	}
	
	//uklanja komande sa liste izvrsenih
	public void removeCommand(Command command)
	{
		this.execute.removeElement(command);
		MainClass.mf.menuBar.editMenu.mnuItemRedo.setEnabled(true);
		//print();
	}
	
	public void undo()
	{
		//System.out.println("UNDO");
		int size = this.execute.size();
		
		if(size > 0)
		{
			//vektor ide od nule pa je -1
			//vrati vr. i skine sa vektora komandu
			Command tmpCommand = this.execute.remove(size-1);
			//opet throw
			tmpCommand.unexecute();
			this.unexecute.addElement(tmpCommand);
			if((size-1)==0)
			{
				MainClass.mf.menuBar.editMenu.mnuItemUndo.setEnabled(false);
			}
			MainClass.mf.menuBar.editMenu.mnuItemRedo.setEnabled(true);
		}
		
		//print();
	}
	
	public void redo()
	{
		//System.out.println("REDO");
		int size = this.unexecute.size();
		if(size > 0)
		{
			//ovo je samo suprotno od undo
			Command tmpCommand = this.unexecute.remove(size-1);
			//opet throw
			tmpCommand.execute(true);
			this.execute.addElement(tmpCommand);
			if((size-1)==0)
			{
				MainClass.mf.menuBar.editMenu.mnuItemRedo.setEnabled(false);
			}
			MainClass.mf.menuBar.editMenu.mnuItemUndo.setEnabled(true);
		}
		
		//print();
	}

	/*//metoda koja ispisuje ova dva vektora
	public void print()
	{
		System.out.println("------ EXECUTE -----");
		
		String msg = "";
		
		for(Command c : this.execute)
		{
			msg += c.description() + " | ";
		}
		
		System.out.println(msg);
		
		System.out.println("------ UNEXECUTE -----");
		
		msg = "";
		
		for(Command c : this.unexecute)
		{
			msg += c.description() + " | ";
		}
		
		System.out.println(msg);
	}*/
}