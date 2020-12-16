package Main;

import java.util.Scanner;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	private Socket socket;
	private Scanner in;
	private PrintWriter out;
	
	public Client(String serverAddress) throws Exception {
		
		socket = new Socket(serverAddress, 58901);
		in = new Scanner(socket.getInputStream());
		out = new PrintWriter(socket.getOutputStream(), true);
		
	}
	
	public void readMessageStart() throws Exception {
		try {
			var responseSetUP = in.nextLine();
			out.println("WAITNG");
			while (in.hasNextLine()) {
				responseSetUP = in.nextLine();
				if (responseSetUP.startsWith("NO_PLAYERS ") || responseSetUP.startsWith("AL_PLAYERS ")) {
					String[] tmp = responseSetUP.substring(11).split(";");
					GUI gui = new GUI(tmp[0], tmp[1], tmp[2], tmp[3]);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void readMessage() throws Exception {
		try {
			var response = in.nextLine();
			
			while (in.hasNextLine()) {
				response = in.nextLine();
				
			}
			out.println("QUIT");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			socket.close();
			// zamknij GUI
		}
	}
	
	public void readMessage(String Message){
	
	}
	
	public void writeTouch(int x, int y){
		out.println("MOVE " + x + ";" + y);
		
	}
	
	public static void main(String[] args) throws Exception {
		GUI gui = new GUI("Classical", "Circle", "red", "6");
		//Client client = new Client("localhost");
		//client.readMessageStart();
		//client.readMessage();
	}
}