package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResponseServlet
 */
@WebServlet("/ResponseServlet2")
public class ResponseServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int counter = 0;

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
	public ResponseServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		TodoArrayBean todoaBean = new TodoArrayBean();

		//DB情報取得。DBからTODOリストの取り出し。
		try {
			Class.forName(drvName);

			try (Connection conn = DriverManager.getConnection(url + servername + ":" + port + ":" + sid, user, pass);
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(
							"SELECT * FROM TODOLIST ORDER BY DAY asc,IMPORTANT desc")) {
				while (rs.next()) {
					TodoRecordBean todoBean = new TodoRecordBean();
					todoBean.setID(rs.getInt("ID"));
					todoBean.setImporta(rs.getString("IMPORTANT"));
					todoBean.setInfo(rs.getString("NAIYOU"));
					todoBean.setDay(rs.getString("DAY"));
					todoBean.setBikou(rs.getString("BIKOU"));
					todoaBean.addToBean(todoBean);

				}
			}

			todoaBean.setSessionld(session.getId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("todoaBean", todoaBean);
		getServletContext().getRequestDispatcher("/index_output.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
