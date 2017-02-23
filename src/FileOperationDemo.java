import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperationDemo {
	
	static boolean fileCopy(String source , String dest) throws IOException{
		boolean isCopied = false;
		final int EOF = -1;
		File file = new File(source);
		
		if(file.exists()){
		long startTime = System.currentTimeMillis();	
		FileInputStream fs = new FileInputStream(file);
		BufferedInputStream bs = new BufferedInputStream(fs,20000);
		FileOutputStream fo = new FileOutputStream(dest);
		BufferedOutputStream bo = new BufferedOutputStream(fo,20000);
		int singleByte = bs.read();
		while(singleByte!=EOF){
			bo.write(singleByte);
			singleByte = bs.read();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Total time taken "+(endTime-startTime)+"ms");
		bs.close();
		bo.close();
		fs.close();
		fo.close();
		return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	
	static void writeFile(String path , String data) throws IOException{
		FileOutputStream fo = new FileOutputStream(path,true);
		fo.write(data.getBytes());
		fo.close();
		System.out.println("Done...");
	}
	
	static String readFile(String path) throws IOException{
		
		FileInputStream fs = new FileInputStream(path);
		StringBuffer sb = new StringBuffer();
		
		int singleByte = fs.read(); 
		while(singleByte!=-1){
			sb.append((char)singleByte);
			
			singleByte = fs.read();
		}
		fs.close();  // close the file
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		fileCopy("/Users/Akshat/Documents/akshat.txt", "/Users/Akshat/Documents/akshat2.txt");
		}

}
