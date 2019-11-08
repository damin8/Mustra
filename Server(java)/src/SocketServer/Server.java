package SocketServer;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private Socket c_socket = null;
	
	public Server() {
		try {
			System.out.println("접속자 받습니다");
			ServerSocket s_socket = new ServerSocket(8888);
			c_socket = s_socket.accept();
			System.out.println("들어 왔네용");
			SendData.getSendData().setSocket(c_socket);
			ReceiveThread receiveThread = new ReceiveThread();
			receiveThread.setSocket(c_socket);
			receiveThread.start();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
