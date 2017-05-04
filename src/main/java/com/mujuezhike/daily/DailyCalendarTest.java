package com.mujuezhike.daily;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.codehaus.plexus.util.StringUtils;

/** 根据时间查看日志   **/
public class DailyCalendarTest {
	
	public static Map<String,Long> typeMap = new HashMap<String,Long>();
	public static List<String> typeList = new ArrayList<String>();
	public static ValueComparator bvc =  new ValueComparator(typeMap);  
	public static Map<String,Long> sorted_map = new TreeMap<String,Long>(bvc); 
	
	public static void main(String[] args){
		
		traverseFolder2("E:\\日记\\rj20170410","2015-06-02");
		
		//showMap(typeMap);
		
		//sorted_map.putAll(typeMap); 

		//showTreeMap(sorted_map);
	}
	
	/**
	 * file 
	 * map
	 * @param path
	 */
	public static void traverseFolder2(String path,String searchBean) {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                //System.out.println("file not find!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        
                    	if(searchBean.contains(file2.getName())){
                    		
                    		traverseFolder2(file2.getAbsolutePath(),searchBean);
                    		
                    	}
                        
                    } else {
                    	
                    	String fileName = file2.getName();
                    	
//                    	if(fileName.equals("SPORTS.txt")){
//                    		File newfile=new File(file2.getParentFile().getAbsolutePath()+"\\SPORT.txt"); 
//                    		file2.renameTo(newfile);
//                    	}
//                    	
//                    	if(fileName.equals("FRIENDS.txt")){
//                    		File newfile=new File(file2.getParentFile().getAbsolutePath()+"\\FRIEND.txt"); 
//                    		file2.renameTo(newfile);
//                    	}
//                    	
//                    	if(fileName.equals("VEDIO.txt")){
//                    		File newfile=new File(file2.getParentFile().getAbsolutePath()+"\\VIDEO.txt"); 
//                    		file2.renameTo(newfile);
//                    	}
//                    	
//                    	if(fileName.equals("WORKING.txt")){
//                    		File newfile=new File(file2.getParentFile().getAbsolutePath()+"\\WORK.txt"); 
//                    		file2.renameTo(newfile);
//                    	}
//                    	
//                    	if(fileName.equals(".DS_Store")){
//                    		file2.delete();
//                    		continue;
//                    	}
//                    	
//                    	
                    	
//                    	Long count = typeMap.get(file2.getName());
//                    	if(count==null){
//                    		typeMap.put(file2.getName(),1l);
//                    	}else{
//                    		typeMap.put(file2.getName(),count+1);
//                    	}
//                    	
//                    	if(file2.getName().contains(searchBean)){
//                    		System.out.println("filename "+ file2.getAbsolutePath() +": title ");
//                    	}
                    	
//                      System.out.println("file:" + file2.getAbsolutePath());
                        searchFileByLines(file2,searchBean);
                    }
                }
            }
        } else {
            System.out.println("�ļ�������!");
        }
    }
	
	/**
	 * show map infomation
	 * @param map
	 */
	public static void showMap(Map<String,Long> map) {
		
	    Set<String> kt = map.keySet();
	    
	    for(String k:kt){
	    	
	    	System.out.println(k+"  :  "+map.get(k));
	    }
		
	}
	
	/**
	 * ��ʾmap
	 * @param map
	 */
	public static void showTreeMap(Map<String,Long> map) {
		
	    for (Entry<String, Long> en : map.entrySet()) {
	    	
	    	System.out.println(en.getKey() + "  :  " + en.getValue());
            
	    }
		
	}
	
	  /**
     * ����Ϊ��λ��ȡ�ļ��������ڶ������еĸ�ʽ���ļ�
     */
    public static void searchFileByLines(File file,String searchBean) {
        BufferedReader reader = null;
        try {
        	System.out.println("["+file.getName());
        	//System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),getCharset(file)));  
            String tempString = null;
            int line = 1;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((tempString = reader.readLine()) != null) {
                // ��ʾ�к�
            	if(tempString != null && StringUtils.isNotBlank(tempString)){
            		
            		System.out.println(tempString);
            		
            	}
                line++;
            }
            System.out.println("]");
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
    
    static class ValueComparator implements Comparator<String> {  
    	  
        Map<String, Long> base;  
        public ValueComparator(Map<String, Long> base) {  
            this.base = base;  
        }  
      
        // Note: this comparator imposes orderings that are inconsistent with equals.      
        public int compare(String a, String b) {  
            if (base.get(a) > base.get(b)) {  
                return -1;  
            } else {  
                return 1;  
            } // returning 0 would merge keys  
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
