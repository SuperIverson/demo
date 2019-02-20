package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import entity.Course;
import entity.Teacher;

public class AdminUpdateCourseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		String id = request.getParameter("stuId_change");
		String name = request.getParameter("stuName_change");
		String teacher = request.getParameter("password_change");
				
		Course course = new Course();
		course.setId(id);
		course.setName(name);
		course.setTeacher(teacher);
		new AdminDao().updateCourse(course);
		
		response.sendRedirect("/StudentScore/adminSearchCourse");
	}
	
}
