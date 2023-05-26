package functions;

import java.util.List;

import com.springdemo.Student;

public interface StudentInt {
	int insert(Student std);
	int updateData(Student std);
	int deleteData(int studentId);
	Student getStudent(int studentId);
	List<Student> getStudents();
}
