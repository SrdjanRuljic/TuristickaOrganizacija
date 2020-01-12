
package model;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Klasa predstavlja glavni model podataka
 * 
 * 
 * @author Milos Nikolic
 */
public class WorkspaceModel
{

	String name;

	public List<ProjectModel> projectModel;

	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Glavni konstruktor Workspace modela
	 * 
	 * 
	 * @param projects
	 *            Lista projekata
	 * @author Milos Nikolic
	 */
	public WorkspaceModel(List<ProjectModel> projects)
	{
		this.projectModel = projects;
	}

	/**
	 * Metoda dodaje novi projekat u listu projekata
	 * 
	 * 
	 * @param project
	 *            Projekat koji se dodaje
	 * @author Milos Nikolic
	 */
	public void addProject(ProjectModel project)
	{
		projectModel.add(project);
	}

	/**
	 * Dohvataju se svi projekti iz glavnog modela
	 * 
	 * 
	 * @return lista projekata
	 * @author Milos Nikolic
	 */
	public List<ProjectModel> getProjects()
	{
		return projectModel;
	}

	/**
	 * Projekti se postavljaju u glavni model.
	 * 
	 * 
	 * @param projects
	 */
	public void setProjects(List<ProjectModel> projects)
	{
		this.projectModel = projects;
	}

	/**
	 * Funkcija napravi stablo na osnovu modela podata
	 * 
	 * 
	 * @param model
	 *            Model na ovnovu kojeg pravi
	 * @param root
	 *            Korijenski cvor
	 * @return Korijenski cvor sa dodatom hijerarhijom
	 * @author Milos Nikolic
	 */
	public DefaultMutableTreeNode getTree(WorkspaceModel model, DefaultMutableTreeNode root)
	{
		if (model.projectModel.size() > 0)
		{
			for (int i = 0; i < model.projectModel.size(); i++)
			{
				DefaultMutableTreeNode child = new DefaultMutableTreeNode(model.projectModel.get(i).getName());
				for (int j = 0; j < model.projectModel.get(i).document.size(); j++)
				{
					child.add(new DefaultMutableTreeNode(model.projectModel.get(i).document.get(j).name));
				}
				root.add(child);
			}
		}
		return root;
	}

	/** @pdGenerated default getter */
	public java.util.List<ProjectModel> getProjectModel()
	{
		if (projectModel == null)
			projectModel = new java.util.Vector<ProjectModel>();
		return projectModel;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorProjectModel()
	{
		if (projectModel == null)
			projectModel = new java.util.Vector<ProjectModel>();
		return projectModel.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newProjectModel
	 */
	public void setProjectModel(java.util.List<ProjectModel> newProjectModel)
	{
		removeAllProjectModel();
		for (java.util.Iterator iter = newProjectModel.iterator(); iter.hasNext();)
			addProjectModel((ProjectModel) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newProjectModel
	 */
	public void addProjectModel(ProjectModel newProjectModel)
	{
		if (newProjectModel == null)
			return;
		if (this.projectModel == null)
			this.projectModel = new java.util.Vector<ProjectModel>();
		if (!this.projectModel.contains(newProjectModel))
			this.projectModel.add(newProjectModel);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldProjectModel
	 */
	public void removeProjectModel(ProjectModel oldProjectModel)
	{
		if (oldProjectModel == null)
			return;
		if (this.projectModel != null)
			if (this.projectModel.contains(oldProjectModel))
				this.projectModel.remove(oldProjectModel);
	}

	/** @pdGenerated default removeAll */
	public void removeAllProjectModel()
	{
		if (projectModel != null)
			projectModel.clear();
	}

}