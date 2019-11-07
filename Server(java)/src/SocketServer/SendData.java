package SocketServer;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SendData {
	private static SendData SD = new SendData();
	private Socket sendSocket;
	private SendData() {
		
	}
	public static SendData getSendData() {
		return SD;
	}
	public void setSocket(Socket socket) {
		sendSocket = socket;
	}
	public void Send(String data) {
		try {
		OutputStream output_data = sendSocket.getOutputStream();
		output_data.write(data.getBytes());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
