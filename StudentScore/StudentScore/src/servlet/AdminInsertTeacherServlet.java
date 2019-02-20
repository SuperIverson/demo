package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import entity.Teacher;

public class AdminInsertTeacherServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		 String id = request.getParameter("stuId");
		 String name = request.getParameter("stuName");
		 String password = request.getParameter("password");
		
		Teacher teacher = new Teacher();
		teacher.setId(id);
		teacher.setName(name);
		teacher.setPassword(password);
		new AdminDao().insertTeacher(teacher);

		response.sendRedirect("/StudentScore/adminSearchTeacher");
	}
}
