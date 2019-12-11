package challange;

import java.util.List;
import challange.domain.User;
import challange.repository.UserRepository;
import challange.services.JsonDataService;
import challange.utils.ConsoleUtil;

public class App {

	public static void main(String[] args) {
		ConsoleUtil.intiateConsole();
//		try {
//			List<User> users = new JsonDataService<User>().getData("users.json", User.class);
//			UserRepository userRepo = UserRepository.getRepository(users);
//			System.out.println(userRepo.search("Francisca Rasmussen","name").get(0).get_id());
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		
	}

}
