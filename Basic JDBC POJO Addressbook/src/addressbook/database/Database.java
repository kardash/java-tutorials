/**
 * 
 */
package addressbook.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    
	private Connection conn = null;
	 
	public Database(String url, String user_name, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		this.conn = DriverManager.getConnection(url, user_name, password);
	}
 
	public Connection getConnection() {
		return this.conn;
	}
}
