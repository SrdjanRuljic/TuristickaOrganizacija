package view.chooseWorkspace;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import XML.DomParserForDocuments;
import XML.DomParserForRecentWorkspace;
import controller.chooseWorkspace.btnBrowseWSListener;
import controller.chooseWorkspace.btnCancelListener;
import controller.chooseWorkspace.btnOKListener;

public class WindowForChooseWorkspace extends JFrame {

	private static final long serialVersionUID = 1L;
	JDesktopPane jDesktopPane;
	JPanel upJPanel;
	JPanel downJPanel;
	static JComboBox<String> jComboBox;
	DomParserForRecentWorkspace domParserForRecentWorkspace;
	
	public WindowForChooseWorkspace()
	{
		setSize(500, 300);
		setResizable(false);
		setTitle("Choose Workspace");
		setIconImage(Toolkit.getDefaultToolkit().getImage("slike/choose_workspace.png"));
		
		jDesktopPane  = new JDesktopPane();
		add(jDesktopPane);
		dodajStavke();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		centrirajProzor();
		setVisible(true);
	}

	public void centrirajProzor()
	{
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x,y);
		
	}
	
	public void dodajStavke()
	{
		dodajGornjiPanel();
		dodajDonjiPanel();
		
		
	}
	
	public void dodajGornjiPanel()
	{
		upJPanel = new JPanel();
		upJPanel.setBounds(0, 0, 495, 60);
		upJPanel.setBackground(Color.LIGHT_GRAY);
		upJPanel.setBorder( new SoftBevelBorder(BevelBorder.RAISED, Color.RED, Color.RED, Color.PINK, Color.PINK));
		
		dodajOpis();
	
		getjDesktopPane().add(upJPanel);
	}
	
	public void dodajOpis()
	{

		JTextPane jTextPane = new JTextPane();
		jTextPane.setBackground(Color.LIGHT_GRAY);
		jTextPane.setEditable(false);
		jTextPane.setText("GeRuDok stores your projects in a folder called workspace. \n Choose workspace folder to use for this session.");
		upJPanel.add(jTextPane, BorderLayout.PAGE_START);
		
	}

	public void dodajDonjiPanel()
	{

		downJPanel = new JPanel();
		downJPanel.setBackground(Color.LIGHT_GRAY);
		downJPanel.setBounds(0, 60, 495, 250);
		downJPanel.setLayout(null);
		
		dodajLabelu();
		
		dodajComboBox();
		
		dodajDugmice();
		
		getjDesktopPane().add(downJPanel);
		
	}
	
	public void dodajLabelu()
	{
		Label label = new Label("Workspace");
		label.setBounds(10, 20, 80, 30);
		downJPanel.add(label);
	}
	
	public void dodajComboBox()
	{

		jComboBox = new JComboBox<String>();
		jComboBox.setEditable(true);
		jComboBox.setBounds(100, 20, 260, 30);
		domParserForRecentWorkspace = new DomParserForRecentWorkspace();
		domParserForRecentWorkspace.citanje();
		downJPanel.add(jComboBox);
	}
	
	public void dodajDugmice()
	{

		Button btnBrowseWorkspace = new Button("Browse");
		Button btnOK = new Button("OK");
		Button btnCancel = new Button("Cancel");
		
		btnBrowseWorkspace.addActionListener(new btnBrowseWSListener());
		btnOK.addActionListener(new btnOKListener());
		btnCancel.addActionListener(new btnCancelListener());
		
		btnBrowseWorkspace.setBounds(370, 20, 100, 30);
		btnOK.setBounds(300, 150, 80, 30);
		btnCancel.setBounds(390, 150, 80, 30);
		
		downJPanel.add(btnBrowseWorkspace);
		downJPanel.add(btnOK);
		downJPanel.add(btnCancel);
	}
	public JDesktopPane getjDesktopPane() {
		return jDesktopPane;
	}

	public void setjDesktopPane(JDesktopPane jDesktopPane) {
		this.jDesktopPane = jDesktopPane;
	}

	public static JComboBox<String> getjComboBox() {
		return jComboBox;
	}

	public static void setjComboBox(JComboBox<String> jComboBox) {
		WindowForChooseWorkspace.jComboBox = jComboBox;
	}
}
