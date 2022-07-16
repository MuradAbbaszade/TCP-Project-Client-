package main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import util.ClientUtility;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String file = ClientUtility.getFileFromUser();
		String adressArray[] = ClientUtility.getAdressFromUser();
		String host = adressArray[0];
		int port = Integer.parseInt(adressArray[1]);
		
		Socket socket = new Socket(host, port);
		ClientUtility.sendFileToServer(socket, file);
		socket.close();
	}

}
