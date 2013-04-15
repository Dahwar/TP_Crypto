package crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * Permits to decipher a byte char and return a String
 * 
 * @author Florent LACROIX & Laetitia GAIGNIER
 * @version 1.0
 *
 */
public class Decryptor {

	private Cipher cipher;

	/**
	 * 
	 * Initialize the {@link Decryptor} (and the Cipher)
	 * 
	 * @param keyPass Key for init the {@link Decryptor}
	 * 
	 * @see Cipher
	 * @see Decryptor
	 * 
	 */
	public Decryptor(String keyPass){
		try {
			Key key = new SecretKeySpec(keyPass.getBytes("ISO-8859-2"),"Blowfish");
			this.cipher=Cipher.getInstance("Blowfish");
			this.cipher.init(Cipher.DECRYPT_MODE,key);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
	}
	
    /**
     * 
     * Decrypt the byte char in parameter
     * 
     * @param byteTable byte char to decipher
     * 
     * @return a string deciphered
     * 
     * @see Cipher
     * 
     */
	public String decrypt(byte[] byteTable){
		try {
			return new String(this.cipher.doFinal(byteTable), "ISO-8859-2");
		} catch (IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * Return the cipher
	 * 
	 * @return the cipher of the {@link Decryptor}
	 * 
	 */
	public Cipher getCypher(){
		return this.cipher;
	}
}
