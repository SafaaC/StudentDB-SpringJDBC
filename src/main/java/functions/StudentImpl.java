package functions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springdemo.Student;

public class StudentImpl implements StudentInt{

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student std) {
		 String query="insert into student values(?,?,?)";
	      int r = jdbcTemplate.update(query,std.getId(),std.getName(),std.getCity());
		return r;
	}

	@Override
	public int updateData(Student std) {
		String query="update student set name=?,city=? where id=?";
	      int r = jdbcTemplate.update(query,std.getName(),std.getCity(),std.getId());
		return r;
	}

	@Override
	public int deleteData(int studentId) {
		String query="delete from student where id=?";
	      int r = jdbcTemplate.update(query,studentId);
	      return r;
	}

	@Override
	public Student getStudent(int studentId) {
		String query="select * from student where id=?";
		Student student=jdbcTemplate.queryForObject(query, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student std= new Student();
				std.setId(rs.getInt(1));
				std.setName(rs.getString(2));
				std.setCity(rs.getString(3));
				return std;
			}
			
		}, studentId);
		return student;
	}

	@Override
	public List<Student> getStudents() {
		
		String query="select * from student ";
		List<Student> students=jdbcTemplate.query(query, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student std= new Student();
				std.setId(rs.getInt(1));
				std.setName(rs.getString(2));
				std.setCity(rs.getString(3));
				return std;
			}
			
		});
		return students;
	}

}
