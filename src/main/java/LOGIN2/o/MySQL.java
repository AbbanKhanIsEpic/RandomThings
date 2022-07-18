/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGIN2.o;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author abban
 */
public class MySQL{
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String user = "root";
    private static final String pass = "ecnjhwd37r837*^8HNBbnm";
    
    public static void update(String update) throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, pass);

		PreparedStatement statement = conn.prepareStatement(update);
		statement.executeUpdate();
		statement.close();
    }
    public static void query(String stmt) throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, pass);

		PreparedStatement statement = conn.prepareStatement(stmt);
		ResultSet resultSet = statement.executeQuery();

		statement.close();
    }
    public static String loginQuery(String query) throws SQLException {
                Connection conn = DriverManager.getConnection(url, user, pass);
		 try (Statement stmt = conn.createStatement()) {
                        ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
                                return "Done";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return "Incorrect";
    }
    public String register(String username, String password){
        
        try {
			MySQL.update("INSERT INTO pratice.login VALUES(\"" + username + "\",\""+ password + "\" , NOW());");
                        MySQL.update("CREATE TABLE `pratice`.`" + username + "` (\n" +
"  `Friends` varchar(100) NOT NULL,\n" +
"  `Messages` varchar(100) DEFAULT NULL,\n" +
"  PRIMARY KEY (`Friends`)\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci");
                        return "Account created";
                        
	} catch (SQLException e) {
			e.printStackTrace();
        }
        return "This username already exits";
    }
    public String login(String username, String password){
        try {
			String result = MySQL.loginQuery("Select username, password from pratice.login where username = \""+ username+"\" and password=\""+password+"\";");
                        return result;
                        
	} catch (SQLException e) {
			e.printStackTrace();
        }
        return "Error";
    }
    public static void searchQuery(String query) throws SQLException {
                Connection conn = DriverManager.getConnection(url, user, pass);
                String list = "";
		 try (Statement stmt = conn.createStatement()) {
                        ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String username = rs.getString("username");
                                list = list + username + "\n" + "";
                                System.out.println(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
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
        int number = MySQL.getNumberOfFriends(query);
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
    public static String convo(String friend,String username) throws SQLException{
        Connection conn = DriverManager.getConnection(url, user, pass);
        String query = ("select Messages from pratice."+username + " Where Friends = \"" + friend + "\";");
        String messages = "";
		 try (Statement stmt = conn.createStatement()) {
                        ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				messages = rs.getString("Messages");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return messages;
    }
    public static void setConvo(String friend, String username,String message) throws SQLException{
        MySQL.update("UPDATE pratice."+friend+"\n SET Messages =\"" + message + "\"\n WHERE Friends = \"" + username + "\";");
        MySQL.update("UPDATE pratice."+username+"\n SET Messages =\"" + message + "\"\n WHERE Friends = \"" + friend + "\";");
    }
}
