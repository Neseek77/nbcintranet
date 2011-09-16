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
import java.io.*;
import java.lang.*;
import java.lang.String;
import java.util.StringTokenizer;
import java.util.*;
/**
 *
 * @author DA
 */
public class IOTemplate extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public String TextField(String nameID,String value){
        String re ="<input type='text',  name='"+ nameID +"' id='"+ nameID +"' value='"+ value +"'>";
        return re;
    }
     public String TextField(String nameID,String value,String width){
        String re ="<input type='text',  name='"+ nameID +"' id='"+ nameID +"' value='"+ value +"' size='"+ width +"'>";
        return re;
    } 
    public String TextField(String nameID){
        String re ="<input type='text',  name='"+ nameID +"' id='"+ nameID +"'>";
        return re;
    }
    public String Buttons(String nameID, String Even,String value){
        String re ="<input type='button',name='"+ nameID +"', id='"+ nameID +"', onclick='"+ Even+ "', value='"+ value +"'>";
        return re;
    }
    public String Buttons(String nameID,String value){
        String re ="<input type='submit',name='"+ nameID +"', id='"+ nameID +"', value='"+ value +"'>";
        return re;
    }
    public String Reset(){
        String re ="<input type='reset',name='reset' id='re'>";
        return re;
    }
      public String Select(String nameID){
        String re ="<Select name='"+ nameID +"', id='"+ nameID +"'>";
        return re;
    }
     public String EndSelect(){
        String re ="</Select>";
        return re;
    }
     public String Option(String VALUE){
        String re ="<option>"+ VALUE + "</option>";
        return re;
    }
    
     public String Rows(String align){
        String re ="<tr align='"+ align +"'>";
        return re;
    }
      public String Rows(){
        String re ="<tr>";
        return re;
    }
     public String EndRows(){
        String re = "</tr>";
        return re;
    }
   
    public String Cols(){
    String re ="<td>";
        return re;
    }
     public String Cols(String align){
    String re ="<td align='"+align+"'>";
        return re;
    }
     public String Cols(String align,int colspan){
    String re ="<td align='"+align+ "', colspan="+ colspan +">";
        return re;
    }
     public String Cols(int colspan){
    String re ="<td colspan="+ colspan +">";
        return re;
    }

    public String EndCols(){
    String re ="</td>";
        return re;
    }
    
    public String Tables(){
    String re ="<table>";
        return re;
    }
    public String Tables(String align){
    
        String re ="<table align='" + align + "'>";
        return re;
    }
    public String Label(String Name){
    
        String re =Name;
        return re;
    }
    public String EndTables(){
    String re ="</table>";
        return re;
    }
    
    public String Cols(String type,String nameID){
    String re ="<td><input type='"+type+"' name='"+nameID+"' id='"+nameID+"'></td></tr>";
        return re;
    } 
    public String CheckBox(String NameID){
        String re="<input type='checkbox'name='CkbPhone' align='left'/>";
        return re;
    }
    
    public String CheckBox(String NameID,int statue){
        String re="<input type='checkbox'name='CkbPhone' align='left' checked='checked'/>";
        return re;
    }
 

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CLTable</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CLTable at " + request.getContextPath () + "</h1>");
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
