<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
		<script type="text/javascript" src="stc/jquery.min.js"></script>
		
	</head> 
	<body>
		<c:url value="/showMessage.html" var="messageUrl" />
		<a href="${messageUrl}">Click to enter</a>
		<div class="gen">gen</div>
		<script type="text/javascript" >
			var d = $("a");
			
			$(".gen").click(function(){
				
				$.post("/dailyAnalysis/ge"
						,{name:"CBC"}
						,function(data){
							
						}
						);
				
			});
		</script>
	</body>
</html>
