<%-- 
    Document   : viewrating
    Created on : Apr 16, 2020, 5:17:54 PM
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
              <link rel="dns-prefetch" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">
    <link rel="icon" href="Favicon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        

    </head>
    <style>
        img {
    display: block;
    max-width:500px;
    max-height:500px;
    width: auto;
    height: auto;
}

.image-circle {
    display: block;
    max-width:80px;
    max-height:80px;
    width: auto;
    height: auto;
    padding:0px 15px 15px 15px;
    
}

.checked {
  color: orange;
}

.heading {
  font-size: 25px;
  margin-right: 25px;
}

.fa {
  font-size: 25px;
}
    </style>
    
    
    <body>
        
<nav class="navbar navbar-expand-sm   navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
          <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item">
              <a class="nav-link" href="login.htm?option=logout">Logout <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="login.htm?option=home">Home</a>
            </li>
     
          </ul>
          
</nav>
 
<c:forEach var="parameter" items="${ratings.parameters}">

<div class="container">
    
    
    
  <div>
      <div class="row d-flex justify-content-center"><img width="800" height="800" src="${parameter.getProfImage()}"><br></div><br>
      <div class="row d-flex justify-content-center"><h2> Prof <c:out value="${parameter.getProfFName()}" /> <c:out value="${parameter.getProfLName()}" /></h2></div>
      <hr>
        <div class="row d-flex justify-content-center">
            <c:set var="totalrating" value="${parameter.getOverall_rating()}"/>
              <span class="heading">Overall Rating
                <%
                double totalRatings = (double)pageContext.getAttribute("totalrating"); 
                for ( int i = 1; i <= totalRatings; i++){ %>
                   <span class="fa fa-star checked"></span>
                <%}%>
                </span>         
      </div>
    <div class="row d-flex justify-content-center">
        <p> ${parameter.getOverall_rating()} average based on ${parameter.getTotalratings()} reviews.</p>
    </div>            
  </div>
  <br>
  
  <!--Difficulty......................................................................................................-->
    <div>
     
        <div class="row d-flex justify-content-center">
            <c:set var="totalrating" value="${parameter.getDifficulty()}"/>
              <span class="heading">Difficulty
                <%
                double difficulty = (double)pageContext.getAttribute("totalrating"); 
                for ( int i = 1; i <= difficulty; i++){ %>
                   <span class="fa fa-star checked"></span>
                <%}%>
                </span>         
      </div>
    <div class="row d-flex justify-content-center">
                          <p> ${parameter.getDifficulty()} average based on ${parameter.getTotalratings()} reviews.</p>
    </div>            
  </div>
  
  
  
      
      
<br>
  
  <div class="card text-center bg-info text-white">
      <div> 
            <div class="card-body"><c:out value="${parameter.getRecommend_percent()}"/>% people recommend this professor.</div>
    </div> 
  </div>
  <br>
  <div class="card bg-secondary text-white text-center">
    <div class="card-body"><c:out value="${parameter.getRecommend_percent()}"/>% people think this course helped them in industry.</div>
  </div>
  <br>
  <div class="card bg-dark text-white text-center">
    <div class="card-body"><c:out value="${parameter.getAttendance()}"/>% people say that the attendance is compulsory.</div>
  </div>
  <br>
  <div class="card bg-light text-dark">
    <div class="card-body"><div class="row bootstrap snippets">

                <div>
                    <div class="comment-wrapper">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                Comment panel
                            </div>
                            <div class="panel-body">

                                <hr>
                                <ul class="media-list">
                                     <c:forEach var="parameter" items="${ratings.overall_rating}" varStatus="count">
                                        <li class="media">
                                            <a href="#" class="pull-left">
                                                <img class="image-circle" src="https://cdn2.iconfinder.com/data/icons/rcons-user/32/male-shadow-circle-128.png" alt="">
                                            </a>
                                            <div class="media-body">
                                                <span class="text-muted pull-right">

                                                </span>
                                                <strong class="text-success">@Anonymous</strong>
                                                <p>
                                                   - <c:out value="${parameter.getComment()}" />
                                                </p>
                                            </div>
                                        </li>
                                        <hr>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>

                </div>
            </div></div>
  </div>
  

  
 </c:forEach>
                 

               
          
        </div>
        
        
        
        
        
        
        
        
       
               
                 
                 
                 
    </body>
</html>
