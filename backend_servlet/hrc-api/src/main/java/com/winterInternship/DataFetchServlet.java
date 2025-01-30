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

import connections.DataFetch;

/**
 * Servlet implementation class ServletJson
 */
@WebServlet("/ServletJson")
public class DataFetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataFetchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataFetch fetchdata = new DataFetch();
		ArrayList<PojoModel> data = fetchdata.getData();
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("data", data);
		Gson gson = new Gson();
		String respData=gson.toJson(map);
	    response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(respData);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
