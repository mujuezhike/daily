package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class JavaTest {
	
	public static Map<String,Long> typeMap = new HashMap<String,Long>();
	public static List<String> typeList = new ArrayList<String>();
	public static ValueComparator bvc =  new ValueComparator(typeMap);  
	public static Map<String,Long> sorted_map = new TreeMap<String,Long>(bvc); 
	
	
	public static void main(String[] args){
		
		traverseFolder2("D:\\data\\day","俞");
		
		//showMap(typeMap);
		
		sorted_map.putAll(typeMap); 

		showTreeMap(sorted_map);
	}
	
	/**
	 * 遍历所有的文件夹 
	 * 并统计在map
	 * @param path
	 */
	public static void traverseFolder2(String path,String searchBean) {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                //System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        //System.out.println("文件夹:" + file2.getAbsolutePath());
                        traverseFolder2(file2.getAbsolutePath(),searchBean);
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
                    	Long count = typeMap.get(file2.getName());
                    	if(count==null){
                    		typeMap.put(file2.getName(),1l);
                    	}else{
                    		typeMap.put(file2.getName(),count+1);
                    	}
                    	
                    	if(file2.getName().contains(searchBean)){
                    		System.out.println("filename "+ file2.getAbsolutePath() +": title ");
                    	}
                    	
//                        System.out.println("文件:" + file2.getAbsolutePath());
                        searchFileByLines(file2,searchBean);
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
	
	/**
	 * 显示map
	 * @param map
	 */
	public static void showMap(Map<String,Long> map) {
		
	    Set<String> kt = map.keySet();
	    
	    for(String k:kt){
	    	
	    	System.out.println(k+"  :  "+map.get(k));
	    }
		
	}
	
	/**
	 * 显示map
	 * @param map
	 */
	public static void showTreeMap(Map<String,Long> map) {
		
	    for (Entry<String, Long> en : map.entrySet()) {
	    	
	    	System.out.println(en.getKey() + "  :  " + en.getValue());
            
	    }
		
	}
	
	  /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void searchFileByLines(File file,String searchBean) {
        BufferedReader reader = null;
        try {
            //System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                // System.out.println("line " + line + ": " + tempString);
            	if(tempString.contains(searchBean)){
            		System.out.println("filename "+ file.getAbsolutePath() +": line " + line + ": " + tempString);
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

}
