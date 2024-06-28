package Utils;

import java.sql.*;

public class ConnectDB {

    // Database connection details
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost;database=Stoven;encrypt=true;trustServerCertificate=true;";
    private static String user = "maithanhdat";
    private static String pass = "123123";

    // Static block to load the SQL Server JDBC driver
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            // Throw a runtime exception if the driver is not found
            throw new RuntimeException("Failed to load SQL Server JDBC driver", ex);
        }
    }

    /**
     * Retrieves a prepared statement object for executing SQL queries or updates.
     * @param sql The SQL query or update statement.
     * @param args The arguments to be set in the prepared statement.
     * @return PreparedStatement object ready to be executed.
     * @throws SQLException If there is an error in preparing the statement.
     */
    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection connection = DriverManager.getConnection(dburl, user, pass);
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = connection.prepareCall(sql); // Prepare a callable statement
        } else {
            pstmt = connection.prepareStatement(sql); // Prepare a regular prepared statement
        }
        // Set parameters for the prepared statement
        for (int i = 0; i < args.length; i++){
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    /**
     * Executes an update SQL statement (INSERT, UPDATE, DELETE).
     * @param sql The SQL update statement.
     * @param args The arguments to be set in the prepared statement.
     * @return The number of rows affected by the update.
     * @throws RuntimeException If there is an error during execution.
     */
    public static int update(String sql, Object... args){
        try {
            PreparedStatement stmt = getStmt(sql, args); // Obtain prepared statement
            try {
                return stmt.executeUpdate(); // Execute the update and return affected row count
            } finally {
                stmt.getConnection().close(); // Close connection after execution
            }
        } catch (SQLException e) {

            // Wrap SQL exceptions in a runtime exception and throw.
            throw new RuntimeException("Failed to execute update", e);
        }
    }

    /**
     * Executes a query SQL statement and returns the result set.
     * @param sql The SQL query statement.
     * @param args The arguments to be set in the prepared statement.
     * @return ResultSet containing the results of the query.
     * @throws RuntimeException If there is an error during execution.
     */
    public static ResultSet query(String sql, Object...args) {
        try {
            PreparedStatement stmt = getStmt(sql, args); // Obtain prepared statement
            return stmt.executeQuery(); // Execute query and return result set
        } catch (SQLException e){
            // Wrap SQL exceptions in a runtime exception and throw
            throw new RuntimeException("Failed to execute query", e);
        }
    }

    /**
     * Executes a query SQL statement and returns a single value from the first row of the result set.
     * @param sql The SQL query statement.
     * @param args The arguments to be set in the prepared statement.
     * @return Object representing the value returned by the query.
     * @throws RuntimeException If there is an error during execution or no result is found.
     */
    public static Object values(String sql, Object... args) {
        try {
            ResultSet rs = query(sql, args); // Execute query to obtain result set
            if (rs.next()) {
                return rs.getObject(1); // Return the first column value of the first row
            }
            rs.getStatement().getConnection().close(); // Close connection after query
        } catch (Exception e) {
            // Wrap exceptions in a runtime exception and throw
            throw new RuntimeException("Failed to retrieve value from query", e);
        }
        return null; // Return null if no result found
    }
}
