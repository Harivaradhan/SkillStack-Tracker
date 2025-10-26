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

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	    private SkillDAO skillDAO;

	    @Override
	    public void init() throws ServletException {
	        skillDAO = new SkillDAOImpl();
	    }

	    // Handle CORS preflight
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
	    protected void doPut(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        // Allow CORS
	        response.setHeader("Access-Control-Allow-Origin", "https://skillstack-beige.vercel.app/");

	        // Handle preflight
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

	        // Convert JSON to Skill object
	        Gson gson = new Gson();
	        Skill skill = gson.fromJson(jsonData, Skill.class);

	        // Update skill using DAOb
	        skillDAO.updateSkills(skill);

	        // Send response
	        response.setContentType("application/json");
	        response.getWriter().write("{\"message\":\"Skill updated successfully!\"}");
	    }
	}
   
