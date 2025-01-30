package com.winterInternship;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Pojo.PojoModel;
import com.google.gson.Gson;

import connections.DataAdd;

/**
 * Servlet implementation class ServletAdd
 */
@WebServlet("/ServletAdd")
public class DataAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PojoModel model2 = new Gson().fromJson(request.getReader(), PojoModel.class);
		String business_code,clear_date,buisness_year,
		doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,baseline_create_date,cust_payment_terms;
        int cust_number,posting_id,invoice_id;
        double total_open_amount;
        
        business_code=model2.getBusiness_code();
        cust_number=model2.getCust_number();
        clear_date=model2.getClear_date();
        buisness_year=model2.getBuisness_year();
        doc_id=model2.getDoc_id();
        posting_date=model2.getPosting_date();
        document_create_date=model2.getDocument_create_date();
        due_in_date=model2.getDue_in_date();
        invoice_currency=model2.getInvoice_currency();
        document_type=model2.getDocument_type();
        posting_id=model2.getPosting_id();
        total_open_amount=model2.getTotal_open_amount();
        baseline_create_date=model2.getBaseline_create_date();
        cust_payment_terms=model2.getCust_payment_terms();
        invoice_id=model2.getInvoice_id();
        
    model2.setBusiness_code(business_code);
    model2.setCust_number(cust_number);
    model2.setClear_date(clear_date);
    model2.setBuisness_year(buisness_year);
    model2.setDoc_id(doc_id);
    model2.setPosting_date(posting_date);
    model2.setDocument_create_date(document_create_date);
    model2.setDue_in_date(due_in_date);
    model2.setInvoice_currency(invoice_currency);
    model2.setDocument_type(document_type);
    model2.setPosting_id(posting_id);
    model2.setTotal_open_amount(total_open_amount);
    model2.setBaseline_create_date(baseline_create_date);
    model2.setCust_payment_terms(cust_payment_terms);
    model2.setInvoice_id(invoice_id);  
    
    DataAdd.getAdd(model2);   
		
	Gson gson = new Gson();
	String JSONresponse = gson.toJson(model2);
	response.setHeader("Access-Control-Allow-Origin", "*");
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().append(JSONresponse);	
	}

}
