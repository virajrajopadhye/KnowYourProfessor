/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.RatingDAO;
import com.me.DAO.professorDAO;
import com.me.pojo.Department;
import com.me.pojo.Professor;
import com.me.pojo.Rating;
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
public class LoginController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        String optionVal = request.getParameter("option");
         PrintWriter out = response.getWriter();
         HttpSession session = request.getSession(true);
         
         
         
         
                List<String> courselist = new ArrayList<>();
                ArrayList courseList = new ArrayList();  //list of the courses will come from the database in the following lab
        //for now, we will serve from the memory
        //CourseList is provided in the text file.
        //Share with students, so that tehy could just copy-paste the contents.
        //This is created in the list - not in the service method - as we just want to create the list ONCE - not for every request.
        courseList.add("Application Engineering and Development - 33460 - INFO 5100 - 02- (Seattle, WA) - Credits 4");
        courseList.add("Application Engineering and Development - 34708 - INFO 5100 - 03- (Silicon Valley, CA) - Credits 4");
        courseList.add("Application Engineering and Development - 34721 - INFO 5100 - 04- (Boston) - Credits 4");
        courseList.add("Data Science Engineering Methods and Tools - 35632 - INFO 6105 - 02- (Boston) - Credits 4");
        courseList.add("Data Science Engineering Methods and Tools - 35636 - INFO 6105 - 05- (Seattle, WA) - Credits 4");
        courseList.add("Data Science Engineering Methods and Tools - 35639 - INFO 6105 - 06- (Boston) - Credits 4");
        courseList.add("Data Science Engineering Methods and Tools - 35642 - INFO 6105 - 07- (Boston) - Credits 4");
        courseList.add("Data Science Engineering Methods and Tools - 35643 - INFO 6105 - 08- (Silicon Valley, CA) - Credits 4");
        courseList.add("Data Science Engineering Methods and Tools - 35644 - INFO 6105 - 09- (Online) - Credits 4");
        courseList.add("Data Science Engineering Methods and Tools - 37555 - INFO 6105 - 10- (Boston) - Credits 4");
        courseList.add("Web Design and User Experience Engineering - 33513 - INFO 6150 - 01- (Boston) - Credits 4");
        courseList.add("Web Design and User Experience Engineering - 34710 - INFO 6150 - 02- (Boston) - Credits 4");
        courseList.add("Web Design and User Experience Engineering - 35654 - INFO 6150 - 03- (Seattle, WA) - Credits 4");
        courseList.add("Program Structure and Algorithms - 32421 - INFO 6205 - 01- (Boston) - Credits 4");
        courseList.add("Program Structure and Algorithms - 33459 - INFO 6205 - 02- (Seattle, WA) - Credits 4");
        courseList.add("Program Structure and Algorithms - 34506 - INFO 6205 - 03- (Boston) - Credits 4");
        courseList.add("Program Structure and Algorithms - 34507 - INFO 6205 - 05- (Boston) - Credits 4");
        courseList.add("Program Structure and Algorithms - 34847 - INFO 6205 - 06- (Silicon Valley, CA) - Credits 4");
        courseList.add("Program Structure and Algorithms - 35645 - INFO 6205 - 07- (Boston) - Credits 4");
        courseList.add("Data Management and Database Design - 32555 - INFO 6210 - 01- (Boston) - Credits 4");
        courseList.add("Data Management and Database Design - 33009 - INFO 6210 - 02- (Online) - Credits 4");
        courseList.add("Data Management and Database Design - 34654 - INFO 6210 - 05- (Seattle, WA) - Credits 4");
        courseList.add("Data Management and Database Design - 34711 - INFO 6210 - 06- (Boston) - Credits 4");
        courseList.add("Data Management and Database Design - 38073 - INFO 6210 - 08- (Boston) - Credits 4");
        courseList.add("Data Management and Database Design - 38074 - INFO 6210 - 09- (Boston) - Credits 4");
        courseList.add("Data Management and Database Design - 38782 - INFO 6210 - 10- (Boston) - Credits 4");
        courseList.add("Business Analysis and Information Engineering - 30819 - INFO 6215 - 01- (Online) - Credits 4");
        courseList.add("Planning and Managing Information Systems Development - 36225 - INFO 6245 - 01- (Boston) - Credits 4");
        courseList.add("Web Development Tools and Methods - 31822 - INFO 6250 - 02- (Boston) - Credits 4");
        courseList.add("Web Development Tools and Methods - 33496 - INFO 6250 - 04- (Boston) - Credits 4");
        courseList.add("Web Development Tools and Methods - 34149 - INFO 6250 - 05- (Seattle, WA) - Credits 4");
        courseList.add("Web Development Tools and Methods - 34846 - INFO 6250 - 07- (Silicon Valley, CA) - Credits 4");
        courseList.add("Software Quality Control and Management - 35652 - INFO 6255 - 01- (Boston) - Credits 4");
        courseList.add("Software Quality Control and Management - 36364 - INFO 6255 - 02- (Boston) - Credits 4");
        courseList.add("Smartphones-Based Web Development - 32485 - INFO 6350 - 01- (Boston) - Credits 4");
        courseList.add("Smartphones-Based Web Development - 33952 - INFO 6350 - 02- (Seattle, WA) - Credits 4");
        courseList.add("Smartphones-Based Web Development - 36699 - INFO 6350 - 03- (Silicon Valley, CA) - Credits 4");
        courseList.add("Business Ethics and Intellectual Property for Engineers - 34702 - INFO 6660 - 01- (Boston) - Credits 4");
        courseList.add("Co-op Work Experience - 38528 - INFO 6964 - 02- (No campus, no room needed) - Credits 0");
        courseList.add("Co-op Work Experience - 38529 - INFO 6964 - 06- (No campus, no room needed) - Credits 0");
        courseList.add("Co-op Work Experience - 38530 - INFO 6964 - 07- (No campus, no room needed) - Credits 0");
        courseList.add("Co-op Work Experience - 38531 - INFO 6964 - 08- (No campus, no room needed) - Credits 0");
        courseList.add("Co-op Work Experience - 38821 - INFO 6964 - 10- (No campus, no room needed) - Credits 0");
        courseList.add("Co-op Work Experience Abroad - 39077 - INFO 6965 - 05- (No campus, no room needed) - Credits 0");
        courseList.add("Co-op Work Experience Abroad - 39078 - INFO 6965 - 06- (No campus, no room needed) - Credits 0");
        courseList.add("Co-op Work Experience Abroad - 39079 - INFO 6965 - 07- (No campus, no room needed) - Credits 0");
        courseList.add("Co-op Work Experience Abroad - 39187 - INFO 6965 - 08- (No campus, no room needed) - Credits 0");
        courseList.add("Accounting and Budgetary Systems for Engineers - 37558 - INFO 7225 - 01- (Boston) - Credits 4");
        courseList.add("Agile Software Development - 38140 - INFO 7245 - 01- (Seattle, WA) - Credits 4");
        courseList.add("Agile Software Development - 38772 - INFO 7245 - 02- (Boston) - Credits 4");
        courseList.add("Advanced Big-Data Applications and Indexing Techniques - 35006 - INFO 7255 - 01- (Boston) - Credits 4");
        courseList.add("Advanced Big-Data Applications and Indexing Techniques - 37559 - INFO 7255 - 02- (Online) - Credits 4");
        courseList.add("Advanced Database Management Systems - 37561 - INFO 7275 - 02- (Online) - Credits 4");
        courseList.add("Organizational Change and IT - 32446 - INFO 7285 - 01- (Boston) - Credits 4");
        courseList.add("Data Warehousing and Business Intelligence - 32447 - INFO 7290 - 01- (Online) - Credits 4");
        courseList.add("Engineering Cybersecure Software Systems - 34714 - INFO 7300 - 01- (Boston) - Credits 4");
        courseList.add("Designing Advanced Data Architectures for Business Intelligence - 35649 - INFO 7370 - 01- (Boston) - Credits 4");
        courseList.add("Designing Advanced Data Architectures for Business Intelligence - 38417 - INFO 7370 - 04- (Boston) - Credits 4");
        courseList.add("Algorithmic Digital Marketing - 34716 - INFO 7374 - 01- (Boston) - Credits 4");
        courseList.add("App Mach Learn & Python In Fin - 36480 - INFO 7374 - 02- (Boston) - Credits 4");
        courseList.add("Machine Learning Med Devices - 37564 - INFO 7374 - 04- (Silicon Valley, CA) - Credits 4");
        courseList.add("ST: Intro to Quantum Computing - 37565 - INFO 7374 - 05- (Seattle, WA) - Credits 4");
        courseList.add("ST: FinTech Engineering I - 37937 - INFO 7374 - 06- (Boston) - Credits 4");
        courseList.add("Adv User Experience Research - 38135 - INFO 7374 - 07- (Seattle, WA) - Credits 4");
        courseList.add("Special Topics in Artificial Intelligence Engineering and Applications - 37566 - INFO 7375 - 01- (Boston) - Credits 4");
        courseList.add("Managerial Communications for Engineers - 38811 - INFO 7385 - 02- (Boston) - Credits 4");
        courseList.add("Advances in Data Sciences and Architecture - 37569 - INFO 7390 - 03- (Boston) - Credits 4");
        courseList.add("Advances in Data Sciences and Architecture - 37570 - INFO 7390 - 04- (Online) - Credits 4");
        courseList.add("Cryptocurrency and Smart Contract Engineering - 36477 - INFO 7500 - 03- (Boston) - Credits 4");
        courseList.add("Smart Contract Application Engineering and Development - 34715 - INFO 7510 - 01- (Boston) - Credits 4");
        courseList.add("Special Topics in Natural Language Engineering Methods and Tools - 38653 - INFO 7610 - 01- (Boston) - Credits 4");
        courseList.add("Independent Study - 34914 - INFO 7978 - 01- (No campus, no room needed) - Credits 1 to 4");
        
        String username = request.getParameter("username");
         String password = request.getParameter("password");
         professorDAO pdao = new professorDAO();
            
          List<Department> deptlist = pdao.getDepartment();
          Students student = pdao.Authenticate(username, password);
          List<Professor> professorlist = pdao.getProfessors();
          List<Students> studentlist = new ArrayList<>();
          
         if (session.getAttribute("students") == null && optionVal.equals("")) {
            return new ModelAndView("login");
        }
       
         if (optionVal.equalsIgnoreCase("checkLogin")) {
                if(username.equals("admin")&& password.equals("admin")){
                       
                        //session.setAttribute("professors", professorlist);
                        session.setAttribute("courseList", courseList);
                        session.setAttribute("departments", deptlist);
                        session.setAttribute("professors", professorlist);
                        mv = new ModelAndView("index");
                        return mv;
               
                 }
                
                
                else if(student!=null ){

                 List<Rating> ratinglist = new ArrayList<>();
                 List<Professor> ratedprofessorlist = new ArrayList<>();
                 RatingDAO rdao = new RatingDAO();
                 ratinglist = rdao.getRatingByStudentID(student.getId());
                 for(Rating r : ratinglist){
                     ratedprofessorlist.add(pdao.getProfessorByIDforUpdate(r.getProfessor_id()));
                 }
                 studentlist.add(student); 
                 Map<String, Object> map = new HashMap<>();
                    map.put("professor", professorlist);
                    map.put("student", studentlist);
                    map.put("ratedprofessorlist", ratedprofessorlist);
                    map.put("ratings", ratinglist);
                    session.setAttribute("stu", studentlist);
                    session.setAttribute("students", map);
                    mv = new ModelAndView("loginsuccess");
                 }
                
                 else{
                    out.println("error logging in");
                 }
         }
         
         else if (optionVal.equalsIgnoreCase("logout")){
                session.invalidate();
                mv = new ModelAndView("login");
         }
         
         else if (optionVal.equalsIgnoreCase("home")){
             
             
             if(session.getAttribute("students")==null){
                 mv = new ModelAndView("login");
             }
             else{
                       // Student student = session.getAttribute(username)
                        List<Students> list = (List<Students>) session.getAttribute("stu");
                         List<Rating> ratinglist = new ArrayList<>();
                         List<Professor> ratedprofessorlist = new ArrayList<>();
                        long student_id =0;
                        List<Students> list2 = new ArrayList<>();
                        for(Students stu: list){
                           list2.add(stu);
                           student_id=stu.getId();
                        }

                         RatingDAO rdao = new RatingDAO();


                         ratinglist = rdao.getRatingByStudentID(student_id);



                         for(Rating r : ratinglist){
                             ratedprofessorlist.add(pdao.getProfessorByIDforUpdate(r.getProfessor_id()));
                 }
                 
                 
                 //studentlist.add(student); 
                    Map<String, Object> map = new HashMap<>();
                    map.put("professor", professorlist);
                    map.put("student", list2);
                    map.put("ratedprofessorlist", ratedprofessorlist);
                    map.put("ratings", ratinglist);
                    session.setAttribute("students", map);
                    mv = new ModelAndView("loginsuccess");
                }
         }
         else{
         mv = new ModelAndView("login");
         }
        
         
      
  
        return mv;
    }
    
}
