package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import entity.Student;
import entity.Teacher;

public class AdminUpdateTeacherServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		String id = request.getParameter("stuId_change");
		String name = request.getParameter("stuName_change");
		String password = request.getParameter("password_change");
		
		Teacher teacher = new Teacher();
		teacher.setId(id);
		teacher.setName(name);
		teacher.setPassword(password);
		new AdminDao().updateTeacher(teacher);
		
		response.sendRedirect("/StudentScore/adminSearchTeacher");
	}
}
