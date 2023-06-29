/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.servlet;

import com.employee.pojos.Employee;
import com.employee.pojos.EmployeeInfo;
import com.employee.tester.ConverterClass;
import com.employee.utils.EmployeeUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import sun.nio.cs.StandardCharsets;

/**
 *
 * @author Ganesh
 */

public class NewEmployeeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
                String name=request.getParameter("name");
                String email= request.getParameter("email");
                String phone= request.getParameter("phone");
                String address= request.getParameter("address");
                double salary= Double.valueOf(request.getParameter("salary"));
                String department= request.getParameter("department");
                byte[] image= request.getParameter("image").getBytes();
                
                  
                EmployeeInfo employeeInfo= new EmployeeInfo(name, phone, email, address, image);
                Employee employee= new Employee(ConverterClass.convertToBlob(employeeInfo), department, salary);
                int id=EmployeeUtil.addEmployeee(employee);
                if(id==-1){
                    out.println("Employee With gmail :<b>"+email+"</b> Already Present");
                }else
                out.println("Successfully Added Employee With id :"+id);
                out.println("<br/><a href=\"index.jsp\">return To Home</a> ");
                
        }catch(Exception e){
           e.printStackTrace();
        }
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        Employee employee=null;
//        if(request.getParameter("id")!=null)
//            employee=fetchEmployeeById(request, response);
//        else
//            fetchEmployeeByEmail(request,response);
//        
//                // Set the response data as an attribute in the request scope
//       // request.setAttribute("responseData", employee);
//
//        String redirectUrl = "your-view.jsp?id=21&responseData=" + URLEncoder.encode(employee);
//
//    // Redirect the request to the JSP page
//    response.sendRedirect(redirectUrl);
//        // Forward the request to the JSP page
//        RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
//        dispatcher.forward(request, response);
//    }
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
       
     processRequest(request, response);
   
    
}

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    

}
