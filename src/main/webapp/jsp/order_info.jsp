<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>下订单</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>
</head>

<body>

	<%@ include file="/jsp/header.jsp"%>


	<div class="container">

		<form id="orderForm" method="post" action="${pageContext.request.contextPath}/OrderServlet?method=payOrder">
			<div class="row">

				<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
					<strong>订单详情</strong>
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th colspan="5">订单编号:${order.oid}</th>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
							<c:forEach items="${order.orderItems}" var="item">
								<tr class="active">
									<td width="60" width="40%"><input type="hidden" name="id" value="22"> <img src="${pageContext.request.contextPath}/${item.product.pimage}" width="70" height="60"></td>
									<td width="30%"><a target="_blank">${item.product.pname}</a></td>
									<td width="20%">￥${item.product.shopprice}</td>
									<td width="10%">${item.quantity}</td>
									<td width="15%"><span class="subtotal">￥${item.total}</span></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div style="text-align: right; margin-right: 120px;">
					商品金额: <strong style="color: #ff6600;">￥${order.total}元</strong>
				</div>

			</div>
			<hr>
			<div>
				<div>
					<ul class="nav nav-tabs">
						<li role="presentation" class="active"><a >请输入以下信息，方便您接收商品</a></li>
						<br>
						<br>
						<br>
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1">联系电话</span> <input type="text" class="form-control" aria-describedby="basic-addon1">
						</div>
						<br>
						<div class="input-group">
							<input type="text" class="form-control" aria-describedby="basic-addon2"> <span class="input-group-addon" id="basic-addon2">地址</span>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">收货人</span> <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
						</div>
						<br>
					</ul>
				</div>
				<div style="margin-top: 5px; margin-left: 150px;">
					<strong>选择银行：</strong>
					<p>
						<br /> <input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked" />工商银行 <img src="${pageContext.request.contextPath}/img/bank_img/icbc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="pd_FrpId" value="BOC-NET-B2C" />中国银行 <img src="${pageContext.request.contextPath}/img/bank_img/bc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="pd_FrpId" value="ABC-NET-B2C" />农业银行 <img src="${pageContext.request.contextPath}/img/bank_img/abc.bmp" align="middle" /> <br /> <br /> <input type="radio" name="pd_FrpId" value="BOCO-NET-B2C" />交通银行 <img src="${pageContext.request.contextPath}/img/bank_img/bcc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="pd_FrpId" value="PINGANBANK-NET" />平安银行 <img src="${pageContext.request.contextPath}/img/bank_img/pingan.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="pd_FrpId" value="CCB-NET-B2C" />建设银行 <img src="${pageContext.request.contextPath}/img/bank_img/ccb.bmp" align="middle" /> <br /> <br /> <input type="radio" name="pd_FrpId" value="CEB-NET-B2C" />光大银行 <img src="${pageContext.request.contextPath}/img/bank_img/guangda.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C" />招商银行 <img src="${pageContext.request.contextPath}/img/bank_img/cmb.bmp" align="middle" />

					</p>
					<hr />
					<p style="text-align: right; margin-right: 100px;">
						<a href="javascript:document.getElementById('orderForm').submit();"> <img src="${pageContext.request.contextPath}/img/finalbutton.gif" width="204" height="51" border="0" />
						</a>
					</p>
					<hr />

				</div>
			</div>
		</form>
	</div>
	<%@ include file="/jsp/footer.jsp"%>
</body>
</html>