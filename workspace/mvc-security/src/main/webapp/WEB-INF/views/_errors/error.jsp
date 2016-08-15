<%@ include file="/WEB-INF/views/_taglibs.jspf" %>
<h1><fmt:message key="error.title" /></h1>
<p><fmt:message key="error.message" /></p>

<!--
Failed URL: ${url}
Exception:  ${exception.message}
<c:forEach items="${exception.stackTrace}" var="ste">
${ste} 
</c:forEach>
-->

<%-- http://docs.spring.io/autorepo/docs/spring-security/4.0.3.RELEASE/apidocs/org/springframework/security/web/access/AccessDeniedHandlerImpl.html --%>