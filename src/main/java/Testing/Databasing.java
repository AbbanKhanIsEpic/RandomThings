/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Testing;

/**
 *
 * @author abban
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
public class Databasing {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String user = "root";
    private static final String pass = "ecnjhwd37r837*^8HNBbnm";
    public static int getNumberOfFriends(String query) throws SQLException{
        Connection conn = DriverManager.getConnection(url, user, pass);
        int friends = 0;
		 try (Statement stmt = conn.createStatement()) {
                        ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String friend = rs.getString("Friends");
                                friends++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
         return friends;
    }
    public static String[] getFriends(String query) throws SQLException{
        Connection conn = DriverManager.getConnection(url, user, pass);
        int number = Databasing.getNumberOfFriends(query);
        String[] friends = new String[number];
        int count = 0;
		 try (Statement stmt = conn.createStatement()) {
                        ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String friend = rs.getString("Friends");
                                friends[count] = friend;
                                if(!(count == number-1)){
                                    count++;
                                }
                                else{
                                    break;
                                }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
         return friends;
    }
}
