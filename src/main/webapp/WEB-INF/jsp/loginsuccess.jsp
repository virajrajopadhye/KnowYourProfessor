<%-- 
    Document   : loginsuccess
    Created on : Mar 26, 2020, 4:46:36 PM
    Author     : viraj
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
            <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
            <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
            <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
      
    </head>
    
    <style>
        .custab{
    border: 1px solid #ccc;
    padding: 5px;
    margin: 5% 0;
    box-shadow: 3px 3px 2px #ccc;
    transition: 0.5s;
    }
.custab:hover{
    box-shadow: 3px 3px 0px transparent;
    transition: 0.5s;
    }
    
    .form-inline{
        padding-top: 8px;
    }
    </style>
    
    
   
    
    <body>
        
            <nav class="navbar navbar-inverse">
               <div class="container-fluid">
                 <div class="navbar-header">
                   <a class="navbar-brand" href="#">Know Your Professor</a>
                 </div>
                   <form action="logout.htm" method="post">
                        <ul class="nav navbar-nav">

                                   <li class="active"><a href="login.htm?option=logout">Logout</a></li>
       <!--                   <li> <input type="hidden" name="option" value="logout">
                               <input type="submit" value="Logout">
                          </li>-->

                        </ul>
                  </form>
                      
                      
                  <form action="login.htm" method="post">
                        <ul class="nav navbar-nav">

                                   <li class="active"><a href="login.htm?option=home">Home</a></li>
 

                        </ul>
                  </form>
                   
                   <form class="form-inline my-2 my-lg-0" method="GET" action="professor.htm">
                       
                        <input class="form-control" type="text" name="profname" placeholder="Enter first or last name"/>
                        <input type="hidden" value="searchProf" name="option" /> 
                        <input class="btn btn-outline-success my-2 my-sm-0" type="submit" name="Submit" value="Search Professor"/>
                       
                   </form>
                   
                   
               </div>
           </nav>
        <br>
        
       
           
        
        
       
       
        
      
        <br>       
       <div class="container">
     
        <c:forEach var="student" items="${students.student}">
          <h1> Welcome <c:out value="${student.getFirstName()}" /></h1> 
        </c:forEach>
          <br>
          Your Recent Ratings
          <div>
     <table class="table table-striped table-bordered" width="70%" > 
        
        <tr>
            <td align="center">Subject</td>
            <td align="center">Professor</td>            
        </tr>
        
         
      
             <c:forEach var="ratings" items="${students.ratings}">
                   <tr> 
                                <td>
                                    <c:out value="${ratings.getSubject()}" />
                                </td>
                                <td>
                                    <c:out value="${ratings.getProfessor_fName()}" /> <c:out value="${ratings.getProfessor_LName()}" />
                                </td>
                             
                    </tr>
             </c:forEach>
       
        
     </table>    
       
    </div>
 
 
        
        <div>
          <button onclick="viewTable()">View All professors</button> 
        </div>  
  
    <div class="row col-md-6 col-md-offset-2 custyle">
        <table class="table table-striped custab" id="proftable" style="display:none">
            <thead>
            
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Department</th>

                    <th class="text-center">Action</th>
                </tr>
            </thead>

            <tbody >
             <c:forEach var="professor" items="${students.professor}">
                    <tr>
                                <td><c:out value="${professor.getFirstName()}" /></td>
                                <td><c:out value="${professor.getLastName()}" /></td>
                                <td><c:out value="${professor.getDepartment()}" /></td>
                                <td class="text-center">
                                <a class='btn btn-info btn-xs' href="professor.htm?option=view&id=${professor.getId()}"><span class="glyphicon glyphicon-eye-open"></span> View </a>

                                &nbsp;
                                <a class='btn btn-info btn-xs' href="rating.htm?option=rate&id=${professor.getId()}"><span class="glyphicon glyphicon-star"></span> Rate </a>

                                </td>  
                    </tr>
             </c:forEach>
             </tbody>
        </table>
    </div>
        
  
  
</div>
        
        
        
</body>
    
    <script>
        
        function viewTable(){
            var table = document.getElementById("proftable");
             if (table.style.display === "none") {
                 table.style.display = "block";
            } else {
                table.style.display = "none";
               }
        }
        

    </script>
    
</html>
