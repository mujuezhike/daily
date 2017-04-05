package test;

import java.io.File;

public class FileTest {
	
	public static void main(String[] args){
		
		File f1 = new File("D:\\data\\test\\b.txt");
		System.out.println(f1.getParentFile().getAbsolutePath()+"\\a.txt");
		File f2 = new File(f1.getParentFile().getAbsolutePath()+"\\a.txt");
		f1.renameTo(f2);
		
	}

}
