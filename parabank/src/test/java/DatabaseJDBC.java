import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterTest;

public class DatabaseJDBC{
	
	public static void main(String[] args)throws  ClassNotFoundException, SQLException {													

	//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
    String dbUrl = "jdbc:mysql://localhost:3306/bank_schema";					

    String actualResult="";
	String expectedResult="";
	
	//Database Username		
	String username = "root";	
    
	//Database Password		
	String password = "surya";				

	//Query to Execute		
	String query = "select *  from cred;";	
    
	    //Load mysql jdbc driver		
	    Class.forName("com.mysql.jdbc.Driver");			

		//Create Connection to DB		
	Connection con = DriverManager.getConnection(dbUrl,username,password);
	  Statement stmt = con.createStatement();
	  ResultSet rs= stmt.executeQuery(query);							
	  //
	
	try {
		 // Step 3 - Execute statement
	      stmt = con.createStatement();
	      rs = stmt.executeQuery("select * from cred where USERNAME='praveen';");
	      
	      
	   //   stmt.setString(1, username);
		//	ResultSet rs=stmt.executeQuery(title);
			
			if(!rs.next())
				expectedResult="LoginFailure";
			else{// something is present
				String pwdDB = rs.getString("PASSWORD");
				System.out.println("Password from DB-> "+ pwdDB);
				if(pwdDB.equals(password))
					
					System.out.println("LOGINSUCCESS");
					//expectedResult="LoginSuccess";
				else
					expectedResult="LoginFailure";
			}
    } catch (SQLException e) {
	      e.printStackTrace();
	    }
}}
	      

	//Create Statement Object		
  //Statement stmt = con.createStatement();					
//
//		// Execute the SQL Query. Store results in ResultSet		
//		ResultSet rs= stmt.executeQuery(query);							
//
//		// While Loop to iterate through all data and print results		
//	while (rs.next()){
//        		String myName = rs.getString(1);								        
//                String myAge = rs.getString(2);					                               
//                System. out.println(myName+"  "+myAge);		
//        }		
//		 // closing DB Connection		
//		con.close();			
//}
//
//
//




