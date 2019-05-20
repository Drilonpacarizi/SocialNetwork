/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Flamur Jahiri
 */
public class connectSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SocialNetwork;user=Hasan;password=fjahiri:P";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
                Statement stmtV = null;
                Connection conV = null;
                ResultSet rsV = null;
		
        	try {
        		// Establish the connection.
        		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		con = DriverManager.getConnection(connectionUrl);
                        conV = DriverManager.getConnection(connectionUrl);
                        
            		// Create and execute an SQL statement that returns some data.
            		String SQL = "SELECT * From Followings";
            		stmt = con.createStatement();
            		rs = stmt.executeQuery(SQL);
            
            		// Iterate through the data in the result set and display it.
                        
            		while (rs.next()) {
            			
                                if(rs.getString(1).equals(rs.getString(2))){
                                    Statement stmt2 = con.createStatement();
                                    String SQL2 = "DELETE FROM Followings WHERE user_id = "+rs.getString(1)+" and following_id = " + rs.getString(1);
                                    stmt2.executeUpdate(SQL2);
                                }
                                
            		}
                        rs = stmt.executeQuery(SQL);
                        System.out.println("Tabela Followings : ");
                        System.out.println("User_from ; user_to ; data");
                        while(rs.next()){
                            System.out.println(rs.getString(1) +"         ;     "+rs.getString(2) + "   ; "+ rs.getString(3));
                        }
                        
                        String Verejtje = "SELECT * FROM Verejtje";
                        stmtV = conV.createStatement();
                        rsV = stmtV.executeQuery(Verejtje);
                        
                       while (rsV.next()) {
            			
                                if(rsV.getString(4).equals(rsV.getString(5))){
                                    
                                    Statement stmt2 = conV.createStatement();
                                    String SQL2 = "DELETE FROM Verejtje WHERE User_from = "+rsV.getString(4)+" and User_to = " + rsV.getString(5);
                                    stmt2.executeUpdate(SQL2);
                                } 
            		}
                       
                       
                       
                       rsV = stmtV.executeQuery(Verejtje);
                       System.out.println();
                       System.out.println();
                       System.out.println("Tabela Verejtje : ");
                       System.out.println("User_from ; User_to ;    Data    ; Arsyea");
                       while(rsV.next()){
                            System.out.println("    "+rsV.getString(4) +"     ;    "+rsV.getString(5) + "    ; "+ rsV.getString(2) +" ; " + rsV.getString(3));
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
                        if (rsV != null) try { rsV.close(); } catch(Exception e) {}
	    		if (stmtV != null) try { stmtV.close(); } catch(Exception e) {}
	    		if (conV != null) try { conV.close(); } catch(Exception e) {}
                        
		}
    }
    
}
