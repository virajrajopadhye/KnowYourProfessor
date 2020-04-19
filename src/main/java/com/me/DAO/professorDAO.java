/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.DAO;


import com.me.pojo.Department;
import com.me.pojo.Professor;
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
public class professorDAO {
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
    
    
    public int addDepartment(Department department){
    int result = 0;
    try{
        
        

        beginTransaction();
        getSession().save(department);
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
    
    
    public List<Department> getDepartment(){
        
         List<Department> department = new ArrayList<Department>();
    try{ 
            beginTransaction();
            Query q = getSession().createQuery("from Department");
            
            department=q.list();
           
            commit();
            
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
            
        return department;
    }
    
    
    
    
    public List<Professor> searchProfessorbyName(String name){
        List<Professor> professor = new ArrayList<>();
       
    try{ 
            beginTransaction();
            Query q = getSession().createQuery("from Professor where firstName like :name or lastName like :name");
            q.setString("name", "%"+name+"%");
            professor=q.list();
           
            commit();
            
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
            
        return professor;
    }
    
    
    public int updateprofessor(long id, String department, String firstName, String lastName, String email, List<String> list, String imagepath){
        int result = 0;
        try{
            beginTransaction();
            Query q = getSession().createQuery("from Professor where id= :id");
            q.setLong("id", id);
            Professor professor = (Professor) q.uniqueResult();
            
                    professor.setDepartment(department);
                    professor.setFirstName(firstName);
                    professor.setLastName(lastName);
                    professor.setEmail(email);
                    professor.setSubjects(list);
                    professor.setImagepath(imagepath);
            getSession().save(professor);
            commit();
            result = 1;
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
        return result;
    }
    
    
    
    
    
    
      public List<Professor> getProfessors(){
        
         List<Professor> professor = new ArrayList<Professor>();
        try{ 
            beginTransaction();
            Query q = getSession().createQuery("from Professor");
            
            professor=q.list();
           
            commit();
            
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
            
        return professor;
    }
    
    
    
    
    
    
    public int addStudent(Students student){
    int result = 0;
    try{
        
    

        beginTransaction();
        getSession().save(student);
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
    
    
    public Students Authenticate(String username, String password){
     try{
            beginTransaction();
            Query q = getSession().createQuery("from Students where username= :username and password= :password");
            q.setString("username", username);
            q.setString("password", password);
            Students student = (Students) q.uniqueResult();
            return student;
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
        return null;
    }
    
    
      public int deleteMProfByID(long id) {
        int result = 0;
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Professor where id= :id");
            q.setLong("id", id);
            Professor professorToDelete = (Professor) q.uniqueResult();
            getSession().delete(professorToDelete);
            commit();
            result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return result;
    }
      
      
      
      public Professor getProfessorByIDforUpdate(long id){
          Professor professor = new Professor();
      try{ 
            beginTransaction();
            Query q = getSession().createQuery("from Professor where id=:id");
            q.setLong("id", id);
            professor=(Professor) q.uniqueResult();
           
            commit();
            
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
            
        return professor;
      
      }
    
   
    
    public List<Professor> getProfessorById(int id){
        List<Professor> professor = new ArrayList<Professor>();
        try{ 
            beginTransaction();
            Query q = getSession().createQuery("from Professor where id=:id");
            q.setInteger("id", id);
            professor=q.list();
           
            commit();
            
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
            
        return professor;
    }
    
    
    
     public int addProfessor(Professor professor){
    int result = 0;
    try{
        
  
        beginTransaction();
        getSession().save(professor);
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
    
    
    
    
}
    


