<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="entity.Teacher"%>

<%@ page import="java.util.List" %>
<%@ page import="VO.SearchGrade" %>

<!-- CSS goes in the document HEAD or added to your external stylesheet -->

<style type="text/css">
#hidden{
	dispaly:none;
}
</style>
<!DOCTYPE html>
<html>
        <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>  
	    <link rel="stylesheet" href="css/style.css">
        <title></title>
<script type="text/javascript">
         function f1(obj){
                var tmp = obj;
                //触发点击事件时，获取当前点击元素的祖先元素tr中第二个td的第一个input输入的值
                //parents()获取所有的祖先元素td/tr/table/div/div/body/html
                //parents("tr")指定tr元素
                //children("td").eq(1)子节点中的第二个td
                //find("input:first").val()第一个input标签的值
                var stuId = $(obj).parents("tr").children("td").eq(0).find("input:first").val();	
				$(document.getElementById("stuId_change")).attr("value",stuId);
            }
        
</script>
    </head>

    <body>
        
<button class="btn btn-primary btn-lg" onclick="javascript:window.history.back(-1);" >
   返回上一页
</button>
<!-- <form action="addGrade" method="post"><button type="submit"  name="add">新增学生成绩</button> </form> -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addModal">
    新增教师信息
</button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    新增教师信息 
                </h4>
            </div>
            <div class="modal-body">
<%--              <%
                String courseId=(String) session.getAttribute("courseId");
            	String courseName=(String) session.getAttribute("courseName");
						
			%> --%>	
			<form action="adminInsertTeacher" method="post">	
                	<div >
                		<label>教师工号</label>
                		<font color="red">*</font>
                		<input class="form-control required" type="text" placeholder="请输入学号" id="stuId" name="stuId" autofocus="autofocus" maxlength="20"/>                    
            		</div> 
            		<div >
                		<label>教师姓名</label>
                		<input class="form-control required" type="text" placeholder="请输入姓名" id="stuName" name="stuName" autofocus="autofocus" maxlength="20"/>                    
            		</div> 
            		<div>
                		<label>密码</label>
                		<font color="red">*</font>
                		<input class="form-control required" type="text" placeholder="请输入密码" id="password" name="password" autofocus="autofocus" maxlength="20"/>                    
            		</div> 
            </div>
            <div class="modal-footer">
                
               	
               	<button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
               		<button type="submit" class="btn btn-primary">
                   		提交更改
                	</button> 
               	</form>   
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
	<!-- 模态框（Modal） -->
<div class="modal fade" id="changeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    修改教师信息
                </h4>
            </div>
            <div class="modal-body">

			<form action="adminUpdateTeacher" method="post">	
                	<div >
                		<label>教师工号</label>
                		<font color="red">*</font>
                		<input class="form-control required" type="text" placeholder="请输入学号" id="stuId_change" name="stuId_change" readonly="readonly" autofocus="autofocus"  maxlength="20"/>                    
            		</div> 
            		<div >
                		<label>教师姓名</label>
                		<input class="form-control required" type="text" placeholder="请输入姓名" id="stuName_change" name="stuName_change" autofocus="autofocus" maxlength="20"/>                    
            		</div> 
            		<div>
                		<label>密码</label>
                		<font color="red">*</font>
                		<input class="form-control required" type="text" placeholder="请输入密码" id="password_change" name="password_change" autofocus="autofocus" maxlength="20"/>                    
            		</div> 
            </div>
            <div class="modal-footer">
                
               	
               	<button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
               		<button type="submit" class="btn btn-primary">
                   		提交更改
                	</button> 
               	</form>   
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
        <table  class="table table-striped table-bordered table-hover" >
            <tr  >
                <td>工号</td>
                <td>姓名</td>
                <td>密码</td> 
                <td>修改操作</td>
                <td>删除操作</td>
                 <%
                 
                 List<Teacher> teachers =(List<Teacher>) session.getAttribute("AdminListTeacher");
                int i = 0;
				for(Teacher teacher:teachers){
					
					%>
					<form action="adminDeleteTeacher" method="post"> 
					<tr id="tr<%= i%>">            
					<td ><input style='width:10vw; border-left:0px;border-top:0px;border-right:0px;border-bottom:0px;background-color:transparent; ' type="text" readonly="readonly" id="studentId_delete" name="studentId_delete" value="<%=teacher.getId()%>" /> </td>
                	<td><input style='width:10vw; border-left:0px;border-top:0px;border-right:0px;border-bottom:0px;background-color:transparent; ' type="text" readonly="readonly" id="studentName_delete" name="studentName_delete" value="<%=teacher.getName()%>" /> </td>
                	<td><input style='width:10vw; border-left:0px;border-top:0px;border-right:0px;border-bottom:0px;background-color:transparent; ' type="text" readonly="readonly"  id="courseName_delete" name="courseName_delete" value="<%=teacher.getPassword()%>" /> </td>
                	<td><button type="button"  name="change" data-toggle="modal" data-target="#changeModal" onclick="f1(this)">修改</button>  </td>
                	<td><button type="submit"  name="delete">删除</button>  </td>
                	</tr>
                	</form > 
				<%	
				i++;
				}
      			%>
            </tr>

        </table>

    </body>
   

</html>