package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Commands;
import controller.ControllerClient;
import utils.Constants;

public class JPSearch extends JPanel implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	
	int number = 5;
	byte numberb = (byte) number;
	
	private JBBaseButton jbSearch;
	private JTFBaseTextField jtfSearh;
	
	public JPSearch(ControllerClient controllerApp) {
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, Constants.BORDER_THICKNESS));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, Constants.JBSEARCH_GAPH, Constants.JBSEARCH_GAPV));
		startComponents(controllerApp);
	}
	
	private void startComponents(ControllerClient controllerApp) {
		jtfSearh = new JTFBaseTextField(Constants.JTFSEARCH_INICIAL_TEXT, Constants.EIGHTEEN_BASE_FONT, Constants.BASE_LIGHT_GRAY, 
				Constants.JTFSEARCH_BORDER_SIZE, controllerApp);
		jbSearch = new JBBaseButton(Constants.SEARH_ICON_PATH, Color.WHITE, controllerApp, Commands.AC_SEARCH_BY_WORDS);
		this.jtfSearh.addMouseListener(this);
		this.add(jtfSearh);
		this.add(jbSearch);
	}
	
	public String captureText() {
		return jtfSearh.getText();
	}
	
//*MouseListener methods(Interface)
	
	public void mouseClicked(MouseEvent e) {
		Object sourceObj = e.getSource();
		if (sourceObj.equals(jtfSearh)) {
			eraseSearchBarDefaultText();
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
	
	private void eraseSearchBarDefaultText() {
		if (jtfSearh.getText().equalsIgnoreCase(Constants.JTFSEARCH_INICIAL_TEXT)) {
			jtfSearh.setForeground(Color.BLACK);
			jtfSearh.setText("");
		}
	}
}







