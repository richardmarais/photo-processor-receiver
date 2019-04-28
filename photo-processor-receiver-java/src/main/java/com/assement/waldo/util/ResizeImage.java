package com.assement.waldo.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ResizeImage {
	
	public static final int WIDTH = 320;
	public static final int HEIGHT = 320;
    
    public static String resize(String url) throws IOException {
    	try {
        	String currentDir = new File(".").getAbsolutePath();
        	URL tUrl = new URL(url);	
            BufferedImage image = ImageIO.read(tUrl);
            BufferedImage resized = resize(image, HEIGHT, WIDTH);
            String resizedUrl = "/waldo-app-thumbs/"+getPhotoName(url)+"-"+HEIGHT+"x"+WIDTH+".jpg";
            File output = new File(currentDir+resizedUrl);
            ImageIO.write(resized, "jpg", output);
            return currentDir+resizedUrl;
		} catch (Exception e) {
			System.out.println("Cannot resize file: "+url);
			e.printStackTrace();
		}
    	return null;
    }

    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
    
    private static String getPhotoName(String url) {
    	return url.substring(url.lastIndexOf("/") + 1).replaceAll(".jpg", "");
    }
}
