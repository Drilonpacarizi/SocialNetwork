/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SqlMesazhaFollowers {
    
    public  Connection connect() throws ClassNotFoundException{  

    Connection con =null;  

    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

    String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";  

    try{

    con=DriverManager.getConnection(connectionURL);
   // System.out.println("Connection is successfull");

    }

    catch(SQLException e){

     System.out.println(e);

    }
        return con;
    }
     
    public boolean getUser(String User, String password) throws ClassNotFoundException, SQLException{
        
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC checkLOGIN '" + User + "' , '" + password + "'";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
                        String s = "";
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                s = rs.getString(1);
            		}
                        if(s.equals("")) return false;
                        else return true;
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
     return false;
    }
    
    public void Regjistrohu(String emri , String mbiemri , String datelindja , String gjinia , String qyteti , String shteti , String username , String password , String email){
                String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		//ResultSet rs = null;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC shtoUser '" + emri + "' , '" + mbiemri + "' , '" + datelindja + "' , '" + gjinia +"' , '" + qyteti +"' , '" + shteti +"' , '" + username +"' , '" + password +"' , '" + email + "'";
            		stmt = con.createStatement();
            		 stmt.executeUpdate(SQL);
                        
            		// Iterate through the data in the result set and display it.
                }
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			//if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
        
    }
    
    public boolean checkAdmin(String username){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC checkPrioriteti '" + username + "'";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
            			if(rs.getString(1).equals("2"))
                                    return true;
                                else return false;
            		}
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
     return false;
    }
    
    public ArrayList<String> getMesazhat(String username){
           String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
                ArrayList<String>  rez = null ;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC getMesazhat '" + username + "' ";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
                        rez = new ArrayList<>();
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                rez.add(rs.getString(7) + " " + rs.getString(4) +" " + rs.getString(5) + " " +rs.getString(6));
            		}
                        
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
                return rez;
    }
    
    public ArrayList<String> getMesazhat2(String username){
           String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
                ArrayList<String>  rez = null ;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC getMesazhet2 '" + username + "' ";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
                        rez = new ArrayList<>();
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                rez.add(rs.getString(7) + ", " + rs.getString(4) +" ," + rs.getString(5) + ", " +rs.getString(6));
            		}
                        
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
                return rez;
    }
     
    public ArrayList<String> getAllMesazhet(String username){
           String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
                ArrayList<String>  rez = null ;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC getAllMesazhet '" + username + "' ";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
                        rez = new ArrayList<>();
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                rez.add(rs.getString(1) + " , " + rs.getString(2) );
            		}
                        
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
                return rez;
    }
    
    public ArrayList<String> getAllMesazhet(String username1 , String username2){
           String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
                ArrayList<String>  rez = null ;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC getMesazhatUsers '" + username1 + "' , '" + username2 + "'" ;
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
                        rez = new ArrayList<>();
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                rez.add(rs.getString(1) + " , " + rs.getString(2)  + " , " + rs.getString(3));
            		}
                        
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
                return rez;
    }
    
    public String personiFavorit(String username){
                   String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
                String s = "";
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC MesazhatMasShumti '"  + username + " ' ";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                               s = rs.getString(1);
            		}
                        
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
                return s;     
    }
    
    public ArrayList<String> getMesazhatDate(String username , String data){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
                ArrayList<String>  rez = null ;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC mesazhatData '" + username + "' , '" + data + "'" ;
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
                        rez = new ArrayList<>();
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                rez.add(rs.getString(2) + " , " + rs.getString(4)  + " , " + rs.getString(5));
            		}
                        
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
                return rez;
    }
    
    public ArrayList<String> getMesazhetSipasDatesSeFundit(String username){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
                ArrayList<String>  rez = null ;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC getMesazhatSipasDates '" + username + "' ";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
                        rez = new ArrayList<>();
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                rez.add(rs.getString(1) + " , " + rs.getString(2) + " , " + rs.getString(3));
            		}
                        
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
                return rez;
    }
    
    public void fshijeMesazhin(String username , String usernameTo){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		//ResultSet rs = null;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC fshijMesazhat '" + username + "' , '" + usernameTo + "'";
            		stmt = con.createStatement();
                        stmt.executeUpdate(SQL);
                     
                        
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			//if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
    }
    
    public ArrayList<String> getFollowersTu(String username){
         String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
                ArrayList<String>  rez = null ;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC FollowersTu '" + username + "' ";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
                        rez = new ArrayList<>();
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                rez.add(rs.getString(1));
            		}
                        
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
                return rez;
    }
    
    public ArrayList<String> getFollowers(String username){
          String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
                ArrayList<String>  rez = null ;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC getFollowings '" + username + "' ";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
                        rez = new ArrayList<>();
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                rez.add(rs.getString(1));
            		}
                        
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
                return rez;
    }
    
    public void dergoMesazha(int derguesi , int pranuesi , String mesazhi){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
                ArrayList<String>  rez = null ;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC dergoMesazh '" + derguesi + "' , '" + pranuesi + "' , '" + mesazhi + "'";
            		stmt = con.createStatement();
            		stmt.executeUpdate(SQL);
            		// Iterate through the data in the result set and display it.
                        JOptionPane.showMessageDialog(null,"Mesazhi u dergua me sukses");
            		
                        
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			//if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
                
    }
    
    public String getUsernameFromUserID(int user_id){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
                String s = "";
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC getUsername '" + user_id + "' ";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                s = rs.getString(1);
            		}
                        
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
                if(s.equals("")) JOptionPane.showMessageDialog(null, "ERROR");
                return s;
    }
    
    public int getUserIDfromUserName(String username){
         String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
                int i = 0;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC getUserID '" + username + "' ";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                i = Integer.parseInt(rs.getString(1));
            		}
                        
                        
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
                if(i == 0) JOptionPane.showMessageDialog(null, "ERROR");
                return i;
    }
    
    public void fshijeFollowing(String userFrom , String userTo){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		//ResultSet rs = null;
                int i = 0;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC jekFOLLOWING '" + userFrom + "' , '" + userTo + "'";
            		stmt = con.createStatement();
                        stmt.executeUpdate(SQL);
            		//rs = stmt.executeQuery(SQL);
            		// Iterate through the data in the result set and display it.
                        i = 1;
                        
        	}
        
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			//if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
                if(i == 0) JOptionPane.showMessageDialog(null, "ERROR");
                else  JOptionPane.showMessageDialog(null, "U fshie me sukses");
    }
    
   public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		// Create a variable for the connection string.
		
                
	}

}