<%@ page import="todo.TodoRecordBean" import="java.util.ArrayList" import="java.sql.Timestamp" import="java.text.SimpleDateFormat" %>
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
<title>S2A105出力結果</title>
</head>
<body>
<header>
<h1>OTODO</h1>
<span id="view_clock"></span>

<nav>
	<ul class="nav nav-tabs nav-justified" style="background-color:#ff8c00" style="color:#000000">
		<li><a href="index.jsp">タスク登録</a>
		<li><a href="ResponseServlet2">タスク</a>
		<li><a href="chart.jsp">チャート</a>
	</ul>
</nav>

</header>
<div class="container" role="main">
	<h1>ToDoアプリケーション</h1>
	<h2>出力画面:JSPVer.</h2><br>
	<jsp:useBean id="todoaBean" class="todo.TodoArrayBean" scope="session" />

		<% int size = todoaBean.getArraySize(); %>

	登録件数：<%= size %><br><br>
	<table border="1">
	<tr class="table2"><td>No.</td><td>重要度</td><td>内容</td><td>日付</td><td>備考</td><td>削除</td></tr>
	<%
		int a = 0;
		String iff = null;
		int[] m = new int[100];
		ArrayList<TodoRecordBean> todoArray = todoaBean.getTodoArray();
		int j =1;
		for(TodoRecordBean trb : todoArray){
			a = trb.getID();
			m[j] = a;
			iff = trb.getDay();
			out.println("<tr class=\"even\"><td>"+j+"</td><td>"+ trb.getImporta() + "</td><td>"+trb.getInfo() +"</td><td>"+
			iff+"</td><td>"+ trb.getBikou() +"</td><td>"
			+"<form action=\"HenkosakujoServlet\" method=\"post\">"
			+"<input type=\"hidden\" name=\"sakujo\" value="+j+">"
			+"<input type=\"hidden\" name=\"henko\" value=\"0\">"
			+"<input type=\"hidden\" name=\"saku\" value="+a+">"
			+"<input type=\"submit\" value=\"削除\" class=\"button\">"
			+"</form></td></tr>");
			j++;
		}
	%>
	</table><br>

	<!-- 変更モーダル -->
	<!-- 1.モーダル表示のためのボタン -->
	<button class="btn btn-primary" data-toggle="modal" data-target="#modal-example">
  		  予定の変更する？
	</button>

	<!-- 2.モーダルの配置 -->
	<form action ="HenkosakujoServlet" method="get">
		<div class="modal" id="modal-example" tabindex="-1">
    	<div class="modal-dialog">

        <!-- 3.モーダルのコンテンツ -->
        <div class="modal-content">
            <!-- 4.モーダルのヘッダ -->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="modal-label">予定修正画面</h4>
            </div>
            <!-- 5.モーダルのボディ -->
            <div class="modal-body">
                項目番号： <select required name="henko" >
		<%	int f= 1;
		for(int i=1;size >= i;i++){
			out.println("<option value=\""+i+"\">"+i+"</option>");
		}

		for(TodoRecordBean trb : todoArray){
			out.println("<input type=\"hidden\" name=\"hen\" value="+m[f]+">");
			f++;
		}
			%>
			</select><br>
			重要度　：
			<select required name="important">
				<option value=""></option>
				<option value="5">5</option>
				<option value="4">4</option>
				<option value="3">3</option>
				<option value="2">2</option>
				<option value="1">1</option>
			</select><br>
			内容　　：
				<input required type="text" name="info" size=20 value=""><br>
			日付　　：
				<input required type="date" name="day"><br>
			備考　　：
				<input required type="text" name="biko" size=30 value=""><br>
            </div>
            <!-- 6.モーダルのフッタ -->
            <div class="modal-footer">
            <input type="hidden" name="sakujo" value="0">
            	<input type="submit" value="変更">
            </div>
        </div>
    </div>
</div>
</form>

	<br><br>
	<a href=TodoSessionRemoveServlet>全件削除</a><br>
	<a href=index.jsp>入力画面に戻る</a>
</div>

</body>
</html>