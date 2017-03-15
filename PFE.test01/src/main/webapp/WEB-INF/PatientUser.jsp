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
				<a class="brand" href="index-2"> <span>Auxilium Watch</span></a>
								
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
						<i class="icon-user"></i><span class="hidden-phone hidden-tablet"> <sec:authentication property="principal.username"/> </span>
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
						<a href="#">Patient</a>
					</li>
				</ul>
			</div>
			
			
			
<!-- 			*********************Start************************* -->

<!-- ******************************************************************************************************************************************************** -->


<!-- ******************************************************************************PATIENT************************************************************************** -->

		<sec:authorize access="hasRole('ROLE_PATIENT')">







<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="icon-user"></i><span class="break"></span>Measurement</h2>
						<div class="box-icon">
							
							<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
					

						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
								  <tr>
                                      <th>User-Name</th>
									  <th>WatchSerialNumber </th>
									  <th>Date / Time</th>
									  <th>Heartbeat</th>
									  <th>Temperature</th>
									  <th>Fall</th>

									  
									                               
								  </tr>
							  </thead>   
					 
						  	 <tbody>
						  
						  <% int c=0; %>
						  
						  <c:forEach var="in" items="${measurementPatient}">
          					
          					<% c=c+1; %>
        
							<tr>
						        

							    
							     <td id="<%= "username"+ c %>">${in.patient.user.username}</td>
							     <td id="<%= "watchSerialNumber"+ c %>">${in.watchSerialNumber}</td>
							     <td id="<%= "date"+ c %>">${in.date}</td>
							     <td id="<%= "heartbeat"+ c %>">${in.heartbeat/10}</td>
							     <td id="<%= "username"+ c %>">${in.temperature/10}</td>
							     <td id="<%= "username"+ c %>">${in.fall}</td>

							
							</tr>
							
							
							
							
							
							
							
							</c:forEach>
						  </tbody>
					  </table>            
					</div>
					<h3><a href="downloadPDF" ><img class="dashboard-avatar" src="<c:url value="/resources/img/Icone_pdf.png" />"></a></h3>
				</div><!--/span-->
			
			</div><!--/row-->



<!-- ************************************************************************************************************* -->

<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="icon-user"></i><span class="break"></span>Patient</h2>
						<div class="box-icon">
						
							<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
					<h2>EDITE</h2>

						<form:form method="POST"   action="editPatientUser" commandName="UserModel" id="frma" onsubmit="return validation4()" >
   <table>
   <div align="center">
   <tr>
        <td><form:label path="id" style="display: none;">id</form:label></td>
        <td><form:input path="id" id="id"  value="${userOne.id}" style="display: none;"/></td>
<%--         <td><form:errors path="username" ui-state-error class="alert alert-error"/></td> --%>
        
    </tr>
   
   
    <tr>
        <td><form:label path="username" style="display: none;">username</form:label></td>
        <td><form:input path="username" id="addname" value="${userOne.username}" style="display: none;"/></td>
<%--         <td><form:errors path="username" ui-state-error class="alert alert-error"/></td> --%>
        
    </tr>
    <tr>
        <td><form:label path="password" >password</form:label></td>
        <td><form:input path="password" type="password" id="addpwd" placeHolder="new Password"/></td>
    </tr>
   

							
						</div>
						
    <tr>
        <td colspan="2">
            <input class="btn btn-primary" type="submit" value="Save"/>
        </td>
    </tr>
</table>  
</form:form>
					</div>
				</div><!--/span-->
			
			</div><!--/row-->
<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">Close</button>
				<h3>Edite User</h3>
		
			</div>
			<div class="modal-body">
			<form:form method="POST"  id="edui" commandName="Info" onsubmit="return validation1()" >
   <table>
