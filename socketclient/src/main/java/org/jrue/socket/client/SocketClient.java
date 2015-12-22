package org.jrue.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClient {

	public static void main(String[] args) {
		try {
			System.out.println("Communicating to server");
			Socket socket = new Socket("localhost", 1234);
			System.out.println("Connected to server");
			InputStream read = socket.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(read));
			System.out.println(br.readLine());
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			OutputStream write = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(write, true);
			writer.println(input);
			
			System.out.println(br.readLine());
			
			read.close();
			write.close();
			sc.close();
			socket.close();
		} catch (UnknownHostException e) {
			System.out.println("Unknown host");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
