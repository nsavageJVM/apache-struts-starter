<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head xmlns="http://www.w3.org/1999/xhtml>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>
<s:set var="userEmail" value="loggedInUser"/>
<div class="navbar">
    <nav class="light-green darken-2 nav-wrapper">
 
            <a class="brand-logo" href="#!"> &nbsp;probably hacked 
                <i class="material-icons right cloud" > </i></a>
            <ul class="right ">    
                <!-- s:property value="#request.loggedInUser" / -->
            </ul>
    
 
    </nav>
</div>
</body>
</html>
