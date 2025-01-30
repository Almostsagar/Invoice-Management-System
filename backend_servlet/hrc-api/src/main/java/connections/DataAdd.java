package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.Pojo.PojoModel;


public class DataAdd {
	public static void getAdd(PojoModel model)
	  {
	         String url ="jdbc:mysql://localhost:3306/grey_goose";
	         String user = "root";
	         String pass ="root";
	         
	         try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	      } catch (ClassNotFoundException exc) {
	        // TODO Auto-generated catch block
	    	  exc.printStackTrace();
	      }
	            
	            String business_code,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,baseline_create_date,cust_payment_terms;
	            int cust_number,posting_id,invoice_id;
	            double total_open_amount;
	            try {
	              Connection conn =DriverManager.getConnection(url,user,pass);
	             String sql_query="INSERT INTO winter_internship (business_code, cust_number, clear_date, buisness_year, doc_id ,posting_date , document_create_date , due_in_date , invoice_currency , document_type , posting_id , total_open_amount , baseline_create_date , cust_payment_terms , invoice_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	             PreparedStatement pst = conn.prepareStatement(sql_query);
	             business_code = model.getBusiness_code();
	             cust_number = model.getCust_number();
	             clear_date = model.getClear_date();
	             buisness_year = model.getBuisness_year();
	             doc_id = model.getDoc_id();
	             posting_date = model.getPosting_date();
	             document_create_date = model.getDocument_create_date();
	             due_in_date = model.getDue_in_date();
	             invoice_currency = model.getInvoice_currency();
	             document_type = model.getDocument_type();
	             posting_id = model.getPosting_id();
	             total_open_amount = model.getTotal_open_amount();
	             baseline_create_date = model.getBaseline_create_date();
	             cust_payment_terms = model.getCust_payment_terms();
	             invoice_id = model.getInvoice_id();
	                    
	                    pst.setString(1,business_code);
	                    pst.setInt(2,cust_number);
	                    pst.setString(3,clear_date);
	                    pst.setString(4,buisness_year);
	                    pst.setString(5,doc_id);
	                    pst.setString(6,posting_date);
	                    pst.setString(7,document_create_date);
	                    pst.setString(8,due_in_date);
	                    pst.setString(9,invoice_currency);
	                    pst.setString(10,document_type);
	                    pst.setInt(11,posting_id);
	                    pst.setDouble(12,total_open_amount);
	                    pst.setString(13,baseline_create_date);
	                    pst.setString(14,cust_payment_terms);
	                    pst.setInt(15,invoice_id);
	   	             System.out.println(pst);

	                    pst.executeUpdate();
	                    conn.close();
	            }
	            catch (Exception e) {
	                e.printStackTrace();
	                System.out.println("exception occured");
	            }     
	 }	
}
