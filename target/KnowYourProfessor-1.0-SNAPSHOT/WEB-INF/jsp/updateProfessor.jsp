<%-- 
    Document   : updateProfessor
    Created on : Apr 17, 2020, 4:38:31 PM
    Author     : viraj
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="dns-prefetch" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">
    <link rel="icon" href="Favicon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    </head>
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
              <a class="nav-link" href="index.htm?option=adminhome">Home</a>
            </li>
     
          </ul>
          
        </nav>
        
        <main class="my-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">Update Professor</div>
                        <div class="card-body">
                            <form name="my-form" onsubmit="return validform()" action="index.htm" method="post">
                                
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Professor ID</label>
                                    <div class="col-md-6">
                                         <input type="text" id="id" class="form-control" name="id" value="${professor.getId()}" readonly/>
                                    </div>
                                </div>
                                    
                                    
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Current courses</label>
                                    <div class="col-md-6">
                                        <select name="currentcourses" class="form-control" readonly >
                                            <c:forEach var="subject" items="${professor.getSubjects()}">
                                                  <option value="${subject}">${subject}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                    
                                    
                                    
                                
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Select Department</label>
                                    <div class="col-md-6">
                                        <select name="department" class="form-control" >
                                            <c:forEach var="department" items="${departments1}">
                                                  <option value="${department.getDepartmentName()}">${department.getDepartmentName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                
                                
                                
                                
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">First Name</label>
                                    <div class="col-md-6">
                                         <input type="text" id="firstName" class="form-control" name="firstName" value="${professor.getFirstName()}"/>
                                    </div>
                                </div>

                                 <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Last Name</label>
                                    <div class="col-md-6">
                                         <input type="text" id="lastName" class="form-control" name="lastName" value="${professor.getLastName()}"/>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="user_name" class="col-md-4 col-form-label text-md-right">Email</label>
                                    <div class="col-md-6">
                                        <input type="text" id="email" class="form-control" name="email" value="${professor.getEmail()}"/>
                                    </div>
                                </div>

                                 <div class="form-group row">
                                    <label for="user_name" class="col-md-4 col-form-label text-md-right">Select Course/Courses</label>
                                    <div class="col-md-6">
                                        <select name="courses" id="courses" class="form-control" multiple >
                                            <c:forEach var="course" items="${courseList}">

                                                <option value="${course}">${course}</option>

                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">ImagePath</label>
                                    <div class="col-md-6">
                                         <input type="text" id="imagepath" class="form-control" name="imagepath" value="${professor.getImagepath()}"/>
                                    </div>
                                </div>
                            

                               

                                    <div class="col-md-6 offset-md-4">
                                         <input type="hidden" value="updateProfessor" name="option" />
                                         <input type="submit" name="Submit" value="Update Professor" class="btn btn-primary">
                                        
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
            </div>
        </div>
    </div>

</main>

        
</body>
    
        <script>
   function validform() {

        var a = document.forms["my-form"]["firstName"].value;
        var b = document.forms["my-form"]["lastName"].value;
        var c = document.forms["my-form"]["email"].value;
        var d = document.forms["my-form"]["courses"].value;
        var e = document.forms["my-form"]["imagepath"].value;
        var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        
        if (a==null || a=="")
        {
            alert("Please Enter Professor's First Name");
            return false;
        }else if (b==null || b=="")
        {
            alert("Please Enter Professor's Last Name");
            return false;
        }else if (c==null || c=="")
        {
            alert("Please Enter Professor's Email address");
            return false;
        }else if (d==null || d=="")
        {
            alert("Please Select Courses");
            return false;
        }else if (e==null || e=="")
        {
            alert("Please Enter an imagepath");
            return false;
        }
            else if(!c.match(mailformat)){
            alert("Invalid Email");
            return false;
        } 

    }
</script>
</html>
