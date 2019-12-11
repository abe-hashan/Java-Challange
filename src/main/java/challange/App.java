package challange;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import challange.utils.ConsoleUtil;

public class App {

	public static void main(String[] args) {
		try {
			ConsoleUtil.intiateConsole();
		}
		catch (JsonParseException | JsonMappingException e) {
			System.out.println("Data source is out of format. Program is exiting...");
		}
		catch (IOException e) {
			System.out.println("Data source read error. . Program is exiting...");
		}
		catch (Exception e) {
			System.out.println("Program is exiting...");
		}
	}

}
