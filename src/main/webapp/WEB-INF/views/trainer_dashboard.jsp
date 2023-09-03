<%@page import="java.util.Base64"%>
<%@page import="project.demo.entities.Trainer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trainer Dashborad</title>

<style>
body {
		 background-color: rgb(229, 211, 183);
            
            overflow: hidden;
	}
	h1{
	text-align:center;
	margin-top:10px;
	}

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: rgb(224,205,170);
            box-shadow: 0 2px 4px rgba(0, 0, 0, 1);
            margin-top: 20px;
            border: 1px solid #dddddd;
        }

        caption {
            font-size: 1.2em;
            font-weight: bold;
            margin-bottom: 10px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-top: 2px solid #dddddd;
            border-bottom: 2px solid #dddddd;
            border-left: 2px solid #dddddd;
            border-right: 2px solid #dddddd;
        }

        th {
            background-color: rgb(224,205,170);
            font-weight: bold;
        }

        tr:nth-child(even) {
            background-color: rgb(224,205,170);
        }

        a {
            text-decoration: none;
            color: #007bff;
            margin-right: 10px;
            
        }

        a:hover {
            text-decoration: underline;
        }
</style>
</head>
<body>

	<%
	List<Trainer> listOfTrainer = (List) request.getAttribute("listOfTrainer");
	%>

	<table>
		<caption>List</caption>
		<tr>
			<th>S. No</th>
			<th>Trainer Name</th>
			<th>qualification</th>
			<th>Description</th>
			<th>Experience</th>
			<th>Contact</th>
			<th>Actions</th>

		</tr>

		<!-- Dynamic No of rows depending upon records in the database -->

		<%
		int serialNo = 0;
		for (Trainer trainer : listOfTrainer) {
		%>
		<tr>
			<td><%=trainer.getTrainerId()%></td>
			<td><%=trainer.getTrainerName()%></td>
			<td><%=trainer.getQualification()%></td>
			<td><%=trainer.getTrainerDescription()%></td>
			<td><%=trainer.getYear_of_exp()%></td>
			<td><%=trainer.getPhone()%></td>

			<td><button><a
				href="<%=request.getContextPath()%>/UpdateTrainer/<%=trainer.getTrainerId()%>">Update</a>
			</button></td>
			<td><button><a
				href="<%=request.getContextPath()%>/delete_trainer/<%=trainer.getTrainerId()%>">Delete</a>
			</button></td>


		</tr>
		<%
		}
		%>


	</table>

	<button>
		<a href="<%=request.getContextPath()%>/openDashboard">Dashboard</a>
	</button>


	<p>
		<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
			out.print(message);
		}
		%>

	</p>
</body>
</html>
