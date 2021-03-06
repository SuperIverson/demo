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
import dao.TeacherDao;
import entity.Grade;

/**
 * Servlet implementation class DeleteGradeServlet
 */
@WebServlet("/DeleteGradeServlet")
public class DeleteGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteGradeServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		
		TeacherDao teacherDao = new TeacherDao();

		HttpSession session = request.getSession();

		Grade grade = new Grade();

		grade.setStudentId(request.getParameter("studentId_delete"));
		grade.setCourseId(request.getParameter("courseId_delete"));
		grade.setScore(Integer.parseInt(request.getParameter("score_delete")));
		teacherDao.deleteGrade(grade);
		String id = request.getParameter("courseId_delete");
		String courseName = request.getParameter("courseName_delete");
		if(id!=null&&!id.equals("")) {
			List<SearchGrade> searchGrade = new ArrayList<SearchGrade>();
			searchGrade = teacherDao.searchGrade(id);
			session.setAttribute("searchGrade", searchGrade);
			session.setAttribute("courseId", id);
			session.setAttribute("courseName", courseName);
			response.sendRedirect("demo.jsp");
			return;
		}
	}

}
