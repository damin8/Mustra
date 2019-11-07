package SocketServer;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import Music.MusicModel;

public class ReceiveThread extends Thread{
	private Socket receiveSocket;
	private String[] tokens;
	@Override
	public void run() {
		super.run();
		try {
			BufferedReader tmpbuf = 
					new BufferedReader
					(new InputStreamReader(receiveSocket.getInputStream()));
			String receiveString;
			while(true) {
				receiveString = tmpbuf.readLine();
				tokens = receiveString.split("/");
				if(receiveString == null) {
					System.out.println("연결 끊김");
					break;
				}
				else if(tokens.length==1) {
					break;
				}
				else {
					System.out.print("상대방 : ");
					for(int i=0;i<tokens.length;i++) {
						System.out.print(tokens[i] + " ");
					}
					System.out.println();
					MusicModel.getMusicModel().Test(tokens[0], tokens[1], tokens[2], tokens[3]);
					

				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void setSocket(Socket socket) {
		this.receiveSocket = socket;
	}
	public String[] getReceiveData() {
		return tokens;
	}
}
