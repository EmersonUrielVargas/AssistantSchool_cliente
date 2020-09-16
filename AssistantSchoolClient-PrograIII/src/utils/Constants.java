package utils;

import java.awt.Color;
import java.awt.Font;

public class Constants {

	// Constantes Generales del Frame
	public static final String ICON = "/images/Icon.png";

	// Init Of Session
	public static final String INIT_SESION_IMAGEN = "/images/Init_Session_Imagen.png";
	public static final String INIT_SESION = "/images/Init_Sesion.png";
	public static final String INIT_SESION_PRESS = "/images/Init_Sesion_Press.png";
	public static final String ERROR_USER = "El Usuario no ha sido encontrado";
	public static final String TEXT_TYPE_USER = "Seleccione el tipo de usuario";
	public static final Font FONT_LOG_IN = new Font("Bahnschrift", Font.PLAIN, 20);
	public final static String[] TYPE_USERS = { "Admin", "Docente", "Estudiante" };
	public final static String[] TYPE_USERS_NOT_ADMIN = { "Docente", "Estudiante" };

	public final static String[] TYPE_DOCUMENT = { "CC", "TI", "RC", "CE" };
	public static final Color COLOR_BLUE = Color.decode("#0070C0");
	public static final Color COLOR_DARK_BLUE = Color.decode("#002060");
	public static final String TEXT_LOGIN_LABEL = "Nombre de Usuario";
	public static final String TEXT_PASSWORD_LOGIN_LABEL = "Ingrese su contraseña";

	// Admin
	public static final String ROUTE_IMAGEN_FOREGROUND = "/images/Imagen_Foreground.png";
	public static final String ROUTE_REMOVE = "/images/Remove.png";
	public static final String ROUTE_REMOVE_PRESS = "/images/Remove_Press.png";
	public static final String ROUTE_ICON_TEACHER = "/images/Icon_Teacher.png";
	public static final String ROUTE_ICON_TEACHER_PRESS = "/images/Icon_Teacher_Press.png";
	public static final String ROUTE_ICON_STUDENT = "/images/Icon_Student.png";
	public static final String ROUTE_ICON_STUDENT_PRESS = "/images/Icon_Student_Press.png";
	public static final String ROUTE_ICON_COURSES = "/images/Icon_Courses.png";
	public static final String ROUTE_ICON_COURSES_PRESS = "/images/Icon_Courses_Press.png";
	public static final String ROUTE_ICON_REGISTER = "/images/Icon_Register.png";
	public static final String ROUTE_ICON_REGISTER_PRESS = "/images/Icon_Register_Press.png";
	
	public static final String ROUTE_ADD_SUBJECT = "/images/Add_Subject.png";
	public static final String ROUTE_ADD_SUBJECT_PRESS = "/images/Add_Subject_Press.png";
	public static final String ROUTE_ADD_COURSE = "/images/Add_Course.png";
	public static final String ROUTE_ADD_COURSE_PRESS = "/images/Add_Courses_Pres.png";
	public static final String ROUTE_SEE_COURSE = "/images/See_Course.png";
	public static final String ROUTE_SEE_COURSE_PRESS = "/images/See_Course_Press.png";
	public static final String ROUTE_SEE_SUBJECT = "/images/See_Subject.png";
	public static final String ROUTE_SEE_SUBJECT_PRESS = "/images/See_Subject_Press.png";


	public static final Color BASE_BLUE = Color.decode("#0070BB");
	public static final Color DARK_BLUE = Color.decode("#283F69");
	public static final Color LIGHT_BLUE = Color.decode("#5B9BD5");
	public static final Color BASE_GREEN = Color.decode("#1FA024");
	public static final Color DARK_GREEN = Color.decode("#187A24");

	public static final Color LIGHT_GREEN = Color.decode("#A2C535");
	public static final Color BASE_LIGHT_GRAY = Color.decode("#909090");
	public static final Color ALTERNATIVE_LIGHT_GRAY = Color.decode("#D3D3D3");
	public static final Font EIGHTEEN_BASE_FONT = new Font("Source Sans Pro", Font.PLAIN, 18);
	public static final Font TWENTY_FIVE_BASE_FONT = new Font("Source Sans Pro", Font.PLAIN, 25);
	public static final Font TWENTY_BASE_FONT = new Font("Source Sans Pro", Font.PLAIN, 20);
	public static final Font TWENTY_EIGHT_BASE_FONT = new Font("Source Sans Pro", Font.PLAIN, 28);
	public static final Font EIGHTEEN_BOLD_BASE_FONT = new Font("Source Sans Pro", Font.BOLD, 18);
	public static final Font SEVENTEEN_BOLD_BASE_FONT = new Font("Source Sans Pro", Font.BOLD, 17);
	public static final Font FOURTEEN_BOLD_BASE_FONT = new Font("Source Sans Pro", Font.BOLD, 14);
	public static final Font FOURTEEN_BOLD_TAHOMA_FONT = new Font("Tahoma", Font.BOLD, 14);
	public static final Font FOURTEEN_PLAIN_TAHOMA_FONT = new Font("Tahoma", Font.PLAIN, 14);
	public static final Font TWELVE_PLAIN_TAHOMA_FONT = new Font("Tahoma", Font.PLAIN, 12);

