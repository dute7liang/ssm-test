<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
</head>
<body>
	<div>
		<input type="text" name="userName" id = "userName">
	</div>
	<div>
		<input type="password" name="passWord" id = "passWord">
	</div>
	<div>
		<button id="goProject">开始</button>
	</div>
</body>
</html>
<script type="text/javascript">
	var context = '${pageContext.request.contextPath}';
	$(function(){
		$("#goProject").click(function(){
			console.log("点击了登入");
			var url = context + "/user/login";
			$.ajax({
				type : 'POST',
				url : url,
				data : {
					userName : $("#userName").val(),
					passWord : $("#passWord").val()
				},
				dataType : 'JSON',
				success : function(data){
					console.log(data);
					if(data.success){
						console.log("登入成功！跳转页面！");
						window.location.href=context + '/table/manager';
					}else{
						console.log("登入失败！");
					}
				}
			});
			
		})
	})	





</script>