import java.io.IOException;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Main {	
	public static final String reset = "\u001B[0m";
	public static final String black = "\u001B[30m";
	public static final String red = "\u001B[31m";
	public static final String green = "\u001B[32m";
	public static final String yellow = "\u001B[33m";
	public static final String blue = "\u001B[34m";
	public static final String purple = "\u001B[35m";
	public static final String cyan = "\u001B[36m";
	public static final String white = "\u001B[37m";

  public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		System.out.print(green + "Input ping size:" + reset);
		String packetSize = reader.nextLine();
		System.out.print(green + "Input packet count:" + reset);
		String count = reader.nextLine();
		System.out.print(green + "Input ip to ping:" + reset);
		String ip = reader.nextLine();
		System.out.print(green + "Input ping interval:" + reset);
		String interval = reader.nextLine();

  	String command = "ping -s" + packetSize + "-i" + interval + "-c" + count + ip;

		try {
			Process process = Runtime.getRuntime().exec(command);
			BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = bf.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}

  }
}