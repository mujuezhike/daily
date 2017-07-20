package com.mujuezhike.daily.netty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SocketServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		runServer();
	}

	private static void runServer() throws IOException, InterruptedException {
		ServerSocket ss = new ServerSocket(3574);// 服务端监听3574这个端口
		Socket s = ss.accept();// 服务端接受客户端的连接
		System.out.println(s.getLocalSocketAddress().toString());
		InputStream in = s.getInputStream();// 得到客户端的输入流，为了得到客户端传来的数据
		OutputStream out = s.getOutputStream();// 得到客户端的输出流，为了向客户端输出数据
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		PrintWriter bufferedWriter = new PrintWriter(out, true);

		while (true) {
			Thread.sleep(10000);
			String line = null;
			// 向客户端输出数据
			line = bufferedReader.readLine();// 读取客户端传来的数据
			if (line == null)
				break;
			System.out.println(line);// 打印客户端传来的数据

		}
	}

}
