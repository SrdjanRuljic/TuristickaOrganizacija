package view;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

/**
 * Klasa dinamicki kreira i prikazuje ToolBox u zavisnosti od selektovanog
 * elementa
 * 
 * 
 * @author Milos Nikolic
 */
public class ToolBox extends JToolBar
{
	private static final long serialVersionUID = 1L;

	/** Funkcija kreira ToolBox u slucaju selekcije tekstualnog elementa */
	private void createTextToolBox()
	{
		JButton boldText = new JButton(new ImageIcon("icons/tBoldIcon.png"));
		boldText.setPreferredSize(dimButton);
		boldText.setToolTipText("Bold");
		boldText.setActionCommand("btn");
		add(boldText);

		JButton italicText = new JButton(new ImageIcon("icons/tItalicIcon.png"));
		italicText.setPreferredSize(dimButton);
		italicText.setToolTipText("Italic");
		italicText.setActionCommand("btn");
		add(italicText);

		JButton colorText = new JButton(new ImageIcon("icons/tColorIcon.png"));
		colorText.setPreferredSize(dimButton);
		colorText.setToolTipText("Color Text");
		colorText.setActionCommand("btn");
		add(colorText);

		JButton alginText = new JButton(new ImageIcon("icons/tAlginIcon.png"));
		alginText.setPreferredSize(dimButton);
		alginText.setToolTipText("Algin Text");
		alginText.setActionCommand("btn");
		add(alginText);

		JButton findText = new JButton(new ImageIcon("icons/tFindReplaceIcon.png"));
		findText.setPreferredSize(dimButton);
		findText.setToolTipText("Find/Replaca");
		findText.setActionCommand("btn");
		add(findText);

		JButton sizeText = new JButton(new ImageIcon("icons/tSizeIcon.png"));
		sizeText.setPreferredSize(dimButton);
		sizeText.setToolTipText("Size Text");
		sizeText.setActionCommand("btn");
		add(sizeText);

		JButton fontText = new JButton(new ImageIcon("icons/tFontIcon.png"));
		fontText.setPreferredSize(dimButton);
		fontText.setToolTipText("Font");
		fontText.setActionCommand("btn");
		add(fontText);

	}

	/** Funkcija kreira ToolBox u slucaju selekcije grafickog elementa */
	private void createGraphicsToolBox()
	{
		JButton rotationAnimation = new JButton(new ImageIcon("icons/3DrotationIcon.png"));
		rotationAnimation.setPreferredSize(dimButton);
		rotationAnimation.setToolTipText("Rotation");
		rotationAnimation.setActionCommand("btn");
		add(rotationAnimation);

		JButton shadowAnimation = new JButton(new ImageIcon("icons/shadowIcon.png"));
		shadowAnimation.setPreferredSize(dimButton);
		shadowAnimation.setToolTipText("Shadow");
		shadowAnimation.setActionCommand("btn");
		add(shadowAnimation);

		JButton effectAnimation = new JButton(new ImageIcon("icons/effectIcon.png"));
		effectAnimation.setPreferredSize(dimButton);
		effectAnimation.setToolTipText("Effect");
		effectAnimation.setActionCommand("btn");
		add(effectAnimation);

		JButton transitionAnimation = new JButton(new ImageIcon("icons/transitionIcon.png"));
		transitionAnimation.setPreferredSize(dimButton);
		transitionAnimation.setToolTipText("Transition Effect");
		transitionAnimation.setActionCommand("btn");
		add(transitionAnimation);

		JButton addAudioAnimation = new JButton(new ImageIcon("icons/audioIcon.png"));
		addAudioAnimation.setPreferredSize(dimButton);
		addAudioAnimation.setToolTipText("Add Audio");
		addAudioAnimation.setActionCommand("btn");
		add(addAudioAnimation);

	}

	Dimension dimButton = new Dimension(35, 35);

	public ToolBox()
	{
		setOrientation(VERTICAL);

		// Testiranje funkcionalnosti
		JLabel test = new JLabel("text");
		if (test.getText() == "text")
		{
			createTextToolBox();
		}
		if (test.getText() == "graphics")
		{
			createGraphicsToolBox();
		}

		setVisible(true);
	}

}