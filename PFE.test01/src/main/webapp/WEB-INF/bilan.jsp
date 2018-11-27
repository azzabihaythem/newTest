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
					<div class="box-header">
						<h2><i class="icon-align-justify"></i><span class="break"></span>Ajout Bilan</h2>
						<div class="box-icon">
							
							<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
					<form:form method="POST"   id="adui" action="addBilan" commandName="bilanModel" onsubmit="return validation()">
   <table >
<td><form:label path="infirmierName">Nom du Responsable</form:label></td>
        <td>
        <form:select data-rel="chosen" class="control-label input-xlarge focused" for="selectError" path="infirmierName" id="infirmierName" items="${userNames}" />
        </td>     
</tr>
     <tr>
        <td><form:label path="poidsDebut">Generateur</form:label></td>
        <td><form:input class="input-xlarge focused" path="generateur" id="generateur" value="Fresenius"/></td>
        
        <td><form:label path="Filtre">Filtre</form:label></td>
        <td><form:input class="input-xlarge focused" path="Filtre" id="Filtre"/></td>           
    </tr>
    
    <tr>
        <td><form:label path="poidsDebut">Poids Sec</form:label></td>
        <td><form:input class="input-xlarge focused" path="PoidsSec" id="PoidsSec" type="number" step="0.01"/></td>
        
        <td><form:label path="UFTDuree">UFT Duree</form:label></td>
        <td><form:input class="input-xlarge focused" path="UFTDuree" id="UFTDuree" type="number" step="0.01" /></td>           
    </tr>
    
    <tr>
        <td><form:label path="DebutDeDialyse">Debut De Dialyse</form:label></td>
        <td><form:input class="input-xlarge focused" path="DebutDeDialyse" id="DebutDeDialyse" type="time"/></td>
        
        <td><form:label path="poidsDebut">Poids Debut</form:label></td>
        <td><form:input class="input-xlarge focused" path="poidsDebut" id="poidsDebut" type="number" step="0.01"/></td>           
    </tr>
    
    <tr>
        <td><form:label path="priseDePoids">Prise De Poids</form:label></td>
        <td><form:input class="input-xlarge focused" path="priseDePoids" id="priseDePoids" type="number" step="0.01"/></td>
        
         <td><form:label path="TensionarterielleDebut">Tensionarterielle Debut</form:label></td>
        <td><form:input class="input-xlarge focused" path="TensionarterielleDebut.systolique" type="number"  id="TensionarterielleDebut"/>
        <form:input class="input-xlarge focused" path="TensionarterielleDebut.diastolique"  type="number"  id="TensionarterielleDebut"/></td>        
    </tr>
    
    <tr>
        <td><form:label path="FinDeDialyse">Fin De Dialyse</form:label></td>
        <td><form:input class="input-xlarge focused" path="FinDeDialyse" id="FinDeDialyse" type="time"/></td>
        
        <td><form:label path="poidsFin">Poids Fin</form:label></td>
        <td><form:input class="input-xlarge focused" path="poidsFin" id="poidsFin" type="number" step="0.01"/></td>           
    </tr>
    
    <tr>
        <td><form:label path="perteDePoids">perte De Poids</form:label></td>
        <td><form:input class="input-xlarge focused" path="perteDePoids" id="perteDePoids" type="number" step="0.01"/></td>
        
        <td><form:label path="TensionarterielleFin">Tensionarterielle Fin</form:label></td>
        <td><form:input class="input-xlarge focused" path="TensionarterielleFin.systolique" type="number"  id="TensionarterielleFin"/>
        <form:input class="input-xlarge focused" path="TensionarterielleFin.diastolique" type="number"  id="TensionarterielleFin"/></td>           
    </tr >
    
     <tr>
        <td><form:label path="heparine">heparine</form:label></td>
        <td><input type="checkbox" ${checked} name="heparine" value="true"><br></td>
        
        <td><form:label path="Traitement">Traitement</form:label></td>
        <td><form:input class="input-xlarge focused" path="Traitement" id="Traitement"/></td>           
    </tr>
    
    <tr>
        <td><form:label path="observationMedicales">Observations Medicales</form:label></td>
        <td><form:input class="input-xlarge focused" path="observationMedicales" id="observationMedicales"/></td>
        
         <td><form:label path="UFT">UFT</form:label></td>
         <td><form:input class="input-xlarge focused" path="UFT" id="UFT" type="number" step="0.01"/></td>           
    </tr>
    
     <tr style="display:none">
        <td><form:label path="seanceId">SeanceId</form:label></td>
        <td><form:input class="input-xlarge focused" path="seanceId" id="seanceId"/></td>                
     </tr>
    
<%--     <% int obs=0;%> --%>
<%--     <%= obs %> --%>
<!--     <tr> -->
<%--          <td><form:input class="input-xlarge focused" path="observationModel[<%= obs %>].heure"  placeholder="Heure" id="observationModel[<%= obs %>].heure"/></td>     --%>
<%--          <td><form:input class="input-xlarge focused" path="observationModel[<%=obs%>].tension_arterielle"  placeholder="Tension Arterielle" id="observationModel[<%=obs%>].tension_arterielle"/></td>   --%>
<!--    </tr><tr>       -->
<%--          <td><form:input class="input-xlarge focused" path="observationModel[<%=obs%>].heparine"  placeholder="heparine" id="observationModel[<%=obs%>].heparine"/></td> --%>
<%--          <td><form:input class="input-xlarge focused" path="observationModel[<%=obs%>].debit_sang"  placeholder="debit_sang" id="observationModel[<%=obs%>].debit_sang"/></td> --%>
<!--    </tr><tr>   -->
<%--          <td><form:input class="input-xlarge focused" path="observationModel[<%=obs%>].uf"  placeholder="uf" id="observationModel[<%=obs%>].uf"/></td> --%>
<%--          <td><form:input class="input-xlarge focused" path="observationModel[<%=obs%>].pv"  placeholder="pv" id="observationModel[<%=obs%>].pv"/></td> --%>
<!--     </tr><tr> -->
<%--          <td><form:input class="input-xlarge focused" path="observationModel[<%=obs%>].ptm"  placeholder="ptm" id="observationModel[<%=obs%>].ptm"/></td>          --%>
<%--          <td><form:input class="input-xlarge focused" path="observationModel[<%=obs%>].uf_cumule"  placeholder="uf_cumule" id="observationModel[<%=obs%>].uf_cumule"/></td> --%>
<!--     </tr> -->
    <tr>
 <%--          <td><form:input class="input-xlarge focused" path="observationModel[<%=obs%>].observation"  placeholder="observation" id="observationModel[<%=obs%>].observation"/></td>   --%> 
<%--           <td><a href="addObservation?id=${u.id}"> <input class="btn btn-primary" type="button" onClick="addObservation()" value="add observation"/></a></td>                                             --%>
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
			
			<div class="row-fluid sortable">	
				<div class="box span12">
					<div class="box-header">
						<h2><i class="icon-align-justify"></i><span class="break"></span>Ajout Observations</h2>
						<div class="box-icon">
							
							<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
			
	  <td><a href="observation?id=${bilanId}">Ajouter des observations <img src="<c:url value="/resources/img/observation.png"/>" height="42" width="42" ></a></td>		
	  </div>
	  </div>
	  	
<!--  *************************end 3**************************** -->			
			
		
    
					<!-- end: Content -->
			</div><!--/#content.span10-->
				</div><!--/fluid-row --> 
				
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
	




</body>


</html>
