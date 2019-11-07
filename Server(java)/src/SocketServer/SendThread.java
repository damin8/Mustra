package SocketServer;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SendThread extends Thread{
	private Socket sendSocket;
	@Override
	public void run() {
		super.run();
		try {
			/*BufferedReader tmpbuf =  비동기 send
					new BufferedReader(new InputStreamReader(System.in));
			PrintWriter sendWriter = new PrintWriter(sendSocket.getOutputStream());
		*/}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void setSocket(Socket socket) {
		this.sendSocket = socket;
	}
}
