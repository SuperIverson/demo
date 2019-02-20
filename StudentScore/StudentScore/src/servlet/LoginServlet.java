package servlet;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.SearchGrade;
import dao.AdminDao;
import dao.StudentDao;
import dao.TeacherDao;
import entity.Course;
import entity.Teacher;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		StudentDao studentDao = new StudentDao();
		TeacherDao teacherDao = new TeacherDao();
		AdminDao adminDao = new AdminDao();
		String id = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		String key = null;
		HttpSession session = request.getSession();
		
		if ("".equals(id)&& "".equals(password)) {

			response.sendRedirect("login.jsp");
			return;
		}
		boolean isValid = false;
		if("student".equals(type)) {
			String pwd = studentDao.searchPassword(id);
			if(pwd.equals(password)) {
				List<SearchGrade> grades = studentDao.searchGrade(id);
				//List<Course> courseName = teacherDao.searchCourse("01");
				session.setAttribute("grades", grades);
				//session.setAttribute("courseName", courseName);
				response.sendRedirect("test.jsp");
				isValid = true;
				return;
			}
		}else if ("teacher".equals(type)) {
			String pwd = teacherDao.searchPassword(id);
			if(pwd.equals(password)) {			
				List<Course> courseName = teacherDao.searchCourse(id);
				session.setAttribute("courseName", courseName);
				response.sendRedirect("teacher.jsp");
				isValid = true;
				return;
			}
		}else if ("admin".equals(type)) {
			String pwd = adminDao.searchPassword(id);
			if(pwd.equals(password)) {			
				response.sendRedirect("admin.jsp");
				isValid = true;
				return;
			}
		}
		if(!isValid){
			response.sendRedirect("login.jsp");
			return;
		}
	}

}
