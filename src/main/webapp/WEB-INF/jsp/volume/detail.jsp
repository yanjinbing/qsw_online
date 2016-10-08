<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>支持全文检索的在线阅读系统</title>
<link rel="stylesheet" href="<c:url value='css/bootstrap.min.css' />" />
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<style>

.content p {
	font-family: "Microsoft yahei";
	line-height: 1.8em;
	letter-spacing: 0.1em;
	font-size: 18px;
	color: #484848;
	word-wrap: break-word;
	text-indent: 2em;
}

.content_header {
	background-color: beige;
	padding-top: 10px;
	padding-bottom: 10px;
}
ul.nav-pills.affix {
	top: 0px; /* Set the top position of pinned element */
}
ul.nav-pills {
	width: 260px;
}
.nav li a{
	padding:2px 10px;	
	overflow:hidden; text-overflow:ellipsis; white-space:nowrap;
}
</style>
</head>
<body data-spy="scroll" data-target=".scrollspy">
	<c:import url="/header.do" />
	<div class="container content">
		<div class="row">
			<div class="col-md-9" role="main">
				<div class="row content_header">
					<div class="col-md-4"><a href="${ctx }/index.do">全宋文</a>${docs[0].publication}</div>
					<div class="col-md-3 text-center">${docs[0].volume }</div>
					<div class="col-md-5 text-right">
						<c:if test="${docs[0].volumeNO > 1}">上一卷：
							<a href="${ctx}/detail.do?id=${docs[0].volumeNO-1}">卷 ${f:formatNumber(docs[0].volumeNO-1)} </a>
						</c:if>
						|
						<c:if test="${docs[0].volumeNO < 8345}">下一卷：
							<a href="${ctx}/detail.do?id=${docs[0].volumeNO+1}">卷 ${f:formatNumber(docs[0].volumeNO+1)}</a>
						</c:if>
					</div>
				</div>
				<c:forEach var="volume" items="${docs }">
					<div class="bs-docs-section">
						<h3 id="${fn:replace(volume.Identifier, ':', '')}">
							<b><a href="/FlexPaper/common/split_document.jsp?doc=002.pdf" target="flexPaper">${volume.title}</a></b>
						</h3>
						<p>${f:formatHTML(volume.data, "<p>")}</p>
						<hr />
					</div>
				</c:forEach>
				<div class="row text_header">
					<div class="col-md-4">${docs[0].publication}</div>
					<div class="col-md-4 text-center">${docs[0].volume }</div>
					<div class="col-md-4 text-right">
						<c:if test="${docs[0].volumeNO > 1}">上一卷：
							<a href="${ctx}/detail.do?id=${docs[0].volumeNO-1}">卷 ${f:formatNumber(docs[0].volumeNO-1)} </a>
						</c:if>
						|
						<c:if test="${docs[0].volumeNO < 8345}">下一卷：
							<a href="${ctx}/detail.do?id=${docs[0].volumeNO+1}">卷 ${f:formatNumber(docs[0].volumeNO+1)}</a>
						</c:if>
					</div>
				</div>
			</div>
			<div class="col-md-3 scrollspy">			
				<ul class="nav nav-pills nav-stacked " data-spy="affix" data-offset-top="100">
					<li><b>目录</b></li>
					<c:forEach var="volume" items="${docs }">
						<li ><a href="#${fn:replace(volume.Identifier, ':', '') }">${volume.title}</a></li> 
					</c:forEach>
				</ul>
			</div>
		</div>		
	</div>
	<c:import url="/WEB-INF/jsp/footer.jsp" />
</body>
</html>