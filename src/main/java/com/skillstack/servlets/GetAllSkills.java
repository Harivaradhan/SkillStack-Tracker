package com.skillstack.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.skillstack.dao.SkillDAO;
import com.skillstack.dao.SkillDAOImpl;
import com.skillstack.model.Skill;


@WebServlet("/getAllSkills")
public class GetAllSkills extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SkillDAO skillDAO;

    @Override
    public void init() throws ServletException {
        skillDAO = new SkillDAOImpl(); // initialize DAO
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setStatus(HttpServletResponse.SC_OK);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");


        // Handle preflight request
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }
    	
        // Fetch all skills from DB
        List<Skill> skills = skillDAO.getAllSkills();

        // Convert list to JSON
        Gson gson = new Gson();
        String json = gson.toJson(skills);

        // Send response
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}
