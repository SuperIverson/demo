package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import entity.Course;

public class AdminInsertCourseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		String id = request.getParameter("stuId");
		String name = request.getParameter("stuName");
		String teacher = request.getParameter("password");

		Course course = new Course();
		course.setId(id);
		course.setName(name);
		course.setTeacher(teacher);
		new AdminDao().insertCourse(course);

		response.sendRedirect("/StudentScore/adminSearchCourse");

	}
}
