
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Registration extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         ExecuteNonQ ex=new ExecuteNonQ();
         String Table1="Departments";
         String Field="Department_Name";
         String Message= request.getParameter("Message");
         String Password=request.getParameter("Pwd");
            try {
                ResultSet rs=ex.SelectQueryByField(Table1,Field);
                out.print("<script language='javascript' src='js/Message.js'></script>");
                out.print("<link href='css/Style.css' rel='stylesheet' type='text/css'>");
                out.print("<table align=center>");
                out.println("<form name='Registration' method='POST'");
                out.print("<tr><td colspan='3' align='right' class='Titlesbar'>It is free to sign up with NBC Intranet!</td></tr>");
                out.print("<tr><td></br></br></td></tr>");        
                out.print("<tr></br><td></td>");
                out.print("<td class='FirstLastName'>First Name:</td>");
                out.print("<td class='FirstLastName'>Last Name:</td></tr>");
                out.print("<tr><td class='Label'>Your Name:</td>");
                out.print("<td><input class='NameField' name='FirstName' type='text' /></td>");
                out.print("<td align='left' class='style2'>");
                out.print("<input class='NameField' name='LastName' type='text'/></td></tr>");
                out.print("<tr><td></td><td colspan='2'>Maximum character length: 15.");
                out.print("<tr><td class='Label'>User ID:</td>");
                out.print("<td colspan='2'>");
                out.print("<input class='TextField' id='UserID' name='UserID' type='text'/></td>"); 
                out.print("<tr><td></td><td colspan='2'>Valid from 6 to 12 characters(no space)");
   
            out.print("<tr><td class='Label'>Password:</td>");
            out.print("<td colspan='2'>");
            out.print("<input class='TextField' ID='Password' name='Password' type='password' /></td></tr>");
         
            out.print("<tr><td class='Label'>Conform Password:</td>");
            out.print("<td colspan='2'>");
            out.print("<input class='TextField' ID='ConformPassword' name='ConformPassword' type='password' /></td>");
           
            out.print("</tr><tr><td class='Label'>NBC Mail:</td>");
            out.print("<td colspan='2'>");
            out.print("<input class='TextField' id='NBCMail' name='NBCMail' type='text' /></td>");
            out.print("</tr><tr><td class='Label'>Department:</td>");
            out.print("<td colspan='2'>");
            out.print("<select  class='TextField' ID='Department' name='Department'/>");
            try{while(rs.next())
            out.print("<option>"+rs.getString("Department_name")+"</option>");
            }catch(Exception e){e.getLocalizedMessage();
            }
            out.print("</select></td></tr>");
            out.print("<tr><td colspan='3' align='right'><input type='button' name='Register' ID='Register' value='Register' Onclick=Message()>");
            if(Message!=null){
                 out.print("<tr><td colspan='3' align='center'>Your User ID is existed</td></tr>");
          }
             if(Password!=null){
                   out.print("<tr><td colspan='3' align='center'>Password must be at least 6 characters</td></tr>");
             }
            out.print("</td></tr>");
            out.print("</table>");
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
