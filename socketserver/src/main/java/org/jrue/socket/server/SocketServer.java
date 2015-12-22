package org.jrue.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(1234);
		System.out.println("Listening...");
		while(true) {
			try {
				Socket client = server.accept();
				InputStream read = client.getInputStream();
				OutputStream write = client.getOutputStream();
				
				PrintWriter writer = new PrintWriter(write);
				
				writer.println("What's your name?");
				writer.flush();
				BufferedReader reader = new BufferedReader(new InputStreamReader(read));
				writer.println(String.format("Oh hello %s! nice meeting you! bye!",reader.readLine()));
				writer.flush();
				reader.close();
				writer.close();
				write.close();
				client.close();
			} catch (UnknownHostException e) {
				System.out.println("Unknown host");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
}
