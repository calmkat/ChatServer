package ChatServer;
/**
 * Created by junsookim on 11/1/15.
 */
import org.omg.CORBA.INVALID_ACTIVITY;

import java.util.*;

/**
 * <b> CS 180 - Project 4 - Chat Server Skeleton </b>
 * <p>
 *
 * This is the skeleton code for the ChatServer Class. This is a private chat
 * server for you and your friends to communicate.
 *
 * @author (Your Name) <(YourEmail@purdue.edu)>
 *
 * @lab (Your Lab Section)
 *
 * @version (Today's Date)
 *
 */
public class ChatServer {
	private int maxMessages;
	private User[] users;
	public ChatServer(User[] users, int maxMessages) {
		this.maxMessages = maxMessages;
		this.users = new User[0];
		//finish this after user
	}

	/**
	 * This method begins server execution.
	 */
	public void run() {
		boolean verbose = false;
		System.out.printf("The VERBOSE option is off.\n\n");
		Scanner in = new Scanner(System.in);

		while (true) {
			System.out.printf("Input Server Request: ");
			String command = in.nextLine();

			// this allows students to manually place "\r\n" at end of command
			// in prompt
			command = replaceEscapeChars(command);

			if (command.startsWith("kill"))
				break;

			if (command.startsWith("verbose")) {
				verbose = !verbose;
				System.out.printf("VERBOSE has been turned %s.\n\n", verbose ? "on" : "off");
				continue;
			}

			String response = null;
			try {
				response = parseRequest(command);
			} catch (Exception ex) {
				response = MessageFactory.makeErrorMessage(MessageFactory.UNKNOWN_ERROR,
						String.format("An exception of %s occurred.", ex.getMessage()));
			}

			// change the formatting of the server response so it prints well on
			// the terminal (for testing purposes only)
			if (response.startsWith("SUCCESS\t"))
				response = response.replace("\t", "\n");

			// print the server response
			if (verbose)
				System.out.printf("response:\n");
			System.out.printf("\"%s\"\n\n", response);
		}

		in.close();
	}

	/**
	 * Replaces "poorly formatted" escape characters with their proper values.
	 * For some terminals, when escaped characters are entered, the terminal
	 * includes the "\" as a character instead of entering the escape character.
	 * This function replaces the incorrectly inputed characters with their
	 * proper escaped characters.
	 *
	 * @param str
	 *            - the string to be edited
	 * @return the properly escaped string
	 */
	private static String replaceEscapeChars(String str) {
		str = str.replace("\\r", "\r");
		str = str.replace("\\n", "\n");
		str = str.replace("\\t", "\t");
		return str;
	}

	/**
	 * Determines which client command the request is using and calls the
	 * function associated with that command.
	 *
	 * @param request
	 *            - the full line of the client request (CRLF included)
	 * @return the server response
	 */
	public String parseRequest(String request) {
		String command = request.split(" ")[0];
		String[] parameters = new String[request.split(" ").length - 1];
		for (int i = 1; i < request.split(" ").length; i++) {
			parameters[i] = request.split(" ")[i];
		}
		if (command.equals("addUser")) {
			//addUser()
			return " ";
		} else if (command.equals("userLogin")) {
			//userLogin()
			return " ";
		} else if (command.equals("postMessage")) {
			//postMessage()
			return " ";
		} else if (command.equals("getMessage")) {
			//getMessage()
			return " ";
		} else {
			//return INVALID_VALUE_ERROR;
			return " ";
		}
	}

	public String addUser(String[] args) {
		Scanner s = new Scanner();
		System.out.println("input your username");
		String username = s.nextLine();
		String[] username1 = username.split("");
		for (int i = 0; i < username1.length; i++) {
			if (!(username1[i].equals("a"))) { //FIX!!!!!
				username = " ";
			}
		}
		System.out.println("input your password");
		String password = s.nextLine();
		if (!(password.length() < 21 && password.length() > 0)) {
			password = " ";
		}
		SessionCookie s = new SessionCookie(0321); //FIX!
		User u = new User(username, password, s);
		return "SUCCESS";
	}

	public String userLogin(String[] args) {
		return " "; //FIX
	}

	public String postMessage(String[] args, String name) {
		return " "; //FIX
	}

	public String getMessages(String[] args) {
		return " "; //FIX
	}
}

