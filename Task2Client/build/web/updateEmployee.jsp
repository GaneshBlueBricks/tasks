<%-- 
    Document   : updateEmployee
    Created on : 27 Jun, 2023, 11:10:54 AM
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
       
        <form id="formdata" >
                        <div class="form-group">
                          <label for="name" class="form-label">Name of Employee</label>
                          <input name="name" type="text" class="form-control" placeholder="Enter Here" id="name" aria-describedby="nameHelp" required="required">
                        </div>
                        
                        <div class="form-group">
                          <label for="email" class="form-label">Email of Employee</label>
                          <input name="email" type="email" class="form-control" placeholder="Enter Here" id="email" required="required">
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
                       
                        <br/>
                        <div class="container text-center">
                            <button type="submit" class="btn btn-outline-success">Update</button>
                           
                        </div>
                     </form>
         <div id="Message" class="mt-3 text-center"></div> <!-- New element for displaying the message --></div>
         </div>
       
<!--        <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
        <script src="">-->
        <script>
            
           const form = document.getElementById('formdata');
           const resultDiv = document.getElementById('resultfromback');
            form.addEventListener('submit', function (event) {
              event.preventDefault();
              const email = document.getElementById('email').value;
              // 1: get form data
              const formData = new FormData(form);
              // 2: store form data in object
              const jsonObject = Object.fromEntries(formData);
              // 3: convert form data object to a JSON string
              const jsonString = JSON.stringify(jsonObject);

              console.log(jsonString); // '{"name":"John","email":"john@example.com","age":"30"}'
              
               fetch('http://localhost:8080/Task2/webresources/ControllerClass/updateEmployee?email=' + encodeURIComponent(email), {
                method: 'PUT',
                headers: {
                  'Content-Type': 'application/json'
                },
                body: jsonString
              })
             .then(response => {
                if (!response.ok) {
                            throw new Error('Network response was not ok');
                        }
                        return response.text(); // Get the response text
                    })
//                    .then(data => {
//                        // Handle the response text
//                        ;
//                    })
//                    .catch(error => {
//                        console.error('Error:', error);
//                        // Handle errors here
//                        document.getElementById('Message').innerHTML = 'Error creating employee';
//                    });
             
             
});
        </script>
    </body>
</html>
