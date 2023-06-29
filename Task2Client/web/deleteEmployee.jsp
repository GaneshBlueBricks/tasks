<%-- 
    Document   : deleteEmployee
    Created on : 27 Jun, 2023, 10:34:40 AM
    Author     : Ganesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
        <div>
            <div class="row mt-5">
<!--                <div class="col-md-4 offset-md-4">
                    
                    <h3 class="text-center my-3">Delete Employee Details By Id</h3>
                    <form action="http://localhost:8080/Task2/webresources/ControllerClass/fetchEmployee" method="get">
                        <div class="form-group">
                          <label for="id" class="form-label">Id of Employee</label>
                          <input name="id" type="number" class="form-control" placeholder="Enter Here" id="id" required="required">
                        </div>
                         <div class="container text-center">
                            <button class="btn btn-outline-success">submit</button>
                           
                        </div>
                    </form>
                </div>-->
            </div>
         </div>
        <div>
            <div class="row mt-5">
                <div class="col-md-4 offset-md-4">
                    
                    <h3 class="text-center my-3">Delete Employee Details By Email</h3>
                    <form id="deleteForm">
                        <div class="form-group">
                          <label for="email" class="form-label">Email of Employee</label>
                          <input name="email" type="email" class="form-control" placeholder="Enter Here" id="email" required="required">
                        </div>
                        <div class="container text-center">
                          <button class="btn btn-outline-success" type="button" onclick="deleteEmployee()">Submit</button>
                        </div>
                      </form>
                </div>
            </div>
            <div id="deleteMessage" class="mt-3 text-center"></div> <!-- New element for displaying the message --></div>
         </div>
       
       
    </body>
    <script>
  function deleteEmployee() {
    const email = document.getElementById('email').value;

    fetch('http://localhost:8080/Task2/webresources/ControllerClass/deleteEmployee?email=' + encodeURIComponent(email), {
      method: 'DELETE'
    })
      .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.text(); // Get the response text
            })
            .then(data => {
                // Handle the response text
                document.getElementById('deleteMessage').innerHTML = data;
            })
            .catch(error => {
                console.error('Error:', error);
                // Handle errors here
                document.getElementById('deleteMessage').innerHTML = 'Error deleting employee';
            });
  }
</script>
</html>
