<%-- 
    Document   : register
    Created on : Mar 26, 2020, 4:05:19 PM
    Author     : viraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Fonts -->
    <link rel="dns-prefetch" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">



    <link rel="icon" href="Favicon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    </head>
    
    <body>
    <main class="my-form">
    <div class="cotainer">
        <div class="row justify-content-center">
            <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">Register</div>
                        <div class="card-body">
                            <form name="my-form" onsubmit="return validform()" action="student.htm" method="post">
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">First Name</label>
                                    <div class="col-md-6">
                                        <input type="text" id="firstName" class="form-control" name="firstName">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="full_name" class="col-md-4 col-form-label text-md-right">Last Name</label>
                                    <div class="col-md-6">
                                        <input type="text" id="lastName" class="form-control" name="lastName">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="email_address" class="col-md-4 col-form-label text-md-right">E-Mail Address</label>
                                    <div class="col-md-6">
                                        <input type="text" id="email" class="form-control" name="email">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="user_name" class="col-md-4 col-form-label text-md-right">User Name</label>
                                    <div class="col-md-6">
                                        <input type="text" id="username" class="form-control" name="username">
                                    </div>
                                </div>

                                 <div class="form-group row">
                                    <label for="user_name" class="col-md-4 col-form-label text-md-right">Password</label>
                                    <div class="col-md-6">
                                        <input type="password" id="password" class="form-control" name="password">
                                    </div>
                                </div>
                            

                               

                                    <div class="col-md-6 offset-md-4">
                                         <input type="hidden" value="addStudent" name="option" />
                                         <input type="submit" name="Submit" value="Register" class="btn btn-primary">
                                        
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
    
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script>
   function validform() {

        var a = document.forms["my-form"]["firstName"].value;
        var b = document.forms["my-form"]["lastName"].value;
        var c = document.forms["my-form"]["email"].value;
        var d = document.forms["my-form"]["username"].value;
        var e = document.forms["my-form"]["password"].value;
        var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        
        if (a==null || a=="")
        {
            alert("Please Enter Your First Name");
            return false;
        }else if (b==null || b=="")
        {
            alert("Please Enter Your Last Name");
            return false;
        }else if (c==null || c=="")
        {
            alert("Please Enter Your Email address");
            return false;
        }else if (d==null || d=="")
        {
            alert("Please Enter Your username");
            return false;
        }else if (e==null || e=="")
        {
            alert("Please Enter a password");
            return false;
        }
            else if(!c.match(mailformat)){
            alert("Invalid Email");
            return false;
        } 

    }
</script>    
 </body>   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
<!--    <body>
         <form action="student.htm" method="POST">
            First Name: <input type="text" name="firstName"/><br>
            Last Name: <input type="text" name="lastName"/><br>
            Email id: <input type="email" name="email"/><br>
            Username: <input type="text" name="username"/><br>
            Password: <input type="text" name="password"/><br>
                <input type="hidden" value="addStudent" name="option" /> 
                <input type="submit" name="Submit" value="Add"/><br>
        </form>
    </body>-->
</html>
