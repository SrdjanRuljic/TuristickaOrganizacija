package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

public class ToolbarListener implements ActionListener {

	JTable table;
	
	public ToolbarListener() {}
	
	public ToolbarListener(JTable table) {
		this.table = table;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (this.table != null)
		{
			int index = 0;
			
			switch (e.getActionCommand())
			{
			case "first":
				this.table.setRowSelectionInterval(index, index);
				this.table.scrollRectToVisible(this.table.getCellRect(index, 0, true));
				break;
			case "last":
				index = this.table.getModel().getRowCount()-1;
				this.table.setRowSelectionInterval(index, index);
				this.table.scrollRectToVisible(this.table.getCellRect(index, 0, true));
				break;
			case "previous":
				index = this.table.getSelectedRow();

				if (index > 0)
				{
					this.table.setRowSelectionInterval(index-1, index-1);
					this.table.scrollRectToVisible(this.table.getCellRect(index-1, 0, true));
				}
				
				break;
			case "next":
				index = this.table.getSelectedRow();

				if (index < this.table.getModel().getRowCount()-1)
				{
					this.table.setRowSelectionInterval(index+1, index+1);
					this.table.scrollRectToVisible(this.table.getCellRect(index+1, 0, true));
				}
				
				break;
			case "new": 
				break;
			case "edit":
				break;
			case "delete":
				break;
			case "accept": 
				break;
			case "cancel":
				break;
			case "report":
				break;
			default:
				break;
			}
		}
	}
}
