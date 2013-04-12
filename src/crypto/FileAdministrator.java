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

public class FileAdministrator {

	private Decryptor decryptFile;
	private Encryptor encryptFile;
	private Decryptor decryptString = new Decryptor("famas2713");
	private Encryptor encryptString = new Encryptor("famas2713");
	
	private String fileName;
	
	private HashMap<String, String> hm;
	
	public HashMap<String, String> openFile(String file, String password) {
		this.decryptFile = new Decryptor(password);
		this.encryptFile = new Encryptor(password);
		this.fileName = file;
		try (ObjectInputStream ois = new ObjectInputStream(new CipherInputStream(new FileInputStream(new File(file)), this.decryptFile.getCypher()));){
			this.hm = (HashMap<String, String>) ois.readObject();
			return this.hm;
		}
			catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public HashMap<String, String> getHashMap(){
		return this.hm;
	}
	
	public String search(String id){
		for(Iterator<String> i=this.hm.keySet().iterator();i.hasNext();){
            Object key=i.next();
            if(this.decryptString.decrypt((String) key).equals(id)){
            	return this.decryptString.decrypt((String) hm.get(key));
            }
        }
		return null;
	}
	
	public boolean add(String id, String password){
		this.hm.put(this.encryptString.encrypt(id), this.encryptString.encrypt(password));
		this.putHashMapInFile();
		for(Iterator<String> i=this.hm.keySet().iterator();i.hasNext();){
            Object key=i.next();
            System.out.println(this.decryptString.decrypt((String)key) + " = " + this.decryptString.decrypt((String) hm.get(key)));
        }
		return true;
	}
	
	public boolean delete(String id){
		for(Iterator<String> i=this.hm.keySet().iterator();i.hasNext();){
            Object key=i.next();
            if(this.decryptString.decrypt((String)key).equals(id)){
            	hm.remove((String)key);
            	this.putHashMapInFile();
            	return true;
            }
        }
		return false;
	}
	
	public void putHashMapInFile(){
		try (ObjectOutputStream oos = new ObjectOutputStream(new CipherOutputStream(new FileOutputStream(new File(this.fileName)), encryptFile.getCypher()));){
			oos.writeObject(this.hm);
			oos.flush();
		}
			catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
}