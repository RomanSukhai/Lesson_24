package lgs.lviv.ua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionUNIT {
	
	final static String USER_NAME = "root";
	final static String USER_PASSWORD = "namor2004";
	final static String URL = "jdbc:mysql://localhost/employy";

	public static Connection connectionUtil() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName ("com.mysql.cj.jdbc.Driver").newInstance ();
		return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
	}

}
