package action;

import java.sql.*;

public class DatabaseHelper {

    Connection conn;
    Statement stmt;
    ResultSet rs;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/phonebook";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "26452ekam";

    DatabaseHelper() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        System.out.println("Creating statement...");
        stmt = conn.createStatement();
    }

    protected void finalize() throws Throwable {
        try {
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try

        System.out.println("Goodbye!");  // close open files\\
        } finally {
            super.finalize();
        }
    }
}
