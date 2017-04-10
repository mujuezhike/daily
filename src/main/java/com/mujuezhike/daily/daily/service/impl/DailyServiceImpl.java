package com.mujuezhike.daily.daily.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mujuezhike.daily.daily.dao.DailyBeanDao;
import com.mujuezhike.daily.daily.dao.DailyBeanHistoryStatisticsDao;
import com.mujuezhike.daily.daily.entity.DailyBean;
import com.mujuezhike.daily.daily.entity.DailyBeanHistoryStatistics;
import com.mujuezhike.daily.daily.enums.StatusEnum;
import com.mujuezhike.daily.daily.service.DailyService;

@Component
public class DailyServiceImpl  implements DailyService{
	
	@Autowired
	private DailyBeanDao dailyBeanDao;
	
	@Autowired
	private DailyBeanHistoryStatisticsDao dailyBeanHistoryStatisticsDao;

	/** title content date 必须 **/
	@Override
	public DailyBean save(DailyBean dailyBean) {
		UUID uuid = UUID.randomUUID();
		dailyBean.setId("s1_" + uuid.toString());
		dailyBean.setName(dailyBean.getTitle());
		dailyBean.setCreator("DEV");
		dailyBean.setOrder(0d);
		dailyBean.setStatus(StatusEnum.NORMAL.getCode());
		
		dailyBeanDao.insert(dailyBean);
		
		DailyBeanHistoryStatistics dailyBeanHistoryStatistics = new DailyBeanHistoryStatistics();
		dailyBeanHistoryStatistics.setTitle(dailyBean.getTitle());
		
		DailyBeanHistoryStatistics dd = dailyBeanHistoryStatisticsDao.selectLastTitle(dailyBeanHistoryStatistics.getTitle());
		
		if(dd!=null && dd.getId()!=null){
			
			DailyBeanHistoryStatistics last = dd;
			UUID uuidin = UUID.randomUUID();
			last.setId("s1_" + uuidin.toString());
			last.setName(dailyBean.getTitle());
			last.setTitle(dailyBean.getTitle());
			last.setCreator(dailyBean.getCreator());
			last.setCount(last.getCount()+1);
			last.setCreateTime(null);
			last.setUpdateTime(null);
			last.setDate(dailyBean.getDate());
			last.setOrder(dailyBean.getOrder());
			dailyBeanHistoryStatisticsDao.insert(last);
			
		}else{
			
			DailyBeanHistoryStatistics last = new DailyBeanHistoryStatistics();
			UUID uuidin = UUID.randomUUID();
			last.setId("s1_" + uuidin.toString());
			last.setName(dailyBean.getTitle());
			last.setTitle(dailyBean.getTitle());
			last.setCreator(dailyBean.getCreator());
			last.setCount(1l);
			last.setCreateTime(null);
			last.setUpdateTime(null);
			last.setDate(dailyBean.getDate());
			last.setOrder(dailyBean.getOrder());
			dailyBeanHistoryStatisticsDao.insert(last);
		}
		
		return dailyBean;
	}

	@Override
	public int arrangeDocuments(String filePath) {
		File file = new File(filePath);
        if (file.exists()) {
            File[] files = file.listFiles();
            String date = file.getName();
            if (files.length == 0) {
                //System.out.println("file not find!");
                return 0;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        
                    	arrangeDocuments(file2.getAbsolutePath());
                    	
                    } else {
                    	
                    	String fileName = file2.getName();
                    	DailyBean db = new DailyBean();
                    	db.setTitle(fileName);
                    	db.setContent(fileToString(file2));
                    	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
                    	Date dated = null;
                    	try {
                    		dated = sd.parse(date);
						} catch (ParseException e) {
							e.printStackTrace();
						}
                    	
                    	db.setDate(dated);
                    	this.save(db);
                    	System.out.println("save: " + date + " " + fileName + " success" );
                    	
                    }
                }
            }
        } else {
            
        }
        
        return 0;
    }
	
	 public String fileToString(File file) {
	        BufferedReader reader = null;
	        try {
	        	String charset = this.getCharset(file);
	            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),charset));  
	            String tempString = "";
	            String totalString = ""; 
	            while ((tempString = reader.readLine()) != null) {
	            	totalString += tempString;
	            }
	            reader.close();
	            return totalString;
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
			return null;
	}
	 
	 private String getCharset(File file) throws IOException{  
	        
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

	@Override
	public List<DailyBeanHistoryStatistics> getHistoryByDate(String date){
		
		DailyBeanHistoryStatistics db = new DailyBeanHistoryStatistics();
		SimpleDateFormat sd = new SimpleDateFormat();
		
		Date s = null;
		try {
			sd.applyPattern("yyyy-MM-dd");
			s = sd.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.setDate(s);
		
		List<DailyBeanHistoryStatistics> list = dailyBeanHistoryStatisticsDao.selectBySearchBean(db);
		
		return list;
	}  
	
	 
}
