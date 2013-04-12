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

public class Encryptor {

	private Cipher cipher;
	
	public Encryptor(String keyPass){
		try {
			Key key = new SecretKeySpec(keyPass.getBytes("ISO-8859-2"),"Blowfish");
			this.cipher=Cipher.getInstance("Blowfish");
			this.cipher.init(Cipher.ENCRYPT_MODE,key);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
	}
	
	public String encrypt(String string){
		try {
			return new String(this.cipher.doFinal(string.getBytes()));
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Cipher getCypher(){
		return this.cipher;
	}
}
