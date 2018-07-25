<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<head xmlns="http://www.w3.org/1999/xhtml"  >
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
		<p class="center-align flow-text green-text" >Complete and submit the form to create your account.</p> 
		<div class="row">
			 <s:actionerror cssStyle="color:red;" />
			 <s:form action="register" theme="simple"
					cssStyle="display:inline-block;padding:32px 48px 0px 48px;border:1px solid #EEE;"
					cssClass="col s12 z-depth-1 grey lighten-4">
			    <div class='row'>
					<input  type="text" name="email" placeholder="email" 
							class="col s12 input-field validate green" style="color:red;"  />
					<input  type="text" name="password" placeholder="password"  
							class="col s12 input-field validate green" style="color:red;"   />
				</div>
				<div class='row'>
					<button type="submit" name='btn_login' value="register" 
							class="col s12 btn btn-large waves-effect indigo">Register</button>
				</div>
			</s:form>
		</div>	
      </div>

	</body>
	
</html>
