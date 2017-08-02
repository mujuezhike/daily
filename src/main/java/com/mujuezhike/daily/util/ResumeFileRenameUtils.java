package com.mujuezhike.daily.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

public class ResumeFileRenameUtils {

	public static void main(String[] args) throws Exception {
		
		File file = new File("C:\\jl\\51job_前端_导出简历_20170801");
		File[] fs = file.listFiles();
		for(File f:fs){
			
			if(f.getName().contains("htm")){
				
				String name = f.getName();
				//51job_张棋(292227004).htm
				name = name.substring(name.lastIndexOf("_")+1, name.lastIndexOf("."));
				File fn = new File("C:\\jl\\简历file20170801\\" + name +".html"); 
				forChannel(f,fn);
				
			}
			
		}
		
	}
	
	public static long forChannel(File f1,File f2) throws Exception{
        long time=new Date().getTime();
        int length=2097152;
        FileInputStream in=new FileInputStream(f1);
        FileOutputStream out=new FileOutputStream(f2);
        FileChannel inC=in.getChannel();
        FileChannel outC=out.getChannel();
        ByteBuffer b=null;
        while(true){
            if(inC.position()==inC.size()){
                inC.close();
                outC.close();
                return new Date().getTime()-time;
            }
            if((inC.size()-inC.position())<length){
                length=(int)(inC.size()-inC.position());
            }else
                length=2097152;
            b=ByteBuffer.allocateDirect(length);
            inC.read(b);
            b.flip();
            outC.write(b);
            outC.force(false);
        }
    }

}