	public static final int BORDER_THICKNESS = 1;

//Constants of JDialogLogin Class-----------------------------------------------

	public static final String LOGIN_ICON = "/images/LOGIN_ICON.png";
	public static final String LOGIN_BUTTON = "/images/LOGIN_BUTTON.png";
	public static final String REGISTER_BUTTON = "/images/REGISTER_BUTTON.png";
	public static final Font BASE_LOGIN_FONT = new Font("Source Sans Pro", Font.PLAIN, 18);
	public static final String TEXT_TYPE_USER_LOGIN_LABEL = "Seleccione el tipo de usuario";

	public static final String REGISTER_ICON = "/images/REGISTER_ICON.png";
	public static final String TEXT_REGISTER_ID = "Ingrese un numero de identificacion";
	public static final String TEXT_REGISTER_NAME = "Ingrese su nombre";
	public static final String TEXT_REGISTER_LASTNAME = "Ingrese su apellido";
	public static final String TEXT_REGISTER_PHONE_NUMBER = "Ingrese su numero de telefono";
	public static final String TEXT_REGISTER_ADDRESS = "Ingrese su direccion";
	public static final String TEXT_REGISTER_GENDER = "Seleccione genero";
	public static final String TEXT_REGISTER_DEPARMENT = "Seleccione Departamento";
	public static final String TEXT_REGISTER_CITY = "Seleccione un municipio";
	public static final String TEXT_REGISTER_PASSWORD = "Ingrese su contraseña";
	public static final String TEXT_REGISTER_CONFIRM_PASSWORD = "Confirme su contraseña";
	public static final String TEXT_REGISTER_INCORRECT_PASSWORDS = "Las contraseñas no coinciden";
	public static final String TEXT_REGISTER_USER_REGISTERED = "El ID ya esta registrado";

	public static final String REGISTERED_ICON = "/images/REGISTERED_ICON.png";
	public static final String SIGN_IN_ICON = "/images/SIGNIN_ICON.png";
	public static final String TEXT_SUCESSFULL_REGISTERED = "Te has registrado Exitosamente";
	public static final String TEXT_SUCESSFULL_NAME = "Usuario : ";
	public static final String TEXT_SUCESSFULL_ID = "ID:";
	public static final String TEXT_SUCESSFULL_LOG_IN = "Has iniciado sesion Exitosamente";

	public static final String DELETE_PROD_ICON_PATH = "/images/DELETE_PRODUCT.png";
	public static final String DELETE_PROD_ICON2_PATH = "/images/DELETE_PRODUCT2.png";

//Constants of JPSearch Class-----------------------------------------------
	public static final String SEARH_ICON_PATH = "/images/SEARCH_ICON.png";
	public static final int JBSEARCH_GAPH = 0;
	public static final int JBSEARCH_GAPV = 10;
	public static final String JTFSEARCH_INICIAL_TEXT = "Ingrese el Id a buscar";
	public static final int JTFSEARCH_BORDER_SIZE = 10;

//Constants of Jbuttons admin-----------------------------------------------
	public static final String SHOW_COURSES_ICON = "/images/SHOW_TEACHERS_ICON.png";
	public static final String SHOW_COURSES_ICON_PRESS = "/images/SHOW_TEACHERS_ICON.png";
	public static final String SHOW_TEACHERS_ICON = "/images/SHOW_TEACHERS_ICON.png";
	public static final String SHOW_TEACHERS_ICON_PRESS = "/images/SHOW_TEACHERS_ICON.png";
	public static final String SHOW_STUDENTS_ICON = "/images/SHOW_TEACHERS_ICON.png";
	public static final String SHOW_STUDENTS_ICON_PRESS = "/images/SHOW_TEACHERS_ICON.png";
	public static final String SHOW_SUBJECTS_ICON = "/images/SHOW_TEACHERS_ICON.png";
	public static final String SHOW_SUBJECTS_ICON_PRESS = "/images/SHOW_TEACHERS_ICON.png";
	public static final String SHOW_LOGIN_ICON = "/images/SHOW_TEACHERS_ICON.png";
	public static final String SHOW_LOGIN_ICON_PRESS = "/images/SHOW_TEACHERS_ICON.png";
	public static final String SHOW_LOGOUT_ICON = "/images/SHOW_TEACHERS_ICON.png";
	public static final String SHOW_LOGOUT_ICON_PRESS = "/images/SHOW_TEACHERS_ICON.png";
	public static final String SHOW_REGISTER_USER_ICON = "/images/SHOW_TEACHERS_ICON.png";
	public static final String SHOW_REGISTER_USER_ICON_PRESS = "/images/SHOW_TEACHERS_ICON.png";

}
