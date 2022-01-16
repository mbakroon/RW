package Decrypt_Encrypt;

import Decrypt_Encrypt.Decrypt;
import Decrypt_Encrypt.Encrypt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//testasdadasddasdasdööö



public class ReadFile {
	
	// Attributes
	private static File inputFile;
	private static File pathAsFile;
	private static String pathAsString;
	private static BufferedReader reader;
	private static int counter = 0;

	// Read the file in and encrypt all paths/files at once
	public static void readFileEncryptAtOnce(String key) {

		try {
			//änderung Pfade 
			inputFile = new File("/Users/m.bakroon/Desktop/location.txt");
			
			reader = new BufferedReader(new FileReader(inputFile));
			
			pathAsString = new String();
			
			while((pathAsString = reader.readLine()) != null) {		
				
				pathAsFile = new File(pathAsString);

				Encrypt.encryptFile(key, pathAsFile);


			}//while

			reader.close();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}//catch
		
	}//Method readFileEncryptAtOnce
	
	
	// Read the file in and encrypt one file after another
	public static void readFileEncryptOneByOne(String key, int index) {
		
		try {
			
			pathAsString = Files.readAllLines(Paths.get("/Users/m.bakroon/Desktop/location.txt")).get(index);
			
			pathAsFile = new File(pathAsString);
			
			Encrypt.encryptFile(key, pathAsFile);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}//catch
		
	}//Method readFileEncryptOneByOne
	
	
	// Read file and decrypt all files at once
	public static void readFileToDecrypt(String key) {
		
		try {
			
			inputFile = new File("/Users/m.bakroon/Desktop/location.txt");
			
			reader = new BufferedReader(new FileReader(inputFile));
			
			pathAsString = new String();
			
			while((pathAsString = reader.readLine()) != null) {
				
				pathAsFile = new File(pathAsString);
				
				Decrypt.decryptFile(key, pathAsFile);
				
			}//while
			
			reader.close();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		
		}//catch
		
	}//Method readFile
	
	
	// Read file and count how many paths we have in the file
	public static int readFileCountPaths() {
		
		try {
			
			inputFile = new File("/Users/m.bakroon/Desktop/location.txt");
			
			reader = new BufferedReader(new FileReader(inputFile));
			
			while((pathAsString = reader.readLine()) != null) {
				
				counter++;
				
			}
			
		} catch (IOException e) {
		
			e.printStackTrace();
			
		}//catch
		
		return counter;
		
	}//Method readFileCountPaths
	
	
}//Class ReadFile
