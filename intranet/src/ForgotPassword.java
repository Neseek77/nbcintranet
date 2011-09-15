/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DA
 */
public class ForgotPassword extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
//Start interface
            out.print("<form name='ForgotPassword' action='ForgotPassword' method='get'>");
            out.print("</br></br></br></br></br></br><table align=center>");
            out.print("<tr><td>Enter Your NBC Email:</td><td><input type='text' name='email' id='email'><input type='submit' value='Submit'>");
//End Interface   
//Database
            String email=request.getParameter("email");
            ExecuteNonQ ex=new ExecuteNonQ();
           // out.print(email);
            ResultSet rs=ex.SelectQueryByFieldWithCondition("USER_ID,Password","USER_ACCOUNTS","NBC_Email",email);
            try{
            while(rs.next()){
            String id=rs.getString("USER_ID");
            String pwd=rs.getString("Password");
            out.print(id+pwd);     
            response.sendRedirect("index?page=SendForgotPassword?email='"+email+"'&uid="+id+"&pwd="+pwd+"");
            }
            }catch(Exception e){e.getLocalizedMessage();
            }
//End Database
             
        out.print("</form>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
