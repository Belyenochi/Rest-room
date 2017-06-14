package zucc.edu.cn.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/danmumaster?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
	private static final String user = "root";
	private static final String password = "root";
	private static Connection conn = null;

	public static Connection getConnection() {
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the DB");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
}
