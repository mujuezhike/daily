package com.mujuezhike.daily.img;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;

public class ImageTest {
	
	public static void main(String[] args){
		
		QRCodeDecoder decoder = new QRCodeDecoder();  
        File imageFile = new File("D://TestQRCode.png");  
        BufferedImage image = null;  
        try {  
            image = ImageIO.read(imageFile);  
        } catch (IOException e) {  
            System.out.println("Error: " + e.getMessage());  
        }  
          
        int[][] is = imageToIntArray(image);
        
        for(int i=0;i<is.length;i++){
        	
        	for(int j=0;j<is[i].length;j++){
        		
        		if(is[i][j]<-1){
        			
        			System.out.print(1);
        			
        		}else{
        			
        			System.out.print(0);
        			
        		}
        		
        	}
        	
        	System.out.println();
        	
        }
        
		
	}

	public static int[][] imageToIntArray(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		int[][] intImage = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				intImage[x][y] = image.getRGB(x, y);
			}
		}
		return intImage;
	}
	
}
