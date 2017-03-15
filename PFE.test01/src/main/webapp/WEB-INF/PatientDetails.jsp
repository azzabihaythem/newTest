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
				<a class="brand" href="index-2"> <span>${cliniqueName}</span></a>
								
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
					     <li><a href=" PatientDetailsinformation"><i class="icon-eye-open"></i><span class="hidden-tablet">  Patient informations </span></a></li>
					       <li><a href=" CliniqueInformations"><i class="icon-eye-open"></i><span class="hidden-tablet">  Clinique informations </span></a></li>
					    <li><a href="Seance"><i class="icon-eye-open"></i><span class="hidden-tablet"> Seance </span></a></li>
					   
					   
<!-- 				        <li><a href="Watchs"><i class="icon-eye-open"></i><span class="hidden-tablet"> Watchs </span></a></li> -->
<!-- 					    <li><a href="Patient"><i class="icon-eye-open"></i><span class="hidden-tablet"> Patient </span></a></li> -->
<!-- 					   <li><a href="Measurement"><i class="icon-eye-open"></i><span class="hidden-tablet">Measurement</span></a></li> -->
<!-- 					    <li><a href="Supervisor"><i class="icon-eye-open"></i><span class="hidden-tablet"> Supervisor </span></a></li> -->
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
						<a href="#">Users Informations</a>
					</li>
				</ul>
			</div>
			
			
			
<!-- 			*********************Start************************* -->

<div class="row-fluid sortable">		
				

<!-- ************************************************************* -->
<!-- 			*********************Start 2 ************************* -->
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
						<h2><i class="icon-user"></i><span class="break"></span>Information</h2>
						<div class="box-icon">
							<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
					

						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
								  <tr>
<!-- 									  <th >id</th> -->
<!--                                       <th>User Id</th> -->
                                      <th >ICN</th>
                                      <th>User-Name</th>
									
									  <th>DOIT</th>
									  <th>affile</th>
									  <th>numAffilation</th>
									  <th>numPriseEnCharge</th> 
									  <th>dateDebut</th>
									  <th>dateFin</th>
								      <th>Action</th>
									                               
								  </tr>
							  </thead>   
					 
						  	 <tbody>
						  
						  <% int h=0; %>
						  
						  <c:forEach var="in1" items="${PatientDetails}">
          					
          					<% h=h+1; %>
        
							<tr>
						        
<%-- 						        <td id="<%= "id"+ h %>">${in.id}</td> --%>
							    <td id="<%= "userID"+ h %>">${in1.user.id}</td> 
							    <td id="<%= "username"+ h %>">${in1.user.username}</td>

								<td id="<%= "DOIT"+ h %>">${in1.DOIT}</td>
								<td id="<%= "affile"+ h %>" class="center">${in1.affile}</td>
								<td class="center" id="<%= "numAffilation"+h %>">${in1.numAffilation}</td>
							    <td class="center" id="<%= "numPriseEnCharge"+ h %>">${in1.numPriseEnCharge}</td>
							
							    <td class="center" id="<%= "dateDebut"+ h %>">${in1.dateDebut}</td>
							    <td class="center" id="<%= "dateFin"+ h %>">${in1.dateFin}</td>
					
							    
<%-- 						    <td class="center">${in.user.username}</td>  --%>
<%-- 							    <c:forEach var="ad" items="${adress}">  --%>
<%--  							    <td class="center">${ad.adress}</td>  --%>
<%-- 							    <td class="center">${ad.country}</td>  --%>
<%-- 						    <td class="center">${ad.state}</td>  --%>
<%-- 							    </c:forEach>  --%>
							
							
								 <td class="center">
									
									<a class="btn btn-info btn-setting" onclick="affichage(<%=  h %>,${in1.id})" >
										<i class="icon-edit icon-white"></i>  
									</a>
									<a class="btn btn-danger" href="deletepatientDetails?id=${in1.id}">
										<i class="icon-trash icon-white"></i> 
									</a>
								</td>
							</tr>
							
							
							
							
							
							
							
							</c:forEach>
						  </tbody>
					  </table>  
<%-- 					    <h3><a href="downloadInformationUserPdf" ><img class="dashboard-avatar" src="<c:url value="/resources/img/Icone_pdf.png" />"></a></h3>            --%>
					</div>
				</div><!--/span-->
			
			</div><!--/row-->


			

			
			
