import java.io.*;
import java.net.*;
import java.sql.ResultSet;
import java.util.Properties;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.http.*;
public class SendForgotPassword extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, 
                                  HttpServletResponse response)
                   throws IOException, ServletException{
 PrintWriter out = response.getWriter();
        final String err = "/error.html";
        String id=request.getParameter("uid");
        String pwd=request.getParameter("pwd");
        //End content message
        String from = "NBC_Intranet_Auto_Mailing";
        String to = request.getParameter("email");
        String subject ="Your Intranet User ID and Password";
        String login = "da.born@nbc.org.kh";
        String password ="dab";
        String message="Welcome to NBC Intranet solution center.\n Please find an inportant information below \n Your User ID:"+id+"Your Password:"+pwd;
       
            try {
            Properties props = new Properties();
            //props.setProperty("mail.host", "smtp.gmail.com");
            props.setProperty("mail.host", "mail.nbc.org.kh");
            props.setProperty("mail.smtp.port", "25");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");
            Authenticator auth = new SMTPAuthenticator(login, password);
            Session session = Session.getInstance(props, auth);
            MimeMessage msg = new MimeMessage(session);
            msg.setText(message);  
            msg.setSubject(subject);
            msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            Transport.send(msg);
            
        } catch (AuthenticationFailedException ex) {
            request.setAttribute("ErrorMessage", "Authentication failed");
            RequestDispatcher dispatcher = request.getRequestDispatcher(err);
            dispatcher.forward(request, response);
        } catch (AddressException ex) {
            request.setAttribute("ErrorMessage", "Wrong email address");
            RequestDispatcher dispatcher = request.getRequestDispatcher(err);
            dispatcher.forward(request, response);
             } catch (MessagingException ex) {
            request.setAttribute("ErrorMessage", ex.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher(err);
            dispatcher.forward(request, response);
        }
            
          // RequestDispatcher dispatcher = request.getRequestDispatcher(succ);
            //dispatcher.forward(request, response);
            out.println("<div align='center'><h2>Complete Registration</h2></div>");
            out.println("<div align='center'><h4>Please check your email :"+to+" to get your USER ID and Password</br> Thanks</h4></div></br><div align='center'><a href=http://mail.nbc.org.kh>Go to your email now...?</a></div>");
            out.println("<a target='_self'>");
           //response.sendRedirect("index?page=CompleteRegistration?email="+to+"");
    
        }
        
    private class SMTPAuthenticator extends Authenticator {

        private PasswordAuthentication authentication;

        public SMTPAuthenticator(String login, String password) {
            authentication = new PasswordAuthentication(login, password);
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return authentication;
        }
    }

    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response)
                   throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response)
                   throws ServletException, IOException {
        processRequest(request, response);
    }
}


