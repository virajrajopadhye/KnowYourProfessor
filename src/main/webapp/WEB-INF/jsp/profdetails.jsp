<%-- 
    Document   : profdetails
    Created on : Apr 12, 2020, 8:43:15 PM
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
       <!--                   <li> <input type="hidden" name="option" value="logout">
                               <input type="submit" value="Logout">
                          </li>-->

                        </ul>
                  </form>
               </div>
           </nav>
        
        <div class="container">
            
        <div class="row   custyle">
        <table class="table table-striped custab" id="proftable" >
            <thead>
            
                <tr>
                    <th>Name</th>
                    <th>Department</th>
                    <th>Subjects (Click to view Ratings)</th>
                    <th>Action</th>

                    
                </tr>
            </thead>

            <tbody >
             <c:forEach var="professor" items="${professors}">
                    <tr>        
                                <td><c:out value="${professor.getFirstName()}" /> <c:out value="${professor.getLastName()}"/></td>
                                
                                <td><c:out value="${professor.getDepartment()}" /></td>
                                <td> <c:forEach var="subjects" items="${professor.getSubjects()}">
                                         <a href="rating.htm?option=view&id=${subjects}"><c:out value="${subjects}"/><br></a>  
                                     </c:forEach>
                                </td>
                                <td class="text-center">
                                
                                    <a class='btn btn-info btn-xs' href="rating.htm?option=rate&id=${professor.getId()}"><span class="glyphicon glyphicon-star"></span> Rate </a>

                                </td>  
                    </tr>
             </c:forEach>
             </tbody>
        </table>
    </div>
   </div>     
        
        
        
        
          
            
           
               
    </body>
</html>
