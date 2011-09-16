/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author DA
 */
public class Register extends HttpServlet {

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
        ExecuteNonQ ex=new ExecuteNonQ();
         //   ServletContext scr=this.getServletContext();
       //    RequestDispatcher re=scr.getRequestDispatcher("/Registration.html");
         //  re.include(request,response); 
        try {
    
            String FName=request.getParameter("FirstName");
            String LName=request.getParameter("LastName");
            String UID=request.getParameter("UserID");
            String Pwd=request.getParameter("Password");
            String NBCMail=request.getParameter("NBCMail");
            String code=Enscription.encodePassword(UID,"MD5");
            String Pass=Enscription.encodePassword(Pwd,"MD5");
            String str=null;
            HttpSession session = request.getSession();
            String userid=(String)session.getAttribute("User_ID");    
            if(!"null".equals(userid)){
            str=userid;
            }
            str=UID;
            String Table="USER_ACCOUNTS";
            String Field="USER_ID";
            String Table2="USER_ACCOUNTS";
          try{
              
                ResultSet Validate=ex.SelectQueryByFieldWithCondition(Field, Table2,Field,UID);
                if(Pwd.length()<6){response.sendRedirect("index?page=Registration?Pwd='notnullstring'");}
                boolean f=Validate.next();
               if(f){ response.sendRedirect("index?page=Registration?Message='notnullstring'");}
               else{
            String TableField="(USER_ID,"
                    + "PASSWORD,"
                    + "FIRST_NAME,"
                    + "LAST_NAME,"
                    + "GROUP_ID,"
                    + "NBC_EMAIL,"
                    + "ACTIVATION_CODE,"
                    + "STATUE,"
                    + "DATE_CREATE,"
                    + "USER_CREATE,"
                    + "DEPARTMENT_ID)";
            String ValueField=" VALUES('"+UID+"','"+Pass+"','"+FName+"','"+LName+"',1,'"+NBCMail+"','"+code+"',0,SYSDATE,'"+str+"',01)";
            String Sql=TableField+ValueField;
            ex.insertQueryCustomize(Table, Sql);
            //out.print(Sql);
           response.sendRedirect("Sendmail?NBCMail='"+NBCMail+"'&UserID='"+UID+"'&code="+code+""); 
               } 
              }catch(Exception e){e.getLocalizedMessage();
                }    
           
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */     
            
            
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
