package Decrypt_Encrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Decrypt {
        private static final String key = "BitteEntsperren!";


	public static void decryptFile(String key, File inputFile) {
		
		try	{
			
			// Construct a secret key from a byte array
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
			
			// Create cryptographic cipher and pass Transformation (e.g. with padding etc)
			// Here default!
			Cipher cipher = Cipher.getInstance("AES");
			
			// Initialize cipher to encryption mode
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			
			// Read content from a File as stream of bytes
			FileInputStream fileInputStream = new FileInputStream(inputFile);
			
			// Reading content of inputFile into a byte array
			byte[] inputByte = new byte[(int) inputFile.length()];
			//byte[] in_byte = Files.readAllBytes(inputFile.toPath());
			fileInputStream.read(inputByte);
			
			// Encrypt the file with doFinal()!
			byte[] outputByte = cipher.doFinal(inputByte);
			
			// Write to a File as a stream of bytes
			FileOutputStream fileOutputStream = new FileOutputStream(inputFile);
			fileOutputStream.write(outputByte);
			
			// Close
			fileInputStream.close();
			fileOutputStream.close();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}//catch
		
	}//decryptFile
	
}//Class decrypt
