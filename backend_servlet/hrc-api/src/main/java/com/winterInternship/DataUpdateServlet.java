package com.winterInternship;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Pojo.PojoModel;
import com.google.gson.Gson;

import connections.DataUpdate;

/**
 * Servlet implementation class DataUpdateServlet
 */
@WebServlet("/DataUpdateServlet")
public class DataUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataUpdateServlet() {
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
	    int sl_no = model2.getSl_no();

	    String invoice_currency = model2.getInvoice_currency();
	    String cust_payment_terms = model2.getCust_payment_terms();
	    
	    PojoModel model = new PojoModel(invoice_currency,cust_payment_terms);
	    
	    model.setCust_payment_terms(cust_payment_terms);
	    model.setInvoice_currency(invoice_currency);
	    
	    DataUpdate.editdata(model,sl_no);
			
		
	}

}
