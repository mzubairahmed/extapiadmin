<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>External API Admin Console - Login</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.2.js"></script>
<script type="text/javascript" src="<c:url value="/js/common-utils.js" />"></script>

<!-- test -->
<style>
   table {border-collapse:collapse; table-layout:fixed; width:50%;}
   table td {border:solid 1px #ccddee; word-wrap:break-word;}
   .error {color: red; font-family: sans-serif; font-size: small;}
   
	.navi, 
	.infoi {
		
	    /* Do not display it on entry */
	    display: none; 

	    position: absolute;
	    top: 45%;
	    left: 45%;
	}
	
	.infoi {
	    z-index: 1002;
	}
	
	#progressPanel
	{
	    /* Do not display it on entry */
	    display: none; 
	 
	    /* Display it on the layer with index 1001.
	       Make sure this is the highest z-index value
	       used by layers on that page */
	    z-index:1001;
	     
	    /* make it cover the whole screen */
	    position: absolute; 
	    top: 0%; 
	    left: 0%; 
	    width: 100%; 
	    height: 100%; 
	 
	    /* make it white but fully transparent */
	    background-color: grey; 
	    opacity:.25;
	    filter: alpha(opacity=25); 
	}
</style>

</head>

<body>

	<div>

		<h1>ASI</h1>

		<c:if test="${not empty authentication_error}">
			<h1>Please enter correct password.. Some thing wrong happen!</h1>

			<p class="error">Your login attempt was not successful.</p>
		</c:if>
		<c:if test="${not empty authorization_error}">
			<h1>Please contact ASI!</h1>

			<p class="error">You are not permitted to access that resource.</p>
		</c:if>

		<div class="form-horizontal">
			<form action="<c:url value="/login"/>" method="post" role="form">
				<fieldset>
					<legend>
						<h2>Login</h2>
					</legend>
					<table >
						<tr>
							<td><label for="asinumber">ASI:</label></td>
							<td>
								<input id="asinumber" class="form-control" type='text' name='asinumber' value="" />
								<span class="error" id="error_asinumber"></span>
							</td>
						</tr>
						<tr>
							<td><label for="username">Username:</label></td>
							<td>
								<input id="username" class="form-control" type='text' name='username' value="" />
								<span class="error" id="error_username"></span>
							</td>
						</tr>
						<tr>
							<td><label for="password">Password:</label></td>
							<td>
								<input id="password" class="form-control" type='password' name='password' value="" />
								<span class="error" id="error_password"></span>
							</td>
						</tr>
						<tr>
							<td><label for="email">Notification E-mail:</label></td>
							<td>
								<input id="email" class="form-control" type='text' name='email' value="" />
								<span class="error" id="error_email"></span>
							</td>
						</tr>
					</table>
					<button class="btn btn-primary" type="submit" onclick="return validate()" value="Login">Login</button>
				</fieldset>
			</form>

		</div>
		
		<div id="progressPanel"></div>
		<div class="infoi" id="progressImage"><img src="img/LoadingCircle.gif" height="35" width="35"/></div>

	</div>

<script>

function validateEmail(email) {
    var re = /^\s*[\w\-\+_]+(\.[\w\-\+_]+)*\@[\w\-\+_]+\.[\w\-\+_]+(\.[\w\-\+_]+)*\s*$/;
    if (re.test(email)) {
        if (email.indexOf('@asicentral.com', email.length - '@asicentral.com'.length) !== -1) {
        	$("#error_email").html('');
        	return true;
        } else {
        	$("#error_email").html('Email must be a ASI E-mail Address (name@asicentral.com).');
        	return false;
        }
    } else {
    	$("#error_email").html('Not a valid e-mail address.');
    	return false;
    }
    return true;
}

function validate() {
	
	var status = true;
	if(!$("#asinumber").val()) {
		$("#error_asinumber").html("Required");
		status = false;
	} else {
		$("#error_asinumber").html("");
	}
	if(!$("#username").val()) {
		$("#error_username").html("Required");
		status = false;
	} else {
		$("#error_username").html("");
	}
	if(!$("#password").val()) {
		$("#error_password").html("Required");
		status = false;
	} else {
		$("#error_password").html("");
	}
	
	status = (validateEmail($("#email").val()) && status);
	
	if(status) {
		$("#progressPanel").show();
		$("#progressImage").show();
	}

	return status;
	
}

</script>

</body>
</html>
