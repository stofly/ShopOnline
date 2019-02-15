<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>买了么商城</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
</head>

<body>
	<div class="container-fluid">
		<%@include file="/jsp/header.jsp"%>
		<!--
            	描述：轮播条
            -->
		<div class="container-fluid">
			<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="${pageContext.request.contextPath}/img/ad/1.jpg">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img src="${pageContext.request.contextPath}/img/ad/2.jpg">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img src="${pageContext.request.contextPath}/img/ad/3.jpg">
						<div class="carousel-caption"></div>
					</div>
				</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> <span class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<!--

            	描述：商品显示
            -->
		<div class="container-fluid">
			<div class="col-md-12">
				<h2>
					热门商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg" />
				</h2>
			</div>
			<div class="col-md-2" style="border: 1px solid #E7E7E7; border-right: 0; padding: 0;">
				<img src="products/hao/big01.jpg" width="205" height="404" style="display: inline-block;" />
			</div>
			<div class="col-md-10">
				<c:forEach items="${hotProduct}" var="hot">
					<div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
						<a href="${pageContext.request.contextPath}/productAction_findProductById.action?pid=${hot.pid}"> <img src="${pageContext.request.contextPath}/${hot.pimage}" width="130" height="130" style="display: inline-block;">
						</a>
						<p>
							<a href="product_info.html" style='color: #666'>${hot.pname}</a>
						</p>
						<p>
							<font color="#E4393C" style="font-size: 16px">&yen;${hot.shopprice}</font>
						</p>
					</div>
				</c:forEach>
			</div>
		</div>
		<br>
		<!--

            	描述：广告部分
            -->
		<div class="container-fluid">
			<img src="products/hao/ad.jpg" width="100%" />
		</div>
		<!--

            	描述：商品显示
            -->
		<div class="container-fluid">
			<div class="col-md-12">
				<h2>
					最新商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg" />
				</h2>
			</div>
			<div class="col-md-2" style="border: 1px solid #E7E7E7; border-right: 0; padding: 0;">
				<img src="products/hao/big01.jpg" width="205" height="404" style="display: inline-block;" />
			</div>
			<div class="col-md-10">
				<c:forEach items="${newProduct}" var="n">
					<div class="col-md-2" style="text-align: center; height: 200px; padding: 10px 0px;">
						<a href="${pageContext.request.contextPath}/productAction_findProductById.action?pid=${n.pid}""> <img src="${pageContext.request.contextPath}/${n.pimage}" width="130" height="130" style="display: inline-block;">
						</a>
						<p>
							<a href="product_info.html" style='color: #666'>${n.pname}</a>
						</p>
						<p>
							<font color="#E4393C" style="font-size: 16px">&yen;${n.shopprice}</font>
						</p>
					</div>
				</c:forEach>
			</div>
		</div>

		<!--
            	描述：页脚部分
            -->
		<%@include file="/jsp/footer.jsp"%>
	</div>
</body>

</html>