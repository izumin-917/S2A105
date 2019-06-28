<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/jquery-3.2.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/index.js"></script>
<link rel=stylesheet href="css/bootstrap.min.css">
<link rel=stylesheet type="text/css" href="css/style.css" />
<link rel="shortcut icon" href="images/favicon.ico">


<title>S2A105</title>
</head>
<body>
	<header>
		<h1>OTODO</h1>
		<span id="view_clock"></span>

		<nav>
			<ul class="nav nav-tabs nav-justified"
				style="background-color: #ff8c00" style="color:#000000">
				<li><a href="index.jsp">タスク登録</a>
				<li><a href="ResponseServlet2">タスク</a>
				<li><a href="chart.jsp">チャート</a>
			</ul>
		</nav>
	</header>
	<div class="container" role="main">
		<%
			String todo = "ToDoアプリケーション";
			String toroku = "登録情報";
			String tex = "入力";
			String da = "日付";
			String bi = "備考";
		%>
		<h1><%=todo%></h1>
		<form action="ResponseServlet" method="get" onSubmit="return check()">
			<h3><%=toroku%></h3>
			<p>
				重要度 <select required name="important">
					<option value=""></option>
					<option value="5">5</option>
					<option value="4">4</option>
					<option value="3">3</option>
					<option value="2">2</option>
					<option value="1">1</option>
				</select>
			</p>
			<p><%=tex%>
				<input required type="text" name="info" size=20 value="">
			</p>
			<p><%=da%>
				<input required type="date" name="day">
			</p>
			<p><%=bi%>
				<input required type="text" name="biko" size=30 value="">
			</p>
			<input required type="submit" value="送信" class="button">
		</form>
	</div>
</body>
</html>