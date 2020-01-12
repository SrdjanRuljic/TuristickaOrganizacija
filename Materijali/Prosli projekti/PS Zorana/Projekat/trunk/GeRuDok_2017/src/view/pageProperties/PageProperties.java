package view.pageProperties;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;

import controller.pageProperties.CheckShowPageNumberListener;
import controller.pageProperties.ColorChoserListener;
import controller.pageProperties.btnOKListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PageProperties extends JFrame {

	private static final long serialVersionUID = 1L;
	
	Font font = new Font("times new roman", Font.PLAIN, 16);
	public static Color background;
	public static JTextField textHeight;
	public static JTextField textWidth;
	JCheckBox checkShowNumber;
	public static JComboBox<String> positionPageNumber;
	
	public PageProperties()
	{
		super();
		setBounds(400, 200, 350, 580); 
		setBackground(new Color(198, 226, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("slike/PopUpMenuPagesArea/properties.png"));
		setTitle("Page Properties");
		dodajStavke();
		setVisible(true);
	}

	private void dodajStavke()
	{
		setLayout(null);
		
		Button btnOK = new Button("OK");
		btnOK.addActionListener(new btnOKListener());
		btnOK.setBounds(150, 470, 150, 30);
		btnOK.setBackground(new Color(135, 206, 250));
		add(btnOK);
		
		dodajPanelZaDimenzije();
		dodajPanelZaIzborBoje();
		dodajPanelZaPozicijuBrojaStranice();
		
	}
	
	public void dodajPanelZaDimenzije()
	{
		//podesavanje parametara panela
		JPanel jPanelDimension = new JPanel();
		jPanelDimension.setLayout(null);
		jPanelDimension.setBackground(new Color(198, 226, 255));
		jPanelDimension.setBounds(5, 5, 300, 180);
		jPanelDimension.setBorder(BorderFactory.createTitledBorder(null, "Dimension", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.PLAIN,20), new Color(0, 191, 255)));
		
		
		//labela i polje za sirinu
		Label labelWidth = new Label("Width");
		labelWidth.setFont(font);
		labelWidth.setBounds(5, 30, 100, 30);
		jPanelDimension.add(labelWidth);
		
		textWidth = new JTextField();
		textWidth.setBackground(new Color(135, 206, 250));
		textWidth.setFont(font);
		textWidth.setBounds(120, 30, 150, 30);
		jPanelDimension.add(textWidth);
		
		//labela i polje za visinu
		Label labelHeight = new Label("Height");
		labelHeight.setFont(font);
		labelHeight.setBounds(5, 80, 100, 30);
		jPanelDimension.add(labelHeight);
		
		textHeight = new JTextField();
		textHeight.setBackground(new Color(135, 206, 250));
		textHeight.setFont(font);
		textHeight.setBounds(120, 80, 150, 30);
		jPanelDimension.add(textHeight);
		
		add(jPanelDimension);
	}
	
	public void dodajPanelZaIzborBoje()
	{
		JPanel jPanelColor = new JPanel();
		jPanelColor.setLayout(null);
		jPanelColor.setBackground(new Color(198, 226, 255));
		jPanelColor.setBounds(5, 210, 300, 80);
		jPanelColor.setBorder(BorderFactory.createTitledBorder(null, "Color", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.PLAIN,20), new Color(0, 191, 255)));
		
		Label labelColor = new Label("Color");
		labelColor.setFont(font);
		labelColor.setBounds(5, 30, 100, 30);
		jPanelColor.add(labelColor);
		
		Button btnColor = new Button("Choose color");
		btnColor.setBackground(new Color(135, 206, 250));
		btnColor.setFont(font);
		btnColor.setBounds(120, 30, 150, 30);
		btnColor.addActionListener(new ColorChoserListener());
		jPanelColor.add(btnColor);
		
		add(jPanelColor);
	}
	

	public void dodajPanelZaPozicijuBrojaStranice()
	{
		JPanel jPanelPageNumber = new JPanel();
		jPanelPageNumber.setLayout(null);
		jPanelPageNumber.setBackground(new Color(198, 226, 255));
		jPanelPageNumber.setBounds(5, 320, 300, 120);
		jPanelPageNumber.setBorder(BorderFactory.createTitledBorder(null, "Page Number", TitledBorder.LEFT, TitledBorder.TOP, new Font("times new roman",Font.PLAIN,20), new Color(0, 191, 255)));
		
		checkShowNumber = new JCheckBox("Show Page Number", true);
		checkShowNumber.setBackground(new Color(135, 206, 250));
		checkShowNumber.setFont(font);
		checkShowNumber.setBounds(5, 30, 100, 30);
		checkShowNumber.addItemListener(new CheckShowPageNumberListener());
		jPanelPageNumber.add(checkShowNumber);

		Label labelPosition = new Label("Position");
		labelPosition.setFont(font);
		labelPosition.setBounds(5, 80, 100, 30);
		jPanelPageNumber.add(labelPosition);
		
		positionPageNumber = new JComboBox<String>();
		positionPageNumber.setBackground(new Color(135, 206, 250));
		positionPageNumber.addItem("Left");
		positionPageNumber.addItem("Center");
		positionPageNumber.addItem("Right");
		positionPageNumber.setBounds(120, 80, 150, 30);
		positionPageNumber.setFont(font);
		jPanelPageNumber.add(positionPageNumber);
		
		add(jPanelPageNumber);
	}
}
