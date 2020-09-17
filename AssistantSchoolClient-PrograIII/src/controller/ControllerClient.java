package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utils.Constants;
import views.JDLogin;
import views.JDRegisterUser;
import views.JFAdmin;

public class ControllerClient implements ActionListener, ItemListener {

	private final static int PORT = 23575;
	private final static String HOST = "localhost";
	private Socket socket;
	private DataOutputStream output;
	private DataInputStream input;

	private JDLogin loginJD;
	private JFAdmin adminJF;
	private JDRegisterUser registerUserJD;

	public ControllerClient() throws FileNotFoundException, IOException {
		//socket = new Socket(HOST, PORT);
//		output = new DataOutputStream(socket.getOutputStream());
//		input = new DataInputStream(socket.getInputStream());
//		initLogin();
	}

	public void initLogin() {
		String[] users = { "Admin", "Docente", "Estudiante" };
		loginJD = new JDLogin(this, users);
		loginJD.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		switch (Commands.valueOf(actionEvent.getActionCommand())) {

		case C_LOG_IN:
			writeDatesInitSesion();
			break;

		case REGISTER_CLIENT:
			try {
				output.writeInt(2);
				String[] subjects = input.readUTF().split("-");
				String[] courses  = input.readUTF().split("-");
				registerUserJD = new JDRegisterUser(this, Constants.TYPE_USERS_NOT_ADMIN, Constants.TYPE_DOCUMENT,subjects,courses);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			break;

		case ADD_CLIENT:
			addClient();
			break;

		case AC_SHOW_TEACHERS_BUTTON:
			addTeachers();
			break;
			
		case REMOVE_USER:
			removeUser();
		}
	}
	
	private void removeUser() {
		try {
			output.writeInt(5);
			String idText = JOptionPane.showInputDialog("Ingrese el id");
			output.writeInt(Integer.parseInt(idText));
			JOptionPane.showMessageDialog(null, "Usuario Elimiando con éxito");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.addTeachers();
		
	}

	private void addClient() {
		try {
			output.writeInt(3);
			output.writeUTF(registerUserJD.getDatesUser());
			registerUserJD.setVisible(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addTeachers() {
		ArrayList<String> teachers = new ArrayList<String>();
		try {
			output.writeInt(4);
			int quantityDates = input.readInt();
			System.out.println(quantityDates);
			if (quantityDates == 1) {
				JOptionPane.showMessageDialog(null, "No hay datos que mostrar");
				adminJF.isVisibleImagen(true);
				adminJF.isVisiblePanelTeachers(false);
			} else {
				for (int i = 0; i < quantityDates; i++) {
					teachers.add(input.readUTF());
				}
				String[] result = new String[teachers.size()];
				for (int i = 0; i < teachers.size(); i++) {
					result[i] = teachers.get(i);
				}
				adminJF.initPanelTeachers(this, result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void writeDatesInitSesion() {

		try {
			output.writeInt(1);
			String[] datas = loginJD.getDataLogIn();
			String dates = datas[0] + "-" + datas[1] + "-" + datas[2];
			output.writeUTF(dates);
			boolean result = input.readBoolean();
			if (result == true) {
				if (datas[2].equals("Admin")) {
					adminJF = new JFAdmin(this);
					loginJD.setVisible(false);
				} else if (datas[2].equals("Estudiante")) {

				} else if (datas[2].equals("Docente")) {

				}
			} else {
				loginJD.incorrectLogin();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		new ControllerClient();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	}

}
