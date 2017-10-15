package com.mdl.Io.write;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class TestWriter {
	
	static String path = System.getProperty("user.dir");
	
    public static void main(String[] args) {  
        TestWriter testWriter = new TestWriter();
        
        System.out.println(path);
        
        String file_path = path + "/src/main/sources/files/txt/TestWriter.txt";
        
        testWriter.writeFileByFileWriter(file_path);  
        testWriter.writeFileByBufferWriter(file_path);  
    }  

    
    /**
     * 字符
     * @param file_path
     */
    public void writeFileByFileWriter(String file_path){
        FileWriter fileWriter = null;  
        try {  
            fileWriter = new FileWriter(file_path,true);             
            //将字符串写入到流中，\r\n表示换行  
            //因为fileWriter不会自动换行
            fileWriter.write("本行是通过fileWriter加入的行\r\n");  
            //如果想马上看到写入效果，则需要调用w.flush()方法  
            fileWriter.flush();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if(fileWriter != null) {  
                try {  
                    fileWriter.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }

    
    /**
     * 缓冲
     * @param file_path
     */
    public void writeFileByBufferWriter(String file_path){
        File file = new File(file_path);  
        if (file.isFile()) {  
            BufferedWriter bufferedWriter = null;  
            FileWriter fileWriter = null;  
            try {  
                fileWriter = new FileWriter(file,true);  
                bufferedWriter = new BufferedWriter(fileWriter);  
                bufferedWriter.write("本行是通过bufferedWriter加入的行\r\n");  
                bufferedWriter.flush();  
            } catch (FileNotFoundException e) {  
                e.printStackTrace();  
            } catch (IOException e) {  
                e.printStackTrace();  
            } finally {  
                try {  
                    fileWriter.close();  
                    bufferedWriter.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    } 
}
