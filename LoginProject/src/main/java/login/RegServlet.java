package login;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/UserDb";
    public static String USER_NAME = "root";
    public static String PASSWORD = "6208gct";
    Connection connection;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String uname = request.getParameter("uname");
		String pword = request.getParameter("pword");
		
		String sql = "insert into uinfo values(?,?,?,?)";
		
		try {
			PreparedStatement ps =  connection.prepareStatement(sql);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, uname);
			ps.setString(4, pword);
			ps.executeUpdate(); 		//insert data into db
			
			PrintWriter pw = response.getWriter();
			pw.println("<!DOCTYPE html>");
			pw.println("<html lang='en'>");
			pw.println("<head>");
			pw.println("<meta charset='UTF-8'>");
			pw.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
			pw.println("<title>Registration Success</title>");
			pw.println("<style>");
			pw.println("    body {");
			pw.println("        background-color: blue;");
			pw.println("        color: green;");
			pw.println("        font-family: Arial, sans-serif;");
			pw.println("        display: flex;");
			pw.println("        justify-content: center;");
			pw.println("        align-items: center;");
			pw.println("        height: 100vh;");
			pw.println("        margin: 0;");
			pw.println("    }");
			pw.println("    .container {");
			pw.println("        background-color: white;");
			pw.println("        padding: 40px;");
			pw.println("        border-radius: 10px;");
			pw.println("        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);");
			pw.println("        text-align: center;");
			pw.println("    }");
			pw.println("    h2 {");
			pw.println("        color: green;");
			pw.println("        font-size: 2em;");
			pw.println("        margin-bottom: 20px;");
			pw.println("    }");
			pw.println("    a {");
			pw.println("        display: inline-block;");
			pw.println("        padding: 10px 20px;");
			pw.println("        text-decoration: none;");
			pw.println("        color: white;");
			pw.println("        background-color: green;");
			pw.println("        border-radius: 5px;");
			pw.println("        font-size: 1.1em;");
			pw.println("        transition: background-color 0.3s ease;");
			pw.println("    }");
			pw.println("    a:hover {");
			pw.println("        background-color: lightgreen;");
			pw.println("    }");
			pw.println("</style>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<div class='container'>");
			pw.println("    <h2>Registration Successful!</h2>");
			pw.println("    <a href='login.html'>Go to Login</a>");
			pw.println("</div>");
			pw.println("</body>");
			pw.println("</html>");

			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
