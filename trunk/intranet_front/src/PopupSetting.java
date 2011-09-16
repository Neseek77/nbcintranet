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
public class PopupSetting extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ExecuteNonQ ex=new ExecuteNonQ();
        String table="Announcements";
        String field="Ann_id,Ann_title";
        
       // out.print("<link type='text/css' href='css/themename/jquery-ui-1.8.15.custom.css' rel='Stylesheet' />");	
       // out.print("<script type='text/javascript' src='js/jquery-1.4.4.min.js'></script>");
        //out.print("<script type='text/javascript' src='js/jquery-ui-1.8.15.custom.min.js'></script>");
        out.print("<html>");
        out.print("<head>");
        out.print("<meta charset='utf-8'>");
        out.print("<link rel='stylesheet' href='css/jquery.ui.all.css'>");
          out.print("<link rel='stylesheet' href='css/Style.css'>");
	out.print("<script src='js/jquery-1.5.1.js'></script>");
	out.print("<script src='js/jquery.ui.core.js'></script>");
	out.print("<script src='js/jquery.ui.widget.js'></script>");
	out.print("<script src='js/jquery.ui.datepicker.js'></script>");
        out.print("<link rel='stylesheet' href='css/demos.css'>");
        out.print("<script>");
        out.print("$(function(){$('#from').datepicker();});"
                + "$(function(){$('#to').datepicker();});"
                + "</script>");
        
out.print("</div>");

	 try {
  try{
// Database
           ResultSet rs= ex.SelectQueryByField(table,field); 
//end database
           out.print("<form name='popupSetting' action='PopupSetting' method='post'>"
                   + "<table align='center'>"
                   + "<tr><td colspan='3' align='center'>PopUp Setting</td></tr>"
                   + "</tr><td></br></td></tr><tr><td>*Announcement:</td><td><select  class='Popup' name='anntitle'>");
                while(rs.next())
                out.print("<option>"+rs.getString("Ann_title")+"</option");
                   }catch(Exception e){e.getLocalizedMessage();
                         }
                out.print("</select");
                out.print("<tr><td class='popupLabel'>*From:</td><td><input type='text' class='Popup' name='from' id='from'></td></tr>"
                        + "<tr><td class='popupLabel'>*To:</td><td><input type='text' class='Popup' name='to' id='to'></td></tr>"
                        + "<tr><td><input type='submit' value='Save' name='Save'><td><input type='button' value='cancel' name='Cancel'></td></tr></table>"
                        + "</head>"
                        + "</html>");
//Database
               
                String annpopup="announcement_popup";
                String field1="(ann_id,date_from,date_to)Values ";
                String anntitle=request.getParameter("anntitle");
                  ResultSet rsx= ex.SelectQueryByFieldWithCondition("ann_id","Announcements","ann_title",anntitle); 
                String annfrom=request.getParameter("from");
                String annto=request.getParameter("to");
                try{
                    String str=null;
                    while(rsx.next())
                str=rsx.getString("ann_id");
                String value1="("+str+",'"+annfrom+"','"+annto+"')";
                String Sql=field1+value1;
                out.append(Sql);
                ex.insertQueryCustomize(annpopup,Sql);       
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
