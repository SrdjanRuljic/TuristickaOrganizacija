package main;

import java.util.ArrayList;
import java.util.List;

import controller.PrimaryController;
import model.Document;
import model.ProjectModel;
import model.WorkspaceModel;
import view.PrimaryView;

public class MainClass
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		// -----------------Testni podaci----------------------//

		List<ProjectModel> projects = new ArrayList<>();

		List<Document> documetns1 = new ArrayList<Document>();

		List<Document> documetns2 = new ArrayList<>();
		List<Document> documetns3 = new ArrayList<>();
		List<Document> documetns4 = new ArrayList<>();
		List<Document> documetns5 = new ArrayList<>();

		Document doc1 = new Document("Ime1");
		Document doc2 = new Document("Ime2");
		Document doc3 = new Document("Ime3");

		documetns1.add(doc1);
		documetns1.add(doc2);
		documetns1.add(doc3);

		documetns2.add(doc1);
		documetns2.add(doc2);
		documetns2.add(doc3);

		documetns3.add(doc1);
		documetns3.add(doc2);
		documetns3.add(doc3);

		documetns4.add(doc1);
		documetns4.add(doc2);
		documetns4.add(doc3);

		documetns5.add(doc1);
		documetns5.add(doc2);
		documetns5.add(doc3);

		ProjectModel pm1 = new ProjectModel(documetns1);
		ProjectModel pm2 = new ProjectModel(documetns2);
		ProjectModel pm3 = new ProjectModel(documetns3);
		ProjectModel pm4 = new ProjectModel(documetns4);
		ProjectModel pm5 = new ProjectModel(documetns5);

		projects.add(pm1);
		projects.add(pm2);
		projects.add(pm3);
		projects.add(pm4);
		projects.add(pm5);

		// -----------------Kraj testni podaci----------------------//

		WorkspaceModel work = new WorkspaceModel(projects);
		PrimaryView view = new PrimaryView(work);
		new PrimaryController(view, work);

		// ----------------------------------------------------//
		// --------------Testiranje hijerarjije----------------//

		List<Document> nesto = null;
		List<ProjectModel> temp = work.getProjects();
		System.out.println(temp.size());
		for (int i = 0; i < temp.size(); i++)
		{
			nesto = (ArrayList<Document>) temp.get(i).getDocuments();
			for (int j = 0; j < nesto.size(); j++)
			{
				System.out.println(nesto.get(j).getName());

			}
			System.out.println("-----------------");

		}

	}

}