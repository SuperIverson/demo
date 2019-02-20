package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Course;
import entity.Student;
import entity.Teacher;

public class AdminDao {
	public AdminDao(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javaee?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT", "root",
				"123456");
	}
	
public String searchPassword(String adminId){
		
		String password = null;
		
		try(Connection connection = getConnection();
		Statement statement = connection.createStatement()){
			String sql = "SELECT password " + 
					"FROM admin " +	
					"where id = " + adminId;
			
			ResultSet rSet = statement.executeQuery(sql);
			if(rSet.next()){
				password = rSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}
	
	public List<Student> listStudent(){
		List<Student> students = new ArrayList<Student>();
		String sql = "SELECT * FROM student;";
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Student student = new Student();
				student.setId(resultSet.getString(1));
				student.setName(resultSet.getString(2));
				student.setPassword(resultSet.getString(3));
				students.add(student);
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return students;
	}
	
	public List<Teacher> listTeacher(){
		List<Teacher> teachers = new ArrayList<Teacher>();
		String sql = "SELECT * FROM teacher;";
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getString(1));
				teacher.setName(resultSet.getString(2));
				teacher.setPassword(resultSet.getString(3));
				teachers.add(teacher);
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return teachers;
	}
	
	public List<Course> listCourse(){
		List<Course> courses = new ArrayList<Course>();
		String sql = "SELECT * FROM course;";
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Course course = new Course();
				course.setId(resultSet.getString(1));
				course.setName(resultSet.getString(2));
				course.setTeacher(resultSet.getString(3));
				courses.add(course);
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return courses;
	}
	
	public void insertStudent(Student student){
		String sql = "INSERT INTO student VALUES (?, ?, ?);";
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getPassword());
			
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void insertTeacher(Teacher teacher){
		String sql = "INSERT INTO teacher VALUES (?, ?, ?);";
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, teacher.getId());
			preparedStatement.setString(2, teacher.getName());
			preparedStatement.setString(3, teacher.getPassword());
			
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	public void insertCourse(Course course){
		String sql = "INSERT INTO course VALUES (?, ?, ?);";
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, course.getId());
			preparedStatement.setString(2, course.getName());
			preparedStatement.setString(3, course.getTeacher());
			
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void deleteStudent(String id){
		String sql = "DELETE FROM student WHERE student.id = " + id;
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void deleteTeacher(String id){
		String sql = "DELETE FROM teacher WHERE teacher.id = " + id;
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void deleteCourse(String id){
		String sql = "DELETE FROM course WHERE course.id = " + id;
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void updateStudent(Student student){
		String sql = "UPDATE student SET  `name`= ?, `password` = ? WHERE id = ?";
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getPassword());
			preparedStatement.setString(3, student.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void updateTeacher(Teacher teacher){
		String sql = "UPDATE teacher SET `name`= ?, `password` = ? WHERE id = ?";
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, teacher.getName());
			preparedStatement.setString(2, teacher.getPassword());
			preparedStatement.setString(3, teacher.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void updateCourse(Course course){
		String sql = "UPDATE course SET  `name`= ?, `teacher` = ? WHERE id = ?";
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, course.getName());
			preparedStatement.setString(2, course.getTeacher());
			preparedStatement.setString(3, course.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
