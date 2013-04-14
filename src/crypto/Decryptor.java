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

public class Decryptor {

	private Cipher cipher;

	public Decryptor(String keyPass){
		try {
			Key key = new SecretKeySpec(keyPass.getBytes("ISO-8859-2"),"Blowfish");
			this.cipher=Cipher.getInstance("Blowfish");
			this.cipher.init(Cipher.DECRYPT_MODE,key);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
	}

	public String decrypt(byte[] byteTable){
		try {
			return new String(this.cipher.doFinal(byteTable), "ISO-8859-2");
		} catch (IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Cipher getCypher(){
		return this.cipher;
	}
}
