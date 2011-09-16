import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.sql.Date.*;
import javax.servlet.http.HttpSession;
public class ClassUploadFile extends HttpServlet {
	private static final String TMP_DIR_PATH = "c:\\tmp";
	private File tmpDir;
	private static final String DESTINATION_DIR_PATH =FilePath.UserUploadPath();
	private File destinationDir;
 
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		tmpDir = new File(TMP_DIR_PATH);
		if(!tmpDir.isDirectory()) {
			throw new ServletException(TMP_DIR_PATH + " is not a directory");
		}
		//String realPath = getServletContext().getRealPath(DESTINATION_DIR_PATH);
		destinationDir = new File(DESTINATION_DIR_PATH);
		if(!destinationDir.isDirectory()) {
			throw new ServletException(DESTINATION_DIR_PATH+" is not a directory");
		}
 
	}
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
	    //response.setContentType("text/plain");
	    response.setContentType("text/html;charset=UTF-8");
	    out.println();
 
		DiskFileItemFactory  fileItemFactory = new DiskFileItemFactory ();
		/*
		 *Set the size threshold, above which content will be stored on disk.
		 */
		fileItemFactory.setSizeThreshold(1*1024*1024); //1 MB
		/*
		 * Set the temporary directory to store the uploaded files of size above threshold.
		 */
		fileItemFactory.setRepository(tmpDir);
 
		ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
		try {
			
			List items = uploadHandler.parseRequest(request);
			Iterator itr = items.iterator();
			while(itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				/*
				 * Handle Form Fields.
				 */
				if(item.isFormField()) 
                         response.sendRedirect("ndex?page=UploadFile");
                         //            out.print("1");
				else 
                           //     out.print("1");  
 				response.sendRedirect("index?page=UploadFile");                                   
//start database
                           ExecuteNonQ ex=new ExecuteNonQ();
                           ResultSet rs=ex.SelectQueryByFieldWithCondition("File_Name","Uploaded_Files","file_name",item.getName());
                               HttpSession session = request.getSession();
                               String userid=(String)session.getAttribute("User_ID");
                           try{
                               while(rs.next()){
                                 response.sendRedirect("UploadFile?message=Your File's name is already existed, please rename your file and upload. again ");
                               }
                               String sqlfield="("
                                       + "File_ID,"
                                       + "Category_ID,"
                                       + "File_Title,"
                                       + "File_Short_Desc,"
                                       + "File_Full_Desc,"
                                       + "file_name,"
                                       + "File_Path,"
                                       + "File_Type,"
                                       + "File_size,"
                                       + "Frequency,"
                                       + "date_Upload,"
                                       + "user_Upload)";
                               String sqlvalue=" VALUES ("
                                       + "Upload_File_ID.nextVal,"
                                       + ""+request.getParameter("CateID")+","
                                       + "'"+request.getParameter("Title")+"',"
                                       + "'"+request.getParameter("ShortDesc")+"',"
                                       + "'"+request.getParameter("FullDesc")+"',"
                                       + "'"+item.getName()+"',"
                                       + "'"+FilePath.UserUploadPath()+"',"
                                       + "'"+item.getContentType()+"',"
                                       + ""+item.getSize()+","
                                       + "0,"
                                       + "SYSDATE,"
                                       + "'"+userid+"')";
                               
                               String sql=sqlfield+sqlvalue;
                               ex.insertQueryCustomize("Uploaded_Files", sql);
                               out.println("sQL "+ sql);
                           }catch(Exception e){e.getLocalizedMessage();
                }    
                                //  out.println("sQL "+ sql);
//end database
					File file = new File(destinationDir,item.getName());
					item.write(file);
				
                                    out.close();
			}
		}catch(FileUploadException ex) {
			log("Error encountered while parsing the request",ex);
		} catch(Exception ex) {
			log("Error encountered while uploading file",ex);
		}
	}
}