<!--    <div align="center"> -->
  
    <tr>
    
    
    
    <td><form:label path="identityCardNumber">identityCardNumber</form:label></td>
        <td><form:input path="identityCardNumber" id="icn"/></td>      
        <td><form:label path="firstName">First Name</form:label></td>
        <td><form:input path="firstName" id="fn"/></td>
        
                 
         
    
           
    </tr>
    <tr>
     <td><form:label path="lastName">Last Name</form:label></td>
        <td><form:input path="lastName" id="ln"/></td>  
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" id="em"/></td>   
        
                
    </tr>
    
   
    <tr>
    <tr>
        <td><form:label path="birthday">Birthday</form:label></td>
        <td><form:input path="birthday" id="bir"/></td>     
        <td><form:label path="phoneNumber">Phone Number</form:label></td>
        <td><form:input path="phoneNumber" id="phone"/></td> 
                   
    </tr>
   
    <tr>
        <td><form:label path="adress.adress">Adress</form:label></td>
        <td><form:input path="adress.adress" id="adr"/></td>     
        <td><form:label path="adress.country">Country</form:label></td>
        <td><form:input path="adress.country" id="coun"/></td>
       
           
    </tr>
    <tr>
                   <td><form:label path="adress.state">State</form:label></td>
                   <td><form:input path="adress.state" id="sta"/></td>    
				   <td><form:label path="gender">gender</form:label></td>
                   <td><form:input path="gender" id="gen"/></td>
  
					
						
						
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
<!-- *******************************informations ************************************************ -->


<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="icon-user"></i><span class="break"></span>Information</h2>
						<div class="box-icon">
							<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
					

						<table class="table table-striped table-bordered bootstrap-datatable ">
						  <thead>
								  <tr>
<!-- 									  <th >id</th> -->
<!--                                       <th>User Id</th> -->
                                      <th >ICN</th>
                                      <th>User-Name</th>
									  <th>First Name</th>
									  <th>Last Name</th>
									  <th>Email</th>
									  <th>Birthday</th>
									  <th>Gender</th>
									  <th>Phone Number</th> 
									  <th>Adress</th>
									  <th>country</th>
									  <th>State</th>
									  <th>Actions</th> 
									                               
								  </tr>
							  </thead>   
					 
						  	 <tbody>
						  
					
							<tr>
						        
<%-- 							    <td id="<%= "id"+ c %>">${in.id}</td> --%>
<%-- 							    <td id="<%= "userID"+ c %>">${in.user.id}</td> --%>
                               
							    <td id="iCardNumber1">${informationPatient.identityCardNumber}</td>
							    <td id="username1">${userOne.username}</td>
								<td id="fName1">${informationPatient.firstName}</td>
								<td id="lName1" class="center">${informationPatient.lastName}</td>
								<td class="center" id="email1">${informationPatient.email}</td>
							    <td class="center" id="birthday1">${informationPatient.birthday}</td>
							    <td class="center" id="gender1">${informationPatient.gender}</td>
							    <td class="center" id="phoneNumber1">${informationPatient.phoneNumber}</td>
							    <td class="center" id="adress1">${informationPatient.adress.adress}</td>
							    <td class="center" id="country1">${informationPatient.adress.country}</td>
							    <td class="center" id="state1">${informationPatient.adress.state}</td>
							    
<%-- 							    <td class="center">${in.user.username}</td> --%>
<%-- 							    <c:forEach var="ad" items="${adress}"> --%>
<%-- 							    <td class="center">${ad.adress}</td> --%>
<%-- 							    <td class="center">${ad.country}</td> --%>
<%-- 							    <td class="center">${ad.state}</td> --%>
<%-- 							    </c:forEach> --%>
							
							
								 <td class="center">
									
									<a class="btn btn-info btn-setting" onclick="affichage(${informationPatient.id})" >
										<i class="icon-edit icon-white"></i>  
									</a>
									
								</td>
							</tr>
							
							
							
							
							
							
						
						  </tbody>
					  </table>            
					</div>
				</div><!--/span-->
			
			</div><!--/row-->


</sec:authorize>

