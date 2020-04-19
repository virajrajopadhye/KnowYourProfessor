<%-- 
    Document   : selectProfForRating
    Created on : Apr 15, 2020, 3:25:59 PM
    Author     : viraj
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    
    <style>
        textarea {
            resize: none;
            
        }
        
        body{
		background-color: whitesmoke;
	}
	.contact{
		padding: 4%;
		height: 400px;
	}
	.col-md-3{
		background: #17a2b8;
		padding: 4%;
		border-top-left-radius: 0.5rem;
		border-bottom-left-radius: 0.5rem;
	}
	.contact-info{
		margin-top:10%;
	}
	.contact-info img{
		margin-bottom: 15%;
	}
	.contact-info h2{
		margin-bottom: 10%;
	}
	.col-md-9{
		background: #fff;
		padding: 3%;
		border-top-right-radius: 0.5rem;
		border-bottom-right-radius: 0.5rem;
	}
	.contact-form label{
		font-weight:600;
	}
	.contact-form button{
		background: #25274d;
		color: #fff;
		font-weight: 600;
		width: 25%;
	}
	.contact-form button:focus{
		box-shadow:none;
	}
        
        .slider {
            -webkit-appearance: none;
            width: 50%;
            height: 10px;
            background: #d3d3d3;
            outline: none;
            opacity: 0.7;
            -webkit-transition: .2s;
            transition: opacity .2s;
}

.slider:hover {
  opacity: 1;
}

.slider::-webkit-slider-thumb {
  -webkit-appearance: none;
  appearance: none;
  width: 25px;
  height: 25px;
  background: #17a2b8;
  cursor: pointer;
}

.slider::-moz-range-thumb {
  width: 25px;
  height: 25px;
  background: #4CAF50;
  cursor: pointer;
}
        
        
    </style>
    <body>
        
        <div class="container contact">
	<div class="row">
		<div class="col-md-3">
			<div class="contact-info">
				<img src="https://image.ibb.co/kUASdV/contact-image.png" alt="image"/>
				<h2>Do's</h2>
				<h5>Double check your comments before posting. Course codes must be accurate, and it doesn’t hurt to check grammar. !</h5>
			</div>
                    
                        <div class="contact-info">
				
				<h2>Dont's</h2>
				<h5>Use profanity, name-calling, or derogatory terms. And, don’t claim that the professor shows bias or favoritism for or against students.</h5>
			</div>
		</div>
		<div class="col-md-9">
                    
                    <form action="rating.htm" name="my-form" onsubmit="return validform2()" method="POST">
                        
                             
			<div class="contact-form">
                            
                            
                             <c:forEach var="professor" items="${professors}">
                                     <input type="hidden" name="professorid" value="${professor.getId()}">
                                     <input type="hidden" name="professorfname" value="${professor.getFirstName()}">
                                     <input type="hidden" name="professorlname" value="${professor.getLastName()}">
                              </c:forEach>
            
                             <c:forEach var="student" items="${students.student}">
                                  <input type="hidden" name="studentId" value="${student.getId()}">
                              </c:forEach>
                                  
                                  
				<div class="form-group">
				  <label class="control-label col-sm-5" for="fname">Select overall Rating:</label>
				  <div class="col-sm-10">          
					<span id="textInput" name="overall_rating" value=""></span><input type="range" name="rangeInputrating" min="1" max="5" value="2" class="slider" onchange="updateTextInput(this.value);">
                                        <span id="textInput" name="overall_rating" value=""></span> <span id="stringInput" ></span>
				  </div>
				</div>
				<div class="form-group">
				  <label class="control-label col-sm-5" for="lname">Select subject:</label>
				  <div class="col-sm-10">          
					<select name="subject" >
                                            <c:forEach var="professor" items="${professors}">
                                                <c:forEach var="subjects" items="${professor.getSubjects()}">
                                                    <option value="${subjects}" >${subjects}</option>
                                                </c:forEach>
                                          </c:forEach>                        
                                        </select> 
				  </div>
				</div>
				<div class="form-group">
				  <label class="control-label col-sm-5" for="email">Select difficulty:</label>
				  <div class="col-sm-10">
					<span id="difficultyinput" name="difficulty" value=""></span><input type="range" class="slider" name="rangeInputdifficulty" min="1" max="5" value="2" onchange="updatedifficultyInput(this.value);">
                                        <span id="difficultyinput" name="difficulty" value=""></span> <span id="difficultystringInput" ></span>
				  </div>
				</div>
                            
                                <div class="form-group">
				  <label class="control-label col-sm-12" for="email"> Would you recommend this professor?</label>
				  <div class="col-sm-10">
					<input type="radio" id="yes" name="recommend" value="1" checked>
                                        <label for="yes">oh! yes</label>
                                        <input type="radio" id="no" name="recommend" value="0">
                                        <label for="no">umm no</label><br>
				  </div>
				</div>
                            
                            
                                <div class="form-group">
				  <label class="control-label col-sm-5" for="email">Attendance?</label>
				  <div class="col-sm-10">
					 
                                        <input type="radio" id="yes" name="attendance" value="1" checked>
                                        <label for="yes">Mandatory</label>
                                        <input type="radio" id="no" name="attendance" value="0">
                                        <label for="no">Not-Mandatory</label>
				  </div>
				</div>
                            
                                <div class="form-group">
                                      <label class="control-label col-sm-5" for="email">Industry oriented?</label>
                                      <div class="col-sm-10">
                                        <input type="radio" id="yes" name="indusry" value="1" checked>
                                        <label for="yes">Yes</label>
                                        <input type="radio" id="no" name="indusry" value="0">
                                        <label for="no">No</label>
                                      </div>
                                 </div>
                            
                            
				<div class="form-group">
				  <label class="control-label col-sm-5" for="comment">Describe your feelings:</label>
				  <div class="col-sm-10">
					<textarea class="form-control" name="comment" rows="5" id="comment"></textarea>
				  </div>
				</div>
				<div class="form-group">        
				  <div class="col-sm-offset-2 col-sm-10">
					<input type="hidden" value="rateProf" name="option" /> 
                                        <input type="submit" name="Submit" class="btn btn-primary" value="Submit"/>
				  </div>
				</div>
			</div>
                    </form> 
		</div>
	</div>
</div>

 
        
    </body>
    <script>
        
        function updateTextInput(val) {
          document.getElementById('textInput').textContent=val; 
          if(val==1)
              document.getElementById('stringInput').textContent="nahhh!";
          else if(val==2)
               document.getElementById('stringInput').textContent="ummm....!";
          else if(val==3)
               document.getElementById('stringInput').textContent="i dont know yet!";
          else if(val==4)
               document.getElementById('stringInput').textContent="most probably!";
          else
              document.getElementById('stringInput').textContent="hell yeah!";
    }
    
    
       function updatedifficultyInput(val) {
          document.getElementById('difficultyinput').textContent=val; 
          if(val==1)
              document.getElementById('difficultystringInput').textContent="easy peasy!";
          else if(val==2)
               document.getElementById('difficultystringInput').textContent="Easy A";
          else if(val==3)
               document.getElementById('difficultystringInput').textContent="the usual!";
          else if(val==4)
               document.getElementById('difficultystringInput').textContent="Need slogging!";
          else
              document.getElementById('difficultystringInput').textContent="Hardest thing i have ever seen!";
    }
    
   
        
    </script>
    
      <script>
   function validform2() {

        var a = document.forms["my-form"]["comment"].value;
        
        
        if (a==null || a=="")
        {
            alert("Please write a few lines/words about professor.");
            return false;
        }

    }
</script>
</html>
