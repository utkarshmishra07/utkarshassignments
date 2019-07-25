/**
 * 
 */
package fileprogram;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author utkarsh.mishra1
 *
 */
import java.io.IOException;
public class FileHandling {

	/**
	 * @param args
	 */
	
	public static void main(String[] args)throws IOException {
		FileOutputStream fos=new FileOutputStream("abc.txt");
		String s1="Welcome to IO";
		fos.write(s1.getBytes());
		fos.close();
		
		FileInputStream fis=new FileInputStream("abc.txt");
		
		int i;
		while((i=fis.read())!=-1) {
			System.out.print((char)i);
		
		}
		fis.close();
		
		
		// TODO Auto-generated method stub

	}

}