<!--  *************************end 3**************************** -->			
			
		
    
					<!-- end: Content -->
			</div><!--/#content.span10-->
				</div><!--/fluid-row --> 
				
		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">Close</button>
				<h3>Edite Information</h3>
			</div>
			<div class="modal-body">
				<form:form method="POST"  id="edui" commandName="Info" onsubmit="return validation1()" >
   <table>
        <tr>
        <td><form:label path="adress.state">DOIT</form:label></td>
        <td><form:input  path="patientDetailsModel.DOIT" id="DOIT"/></td> 
         <td><form:label path="adress.country">affile</form:label></td>
        <td><form:input  path="patientDetailsModel.affile" id="affile"/></td>   
           
    </tr>
   
   
        <tr>
       
        <td><form:label path="adress.state">numAffilation</form:label></td>
        <td><form:input  path="patientDetailsModel.numAffilation" id="numAffilation"/></td>  
         <td><form:label path="adress.country">numPriseEnCharge</form:label></td>
        <td><form:input  path="patientDetailsModel.numPriseEnCharge" id="numPriseEnCharge"/></td>  
           
    </tr>
     
        
       <tr>
        <td><form:label path="adress.country">dateDebut</form:label></td>
        <td><form:input class=" focused datepicker" path="patientDetailsModel.dateDebut" id="dateDebut"/></td>
        <td><form:label path="adress.state">dateFin</form:label></td>
        <td><form:input class=" focused datepicker" path="patientDetailsModel.dateFin" id="dateFin"/></td>    
           
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
<!-- 				<a href="#" class="btn btn-primary">Save changes</a> -->
<!-- 			</div> -->
		</div>
		
		
		
		

		
		
		
		</sec:authorize>
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

// function affichage(id,c){
  
//  	$("#icn").val($("#iCardNumber"+id).text());
 
//  	$("#fn").val($("#fName"+id).text());
 	
//  	$("#ln").val($("#lName"+id).text());
 	
//  	$("#em").val($("#email"+id).text());
 	 
//  	$("#bir").val($("#birthday"+id).text());
 	
//  	$("#phone").val($("#phoneNumber"+id).text());
 	
//  	$("#adr").val($("#adress"+id).text());
	 
//  	$("#coun").val($("#country"+id).text());
 	
//  	$("#sta").val($("#state"+id).text());
 	
//  	$("#gen").val($("#gender"+id).text());
 	
// 	$("#edui").attr("action","editeInformationUser?id="+c);
	
	
	
// }

function affichage(id,c){
	$('#myModal').modal('show');
	
	
 	$("#DOIT").val($("#DOIT"+id).text());
 
 	$("#affile").val($("#affile"+id).text());
 	
 	$("#numAffilation").val($("#numAffilation"+id).text());
 	
 	$("#numPriseEnCharge").val($("#numPriseEnCharge"+id).text());
 	
 	$("#edui").attr("action","editePatientDetails?id="+c);
 	 
//  	$("#bir").val($("#birthday"+id).text());
 	
//  	$("#phone").val($("#phoneNumber"+id).text());
 	
//  	$("#adr").val($("#adress"+id).text());
	 
//  	$("#coun").val($("#country"+id).text());
 	
//  	$("#sta").val($("#state"+id).text());
 	
//  	$("#gen").val($("#gender"+id).text());
 	
// 	$("#edui").attr("action","editeInformationUser?id="+c);
	
	
	
}





function saveInfo(){
	
  alert($("#userId").text());
	$("#adui").attr("action","addUserInformation?id="+$("#userId").text());	
}


function validation1(){
	
// 	alert("in");




	
	var DOIT=$("#DOIT"),
	affile=$("#affile"),numPriseEnCharge=$("#numPriseEnCharge"),
	numAffilation=$("#numAffilation"),dateDebut=$("#dateDebut"),dateFin=$("#dateFin"),
		
		valid=true,
		
		fields=$([]).add(DOIT).add(affile).add(numPriseEnCharge).add(numAffilation).add(dateDebut).add(dateFin);
		
	fields.removeClass("alert alert-error");
	
	
	if (DOIT.val().length==0 ){
		
		DOIT.addClass("alert alert-error");
		valid=false;
		
	}
	
    if (affile.val().length==0){
		
    	affile.addClass("alert alert-error");
		valid=false;
		
	}
	
	 if (numPriseEnCharge.val().length==0){
			
		 numPriseEnCharge.addClass("alert alert-error");
			valid=false;
			
		}
		
		
		if (numAffilation.val().length==0){
			
			numAffilation.addClass("alert alert-error");
				valid=false;
				
			}
		
if (dateDebut.val().length==0){
			
	dateDebut.addClass("alert alert-error");
				valid=false;
				
			}
			
if (dateFin.val().length==0){
	
	dateFin.addClass("alert alert-error");
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

</script>



</body>


</html>
