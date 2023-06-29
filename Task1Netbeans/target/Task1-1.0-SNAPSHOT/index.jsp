<%-- 
    Document   : index
    Created on : 18-Jun-2023, 7:56:40 PM
    Author     : Ganesh
--%>

<%@page import="com.employee.helper.FactoryProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        
        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
         <div class="row mt-5">
                <div class="col-md-4 offset-md-4">
                    <div>
                         <a href="newemployee.jsp">Add New Employee</a>
                    </div>
                    <div>
                        <a href="fetchById.jsp">fetch Employee</a>
                    </div>
<!--                    <div>
                         <a href="updateEmployee.jsp">Update Employee</a>
                    </div>-->
                    <div>
                         <a href="deleteEmployee.jsp">Delete Employee</a>
                    </div>
            
                </div>
         </div>
    </body>
</html>
