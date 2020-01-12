package controller;

import view.PrimaryView;
import model.WorkspaceModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import model.ProjectModel;

/**
 * Klasa koja predstavlja kontroler za Menubar
 * 
 * 
 * @author Milos Nikolic
 */
public class MenuBarControler
{
	private PrimaryView primaryView;
	private WorkspaceModel dataModel;

	/**
	 * @param view
	 * @param dataModel
	 */
	public MenuBarControler(PrimaryView view, WorkspaceModel dataModel)
	{
		this.primaryView = view;
		this.dataModel = dataModel;

		primaryView.menuBar.setListeners(al);

	}

	ActionListener al = new ActionListener()
	{

		public void actionPerformed(ActionEvent e)
		{
			String actionCommand = e.getActionCommand();

			switch (actionCommand)
				{
					case "NewProject":
						ProjectModel newproj = new ProjectModel(null);
						newproj.setName("Milos");
						dataModel.addProject(newproj);
						// Samo provjeravam da li dodaje projekat, ovo sve treba
						// izdvojiti u posebnu funkciju
						List<ProjectModel> temp = dataModel.getProjects();
						System.out.println(temp.size());

						break;
				}

		}
	};

}