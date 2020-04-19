/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.professorDAO;
import com.me.pojo.Department;
import com.me.pojo.Professor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author viraj
 */
public class DepartmentController extends AbstractController {
    
   
    public DepartmentController() {
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
       ModelAndView mv = null;
        String option = request.getParameter("option") == null ? "" : request.getParameter("option");
             PrintWriter out = response.getWriter();
             
             
       HttpSession session = request.getSession(true);
             
             professorDAO pdao = new professorDAO();
             
             //out.println("we are here");
             if (option == null || option == "") {
                    mv = new ModelAndView("login");
                    return mv;
             }
             else if(option.equalsIgnoreCase("register")){
                 
                 mv= new ModelAndView("register");
                 return mv;
             }
             
             
            else if(option.equalsIgnoreCase("addDept")){
                  if (session.getAttribute("courseList") == null ) {
                    return new ModelAndView("login");
        }
               String departmentname = request.getParameter("department");
               Department department = new Department();
               department.setDepartmentName(departmentname);
               int result =  pdao.addDepartment(department);
               if(result==1){
//                 
                mv = new ModelAndView("DeptAddSuccess");
                }
             
             }
             
              else if(option.equalsIgnoreCase("addProfessor")){
                  if (session.getAttribute("courseList") == null ) {
                    return new ModelAndView("login");
        }
                
               List<String> list = Arrays.asList(request.getParameterValues("courses"));
               String department = request.getParameter("department");
               String firstName = request.getParameter("firstName");
               String lastName = request.getParameter("lastName");
               String email = request.getParameter("email");
               String imagepath = request.getParameter("imagepath");
               
                    Professor professor = new Professor();
                    professor.setDepartment(department);
                    professor.setFirstName(firstName);
                    professor.setLastName(lastName);
                    professor.setEmail(email);
                    professor.setSubjects(list);
                    professor.setImagepath(imagepath);

               
             
               int result = pdao.addProfessor(professor);
               if(result==1){
                mv = new ModelAndView("profAddSuccess");
                }
               else{
                   out.println("couldnt add professor");
               }
//             
             }
             
             
             
             
              else if(option.equalsIgnoreCase("delete")) {
                  if (session.getAttribute("courseList") == null ) {
                    return new ModelAndView("login");
        }
                    professorDAO pdao1 = new professorDAO();
                    long id = Long.parseLong(request.getParameter("id"));
                    int result = pdao1.deleteMProfByID(id);
                   if(result==1) {
                        //String msg = "Professor with id "+id+" has been deleted successfully";
                        mv = new ModelAndView("profDeleteSuccess");
                    }
                   else{
                       out.println("Prof del failed");
                   }
            
         }
             
             
            else if (option.equalsIgnoreCase("update")) {
                if (session.getAttribute("courseList") == null ) {
                    return new ModelAndView("login");
        }
            long id = Long.parseLong(request.getParameter("id"));
            professorDAO pdao1 = new professorDAO();
            Professor professor = pdao1.getProfessorByIDforUpdate(id);
            session.setAttribute("departments1", session.getAttribute("departments"));
            session.setAttribute("courseList", session.getAttribute("courseList"));
            mv = new ModelAndView("updateProfessor", "professor", professor);
            return mv;
          }
             
             
            else if (option.equalsIgnoreCase("updateProfessor")){
                if (session.getAttribute("courseList") == null ) {
                    return new ModelAndView("login");
        }
                
            professorDAO pdao2 = new professorDAO();
            long id = Long.parseLong(request.getParameter("id"));
            List<String> list = Arrays.asList(request.getParameterValues("courses"));
            String department = request.getParameter("department");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String imagepath = request.getParameter("imagepath");
            
           int result = pdao.updateprofessor(id, department, firstName, lastName, email, list, imagepath);
           
           if(result==1){
               mv = new ModelAndView("profUpdSuccess");
           }
         
            }
             
             
             else if (option.equalsIgnoreCase("adminhome")){
             if (session.getAttribute("courseList") == null ) {
                    return new ModelAndView("login");
             
             }
             else{
                  List<Professor> professorlist = pdao.getProfessors();
                 session.setAttribute("professors", professorlist);
                 mv = new ModelAndView("index");
             }
             
             }
             
             
             else if (option.equalsIgnoreCase("adminhomefromdelete")){
             if (session.getAttribute("courseList") == null ) {
                
                    return new ModelAndView("login");
             }
             else{
                 List<Professor> professorlist = pdao.getProfessors();
                 session.setAttribute("professors", professorlist);
                 mv = new ModelAndView("index");
                    }
             
             }
             
             
             
             
             
        return mv;
    }



}
