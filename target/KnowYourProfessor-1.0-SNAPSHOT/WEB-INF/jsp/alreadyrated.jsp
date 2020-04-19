<%-- 
    Document   : alreadyrated
    Created on : Apr 18, 2020, 8:37:31 PM
    Author     : viraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
            <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
            <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
            <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        
        <nav class="navbar navbar-inverse">
               <div class="container-fluid">
                 <div class="navbar-header">
                   <a class="navbar-brand" href="#">WebSiteName</a>
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
        <h1>You have already rated for this subject</h1>
    </body>
</html>
