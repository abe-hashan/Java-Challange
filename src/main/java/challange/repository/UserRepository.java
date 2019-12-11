package challange.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import challange.domain.User;

public class UserRepository implements IRepository<User> {

	private static UserRepository instance = null;
	
	private List<User> data = new ArrayList<User>();
	
	private UserRepository(List<User> users) {
		data = users;
	}

	public static UserRepository getRepository(List<User> users) {
		if (instance == null) {
			instance = new UserRepository(users);
		}
		return instance;
	}

	public List<User> search(String term, String field) {
		List<User> users = this.data.stream().filter(user -> {
			boolean matched = isMatch(term, field.toUpperCase(), user);
			return matched;
		}).collect(Collectors.toList());
		return users;
	}

	private boolean isMatch(String term, String field, User user) {
		switch (field) {
		case "_ID":
			return term.equals(user.get_id());
		case "EMAIL":
			return term.equals(user.getEmail());
		case "CREATED_AT":
			return term.equals(user.getCreated_at());
		case "EXTERNAL_ID":
			return term.equals(user.getExternal_id());
		case "LOCALE":
			return term.equals(user.getLocale());
		case "NAME":
			return term.equals(user.getName());
		case "PHONE":
			return term.equals(user.getPhone());
		case "SIGNATURE":
			return term.equals(user.getSignature());
		case "TIMEZONE":
			return term.equals(user.getTimezone());
		case "URL":
			return term.equals(user.getUrl());
		case "TAGS":
			return user.getTags().contains(term);
		default:
			return false;
		}
	}

}
