package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Pojo.PojoModel;
import com.Pojo.PojoModelForAnalytics;

public class AnalyticsView {
	public static ArrayList<PojoModel> analyticsfn(PojoModelForAnalytics model) {
	      String SEARCH_USERS_SQL = "SELECT business_code,invoice_currency,total_open_amount FROM winter_internship WHERE (clear_date BETWEEN ? AND ?) AND (due_in_date BETWEEN ? AND ?) AND (baseline_create_date BETWEEN ? AND ?) AND invoice_currency = ?;";
	        ArrayList<PojoModel> onemodel =new ArrayList<PojoModel>();
	        String business_code,invoice_currency;
	          double total_open_amount;

	            try {
	          Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e1) {
	          // TODO Auto-generated catch block
	          e1.printStackTrace();
	        }

	            try {
	              Connection connection = DriverManager
	                .getConnection("jdbc:mysql://localhost:3306/grey_goose", "root", "root");

	                PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERS_SQL);

	                preparedStatement.setString(1, model.getClear_date1());
	                preparedStatement.setString(2, model.getClear_date2());
	                preparedStatement.setString(3, model.getDue_in_date1());
	                preparedStatement.setString(4, model.getDue_in_date2());
	                preparedStatement.setString(5, model.getBaseline_create_date1());
	                preparedStatement.setString(6, model.getBaseline_create_date2());
	                preparedStatement.setString(7, model.getInvoice_currency());

	                System.out.println(preparedStatement);
	                ResultSet rs = preparedStatement.executeQuery();
	                
	                while(rs.next())
	                {
	                  PojoModel p = new PojoModel();
	                      business_code=rs.getString("business_code");
	                      invoice_currency=rs.getString("invoice_currency");
	                      total_open_amount=rs.getDouble("total_open_amount");	                      
	                      	                     
	                      p.setBusiness_code(business_code);
	                      p.setInvoice_currency(invoice_currency);
	                      p.setTotal_open_amount(total_open_amount);   	                       
	                       
	                  onemodel.add(p);
	                       
	                }
	            } catch (SQLException e) {
	            	// process sql exception
	                e.printStackTrace();
	            }
	            return onemodel;  
	    }
}


