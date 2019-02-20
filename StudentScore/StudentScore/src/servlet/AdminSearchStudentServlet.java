package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.StudentDao;
import entity.Course;
import entity.Student;
import entity.Teacher;

public class AdminSearchStudentServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		List<Student> students = new ArrayList<Student>();
		students = new AdminDao().listStudent();
		HttpSession session = request.getSession();
		session.setAttribute("AdminListStudent", students);
		
		response.sendRedirect("studentDetail.jsp");
	}
	
}
