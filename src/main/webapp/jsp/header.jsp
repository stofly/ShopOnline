<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<!--
            	描述：菜单栏
            -->
	<div class="container-fluid">
		<div class="col-md-4">
			<img src="${pageContext.request.contextPath}/img/logo2.png" />
		</div>
		<div class="col-md-5">
			<img src="${pageContext.request.contextPath}/img/header.png" />
		</div>
		<div class="col-md-3" style="padding-top: 20px">
			<ol class="list-inline">
				<c:if test="${empty user}">
					<li><a href="${pageContext.request.contextPath}/uiAction_login.action">登录</a></li>
					<li><a href="${pageContext.request.contextPath}/uiAction_rejester.action">注册</a></li>
				</c:if>
				<c:if test="${not empty user}">
					<li>欢迎${user.name}</li>
					<li><a href="${pageContext.request.contextPath}/jsp/cart.jsp">购物车</a></li>
					<li><a href="${pageContext.request.contextPath}/orderAction_findOrderByCidAndPage?num=1">我的订单</a></li>
					<li><a href="${pageContext.request.contextPath}/userAction_logout.action">安全退出</a></li>
				</c:if>
			</ol>
		</div>
	</div>
	<!--
            	描述：导航条
            -->
	<div class="container-fluid">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="${pageContext.request.contextPath}/">首页</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav" id="category">
					</ul>
					<form class="navbar-form navbar-right" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>

				</div>
			</div>
		</nav>
	</div>
</body>
<script type="text/javascript">
	$(function($) {
		$.post(
			"/ShoppingOnline/categoryAction_findAllCategorys.action",
				function(data) {
				$.each(data,function(i, obj) {
					var li = "<li><a href='${pageContext.request.contextPath}/productAction_findProductByCidAndPage?num=1&cid="
						+ obj.cid
						+ "'>"
						+ obj.cname
						+ "</a></li>"
						$("#category").append(li);
					});
			});
	});
</script>
</html>