package com.mujuezhike.daily;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResumeSearchOneTest {

	public static int mainnum = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] searchbean = {"Flux"};
		
		for(int i=0;i<searchbean.length;i++){
			mainnum = 0;
			traverseFolder("C:/简历",searchbean[i]);
			System.out.println(searchbean[i]+": "+mainnum);
		}

	}
	
	public static void traverseFolder(String path,String searchBean) {
		
		File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                //System.out.println("file not find!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                    	
                    	traverseFolder(file2.getAbsolutePath(),searchBean);
                    	
                    } else {
                    	
                    	String fileName = file2.getName();
                    	
                    	if(file2.getName().contains(searchBean)){
                    		System.out.println("filename "+ file2.getAbsolutePath() +": title ");
                    	}

                    	if(file2.getName().contains(".htm")){
                    		searchFileByLines(file2,searchBean);
                    	}
                    }
                }
            }
        } else {
            System.out.println("文件路径不存在!");
        }
	}
	
    public static void searchFileByLines(File file,String searchBean) {
        BufferedReader reader = null;
        try {
            
        	reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),getCharset(file)));    
            String tempString = null;
            int line = 1;
            
            while ((tempString = reader.readLine()) != null) {
                
            	if(tempString.toLowerCase().contains(searchBean.toLowerCase())){
            		System.out.println("filename "+ file.getAbsolutePath() +": line " + line + ": " + tempString);
            		mainnum++;
            		//return;
            	}
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                	e1.printStackTrace();
                }
            }
        }
    }
    
    /**
     * 获取指定文件编码  
     * @param file
     * @return
     * @throws IOException
     */
    private static String getCharset(File file) throws IOException{  
        
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));    
        int p = (bin.read() << 8) + bin.read();    
          
        String code = null;    
          
        switch (p) {    
            case 0xefbb:    
                code = "UTF-8";    
                break;    
            case 0xfffe:    
                code = "Unicode";    
                break;    
            case 0xfeff:    
                code = "UTF-16BE";    
                break;    
            default:    
                code = "GBK";    
        }    
        return code;  
	 }

}
