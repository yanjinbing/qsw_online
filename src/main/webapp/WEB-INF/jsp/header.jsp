
<nav class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div style="float:right">
		<div>
		<c:choose>
  			<c:when test="${username != null}"> 
  			<span>欢迎${username}</span>
  			<span class="space"><a href="signout.do">退出</a></span>
   			</c:when>  
   			<c:otherwise>
   			<span><a href="signin.do">登录</a></span>
   			</c:otherwise>  
		</c:choose>
		<span  class="space"><a href="signup.do">注册</a></span>
		<c:choose>  
  			<c:when test="${username != null}"> 
  			<span class="space"><a href="buy.do">购买服务</a></span>
   			</c:when>  
   			<c:otherwise>
   			<span></span>
   			</c:otherwise>  
		</c:choose>  
		
		</div>
		</div>
		<div class="masthead">
			<h1 class="muted">在线阅读系统<a href="${ctx }/index.do" style="font-size:14px">《全宋文》库</a></h1>
		</div>
	</div>
</nav>