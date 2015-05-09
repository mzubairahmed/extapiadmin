<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>External API Admin Console - Welcome</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.2.js"></script>
<script type="text/javascript" src="<c:url value="/js/common-utils.js" />"></script>
<style>
   table {border-collapse:collapse; table-layout:fixed; width:80%;}
   table td {border:solid 1px #ccddee; word-wrap:break-word;}
   
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
	
	.alert-box {
	    color:#555;
	    border-radius:10px;
	    font-family:Tahoma,Geneva,Arial,sans-serif;font-size:11px;
	    padding:10px 10px 10px 36px;
	    margin:10px;
	}

	.alert-box span {
	    font-weight:bold;
	    text-transform:uppercase;
	}
	
	.error {
	    background:#ffecec;
	    border:1px solid #f5aca6;
	}
   
   
</style>
<script type="text/javascript">

	var companyId = '${STAGE_USER.companyId}';
	var authToken = '${STAGE_USER.accessToken}';
	var data = {
			'asiNumber'		 : '${SupplierNumber}',
			'companyId'      : '${STAGE_USER.companyId}',
			'authToken'      : '${STAGE_USER.accessToken}',
			'sourceAuthToken' : '${STAGE_USER.accessToken}',
			'destinationAuthToken'   : '${SANDBOX_USER.accessToken}',
			'email'			:  '${email}'
		};
	$(document).ready(function() {
		$("#progressPanel").show();
		$("#progressImage").show();
		// use jQuery.ajax
		jQuery.ajax({
			'data' : data,
			'type' : 'GET',
			'url' : 'utility/validate',
			'success' : function(response) {
				// alert($.trim(response).toUpperCase());
				if($.trim(response).toUpperCase() === "TRUE") {
					getCount();
				} else {
					$("#errorMessage").show();
					$("#progressPanel").hide();
					$("#progressImage").hide();

				}
			}
		});

	});
	
	function getCount() {
		// use jQuery.ajax
		jQuery.ajax({
			'data' : data,
			'type' : 'GET',
			'url' : 'utility/count',
			'success' : function(response) {
				$("#productCount").html(response);
			//	$('#copyButton').show();
				$('#btnCopy').show();
				$("#progressPanel").hide();
				$("#progressImage").hide();
			}
		});
	}
	
	function copyProducts() {
		var confirmation = window.confirm("Click 'Yes' to begin the Copy process, otherwise press 'Cancel' if you accidently hit the copy button.");
		if(!confirmation) {
			return;
		}
		$("#progressPanel").show();
		$("#progressImage").show();
		jQuery.ajax({
			'data' : data,
			'type' : 'GET',
			'url' : 'utility/copy',
			'success' : function(response) {
				$('#progressData').html(response);
				$("#progressPanel").hide();
				$("#progressImage").hide();

			}
		});

	}
	
	function submitForm() {
		var confirmation = window.confirm("Click 'Yes' to begin the Copy process, otherwise press 'Cancel' if you accidently hit the copy button.");
		if(!confirmation) {
			return false;
		}
		return true;
	}
	
</script>
</head>
<body>
	<div class="container">

		<h1>Welcome to the Copy Utility!</h1>
		
		<div id="errorMessage" class="alert-box error" style="display: none;"><span>STOP!</span> Cannot Proceed - The destination has set as production</div>

		<h4>
			There are <span id="productCount"></span> number of products in
			supplier: asi/${SupplierNumber}
		</h4>
		<h5>Copy will be done from Production to Sandbox</h5>
		<h5>Please press the copy button to begin the copying process</h5>

		<button type="button" name="copyButton" id="copyButton"
			value="Copy Products" onclick="copyProducts();" style="display: none;" >Copy Products</button>
			
		<form name="copyForm" id="copyForm" action="utility/copy" method="POST">
			<input type="hidden" name="asiNumber" id="asiNumber" value="${SupplierNumber}">
			<input type="hidden" name="companyId" id="companyId" value="${STAGE_USER.companyId}">
			<input type="hidden" name="authToken" id="authToken" value="${STAGE_USER.accessToken}">
			<input type="hidden" name="sourceAuthToken" id="sourceAuthToken" value="${STAGE_USER.accessToken}">
			<input type="hidden" name="destinationAuthToken" id="destinationAuthToken" value="${SANDBOX_USER.accessToken}">
			<input type="hidden" name="email" id="email" value="${email}">
			<button type="submit" id="btnCopy" name="btnCopy" onclick="return submitForm();" style="display: none;">Copy</button>
		</form>
		
		<br /> <br />
		
		<div align="center" style="width: 100%">
			<table id="progressTable" border="1px">
				<tr>
					<th width="15%">XID</th>
					<th width="5%">Status</th>
					<th>Message</th>
				</tr>
				<tbody id="progressData">
					
				</tbody>
			</table>
		</div>
	</div>
	
	<div id="progressPanel"></div>
	<div class="infoi" id="progressImage"><img src="img/LoadingCircle.gif" height="35" width="35"/></div>
	
</body>
</html>






























