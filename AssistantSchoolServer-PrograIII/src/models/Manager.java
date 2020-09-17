package models;

import comparators.ComparatorByCourse;
import comparators.ComparatorByStudent;
import comparators.ComparatorBySubject;
import comparators.ComparatorByTeacher;
import comparators.ComparatorByUsers;
import enums.TypeId;
import enums.TypeUser;
import structures.AVLTree;
import structures.NodeAVL;

public class Manager {

	private AVLTree<User> users;
	private AVLTree<Subject> subjects;
	private AVLTree<Teacher> teachers;
	private AVLTree<Student> students;
	private AVLTree<Course> courses;
	private String subjectsString;
	private String coursesString;
	private String teachersString;
//	private String studentsString;

	public Manager() {
		users = new AVLTree<User>(new ComparatorByUsers());
		subjects = new AVLTree<Subject>(new ComparatorBySubject());
		teachers = new AVLTree<Teacher>(new ComparatorByTeacher());
		students = new AVLTree<Student>(new ComparatorByStudent());
		courses = new AVLTree<Course>(new ComparatorByCourse());
		coursesString = "";
		subjectsString = "";
		teachersString = "";
		createAdmin();
		createSubjects();
	}

	private void createAdmin() {
		users.insert(new User(new Person("Administrador", "Administrador", TypeId.CC, 1234), TypeUser.ADMIN));
	}

	public boolean verifyUser(String nickName, String password) {
		boolean result = false;
		User userAux = new User(nickName, password);
		boolean exist = users.exist(userAux, users.getRoot());
		if (exist == true && userAux.getPassword().equals(password)) {
			result = true;
		}

		return result;
	}

	public String getSubjectsString() {
		convertSubjectsString(subjects.getRoot());
		return subjectsString;
	}

	public String getCoursesString() {
		convertCoursesToString(courses.getRoot());
		return coursesString;
	}

	public void addSubject(Subject subject) {
		subjects.insert(subject);
	}

	public void removeSubject(Subject subject) {
		subjects.delete(subject);
	}

	public Subject askSubject(Subject subject) {
		return subjects.ask(subject, subjects.getRoot()).getData();
	}
	
	public void asigSubjectToTeacher(Subject subject,Teacher teacher) {
		teacher.addSubject(subject);
	}
	
	public void asigCourseToTeacher(Course course , Teacher teacher) {
		course.reeplaceCourseDirector(teacher);
	}

	public void addStudent(Student student) {
		students.insert(student);
		users.insert(new User(student, TypeUser.STUDENT));
	}

	public void removeStudent(Student student) {
		students.delete(student);
		users.delete(new User(student, TypeUser.STUDENT));

	}

	public Student askStudent(Student student) {
		return students.ask(student, students.getRoot()).getData();
	}

	public void addTeacher(Teacher teacher) {
		teachers.insert(teacher);
		users.insert(new User(teacher, TypeUser.TEACHER));
	}
	
	public User askUser(User user) {
		return users.ask(user, users.getRoot()).getData();
	}

	public void removeTeacher(Teacher teacher) {
		teachers.delete(teacher);
		users.delete(new User(teacher, TypeUser.TEACHER));
	}

	public void assingSubjectToTeacher(Teacher teacher, Subject subject) {
		teacher.addSubject(subject);
	}

	public Teacher askTeacher(Teacher teacher) {
		return teachers.ask(teacher, teachers.getRoot()).getData();
	}

	public void assingTeacherToCourse(Teacher teacher, Course course) {
		course.setCourseDirector(teacher);
	}

	public void addPartialNote(PartialNote partialNote, Student student, int subjectId) {
		student.addPartialNote(partialNote, subjectId);
	}
	
	public void addCourse(Course course) {
		courses.insert(course);
	}


	public void modifyPartialNote(int subjectId, String topic, double value, String notation, Student student) {
		Student studentAux = students.ask(student, students.getRoot()).getData();
		FinalNote auxiliar = studentAux.askFinalNote(subjectId);
		auxiliar.modifyPartialNote(topic, value, notation);
	}
	
	public Course askCourse(Course course) {
		return courses.ask(course, courses.getRoot()).getData();
	}


	public PartialNote askPartialNote(String topic,int subjectId, Student student) {
		Student studentAux = students.ask(student, students.getRoot()).getData();
		FinalNote auxiliar = studentAux.askFinalNote(subjectId);
		return auxiliar.askPartialNote(topic);
	}

	public void addComment(String topic, String comment, int subjectId, Student student) {
		Student studentAux = students.ask(student, students.getRoot()).getData();
		FinalNote auxiliar = studentAux.askFinalNote(subjectId);
		PartialNote note = auxiliar.askPartialNote(topic);
		note.setComment(comment);
	}

