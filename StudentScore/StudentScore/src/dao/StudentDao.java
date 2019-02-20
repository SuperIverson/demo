package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Grade;
import entity.Student;
import VO.SearchGrade;

public class StudentDao {
	
	public StudentDao(){
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
	
	public List<SearchGrade> searchGrade(String studentId){
		List<SearchGrade> grades = new ArrayList<SearchGrade>();
		
		String sql = "SELECT student.`name`, course.`name`,  course.teacher,  grade.score "+
				"FROM grade JOIN student ON student.id = grade.studentId " +
				"JOIN course ON grade.courseId = course.id " +
				"WHERE student.id = ?;";
		
		try(Connection connection = getConnection(); PreparedStatement pStatement = connection.prepareStatement(sql);){
			pStatement.setString(1, studentId);
			
			ResultSet rSet = pStatement.executeQuery();
			while(rSet.next()){
				SearchGrade searchGrade = new SearchGrade();
				searchGrade.setStudentName(rSet.getString(1));
				searchGrade.setCourseName(rSet.getString(2));
				searchGrade.setTeacherName(rSet.getString(3));
				searchGrade.setScore(rSet.getInt(4));
				grades.add(searchGrade);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return grades;
	}
	
	public String searchPassword(String strudentId){
		
		String password = null;
		
		try(Connection connection = getConnection();
		Statement statement = connection.createStatement()){
			String sql = "SELECT password " + 
					"FROM student " +	
					"where id = " + strudentId;
			
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

}
