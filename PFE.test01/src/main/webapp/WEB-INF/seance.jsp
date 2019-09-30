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
									<i class="icon-user"></i><span class="break"></span>Patient
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
											<th>user User-Name</th>
											<th>Type</th>
											<th>Date</th>
											<th>Bilan</th>
											<th>Actions</th>
										</tr>
									</thead>

									<tbody>

										<%
											int j = 0;
										%>
										<c:forEach var="u" items="${seanceList}">

											<%
												j = j + 1;
											%>

											<tr id="Line${u.id}">
												<td id="<%="wSNumber" + j%>">${u.user.username}</td>
												<td id="<%="hVersion" + j%>">${u.type.typeName}</td>
												<td id="<%="sVersion" + j%>" class="center">${fn:substring(u.date,
													0, 10)}</td>

                                                <td id="<%="hBilan" + j%>">
                                                  <a href="bilan?id=${u.id}">
                                                  <img src="<c:url value="/resources/img/observation.png"/>" height="42" width="42" >
                                                  </a>
                                                  <a href="downloadBilanSeancePdf?idSeance=${u.id}">PDF
                                                  </a>
                                                </td>
												<td class="center"><a class="btn btn-info btn-setting"
													onclick="affichage(<%= j %>,${u.id})"> <i
														class="icon-edit icon-white"></i>
												</a> <a  class="btn btn-danger"  onClick="deleteAjaxSeance(${u.id})">
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
					<!--/row-->
					<div class="modal hide fade" id="myModal">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">Close</button>
							<h3>Edite Seance</h3>

						</div>
						<div class="modal-body">
							<form:form method="POST" id="frmew" commandName="seanceModel"
								onsubmit="return validation1()">
								<table>


									<tr>
										<td><form:label path="user" style="display: none;">user UserName</form:label></td>
										<td><form:input path="user" id="wsnb"
												style="display: none;" /></td>
									</tr>
									<tr>
										<td><form:label path="type">type</form:label></td>
										<td><form:input path="type" id="hv" /></td>
									</tr>
									<tr>
										<td><form:label path="date">date</form:label></td>
										<td><form:input path="date"
												class="input-xlarge datepicker" id="sv" /></td>
									</tr>



									<tr>

										<td colspan="2"><input class="btn btn-primary"
											type="submit" value="Save changes" /> <a href="#"
											class="btn" data-dismiss="modal">Close</a></td>
									</tr>

								</table>
							</form:form>
						</div>
						<div class="modal-footer">
							<!-- 				<a href="#" class="btn" data-dismiss="modal">Close</a> -->
							<!-- 				<a href="#" class="btn btn-primary" type="submit" value="Submit" >Save changes</a> -->

						</div>
					</div>

					<!-- ***********************************start 2************************** -->

					<!-- 					<div class="row-fluid sortable"> -->
					<!-- 						<div class="box span12"> -->
					<!-- 							<div class="box-header"> -->
					<!-- 								<h2> -->
					<!-- 									<i class="icon-align-justify"></i><span class="break"></span>Patien-Seance -->
					<!-- 								</h2> -->
					<!-- 								<div class="box-icon"> -->

					<!-- 									<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a> -->
					<!-- 									<a href="#" class="btn-close"><i class="icon-remove"></i></a> -->
					<!-- 								</div> -->
					<!-- 							</div> -->
					<!-- 							<div class="box-content"> -->
					<%-- 								<form:form method="POST" id="adui" action="addSeance" --%>
					<%-- 									commandName="seanceModel" onsubmit="return validation()"> --%>
					<!-- 									<table> -->
					<!-- 										   <div align="center"> -->


					<!-- 										<tr> -->
					<%-- 											<td><form:label path="user">user userName</form:label></td> --%>
					<%-- 											<td><form:select data-rel="chosen" --%>
					<%-- 													class="control-label input-xlarge focused" --%>
					<%-- 													for="selectError" path="user" id="userId" --%>
					<%-- 													items="${patientAv}" /></td> --%>
					<%-- 											        <td><form:input class="input-xlarge focused" path="user.id" id="user.id"/></td>    --%>

					<!-- 										</tr> -->
					<!-- 										<tr> -->
					<%-- 											<td><form:label path="type">type</form:label></td> --%>

					<!-- 											<td> -->
					<%-- 												        <form:input class="input-xlarge focused" path="watch.id" id="watch.id"/> --%>
					<%-- 												<form:select data-rel="chosen" --%>
					<%-- 													class="control-label input-xlarge focused" --%>
					<%-- 													for="selectError" path="type" id="type" items="${typeAv}" /> --%>
					<!-- 											</td> -->

					<!-- 										</tr> -->

					<!-- 										<tr> -->
					<%-- 											<td><form:label path="type">Date</form:label></td> --%>

					<%-- 											<td><form:input path="date" id="date" --%>
					<%-- 													class="input-xlarge datepicker" /></td> --%>

					<!-- 										</tr> -->



					<!-- 										<tr> -->


					<!-- 											<td colspan="2"> -->
					<!-- 												            <input class="btn btn-primary" type="submit" value="Save"/> -->

					<!-- 												<button onClick="SaveSeance()" class="btn btn-primary">add Seance</button> -->
					<!-- 											</td> -->
					<!-- 										</tr> -->
					<!-- 									</table> -->
					<%-- 								</form:form> --%>



					<!-- 							</div> -->
					<!-- 						</div> -->
					<!-- 						/span -->
					<!-- 					</div> -->
					<!-- 					/row -->



					<!-- ****************************************************************** -->

					<!-- ***********************************start 2************************** -->

					<div class="row-fluid sortable">
						<div class="box span12">
							<div class="box-header">
								<h2>
									<i class="icon-align-justify"></i><span class="break"></span>Patien-Seance
								</h2>
								<div class="box-icon">

									<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="btn-close"><i class="icon-remove"></i></a>
								</div>
							</div>
							<div class="box-content">
