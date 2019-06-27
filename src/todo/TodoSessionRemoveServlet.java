package todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TodoSessionRemoveServlet
 */
@WebServlet("/TodoSessionRemoveServlet")
public class TodoSessionRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String drvName = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@";
	String servername = "10.11.39.215";
	String port = "1521";
	String sid = "HCS1";
	String user = "h20183011";
	String pass = "oraclemaster";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TodoSessionRemoveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.invalidate();

		try {
			Class.forName(drvName);
			try (Connection conn = DriverManager.getConnection(url + servername + ":" + port + ":" + sid, user, pass);
					Statement stmt = conn.createStatement()) {
				stmt.executeUpdate(
						"DELETE FROM TODOLIST");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />");
		out.println("<title>S2A105出力結果</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>ToDoアプリケーション</h1>");
		out.println("<p>出力画面:削除</br>");
		out.println("<br>");
		out.println("<br>");
		out.println("タスクを全件削除しました。。。");
		out.println("<hr>");

		out.println("<br>");

		out.println("<a href=index.jsp>入力画面に戻る</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
