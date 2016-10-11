<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
<link rel="stylesheet" href="<c:url value='css/bootstrap.min.css' />" />
<link rel="stylesheet" href="<c:url value='css/main.css' />" />
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</head>
<body>
	<c:import url="/header.do"/>
	<div class="container">
		<div class="row">
			<div class="col-md-12" role="main">
				<div class="center-block" style="width: 600px;margin-bottom: 30px">
					<form class="center-block" action="${ctx }/dosignin.do" method="post">
						<ul class="list-unstyled">
						<li class="cent"><H2>欢迎登录</H2></li>
						<li class="cent"></li>
						<li  class="center-block">
						<span class="tit">用户名：</span>
						<span><input class="input-lg" id="name" name="name" type="text" placeholder="请输入用户名" size="30"/> </span>
						<span class="star">*</span>
						</li>
						<li  class="center-block">
						<span class="tit">密码：</span>
						<span><input class="input-lg" id="pass" name="pass" type="password" placeholder="请输入密码" size="30"/> </span>
						<span class="star">*</span>
						</li>
						<li  class="cent">
						<input class="input-lg" type="submit" value="登录" onclick="return check_signin();"/>
						</li>
						</ul>
					</form>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/jsp/footer.jsp" />
</body>
</html>