package view;

import model.WorkspaceModel;
import java.lang.annotation.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.UIManager;

public class PrimaryView extends javax.swing.JFrame implements View
{
	private static final long serialVersionUID = 1L;

	JStatusBar status = null;

	public static final String NIMBUS = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	public WorkspaceModel dataModel;
	public MenuBar menuBar = null;

	/**
	 * @param model
	 */
	public PrimaryView(WorkspaceModel model)
	{

		this.dataModel = model;
		try
		{

			UIManager.setLookAndFeel(PrimaryView.NIMBUS);

		} catch (Exception e)
		{
		}

		setLayout(new BorderLayout());
		setVisible(true);
		setTitle("GeRuDok");

		Dimension dim = new Dimension(1000, 700);
		setSize(dim);
		setMinimumSize(dim);
		Image icona = Toolkit.getDefaultToolkit().getImage("icons/appIcon.png");
		setIconImage(icona);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screnSize = tk.getScreenSize();
		setLocation(screnSize.width / 2 - dim.width / 2, screnSize.height / 2 - dim.height / 2);

		menuBar = new MenuBar();
		setJMenuBar(menuBar);
		status = new JStatusBar();
		add(status, BorderLayout.SOUTH);

		add(new TreePanel(model), BorderLayout.WEST);

		add(new ToolBox(), BorderLayout.EAST);

		setVisible(true);
	}

	@Override
	public void update()
	{

	}

}