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


<!DOCTYPE html>
<html>
        <head>
        <meta charset="UTF-8">
        <title></title>
    </head>

    <body>
<input type="button" name="Submit" value="返回上一页" onclick="javascript:window.history.back(-1);">
         <table  class="hovertable" >
            <tr  >
                <td>课程编号 </td>
                <td>课程名称 </td>
				<td>操作 </td>
                 <%
                 
                 List<Course> courseName =( List<Course>) session.getAttribute("courseName");
				for(Course course:courseName){
					int i = 0;
					%>
					
					<tr   onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';" >   
					<form action="teacherSearch" method="post">  
					<td ><input style='border-left:0px;border-top:0px;border-right:0px;border-bottom:0px;background-color:transparent; ' class="form-control required" type="text" readonly="readonly" id="courseId_teacher" name="courseId_teacher" value="<%= course.getId() %>" /> </td>
                	<td ><input style='border-left:0px;border-top:0px;border-right:0px;border-bottom:0px;background-color:transparent; ' class="form-control required" type="text" readonly="readonly" id="courseName_teacher" name="courseName_teacher" value="<%= course.getId() %>" /> </td>
					<td><button type="submit" class="btn btn-success pull-right" name="submit">查看详细</button> </td>
					</form >
                	</tr>
                	 
				<%	
				}
      			%>
            </tr>

        </table>

    </body>
   

</html>