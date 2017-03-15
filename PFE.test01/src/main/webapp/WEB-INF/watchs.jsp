<%@page import="com.haythem.persistance.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page import = "java.util.*" %> 
<%@ page import = "java.net.*" %> 


<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from clabs.co/projects/optimus/table.html by HTTrack Website Copier/3.x [XR&CO'2013], Thu, 03 Apr 2014 14:55:05 GMT -->
<head>
	<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>HANTOR</title>
	<meta name="description" content="Optimus Dashboard Bootstrap Admin Template.">
	<meta name="author" content="Łukasz Holeczek">
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- end: Mobile Specific -->

	<!-- start: CSS -->
	<link id="bootstrap-style"
	href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<link
	href="<c:url value="/resources/css/bootstrap-responsive.min.css" />"
	rel="stylesheet">
<link id="base-style" href="<c:url value="/resources/css/style.css" />"
	rel="stylesheet">
<link id="base-style-responsive"
	href="<c:url value="/resources/css/style-responsive.css" />"
	rel="stylesheet">
	<!-- end: CSS -->

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<!-- start: Favicon -->
	<link rel="shortcut icon" href="img/favicon.ico">
	<!-- end: Favicon -->
		
</head>

<body>
		<!-- start: Header -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="index-2">  <span>Auxilium Watch</span></a>
								
				<!-- start: Header Menu -->
				<div class="btn-group pull-right" >
<!-- 					<a class="btn" href="#"> -->
<!-- 						<i class="icon-warning-sign"></i><span class="hidden-phone hidden-tablet"> notifications</span> <span class="label label-important hidden-phone">2</span> <span class="label label-success hidden-phone">11</span> -->
<!-- 					</a> -->
<!-- 					<a class="btn" href="#"> -->
<!-- 						<i class="icon-tasks"></i><span class="hidden-phone hidden-tablet"> tasks</span> <span class="label label-warning hidden-phone">17</span> -->
<!-- 					</a> -->
<!-- 					<a class="btn" href="#"> -->
<!-- 						<i class="icon-envelope"></i><span class="hidden-phone hidden-tablet"> messages</span> <span class="label label-success hidden-phone">9</span> -->
<!-- 					</a> -->
<!-- 					<a class="btn" href="#"> -->
<!-- 						<i class="icon-wrench"></i><span class="hidden-phone hidden-tablet"> settings</span> -->
<!-- 					</a> -->
					<!-- start: User Dropdown -->
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i><span class="hidden-phone hidden-tablet"> <sec:authentication property="name"/></span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						
						<li><a href="logout">Logout</a></li>
					</ul>
					<!-- end: User Dropdown -->
				</div>
				<!-- end: Header Menu -->
				
			</div>
		</div>
	</div>
	<div id="under-header"></div>
	<!-- start: Header -->
	
		<div class="container-fluid">
		<div class="row-fluid">
				
			<!-- start: Main Menu -->
			<div class="span2 main-menu-span">
				<div class="nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li class="nav-header hidden-tablet">Navigation</li>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="index-2"><i class="icon-home"></i><span class="hidden-tablet"> Dashboard</span></a></li>
						<li><a href="table"><i class="icon-user"></i><span class="hidden-tablet"> Users authentication</span></a></li>
					    <li><a href="userinformation"><i class="icon-eye-open"></i><span class="hidden-tablet"> Users Informations </span></a></li>
				        <li><a href="Watchs"><i class="icon-eye-open"></i><span class="hidden-tablet"> Watchs </span></a></li>
					    <li><a href="Patient"><i class="icon-eye-open"></i><span class="hidden-tablet"> Patient </span></a></li>
					   <li><a href="Measurement"><i class="icon-eye-open"></i><span class="hidden-tablet">Measurement</span></a></li>
					    <li><a href="Supervisor"><i class="icon-eye-open"></i><span class="hidden-tablet"> Supervisor </span></a></li>
					    </sec:authorize>
					    
					    
					    
<!--  					    *********************************start menu Patient*********************************************** -->
                       <sec:authorize access="hasRole('ROLE_PATIENT')">

                        <li><a href="index-2"><i class="icon-home"></i><span class="hidden-tablet"> Dashboard</span></a></li>
					    <li><a href="PatientUser"><i class="icon-home"></i><span class="hidden-tablet"> Patient </span></a></li>
					    
					 </sec:authorize>    
		<!--  					    *********************************Patient*********************************************** -->			    
					    
						<li><a href="login"><i class="icon-lock"></i><span class="hidden-tablet"> Login Page</span></a></li>
					</ul>
				</div><!--/.well -->
			</div><!--/span-->
			<!-- end: Main Menu -->
			
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
				</div>
			</noscript>
			
			<div id="content" class="span10">
			<!-- start: Content -->
			

			<div>
				<ul class="breadcrumb">
					<li>
						<a href="#">Home</a> <span class="divider">/</span>
					</li>
					<li>
						<a href="#">WATCHS</a>
					</li>
				</ul>
			</div>
			
			
			
<!-- 			*********************Start************************* -->
<sec:authorize access="hasRole('ROLE_PATIENT')">
 Restricted data, you are not allowed to access this resource 
</sec:authorize>


<sec:authorize access="hasRole('ROLE_SUPERVISOR')">
 Restricted data, you are not allowed to access this resource 
</sec:authorize>

<sec:authorize access="hasRole('ROLE_ADMIN')">

<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="icon-user"></i><span class="break"></span>watchs</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="icon-wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
					<h2>Watchs</h2>

						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
						  
							  <tr>
								  <th>watch Serial Number</th>
								  <th>hardVersion</th>
								  <th>softVersion</th>
								  <th>communicationType</th>
								  <th>Actions</th>
								  
							  </tr>
						  </thead>  
					 
						  <tbody>
						  
						  <% int j=0; %>
						  <c:forEach var="u" items="${watchList}">
          					
          					<% j=j+1; %>
        
							<tr>
							    <td id="<%= "wSNumber"+ j %>">${u.watchSerialNumber}</td>
								<td id="<%= "hVersion"+ j %>">${u.hardVersion}</td>
								<td id="<%= "sVersion"+ j %>" class="center">${u.softVersion}</td>
								<td id="<%= "cType"+ j %>" class="center">${u.communicationType}</td>
								
								<td class="center">
									
									<a class="btn btn-info btn-setting" onclick="affichage(<%= j %>,${u.id})" >
										<i class="icon-edit icon-white"></i>  
									</a>
									<a class="btn btn-danger" href="deletWatch?id=${u.id}">
										<i class="icon-trash icon-white"></i> 
									</a>
								</td>
							</tr>
							
							
							
							
							
							
							
							</c:forEach>
						  </tbody>
					  </table>            
					  <h3><a href="downloadWatchPdf" ><img class="dashboard-avatar" src="<c:url value="/resources/img/Icone_pdf.png" />"></a></h3>
					</div>
				</div><!--/span-->
			
			</div><!--/row-->
<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">Close</button>
				<h3>Edite User</h3>
		
			</div>
			<div class="modal-body">
			<form:form method="POST" id="frmew" commandName="watchModel" onsubmit="return validation1()">
   <table>
   
 
    <tr>
        <td><form:label path="watchSerialNumber">watch Serial Number</form:label></td>
        <td><form:input path="watchSerialNumber" id="wsnb" /></td>
    </tr>
    <tr>
        <td><form:label path="hardVersion">hardVersion</form:label></td>
        <td><form:input path="hardVersion" id="hv"/></td>
    </tr>
    <tr>
        <td><form:label path="softVersion">softVersion</form:label></td>
        <td><form:input path="softVersion" id="sv"/></td>
    </tr>
    <tr>
        <td><form:label path="communicationType">communicationType</form:label></td>
        <td><form:input path="communicationType" id="ct"/></td>
    </tr>
    
 
    <tr>
    
        <td colspan="2">
      
            <input class="btn btn-primary" type="submit" value="Save changes"/>
            <a href="#" class="btn" data-dismiss="modal">Close</a>
          
        </td>
    </tr>
    	
</table>  
</form:form>
			</div>
<!-- 			<div class="modal-footer"> -->
<!-- 				<a href="#" class="btn" data-dismiss="modal">Close</a> -->
<!-- 				<a href="#" class="btn btn-primary" type="submit" value="Submit" >Save changes</a> -->
				  
<!-- 			</div> -->
		</div>

<!-- ***********************************start 2************************** -->

<div class="row-fluid sortable">	
				<div class="box span12">
					<div class="box-header">
						<h2><i class="icon-align-justify"></i><span class="break"></span>Add Wacth</h2>
						<div class="box-icon">
							
							<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
					<form:form method="POST"  id="adui" action="addWatch" commandName="watchModel" onsubmit="return validation()">
   <table>
<!--    <div align="center"> -->
     
    <tr>
        <td><form:label path="watchSerialNumber">watchSerialNumber</form:label></td>
        <td><form:input class="input-xlarge focused" path="watchSerialNumber" id="watchSerialNumber"/>   <span style="color:red">${validator}</span></td>
        
                  
         
    
           
    </tr>
    <tr>
        <td><form:label path="hardVersion">hardVersion</form:label></td>
        <td><form:input class="input-xlarge focused" path="hardVersion" id="hardVersion"/></td>   
         
    </tr>
    
   
    <tr>
    <tr>
        <td><form:label path="softVersion">softVersion</form:label></td>
        <td><form:input class="input-xlarge focused" path="softVersion" id="softVersion"/></td> 
                   
    </tr>
   
    <tr>
        <td><form:label path="communicationType">communicationType</form:label></td>
        <td><form:input class="input-xlarge focused" path="communicationType" id="communicationType"/></td>
     
           
    </tr>
   
        <td colspan="2">
            <input class="btn btn-primary" type="submit" value="Save"/>
        </td>
    </tr>
</table>  
</form:form>
						
						
						 
					</div>
				</div><!--/span-->
			</div><!--/row-->
			
	</sec:authorize>		
			
<!-- ****************************************************************** -->

			
			
		
    
					<!-- end: Content -->
			</div><!--/#content.span10-->
				</div><!--/fluid-row-->
				
		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>Settings</h3>
			</div>
			<div class="modal-body">
				<p>Here settings can be configured...</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">Close</a>
				<a href="#" class="btn btn-primary">Save changes</a>
			</div>
		</div>
		
		<div class="clearfix"></div>
		<hr>
		
		<footer>
			<p class="pull-left">&copy; <a href="#" target="_blank">Hantor</a> 2014</p>
			<p class="pull-right">Powered by: <a href="#">Auxilium</a></p>
		</footer>
				
	</div><!--/.fluid-container-->

	<!-- start: JavaScript-->

		<script src="<c:url value="/resources/js/jquery-1.7.2.min.js" />"></script>

	<script
		src="<c:url value="/resources/js/jquery-ui-1.8.21.custom.min.js" />"></script>

	<script src="<c:url value="/resources/js/bootstrap.js" />"></script>

	<script src="<c:url value="/resources/js/jquery.cookie.js" />"></script>

	<script src="<c:url value="/resources/js/fullcalendar.min.js" />"></script>

	<script src="<c:url value="/resources/js/jquery.dataTables.min.js" />"></script>

	<script src="<c:url value="/resources/js/excanvas.js" />"></script>

	<script src="<c:url value="/resources/js/jquery.flot.min.js" />"></script>

	<script src="<c:url value="/resources/js/jquery.flot.pie.min.js" />"></script>

	<script src="<c:url value="/resources/js/jquery.flot.stack.js" />"></script>

	<script src="<c:url value="/resources/js/jquery.flot.resize.min.js" />"></script>



	<script src="<c:url value="/resources/js/jquery.chosen.min.js" />"></script>

	<script src="<c:url value="/resources/js/jquery.uniform.min.js" />"></script>

	<script src="<c:url value="/resources/js/jquery.cleditor.min.js" />"></script>

	<script src="<c:url value="/resources/js/jquery.noty.js" />"></script>

	<script src="<c:url value="/resources/js/jquery.elfinder.min.js" />"></script>


	<script src="<c:url value="/resources/js/jquery.raty.min.js" />"></script>

	<script src="<c:url value="/resources/js/jquery.iphone.toggle.js" />"></script>

	<script
		src="<c:url value="/resources/js/jquery.uploadify-3.1.min.js" />"></script>


	<script src="<c:url value="/resources/js/jquery.gritter.min.js" />"></script>

	<script src="<c:url value="/resources/js/jquery.imagesloaded.js" />"></script>

	<script src="<c:url value="/resources/js/jquery.masonry.min.js" />"></script>

	<script src="<c:url value="/resources/js/custom.js" />"></script>

		<!-- end: JavaScript-->
	

<script type="text/javascript">

function affichage(j,id){
	
	$("#wsnb").val($("#wSNumber"+j).text());
	
	$("#hv").val($("#hVersion"+j).text());
	
	$("#sv").val($("#sVersion"+j).text());
	
	$("#ct").val($("#cType"+j).text());

	$("#frmew").attr("action","editWatch?id="+id);
	
	
}






function validation1(){
	
// 	alert("in");
	
	var watchSerialNumber=$("#wsnb"),
	hardVersion=$("#hv"),softVersion=$("#sv"),communicationType=$("#ct"),
		
		valid=true,
		
		fields=$([]).add(watchSerialNumber).add(hardVersion).add(softVersion).add(communicationType);
		
	fields.removeClass("alert alert-error");
	
	
	if (watchSerialNumber.val().length==0){
		
		watchSerialNumber.addClass("alert alert-error");
		valid=false;
		
	}
	
if (softVersion.val().length==0){
		
	softVersion.addClass("alert alert-error");
		valid=false;
		
	}
	
if (communicationType.val().length==0){
	
	communicationType.addClass("alert alert-error");
	valid=false;
	
}
if (hardVersion.val().length==0){
	
	hardVersion.addClass("alert alert-error");
	valid=false;
	
}
	return valid;
	
}


function validation(){
	
// 	alert("in");
	
	var watchSerialNumber=$("#watchSerialNumber"),
	hardVersion=$("#hardVersion"),softVersion=$("#softVersion"),communicationType=$("#communicationType"),
		
		valid=true,
		
		fields=$([]).add(watchSerialNumber).add(hardVersion).add(softVersion).add(communicationType);
		
	fields.removeClass("alert alert-error");
	
	
	if (watchSerialNumber.val().length==0){
		
		watchSerialNumber.addClass("alert alert-error");
		valid=false;
		
	}
	
if (softVersion.val().length==0){
		
	softVersion.addClass("alert alert-error");
		valid=false;
		
	}
	
if (communicationType.val().length==0){
	
	communicationType.addClass("alert alert-error");
	valid=false;
	
}
if (hardVersion.val().length==0){
	
	hardVersion.addClass("alert alert-error");
	valid=false;
	
}
	return valid;
	
}

</script>



</body>


</html>
