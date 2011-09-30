
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
public class MyUploads extends HttpServlet {

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
        String Fld="File_ID,File_Name,File_Short_Desc,File_size,Frequency,File_Path";
        String Tbl="Uploaded_Files";
        String FldCon="Category_ID";
        //String ValCon="";
        ResultSet rsx=null;
        ResultSet Allresult=null;
        String Sql="";
        String CateID="";
        String KeyW="";
        String Title="";
        String ID="";
         out.print("<link href='css/Style.css' rel='stylesheet' type='text/css'>");       
        try {
            ResultSet rs=ex.Empty("SELECT Category_Name,Category_ID From File_Categories");
            try{
                
            out.print("<form name='MyUploads action='MyUpload' method='post'>"
                    + "<table align='center' width='710'>"
                    + "<tr><td>Enter Keywords:</td>" +
                    		"<td><input type='text' name='KeyW' class='TextField'></td>" +
                    		"<td><select class='Selection'><option value='0'>All Categories</option>");
            					while(rs.next()){
            							out.print("<option value='"+rs.getString("Category_ID") +"'>"+rs.getString("Category_Name")+" </option>");
                      }
            					out.print("</otpion></td></tr>");
           out.print("<tr><td>File Title:</td><td><input type='text' class='TextField' name='Title'></td><td><input type='checkbox' name='byid' class='checkedBox'><input type='text' class='SortTextFiled' name='ByFileId'></td></tr>"
                   + "<tr><td><input type='submit' name='submit' value='search'></td></tr>");
           out.print("<tr><td><Select class='SmallSelection' id='Numberpage'>");
                   try{
                   rsx=ex.Empty("Select File_ID,File_Title,File_Short_Desc,File_Size,Frequency FROM Uploaded_Files Order By date_Upload");
                           while(rsx.next())
               out.print("<option>"+rsx.getString("File_ID") +"</option>");
                             }catch(Exception e){e.getLocalizedMessage();
                }    
           out.print("</Select></td><td></td><td align='right'><input type='button' value='Upload' onclick=location.href='index?page=UploadFile'");
           out.print("</td></tr><tr><td colspan='3'>" +
           						"<table border='1'>"+
           						"<tr>"+
           						"<td>FileID</td>" +
           						"<td>Title</td>" +
           						"<td>Sort Desscription</td>" +
           						"<td>Size</td>" +
           						"<td>Frequency</td>" +
           						"<td>Download</td>" +
           						
           				  "</tr>");
 //Put data into Table on web page
           Allresult=ex.SelectQueryByFieldWithCondition(Fld, Tbl, FldCon,"3");
           try{		
        	   while(Allresult.next())
           			out.print("<tr><td>"+Allresult.getString("File_ID")
           					 +"</td><td>"+Allresult.getString("File_Name")
           					 +"</td><td>"+Allresult.getString("File_Short_Desc")
           					 +"</td><td>"+Allresult.getString("File_Size")
           					 +"</td><td>"+Allresult.getString("Frequency")
           					 +"</td><td><a href='"+Allresult.getString("File_Path")+"/"+Allresult.getString("File_Name")+"'><img src='images/download.jpg' width='130' height='100'></a></td>");
      			
           }catch(Exception e){e.getLocalizedMessage();
           }    
           out.print("</td></tr></table>");				  
           out.print("</td></tr></table>");
            }catch(Exception e){e.getLocalizedMessage();}
//database
            
            //String ValCon=request.getParameter("Numberpage");
            //if(ValCon.equalsIgnoreCase("0"))
         
/*select by selection option            
            else
                CateID=request.getParameter("Category_ID");
                KeyW=request.getParameter("KeyW");
                Title="Title";
                Sql="Select Uploaded_Files.File_ID,"
                         + "Uploaded_Files.Category_Title,"
                         + "Uploaded_Files.File_Short_Desc,"
                         + "Uploaded_Files.File_siz,"
                         + "Uploaded_Files.Frequency"
                         + " From Uploaded_Files JOIN File_Keywords ON Uploaded_Files.File_ID=File_Keywords.File_ID "
                        + "Where Uploaded_Files.Category_ID='"+CateID+"'"
                        + " AND File_Keywords.Keyword='"+KeyW+"'";
                        */
//rs=s.executeQuery("SELECT " + SELECTFIELDFROMBOTHTABLE + " FROM " +TABLENAME1+ " JOIN "+ TABLENAME2 +" ON "+CONDITIONTABLE1+"="+CONDITIONTABLE2);
                //rsx=ex.Empty(Sql);
              
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
