<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="js/jquery-1.7.2.min.js"></script>
</head>
<body>
	<form id="myForm">
		用户名称：<input type="text" name="username">
		<br><br>
		用户密码：<input type="text" name="password">
		<br><br>
		用户性别：<input type="text" name="sex">
		<br><br>
		<button id="btn">提交</button>	
	</form>
</body>
</html>
<script>
   $(function(){
	   $("#btn").click(function (){
		   $.ajax({
				  url:"userServlet",
				  type:"GET",
				  data:$("#myForm").serialize(),
				  success:function(data){
					alert("success"+data);  
				  },
			      error:function(data){
					alert("error"+data);  
				  }
			  })
	   })
	  
   });

</script>