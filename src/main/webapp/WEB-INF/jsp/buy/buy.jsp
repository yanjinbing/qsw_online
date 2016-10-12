<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购买服务</title>
<link rel="stylesheet" href="<c:url value='css/bootstrap.min.css' />" />
<link rel="stylesheet" href="<c:url value='css/main.css' />" />
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</head>
<body>
	<c:import url="/header.do"/>
	<div class="container">
		<div class="row">
			<div class="col-md-6"  role="main">
				<div style="width:500px; margin-bottom:30px; float:right;">
					<ul>
						<li class="cent"><H2>服务购买</H2></li>
						<li class="cent"></li>
						<li  class="center-block">
						<span class="tit">服务名称：</span>
						<span>VIP包年服务</span>
						</li>
						<li  class="center-block">
						<span class="tit">服务内容：</span>
						<span>服务期内可随意阅读本网站内全部资源。</span>
						</li>
						<li  class="center-block">
						<span class="tit">服务期限：</span>
						<span>1年</span>
						</li>
						<li  class="center-block">
						<span class="tit">价格：</span>
						<span>20元</span>
						</li>
						<li  class="center-block">
						<span class="tit">支付方式：</span>
						<span>支付宝</span>
						</li>
					</ul>
				</div>
		</div>
		<div class="col-md-6" role="main">
			<div style="width:250px; margin-top:80px; float:left;">
				<IMG alt="使用支付宝扫一扫进行支付" src="images/pay.png" />
			</div>
		</div>
		
		</div>
		<div class="row">
			<form class="center-block" action="${ctx }/dobuy.do" method="post">
			<div align=center>
				<input class="input-lg" type="submit"  value="确认支付完成" />
			</div>
			</form>
		</div>
	</div>
	<c:import url="/WEB-INF/jsp/footer.jsp" />

</body>
</html>