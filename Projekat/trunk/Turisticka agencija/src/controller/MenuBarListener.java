package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MenuBarListener implements ActionListener
{
	
	public MenuBarListener()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch (e.getActionCommand())
		{
			case "SwitchXML":
				JOptionPane.showConfirmDialog(null, "SwitchXML: opcija u izradi.");
				break;
			case "Save":
				JOptionPane.showConfirmDialog(null, "Save: opcija u izradi.");
				break;
			case "SaveAs":
				JOptionPane.showConfirmDialog(null, "Save As: opcija u izradi.");
				break;
			case "Exit":
				System.exit(0);
				break;
			case "New":
				JOptionPane.showConfirmDialog(null, "New: opcija u izradi.");
				break;
			case "Edit":
				JOptionPane.showConfirmDialog(null, "Edit: opcija u izradi.");
				break;
			case "Delete":
				JOptionPane.showConfirmDialog(null, "Delete: opcija u izradi.");
				break;
			case "First":
				JOptionPane.showConfirmDialog(null, "First: opcija u izradi.");
				break;
			case "Next":
				JOptionPane.showConfirmDialog(null, "Next: opcija u izradi.");
				break;
			case "Previous":
				JOptionPane.showConfirmDialog(null, "Previous: opcija u izradi.");
				break;
			case "Last":
				JOptionPane.showConfirmDialog(null, "Last: opcija u izradi.");
				break;
			case "Accept":
				JOptionPane.showConfirmDialog(null, "Accept: opcija u izradi.");
				break;
			case "Cancel":
				JOptionPane.showConfirmDialog(null, "Cancel: opcija u izradi.");
				break;
			case "Report":
				JOptionPane.showConfirmDialog(null, "Report: opcija u izradi.");
				break;
			case "Help":
				JOptionPane.showConfirmDialog(null, "Help: opcija u izradi.");
				break;
			case "About":
				JOptionPane.showConfirmDialog(null, "About: opcija u izradi.");
				break;
			default:
				break;
		}
		
	}
	
}
