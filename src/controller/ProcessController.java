package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessController {
	public ProcessController() {
		super();
	}
	
	public String os() {
		String os = System.getProperty("os.name");
		
		return os;
	}
	
	public void taskList(String os) {
		if (os.contains("Windows")) {
			String cmd = "TASKLIST";
			try {
				Process p = Runtime.getRuntime().exec(cmd);
				InputStream flow = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(flow);
				BufferedReader buffer = new BufferedReader(reader);
				String line = buffer.readLine();
				
				while (line != null) {
					System.out.println(line);
					line = buffer.readLine();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (os.contains("Linux")) {
			String cmd = "PS -AUX";
			try {
				Process p = Runtime.getRuntime().exec(cmd);
				InputStream flow = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(flow);
				BufferedReader buffer = new BufferedReader(reader);
				String line = buffer.readLine();
				
				while (line != null) {
					System.out.println(line);
					line = buffer.readLine();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void processKillerPid(String os, int pid) {
		if (os.contains("Windows")) {
			StringBuffer cmd = new StringBuffer();
			cmd.append("TASKKILL /PID");
			cmd.append(" ");
			cmd.append(pid);
			try {
				Runtime.getRuntime().exec(cmd.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (os.contains("Linux")) {
			StringBuffer cmd = new StringBuffer();
			cmd.append("KILL -9");
			cmd.append(" ");
			cmd.append(pid);
			try {
				Runtime.getRuntime().exec(cmd.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void processKillerName(String os, String name) {
		if (os.contains("Windows")) {
			StringBuffer cmd = new StringBuffer();
			cmd.append("TASKKILL /IM");
			cmd.append(" ");
			cmd.append(name);
			try {
				Runtime.getRuntime().exec(cmd.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (os.contains("Linux")) {
			StringBuffer cmd = new StringBuffer();
			cmd.append("PKILL");
			cmd.append(" ");
			cmd.append(name);
			try {
				Runtime.getRuntime().exec(cmd.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
