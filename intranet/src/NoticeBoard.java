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
public class NoticeBoard extends HttpServlet {

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
        ExecuteNonQ ex=new  ExecuteNonQ();
        ResultSet rs=ex.SelectQueryByField("Announcement","Ann_ID,Ann_DESC,FILE_Name,DATE_POST");
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Notice Board</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Click on Notice Board</h1>");
            out.print("<table align='center'>");
            out.print("<tr><td colspan='6'><a href='PostAnnouncement'><input type='submit' value='Post Announcement'></td></tr>");
            try{
                while(rs.next())
                 out.print("<tr><td>"+rs.getString("Ann_ID")+"</td><td>"+rs.getString("Ann_DESC")+"</td><td>"+rs.getString("File_Name")+"</td><td>"+rs.getString("DATE_POST"));
           }catch(Exception e){e.getLocalizedMessage();
                         }     
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