<%-- 													<form method="POST"  id="adui1" > --%>
								<table>
									<!--    <div align="center"> -->


									<tr>
										<td><label>Patient </label></td>
										<td><select name="category" data-rel="chosen"
											class="control-label input-xlarge focused" id="userId">


												<c:forEach items="${patientAv}" var="patient">
													<option value="${patient}">${patient}</option>
												</c:forEach>
										</select></td>
										<%--         <td><form:input class="input-xlarge focused" path="user.id" id="user.id"/></td>    --%>

									</tr>
									<tr>
										<td><label style="display: none">type</label></td>

										<td>
											<%--         <form:input class="input-xlarge focused" path="watch.id" id="watch.id"/> --%>
											<input class="control-label input-xlarge focused" id="type"
											value="1" style="display: none"></input>
										</td>


									</tr>

									<tr>
										<td><label>Date</label></td>

										<td><input id="date2" class="input-xlarge datepicker" /></td>

									</tr>



									<tr>


										<td colspan="2"><br> <br> <!--             <input class="btn btn-primary" type="submit" value="Save"/> -->
											<input class="btn btn-primary" width="10%"
											onClick="SaveSeance()" value="Add Seance" /> <!-- 											<button onClick="SaveSeance()">add Seance</button> -->
										</td>
									</tr>
								</table>
								<%-- </form:form> --%>

<%-- </form> --%>

							</div>
						</div>
						<!--/span-->
					</div>
					<!--/row-->



					<!-- ****************************************************************** -->

