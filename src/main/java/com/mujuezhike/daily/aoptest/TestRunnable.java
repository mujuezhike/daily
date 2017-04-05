package com.mujuezhike.daily.aoptest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestRunnable implements Runnable{  

    public void run(){  

               try{  

                  Thread.sleep(1000);//守护线程阻塞1秒后运行  

                  File f=new File("D://daemonlvl.txt");  

                  FileOutputStream os=new FileOutputStream(f,true);  

                  os.write("daemonsssssss".getBytes());  

           }catch(IOException e1){  

        	   e1.printStackTrace();  

           }catch(InterruptedException e2){  

               e2.printStackTrace();  

           }  

    }  

}  
