package crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;

import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

/**
 * 
 * Permits to manage a file after deciphering (require password).
 * Require a {@link Encryptor} and a {@link Decryptor} for the File and the Strings, the name of the file and a empty HashMap
 * 
 * @author Florent LACROIX & Laetitia GAIGNIER
 * @version 1.0
 * 
 * @see Encryptor
 * @see Decryptor
 * @see FileScreen
 * @see ConnectionScreen
 *
 */
public class FileAdministrator {

	private Decryptor decryptFile;
	private Encryptor encryptFile;
	private Decryptor decryptString = new Decryptor("famas2713");
	private Encryptor encryptString = new Encryptor("famas2713");
	
	private String fileName;
	
	private HashMap<byte[], byte[]> hm;
	
	/** 
	 * Permits to open a encrypted file, if the password is correct
	 * 
	 * @param file Name of the file
	 * @param password Password to decipher the file
	 * @return The HashMap deciphered, with the encrypted data of some ID and password
	 * 
	 */
	public HashMap<byte[], byte[]> openFile(String file, String password) {
		this.decryptFile = new Decryptor(password);
		this.encryptFile = new Encryptor(password);
		this.fileName = file;
		try (ObjectInputStream ois = new ObjectInputStream(new CipherInputStream(new FileInputStream(new File(file)), this.decryptFile.getCypher()));){
			this.hm = (HashMap<byte[], byte[]>) ois.readObject();
			return this.hm;
		}
			catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * Return the HashMap who contains the data of the deciphered file
	 * 
	 * @return The HashMap deciphered, data of {@link FileAdministrator}
	 * 
	 */
	public HashMap<byte[], byte[]> getHashMap(){
		return this.hm;
	}
	
	/**
	 * 
	 * Set the HashMap who contains the data of the deciphered file to NULL
	 * 
	 */
	public void setHashMapToNull(){
		this.hm = null;
	}
	
	/**
	 * 
	 * Search a key in the HashMap
	 * 
	 * @param id ID of the pair id-password to find in the HashMap
	 * @return The password deciphered if the id pass in parameter exists, NULL otherwise
	 * 
	 * @see FileScreen
	 * @see Decryptor
	 * 
	 */
	public String search(String id){
		for(Iterator<byte[]> i=this.hm.keySet().iterator();i.hasNext();){
            Object key=i.next();
            if(this.decryptString.decrypt((byte[]) key).equals(id)){
            	return this.decryptString.decrypt(this.hm.get(key));
            }
        }
		return null;
	}
	
	/**
	 * 
	 * Add a pair ID-password to the HashMap and push it in the encrypted file
	 * 
	 * @param id ID to the pair ID-password to add at the HashMap
	 * @param password Password to the pair ID-password to add at the HashMap
	 * @return TRUE if the pair is add to the HashMap, FALSE otherwise
	 * 
	 * @see FileScreen
	 * @see Encryptor
	 * @see Decryptor
	 * 
	 */
	public boolean add(String id, String password){
		for(Iterator<byte[]> i=this.hm.keySet().iterator();i.hasNext();){
            Object key=i.next();
            if(this.decryptString.decrypt((byte[]) key).equals(id)){
            	return false;
            }
        }
		this.hm.put(this.encryptString.encrypt(id), this.encryptString.encrypt(password));
		this.putHashMapInFile();
		return true;
	}
	
	/**
	 * 
	 * Delete a pair ID-password of the HashMap and update the encrypted file
	 * 
	 * @param id ID of the pair to delete
	 * @return TRUE if the pair is deleted, FALSE otherwise
	 * 
	 * @see FileScreen
	 * @see Decryptor
	 * 
	 */
	public boolean delete(String id){
		for(Iterator<byte[]> i=this.hm.keySet().iterator();i.hasNext();){
            Object key=i.next();
            if(this.decryptString.decrypt((byte[]) key).equals(id)){
            	this.hm.remove((byte[]) key);
            	this.putHashMapInFile();
            	return true;
            }
        }
		return false;
	}
	
	/**
	 * 
	 * Put the HashMap in the encrypted file
	 * 
	 */
	public void putHashMapInFile(){
		try (ObjectOutputStream oos = new ObjectOutputStream(new CipherOutputStream(new FileOutputStream(new File(this.fileName)), encryptFile.getCypher()));){
			oos.writeObject(this.hm);
			oos.flush();
		}
			catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Permits to create a new encrypted file
	 * 
	 * @param file Name of the file
	 * @param password Password to encrypt and decipher the file
	 * 
	 * @see FileScreen
	 * @see Encryptor
	 * @see Decryptor
	 * 
	 */
	public void createNewFile(String file, String password) {
		this.decryptFile = new Decryptor(password);
		this.encryptFile = new Encryptor(password);
		this.fileName = file;
		this.hm = new HashMap<byte[], byte[]>();
		this.putHashMapInFile();
	}
}