<div class="row-fluid sortable">
							<div class="box span12">
								<div class="box-header">
									<h2>
										<i class="icon-align-justify"></i><span class="break"></span>automatic seance add
									</h2>
									<div class="box-icon">

										<a href="#" class="btn-minimize"><i
											class="icon-chevron-up"></i></a> <a href="#" class="btn-close"><i
											class="icon-remove"></i></a>
									</div>
								</div>
								<div class="box-content">
									<form:form method="POST" id="adui" action="seanecAutomatiqueAdd"
										commandName="SeanecAutomatiqueModel" >
										<table>





											<tr>
												<td><form:label path="date">Date Debut</form:label></td>

												<td><form:input path="date" id="dateId1"
														class="input-xlarge datepicker" /></td>

											</tr>
											<tr>
												<td><form:label path="date2">Date Fin</form:label></td>

												<td><form:input path="date2" id="dateId2"
														class="input-xlarge datepicker" /></td>

											</tr>



											<tr>


												<td colspan="2"><input class="btn btn-primary"
													type="submit" value="add all" /></td>
											</tr>
										</table>
									</form:form>



								</div>
							</div>
							<!--/span-->
						</div>

	<!-- ***********************************start 3************************** -->

					<div class="row-fluid sortable">
						<div class="box span12">
							<div class="box-header">
								<h2>
									<i class="icon-align-justify"></i><span class="break"></span>Patien-Seance-Days
								</h2>
								<div class="box-icon">

									<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="btn-close"><i class="icon-remove"></i></a>
								</div>
							</div>
							<div class="box-content">
							<form method="POST"  id="adui1" name="adui1" >
								<table id="daysTable">
									<!--    <div align="center"> -->


									<tr>
										<td><label>Patient </label></td>
										<td><select name="category" data-rel="chosen"
											class="control-label input-xlarge focused" id="userId1">


												<c:forEach items="${patientAv3}" var="patient">
													<option value="${patient}">${patient}</option>
												</c:forEach>
										</select></td>
										<%--         <td><form:input class="input-xlarge focused" path="user.id" id="user.id"/></td>    --%>

									</tr>
									<tr>
				

									</tr>

									<tr>
										<td><label>Day</label></td>

										<td>  <input type="checkbox" name="Monday" value="Monday"> Monday <br>
                                              <input type="checkbox" name="Tuesday" value="Tuesday"> Tuesday<br>
                                              <input type="checkbox" name="Wednesday" value="Wednesday"> Wednesday<br>
                                              <input type="checkbox" name="Thursday" value="Thursday"> Thursday<br>
                                              <input type="checkbox" name="Friday" value="Friday"> Friday<br>
                                              <input type="checkbox" name="Saturday" value="Saturday"> Saturday<br></td>

									</tr>



									<tr>


										<td colspan="2"><br> <br> <!--             <input class="btn btn-primary" type="submit" value="Save"/> -->
											<input class="btn btn-primary" width="10%"
											onClick="SaveSeanceDay()" value="Add Days" /> <!-- 											<button onClick="SaveSeance()">add Seance</button> -->
										</td>
										<td colspan="2"><br> <br> 
										<input class="btn btn-danger" width="10%"
											onClick="deleteAjaxSeanceDay()" value="Delete All Days" />
										
										</td>
									</tr>
								</table>
								<%-- </form:form> --%>
