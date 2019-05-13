package com.bjsxt.chat.server;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtil {
	public static void closeAll(Closeable... able){
		for (Closeable c : able) {
			if (c!=null) {
				try {
					c.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
