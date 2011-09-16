import java.io.*;
import java.net.*;
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
public class Sendmail extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, 
                                  HttpServletResponse response)
                   throws IOException, ServletException {
 PrintWriter out = response.getWriter();
        final String err = "/error.html";
        String id=request.getParameter("UserID");
        String from = "NBC_Intranet_Mail_System";
        String to = request.getParameter("NBCMail");
        //String to ="da.born@nbc.org.kh";
        String subject ="Activate your Email";
        String str=request.getParameter("code");
        String message ="Thanks your registering with our intranet!!\n To activate your account Please check below link. http://localhost:8084/NBCIntranet/GetActivateCode?code="+str;
        String login = "da.born@nbc.org.kh";
        String password ="dab";
            //out.print("restult"+tos);
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
            out.println("<div align='center'><h4>Your Activation code has been sent to your email :"+to+" . Please check your email and follow the instruction to activate your account.</br> Thanks</h4></div></br><div align='center'><a href=http://mail.nbc.org.kh>Activate Now...?</a></div>");
            out.println("<a target='_self'>");
           response.sendRedirect("index?page=CompleteRegistration?email="+to+"");
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