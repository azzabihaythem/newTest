<%@page import="com.haythem.persistance.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


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
<meta name="description"
	content="Optimus Dashboard Bootstrap Admin Template.">
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
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a> <a class="brand" href="index-2"> <span>${cliniqueName}</span></a>

				<!-- start: Header Menu -->
				<div class="btn-group pull-right">
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
						<i class="icon-user"></i><span class="hidden-phone hidden-tablet">
							<sec:authentication property="name" />
					</span> <span class="caret"></span>
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
							<li><a href="index-2"><i class="icon-home"></i><span
									class="hidden-tablet"> Dashboard</span></a></li>
							<li><a href="table"><i class="icon-user"></i><span
									class="hidden-tablet"> Users authentication</span></a></li>
							<li><a href="userinformation"><i class="icon-eye-open"></i><span
									class="hidden-tablet"> Users Informations </span></a></li>
							<li><a href=" PatientDetailsinformation"><i
									class="icon-eye-open"></i><span class="hidden-tablet">
										Patient informations </span></a></li>
							<li><a href=" CliniqueInformations"><i
									class="icon-eye-open"></i><span class="hidden-tablet">
										Clinique informations </span></a></li>
							<li><a href="Seance"><i class="icon-eye-open"></i><span
									class="hidden-tablet"> Seance </span></a></li>

							<!-- 				        <li><a href="Watchs"><i class="icon-eye-open"></i><span class="hidden-tablet"> Watchs </span></a></li> -->
							<!-- 					    <li><a href="Patient"><i class="icon-eye-open"></i><span class="hidden-tablet"> Patient </span></a></li> -->
							<!-- 					   <li><a href="Measurement"><i class="icon-eye-open"></i><span class="hidden-tablet">Measurement</span></a></li> -->
							<!-- 					    <li><a href="Supervisor"><i class="icon-eye-open"></i><span class="hidden-tablet"> Supervisor </span></a></li> -->
						</sec:authorize>



						<!--  					    *********************************start menu Patient*********************************************** -->
						<sec:authorize access="hasRole('ROLE_PATIENT')">

							<li><a href="index-2"><i class="icon-home"></i><span
									class="hidden-tablet"> Dashboard</span></a></li>
							<li><a href="PatientUser"><i class="icon-home"></i><span
									class="hidden-tablet"> Patient </span></a></li>

						</sec:authorize>
						<!--  					    *********************************Patient*********************************************** -->

						<li><a href="login"><i class="icon-lock"></i><span
								class="hidden-tablet"> Login Page</span></a></li>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<!-- end: Main Menu -->
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>
						You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
							target="_blank">JavaScript</a> enabled to use this site.
					</p>
				</div>
			</noscript>

			<div id="content" class="span10">
				<!-- start: Content -->


				<div>
					<ul class="breadcrumb">
						<li><a href="#">Home</a> <span class="divider">/</span></li>
						<li><a href="#">PATIENT</a></li>
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
								<h2>
									<i class="icon-user"></i><span class="break"></span>Observations
								</h2>
								<div class="box-icon">

									<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="btn-close"><i class="icon-remove"></i></a>
								</div>
							</div>
							<div class="box-content">
								<h2>Patient</h2>

								<table
									class="table table-striped table-bordered bootstrap-datatable datatable">
									<thead>

										<tr>
									 	    <th>heure</th>
											<th>tension_arterielle</th>
											<th>heparine</th>
											<th>fdebit_sang</th>
											<th>uf</th>
											<th>pv</th>
											<th>ptm</th>
											<th>uf_cumule</th>
											<th>observation</th>
											<th>Actions</th>
										</tr>
									</thead>

									<tbody>

										<%
											int j = 0;
										%>
										<c:forEach var="u" items="${observationsList}">

											<%
												j = j + 1;
											%>

											<tr id="Line${u.id}">
											    <td id="<%="heure" + j%>">${u.heure}</td>
												<td id="<%="tension_arterielle" + j%>">${u.tension_arterielle_s}/${u.tension_arterielle_d}</td>
												<td id="<%="heparine" + j%>">${u.heparine}</td>
												<td id="<%="debit_sang" + j%>">${u.debit_sang}</td>
                                                <td id="<%="uf" + j%>">${u.uf}</td>
                                                <td id="<%="pv" + j%>">${u.pv}</td>
                                                <td id="<%="ptm" + j%>">${u.ptm}</td>
                                                <td id="<%="uf_cumule" + j%>">${u.uf_cumule}</td>
                                                <td id="<%="observation" + j%>">${u.observation}</td>
												<td class="center"><a  class="btn btn-danger"  onClick="deleteObservation(${u.id},${bilanId})">
														<i class="icon-trash icon-white"></i>
												</a></td>
											</tr>

										</c:forEach>
									</tbody>
								</table>
								<h3>
									<!-- 									<a href="downloadPatientWatchPdf"><img -->
									<!-- 										class="dashboard-avatar" -->
									<%-- 										src="<c:url value="/resources/img/Icone_pdf.png" />"></a> --%>
								</h3>
							</div>
						</div>
						<!--/span-->

					</div>
	









