<%@page import="com.haythem.persistance.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html lang="en">


<head>

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
<link rel="shortcut icon" href="/resources/img/favicon.ico">
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
				</a> <a class="brand" href="index-2">  <span>${cliniqueName}</span></a>

				<!-- start: Header Menu -->
				<div class="btn-group pull-right">
				
					<!-- start: User Dropdown -->
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i><span class="hidden-phone hidden-tablet">
							<sec:authentication property="name"/></span> <span class="caret"></span>
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
					    
					    
					    
					    
					    
<!-- 					    ***************************************Supervisor**************************************** -->
					     <sec:authorize access="hasRole('ROLE_SUPERVISOR')">
					    <li><a href="index-2"><i class="icon-home"></i><span class="hidden-tablet"> Dashboard</span></a></li>
					    <li><a href="SupervisorUser"><i class="icon-home"></i><span class="hidden-tablet"> Supervisor </span></a></li>
					     </sec:authorize>
					     
<!--  					    *********************************END menu Supervisor*********************************************** --> 
  
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
						<li><a href="#">Dashboard</a></li>
					</ul>
				</div>
				<div class="sortable row-fluid">

					<div class="box-small span2">
						<a data-rel="tooltip" 
							class="box-small-link" href="#">
							<div id="mesure-count"></div>
						</a>
						<div class="box-small-title">Seance Number</div>
<!-- 						<span id="visits-count-n" class="notification">+ 55%</span> -->
					</div>

					<div class="box-small span2">
						<a data-rel="tooltip" 
							class="box-small-link" href="#">
							<div id="members-count"></div>
						</a>
						<div class="box-small-title" >Members</div>
<!-- 						<span id="members-count-n" class="notification green">+ -->
<!-- 							1.586</span> -->
					</div>

					<div class="box-small span2">
						<a data-rel="tooltip" 
							class="box-small-link" href="#">
							<div id="watch-count"></div>
						</a>
						<div class="box-small-title">Watchs</div>
<!-- 						<span id="income-count-n" class="notification yellow">+ -->
<!-- 							$29.875</span> -->
					</div>

					<div class="box-small span2">
						<a data-rel="tooltip" 
							class="box-small-link" href="#">
							<div id="patient-count"></div>
						</a>
						<div class="box-small-title">Patients </div>
<!-- 						<span id="sales-count-n" class="notification red">+ 1.296</span> -->
					</div>
					<div class="box-small span2">
						<a data-rel="tooltip" 
							class="box-small-link" href="#">
							<div id="risk-detected-count"></div>
						</a>
						<div class="box-small-title">Patient Measurements</div>
<!-- 						<span id="visits-count-n" class="notification">+ 55%</span> -->
					</div>
					

				</div>

				<hr>




				<div class="row-fluid">

					<div class="box span8">
						<div class="box-header">
							<h2>
								<i class="icon-signal"></i><span class="break"></span>Real Time Measurements
<%-- 								<form:select data-rel="chosen" class="control-label input-xlarge focused" for="selectError" path="username" id="u" items="${userNames}" /> --%>
<%-- 								<form:input class="input-xlarge focused" path="user.id" id="user"/> --%>

							</h2>
							<div class="box-icon">
<!-- 								<a href="#" class="btn-setting"><i class="icon-wrench"></i></a> -->
								<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
								<a href="#" class="btn-close"><i class="icon-remove"></i></a>
							</div>
						</div>
						<div class="box-content">
							<div id="mesure" class="center" style="height: 300px"></div>
							<p id="hoverdata">
								Mouse position at (<span id="x">0</span>, <span id="y">0</span>).
								<span id="clickdata"></span>
							</p>
						</div>
						<form:form method="POST"  action="addUser" id="frma" commandName="userModel" onsubmit="return validation()" >
   <table>
   <div align="center">
    <tr>
         <form:select data-rel="chosen" class="control-label input-xlarge focused" for="selectError" path="username" id="username" items="${userNames}" />
    </tr>
						</div>
						
</table>  
</form:form>
					</div>
					
<div class="row-fluid sortable">
				<div class="box span4">
					<div class="box-header">
						<h2><i class="icon-list-alt"></i><span class="break"></span>Users Statistics</h2>
						<div class="box-icon">
<!-- 							<a href="#" class="btn-setting"><i class="icon-wrench"></i></a> -->
							<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
							<div id="piechart" style="height:300px"></div>
					</div>
				</div>
					

				
				
				<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="icon-user"></i><span class="break"></span>Send Message to Admin</h2>
						<div class="box-icon">
<!-- 							<a href="#" class="btn-setting"><i class="icon-wrench"></i></a> -->
							<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
					

						<form:form method="POST"   action="sendMail" commandName="mailModel" >
   <table>
   <div align="center">
   <tr>
       
        <td><form:input path="to" id="to" style="display: none;" /></td>
<%--         <td><form:errors path="username" ui-state-error class="alert alert-error"/></td> --%>
        
   
       
        <td><form:input path="object" id="addname" style="display: none;"/></td>
<%--         <td><form:errors path="username" ui-state-error class="alert alert-error"/></td> --%>
        
    </tr>
    <tr>
        <td><form:label path="body" ></form:label></td>
        <td><form:input path="body" id="addpwd" /></td>
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
			

				<hr>
<!-- 			********************************Statistique******************************************** -->
       <% int j=0; %>
  <c:forEach var="u" items="${stat}">
   	  <% j=j+1; %>
  <input type="hidden" id="<%= "adm"+ j %>" value="${u}">
  
  </c:forEach>
