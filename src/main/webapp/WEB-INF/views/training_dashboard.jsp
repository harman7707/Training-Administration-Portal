<%@page import="java.util.Base64"%>
<%@page import="project.demo.entities.*"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Training Dashborad</title>

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
	List<Training> training = (List) request.getAttribute("listOfTraining");
	List<Trainer> trainer = (List) request.getAttribute("listOfTrainer");
	List<Course> course = (List) request.getAttribute("listOfCourse");
	int size = training.size();
	%>

	<table>
		<caption>List</caption>
		<tr>
			<th>ID</th>
			<th>Course ID</th>
			<th>Course Name</th>
			<th>Trainer ID</th>
			<th>Trainer Name</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Fees</th>
			<th>Discount</th>
			<th>Batch Size</th>
			<th>Offer Price</th>
			<th>Actions</th>

		</tr>

		<!-- Dynamic No of rows depending upon records in the database -->

		<%
		int serialNo = 0;
		for (int i=0;i<size;i++) {
		%>
		<tr>
			<td><%=training.get(i).getTrainingId()%></td>
			<td><%=training.get(i).getCourseId()%></td>
			<td><%=course.get(i).getCourseName()%></td>
			<td><%=training.get(i).getTrainerId()%></td>
			<td><%=trainer.get(i).getTrainerName()%></td>
			<td><%=training.get(i).getStart_date()%></td>
			<td><%=training.get(i).getEnd_date() %></td>
			<td><%=training.get(i).getFees()%></td>
			<td><%=training.get(i).getDiscount()%></td>
			<td><%=training.get(i).getBatchSize()%></td>
			<td><%=training.get(i).getDiscountedPrice() %></td>
			
			<td><button><a
				href="<%=request.getContextPath()%>/Update_Training/<%=training.get(i).getTrainingId()%>">Update</a>
			</button></td>
			<td><button><a
				href="<%=request.getContextPath()%>/delete_training/<%=training.get(i).getTrainingId()%>">Delete</a>
			</button></td>


		</tr>
		<%
		}
		%>
		
		

	</table>

	<button>
		<a href="<%=request.getContextPath()%>/openDashboardTraining">Dashboard</a>
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
