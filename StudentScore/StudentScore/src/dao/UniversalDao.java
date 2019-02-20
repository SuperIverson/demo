package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Grade;

public class UniversalDao {

	public UniversalDao(){
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
	
	//检查学生id是否存在
	public String checkStudentId(String student){
		String sql = "SELECT id FROM student WHERE student.id = " + student + ";";
		String studentId = null;
		try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			ResultSet rSet = preparedStatement.executeQuery();
			if(rSet.next()){
				studentId = rSet.getString(1);
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return studentId;
	}
	
	//检查课程id是否存在
	public String checkCourseId(String course){
		String sql ="SELECT id FROM course WHERE course.id = " + course + ";";
		String courseId = null;
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				courseId = resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return courseId;
	}
	
	//检查老师id是否存在
	public String checkTeacherId(String teacher){
		String sql ="SELECT id FROM teacher WHERE teacher.id = " + teacher + ";";
		String teacherId = null;
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				teacherId = resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return teacherId;
	}
}
