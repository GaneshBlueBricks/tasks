<%-- 
    Document   : fetchById
    Created on : 19-Jun-2023, 12:05:52 PM
    Author     : Ganesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>fetch BY Id</title>
         <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
         <div>
            <div class="row mt-5">
                <div class="col-md-4 offset-md-4">
                    
                    <h3 class="text-center my-3">Fetch Employee Details By Id</h3>
                    <form action="fetchServlet" method="get">
                        <div class="form-group">
                          <label for="id" class="form-label">Id of Employee</label>
                          <input name="id" type="number" class="form-control" placeholder="Enter Here" id="id" required="required">
                        </div>
                         <div class="container text-center">
                            <button class="btn btn-outline-success">submit</button>
                           
                        </div>
                    </form>
                </div>
            </div>
         </div>
        <div>
            <div class="row mt-5">
                <div class="col-md-4 offset-md-4">
                    
                    <h3 class="text-center my-3">Fetch Employee Details By Email</h3>
                    <form action="fetchServlet" method="get">
                        <div class="form-group">
                          <label for="email" class="form-label">Email of Employee</label>
                          <input name="email" type="email" class="form-control" placeholder="Enter Here" id="email" required="required">
                        </div>
                         <div class="container text-center">
                            <button class="btn btn-outline-success">submit</button>
                           
                        </div>
                    </form>
                </div>
            </div>
         </div>
        
                        
    </body>
</html>
