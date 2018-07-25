<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head xmlns="http://www.w3.org/1999/xhtml" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" >
    history.pushState(null, null, location.href);
    window.onpopstate = function () {
        history.go(1);
    };
</script>
  <style>
    body {
      min-height: 100vh;
    }
    ::placeholder {  
      color: black;
      opacity: 1; 
      text-align: center;
    }

    body {
      background: #fff;
    }

    .input-field input[type=date]:focus + label,
    .input-field input[type=text]:focus + label,
    .input-field input[type=email]:focus + label,
    .input-field input[type=password]:focus + label {
      color: #e91e63;
    }

    .input-field input[type=date]:focus,
    .input-field input[type=text]:focus,
    .input-field input[type=email]:focus,
    .input-field input[type=password]:focus {
      border-bottom: 2px solid #e91e63;
      box-shadow: none;
    }
  </style>


</head>
<body>

 	<div class="container">  
    <h5 class="indigo-text">Please, login into your account</h5>  
	 	<div class="row">
	 	<s:actionerror cssStyle="color:red;" />
        <s:form action="do_login" theme="simple"
            cssStyle="display:inline-block;padding:32px 48px 0px 48px;border:1px solid #EEE;"
            cssClass="col s12 z-depth-1 grey lighten-4">
        <div class='row'>
    	  <input  type="text" name="email"  placeholder="email" 
                class="col s12 input-field validate green" style="color:red;" />
    	  </div>
        <div class='row'>
        <input  type="password" name="password"  placeholder="password"  
                class="col s12 input-field validate green" style="color:red;"/>
    	  </div>
        <div class='row'>
        <button type="submit" name='btn_login' value="login" 
                class="col s12 btn btn-large waves-effect indigo">Login</button>
	      </div>
  	</s:form>	
    </div>
</body>
</html>
