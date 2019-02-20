package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.SearchGrade;
import dao.StudentDao;
import dao.TeacherDao;
import entity.Course;
import entity.Grade;

/**
 * Servlet implementation class AddGradeServlet
 */
@WebServlet("/AddGradeServlet")
public class AddGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		
		TeacherDao teacherDao = new TeacherDao();

		HttpSession session = request.getSession();

		Grade grade = new Grade();
		grade.setStudentId(request.getParameter("stuId"));
		grade.setCourseId(request.getParameter("courseId"));
		grade.setScore(Integer.parseInt(request.getParameter("score")));
		teacherDao.insertGrade(grade);
		String id = request.getParameter("courseId");
		String courseName = request.getParameter("courseName");
		if(id!=null&&!id.equals("")) {
			List<SearchGrade> searchGrade = new ArrayList();
			searchGrade = teacherDao.searchGrade(id);
			session.setAttribute("searchGrade", searchGrade);
			session.setAttribute("courseId", id);
			session.setAttribute("courseName", courseName);
			response.sendRedirect("demo.jsp");
			return;
		}

		

	}

}
