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
public class UploadFile extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ExecuteNonQ ex=new ExecuteNonQ();
         out.print(""
                 + "<link href='css/Style.css' rel='stylesheet' type='text/css'>"
                  + "<link href='css/Colape.css' rel='stylesheet' type='text/css'>"
                  + "<script language='javascript' src='js/MultiAction.js'></script>"
                 + "<script language='javascript' src='js/Colape.js'></script>"
                 + "<link href='css/Style.css' rel='stylesheet' type='text/css'>"
                 + "<head><script language='javascript' src='js/MultiAction.js'></script>"
                 + "<script language='javascript' src='js/Colape.js'>"
                 + "</script></head><link href='css/jquery-ui.css' rel='stylesheet' type='text/css'/>"
                 + "<script src='js/Jquery.min.js'></script>"
                 + "<script src='js/jquery-ui.min.js'></script>"
                 + "<script language='javascript' src='js/Jquery.min.js'></script>"
                 + "<link href='css/Style.css' rel='stylesheet' type='text/css'>"
                 + "<head><script language='javascript' src='js/MultiAction.js'></script>"
                 + "<script language='javascript' src='js/Colape.js'></script></head><link href='css/jquery-ui.css' rel='stylesheet' type='text/css'/>"
                 + "<script src='js/Jquery.min.js'></script>"
                 + "<script src='js/jquery-ui.min.js'></script>");
                
        out.print("<script>$(function(){$('h2.expand').toggler({initShow: 'div.collapse:first'});});</script></head>");
            try {
               ResultSet rs=ex.Empty("SELECT Category_Name,Category_ID From File_Categories");
               ResultSet rsg=ex.Empty("Select Group_Name,Group_ID From User_Defined_Groups");            
       String field="User_ID";
        String table="User_Accounts";
        String strx="'VachanDararith'";  
        try {  
          ResultSet rsx=ex.SelectQueryByField(field,table);
          try{
            while(rsx.next())
            strx+=",'"+rsx.getString("USER_ID")+"'";
         out.print(""
                 + "<form name='UploadFile' method='Post' enctype='multipart/form-data'>"
                 + "<table align='center'><tr><td>*File:</td><td><input type='file' name='file1' id='file1' class='TextField'></td></tr>"
                 + "<tr><td>*File Title:</td><td><input type='text' id='Title' class='TextField'></td></tr>"
                 + "<tr><td>*Category:<td><select class='Selection' id='Selection'><option>"
                 + "");
               while(rs.next())
                      out.print("<option value='"+rs.getString("Category_ID") +"'>"+rs.getString("Category_Name")+" </option>");
                 }catch(Exception e){e.getLocalizedMessage();}
           out.print(""
                   + "</otpion><td><tr>"
                   + "");
           out.print(""
                   + "<tr><td>"
                   + "Short Description:</td><td><input type='text' class='TextField' id='ShortDesc'><td></tr>"
                   + "<tr><td>Full Description:</td><td><TextArea id='FullDesc' class='TextArea'></TextArea><td></tr>"
                   + "<tr><td>File Keywords:</td><td><input type='text' id='KeyW' class='TextField'></td></tr>"
                   + "<tr><td colspan='2'>eg. Telecommunication; Computer Network</td></tr>"
                   + "<tr><td colspan='2'>(*Require Field)</td></tr>"
                   + "<tr><td></td></tr>"
                   + "<tr><td><input type='submit' value='Upload' id='Upload' onclick='SubmitValue();'><input type='Button' name='Cancel'></td></tr>"
                   + "");
              String str=request.getParameter("message");
              if(str!=null)
           out.println("<tr><td colspan='2'>"+str+"</td></tr>");
                out.print(""
                   + "<tr><td colspan='4'><div id='wrapper'><div class='collapse'>"
                   +"<p></p></div><div id"
                        + "='content'><h1 class='heading'></h1><div class='demo'><h2 class='expand'>Share File"
                   + "<h2><div class='collapse'><p>"
                        + "<table border='1'>"
                        + "<tr><td colspan='5'> By Default, your file will be shared to everyone.</br> "
                                + "Please choose group or user ID that you want to share this file to."
                        + "<tr><td><select class='Selection' id='userGroup'>"
                        + "");
                  try{
                     while(rsg.next())
                        out.print("<option value='"+rsg.getString("Group_ID") +"'>"+rsg.getString("Group_Name")+" </option>");
                 }catch(Exception e){e.getLocalizedMessage();}
            out.print("</otpion></td>"
                                + "<td><input type='button' onclick=\"javascript:addMe(document.getElementById('userGroup').options[document.getElementById('userGroup').selectedIndex].text)\" name='Add' value='+'></td>"
                                + "<td><input type='button' name='Sub' value='-'></td>"
                                + "<td><input class='TextField' id='autocomplete'/></td></tr>"
                        + "<tr><td colspan='3'><select id='selGroup' name='selGroup' multiple='multiple' size='5' style='width:235px'></td>"
                                + "<td colspan='2'><select id='UserID' name='UserID' multiple='multiple' size='5' style='width:235px'></select></td>"
                        + "<tr><td><input type='submit' name='submit' value='Submit'>"
                                 + "<td><input type='submit' name='submit' value='Cancel'>"
                                    + "</td></tr></table>");
                  out.print("<!DOCTYPE html><html><head>"
                  + "<link href='css/Style.css' rel='stylesheet' type='text/css'>"
                  + "<head><script language='javascript' src='js/MultiAction.js'></script>"
                  + "</head><link href='css/jquery-ui.css' rel='stylesheet' type='text/css'/>"
                  + "<script src='js/Jquery.min.js'></script>"
                  + "<script src='js/jquery-ui.min.js'></script>"
                  + "<script>"
                  + "$(document).ready(function() {"
                  + "$('input#autocomplete').autocomplete({source: ["+strx+"]});"
                  + "});"
                           + "alert(hello);"
                  + "</script>"
                  + "</body></html>"); 
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
