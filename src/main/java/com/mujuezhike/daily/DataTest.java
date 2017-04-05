package com.mujuezhike.daily;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataTest {
	
	public static void main(String[] args){
		
		//jdbc.url=jdbc:mysql://192.168.1.105:3306/meien_sdb?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull
		//jdbc.username=heb
		//jdbc.password=changethepassword
		
		// 驱动程序名
        String driver = "com.mysql.jdbc.Driver";

        // URL指向要访问的数据库名scutcs
        String url = "jdbc:mysql://192.168.1.105:3306/meien_sdb?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull";

        // MySQL配置时的用户名
        String user = "heb"; 

        // MySQL配置时的密码
        String password = "changethepassword";

        try { 
         // 加载驱动程序
         Class.forName(driver);

         // 连续数据库
         Connection conn = DriverManager.getConnection(url, user, password);

         if(!conn.isClosed()) 
          System.out.println("Succeeded connecting to the Database!");

         // statement用来执行SQL语句
         Statement statement = conn.createStatement();

         // 要执行的SQL语句
         String sql = "select * from search_bean";

         // 结果集
         ResultSet rs = statement.executeQuery(sql);

         System.out.println("-----------------");
         System.out.println("执行结果如下所示:");
         System.out.println("-----------------");
         System.out.println(" 学号" + "\t" + " 姓名");
         System.out.println("-----------------");

         String name = null;

         while(rs.next()) {
 
          // 选择sname这列数据
          name = rs.getString("name");
 
//          // 首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
//          // 然后使用GB2312字符集解码指定的字节数组
//          name = new String(name.getBytes("ISO-8859-1"),"GB2312");

          // 输出结果
          System.out.println(rs.getString("id") + "\t" + name);
         }

         rs.close();
         conn.close();

        } catch(ClassNotFoundException e) {


         System.out.println("Sorry,can`t find the Driver!"); 
         e.printStackTrace();


        } catch(SQLException e) {


         e.printStackTrace();


        } catch(Exception e) {


         e.printStackTrace();


        } 
		
	}

}