<div class="row-fluid sortable">	
				<div class="box span12">
					<div class="box-header">
						<h2><i class="icon-align-justify"></i><span class="break"></span>Ajout Observation</h2>
						<div class="box-icon">
							
							<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
					<form:form method="POST"   id="adui" action="addObservation" commandName="observationModel">
   <table >

     <tr>
        <td><form:label path="heure">Heure</form:label></td>
        <td><form:input class="input-xlarge focused" path="heure" id="heure" type="time"/></td>
        
        <td><form:label path="tension_arterielle_s">Tension Arterielle</form:label></td>
        <td><form:input class="input-xlarge focused" path="tension_arterielle_s" type="number"  id="tension_arterielle_s"/>
        <form:input class="input-xlarge focused" path="tension_arterielle_d" type="number"  id="tension_arterielle_d"/></td>           
    </tr>
    
    <tr>
        <td><form:label path="heparine">Heparine (mg)</form:label></td>
        <td><form:input class="input-xlarge focused" path="heparine" id="heparine"  type="number" step="0.01"/></td>
        
        <td><form:label path="debit_sang">Debit sang</form:label></td>
        <td><form:input class="input-xlarge focused" path="debit_sang" id="debit_sang" type="number" step="0.01"/></td>           
    </tr>
    
    <tr>
        <td><form:label path="uf">UF</form:label></td>
        <td><form:input class="input-xlarge focused" path="uf" id="uf" type="number" step="0.01"/></td>
        
        <td><form:label path="pv">PV</form:label></td>
        <td><form:input class="input-xlarge focused" path="pv" id="pv" type="number" step="0.01"/></td>           
    </tr>
    
    <tr>
        <td><form:label path="ptm">PTM</form:label></td>
        <td><form:input class="input-xlarge focused" path="ptm" id="ptm" type="number" step="0.01"/></td>
        
        <td><form:label path="uf_cumule">UF cumule</form:label></td>
        <td><form:input class="input-xlarge focused" path="uf_cumule" id="uf_cumule" type="number" step="0.01"/></td>           
    </tr>
    
    <tr>
        <td><form:label path="observation">Observation</form:label></td>
        <td><form:input class="input-xlarge focused" path="observation" id="observation"/></td>         
    </tr>
   
     <tr style="display:none">
        <td><form:label path="bilanId">bilanId</form:label></td>
        <td><form:input class="input-xlarge focused" path="bilanId" id="bilanId"/></td>                
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
			

				</sec:authorize>


				<!-- end: Content -->
			</div>
			<!--/#content.span10-->
		</div>
		<!--/fluid-row-->



		<hr>

		<footer>
			<p class="pull-left">
				&copy; <a href="#" target="_blank">Hantor</a> 2014
			</p>
			<p class="pull-right">
				Powered by: <a href="#">Auxilium</a>
			</p>
		</footer>

	</div>
	<!--/.fluid-container-->

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
	
	//$("#myModal").html("<p>exemple</p>");
		$('#myModal').modal('show');
	$("#wsnb").val($("#wSNumber"+j).text());
	
	$("#hv").val($("#hVersion"+j).text());
	
// 	$("#sv").val($("#sVersion"+j).text());
	
	$("#ct").val($("#cType"+j).text());

	$("#frmew").attr("action","editSeance?id="+id);
	
	
}


function validation1(){
	
// 	alert("in");
	
	var hv=$("#hv"),
	sv=$("#sv"),
		
		valid=true,
		
		fields=$([]).add(hv).add(sv);
		
	fields.removeClass("alert alert-error");
	
	
	if (hv.val().length==0){
		
		hv.addClass("alert alert-error");
		valid=false;
		
	}
	
if (sv.val().length==0){
		
	sv.addClass("alert alert-error");
		valid=false;
		
	}

	
	return valid;
	
}

function validation2(){
	
// 	alert("in");
	
	var number=$("#number"),
	
		
		valid=true,
		
		fields=$([]).add(number);
		
	fields.removeClass("alert alert-error");
	
	
	if (isNaN(number.val())&&number.val().length!=0){
		
		number.addClass("alert alert-error");
		valid=false;
		
	}
	

	
	return valid;
	
}


