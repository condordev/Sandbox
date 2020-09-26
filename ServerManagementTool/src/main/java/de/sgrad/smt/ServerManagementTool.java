package de.sgrad.smt;

import java.util.Scanner;

public class ServerManagementTool {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("Which server do you want to resolve?");
		String serverResult = input.nextLine();
		
		IServer server = ServerFactory.GetServer(serverResult);
		server.resolve();
		input.close();
	}

}
