/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class AdminPostAnnouncement extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Post Announcement</title>");  
            out.print("<script language='javascript' src='js/MultiAction.js'></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form name='PostAnnouncement' enctype='multipart/form-data' method='post'>");
            out.print("<table align='center'>");
            out.println("<tr><td>Source File:<td><input type='file' name='file' id='file'><br/>");
            
            out.println("<tr><td>Title:<td><input type='text' name='title' id='title'><br/>");
            
            out.println("<tr><td>Description:<td><TextArea type='text' name='desc' id='desc' row=100 col=300></TextArea><br/>");
            out.println("<input type='submit' name='submit' value='Submit' onclick='submitMe();'>");
            String str=request.getParameter("message");
                if(str!=null)
            out.println("<tr><td colspan='2'>"+str+"</td></tr>");
            out.print("<table>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            
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
