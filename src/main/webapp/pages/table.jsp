<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
</head>
<body>
	<div >
		<button id = "goout">退出</button>
	</div>
	<table id = "table">
		<tr>
			<th>名称</th>
			<th>int</th>
			<th>date</th>
			<th>double</th>
			<th>varchar</th>
		</tr>
	</table>
</body>
</html>
<script type="text/javascript">
	var context = '${pageContext.request.contextPath}';
	$(function(){
		$(function(){
			$.ajax({
				url : context + "/table/dataGrid",
				type : "post",
				dataType : "json",
				success : function(data){
					console.log(data);
					var html = "";
					for (var int = 0; int < data.length; int++) {
						html += 
						'<tr>'+
							'<th>'+data[int].name+'</th>'+
							'<th>'+data[int].age+'</th>'+
							'<th>'+data[int].birthDay+'</th>'+
							'<th>'+data[int].grade+'</th>'+
							'<th>'+data[int].clas+'</th>'+
						'</tr>';
					}
					$("#table").append(html);
					if(data.success){
						window.location.href = context + "/user/gogo";
					}else{
					}
				}
			});
			
			$("#goout").click(function(){
				window.location.href = context + "/user/logout";
				/* $.ajax({
					url : context + "/user/logout",
					type : "post",
					dataType : "json",
					success : function(data){
						if(data.success){
							console.log("登出成功");
							window.location.href = context + "/user/gogo";
						}else{
							console.log("登出失败");
						}
						
						
					}
				}) */
			});
			
			
			
			
			
		})
	})	





</script>