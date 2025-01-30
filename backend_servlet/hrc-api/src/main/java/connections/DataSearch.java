package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Pojo.PojoModel;

public class DataSearch {
	public static ArrayList<PojoModel> searchstu(int cust_number) {
	      String SEARCH_USERS_SQL = "SELECT * from winter_internship WHERE cust_number = ?;";
	        ArrayList<PojoModel> onemodel =new ArrayList<PojoModel>();
	        String business_code,clear_date,buisness_year,doc_id,posting_date,aging_bucket,document_create_date,document_create_date1,due_in_date,invoice_currency,document_type,area_business,baseline_create_date,cust_payment_terms;
	          int sl_no,posting_id,invoice_id,isOpen,is_deleted;
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

	                preparedStatement.setInt(1, cust_number);
	                System.out.println(preparedStatement);
	                ResultSet rs = preparedStatement.executeQuery();
	                
	                while(rs.next())
	                {
	                  PojoModel p = new PojoModel();
	                      sl_no= rs.getInt("sl_no");
	                      business_code=rs.getString("business_code");
	                      cust_number=rs.getInt(3);
	                      clear_date=rs.getString(4);
	                      buisness_year=rs.getString(5);
	                      doc_id=rs.getString(6);
	                      posting_date=rs.getString(7);
	                      document_create_date=rs.getString(8);
	                      document_create_date1=rs.getString(9);
	                      due_in_date=rs.getString(10);
	                      invoice_currency=rs.getString(11);
	                      document_type=rs.getString(12);
	                      posting_id=rs.getInt(13);
	                      area_business=rs.getString(14);
	                      total_open_amount=rs.getDouble(15);
	                      baseline_create_date=rs.getString(16);
	                      cust_payment_terms=rs.getString(17);
	                      invoice_id=rs.getInt(18);
	                      isOpen=rs.getInt(19);
	                      aging_bucket=rs.getString(20);
	                      is_deleted=rs.getInt(21);
	                      
	                      
	                      
	       
	                      
	                      //System.out.println("ID is "+id+" "+"Name is "+Name);
	                      
	                      p.setAging_bucket(aging_bucket);
	                      p.setArea_business(area_business);
	                      p.setBaseline_create_date(baseline_create_date);
	                      p.setBuisness_year(buisness_year);
	                      p.setBusiness_code(business_code);
	                      p.setClear_date(clear_date);
	                      p.setCust_number(cust_number);
	                      p.setCust_payment_terms(cust_payment_terms);
	                      p.setDoc_id(doc_id);
	                      p.setDocument_create_date(document_create_date);
	                      p.setDocument_create_date1(document_create_date1);
	                      p.setDocument_type(document_type);
	                      p.setDue_in_date(due_in_date);
	                      p.setInvoice_currency(invoice_currency);
	                      p.setInvoice_id(invoice_id);
	                      p.setIs_deleted(is_deleted);
	                      p.setIsOpen(isOpen);
	                      p.setPosting_date(posting_date);
	                      p.setPosting_id(posting_id);
	                      p.setSl_no(sl_no);
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
