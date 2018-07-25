<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="javax.servlet.http.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page contentType="text/html; charset=UTF-8" %>

<!-- see definitions tiles.xml -->
<tiles:importAttribute name="stylesheets"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title> Struts2 Vunarability Demo </title>

     <!-- stylesheets -->
        <c:forEach var="css" items="${stylesheets}">
            <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
        </c:forEach>

        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
        <!--Compiled and minifed jQuery -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
         <!-- Material Design Icons courtesy of Google -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<style type="text/css">
        #slide-out {
        top: 70px;
        }

        #content {
        padding-left: 240px;
        }

        @media only screen and (max-width : 992px) {
        #container {
            padding-left: 0px;
        }
</style>



</head>
<body>

    <%
    /**  init some vars  */
     String contextRoot = request.getContextPath();
    %>
    
    <div class="row"> 
        <div class="col s12">
            <tiles:insertAttribute name="headerslot"  ignore="true"/>
        </div>
    </div>
    
<a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>
    
    <ul id="slide-out" class="side-nav show-on-large-only">
      <li><tiles:insertAttribute name="side-bar-top"  ignore="true"/></li>
      <li class="no-padding">
            <tiles:insertAttribute name="side-bar-dropdown"  ignore="true"/>
      </li> 
      <!-- li><a href="#!" id="nav-closer">Close Sidenav</a></li -->
    </ul>

    <div id="content">     
     <tiles:insertAttribute name="body"  ignore="true"/>
    </div>
<script>
            $( document ).ready(function() {
                console.log( "jquery is go init side nav" );
                $('.button-collapse').sideNav({
                    menuWidth: 240, // Default is 300
                    edge: 'left', // Choose the horizontal origin
                    closeOnClick: true, // Closes side-nav on <a> clicks
                    draggable: true // Choose whether you can drag to open on touch screens
                    });

                $('#nav-closer').click(function() {
                        $('.side-nav').sideNav('hide');
                });


                var contextRoot = "<%= contextRoot %>";
                var path = contextRoot+"/authDispatch"

            
            });



</script>

</body>

</html>
