package ch.bfh.btx8081.w2017.green.Spero.model;

/**
 * checks the input mail address
 * @author mirjam
 *
 */
public class ForgetPasswordModel {
	
	  	/**
	  	 * checks the input mail address, if it is well formed
	  	 * @param the mail address
	  	 * @return true if it is well formed and false if the mail address isn't well formed
	  	 */
		public static boolean checkEmail(String mail){
			
			boolean correctEmail = true;
			
			int i = mail.indexOf("@");
			int j = mail.indexOf(".", i);
			
			if (i == 0) {
				correctEmail = false;
			}
			if (j == -1) {
				correctEmail = false;
			}
			if ((j-i) < 2) {
				correctEmail = false;
			}
			if (j == mail.length()-1) {
				correctEmail = false;
			}
			return correctEmail;
		}

}
