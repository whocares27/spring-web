<%@ include file="/WEB-INF/views/_taglibs.jspf" %>
<h1>Error Page</h1>
<p>Application has encountered an error. Please contact support on ...</p>
    
<!--
Failed URL: ${url}
Exception:  ${exception.message}
    <c:forEach items="${exception.stackTrace}" var="ste">    ${ste} 
</c:forEach>
-->

<%-- http://docs.spring.io/autorepo/docs/spring-security/4.0.3.RELEASE/apidocs/org/springframework/security/web/access/AccessDeniedHandlerImpl.html --%>