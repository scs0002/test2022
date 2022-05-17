package com.bit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.util.Bitmy;

public class EmpDeleteController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setCharacterEncoding("application/json");
		
		int empno=Integer.parseInt(req.getParameter("empno").trim());
		String sql = "delete from emp where empno="+empno;
		
		try(
			Connection conn = Bitmy.getConnection();
			Statement stmt = conn.createStatement();
			
		){
			stmt.executeUpdate(sql);
			resp.setStatus(HttpServletResponse.SC_OK);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
	
}
