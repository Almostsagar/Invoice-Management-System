package com.winterInternship;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Pojo.PojoModel;
import com.google.gson.Gson;

import connections.DataDelete;

/**
 * Servlet implementation class DataDeleteServlet
 */
@WebServlet("/DataDeleteServlet")
public class DataDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PojoModel model2 = new Gson().fromJson(request.getReader(), PojoModel.class);
		int sl_no = model2.getSl_no();
		System.out.println(sl_no);
		DataDelete.deletedata(sl_no);
		String msg = "success";
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("data", msg);
		Gson gson = new Gson();
		String respData=gson.toJson(map);
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("UTF-8");		
		response.getWriter().print(respData);	
		}

}
