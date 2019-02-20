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
import entity.Teacher;

public class AdminSearchTeacherServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		List<Teacher> teachers = new ArrayList<Teacher>();
		teachers = new AdminDao().listTeacher();
		HttpSession session = request.getSession();
		session.setAttribute("AdminListTeacher", teachers);
		
		response.sendRedirect("teacherDetail.jsp");
	}
}
