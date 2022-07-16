package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientUtility {
	public static String getFileFromUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Gondermek istediyiniz fayli secin:");
		String file = scan.nextLine();
		return file;
	}

	public static String[] getAdressFromUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Serveri daxil edin :");
		String adress = scan.nextLine();
		String adressArray[] = adress.split(":");
		return adressArray;
	}

	public static String readFromFile(String file) throws IOException {
		InputStream is = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(is);
		BufferedReader bReader = new BufferedReader(reader);
		String result = bReader.readLine();
		while (bReader.readLine() != null) {
			result += bReader.readLine();
		}
		return result;
	}

	public static void sendFileToServer(Socket socket, String file) throws IOException {
		String lines = readFromFile(file);
		OutputStream os = socket.getOutputStream();
		DataOutputStream data = new DataOutputStream(os);
		os.write(lines.getBytes());
	}
}
