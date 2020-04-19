/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.RatingDAO;
import com.me.DAO.professorDAO;
import com.me.pojo.Rating;
import com.me.pojo.Students;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author viraj
 */
public class StudentController extends AbstractController{

    public StudentController() {
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
         ModelAndView mv = null;
        String option = request.getParameter("option") == null ? "" : request.getParameter("option");
             PrintWriter out = response.getWriter();
             
             
             
             if(option.equalsIgnoreCase("addStudent")){
                 int result = 0;
                   professorDAO pdao = new professorDAO();  
                        String firstName= request.getParameter("firstName");
                        String lastName= request.getParameter("lastName");
                        String email = request.getParameter("email");
                        String username = request.getParameter("username");
                        String password = request.getParameter("password");

                        Students student = new Students();
                        student.setFirstName(firstName);
                        student.setLastName(lastName);
                        student.setEmail(email);
                        student.setUsername(username);
                        student.setPassword (password);
                        student.setRate(Boolean.FALSE);
          
                      
                        result = pdao.addStudent(student);
              
                 
             if(result == 1){
                 mv=new ModelAndView("registerSuccess");
                 return mv;
             }
             else{
                 mv=new ModelAndView("register");
             }
            
             
             }
             
   
            
             
             
        return mv;
    }
    
}
