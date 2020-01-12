package main;

import java.awt.Frame;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

import documentModel.Workspace;
import localization.Localization;
import view.MainFrame;
import xml.ConfigDOM;

public class WorkspaceChooser extends JPanel{

	private static Localization local = Localization.getInstance();
	public static final String WINDOWS = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

	public WorkspaceChooser(){
		
		
		try
		{
			UIManager.setLookAndFeel(WINDOWS);
		}
		catch(Exception e)
		{
		    System.out.println("Failed loading L&F");
		}
		
		Object[] options1 = {local.getString("workspaceOptions.New") , local.getString("workspaceOptions.Default"), local.getString("workspaceOptions.Existing")};
		add(new JLabel(local.getString("workspaceOptions.select")));
		JTextField textField = new JTextField(30);
		textField.setText("C:\\GeRuDok");
		add(textField);
		int result = JOptionPane.showOptionDialog(null, this, local.getString("workspaceOptions.title"),
		JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);
		
		if (result == JOptionPane.YES_OPTION)
		{
			JFileChooser fileCh = new JFileChooser();
			fileCh.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int option = fileCh.showOpenDialog(null);
			if(option == JFileChooser.APPROVE_OPTION)
			{		
				File file = fileCh.getSelectedFile();
				Workspace.getInstance(file.getPath(), "Workspace");
				ConfigDOM write=new ConfigDOM();
				write.WriteConfig("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			}
			else
				new WorkspaceChooser();
		}
		
		else if(result == JOptionPane.NO_OPTION)
		{
			Workspace.getDefaultInstance();
			ConfigDOM config=new ConfigDOM();
			
			String lookAndFeel = config.ReadConfig();
			if(lookAndFeel!="")
			{
				try
				{
					UIManager.setLookAndFeel(lookAndFeel);
				}
				catch(Exception e)
				{
				    System.out.println("Failed loading L&F");
				}
			}
			else
			{
					try {
						UIManager.setLookAndFeel(WINDOWS);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
			
		}
		else if(result == JOptionPane.CANCEL_OPTION)
		{
			//ovdje implementirati otvaranje postojeceg workspace-a
			JFileChooser fileCh = new JFileChooser();
			fileCh.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int option = fileCh.showOpenDialog(null);
			if(option == JFileChooser.APPROVE_OPTION)
			{		
				File file = fileCh.getSelectedFile();
				Workspace.setInstance(file.getPath(), file.getName());
				ConfigDOM config=new ConfigDOM();
				String lookAndFeel = config.ReadConfig();
				if(lookAndFeel!="")
				{
					try
					{
						UIManager.setLookAndFeel(lookAndFeel);
					}
					catch(Exception e)
					{
					    System.out.println("Failed loading L&F");
					}
				}
				else
				{
					try {
						UIManager.setLookAndFeel(WINDOWS);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else
				new WorkspaceChooser();
		}
		else 
		{
			System.exit(0);
		}
	}
}
