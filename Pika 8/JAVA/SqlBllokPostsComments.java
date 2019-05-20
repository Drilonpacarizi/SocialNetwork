/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Flamur Jahiri
 */
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class SqlBllokPostsComments {
    public ArrayList<String> getBlock (String username){
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
            		String SQL = "EXEC getBlock '" + username + "' ";
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
    
    public void FshijeBllokin(String user_From , String user_to){
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
            		String SQL = "EXEC unblock '" + user_From + "' , '" + user_to + "'";
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
    
    public ArrayList<String> SearchUser(String Search){
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
            		String SQL = "EXEC SelectAllUsers '" + Search + "' ";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
                        rez = new ArrayList<>();
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                rez.add(rs.getString(3) + " , " + rs.getString(6) + " , " + rs.getString(7) + " , " + rs.getString(8) + " , " + rs.getString(9) + " , " + rs.getString(10) );
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
    
    public ArrayList<String> SearchPosts(String Search){
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
            		String SQL = "EXEC SelectAllUsersByPosts '" + Search + "' ";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
                        rez = new ArrayList<>();
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                rez.add(rs.getString(3) + " , " + rs.getString(6) + " , " + rs.getString(7) + " , " + rs.getString(8) + " , " + rs.getString(9) + " , " + rs.getString(10) 
                                + " , " + rs.getString(17) + " , " + rs.getString(18));
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
    
    public ArrayList<String> SearchComments(String Search){
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
            		String SQL = "EXEC SelectAllUsersByComments '" + Search + "' ";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
                        rez = new ArrayList<>();
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                rez.add(rs.getString(3) + " , " + rs.getString(6) + " , " + rs.getString(7) + " , " + rs.getString(8) + " , " + rs.getString(9) + " , " + rs.getString(10) 
                                + " , " + rs.getString(19) + " , " + rs.getString(18));
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
     
    public void ndryshoPasswordin(String username , String password){
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
            		String SQL = "EXEC updatePassword '" + username + "' , '" + password + "'";
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
                else  JOptionPane.showMessageDialog(null, "Passwordi u ndryshua me sukses");
     }
     
    public void ndryshoEmail(String username , String email){
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
            		String SQL = "EXEC updateEmail '" + username + "' , '" + email + "'";
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
                else  JOptionPane.showMessageDialog(null, "Email u ndryshua me sukses");
     }
    
    public ArrayList<String> shikoPostet(String username){
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
            		String SQL = "EXEC shikoPostet '" + username + "' ";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
                        rez = new ArrayList<>();
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                rez.add(rs.getString(3));
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
    
    public int merrePostID(String pershkrimi){
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
            		String SQL = "EXEC zgjedhPostin '" + pershkrimi + "' ";
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
                return i;
    }
    
    public void fshijePostin(int post_id){
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
            		String SQL = "EXEC fshijePostin '" + post_id + "'";
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
                else  JOptionPane.showMessageDialog(null, "Posti u fshi me sukses");
    }
    
    public void editoPostin(int post_id , String pershkrimi){
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
            		String SQL = "EXEC editoPostin '" + post_id + "' , '" + pershkrimi + "'";
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
                else  JOptionPane.showMessageDialog(null, "Posti u ndryshua me sukses");
    }
    
    public void shtoPost(String username , String pershkrimi , String lloji){
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
            		String SQL = "EXEC shtoPost '" + username + "' , '" + pershkrimi + "' , '" + lloji + "'" ;
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
                else  JOptionPane.showMessageDialog(null, "Posti u shtua me sukses");
    }
    
    public ArrayList<String> gjejKomentet(String username , int user_id){
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
            		String SQL = "EXEC GjejKomentet '" + username + "' , '" + user_id + "'";
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
    
    public String ktheTeDhenat(String username){
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
            		String SQL = "EXEC TeDhenat '" + username + "'";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                s = (rs.getString(1) + " ; " + rs.getString(2) + ";" + rs.getString(3) + ";"+ rs.getString(4) + ";"+ rs.getString(5) + ";"+ rs.getString(6) + ";"+ rs.getString(7));
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
    
    public void shtoFollow(String username , String usernameTi){
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
            		String SQL = "EXEC FollowUser '" + username + "' , '" + usernameTi + "'" ;
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
                else  JOptionPane.showMessageDialog(null, "Follow u shtua me sukses");
      }
    
    public ArrayList<String> UseratAktiv(){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
                ArrayList<String> s = null;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC shikoUserAktiv ";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
                        s=new ArrayList<>();
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                s.add(rs.getString(1) );
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
    
     public ArrayList<String> UseratDeaktiv(){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
                ArrayList<String> s = null;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
            
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "EXEC shikoUserDEAKTIV ";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
                        s=new ArrayList<>();
            		// Iterate through the data in the result set and display it.
            		while (rs.next()) {
                                s.add(rs.getString(1) );
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
     
     public void AktivizoUser(String username){
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
            		String SQL = "EXEC AktivizoUser '" + username  + "'" ;
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
                else  JOptionPane.showMessageDialog(null, "User u Aktivizua me sukses");
     }
     
     public void DeAktivizoUser(String username){
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
            		String SQL = "EXEC DeaktivizoUSER '" + username  + "'" ;
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
                else  JOptionPane.showMessageDialog(null, "User u DeAktivizua me sukses");
     }
     
}
