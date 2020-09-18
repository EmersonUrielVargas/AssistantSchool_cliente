package views;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controller.Commands;
import utils.Constants;

public class JPTopics extends JPanel{
	private JTFBaseTextField[] listTopics;
	private JBBaseButton jbSaveChanges;
	
	public JPTopics(ActionListener actionlistener, String[] topics) {
		super();
		setSize(1000, 100);
		setLayout(null);
		init(actionlistener, topics);
	}

	private void init(ActionListener actionlistener, String[] topics) {
		int positionX = 100;
		for (int i = 0; i < listTopics.length; i++) {
			listTopics[i] = new JTFBaseTextField(Constants.BASE_BLUE, Constants.TWENTY_BASE_FONT, 6);
			listTopics[i].setBounds(positionX, 10, 80, 60);
			listTopics[i].setText(topics[i]);
			this.add(listTopics[i]);
			positionX += 100;
		}
		this.jbSaveChanges = new JBBaseButton(Constants.SAVE_CHANGES_ICON, Constants.SAVE_CHANGES_ICON_PRESS, actionlistener, Commands.AC_SAVE_CHANGES_BUTTON);
		this.jbSaveChanges.setBounds(positionX, 10, 100, 60);
		this.add(jbSaveChanges);
	}
	
	public void setEditableTopics(boolean isEditable) {
		for (int i = 0; i < listTopics.length; i++) {
			listTopics[i].setEditable(isEditable);
		}
	}

	
	

}
