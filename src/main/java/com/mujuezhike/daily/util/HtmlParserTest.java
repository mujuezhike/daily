/**
 * 
 */
package com.mujuezhike.daily.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;

import com.mujuezhike.daily.ResumeSearchTest;

/**
 * @author mujuezhike
 *
 */
public class HtmlParserTest{
	
	static Map<String,Long> wordmap = new HashMap<String,Long>();
	public static ValueComparator bvc =  new ValueComparator(wordmap);  
	public static Map<String,Long> sorted_map = new TreeMap<String,Long>(bvc); 
	
	public static void main (String[] args) throws Exception {  
		
		List<File> filelist = new ArrayList<File>();
		getFileList("C:\\jl",filelist);
		 
		for(int i=0;i<filelist.size();i++){
			deceFile(filelist.get(i).getAbsolutePath());
		}
		sorted_map.putAll(wordmap); 
		showTreeMap(sorted_map); 
		writeTreeMap(sorted_map,"C:\\jl\\pi.txt");
    } 
	
	public static List<File> getFileList(String strPath,List<File> filelist) {
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) { // 判断是文件还是文件夹
                    getFileList(files[i].getAbsolutePath(),filelist); // 获取文件绝对路径
                } else if (fileName.endsWith("avi")) { // 判断文件名是否以.avi结尾
                    
                } else {
                	String strFileName = files[i].getAbsolutePath();
                    System.out.println("---" + strFileName);
                    filelist.add(files[i]);
                }
            }

        }
        return filelist;
    }
	
	public static void deceFile(String filePath) throws IOException{
		
		//String filePath = "C:\\jl\\简历file\\安秦阳(236761171)";
		 StringBuffer sb = new StringBuffer();
	     readToBuffer(sb, filePath);
		 String m = Html2Text(sb.toString());
		 //System.out.println(filePath+"  :ok!!");
		 //System.out.println(m);
		 getWordsFromString(m,wordmap);
		 
	}
	
	public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is,ResumeSearchTest.getCharset(new File(filePath))));
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            buffer.append(line); // 将读到的内容添加到 buffer 中
            buffer.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();
    }
	
	 public static String Html2Text(String inputString) {  
	        String htmlStr = inputString; // 含html标签的字符串  
	        String textStr = "";  
	        java.util.regex.Pattern p_script;  
	        java.util.regex.Matcher m_script;  
	        java.util.regex.Pattern p_style;  
	        java.util.regex.Matcher m_style;  
	        java.util.regex.Pattern p_html;  
	        java.util.regex.Matcher m_html;  
	        try {  
	            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>  
	            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>  
	            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式  
	            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);  
	            m_script = p_script.matcher(htmlStr);  
	            htmlStr = m_script.replaceAll(""); // 过滤script标签  
	            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);  
	            m_style = p_style.matcher(htmlStr);  
	            htmlStr = m_style.replaceAll(""); // 过滤style标签  
	            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);  
	            m_html = p_html.matcher(htmlStr);  
	            htmlStr = m_html.replaceAll(""); // 过滤html标签  
	            textStr = htmlStr;  
	        } catch (Exception e) {System.err.println("Html2Text: " + e.getMessage()); }  
	        //剔除空格行  
	        textStr=textStr.replaceAll("[ ]+", " ");  
	        textStr=textStr.replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");  
	        return textStr;// 返回文本字符串  
	    }  
	 
	 private static void getWordsFromString(String s,Map<String,Long> map){
		 
		 String last = "";
		 
		 for(int i=0;i<s.length();i++){
			 char c = s.charAt(i);
			 
			 if(Character.isDigit(c) && (c>=65&&c<=90)||(c>=97&&c<=122)){
				
				 last += c;
				 
			 }else{
				 
				 if(last!=null && !last.equals("") && last.length() < 20){
					 
					 Long l = map.get(last);
					 if(l!=null && l>0){
						 map.put(last, l+1);
					 }else{
						 map.put(last, 1l);
					 }
				 }else{
					 
				 }
				 
				 last = "";
				 
			 }
			 
			 
			 
		 }
		 
		 if(last!=null && !last.equals("")  && last.length() < 20){
			 
			 Long l = map.get(last);
			 if(l!=null && l>0){
				 map.put(last, l+1);
			 }else{
				 map.put(last, 1l);
			 }
			 
		 }else{
			 
		 }
		 
	 }
	 
		public static void showTreeMap(Map<String,Long> map) {
			
		    for (Entry<String, Long> en : map.entrySet()) {
		    	
		    	System.out.println(en.getKey() + "  :  " + en.getValue());
	            
		    }
			
		}
		
		public static void writeTreeMap(Map<String,Long> map ,String filepath) throws IOException {
			 
		    FileWriter fw = null;   
            int count=1000;//写文件行数  
            try {   
            	fw = new FileWriter(filepath); 
                for (Entry<String, Long> en : map.entrySet()) {	
    		    	
                	fw.write(en.getKey() + "  :  " + en.getValue());
    		    	fw.write("\r\n");
    		    }
            
            }catch(Exception e){
            	
            	e.printStackTrace();
            	
            }
            
            fw.flush();
			fw.close();
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
