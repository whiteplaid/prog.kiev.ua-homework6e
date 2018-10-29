package com.homework.filemanager;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File folder = new File ("src/com/homework/filemanager/folder/");
		Thread thr = new Thread(new FileWatcher(folder));
		thr.start();
		

		
	}

}
