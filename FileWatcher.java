package com.homework.filemanager;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileWatcher implements Runnable{
	private File mainFolder;
	private File[] fileMainArray;
	private int filesCount;
	private StringBuilder sbnew = new StringBuilder();
	private String changed;
	public FileWatcher(File mainFolder) {
		super();
		this.mainFolder = mainFolder;
	}

	public FileWatcher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public File getMainFolder() {
		return mainFolder;
	}
	

	public int getFilesCount() {
		return filesCount;
	}

	private void setFilesCount(int filesCount) {
		this.filesCount = filesCount;
	}

	public String getChanged() {
		return changed;
	}

	public void setChanged(String changed) {
		this.changed = changed;
	}

	public File[] getFileMainArray() {
		return fileMainArray;
	}

	public void setFileMainArray(File[] fileMainArray) {
		this.fileMainArray = fileMainArray;
	}

	private int getFileCount () {
		StringBuilder sb = new StringBuilder();

		File[] fileArray = this.mainFolder.listFiles();
		int filesCount = fileArray.length;
		for (File file : fileArray) {

			sb.append(file.getName() + "\t" + file.length()).append(System.lineSeparator());

			
		}
		if (sb.length() > sbnew.length()) {
			for (int i = 0; i < fileMainArray.length;i++) {
				for (int j = 0; j < filesCount; j++) {
					
				
				if (!fileMainArray[i].getName().equals(fileArray[j].getName())) {
					changed = fileArray[j].getName() + "\t" + fileArray[j].length();
				}
				}
			}
			
				System.out.println("new file" + " " + changed);
				System.out.println();

		} else  
		if (sb.length() < sbnew.length()) {
			for (int i = 0; i < filesCount;i++) {
				for (int j = 0; j < fileMainArray.length; j++) {
					
				
				if (!fileArray[i].getName().equals(fileMainArray[j].getName())) {
					changed = fileMainArray[j].getName() + "\t" + fileMainArray[j].length();
				}
				}
			}
				System.out.println("deleted file" + " " + changed);
				System.out.println();
			
		}
		return filesCount;
	}
	private String getFolderInfo() {
		if (mainFolder == null) return "None";
		//StringBuilder sb = new StringBuilder();
		fileMainArray = this.mainFolder.listFiles();
		
		for (File file : fileMainArray) {
			sbnew.append(file.getName() + "\t" + file.length()).append(System.lineSeparator());
			filesCount++;
			
		}
		setFilesCount(filesCount);
		return sbnew.toString();
	}

	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy   hh:mm:ss");


		
		System.out.println(sdf.format(System.currentTimeMillis()));
		System.out.println(getFolderInfo());
		System.out.println();
		
		for (;;) {

			if (getFileCount() == getFilesCount()) {
			
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

				}
			} else {
				System.out.println();
				System.out.println(getFolderInfo());
				break;
			}

			
		}
//		System.out.println(sdf.format(System.currentTimeMillis()));
//		System.out.println(getFolderInfo());
//		System.out.println();
	}
	
	
}
