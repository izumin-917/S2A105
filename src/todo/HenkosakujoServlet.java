package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HenkosakujoServlet
 */
@WebServlet("/HenkosakujoServlet")
public class HenkosakujoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int henko = 0;
	private int sakujo = 0;

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
	public HenkosakujoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		TodoArrayBean todoaBean = (TodoArrayBean) session.getAttribute("todoaBean");

		TodoRecordBean todoBean = new TodoRecordBean();
		ArrayList<TodoRecordBean> todoArray = todoaBean.getTodoArray();

		henko = Integer.parseInt(request.getParameter("henko"));
		int hen = Integer.parseInt(request.getParameter("hen"));

		String importants = request.getParameter("important");
		String infomartion = request.getParameter("info");
		String Date = request.getParameter("day");
		String Bikou = request.getParameter("biko");

		todoBean.setImporta(importants);
		todoBean.setInfo(infomartion);
		todoBean.setDay(Date);
		todoBean.setBikou(Bikou);
		todoaBean.setSessionld(session.getId());

		if (henko == 0) {
		} else {
			henko = henko - 1;
			todoArray.set(henko, todoBean);
			try {
				Class.forName(drvName);
				try (Connection conn = DriverManager.getConnection(url + servername + ":" + port + ":" + sid, user, pass);
						Statement stmt = conn.createStatement()) {
					stmt.executeUpdate(
							"UPDATE TODOLIST SET IMPORTANT='" + importants + "',NAIYOU='" + infomartion + "',DAY='" + Date + "',BIKOU='" + Bikou + "' WHERE ID=" + hen);
					conn.commit();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			henko = 0;
		}

		session.setAttribute("todoaBean", todoaBean);

		getServletContext().getRequestDispatcher("/index_output.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sakujo = Integer.parseInt(request.getParameter("sakujo"));
		int saku = Integer.parseInt(request.getParameter("saku"));

		HttpSession session = request.getSession();
		TodoArrayBean todoaBean = (TodoArrayBean) session.getAttribute("todoaBean");
		ArrayList<TodoRecordBean> todoArray = todoaBean.getTodoArray();

		sakujo = sakujo - 1;
		try {
			Class.forName(drvName);
			try (Connection conn = DriverManager.getConnection(url + servername + ":" + port + ":" + sid, user, pass);
					Statement stmt = conn.createStatement()) {
				stmt.executeUpdate(
						"DELETE FROM TODOLIST WHERE ID =" + saku);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		todoArray.remove(sakujo);
		sakujo = 0;
		getServletContext().getRequestDispatcher("/index_output.jsp").forward(request, response);
	}

}
