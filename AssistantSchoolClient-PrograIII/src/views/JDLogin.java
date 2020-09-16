package views;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPasswordField;

import controller.Commands;
import controller.ControllerClient;
import utils.Constants;

public class JDLogin extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLBaseLabel imagenJL, errorJL, nickNameJL, passwordJL, typeUserJL;
	private JTFBaseTextField nickNameJTF;
	private JPasswordField passwordJPF;
	private JBBaseButton initSesionJB;
	private JCBBaseComboBox typeUserJCB;

	public JDLogin(ControllerClient controller, String[] typeUser) {
		this.getContentPane().setBackground(Color.white);
		this.setSize(400, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		setIconImage(new ImageIcon(getClass().getResource(Constants.ICON)).getImage());
		initComponents(controller, typeUser);
	}

	private void initComponents(ControllerClient controllerApp, String[] typeUser) {

		imagenJL = new JLBaseLabel(Constants.INIT_SESION_IMAGEN);
		imagenJL.setBounds(100, 0, 200, 200);
		typeUserJL = new JLBaseLabel(Constants.TEXT_TYPE_USER, Constants.FONT_LOG_IN, Constants.COLOR_DARK_BLUE);
		typeUserJL.setBounds(10, 200, 370, 40);
		typeUserJCB = new JCBBaseComboBox(controllerApp, typeUser, Constants.FONT_LOG_IN, Constants.COLOR_DARK_BLUE);
		typeUserJCB.setBounds(10, 240, 370, 40);
		errorJL = new JLBaseLabel("", Constants.FONT_LOG_IN, Color.RED);
		errorJL.setBounds(10, 280, 370, 40);
		nickNameJL = new JLBaseLabel(Constants.TEXT_LOGIN_LABEL, Constants.FONT_LOG_IN, Constants.COLOR_DARK_BLUE);
		nickNameJL.setBounds(10, 320, 370, 40);
		nickNameJTF = new JTFBaseTextField(Constants.COLOR_DARK_BLUE, Constants.FONT_LOG_IN, 2);
		nickNameJTF.setBounds(10, 360, 370, 40);
		passwordJL = new JLBaseLabel(Constants.TEXT_PASSWORD_LOGIN_LABEL, Constants.FONT_LOG_IN,Constants.COLOR_DARK_BLUE);
		passwordJL.setBounds(10, 410, 370, 40);
		passwordJPF = new JPasswordField(15);
		passwordJPF.setBounds(10, 450, 370, 40);
		initSesionJB = new JBBaseButton(Constants.INIT_SESION, Constants.INIT_SESION_PRESS, controllerApp,Commands.C_LOG_IN);
		initSesionJB.setBounds(100, 500, 200, 50);

		add(imagenJL);
		add(typeUserJL);
		add(typeUserJCB);
		add(errorJL);
		add(nickNameJL);
		add(nickNameJTF);
		add(passwordJL);
		add(passwordJPF);
		add(initSesionJB);
	}

	public String[] getDataLogIn() {
		String[] data = new String[3];
		data[0] = this.nickNameJTF.getText();
		data[1] = String.copyValueOf(this.passwordJPF.getPassword());
		data[2] = "" + typeUserJCB.getSelectedItem();
		return data;
	}

	public void restoreValue() {
		this.nickNameJTF.setText("");
		this.passwordJPF.setText("");
		this.errorJL.setText("");
		this.setVisible(false);
	}

	public void incorrectLogin() {
		this.errorJL.setText(Constants.ERROR_USER);
	}
}