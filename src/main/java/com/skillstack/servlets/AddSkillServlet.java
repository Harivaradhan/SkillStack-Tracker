package com.skillstack.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.skillstack.dao.SkillDAO;
import com.skillstack.dao.SkillDAOImpl;
import com.skillstack.model.Skill;


@WebServlet("/addSkill")
public class AddSkillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private SkillDAO skillDAO;

	    @Override
	    public void init() throws ServletException {
	        skillDAO = new SkillDAOImpl(); // initialize DAO
	    }

	    @Override
	    protected void doOptions(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	        response.setHeader("Access-Control-Allow-Origin", "https://skillstack-beige.vercel.app/");
	        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
					    res.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        res.setHeader("Access-Control-Allow-Credentials", "true");
	        response.setStatus(HttpServletResponse.SC_OK);
	    }
	    
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	    	// Allow CORS
	    	 response.setHeader("Access-Control-Allow-Origin", "https://skillstack-beige.vercel.app/");

	        // Handle preflight request
	        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
	            response.setStatus(HttpServletResponse.SC_OK);
	            return;
	        }
	    	
	    	
	        // Read JSON from request body
	        StringBuilder sb = new StringBuilder();
	        BufferedReader reader = request.getReader();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line);
	        }
	        String jsonData = sb.toString();

	        // Convert JSON to Skill object using Gson
	        Gson gson = new Gson();
	        Skill skill = gson.fromJson(jsonData, Skill.class);

	        // Add skill using DAO
	        skillDAO.addSkills(skill);

	        // Respond back to frontend
	        response.setContentType("application/json");
	        response.getWriter().write("{\"message\":\"Skill added successfully!\"}");
	    }
  

	


}
