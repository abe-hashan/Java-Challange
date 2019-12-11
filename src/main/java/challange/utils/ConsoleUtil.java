package challange.utils;

import java.util.Scanner;

import challange.constants.UserEnum;

public class ConsoleUtil {
	public static void intiateConsole() {
		
//		showInstructions();
		showOptions();
		
		
		
//		try {
//			UserEnum userField = UserEnum.valueOf(command);
//			
//		} catch(Exception e) {
//			
//		}
//		
//		input.close();
//		
//		switch(command) {
//			case "1":
//				
//				break;
//			default:
//				System.out.println("Wrong input. Please try again");
//				break;
//		}
		
		
	}
	
	private static String showInstructions() {
		boolean t = true;
		while(t) {
			System.out.println("Type 'quit' to exit anytime. Press 'Enter' to continue\n");
			Scanner input = new Scanner(System.in);
			String commandIn = input.nextLine();
			input.close();
			if("QUIT".equals(commandIn.toUpperCase())) {
				return "QUIT";
			} else if(!commandIn.isEmpty()){
				System.out.println("Command is inavlid\n");
			} else {
				break;
			}
		}
		return "CONTINUE";
	}
	
	public static void showOptions() {
		System.out.println("Select search options");
		System.out.println("Press 1 to search");
		System.out.println("Press 2 to view a list of searchable fields");
		System.out.println("Type 'quit' to exit");
		
		Scanner input = new Scanner(System.in);
		String commandIn = input.nextLine();
		
		switch(commandIn.toUpperCase()) {
			case "1":
				System.out.println("Select 1) Users  2) Tickets  3) Organizations");
			case "2":
				System.out.println("User fields:");
				for(UserEnum field: UserEnum.values()) {
					System.out.println(field.toString().toLowerCase());
				}
		}
		
		input.close();
		
		
	}
	
	public static void initiateSearch() {
		
	}
}