<!-- ******************************************************************Supervisor************************************************************************************** -->	
<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="icon-user"></i><span class="break"></span>Patient-Spervisor</h2>
						<div class="box-icon">
						
							<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
					<h2>Patient</h2>

						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
						  
							  <tr> 
							      <th>Supervisor</th>
							      <th>Patient</th>
							      
								  <th>Actions</th>  
							  </tr>
						  </thead>  
					 
						  <tbody>
						  
						  <% int j=0; %>
						  <c:forEach var="u" items="${supervisorPatientList}">
          					
          					<% j=j+1; %>
        
							<tr>
							    <td id="<%= "wSNumber"+ j %>">${u.user.username}</td>
							    
								<td id="<%= "hVersion"+ j %>">${u.patient.user.username}</td>
								
								
								<td class="center">
									<a class="btn btn-danger" href="deletSupervisorPatient?id=${u.id}">
										<i class="icon-trash icon-white"></i> 
									</a>
								</td>
							</tr>
							
							
							
							
							
							
							
							</c:forEach>
						  </tbody>
					  </table>            
					</div>
				</div><!--/span-->
			
			</div><!--/row-->
			
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="icon-user"></i><span class="break"></span>Add Supervisor</h2>
						<div class="box-icon">
							
							<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
					

						<form:form method="POST"  action="addPatientSupervisor"  commandName="UserModel"   onsubmit="return validation3()">
   <table>
   <div align="center">
<!--     <tr> -->
				
<!-- 				<td> -->
<%-- 				<form:radiobutton path="role" value="1" id="rdio1" style="margin-left:5px;"/>Admin &nbsp;&nbsp;&nbsp; --%>
<%-- 				<form:radiobutton path="role" value="2" id="rdio2"   style="margin-left:5px;"/>Patient&nbsp;&nbsp;&nbsp; --%>
<%-- 				<form:radiobutton path="role" value="3" id="rdio3" checked="checked" style="margin-left:5px;"/>Supervisor&nbsp;&nbsp;&nbsp; --%>
<!-- 				</td> -->
<!-- 				<td> -->
<%-- 				<form:errors path="role" cssClass="error" /></td> --%>
<!-- 			</tr> -->
			
			<tr>
        <td><form:label path="role" style="display: none;">role</form:label></td>
        <td><form:input path="role" id="role" value="3" style="display: none;"/></td>
<%--         <td><form:errors path="username" ui-state-error class="alert alert-error"/></td> --%>
        
    </tr>
    <tr>
        <td><form:label path="username">username</form:label></td>
        <td><form:input path="username" id="addname1"/></td>
<%--         <td><form:errors path="username" ui-state-error class="alert alert-error"/></td> --%>
        
    </tr>
    <tr>
        <td><form:label path="password" >password</form:label></td>
        <td><form:input path="password" type="password" id="addpwd1"/></td>
    </tr>
   

							
						</div>
						
    <tr>
        <td colspan="2">
            <input class="btn btn-primary" type="submit" value="Save"/>
        </td>
    </tr>
</table>  
</form:form>
					</div>
				</div><!--/span-->

<!-- 			********************************************************************************************** -->
		
    
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


   


function affichage(c){
  
 	$("#icn").val($("#iCardNumber1").text());
 
 	$("#fn").val($("#fName1").text());
 	
 	$("#ln").val($("#lName1").text());
 	
 	$("#em").val($("#email1").text());
 	 
 	$("#bir").val($("#birthday1").text());
 	
 	$("#phone").val($("#phoneNumber1").text());
 	
 	$("#adr").val($("#adress1").text());
	 
 	$("#coun").val($("#country1").text());
 	
 	$("#sta").val($("#state1").text());
 	
 	$("#gen").val($("#gender1").text());
 	
	$("#edui").attr("action","editPatientInformation?id=1");
	
	
	
}



function saveInfo(){
	
  alert($("#userId").text());
	$("#adui").attr("action","addUserInformation?id="+$("#userId").text());	
}


