package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Pojo.PojoModel;

public class DataFetch {
	public Connection getConnection()
    {
         Connection conn =null;
         String url ="jdbc:mysql://localhost:3306/grey_goose";
         String user = "root";
         String pass ="root";
            
            
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn =DriverManager.getConnection(url,user,pass);
                } catch (ClassNotFoundException e) {
                    
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
                return conn;

        }
	public ArrayList<PojoModel> getData()
    {
        ArrayList<PojoModel> ALLPojoModel =new ArrayList<PojoModel>();
        String business_code,clear_date,buisness_year,doc_id,posting_date,aging_bucket,document_create_date,document_create_date1,due_in_date,invoice_currency,document_type,area_business,baseline_create_date,cust_payment_terms;
        int sl_no,cust_number,posting_id,invoice_id,isOpen,is_deleted;
        double total_open_amount;
        try {
         Connection conn = getConnection();
         String sql_query="SELECT * from winter_internship";
         PreparedStatement pst = conn.prepareStatement(sql_query);
         System.out.println(pst);
         ResultSet rs = pst.executeQuery();
        
         while(rs.next())
         {
                PojoModel p = new PojoModel();
                sl_no= rs.getInt(1);
                business_code=rs.getString(2);
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
                
                ALLPojoModel.add(p);                
                
         }        
        
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("exception occur");
        }
        
        return ALLPojoModel;
        
    
    }  
    
}



//
//public JsonObject getData2()
//{
//    JsonObject headerFile = new JsonObject();
//
//    JsonArray listOfAttrs = new JsonArray();
//    ArrayList<PojoModel> ALLPojoModel =new ArrayList<PojoModel>();
//    String business_code,clear_date,buisness_year,doc_id,posting_date,aging_bucket,document_create_date,document_create_date1,due_in_date,invoice_currency,document_type,area_business,baseline_create_date,cust_payment_terms;
//    int sl_no,cust_number,posting_id,invoice_id,isOpen,is_deleted;
//    double total_open_amount;
//    try {
//     Connection conn = getConnection();
//     String sql_query="SELECT * from winter_internship";
//     PreparedStatement pst = conn.prepareStatement(sql_query);
//     //System.out.println(pst);
//     
//     ResultSet rs = pst.executeQuery();
//    
//     while(rs.next())
//     {
//            PojoModel p = new PojoModel();
//            sl_no= rs.getInt(1);
//            business_code=rs.getString(2);
//            cust_number=rs.getInt(3);
//            clear_date=rs.getString(4);
//            buisness_year=rs.getString(5);
//            doc_id=rs.getString(6);
//            posting_date=rs.getString(7);
//            document_create_date=rs.getString(8);
//            document_create_date1=rs.getString(9);
//            due_in_date=rs.getString(10);
//            invoice_currency=rs.getString(11);
//            document_type=rs.getString(12);
//            posting_id=rs.getInt(13);
//            area_business=rs.getString(14);
//            total_open_amount=rs.getDouble(15);
//            baseline_create_date=rs.getString(16);
//            cust_payment_terms=rs.getString(17);
//            invoice_id=rs.getInt(18);
//            isOpen=rs.getInt(19);
//            aging_bucket=rs.getString(20);
//            is_deleted=rs.getInt(21);
//            
//            
//            
//
//            
////            System.out.println("ID is "+sl_no+" "+"Name is "+cust_number);
//            p.setSl_no(sl_no);
//            p.setBusiness_code(business_code);
//            p.setCust_number(cust_number);
//            p.setClear_date(clear_date);
//            p.setBuisness_year(buisness_year);
//            p.setDoc_id(doc_id);
//            p.setPosting_date(posting_date);
//            p.setDocument_create_date(document_create_date);
//            p.setDocument_create_date1(document_create_date1);
//            p.setDue_in_date(due_in_date);
//            p.setInvoice_currency(invoice_currency);
//            p.setDocument_type(document_type);
//            p.setPosting_id(posting_id);
//            p.setArea_business(area_business);
//            p.setTotal_open_amount(total_open_amount);
//            p.setBaseline_create_date(baseline_create_date);
//            p.setCust_payment_terms(cust_payment_terms);
//            p.setInvoice_id(invoice_id);
//            p.setIsOpen(isOpen);
//            p.setAging_bucket(aging_bucket);
//            p.setIs_deleted(is_deleted);
//            
//            listOfAttrs.add("sl_no : " + sl_no);
//            listOfAttrs.add("business_code : " + business_code);
//            listOfAttrs.add("cust_number : " + cust_number);
//            listOfAttrs.add("clear_date : " + clear_date);
//            listOfAttrs.add("doc_id : " + doc_id);
//            listOfAttrs.add("posting_date : " + posting_date);
//            listOfAttrs.add("document_create_date : " + document_create_date);
//            listOfAttrs.add("document_create_date1 : " + document_create_date1);
//            listOfAttrs.add("due_in_date : " + due_in_date);
//            listOfAttrs.add("invoice_currency : " + invoice_currency);
//            listOfAttrs.add("posting_id : " + posting_id);
//            listOfAttrs.add("area_business : " + area_business);
//            listOfAttrs.add("total_open_amount : " + total_open_amount);
//            listOfAttrs.add("baseline_create_date : " + baseline_create_date);
//            listOfAttrs.add("cust_payment_terms : " + cust_payment_terms);
//            listOfAttrs.add("invoice_id : " + invoice_id);
//            listOfAttrs.add("isOpen : " + isOpen);
//            listOfAttrs.add("aging_bucket : " + aging_bucket);
//            listOfAttrs.add("is_deleted : " + is_deleted);
//
//            headerFile.add("Data", listOfAttrs);
//            
//   
//     }
//     
//
//    }
//    catch (Exception e) {
//        e.printStackTrace();
//        System.out.println("exception occur");
//    }
//    
//    return headerFile;
//    
//
//}
