package functions;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo.Student;

public class Methods {
	static Scanner sc = new Scanner(System.in);
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	StudentImpl stdimp = context.getBean("mysi", StudentImpl.class);

	static Student readInput() {
		System.out.println("Enter Id ");
		int id = sc.nextInt();
		System.out.println("Enter Name ");
		String name = sc.next();
		System.out.println("Enter City ");
		String city = sc.next();
		Student std = new Student(id, name, city);
		return std;
	}

	public void insertStudent() {
		Student std = readInput();
		int result = stdimp.insert(std);
		System.out.println("Student record inserted  !!!!" + result);
	}

	public void updateStudent() {
		Student std = readInput();
		int result = stdimp.updateData(std);
		System.out.println("Student detail Updated  !!!!" + result);
	}

	public void deleteStudentById() {
		System.out.println("Enter Id of Student to be deleted");
		int id = sc.nextInt();
		int result = stdimp.deleteData(id);
		System.out.println("Deleted the data" + result);
	}

	public void getStudentById() {
		System.out.println("Enter Id of Student to be deleted");
		int id = sc.nextInt();
		Student std = stdimp.getStudent(id);
		System.out.println(std);
	}

	public void displayAllStudents() {
		List<Student> stds = stdimp.getStudents();
		for (Student student : stds) {
			System.out.println(student);
		}
	}
}
