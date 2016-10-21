<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
<link rel="stylesheet" href="<c:url value='css/bootstrap.min.css' />" />
<link rel="stylesheet" href="<c:url value='css/main.css' />" />
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
<style>
.brief {
	font-family: "Microsoft yahei";
	line-height: 1.8em;
	letter-spacing: 0.1em;
	font-size: 20px;
	color: #484848;
	word-wrap: break-word;
	text-indent: 2em;
	margin: 50px 30px;
}
.login{
	border-left: thin solid;
}
</style>
</head>
<body>
	<c:import url="/header.do" />
	<div class="container">
		<div class="row">
			<div class="col-md-6">
			<p class="brief">《全宋文》是一部包含两宋320年间所有现存单篇散文、骈文、诗词以外的韵文的大型断代总集，更是目前已经出版的规模最大的文学总集。《全宋文》分15个大类，共360册，17万余篇各种体例文章，总字数逾1亿字，内容遍及文学、艺术、历史、哲学等各个方面。</p>
			</div>
			<div class="col-md-6 login" role="main">
				<div class="center-block" style="width: 600px; margin-bottom: 30px">
					<form class="center-block" action="${ctx }/dosignin.do" method="post">
						<ul class="list-unstyled">
							<li class="cent"><H2>欢迎登录</H2></li>
							<li class="cent"></li>
							<li class="center-block"><span class="tit">用户名：</span> <span><input class="input-lg" id="name"
									name="name" type="text" placeholder="请输入用户名" size="30" /> </span> <span class="star">*</span></li>
							<li class="center-block"><span class="tit">密码：</span> <span><input class="input-lg" id="pass"
									name="pass" type="password" placeholder="请输入密码" size="30" /> </span> <span class="star">*</span></li>
							<li class="cent"><input class="input-lg" type="submit" value="登录" onclick="return check_signin();" /></li>
						</ul>
					</form>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/jsp/footer.jsp" />
</body>
</html>