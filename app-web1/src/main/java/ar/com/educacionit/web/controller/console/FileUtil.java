package ar.com.educacionit.web.controller.console;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public final class FileUtil {

	public final static void copyFile(File source, File target) throws IOException {
		
		FileInputStream fin = null;
		FileOutputStream fout = null;
		
		try {
			
			fin = new FileInputStream(source);
			
			fout = new FileOutputStream(target);
			
			byte[] b = new byte[1024];	//1kb
			
			int nroOfByte = 0;
			
			System.out.println("Copiado de archivo usando streams");
			while((nroOfByte = fin.read(b)) != -1) {
				fout.write(b,0,nroOfByte);
			}
		}finally {
			fin.close();
			fout.close();			
		}
		
	}
}
