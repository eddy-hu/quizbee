package com.demo.quizbee.javafx;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileUtils {
	
	private static QA[] qaAr;
		
	public static void setQAArray(String absPath, int numObjects) {
		qaAr = new QA[numObjects];
		if (fileExists(absPath)) {
			try {
				FileInputStream fis = new FileInputStream(absPath);
				ObjectInputStream ois = new ObjectInputStream(fis);
				for (int i = 0; i < numObjects; i++)
					qaAr[i] = (QA) (ois.readObject());
				ois.close();
			} catch (IOException | ClassNotFoundException e) {} 
		}
		else 
			qaAr = null;
	}
	
	public static QA[] getQAArray() {return qaAr;}

	public static boolean fileExists(File f) {
		return (f != null && f.exists() && f.isFile() && f.canRead() && (f.length() > 2));
	}

	public static boolean fileExists(String s) {
		return (fileExists(new File(s)));
	}
	
	public static String getAbsPath(File f) {
		return f.getAbsolutePath();
	}

}
