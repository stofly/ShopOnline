<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>关于我们</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
</head>

<body>
	<%@include file="/jsp/header.jsp"%>
	<div class="container">
		<div class="container">
			<div class="main_con">
				<h1 style="text-align: center;">买了么客服为您提示：</h1>
				<br>
				<h3 style="text-align: center;">${msg}</h3>
				<br> <br> <br> <br> <br> <br> <br> <br> <br> <br>
			</div>
		</div>
	</div>
	<%@include file="/jsp/footer.jsp"%>
</body>
</html>