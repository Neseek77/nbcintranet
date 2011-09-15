/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.security.MessageDigest;

public class Enscription{

public static String encodePassword(String password, String algorithm) {
byte[] unencodedPassword = password.getBytes();
MessageDigest md = null;
try {
// first create an instance, given the provider
md = MessageDigest.getInstance(algorithm);
} catch (Exception e) {
//log.error("Exception: " + e);
return password;
}
md.reset();
// call the update method one or more times
// (useful when you don't know the size of your data, e.g. stream)
md.update(unencodedPassword);
// now calculate the hash
byte[] encodedPassword = md.digest();
StringBuffer buf = new StringBuffer();
for (int i = 0; i < encodedPassword.length; i++) {
if (((int) encodedPassword[i] & 0xff) < 0x10) {
buf.append("0");
}
buf.append(Long.toString((int) encodedPassword[i] & 0xff, 16));
}
return buf.toString();
}

}