<!--   ******************************************************************************* -->




				
				


				<!-- end: Content -->
			</div>
			<!--/#content.span10-->
		</div>
		<!--/fluid-row-->
		
		
		
		
		
		

		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>Settings</h3>
			</div>
			<div class="modal-body">
				<p>Here settings can be configured...</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">Close</a> <a href="#"
					class="btn btn-primary">Save changes</a>
			</div>
		</div>

		<div class="clearfix"></div>
		<hr>

		<footer>
			<p class="pull-left">
				&copy; <a href="#" target="_blank">HANTOR</a> 2014
			</p>
			<p class="pull-right">
				Powered by: <a href="#">Educanet</a>
			</p>
		</footer>

	</div>
	<!--/.fluid-container-->

	<!-- start: JavaScript-->
	<script src="<c:url value="/resources/js/jquery-1.7.2.min.js" />"></script>

<!-- *****Json********* -->
<script src="<c:url value="/resources/js/jquery.sparkline.js" />"></script>


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
	
	
	
	
	
	
	<script type="text/javascript">
    function crunchifySparkline() {
        $.ajax({
            url : 'mesure?id='+$("#username").val(),
            dataType : "json",
            cache : false,
            contentType : 'application/json; charset=utf-8',
            type : 'GET',
            success : function(result) {
                var one = result.sparkData;
           //  alert(result);
               charts(one);
                //consumeJSONData(one);
            }
        });
    }
 
   
    
//     function consumeJSONData(sparkData) {
//         console.log(sparkData);
     
        
//         for ( var i = 0; i < sparkData.length; i++) {
//             var obj = sparkData[i];
//             var crunchifyName;
//             var crunchifyValue;
//             for ( var key in obj) {
//                 crunchifyName = key;
//                 crunchifyValue = obj[key].toString();
//                 crunchifyValue = crunchifyValue.substr(1);
//                 crunchifyValue = crunchifyValue.substring(0,
//                         crunchifyValue.length - 1);
//                 var n = crunchifyValue.split(",");
//                 console.log(n);
//                 $("#" + crunchifyName).sparkline(n, {
//                     type : 'line',
//                     width : '80',
//                     fillColor : '#eeeeee'
//                 });
//             }
//         }
//     }
</script>
 
<script type="text/javascript">
    var intervalId = 0;
   intervalId = setInterval(crunchifySparkline, 1000);
  
</script>

	
	<script type="text/javascript" language="JavaScript">
	
	
	//chart du statistique du nombre de admin, patient et supervisor
	
	 var adm=parseInt($("#adm1").val()),

		pat=parseInt($("#adm2").val()),
		
		sup=parseInt($("#adm3").val());
	 crunchifySparkline();

	 
	 
	 
// 		function message_welcome1() {
// 			var unique_id = $.gritter.add({
// 				// (string | mandatory) the heading of the notification
// 				title : 'Welcome on Optimus Dashboard',
// 				// (string | mandatory) the text inside the notification
// 				text : 'I hope you like this template',
// 				// (string | optional) the image to display on the left
// 				//image : '/resources/img/avatar.png',
// 				// (bool | optional) if you want it to fade out on its own or just sit there
// 				sticky : false,
// 				// (int | optional) the time you want it to be alive for before fading out
// 				time : '',
// 				// (string | optional) the class name you want to apply to that specific message
// 				class_name : 'my-sticky-class'
// 			});
// 		}

// 		function message_welcome2() {
// 			var unique_id = $.gritter
// 					.add({
// 						// (string | mandatory) the heading of the notification
// 						title : 'Optimus is Amazing Theme',
// 						// (string | mandatory) the text inside the notification
// 						text : 'Optimus works on all devices, computers, tablets and smartphones. Optimus has lots of great features. Try It!',
// 						// (string | optional) the image to display on the left
// 						//image : '/resources/img/avatar.png',
// 						// (bool | optional) if you want it to fade out on its own or just sit there
// 						sticky : false,
// 						// (int | optional) the time you want it to be alive for before fading out
// 						time : '',
// 						// (string | optional) the class name you want to apply to that specific message
// 						class_name : 'my-sticky-class'
// 					});
// 		}

// 		function message_welcome3() {
// 			var unique_id = $.gritter.add({
// 				// (string | mandatory) the heading of the notification
// 				title : 'Buy Optimus!',
// 				// (string | mandatory) the text inside the notification
// 				text : 'This great template can be yours today.',
// 				// (string | optional) the image to display on the left
// 				//image : '/resources/img/avatar.png',
// 				// (bool | optional) if you want it to fade out on its own or just sit there
// 				sticky : false,
// 				// (int | optional) the time you want it to be alive for before fading out
// 				time : '',
// 				// (string | optional) the class name you want to apply to that specific message
// 				class_name : 'gritter-light'
// 			});
// 		}

// 		$(document).ready(function() {

// 			setTimeout("message_welcome1()", 5000);
// 			setTimeout("message_welcome2()", 10000);
// 			setTimeout("message_welcome3()", 15000);
// 			setInterval(f_visits, 100);
// 			setInterval(f_members, 2000);
// 			setInterval(f_income, 5000);
// 			setInterval(f_sales, 5000);
// 			setInterval(live_notifications_center, 5000);

// 		});
		
		
		
	</script>
	<!-- end: JavaScript-->

</body>


</html>
