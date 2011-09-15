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
import java.lang.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public class AdminHome extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        IOTemplate io=new IOTemplate();
        HttpSession session = request.getSession();
        try {
            String str=request.getParameter("page");
            //out.println(str);
            if (str==null)
                str="AdminHome.html";
        out.print("<head> ");    
    out.print("<html>");
      out.println("<link rel='stylesheet' type='text/css' href='css/menustyle.css'/>");
            // out.println("<form name='index' action='Login' method='Post'>");
out.println("<table cellpadding='0' cellspacing='0' border='1' width='80%' align='center' style='background-image:url('menu/images/menuBg.gif');background-repeat:repeat'>");
    out.println("<tr>");
    out.println("<td class='frameTop' colspan='2'>");
    
    //Start TopMenu
    String strx=(String)session.getAttribute("User_admin");
    if(strx==null)
    out.print("Don't have account yet? <a href=index?page=Registration>Register</a></br><a href=index?page=Login>Log in</a>");
    else
    out.print("Hi,:"+ strx+"<a href=Logout> Sign Out</a>"); 
//End TopMenu
    
    out.println("</td></tr><tr>");
    out.println("<td class='frameLeft' valign='top'>");
    out.println("<img style='border-left:4px solid #FFFFFF;' src='images/menu_left_up.png' valign='top'>");
    out.println("<script type='text/javascript' src='js/quickmenu.js'></script>");
    out.println("</td>"); 
    out.println("<td class='frameRight' valign='top'>");
     ServletContext scr=this.getServletContext();
           RequestDispatcher re=scr.getRequestDispatcher("/"+ str);
           re.include(request,response); 
    out.println("</tr>");
    out.println("<td class='frameButton' colspan='2'>button"); 
    out.println("</td>");
    out.println("</tr>");
    out.println("</table>");
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
