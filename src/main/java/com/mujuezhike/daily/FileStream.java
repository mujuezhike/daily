package com.mujuezhike.daily;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStream {
	
	public static void main(String[] args) throws Exception {
//		
		to();
		back();
	}
	
	public static void back() throws Exception {
		
		File file = new File("/Users/shengboxu/Documents/imp/f/m3.m");
		InputStream input = new FileInputStream(file);
		byte[] byt = new byte[input.available()];
		input.read(byt);
		
		byte[] dmr = new byte[byt.length];
		
		for(int i=0;i<dmr.length;i++) {
			byte d = byt[i];
			
			if(d%2==0) {
				dmr[i] = (byte) (d-2*i);
			}else {
				dmr[i] = (byte) (d+2*i);
			}
		}
		
		File file1 = new File("/Users/shengboxu/Documents/imp/f/m3b.zip");
		OutputStream output = new FileOutputStream(file1);
		output.write(dmr);
		
	}
	
	public static void to() throws Exception {
		File file = new File("/Users/shengboxu/Documents/imp/f/m3.zip");
		InputStream input = new FileInputStream(file);
		byte[] byt = new byte[input.available()];
		input.read(byt);
		
		byte[] dmr = new byte[byt.length];
		
		for(int i=0;i<dmr.length;i++) {
			byte d = byt[i];
			
			if(d%2==0) {
				dmr[i] = (byte) (d+2*i);
			}else {
				dmr[i] = (byte) (d-2*i);
			}
		}
		
		File file1 = new File("/Users/shengboxu/Documents/imp/f/m3.m");
		OutputStream output = new FileOutputStream(file1);
		output.write(dmr);
	}

}
