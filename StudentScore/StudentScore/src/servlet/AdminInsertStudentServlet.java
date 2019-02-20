package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import entity.Student;

public class AdminInsertStudentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		 String id = request.getParameter("stuId");
		 String name = request.getParameter("stuName");
		 String password = request.getParameter("password");

		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setPassword(password);
		new AdminDao().insertStudent(student);

		response.sendRedirect("/StudentScore/adminSearchStudent");
	}
}
