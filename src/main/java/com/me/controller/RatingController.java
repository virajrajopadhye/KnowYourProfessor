/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.RatingDAO;
import com.me.DAO.professorDAO;
import com.me.pojo.Professor;
import com.me.pojo.Rating;
import com.me.pojo.Students;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author viraj
 */
public class RatingController extends AbstractController {
    
    
    public class viewRating{

     
    int totalratings;
    double overall_rating;
    double difficulty;
    double recommend_percent;
    double industry_percent;
    String profFName;
    String profLName;
    String profImage;
    double attendance;

        public double getAttendance() {
            return attendance;
        }

        public void setAttendance(double attendance) {
            this.attendance = attendance;
        }

        public String getProfImage() {
            return profImage;
        }

        public void setProfImage(String profImage) {
            this.profImage = profImage;
        }

        public String getProfFName() {
            return profFName;
        }

        public void setProfFName(String profFName) {
            this.profFName = profFName;
        }

        public String getProfLName() {
            return profLName;
        }

        public void setProfLName(String profLName) {
            this.profLName = profLName;
        }

      

        public double getIndustry_percent() {
            return industry_percent;
        }

        public void setIndustry_percent(double industry_percent) {
            this.industry_percent = industry_percent;
        }
        
        public int getTotalratings() {
            return totalratings;
        }

        public double getRecommend_percent() {
            return recommend_percent;
        }

        public void setRecommend_percent(double recommend_percent) {
            this.recommend_percent = recommend_percent;
        }

        public void setTotalratings(int totalratings) {
            this.totalratings = totalratings;
        }
        public double getOverall_rating() {
            return overall_rating;
        }

        public void setOverall_rating(double overall_rating) {
            this.overall_rating = overall_rating;
        }

        public double getDifficulty() {
            return difficulty;
        }

        public void setDifficulty(double difficulty) {
            this.difficulty = difficulty;
        }
    
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        String optionVal = request.getParameter("option");
         PrintWriter out = response.getWriter();
         HttpSession session = request.getSession(true);
         if(session.getAttribute("students")==null){
                 mv = new ModelAndView("login");
             }
         
         professorDAO pdao= new professorDAO();
//         String professorid= request.getParameter("professorid");
//         int profid = Integer.parseInt(professorid);
//         List<Professor> list = pdao.getProfessorById(profid);
         
         
         
         if(optionVal.equalsIgnoreCase("rate")){
             if(session.getAttribute("students")==null){
                 mv = new ModelAndView("login");
             }
                 String professorid= request.getParameter("id");
                int profid = Integer.parseInt(professorid);
                List<Professor> list = pdao.getProfessorById(profid);
                mv=new ModelAndView("selectProfForRating", "professors", list);
                 
         }
         
         else if(optionVal.equalsIgnoreCase("rateProf")){
             if(session.getAttribute("students")==null){
                 mv = new ModelAndView("login");
             }
             Rating rating = new Rating();
             RatingDAO rdao = new RatingDAO();
             long profid = parseLong(request.getParameter("professorid"));
             String profFname = request.getParameter("professorfname");
             String profLname = request.getParameter("professorlname");
             
             long studentid= parseLong(request.getParameter("studentId"));
             String subject = request.getParameter("subject");
             int overall_rating = parseInt(request.getParameter("rangeInputrating"));
             int difficulty = parseInt(request.getParameter("rangeInputdifficulty"));
             int recommend= parseInt(request.getParameter("recommend"));
             int attendance=parseInt(request.getParameter("attendance"));
             int industry_use =parseInt(request.getParameter("indusry"));
             String comment = request.getParameter("comment");
             
             
             int check = (int) rdao.check(subject, studentid);
            
             
             if(check<=0){
                rating.setProfessor_id(profid);
                rating.setProfessor_fName(profFname);
                rating.setProfessor_LName(profLname);
                rating.setStudent_id(studentid);
                rating.setSubject(subject);
                rating.setDifficulty(difficulty);
                rating.setAttendance(attendance);
                rating.setComment(comment);
                rating.setIndustry_use(industry_use);
                rating.setRecommend(recommend);
                rating.setOverall_rating(overall_rating);
             
             
             int result= rdao.addRating(rating);
             
             if(result==1){
              Map <String, Object> map =  (Map <String, Object>) session.getAttribute("students");
              
              List<Students> list = (List<Students>) map.get("student");
              String emailid = null;
              String firstName = null;
              for(Students stu : list){
                  emailid=stu.getEmail();
                  firstName=stu.getFirstName();
              }
                        Email email = new SimpleEmail();
                        email.setHostName("smtp.gmail.com");
                        email.setSmtpPort(465);
                        email.setAuthenticator(new DefaultAuthenticator("username", "password"));
                        email.setSSLOnConnect(true);
                        email.setFrom("virajrajopadhye@gmail.com");
                        email.setSubject("Rating Received");
                        email.setMsg("Hello "+firstName+","+"\n"+"Your rating has been sucessfully received. Thank you for your time"+"\n"+"Best Regards,"+"\n"+"Northeastern University");
                        email.addTo(emailid);
                        email.send();
                 
                 
                 mv = new ModelAndView("ratingSuccess");
                }
             }
             else{
             
              mv=new ModelAndView("alreadyrated");
             
             }
             
             
         }
         
         else if(optionVal.equalsIgnoreCase("view")){
             if(session.getAttribute("students")==null){
                 mv = new ModelAndView("login");
             }
             //int  profid= parseInt(request.getParameter("profID"));
             
             String subject = request.getParameter("id");
             RatingDAO rdao = new RatingDAO();
             
            
         
                 //session.setAttribute("parameters", list2);
                    int totalratings = (int) rdao.totalRatings(subject);

                        if(totalratings==0 ){
                            mv=new ModelAndView("ratingnotfound");
                        
                        }
                        else{
                            List<Rating> list = rdao.viewRatingsBySubject(subject);
                                Set<Long> set = new HashSet<>();

                               for(Rating r :list){
                                   set.add(r.getProfessor_id());
                               }

                               long l = set.stream().findFirst().get();

                            
                            Professor p = pdao.getProfessorByIDforUpdate(l);
                            
                            
                            
                            viewRating vr = new viewRating();


                            int totRec = (int) rdao.totalRecommendation(subject);
                            double rcip = (100*totRec)/totalratings;
                            
                            int totInd = (int) rdao.totalIndustry(subject);
                            double indip = (100*totInd)/totalratings;
                            
                            int totAtt = (int) rdao.totalattendance(subject);
                            double attip = (100*totAtt)/totalratings;
                            
                            double overall_rating=   Math.round (rdao.avgoverallRating(subject));
                            double difficulty= Math.round (rdao.avgdifficulty(subject));
                            double attendance = rdao.totalattendance(subject);

                            vr.setOverall_rating(overall_rating);
                            vr.setDifficulty(difficulty);
                            vr.setTotalratings(totalratings);
                            vr.setRecommend_percent(rcip);
                            vr.setIndustry_percent(indip);
                            vr.setProfFName(p.getFirstName());
                            vr.setProfLName(p.getLastName());
                            vr.setProfImage(p.getImagepath());
                            vr.setAttendance(attip);
                            
                            out.println(p.getImagepath());
                            
                            List<viewRating> list2 = new ArrayList<>();
                            list2.add(vr);


                            Map<String,List> map = new HashMap<>();
                            map.put("overall_rating",list);
                            map.put("parameters",list2);
                            mv=new ModelAndView("viewrating","ratings",map);
                        }
                    }
             
         
        
        
        return mv;
    }
    
}
