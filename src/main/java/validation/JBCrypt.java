package validation;

import org.mindrot.jbcrypt.BCrypt;


public class JBCrypt {
    
    //hash user password
    public static String hashPassword(String password_plaintext) {
	// Define the BCrypt workload=12 to use when generating password hashes. 10-31 is a valid value.
	String hashed_password = BCrypt.hashpw(password_plaintext, BCrypt.gensalt(12));
	return(hashed_password);
    }
    
    
}
