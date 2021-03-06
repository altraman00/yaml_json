package com.mdl.Io.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReader {

	static String path = System.getProperty("user.dir");

	public static void main(String[] args) {
		TestReader testReader = new TestReader();
		String file_path = path + "/src/main/sources/files/txt/TestReader.txt";
		testReader.readFileByFileReader(file_path);
		testReader.readFileByBufferedReader(file_path);
	}

	
	/**
	 * 字符
	 * @param file_path
	 */
	public void readFileByFileReader(String file_path) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file_path);
			char[] buf = new char[1024]; // 每次读取1024个字符
			int temp = 0;
			System.out.println("readFileByFileReader执行结果：\n");
			while ((temp = fileReader.read(buf)) != -1) {
				System.out.print(new String(buf, 0, temp) + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 像这种i/o操作尽量finally确保关闭
			if (fileReader != null) {
				try {
					System.out.println("------文件读取完毕，关闭IO资源------\n");
					fileReader.close();
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
	public void readFileByBufferedReader(String file_path) {
		File file = new File(file_path);
		if (file.isFile()) {
			BufferedReader bufferedReader = null;
			FileReader fileReader = null;
			try {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				String line = bufferedReader.readLine();
				System.out.println("readFileByBufferReader执行结果：\n");
				while (line != null) {
					System.out.println(line);
					line = bufferedReader.readLine();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					System.out.println("------文件读取完毕，关闭IO资源------\n");
					fileReader.close();
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
