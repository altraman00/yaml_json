package com.mdl.Io.write;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
	public static void main(String[] args) {
		
//		System.out.println(Thread.currentThread().getContextClassLoader().getResource("")); 
//		System.out.println(FileWriterDemo.class.getClassLoader().getResource("")); 
//		System.out.println(ClassLoader.getSystemResource("")); 
//		System.out.println(FileWriterDemo.class.getResource("")); 
//		System.out.println(FileWriterDemo.class.getResource("/")); 
		//Class文件所在路径 
//		System.out.println(new File("/").getAbsolutePath()); 
//		System.out.println(System.getProperty("user.dir")); 
//		System.getProperty("user.dir");
		
		String path = System.getProperty("user.dir");
		System.out.println(path);
		
        FileWriter fileWriter = null;
        try {
            try {
            	//如果文件不存在，则自动创建一个文件
                fileWriter = new FileWriter(path + "/src/main/sources/files/txt/FileWriterDemo1.txt");
                fileWriter.write("demo123456789");
            } finally {
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