	public FinalNote askFinalNote(int subjectId, Student student) {
		Student studentAux = students.ask(student, students.getRoot()).getData();
		return studentAux.askFinalNote(subjectId);
	}

	public AVLTree<User> getUsers() {
		return users;
	}

	public void setUsers(AVLTree<User> users) {
		this.users = users;
	}

	public AVLTree<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(AVLTree<Subject> subjects) {
		this.subjects = subjects;
	}

	public AVLTree<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(AVLTree<Teacher> teachers) {
		this.teachers = teachers;
	}

	public AVLTree<Student> getStudents() {
		return students;
	}

	public void setStudents(AVLTree<Student> students) {
		this.students = students;
	}

	public AVLTree<Course> getCourses() {
		return courses;
	}

	public void setCourses(AVLTree<Course> courses) {
		this.courses = courses;
	}

	private void createSubjects() {
		Subject math = new Subject(1, "Matematicas");
		Subject spanish = new Subject(2, "Español");
		Subject social = new Subject(3, "Sociales");
		Subject natural = new Subject(4, "Naturales");
		Subject religion = new Subject(5, "Religion");
		Subject ethics = new Subject(6, "Etica");
		Subject physical = new Subject(7, "Fisica");
		Subject chemistry = new Subject(8, "Quimica");
		Subject algebra = new Subject(9, "Algebra");
		Subject calculus = new Subject(10, "Calculo");
		subjects.insert(math);
		subjects.insert(spanish);
		subjects.insert(social);
		subjects.insert(natural);
		subjects.insert(religion);
		subjects.insert(ethics);
		subjects.insert(physical);
		subjects.insert(chemistry);
		subjects.insert(algebra);
		subjects.insert(calculus);
		Course sixth = new Course("Sexto ");
		Course seventh = new Course("Septimo");
		Course eighth = new Course("Octavo");
		Course nineth = new Course("Noveno");
		Course tenth = new Course("Decimo");
		Course eleventh = new Course("Once");
		courses.insert(sixth);
		courses.insert(seventh);
		courses.insert(eighth);
		courses.insert(nineth);
		courses.insert(tenth);
		courses.insert(eleventh);
		Teacher t1 = new Teacher("Pedro", "Perez", TypeId.CC, 1234);
		t1.addSubject(calculus);
		t1.addSubject(algebra);
		teachers.insert(t1);

	}

	private void convertSubjectsString(NodeAVL<Subject> auxiliar) {
		if (auxiliar != null) {
			convertSubjectsString(auxiliar.getLeft());
			subjectsString += (("-" + auxiliar.getData().getSubjectName() + "_" + auxiliar.getData().getSubjectCode()));
			convertSubjectsString(auxiliar.getRigth());
		}
	}

	private void convertCoursesToString(NodeAVL<Course> auxiliar) {
		if (auxiliar != null) {
			convertCoursesToString(auxiliar.getLeft());
			coursesString += "-" + ((auxiliar.getData().getNameCourse()));
			convertCoursesToString(auxiliar.getRigth());
		}
	}

	private void convertTeachersToString(NodeAVL<Teacher> auxiliar) {
		if (auxiliar != null) {
			convertTeachersToString(auxiliar.getLeft());
			teachersString += "," + ((auxiliar.getData().getName() + " " + auxiliar.getData().getLastName() + "-"
					+ auxiliar.getData().getTypeId() + " " + auxiliar.getData().getNumberId())
					+ ","+ auxiliar.getData().getSubjectsString());
			auxiliar.getData().resetSubjectsString();
			convertTeachersToString(auxiliar.getRigth());
		}
	}
	
	private void convertTeachersToStringOutSubjects(NodeAVL<Teacher> auxiliar) {
		if (auxiliar != null) {
			convertTeachersToStringOutSubjects(auxiliar.getLeft());
			teachersString += "," + auxiliar.getData().toStringTeacher();
			convertTeachersToStringOutSubjects(auxiliar.getRigth());
		}
	}

	public String getTeachersString() {
		convertTeachersToString(teachers.getRoot());
		return teachersString;
	}
	
	public String getTeachersStringOutSubjects() {
		teachersString = "";
		this.convertTeachersToStringOutSubjects(teachers.getRoot());
		return teachersString;
	}
	
	public void resetStrings() {
		this.coursesString="";
		this.subjectsString="";
		this.teachersString="";
	}
	
	

	public static void main(String[] args) {
		Manager ma = new Manager();
		System.out.println(ma.getCoursesString());
	}

}
