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
 * Permits to encrypt String and return a byte char
 * 
 * @author Florent LACROIX & Laetitia GAIGNIER
 * @version 1.0
 *
 */
public class Encryptor {

	private Cipher cipher;
	
	/**
	 * 
	 * Initialize the {@link Encryptor} (and the Cipher)
	 * 
	 * @param keyPass Key for init the {@link Encryptor}
	 * 
	 * @see Cipher
	 * @see Encryptor
	 * 
	 */
	public Encryptor(String keyPass){
		try {
			Key key = new SecretKeySpec(keyPass.getBytes("ISO-8859-2"),"Blowfish");
			this.cipher=Cipher.getInstance("Blowfish");
			this.cipher.init(Cipher.ENCRYPT_MODE,key);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * 
	 * Encrypt the string in parameter
	 * 
	 * @param string String to encrypt
	 * 
	 * @return a byte char encrypted
	 * 
	 * @see Cipher
	 * 
	 */
	public byte[] encrypt(String string){
		try {
			return this.cipher.doFinal(string.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * Return the cipher
	 * 
	 * @return the cipher of the {@link Encryptor}
	 * 
	 */
	public Cipher getCypher(){
		return this.cipher;
	}
}