</form>


							</div>
						</div>
						<!--/span-->
					</div>
					<!--/row-->



					<!-- ****************************************************************** -->




					<!-- ***********************************start 3************************** -->

					<div class="row-fluid sortable">
						<div class="box span12">
							<div class="box-header">
								<h2>
									<i class="icon-align-justify"></i><span class="break"></span>Facture
								</h2>
								<div class="box-icon">

									<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="btn-close"><i class="icon-remove"></i></a>
								</div>
							</div>
							<div class="box-content">
								<form:form method="POST" id="adui" action="downloadSeanceFctPdf"
									commandName="seanceModel" onsubmit="return validation2()">
									<table>
										<!--    <div align="center"> -->


										<tr>
											<td><form:label path="user">user userName</form:label></td>
											<td><form:select data-rel="chosen"
													onchange="cleareNumber()"
													class="control-label input-xlarge focused"
													for="selectError" path="user" id="userId2"
													items="${patientAv2}" /></td>
											<%--         <td><form:input class="input-xlarge focused" path="user.id" id="user.id"/></td>    --%>

										</tr>
										<!--     <tr> -->
										<%--         <td><form:label path="type">MOIS</form:label></td> --%>

										<!--         <td> -->
										<%--         <form:input class="input-xlarge focused" path="watch.id" id="watch.id"/> --%>
										<%--            <form:select data-rel="chosen" class="control-label input-xlarge focused" for="selectError" path="type" id="watch.id" items="${typeAv}" /> --%>
										<!--         </td> -->

										<!--     </tr> -->

										<tr>
											<td><form:label path="type">Date</form:label></td>

											<td><form:input path="date" id="birthday2"
													class="input-xlarge datepicker" onchange="cleareNumber()" /></td>

										</tr>
										<tr>
											<td><form:label path="type">Numero</form:label></td>

											<td><form:input path="number" id="number"
													class="input-xlarge " placeholder="facultatif" /></td>

										</tr>



										<tr>


											<td colspan="2"><input class="btn btn-primary"
												type="submit" formtarget="_blank" value="Save" /></td>
										</tr>
									</table>
								</form:form>



							</div>
						</div>
						<!--/span-->
					</div>
					<!--/row-->



					<!-- ****************************************************************** -->


		<!-- ***********************************start 3.1 ************************** -->

					<div class="row-fluid sortable">
						<div class="box span12">
							<div class="box-header">
								<h2>
									<i class="icon-align-justify"></i><span class="break"></span>Facture All Patient
								</h2>
								<div class="box-icon">

									<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="btn-close"><i class="icon-remove"></i></a>
								</div>
							</div>
							<div class="box-content">
								<form:form method="POST" id="adui" action="downloadSeanceFctPdfTotal"
									commandName="seanceModel2" onsubmit="return validation2()">
									<table>
										<!--    <div align="center"> -->


									
										<!--     <tr> -->
										<%--         <td><form:label path="type">MOIS</form:label></td> --%>

										<!--         <td> -->
										<%--         <form:input class="input-xlarge focused" path="watch.id" id="watch.id"/> --%>
										<%--            <form:select data-rel="chosen" class="control-label input-xlarge focused" for="selectError" path="type" id="watch.id" items="${typeAv}" /> --%>
										<!--         </td> -->

										<!--     </tr> -->

										<tr>
											<td><form:label path="type">Date</form:label></td>

											<td><form:input path="date" id="birthday4"
													class="input-xlarge datepicker" onchange="cleareNumber()" /></td>

										</tr>
									



										<tr>


											<td colspan="2"><input class="btn btn-primary"
												type="submit" formtarget="_blank" value="Save" /></td>
										</tr>
									</table>
								</form:form>



							</div>
						</div>
						<!--/span-->
					</div>



					<!-- ***********************************start 4************************** -->

					<div class="row-fluid sortable">
						<div class="box span12">
							<div class="box-header">
								<h2>
									<i class="icon-align-justify"></i><span class="break"></span>Facture
									Glo
								</h2>
								<div class="box-icon">

									<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="btn-close"><i class="icon-remove"></i></a>
								</div>
							</div>
							<div class="box-content">
								<form:form method="POST" id="adui"
									action="downloadSeanceFctGlobPdf" commandName="seanceModel"
									onsubmit="return validation()">
									<table>
										<!--    <div align="center"> -->


										<tr>
											<td><form:label path="type">Date</form:label></td>

											<td><form:input path="date" id="birthday3"
													class="input-xlarge datepicker" /></td>

										</tr>



										<tr>


											<td colspan="2"><input class="btn btn-primary"
												type="submit" value="Save" /></td>
										</tr>
									</table>
								</form:form>



							</div>
						</div>
						<!--/span-->
					</div>
					<!--/row-->
					
					
					<div class="row-fluid sortable">
						<div class="box span12">
							<div class="box-header">
								<h2>
									<i class="icon-align-justify"></i><span class="break"></span>Text Facture
									Glo
								</h2>
								<div class="box-icon">

									<a href="#" class="btn-minimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="btn-close"><i class="icon-remove"></i></a>
								</div>
							</div>
							<div class="box-content">
								<p>
									Date: <input type="text" class="input-xlarge datepicker"
										id="datepicker1">
								</p>
								<a class="btn btn-primary" href="" id="txtfileid">Download txt</a>
							</div>
						</div>
					</div>

					<div class="modal hide fade" id="met">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">Close</button>
							<h3>Seance Added</h3>

						</div>

						<div class="modal-footer">
							<!-- 				<a href="#" class="btn" data-dismiss="modal">Close</a> -->


						</div>
					</div>
					
						<div class="modal hide fade" id="met1">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">Close</button>
							<h3>Days Deleted</h3>

						</div>

						<div class="modal-footer">
							<!-- 				<a href="#" class="btn" data-dismiss="modal">Close</a> -->


						</div>
					</div>
						<div class="modal hide fade" id="met2">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">Close</button>
							<h3>success</h3>

						</div>

						<div class="modal-footer">
							<!-- 				<a href="#" class="btn" data-dismiss="modal">Close</a> -->


						</div>
					</div>
					
					<div class="modal hide fade" id="met2">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">Close</button>
							<h3>Days added</h3>

						</div>

						<div class="modal-footer">
							<!-- 				<a href="#" class="btn" data-dismiss="modal">Close</a> -->


						</div>
					</div>

					<!-- ****************************************************************** -->


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





function deleteAjaxSeanceDay(){
// 	alert($('#type').val());


	if ( $('#userId').val()!="") {
    	
		var i = 0;
// 		for (i = 0; i < searchIDs.length; i++) {
		$.ajax({
			url : 'deleteAjaxSeanceDay',
			type : 'POST',
			data:{user:$('#userId1').val()},
			success : function(data) {
// 				alert("Seance Added");
				 $('#met1').modal("show");
			},
			error: function( jqXHR,textStatus,errorThrown){
				
				alert("error");
				
			}
		});
		
// 		}
    }
    
//     calendar.fullCalendar('unselect');
	
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
