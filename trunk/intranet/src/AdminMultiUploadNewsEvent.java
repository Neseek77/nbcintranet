
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;
import java.util.Iterator;

public class AdminMultiUploadNewsEvent extends HttpServlet {
    private static final long serialVersionUID = -3208409086358916855L;
    private String path;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
         response.setContentType("text/html;charset=UTF-8");
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List items = upload.parseRequest(request);
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();

                    
                    if (!item.isFormField()) {
                        String fileName = item.getName();
                       
                        //String root = getServletContext().getRealPath("/");
                        File path = new File(FilePath.MultiUpload());
                        //File path = new File(root + "/NewsEvent_Files");
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }
                            //if(item1!="null")
                            //item2=item.getName();
                       //out.print("Value 1"+item1+"Value 2 "+item2);
                        
                        File uploadedFile = new File(path + "/" + fileName);
                        System.out.println(uploadedFile.getAbsolutePath());
                        item.write(uploadedFile);   
                    }
                }
 
            } catch (FileUploadException e) {
                e.printStackTrace();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
                     }
        //start database
                           ExecuteNonQ ex=new ExecuteNonQ();        
                       ResultSet rs=ex.SelectQueryByFieldWithCondition("Ann_title","Announcements","file_name",request.getParameter("fl1"));
                           try{
                               while(rs.next()){
                                 response.sendRedirect("AdminPostNewsEvent?message=Your File's name is already existed, please rename your file and upload. again ");
                               }
                               String sqlfield="(News_id,News_title,News_desc,Front_Image_Name,Back_Image_Name,date_post,user_post,Front_image_path,Back_image_path)";
                               String sqlvalue=" VALUES (SEQ_News_Events.nextVal,"
                                                        + "'"+request.getParameter("title")+"',"
                                                        + "'"+request.getParameter("desc")+"',"
                                                        + "'"+request.getParameter("fl1")+"',"
                                                        + "'"+request.getParameter("fl2")+"',"
                                                        + "SYSDATE,'da.born','"+FilePath.MultiUpload()+"','"+FilePath.MultiUpload()+"')";
                               String sql=sqlfield+sqlvalue;
                               //out.print("fsdfsd"+sql);
                               ex.insertQueryCustomize("News_Events", sql);
                             response.sendRedirect("AdminPostNewsEvent");
                           }catch(Exception e){e.getLocalizedMessage();
                }    
//end database

    }
    
}
