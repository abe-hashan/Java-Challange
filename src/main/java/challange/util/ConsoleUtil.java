package challange.util;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import challange.config.JsonDataConfig;
import challange.constant.EntityType;
import challange.constant.OrganizationEnum;
import challange.constant.TicketEnum;
import challange.constant.UserEnum;
import challange.domain.Organization;
import challange.domain.Ticket;
import challange.domain.User;
import challange.repository.OrganizationRepository;
import challange.repository.TicketRepository;
import challange.repository.UserRepository;
import challange.service.OrganizationService;
import challange.service.TicketService;
import challange.service.UserService;
import challange.viewModel.OrganizationModel;
import challange.viewModel.TicketViewModel;
import challange.viewModel.UserViewModel;

public class ConsoleUtil {
	
	public static void intiateConsole() throws JsonParseException, JsonMappingException, IOException, Exception{
		
		OrganizationRepository orgRepo =  OrganizationRepository.getRepository(new JsonDataConfig<Organization>().getData(Organization.class));
		TicketRepository ticketRepo =  TicketRepository.getRepository(new JsonDataConfig<Ticket>().getData(Ticket.class));
		UserRepository userRepo =  UserRepository.getRepository(new JsonDataConfig<User>().getData(User.class));
		
		OrganizationService orgService = new OrganizationService(orgRepo, ticketRepo, userRepo);
		TicketService ticketService = new TicketService(orgRepo, ticketRepo, userRepo);
		UserService userService = new UserService(orgRepo, ticketRepo, userRepo);
		
		System.out.println("Type 'quit' to exit anytime. Press 'Enter' to continue\n");
		Scanner in = new Scanner(System.in);
		String commandIn = in.nextLine();
		
		if("QUIT".equals(commandIn.toUpperCase())) {
			in.close();
			return;
		} else {
			showOptions(orgService, ticketService, userService);
		}
		in.close();
	}
	
	public static void showOptions(OrganizationService orgService, TicketService ticketService, UserService userService) {
		boolean t = true;
		
		Scanner input = new Scanner(System.in);
		while(t) {
			System.out.println("--------------------------------------------------");
			System.out.println("Select search options :\n");
			System.out.println("*Press 1 to search");
			System.out.println("*Press 2 to view a list of searchable fields");
			System.out.println("*Type 'quit' to exit");
			
			String commandIn = input.nextLine();
			
			switch(commandIn.toUpperCase()) {
				case "1":
					System.out.println("--------------------------------------------------");
					System.out.println("*Select 1) Users  2) Tickets  3) Organizations");
					System.out.println("*Type quit to exit. Anything else to go back");
					String inputSearchType = input.nextLine().toUpperCase();
					if("1".equals(inputSearchType) || "2".equals(inputSearchType) || "3".equals(inputSearchType) ) {
						System.out.println("Enter Search Field");
						String inputField = input.nextLine().toUpperCase();
						System.out.println("Enter Search value");
						String inputValue = input.nextLine();
						System.out.printf(
								"Searching %s for %s with a value of %s\n", 
								EntityType.MAP.get(inputSearchType).toLowerCase(),
								inputField.toLowerCase(),
								inputValue.toLowerCase()
						);
						switch (inputSearchType) {
							case "1":
								List<UserViewModel> users = userService.search(inputValue, inputField);
								ConsoleUtil.<UserViewModel>printViewModels(users);
								break;
							case "2":
								List<TicketViewModel> tickets = ticketService.search(inputValue, inputField);
								ConsoleUtil.<TicketViewModel>printViewModels(tickets);
								break;
							case "3":
								List<OrganizationModel> orgs=orgService.search(inputValue, inputField);
								ConsoleUtil.<OrganizationModel>printViewModels(orgs);
								break;
							default:
								break;
						}
					} else if("quit".equals(inputSearchType)) {
						return;
					}
					break;
				case "2":
					System.out.println("--------------------------------------------------");
					System.out.println("Select searchable fields 1) Users  2) Tickets  3) Organizations");
					System.out.println("Type quit to exit. Anything else to go back");
					String inputForFileds = input.nextLine();
					switch(inputForFileds.toUpperCase()) {
						case "1":
							for(UserEnum field: UserEnum.values()) {
								System.out.println(field.toString().toLowerCase());
							}
							break;
						case "2":
							for(TicketEnum field: TicketEnum.values()) {
								System.out.println(field.toString().toLowerCase());
							}
							break;
						case "3":
							for(OrganizationEnum field: OrganizationEnum.values()) {
								System.out.println(field.toString().toLowerCase());
							}
							break;
						case "QUIT":
							input.close();
							return;
						default:
							break;
					}
					break;
				case "QUIT":
					input.close();
					return;
				default:
					System.out.println("Command is inavlid\n");
					break;
			}
		}
		input.close();
	}
	
	public static <E> void printViewModels(List<E> items) {
		if(items.isEmpty()) {
			System.out.println("\nNo results found");
			return;
		}
		items.forEach((i)-> {
			System.out.println("\n--------------------------------------------------");
			System.out.println(i);
		});
		System.out.printf("%d results found\n", items.size());
	}
}
