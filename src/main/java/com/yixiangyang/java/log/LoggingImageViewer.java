package com.yixiangyang.java.log;

import java.awt.EventQueue;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoggingImageViewer {

	public static void main(String[] args) {
		if(System.getProperty("java.util.logging.config.class")==null 
				&& System.getProperty("java.util.logging.config.file") == null){
			try {
				Logger.getLogger("com.horstmann.corejava").setLevel(Level.ALL);
				final int LOG_TOTATION_COUNT = 10;
				Handler handler = new FileHandler("%h/LoggingImageViewer.log",0,LOG_TOTATION_COUNT);
				Logger.getLogger("com.horstmann.corejava").addHandler(handler);
			} catch (Exception e) {
				Logger.getLogger("com.horstmann.corejava").log(Level.SEVERE, "没有发现文件", e);
			}
		}
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				//Handler windowHandler = new
				
			}
		});
	}
/*	
	class ImageViewerFrame extends JFrame{
		public ImageViewerFrame(){
			logger.
		}
	}*/

}
