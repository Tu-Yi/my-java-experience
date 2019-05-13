package com.bjsxt.buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestBuffered {
	public static void main(String[] args) {
		//»º³å×Ö·ûÁ÷
		BufferedReader br=null;
		BufferedWriter bw=null;
		try {
			br = new BufferedReader(new FileReader("D:\\a.txt"));
			bw = new BufferedWriter( new FileWriter("D:\\copya.txt"));
			String line=null;//ÓÃÓÚ´æ´¢¶Áµ½µÄ×Ö·û´®
			while((line=br.readLine())!=null){
				bw.write(line);
				bw.newLine();
				bw.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bw!=null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
