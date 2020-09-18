package views;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controller.ControllerClient;
import utils.Constants;

public class JPCBoxTeacher extends JPanel{
	private JLBaseLabel jLError;
	private JCBBaseComboBox jCBoxElements;
	
	public JPCBoxTeacher(ControllerClient controller, String[] elements, String title) {
		super();
		this.setSize(0,0);
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE), title));
		initComponents(controller, elements);
	}

	private void initComponents(ControllerClient controller, String[] elements) {
		this.jCBoxElements = new JCBBaseComboBox(controller, elements, Constants.FONT_LOG_IN, Constants.DARK_BLUE);
		this.jCBoxElements.setBounds(600, 230, 300, 50);
		this.jLError = new JLBaseLabel(Constants.ICON_ALERT_RED);
		this.jLError.setBackground(Constants.BASE_BLUE);
		this.jLError.setVisible(false);
		this.add(this.jCBoxElements);
		this.add(jLError);
	}
	
	public void setVisibleJLError(boolean isVisible) {
		this.jLError.setVisible(isVisible);
	}
	
	

}
