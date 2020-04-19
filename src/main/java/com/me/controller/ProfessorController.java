/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;
import com.me.DAO.professorDAO;
import com.me.pojo.Department;
import com.me.pojo.Professor;
import com.me.pojo.Students;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author viraj
 */
public class ProfessorController extends AbstractController{

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ModelAndView mv = null;
        String optionVal = request.getParameter("option");
         PrintWriter out = response.getWriter();
         HttpSession session = request.getSession(true);
         
         
         if (session.getAttribute("students")==null) {
            return new ModelAndView("login");
         }
         
         
         
         
          if(optionVal.equalsIgnoreCase("searchProf"))  {
            
            professorDAO pdao = new professorDAO();
            String name = request.getParameter("profname");
            out.println(name);
             List<Professor> list = new ArrayList<>();
             list = pdao.searchProfessorbyName(name);
             
              if(list!=null)
                   mv = new ModelAndView("profdetails","professors",list);
               else
                  out.println("professor not found");
       }
          
          else if (optionVal.equalsIgnoreCase("view")){
                professorDAO pdao = new professorDAO();
                String idstring = request.getParameter("id");
                int id = Integer.parseInt(idstring);	
                List<Professor> list= pdao.getProfessorById(id);
                mv=new ModelAndView("profdetails","professors",list);
        
    }
          
          
         
          
          
        return mv;
    }
    
}
