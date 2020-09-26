package de.sgrad.smt;

public class ServerFactory {
	
	public static IServer GetServer(String serverType) throws Exception {
		
		switch(serverType) {
		case "mail":
			return new MailServer();
		case "ftp":
			return new FtpServer();
		default:
			throw new IllegalArgumentException("Unexpected value: " + serverType);
		}
	}
}
