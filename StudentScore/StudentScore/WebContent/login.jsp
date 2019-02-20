<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
System.out.println("path:"+path);
System.out.println("basepath:"+basePath);

%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>"> 
    <title>学生成绩系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="user/login/css/base.css" type="text/css" media="screen">
    <link rel="stylesheet" href="user/login/css/page.css" type="text/css" media="screen">
    <link rel="stylesheet" type="text/css" href="user/login/css/jquery.alerts.css">
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
    </script>
    <style>
        a.back {
            background-color: #ff8a00;
            margin-left: 10px;
        }

            a.back:hover {
                background-color: #ffa740;
            }

        .loginWrap ul li.inpbox input {
            border: 0;
            background-color: #fff;
            height: 15px;
            line-height: 15px;
            width: 110px;
            padding: 5px;
            font-size: 16px;
            font-family: "Microsoft JhengHei";
            color: #777;
        }

        .loginWrap ul li .NoCode {
            float: left;
            display: inline;
            width: 119px;
            height: 33px;
            line-height: 33px;
            text-align: center;
            background-color: #C3C3BC;
            color: #fff;
        }
    </style>
    <script type="text/javascript">
/* $(function(){
	var mainWidth =document.getElementById('main').clientWidth;
	var floatWidth=document.getElementById('float_window').style.width.split('px')[0];
	document.getElementById('float_window').style.left=mainWidth-floatWidth-20+'px';

}); */
     //获取参数值
      function query(name){
      var sUrl = window.location.search.substr(1);
      var r = sUrl.match(new RegExp("(^|&)" + name + "=([^&]*)(&|$)"));
      return (r == null ? null : (r[2]));
      }
    </script>

    <script>
function getvalue(){
	var type = $('input[name="type"]:checked').val();
	if(type=="ls"){
		$("#namebox").html("<span></span><input type='text' id='username' name='username'  placeholder='请输入用户名'	 style='width:183px;'>");
		$("#pwdbox").html("<span></span><input type='password' id='password' name='password'	placeholder='请输入密码' style='width:183px;'>");
	}else if(type=="dsr_zrr"){
		$("#namebox").html("<span></span><input type='text' id='username' name='username'  placeholder='请输入行政用户名'	 style='width:183px;'>");
		$("#pwdbox").html("<span></span><input type='password' id='password' name='password'	placeholder='请输入密码' style='width:183px;'>");
	}else if(type=="dsr_zzjg"){
		$("#namebox").html("<span></span><input type='text' id='username' name='username'  placeholder='请输入管理员账号'	 style='width:183px;'>");
		$("#pwdbox").html("<span></span><input type='password' id='password' name='password'	placeholder='请输入密码' style='width:183px;'>");
	}

}

//去掉左右空格
function trim_(theValue){
	var retn = theValue;
	retn = retn.replace(/^\s*/g,"");
	retn = retn.replace(/\s*$/g,"");
	return retn;
}
function login() {
    var type = $('input[name="type"]:checked').val();
    var username = $("#username").val();
    var password = $("#password").val();

    if (username == "") {
        alert("用户名不能为空");
        //$("#username").focus();
    }else if (password == "") {
        alert("密码不能为空");
        //$("#password").focus();
    }

}

function logout() {
   
}
    </script>
</head>
<body>
	<%
	String key = (String)session.getAttribute("key");
	if(key == "no"&&key != null){
		out.print("<script> alert('登录失败'); </script>");	
	}
	session.removeAttribute("key");
	%>

    <div id="header">
        <div class="wrap">
            <a class="f-fl logo"  title="学生成绩系统"><img  alt="学生成绩系统"></a>
           
        </div>
    </div>
 
    <div id="main">
        <div class="loginmain">
            <div class="loginWrap">
                <form action="login" method="post">
                    <ul class="f-fr">
                        <li class="type" style="text-align: left;">
                            <label><input type="radio" name="type" id="student" value="student" checked onclick="getvalue()">学生</label>
                            <label><input type="radio" name="type" id="teacher" value="teacher" onclick="getvalue()">教师</label>
                            <label><input type="radio" name="type" id="dsr_zzjg" value="dsr_zzjg" onclick="getvalue()">教务管理人员</label>
                        </li>
                        <li class="namebox" id="namebox"><span></span><input type="text" id="username" name="username" placeholder="请输入用户帐号" style="width:183px;"></li>
                        <li class="pwdbox" id="pwdbox"><span></span><input type="password" id="password" name="password" placeholder='请输入密码' style="width:183px;"></li>
                        <li><input type="submit" onclick="login();" value="登录" class="loginBtn" /></li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
    
    

</body>
</html>
