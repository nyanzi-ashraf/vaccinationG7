package org.health.administration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class AddBookerTagHandler extends TagSupport {
	private static final long serialVersionUID =1L ;
	
	private static String table;  
	private static String value;
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/vaccination_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    
	public void setTable(String table) {  
	    this.table = table;  
	} 
	
	public void setValue(String value) {  
	    this.value = value;  
	}
	
	public int doStartTag() throws JspException {
		Connection connection = null;
		
		
	    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
	    
	    String[] credentials = value.split("``");
	    
		try {

			 // Load the database driver
				Class.forName(jdbcDriver);
		
				  // Get a Connection to the database
			
				connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); 
			
				  //Select the data from the database
		
				String sql = "INSERT INTO bookings" +
			            "  (email, password) VALUES " +
			            " (?, ?);";
			
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, credentials[0]);
	            preparedStatement.setString(2, credentials[1]);
				
	            int i = preparedStatement.executeUpdate();  
	            if(i>0){
		            out.println("<h1 style='color:green;'>You have signed up successfully</h1>");
		            out.println("<h3>Click <a href='login'>here</a> to start booking</h3>");
	            }
	            else{
	            	out.println("<h1 style='color:red;'>You have failed to sign up successfully</h1>");
		            out.println("<h3>Click <a href='booker_form'>here</a> to try again</h3>");
	            }
	    	}
		catch(Exception e){

				System.out.println("Exception is ;"+e);

			}
	    
	    return SKIP_BODY;//will not evaluate the body content of the tag  
	}  
}
