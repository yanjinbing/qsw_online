<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>提示</title>
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
				<div class="center-block" style="margin-bottom: 30px">
					<ul class="list-unstyled">
						<li  class="cent"><H2>${message}</H2></li>
						<li  class="cent"></li>
						<li  class="cent"><a href="${linkUrl}">${linkText}</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/jsp/footer.jsp" />
</body>
</html>