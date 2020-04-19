<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Fonts -->
    <link rel="dns-prefetch" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">
    <link rel="icon" href="Favicon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <!-- Bootstrap CSS -->
   
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
 
    <br>
    
     <div class="d-flex justify-content-center">
          <button onclick="viewTable()">View All professors</button> 
        </div> 
    <br>
    <div class="d-flex justify-content-center">  

    <div class="row">
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
             <c:forEach var="professor" items="${professors}">
                    <tr>
                                <td><c:out value="${professor.getFirstName()}" /></td>
                                <td><c:out value="${professor.getLastName()}" /></td>
                                <td><c:out value="${professor.getDepartment()}" /></td>
                                <td class="text-center">
                                <a class='btn btn-info btn-xs' href="index.htm?option=update&id=${professor.getId()}"><span class="glyphicon glyphicon-eye-open"></span> Update </a>

                                &nbsp;
                                <a class='btn btn-info btn-xs' href="index.htm?option=delete&id=${professor.getId()}"><span class="glyphicon glyphicon-star"></span> Delete </a>

                                </td>  
                    </tr>
             </c:forEach>
             </tbody>
        </table>
    </div>
    </div>       
        
    
    
    
    
    
    
    
  <main class="my-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">Add Professor</div>
                        <div class="card-body">
                            <form name="my-form" onsubmit="return validform()" action="index.htm" method="post">
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Select Department</label>
                                    <div class="col-md-6">
                                        <select name="department" class="form-control" >
                                            <c:forEach var="department" items="${departments}">
                                                  <option value="${department.getDepartmentName()}">${department.getDepartmentName()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">First Name</label>
                                    <div class="col-md-6">
                                         <input type="text" id="firstName" class="form-control" name="firstName"/>
                                    </div>
                                </div>

                                 <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Last Name</label>
                                    <div class="col-md-6">
                                         <input type="text" id="lastName" class="form-control" name="lastName"/>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="user_name" class="col-md-4 col-form-label text-md-right">Email</label>
                                    <div class="col-md-6">
                                        <input type="text" id="email" class="form-control" name="email">
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
                                         <input type="text" id="imagepath" class="form-control" name="imagepath"/>
                                    </div>
                                </div>
                            

                               

                                    <div class="col-md-6 offset-md-4">
                                         <input type="hidden" value="addProfessor" name="option" />
                                         <input type="submit" name="Submit" value="AddProfessor" class="btn btn-primary">
                                        
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
    
    
    <main class="my-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">Add Department </div>
                        <div class="card-body">
                            <form name="my-form2" onsubmit="return validform2()" action="index.htm" method="post">
                                
                                
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Department</label>
                                    <div class="col-md-6">
                                         <input type="text" id="department" class="form-control" name="department"/>
                                    </div>
                                </div>
                            

                               

                                    <div class="col-md-6 offset-md-4">
                                         <input type="hidden" value="addDept" name="option" />
                                         <input type="submit" name="Submit" value="AddDepartment" class="btn btn-primary">
                                        
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
        
        function viewTable(){
            var table = document.getElementById("proftable");
             if (table.style.display === "none") {
                 table.style.display = "block";
            } else {
                table.style.display = "none";
               }
        }
        

    </script>
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
    
    <script>
   function validform2() {

        var a = document.forms["my-form2"]["department"].value;
        
        
        if (a==null || a=="")
        {
            alert("Please Department");
            return false;
        }

    }
</script>
    
    
    
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    
    
</html>
