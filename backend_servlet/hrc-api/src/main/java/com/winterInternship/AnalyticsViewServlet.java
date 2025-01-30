package com.winterInternship;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Pojo.PojoModel;
import com.Pojo.PojoModelForAnalytics;
import com.google.gson.Gson;

import connections.AnalyticsView;

/**
 * Servlet implementation class AnalyticsViewServlet
 */
@WebServlet("/AnalyticsViewServlet")
public class AnalyticsViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalyticsViewServlet() {
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
		PojoModelForAnalytics model = new Gson().fromJson(request.getReader(),PojoModelForAnalytics.class);
        String clear_date1 = model.getClear_date1();
        String clear_date2 = model.getClear_date2();
        String due_in_date1 = model.getDue_in_date1();
        String due_in_date2 = model.getDue_in_date2();
        String baseline_create_date1 = model.getBaseline_create_date1();
        String baseline_create_date2 = model.getBaseline_create_date2();
        String invoice_currency = model.getInvoice_currency();
        System.out.println(clear_date1 + " " + clear_date2 + " " + due_in_date1 + " " + due_in_date2 + " " + baseline_create_date1 + " " + baseline_create_date2 + " " + invoice_currency);
        ArrayList<PojoModel> data = AnalyticsView.analyticsfn(model);
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("data", data);
        Gson gson = new Gson();
        String respData=gson.toJson(map);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(respData);  		
        }

}
