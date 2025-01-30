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
import com.google.gson.Gson;

import connections.DataSearch;

/**
 * Servlet implementation class DataSearchServlet
 */
@WebServlet("/DataSearchServlet")
public class DataSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PojoModel model2 = new Gson().fromJson(request.getReader(),PojoModel.class);
        int cust_number = model2.getCust_number();
        System.out.println(cust_number);
        ArrayList<PojoModel> data = DataSearch.searchstu(cust_number);
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("data", data);
        Gson gson = new Gson();
        String respData=gson.toJson(map);
          response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(respData);  	
        }
}
