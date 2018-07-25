<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="javax.servlet.http.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Entry</title>


</head>
<body>
    <%
    /**  init some vars  */
     String contextRoot = request.getContextPath();
    %>
<div class="container">
    <div class="inject-r"></div>
</div>
</body>
    <script src="<%= contextRoot %>/js/bundle.js"></script>
</html>