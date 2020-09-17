package views;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JPanel;

import controller.ControllerClient;

public class JPNote extends JPanel{
	
	private JTFBaseTextField jtNote;
	private JBBaseButton jbshowcommits;
	private JDialogCommitsNote jdcommentN;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		new JDialogCommitsNote(new ControllerClient(), new Point(500, 200));
	}

}
