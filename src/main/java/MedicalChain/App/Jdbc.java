package MedicalChain.App;

import java.sql.*;

/*
    Java Database Connectivity Theory
    1. Import ----> java.sql
    2. load and register the driver ---> com.mysql.jdbc.Driver
    3. Create Connection ----> Connection
    4. create a statement ----> statement
    5. execute the query ->
    6. process the results ->
    7. Close
*/


public class Jdbc {

    public static void main(String[] args) throws Exception {

        String url = "";
        String uName = "root";
        String pass = "";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uName, pass);
    }
}
