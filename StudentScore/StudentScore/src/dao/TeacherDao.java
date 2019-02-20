package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.SearchGrade;
import entity.Course;
import entity.Grade;

public class TeacherDao {

	public TeacherDao(){
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
	
	public List<Course> searchCourse(String teacherId){
		List<Course> courses = new ArrayList<Course> ();

		try(Connection connection = getConnection(); 
			Statement statement = connection.createStatement()){
			String sql = "SELECT * FROM course WHERE course.teacher = "+ teacherId;
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				Course course = new Course();
				course.setId(resultSet.getString(1));
				course.setName(resultSet.getString(2));
				course.setTeacher(resultSet.getString(3));
				courses.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courses;
	}
	
	public List<SearchGrade> searchGrade(String courseId){
		List<SearchGrade> searchGrades = new ArrayList<SearchGrade>();
		
		try(Connection connection = getConnection(); Statement statement = connection.createStatement()){
			String sql = "SELECT student.`name`, course.`name`,  course.teacher,  grade.score, student.id "+
					"FROM grade JOIN student ON student.id = grade.studentId " +
					"JOIN course ON grade.courseId = course.id " +
					"WHERE course.id = " + courseId;
			
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				SearchGrade searchGrade = new SearchGrade();
				searchGrade.setStudentName(resultSet.getString(1));
				searchGrade.setCourseName(resultSet.getString(2));
				searchGrade.setTeacherName(resultSet.getString(3));
				searchGrade.setScore(resultSet.getInt(4));
				searchGrade.setStudentId(resultSet.getString(5));
				searchGrades.add(searchGrade);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchGrades;
	}
	
	public String searchPassword(String teacherId){
		
		String password = null;
		
		try(Connection connection = getConnection();
		Statement statement = connection.createStatement()){
			String sql = "SELECT password " + 
					"FROM teacher " +	
					"where id = " + teacherId;
			
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

	public void insertGrade(Grade grade){
		String sql = "INSERT INTO grade VALUES(?, ?, ?);";
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, grade.getStudentId());
			preparedStatement.setString(2, grade.getCourseId());
			preparedStatement.setInt(3, grade.getScore());
			
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void updateGrade(Grade grade){
		String sql = "UPDATE grade SET grade.score = ? WHERE studentId =  ? AND courseId = ?;";
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, grade.getScore());
			preparedStatement.setString(2, grade.getStudentId());
			preparedStatement.setString(3, grade.getCourseId());
			preparedStatement.execute();
		}catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void deleteGrade(Grade grade){
		String sql = "DELETE FROM grade WHERE studentId = ? AND courseId = ?;";
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, grade.getStudentId());
			preparedStatement.setString(2, grade.getCourseId());
			preparedStatement.execute();
		}catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
}