function validation1(){
	
// 	alert("in");
	
	var identityCardNumber=$("#icn"),
	firstName=$("#fn"),lastName=$("#ln"),
	email=$("#em"),birthday=$("#bir"),phoneNumber=$("#phone"),adress=$("#adr"),country=$("#coun"),state=$("#sta"),
		
		valid=true,
		
		fields=$([]).add(identityCardNumber).add(firstName).add(lastName).add(email).add(birthday).add(phoneNumber).add(adress).add(country).add(state);
		
	fields.removeClass("alert alert-error");
	
	
	if (identityCardNumber.val().length==0 || identityCardNumber.val()==0){
		
		identityCardNumber.addClass("alert alert-error");
		valid=false;
		
	}
	
    if (firstName.val().length==0){
		
    	firstName.addClass("alert alert-error");
		valid=false;
		
	}
	
	 if (lastName.val().length==0){
			
		 lastName.addClass("alert alert-error");
			valid=false;
			
		}
		
		
		if (email.val().length==0){
			
			email.addClass("alert alert-error");
				valid=false;
				
			}
		
if (birthday.val().length==0){
			
	birthday.addClass("alert alert-error");
				valid=false;
				
			}
			
if (phoneNumber.val().length==0){
	
	phoneNumber.addClass("alert alert-error");
		valid=false;
		
	}
	 


if (adress.val().length==0){
	
	adress.addClass("alert alert-error");
		valid=false;
		
	}
	
if (country.val().length==0){
	
	country.addClass("alert alert-error");
		valid=false;
		
	}
	
	
if (state.val().length==0){
	
	state.addClass("alert alert-error");
		valid=false;
		
	}
	 
	 
	return valid;
	
}


function validation(){
	
// 	alert("in");
	
	var identityCardNumber=$("#identityCardNumber"),
	firstName=$("#firstName"),lastName=$("#lastName"),
	email=$("#email"),birthday=$("#birthday"),phoneNumber=$("#phoneNumber"),adress=$("#adress"),country=$("#country"),state=$("#state"),
		
		valid=true,
		
		fields=$([]).add(identityCardNumber).add(firstName).add(lastName).add(email).add(birthday).add(phoneNumber).add(adress).add(country).add(state);
		
	fields.removeClass("alert alert-error");
	
	
	if (identityCardNumber.val().length==0 || identityCardNumber.val()==0){
		
		identityCardNumber.addClass("alert alert-error");
		valid=false;
		
	}
	
    if (firstName.val().length==0){
		
    	firstName.addClass("alert alert-error");
		valid=false;
		
	}
	
	 if (lastName.val().length==0){
			
		 lastName.addClass("alert alert-error");
			valid=false;
			
		}
		
		
		if (email.val().length==0){
			
			email.addClass("alert alert-error");
				valid=false;
				
			}
		
if (birthday.val().length==0){
			
	birthday.addClass("alert alert-error");
				valid=false;
				
			}
			
if (phoneNumber.val().length==0){
	
	phoneNumber.addClass("alert alert-error");
		valid=false;
		
	}
	 


if (adress.val().length==0){
	
	adress.addClass("alert alert-error");
		valid=false;
		
	}
	
if (country.val().length==0){
	
	country.addClass("alert alert-error");
		valid=false;
		
	}
	
	
if (state.val().length==0){
	
	state.addClass("alert alert-error");
		valid=false;
		
	}
	 
	 
	return valid;
	
}


function validation2(){
	
// 	alert("in");
	$("#name").val($("#name"+id).text());
	$("#pwd").val($("#pwd"+id).text());
	$("#id").val($("#id"+id).text());
	$("#frme").attr("action","editPatientUser?id="+"${informationPatient.user.id}" );
	
	
	
}


function validation3(){
	
// 	alert("in");
	
	var name=$("#addname1"),
		pwd=$("#addpwd1"),
		
		valid=true,
		
		fields=$([]).add(name).add(pwd);
		
	fields.removeClass("alert alert-error");
	
	
	if (name.val().length==0){
		
		name.addClass("alert alert-error");
		valid=false;
		
	}
	
if (pwd.val().length==0){
		
		pwd.addClass("alert alert-error");
		valid=false;
		
	}

	
	return valid;
	
}


function validation4(){
	
// 	alert("in");
	
	var name=$("#addname"),
		pwd=$("#addpwd"),
		
		valid=true,
		
		fields=$([]).add(name).add(pwd);
		
	fields.removeClass("alert alert-error");
	
	
	if (name.val().length==0){
		
		name.addClass("alert alert-error");
		valid=false;
		
	}
	
if (pwd.val().length==0){
		
		pwd.addClass("alert alert-error");
		valid=false;
		
	}

	
	return valid;
	
}


</script>



</body>


</html>
