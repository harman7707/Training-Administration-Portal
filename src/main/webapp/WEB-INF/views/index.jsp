<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="project.demo.entities.Course" %>
    <%@page import="project.demo.entities.Trainer" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<style>
h1 {
	text-align: center;
	font-size: 50px;

	
}
h2 {
	text-align: center;
	font-size: 28px;

	
}

.cont {
	margin-left: 250px;
	margin-top: 50px;
}



button {
	background-color: #007bff;
	align-self: center;
	color: white;
	border-radius: 100%;
	border-radius: 10px;
	padding: 10px 30px;
	margin: 5px;
	cursor: pointer;
	transition: background-color 0.3s;
}

button:hover {
	background-color: #0056b3;
}

a {
	text-decoration: none;
	color: white;
	font-size: 18px;
}
 .container {
    
    background-image: url("<c:url value="/resources/images/dashboard.png" />") no-repeat;
	background-size: cover;
	}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body style ="background-image: url('<c:url value="/resources/images/dashboard.png"/>');background-size: cover;">

<% 
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
%>


<div class="container">

<h1> WELCOME ADMIN!!</h1>
<h2>Manage your trainings with ease..</h2>

<div class= "cont">
<bUtton><a href="logout">logout</a></bUtton>
<bUtton><a href="openAddCoursePage">Add Courses</a></bUtton>
<bUtton><a href="viewCourses">View Courses</a></bUtton>
<bUtton><a href="openAddTrainer">Add Trainer</a></bUtton>
<bUtton><a href="viewTrainer">View Trainer</a></bUtton>
<bUtton><a href="openAddTrainingPage">Add Training</a></bUtton>
<bUtton><a href="viewTraining">View Training</a></bUtton>
</div>
</div>

</body>
</html>