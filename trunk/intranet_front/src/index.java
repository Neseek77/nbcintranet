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
public class index extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        IOTemplate io=new IOTemplate();
        HttpSession session = request.getSession();
        out.print("<head><script src='js/popupimage.js'></script>"
                + "<link rel='stylesheet' href='css/Style.css'>"
                + "<link rel='stylesheet' type='text/css' href='css/menustyle.css'/>"); 
        if(session.isNew()==true)
         //pop up Script
        out.print("<SCRIPT LANGUAGE='JavaScript'>window.open('PopupPage' ,'','toolbar=no,menubar=no,location=no,scrollbars=no,resizable=no,status=no,width=600,height=800,left=250,top=375'); window.focus();</SCRIPT>");
        session.setAttribute("popup",'1');
        session.setMaxInactiveInterval(86400);
        try {
            String str=request.getParameter("page");
                if (str==null)
                    str="Home.html";
        out.print("</head>");    
    out.print("<html>"
            + "<body><div id='wrapper'><div id='Space'><div id='header'>"
            + "<table>"
                + "<tr>"
                    + "<td class='frameTop' colspan='2'><img src='images/banner.jpg' id='banner'></td>"
                + "</tr>"
                    + "<td colspan='2' background='images/BlockHeader.png'align='center' id='Line'>");
    //Start TopMenu
    String strx=(String)session.getAttribute("User_ID");
    if(strx==null)
    out.print("Don't have account yet? <a href=index?page=Registration>Register</a> | <a href=index?page=Login>Log in</a>&nbsp;&nbsp;");
    else
    out.print("Hi,:"+strx+"<a href='Logout'> Sign Out     </a></td></tr>"); 
//End TopMenu
    
    out.println("<tr>"
                    + "<td class='frameLeft' valign='top'><img style='border-left:4px solid #FFFFFF;' src='images/menu_left_up.png' valign='top'>"
                    + "<script type='text/javascript' src='js/quickmenu.js'></script></td>"
                    + "<td class='frameRight' valign='top'>");
           ServletContext scr=this.getServletContext();
           RequestDispatcher re=scr.getRequestDispatcher("/"+ str);
           re.include(request,response); 
    out.println("</tr>"
                    + "<td class='frameButton' colspan='2'><image src='images/footer.gif'></td></tr>"
                    + "</table></center>"
                    + "</body></html>");
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
