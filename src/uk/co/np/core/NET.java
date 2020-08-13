package uk.co.np.core;

import java.io.*;
import java.net.*;
import java.util.*;

class NET {
	private static Queue<String> messageBuffer = new LinkedList<>();
	private static ServerSocket server;
	public static boolean SendString(String msg, String ip, int port) {
		if(ip == null) ip = "127.0.0.1";
		try {
			Socket sock = new Socket(ip, port);
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(sock.getOutputStream())
			);
			
			writer.write(msg);
			writer.newLine();
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static String GetNextMessage() {
		return messageBuffer.poll();
	}
	
	public static Thread StartListening(int port) {
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			return null;
		}
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				ReadInputLoop();
			}
		});
		t.setName("NET-INPUT-LISTENER-DAEMON");
		t.setDaemon(true);
		t.start();
		return t;
	}
	
	public static boolean HasNextMessage() {
		return !messageBuffer.isEmpty();
	}
	
	private static void ReadInputLoop() {
		try {
			System.err.println("Waiting For A Connection...");
			Socket sock = server.accept();
			System.err.println("Connected To "+sock.getInetAddress());
			BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			while(true) {
				String message = reader.readLine();
				if(message != null) messageBuffer.add(message);
			} 
		} catch (IOException e) {
			System.err.println(e);
			return;
		}
	}
}
