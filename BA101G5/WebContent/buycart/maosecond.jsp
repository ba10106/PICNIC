<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.goods_sell.model.*"%>

<jsp:useBean id="goods_sellSvc" scope="page"
	class="com.goods_sell.model.Goods_SellService" />

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Title Page</title>
<jsp:include page="/mustinclude/head.jsp" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<!--[if lt IE 9]>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->

<style>
.collapse {
	margin: -15px;
}

.list-group {
	margin-top: 15px;
}
</style>
</head>
<body>
	<jsp:include page="/mustinclude/left_nav.jsp" />
	<jsp:include page="/mustinclude/top_nav.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-sm-11 cal-sm-push-1">
				<div class="collapse navbar-collapse navbar-ex1-collapse">
					<ul class="nav navbar-nav side-nav">
						<li><a href="#">
							<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/goods_sell/goods_sell.do"onclick="submit()">
								<p>食物</p> 
								<input type="hidden" name="deptno" value="food"> 
								<input type="hidden"name="action" value="Goods_Sell_ByMF_A">

							</FORM>
							</a>
						</li>
							<li><a href="#">
							<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/goods_sell/goods_sell.do"onclick="submit()">
								<p>野餐器具</p> 
								<input type="hidden" name="deptno" value="food"> 
								<input type="hidden"name="action" value="Goods_Sell_ByMF_B">

							</FORM>
							</a>
						</li>
							<li><a href="#">
							<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/goods_sell/goods_sell.do"onclick="submit()">
								<p>防曬</p> 
								<input type="hidden" name="deptno" value="food"> 
								<input type="hidden"name="action" value="Goods_Sell_ByMF_C">

							</FORM>
							</a>
						</li>
							<li><a href="#">
							<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/goods_sell/goods_sell.do"onclick="submit()">
								<p>其他</p> 
								<input type="hidden" name="deptno" value="food"> 
								<input type="hidden"name="action" value="Goods_Sell_ByMF_D">

							</FORM>
							</a>
						</li>
						
					</ul>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-11 ">
				<div class="col-sm-2 ">
					<ul class="list-group">
						<li class="list-group-item">aeu</li>
						<li class="list-group-item">aeou</li>
						<li class="list-group-item">aeou</li>
						<li class="list-group-item">aeou</li>
						<li class="list-group-item">aeou</li>
						<li class="list-group-item">aeou</li>
						<li class="list-group-item">aoeu</li>
					</ul>
				</div>
				<div class="col-sm-10 ">
					<c:forEach var="goods_sellVO" items="${goods_sellSvc.getAll()}">
						<div class="col-sm-4 ">
							<div class="thumbnail">
								<img
									src="${request.getContextPath()}/images/${goods_sellVO.getGs_name()}.jpg"
									alt="">

								<div class="caption">
									<h2>${goods_sellVO.getGs_name()}</h2>
									<p>${goods_sellVO.getGs_price()}</p>
									<p>
										<a href="<%=request.getContextPath()%>/buycart/maothird.jsp"
											class="btn btn-default">${goods_sellVO.getGs_price()}</a> <a
											href="#" class="btn btn-default btn-xs"><span
											class="glyphicon glyphicon-shopping-cart"></span></a>
									</p>
								</div>
							</div>
						</div>



					</c:forEach>
				</div>
			</div>
		</div>

		<div class="row ">
			<div class="col-sm-11 col-sm-push-1 ">
				<div class="btn-group btn-group-justified ">
					<a href="# " class="btn btn-default " role="button ">aoeu</a>
				</div>
				<div class="col-sm-11 col-sm-push-3 ">
					<jsp:include page="/mustinclude/footer.jsp" />
				</div>
			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>