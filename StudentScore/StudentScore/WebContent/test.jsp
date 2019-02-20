<%@page import="entity.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="VO.SearchGrade" %>

<!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
table.hovertable {
font-family: verdana,arial,sans-serif;
font-size:11px;
color:#333333;
border-width: 1px;
border-color: #999999;
border-collapse: collapse;
}
table.hovertable th {
background-color:#c3dde0;
border-width: 1px;
padding: 8px;
border-style: solid;
border-color: #a9c6c9;
}
table.hovertable tr {
background-color:#d4e3e5;
}
table.hovertable td {
border-width: 1px;
padding: 8px;
border-style: solid;
border-color: #a9c6c9;
}
</style>
	<script>


	function load(id) {
		window.location.href='teacherSearch?id='+id;
	}
    </script>
<!DOCTYPE html>
<html>
        <head>
        <meta charset="UTF-8">
        <title></title>
    </head>

    <body>
        
<input type="button" name="Submit" value="返回上一页" onclick="javascript:window.history.back(-1);">
        <table  class="hovertable" >
            <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';" >
                <td>姓名</td>
                <td>课程名称 </td>
                <td>任课教师</td> 
                <td>分数</td>
                 <%
                 
                 List<SearchGrade> grades =(List<SearchGrade>) session.getAttribute("grades");
				for(SearchGrade searchGrade:grades){
					
					%>
					<tr   onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">            
					<td><%= searchGrade.getStudentName()%></td>
                	<td><%= searchGrade.getCourseName()%> </td>
                	<td><%= searchGrade.getTeacherName()%></td> 
                	<td><%= searchGrade.getScore()%></td>
                	</tr>
				<%	
				}
      			%>
            </tr>

        </table>
<%--          <table  class="hovertable" >
            <tr  >
                <td>课程编号 </td>
                <td>课程名称 </td>

                 <%
                 
                 List<Course> courseName =( List<Course>) session.getAttribute("courseName");
				for(Course course:courseName){
					
					%>
					<tr   onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';" onclick="load('<%= course.getId()%>')">    
					<td><%= course.getId()%></td>
                	<td><%= course.getName()%> </td>

                	</tr>
				<%	
				}
      			%>
            </tr>

        </table> --%>

    </body>
   

</html>