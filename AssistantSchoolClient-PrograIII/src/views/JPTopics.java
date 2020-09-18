package views;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controller.Commands;
import utils.Constants;

public class JPTopics extends JPanel{
	private JLBaseLabel[] listTopics;
	private JBBaseButton jbSaveChanges;
	
	public JPTopics(ActionListener actionlistener, String[] topics) {
		super();
		setSize(1000, 80);
		setLayout(null);
		init(actionlistener, topics);
	}

	private void init(ActionListener actionlistener, String[] topics) {
		int positionX = 180;
		listTopics = new JLBaseLabel[7];
		for (int i = 0; i < listTopics.length; i++) {
			listTopics[i] = new JLBaseLabel( Constants.TWENTY_BASE_FONT,Constants.BASE_BLUE);
			listTopics[i].setBounds(positionX, 5, 90, 50);
			listTopics[i].setText(topics[i]);
			listTopics[i].setBorder(null);
			this.add(listTopics[i]);
			positionX += 100;
		}
		this.jbSaveChanges = new JBBaseButton(Constants.SAVE_CHANGES_ICON, Constants.SAVE_CHANGES_ICON_PRESS, actionlistener, Commands.AC_SAVE_CHANGES_BUTTON);
		this.jbSaveChanges.setBounds(positionX, 0, 100, 70);
		this.add(jbSaveChanges);
	}

	
	

}
