package SocketServer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import Music.MusicModel;

public class ReceiveThread extends Thread{
	private Socket receiveSocket;
	private String[] tokens;
	
	
	@Override
	public void run() {
		try {
			BufferedReader tmpbuf = new BufferedReader
					(new InputStreamReader(receiveSocket.getInputStream(),"UTF8"));
			String receiveString;
			while(true) {
				receiveString = tmpbuf.readLine();
				System.out.println(receiveString);
				tokens = receiveString.split("/");
				if(receiveString.equals(null)) {
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
					//								알고리즘	  ArtistN    SongN       FanNum                       Video
					MusicModel.getMusicModel().Test(tokens[0],tokens[1], tokens[2],	Double.parseDouble(tokens[3]),tokens[4]);
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
