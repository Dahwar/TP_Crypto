package crypto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import javax.crypto.CipherOutputStream;
import javax.crypto.CipherInputStream;

public class Main {
	
	public static void main(String[] args) {
		
		Window window = new Window();
		
		Encryptor cryptString = new Encryptor("famas2713");
		
		Encryptor cryptFile = new Encryptor("azerty");

		String id = "Florent";
		String password = "Lacroix";
		
		HashMap<String, String> map = new HashMap<>();
		map.put(cryptString.encrypt(id), cryptString.encrypt(password));
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new CipherOutputStream(new FileOutputStream(new File("file")), cryptFile.getCypher()));){
			oos.writeObject(map);
			oos.flush();
		}
			catch (java.io.IOException e) {
			e.printStackTrace();
		}
		
		/*try (ObjectInputStream ois = new ObjectInputStream(new CipherInputStream(new FileInputStream(new File("file")), decryptFile.getCypher()));){
			HashMap<String, String> hm = (HashMap<String, String>) ois.readObject();
			System.out.println(hm);
			System.out.println("Hello !");
		}
			catch (java.io.IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		
		/*try {
			FileInputStream fileIn = new FileInputStream("file");
			ObjectInputStream ois = new ObjectInputStream(fileIn);
			HashMap MapRead = (HashMap) ois.readObject();
			
			for(Iterator i=MapRead.keySet().iterator();i.hasNext();){
	            Object key=i.next();
	            System.out.println(key + " " + MapRead.get(key));
	            System.out.println(cryptString.decrypt((String) key) + " " + cryptString.decrypt((String) MapRead.get(key)));
	        }
		}
		catch (java.io.IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
	}
}
