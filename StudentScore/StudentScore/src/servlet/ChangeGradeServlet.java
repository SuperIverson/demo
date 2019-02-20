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
import entity.Grade;

/**
 * Servlet implementation class ChangeGradeServlet
 */
@WebServlet("/ChangeGradeServlet")
public class ChangeGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeGradeServlet() {
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
		request.setCharacterEncoding("UTF-8"); 
		
		TeacherDao teacherDao = new TeacherDao();

		HttpSession session = request.getSession();

		Grade grade = new Grade();
		String studentId = request.getParameter("stuId_change");
		String regStartSpace = "^[　 ]*";  
	    String regEndSpace = "[　 ]*$";  
	    String strDelSpace = studentId.replaceAll(regStartSpace, "").replaceAll(regEndSpace, "");  

		grade.setStudentId(strDelSpace);
		grade.setCourseId(request.getParameter("courseId_change"));
		grade.setScore(Integer.parseInt(request.getParameter("score_change")));
		teacherDao.updateGrade(grade);
		String id = request.getParameter("courseId_change");
		String courseName = request.getParameter("courseName_change");
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
