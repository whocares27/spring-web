<%@ include file="/WEB-INF/views/_taglibs.jspf"
%><!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title><fmt:message><tiles:insertAttribute name="title"/></fmt:message> - RewardsOnline</title>
	<link href="<c:url value="/images/onb_logo_tiny.ico" />" rel="icon" type="image/png" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" />" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/styles/main.css" />" />
	<spring:theme var="cssUrl" code="css.bootstrap" />
	<link type="text/css" rel="stylesheet" href="<c:url value="${cssUrl}" />" />
</head>
<body>
<body>
	<nav id="navbar-header" class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">RewardsOnline</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<tiles:importAttribute name="navigationTab" />
				<ul class="nav navbar-nav">
					<li class="${navigationTab eq 'home' ? 'active' : ''}"><a href="<c:url value="/" />"><fmt:message key="navigate.home" /></a></li>
					<li class="${navigationTab eq 'accounts' ? 'active' : ''}"><a href="<c:url value="/accounts" />"><fmt:message key="navigate.accounts" /></a></li>
					<security:authorize access="isAuthenticated()"><li class=""><a href="<c:url value="/logout" />"><fmt:message key="navigate.logout"/></a></li></security:authorize>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li>
					<c:choose>
						<c:when test="${requestContext.locale.language eq 'en'}">
							<c:url var="localeUrl" value="">
								<c:param name="locale" value="fr"/>
							</c:url>
							<a href="${localeUrl}">Fran�ais</a>
						</c:when>
						<c:otherwise>
							<c:url var="localeUrl" value="">
								<c:param name="locale" value="en"/>
							</c:url>
							<a href="${localeUrl}">English</a>
						</c:otherwise>
					</c:choose>
					</li>
					<li>
					<c:choose>
						<c:when test="${requestContext.theme.name eq 'orange'}">
							<c:url var="themeUrl" value="">
								<c:param name="theme" value="blue"/>
							</c:url>
							<a href="${themeUrl}"><fmt:message key="theme.Blue"/></a>
						</c:when>
						<c:otherwise>
							<c:url var="themeUrl" value="">
								<c:param name="theme" value="orange"/>
							</c:url>
							<a href="${themeUrl}"><fmt:message key="theme.Orange"/></a>
						</c:otherwise>
					</c:choose>
					</li>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<tiles:insertAttribute name="main" />
	</div>
	<footer id="footer" class="footer">
		<div class="container">
			<p class="text-muted"><fmt:message key="footer.message"/></p>
		</div>
    </footer>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/webjars/jquery/1.11.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
