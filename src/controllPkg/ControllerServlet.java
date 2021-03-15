package controllPkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// JDBC driver name and database URL
	      final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	      final String DB_URL="jdbc:mysql://localhost:3306/users";

	      //  Database credentials
	      final String USER = "root";
	      final String PASS = "";

	      // Set response content type
	      response.setContentType("text/html");
	      
	      try 
	      {
	    	 
	         // Register JDBC driver
	         Class.forName(JDBC_DRIVER);
	         
	         // Open a connection    
	    	  
	         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         
	         // Execute SQL query
	         java.sql.Statement stmt = conn.createStatement();
	         /////////
	         
	         String uid = request.getParameter("uID");	         
	         String sql = "SELECT * FROM userdetails WHERE id='"+uid + "'";
	         
	         
	         ResultSet rs = stmt.executeQuery(sql);
	         
	         if(rs.next())
	         {
	        	 String fname = rs.getString("name");
	             String un = rs.getString("username");
	             String pass = rs.getString("password");
	                        			     
	             request.setAttribute("fname", fname);
	   		     request.setAttribute("un", un);
   			     request.setAttribute("pass", pass);
   			     request.setAttribute("uid", uid);
   			     
   			     rs.close();
		         stmt.close();
		         conn.close();
       			     
   			     RequestDispatcher rd = request.getRequestDispatcher("form.jsp");
   			     rd.forward(request, response); 
	            
	         }	 
	         else 
	         {
	        	 response.sendRedirect("error.jsp"); //error page 
	         } 
	         rs.close();
	         stmt.close();
	         conn.close();
	         
	      } 
	      catch(SQLException se) 
	      {
	         //Handle errors for JDBC
	         se.printStackTrace();
	      } 
	      catch(Exception e) 
	      {
	         //Handle errors for Class.forName
	         e.printStackTrace();
	      }
	      
	      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// JDBC driver name and database URL
	      final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	      final String DB_URL="jdbc:mysql://localhost:3306/users";

	      //  Database credentials
	      final String USER = "root";
	      final String PASS = "";

	      // Set response content type
	      response.setContentType("text/html");
	      
	      try 
	      { 
	         // Register JDBC driver
	         Class.forName(JDBC_DRIVER);
	         
	         // Open a connection    
	    	  
	         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

	         String un = request.getParameter("yourUN");
	         String pass = request.getParameter("yourPass");
	         String name = request.getParameter("yourName");
	         String uID = request.getParameter("sameid");
	         

	         PreparedStatement update;
	         if(!name.isEmpty())
	         {
	        	 update = conn.prepareStatement("UPDATE userdetails SET name='"+name+ "' WHERE id = '"+uID+"'");
	        	 update.executeUpdate();
	         }
	         if(!un.isEmpty())
	         {
	        	 update = conn.prepareStatement("UPDATE userdetails SET username='"+un+ "' WHERE id = '"+uID+"'");
	        	 update.executeUpdate();
	         }
	         if(!pass.isEmpty())
	         {
	        	 update = conn.prepareStatement("UPDATE userdetails SET password='"+pass+ "' WHERE id = '"+uID+"'");
	        	 update.executeUpdate();
	         }
	         
		     
		     response.sendRedirect("success.jsp");
  
	      } 
	      catch(SQLException se) 
	      {
	         //Handle errors for JDBC
	         se.printStackTrace();
	      } 
	      catch(Exception e) 
	      {
	         //Handle errors for Class.forName
	         e.printStackTrace();
	      }
	}

}
