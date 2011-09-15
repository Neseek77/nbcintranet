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
public class LastestNews extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //int pageSize=2;
        int rowCount=0;
        int pageCount=0;
        int currentRow=0;
        int currentPage= Integer.parseInt(request.getParameter("curpage"));
        int i=0;
        int j=1;
        try {
           // out.print("Announcement</br>");
            ExecuteNonQ ex=new ExecuteNonQ();
            ResultSet rs=ex.Emptyme("SELECT News_Title,News_Desc,Front_Image_Name,Back_Image_Name FROM NEWS_EVENTS ORDER BY Date_POST ASC");
            try{                    
               /* Get Row Size*/
                while(rs.next()){
                 rowCount++;
                } 
               // out.print(rowCount);
                pageCount=Math.round(rowCount/2);
                if(currentPage<1){
                    currentPage=1;
                    
                }else if(currentPage>pageCount){
                    currentPage=pageCount;
                }
                /* GET STARTING ROW INDEX of EACH PAGE */
                currentRow=(currentPage-1)*2;
                /* MOVE CURSOR TO THE POSITION PLACING BEFORE THE FIRST ROW*/
                     rs.beforeFirst();
                     
                     /* LOADING ANNOUNCEMENT IMAGE */       
                     while(rs.next()){
                        if(i>=currentRow && i<=currentRow+1){    
                        //out.println(rs.getString("File_Name")+ " AND " + rs.getString("ANN_ID")+"<br/>");
                        
                            String filename="NewsEvent_Files/"+rs.getString("Front_Image_Name");
                                out.print("<table>");
                                out.print("<tr><td rowspan=2 border=2>");
                                out.print("<a href='index?page=FullStory?Path=./NewsEvent_Files/"+rs.getString("Back_Image_Name")+"'><img src='"+filename+"' height=250px width=250px></a></br>");
                                out.print("");
                                out.print("<td align='center'><a href='index?page=FullStory?Path=./NewsEvent_Files/"+rs.getString("Back_Image_Name")+"'>"+rs.getString("News_Title")+"</a></td>");
                                out.print("<tr><td>"+rs.getString("News_Desc")+"</td></tr>");        
                         }
                        
                        i++;
                    }
                                out.print("<table>");
                     /* GENERATE PAGINATION LINK */
                     String myPrevious=(currentPage<=1)?"<a>Previous</a>":"<a href='index?page=LastestNews&curpage="+(currentPage-1)+"'>Previous</a>";
                     String myNext=(currentPage>=pageCount)?"<a>Next</a>":"<a href='index?page=LastestNews&curpage="+(currentPage-1)+"'>Next</a>";
                     out.println("<center>");
                     out.println(myPrevious);
                     for(j=1;j<=pageCount;j++){
                         String myPage=(currentPage==j)?"<a><b>"+ j +"</b></a>"+"||":"<a href='index?page=LastestNews&curpage="+j+"'>"+ j +"</a>"+"||";
                         out.println(myPage);
                     }
                     out.println(myNext);
                    out.println("</center>");
            }catch(Exception e){e.getLocalizedMessage();
                         }

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
