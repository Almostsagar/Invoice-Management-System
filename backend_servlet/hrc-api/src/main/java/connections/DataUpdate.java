package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Pojo.PojoModel;

public class DataUpdate {
	public static int editdata(PojoModel model,int sl_no)
	  {
	    String sql = "UPDATE winter_internship SET invoice_currency= ? , cust_payment_terms= ? WHERE sl_no = ?;";
	    int result = 0;

	        try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e1) {
	      // TODO Auto-generated catch block
	      e1.printStackTrace();
	    }
	        
	        try {
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose", "root", "root");
	            String cust_payment_terms,invoice_currency;

	              PreparedStatement ps = conn.prepareStatement(sql);
	             
	             cust_payment_terms=model.getCust_payment_terms();
	             invoice_currency=model.getInvoice_currency();      
	             
	              ps.setString(1, invoice_currency);
	              ps.setString(2,cust_payment_terms);
	              ps.setInt(3, sl_no);
	              
	              System.out.println(ps);
	              ps.executeUpdate();
	              conn.close();


	          } catch (SQLException e) {
	              // process sql exception
	              e.printStackTrace();
	          }
	          return result;
	        
	  }
}
