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

/**
 *
 * @author DA
 */
public class AdminPostNewsEvent extends HttpServlet {

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
            out.println("<html>");
            out.println("<head>");
            out.print("<script language='javascript' src='js/MultiAction.js'></script>");
            out.println("<title>Post News & Event</title>");  
            out.println("</head>");
            out.println("<body>");
            out.print("<form name='AdminPostNewsEvent' method='post' enctype='multipart/form-data'>");
            out.println("<table align='center'>");
            out.print("<tr><td colspan='2'><h2>Post News and Event</h2></td></tr>");
            out.print("<tr><td colspan='2'><input type='file' name='filename_1' id='filename_1'></td></tr>");
            out.print("<tr><td colspan='2'><input type='file' name='filename_2' id='filename_2'></td></tr>");
            out.print("<tr><td>*Title:</td><td><input type='text' id='title'></td></tr>");
            out.print("<tr><td>Short Description:</td><td><TEXTAREA id='desc' name='desc' col=100 row=200></TextArea></td></tr>");
            out.append("<tr><td align='right' colspan='2'><input type='submit' name='submit' value='PostNow' onclick='MultiUpload();'>");
                       String str=request.getParameter("message");
                if(str!=null)
            out.println("<tr><td colspan='2'>"+str+"</td></tr>");
            out.print("</table>");
            out.append("</form>");
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