function validation(){
	
// 	alert("in");

	
	var hbRef=$("#hbRef"),
	SRef=$("#SRef"),
		
		valid=true,
		
		fields=$([]).add(hbRef).add(SRef);
// 	alert(isNaN(hbRef));
// 	alert(isNaN(SRef));
		
	fields.removeClass("alert alert-error");
	
	
	if (hbRef.val().length==0 ){
		
		hbRef.addClass("alert alert-error");
		valid=false;
		
	}
	
//    if (!isNaN(hbRef)){
		
// 		hbRef.addClass("alert alert-error");
// 		valid=false;
		
// 	}
	
	
	
if (SRef.val().length==0 ){
		
	SRef.addClass("alert alert-error");
		valid=false;
		
	}
	
// if (!isNaN(SRef)){
	
// 	SRef.addClass("alert alert-error");
// 		valid=false;
		
// 	}
	
	return valid;
	
}


function cleareNumber(){
	
	$("#number").val("");
	
}

function SaveSeance(){
// 	alert($('#type').val());

	if ( $('#userId').val()!="") {
    	

		$.ajax({
			url : 'addAjaxSeance',
			type : 'POST',
			data:{user:$('#userId').val(),type:$('#type').val(),date:$('#date2').val()},
			success : function(data) {
// 				alert("Seance Added");
				 $('#met').modal("show");
			},
			error: function( jqXHR,textStatus,errorThrown){
				
				alert("error");
				
			}
		});
		
		
    }
    
//     calendar.fullCalendar('unselect');
	
}



// function SaveSeanceDay(){
// // 	alert($('#type').val());


// var searchIDs = [];

//   $("#daysTable input:checkbox:checked").map(function(){
//     searchIDs.push($(this).val());
//   });
  
  
// //   alert(searchIDs);
// //   alert(searchIDs[1]);
// 	if ( $('#userId').val()!="") {
    	
// 		var i = 0;
// 		for (i = 0; i < searchIDs.length; i++) {
// 		$.ajax({
// 			url : 'addAjaxSeanceDay',
// 			type : 'POST',
// // 			data:{user:$('#adui').serializeArray()},
// 			data:{user:$('#userId1').val(),day:searchIDs[i],index:i},
// 			success : function(data) {
// // 				alert("Seance Added");
// 				 $('#met2').modal("show");
// 			},
// 			error: function( jqXHR,textStatus,errorThrown){
				
// 				alert("error");
				
// 			}
// 		});
		
// 		}
//     }
    
// //     calendar.fullCalendar('unselect');
	
// }




function SaveSeanceDay(){
// 	alert($('#type').val());


var searchIDs = [];

  $("#daysTable input:checkbox:checked").map(function(){
    searchIDs.push($(this).val());
  });
  
  
//   alert(searchIDs);
//   alert(searchIDs[1]);
	if ( $('#userId').val()!="") {
    	
		var i = 0;
// 		for (i = 0; i < searchIDs.length; i++) {
		$.ajax({
			url : 'addAjaxSeanceDay',
			type : 'POST',
			data: $('#adui1').serializeArray(),
			success : function(data) {
// 				alert("Seance Added");
				 $('#met2').modal("show");
			},
			error: function( jqXHR,textStatus,errorThrown){
				
				alert("error");
				
			}
		});
		
// 		}
    }
    
//     calendar.fullCalendar('unselect');
	
}



function deleteObservation(idObs,bilanid){
	 document.location.href = "deleteobservation?idobs="+idObs+"&idBilan="+bilanid;
}




function deleteAjaxSeance(iduser){
// 	alert($('#type').val());


	
    	
 $("#Line"+iduser).css("display", "none");

		$.ajax({
			url : 'deletAjaxSeance',
			type : 'POST',
			data:{id:iduser},
			success : function(data) {
// 				alert("Seance Added");
				 $('#met2').modal("show");
				
			},
			error: function( jqXHR,textStatus,errorThrown){
				 $("#Line"+iduser).css("display", "block");
				alert("error");
				
			}
		});
		

}
    
//     calendar.fullCalendar('unselect');
	
</script>
<script>
$( function() {
    $( "#datepicker1" ).datepicker();
  } );
$("#datepicker1").change(function() {
//     alert($(this).val());
    
    var date = $(this).datepicker('getDate'),
    month = date.getMonth(),              
    year =  date.getFullYear();
    document.getElementById("txtfileid").href="/txt?m="+month+"&&year="+year; 
});
</script>

</body>


</html>
