/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.DAO;

/**
 *
 * @author viraj
 */
import com.me.pojo.Department;
import com.me.pojo.Professor;
import com.me.pojo.Rating;
import com.me.pojo.Students;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author viraj
 */
public class RatingDAO {
     private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private Session session = null;
    
     private Session getSession() {
        if (session == null || !session.isOpen()) {
            session = sf.openSession();
        }
        return session;
    }

    private void beginTransaction() {
        getSession().beginTransaction();
    }

    private void commit() {
        getSession().getTransaction().commit();;
    }

    private void close() {
        getSession().close();
    }

    private void rollbackTransaction() {
        getSession().getTransaction().rollback();
    }
    
    
    
    public int addRating(Rating rating){
        int result = 0;
        try{
            beginTransaction();
            getSession().save(rating);
             commit();
             result = 1;
            }
            catch (HibernateException e) {
                e.printStackTrace();
                rollbackTransaction();
            } finally {
                close();
            }
        return result;
        }
    
    
    public List<Rating> getRatingByStudentID(long student_id){
        
         List<Rating> rating = new ArrayList<Rating>();
         try{ 
            beginTransaction();
            Query q = getSession().createQuery("from Rating where student_id= :student_id");
            q.setLong("student_id", student_id);
            rating=q.list();
           
            commit();
            
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
            
        return rating;
    }
    
    
    public long check(String subject, long student_id){
        long check = 0;
             try{ 
            beginTransaction();
            Query q = getSession().createQuery("select count(*) from Rating where subject= :subject and student_id= :student_id");
            q.setString("subject", subject);
            q.setLong("student_id", student_id);
            check=(long) q.uniqueResult();
           
            commit();
            
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
            
        return check;
    
    }
    
    
    
    
    
    
      public List<Rating> viewRatingsBySubject(String subject){
        
         List<Rating> rating = new ArrayList<Rating>();
         try{ 
            beginTransaction();
            Query q = getSession().createQuery("from Rating where subject= :subject");
            q.setString("subject", subject);
            rating=q.list();
           
            commit();
            
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
            
        return rating;
    }
      
      public long totalRatings(String subject){
          long totalRatings = 0;
             try{ 
            beginTransaction();
            Query q = getSession().createQuery("select count(*) from Rating where subject= :subject");
            q.setString("subject", subject);
            totalRatings=(long) q.uniqueResult();
           
            commit();
            
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
            
        return totalRatings;
       
      }
      
      
      
      public long totalRecommendation(String subject){
      
          long totalreommendations = 0;
          
          try{ 
            beginTransaction();
            Query q = getSession().createQuery("select count(*) from Rating where subject= :subject and recommend= :recommend");
            q.setString("subject", subject);
            q.setInteger("recommend", 1);
            totalreommendations=(long) q.uniqueResult();
           
            commit();
            
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
            
        return totalreommendations;
      
      }
      
      
      
          public long totalattendance(String subject){
      
          long totalattendance = 0;
          
          try{ 
            beginTransaction();
            Query q = getSession().createQuery("select count(*) from Rating where subject= :subject and attendance= :attendance");
            q.setString("subject", subject);
            q.setInteger("attendance", 1);
            totalattendance=(long) q.uniqueResult();
           
            commit();
            
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
            
        return totalattendance;
      
      }
      
      
       public long totalIndustry(String subject){
      
          long totalindustry = 0;
          
          try{ 
            beginTransaction();
            Query q = getSession().createQuery("select count(*) from Rating where subject= :subject and industry_use= :industry");
            q.setString("subject", subject);
            q.setInteger("industry", 1);
            totalindustry=(long) q.uniqueResult();
           
            commit();
            
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
            
        return totalindustry;
      
      }
      
      
      
    
     public Rating checkRating(String subject){
     Rating rating = new Rating();
          try{ 
            beginTransaction();
            Query q = getSession().createQuery("from Rating where subject= :subject");
            q.setString("subject", subject);
            
            rating = (Rating) q.uniqueResult();
           
           
            commit();
            
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
            
        return rating;
       
     
     
     } 
      
      
      
      
      
      public double avgoverallRating(String subject){
          double overallrating = 0;
             try{ 
            beginTransaction();
            Query q = getSession().createQuery("select avg(overall_rating) from Rating where subject= :subject");
            q.setString("subject", subject);
            
            overallrating= (double) q.uniqueResult();
           
           
            commit();
            
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
            
        return overallrating;
       
      }
      
      
       public double avgdifficulty(String subject){
          double overallrating = 0;
             try{ 
            beginTransaction();
            Query q = getSession().createQuery("select avg(difficulty) from Rating where subject= :subject");
            q.setString("subject", subject);
            overallrating= (double) q.uniqueResult();
           
            commit();
            
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
            
        return overallrating;
       
      }
       
       
       
    
}