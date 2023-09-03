<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="project.demo.entities.*"%>
	<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ADD Training</title>
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
<% List<Trainer> trainer = (List) request.getAttribute("listOfTrainer");
	List<Course> course = (List) request.getAttribute("listOfCourse");
	int courseSize = course.size();
	int trainerSize = trainer.size();%>

	<form action="addTraining" method="post">

		<table>
			<tr>
				<td>Course ID</td>
				<td>
					<select name="courseId">
					<% for(int i =0;i<courseSize;i++){%>
					<option value="<%= course.get(i).getCourseId() %>" type="number"><%= course.get(i).getCourseName()%></option>
					<%} %>
					</select>
					</td>
			</tr>
			<tr>
				<td>Trainer ID</td>
				<td>
				<select name="trainerId">
					<% for(int i =0;i<trainerSize;i++){%>
					<option value="<%= trainer.get(i).getTrainerId() %>" type="number"><%= trainer.get(i).getTrainerName()%> </option>
					<%} %>
					</select>
					</td>
			</tr>
			<tr>
				<td>Start Date</td>
				<td><input type="date" name="start_date"
					placeholder="start date" required/></td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><input type="date" name="end_date"
					placeholder="end date" required/></td>
			</tr>
			<tr>
				<td>Fees</td>
				<td><input type="number" name="fees"
					placeholder="FEES" required/></td>
			</tr>
			<tr>
				<td>Discount</td>
				<td><input type="number" name="discount"
					placeholder="Discount" required/></td>
			</tr>
			<tr>
				<td>Batch Size</td>
				<td><input type="number" name="batchSize"
					placeholder="Batch Size" required/></td>
			</tr>
			
			
			<tr>
				<td><input type="reset" value="Reset" /> <input id="submit"
					type="submit" value="Submit" />
					
			</tr>
		</table>
	</form>
<button>
		<a href="<%=request.getContextPath()%>/openDashboardTraining">Dashboard</a>
	</button>
</body>
</html>