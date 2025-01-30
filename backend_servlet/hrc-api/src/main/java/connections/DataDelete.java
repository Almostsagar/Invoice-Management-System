package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataDelete {
	public static void deletedata(int sl_no) {
		String Delete_USERS_SQL = "Delete from winter_internship where sl_no = ?;";
			System.out.println(sl_no);
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	        try {
	        	Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/grey_goose", "root", "root");

	            PreparedStatement preparedStatement = connection.prepareStatement(Delete_USERS_SQL); 
	            preparedStatement.setInt(1, sl_no);
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	            connection.close();

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
//	        return result;	
	}

}
