<%--
  Created by IntelliJ IDEA.
  User: jianf
  Date: 2020/7/4
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>/WEB-INF/forwardView.jsp

<%=request.getAttribute("msg")%>
<c:if test="true">
    ${msg}
</c:if>

</body>
</html>
