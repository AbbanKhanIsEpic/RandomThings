/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moving;

/**
 *
 * @author abban
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Cliftonb
 */
public class DatabaseManager {

	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://127.0.0.1:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
	private static final String user = "root";
	private static final String pass = "ecnjhwd37r837*^8HNBbnm";

	//INSERT, UPDATE or DELETE
	public static void update(String update) throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, pass);

		PreparedStatement statement = conn.prepareStatement(update);
		statement.executeUpdate();
		statement.close();
	}

	//SELECT
	public static void query(String stmt) throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, pass);

		PreparedStatement statement = conn.prepareStatement(stmt);
		ResultSet resultSet = statement.executeQuery();

		processBookRequest(resultSet);

		statement.close();
	}

	//process a SPECIFIC query
	public static void processBookRequest(ResultSet rs) {
		try {
			ResultSetMetaData meta = rs.getMetaData();
			int size = meta.getColumnCount();
			while (rs.next()) {
				int isbn = rs.getInt(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				int rating = rs.getInt(4);
				double replacement_cost = rs.getDouble(5);

				System.out.println(isbn + "#" + title + "#" + author + "#" + rating + "#" + replacement_cost);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			DatabaseManager.update("INSERT INTO pratice.list(number_of_apple,number_of_banana) VALUES(69,420)");

			DatabaseManager.query("SELECT * FROM pratice.list");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
