<%-- 
    Document   : newemployee
    Created on : 18-Jun-2023, 9:46:54 PM
    Author     : Ganesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Employee</title>
        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
       
        <div>
            <div class="row mt-5">
                <div class="col-md-4 offset-md-4">
                    
                    <h3 class="text-center my-3">Enter Employee Details</h3>
                    <form action="NewEmployeeServlet" method="post">
                        <div class="form-group">
                          <label for="name" class="form-label">Name of Employee</label>
                          <input name="name" type="text" class="form-control" placeholder="Enter Here" id="name" aria-describedby="nameHelp" required="required">
                        </div>
                        
                        <div class="form-group">
                          <label for="Phone" class="form-label">Phone Number</label>
                          <input name="phone" type="number" class="form-control" placeholder="Enter Here" id="Phone" aria-describedby="phoneHelp" required="required">
                        </div>
                        <div class="form-group">
                          <label for="email" class="form-label">Email address</label>
                          <input name="email" type="email" class="form-control" placeholder="Enter Here" id="email" aria-describedby="emailHelp" required="required">
                        </div>
                        <div class="form-group">
                          <label for="address" class="form-label">Address</label>
                          <textarea name="address" style="height: 100px" class="form-control" placeholder="Enter Here" id="address" required="required"></textarea>
                        </div>
                        <div class="form-group">
                          <label for="department" class="form-label">Department</label>
                          <input name="department" type="text" class="form-control" placeholder="Enter Here" id="department" aria-describedby="departmentHelp" required="required">
                        </div>
                        <div class="form-group">
                          <label for="salary" class="form-label">Salary</label>
                          <input name="salary" type="number" class="form-control" placeholder="Enter Here" id="salary" aria-describedby="salaryHelp" required="required">
                        </div>
                        <br/>
                        <div class="form-group">
                          <label for="image" class="form-label">Upload Image</label>
                          <br/>
                          <input name="image" type="file" class="file-upload-input" id="image" onchange="readURL()" accept="Image/*" required="required">
                        </div>
                        <br/>
                        <div class="container text-center">
                            <button class="btn btn-outline-success">submit</button>
                           
                        </div>
                     </form>
<!--                    <button class="btn btn-outline-warning" onclick="index.jsp">Reset</button>-->
<a href="index.jsp">Back to Home</a>
                </div>
            </div>
        </div>
        
    </body>
</html>
