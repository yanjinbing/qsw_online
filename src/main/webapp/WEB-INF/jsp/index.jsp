<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>支持全文检索的在线阅读系统</title>
<link rel="stylesheet" href="<c:url value='css/bootstrap.min.css' />" />
<link rel="stylesheet" href="<c:url value='css/main.css' />" />
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<style>

em{
	font-style: normal;
	color: red;
}

.search-result {
	font-family: "Microsoft yahei";
	letter-spacing: 0.1em;
	color: #484848;
	word-wrap: break-word;
}
.list-group-item{
	padding:5px 15px
}
.col-md-3{
	width:20%
}
.col-md-9{
	width:80%
}
select.input-lg,.input-lg{
	height:36px;
	padding: 5px 16px
}

.author-list span{
padding-right: 10px;
padding-bottom: 10px;
}

</style>
</head>
<body>
	<c:import url="/header.do"></c:import>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<a href="${ctx }/index.do">全宋文</a>册列表		
				<div class="list-group">
				<c:forEach var="i" begin="0" end="44" step="1">
					<a href="${ctx}/index.do?id=${i}" class="list-group-item <c:if test='${param.id==i}'>active</c:if>">第${f:formatNumber(i*8+1)}册--第${f:formatNumber(i*8+8)}册</a>
				</c:forEach>
				</div>
			</div>
			<div class="col-md-9" role="main">
			
				<div class="center-block" style="width: 600px;margin-bottom: 30px">
					<form class="center-block" action="${ctx }/search.do">
						<select class="input-lg"  name="fl">
							<option value="all">全部</option>
							<option value="authors">作者</option>
							<option value="title">标题</option>
							<option value="data">正文</option>
						</select> 
						<input class="input-lg" name="v" type="text" placeholder="输入检索词" size="30" value="${param.v}"/> 
						<INPUT type="hidden" name="s" value="0" /> 
						<INPUT type="hidden" name="c" value="10" /> 
						<input class="input-lg" type="submit" value="搜索" />
					</form>
				</div>
				<div>
					<c:forEach var="book" items="${docs }">
						<h4><a href="${ctx}/detail.do?id=${book.volumeNO}">${book.name }</a></h4>
						<ul class="nav nav-pills">
						<c:forEach var="author" items="${book.authors }">
							<li><a href="${ctx}/detail.do?id=${author.volumeNO}#${fn:replace(author.Identifier, ':', '') }">${author.authors}</a></li>
						</c:forEach>
						</ul>
						<hr />
					</c:forEach>
				</div>

			</div>
			
		</div>
		

	</div>
	<c:import url="/WEB-INF/jsp/footer.jsp" />

</body>
</html>