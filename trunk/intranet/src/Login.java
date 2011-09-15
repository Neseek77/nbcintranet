
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //out.print("login page");
        //String userid=request.getParameter("User_ID");
        //String password=Enscription.encodePassword(request.getParameter("Password"),"MD5");
        HttpSession session = request.getSession();
        try {
        
//interface
            out.println("<html>");
            out.println("<head>");
            out.print("<link href='css/Style.css' rel='stylesheet' type='text/css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form name='Login' action='Login' method='post'>");
            out.print("<table align='center'>");
            out.print("<tr><td colspan='2' class='Label'>Log into NBC Intranet</td></tr>");
            out.print("<tr><td class='Label'>User ID:</td><td><input type='text' name='User_ID' class='TextLogin'></td></tr>");
            out.print("<tr><td class='Label'>Password:</td><td><input type='password' name='Password' class='TextLogin'></td></tr>");
            out.print("<tr><td colspan='2' class='Label'><a href=index?page=ForgotPassword>Forgot Password</a></td></tr>");
            out.print("<tr><td></td><td class='Label'><input type='submit' name='submit' value='Log In'><input type='reset' value='Clear'></td></tr>");
            
            out.print("</table>");
            out.print("</form>");
            out.println("</body>");
            out.println("</html>");
//end interface
            
//database section
            String userid=request.getParameter("User_ID");
        String password=Enscription.encodePassword(request.getParameter("Password"),"MD5");
        
            ExecuteNonQ ex=new ExecuteNonQ();
                   String Sql="SELECT USER_ID FROM USER_ACCOUNTS WHERE USER_ID='"+userid+"'AND Password='"+password+"'";
                   ResultSet rs=ex.Empty(Sql);
                   try{     
                   while(rs.next())
                       session.setAttribute("User_ID",rs.getString("User_ID"));
                   response.sendRedirect("index");
                     // out.print(rs.getString("USER_ID"));
                          }catch(Exception e){e.getLocalizedMessage();
                         }
                   
//end database section
            } finally{            
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
