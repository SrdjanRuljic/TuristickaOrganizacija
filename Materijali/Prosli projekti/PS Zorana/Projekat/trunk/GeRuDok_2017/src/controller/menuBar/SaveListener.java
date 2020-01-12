package controller.menuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import XML.DomParserForDocuments;
import model.Dokument;
import model.Projekat;
import model.Workspace;

public class SaveListener implements ActionListener {

	DomParserForDocuments domParserForDocuments;
	File file;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		for (Projekat projekat: Workspace.getProjekti())
		{
			file = new File(Workspace.getFajl() + "/"+ projekat.getIme());
			if(!file.exists())
			 {
				file.mkdir();
			 }
			for (Dokument dokument : projekat.getDokumenti())
			{
				domParserForDocuments = new DomParserForDocuments(projekat);
				try {
					domParserForDocuments.sacuvajDokument(dokument, file.toPath());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
