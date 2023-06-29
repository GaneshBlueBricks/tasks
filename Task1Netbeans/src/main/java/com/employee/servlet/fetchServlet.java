/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.servlet;

import com.employee.pojos.Employee;
import com.employee.utils.EmployeeUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ganesh
 */
public class fetchServlet extends HttpServlet {

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
          Employee employee;
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            if(request.getParameter("id")==null){
                  String email=request.getParameter("email");
                    employee=EmployeeUtil.getEmployeeByEmail(email);
                  
              }else{
                  int id=Integer.valueOf(request.getParameter("id"));
                   System.out.println("Id "+id);
              employee=EmployeeUtil.getEmployeeById(id);
              System.out.print(employee);
              }
            
            if(employee==null){
                
                  response.sendRedirect("notFound.jsp");
            }else{                
               HttpSession httpsession=request.getSession();
                 httpsession.setAttribute("employee", employee);
//                 String base64Image = Base64.getEncoder().encodeToString(employee.getEmployeeInfo().getImage());
//                httpsession.setAttribute("base64Image", base64Image);

                response.sendRedirect("update.jsp");
            }
            
        }
    }
//    private void fetchEmployeeById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         response.setContentType("text/html;charset=UTF-8");
//          Employee employee;
//          try ( PrintWriter out = response.getWriter()) {
//              
//              int id=Integer.valueOf(request.getParameter("id"));
//             
//              employee=EmployeeUtil.getEmployeeById(id);
//              if(employee!=null){                   
//                    HttpSession httpsession=request.getSession();
//                    httpsession.setAttribute("employee", employee);
//                    response.sendRedirect("update.jsp");
//              }
//              else{
//                   
//                  return;
//                
//              }
//                  
//          }
//         
//    }
//      private void fetchEmployeeByEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         response.setContentType("text/html;charset=UTF-8");
//         Employee employee;
//          try ( PrintWriter out = response.getWriter()) {
//              String email=request.getParameter("email");
//              employee=EmployeeUtil.getEmployeeByEmail(email);
//               if(employee!=null){                   
//                    HttpSession httpsession=request.getSession();
//                    httpsession.setAttribute("employee", employee);
//                    response.sendRedirect("update.jsp");
//              }
//               else{
//                   out.println("<h3>Employee Not Found</h3>");
//                  out.println("<br/><a href=\"index.jsp\">return To Home</a> ");
//               }
//                  
//          }
//             
//        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
