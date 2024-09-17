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


public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/UserDb";
    public static String USER_NAME = "root";
    public static String PASSWORD = "6208gct";
    Connection connection;
       
    
    public RegServlet() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
	
		try {
			connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	
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
			pw.println("<html><body bgcolor = blue text = green><center>");
			pw.println("<h2>Registration succesfully.</h2>");
			pw.println("<a href=\"login.html\">Login</a>");
			pw.println("</center></body></html>");
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
