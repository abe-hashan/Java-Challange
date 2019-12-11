package challange.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import challange.constant.UserEnum;
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
		try {
			UserEnum userField = UserEnum.valueOf(field);
			switch (userField) {
			case _ID:
				return Objects.equals(term,user.get_id());
			case ALIAS:
				return Objects.equals(term,user.getAlias());
			case ACTIVE:
				return Objects.equals(term,Boolean.toString(user.isActive()));
			case VERIFIED:
				return Objects.equals(term,Boolean.toString(user.isVerified()));
			case SHARED:
				return Objects.equals(term,Boolean.toString(user.isShared()));
			case SUSPENDED:
				return Objects.equals(term,Boolean.toString(user.isSuspended()));
			case LAST_LOGIN_AT:
				return Objects.equals(term,user.getLast_login_at());
			case ORGANIZATION_ID:
				return Objects.equals(term,user.getOrganization_id());
			case ROLE:
				return Objects.equals(term,user.getRole());
			case EMAIL:
				return Objects.equals(term,user.getEmail());
			case CREATED_AT:
				return Objects.equals(term,user.getCreated_at());
			case EXTERNAL_ID:
				return Objects.equals(term,user.getExternal_id());
			case LOCALE:
				return Objects.equals(term,user.getLocale());
			case NAME:
				return Objects.equals(term,user.getName());
			case PHONE:
				return Objects.equals(term,user.getPhone());
			case SIGNATURE:
				return Objects.equals(term,user.getSignature());
			case TIMEZONE:
				return Objects.equals(term,user.getTimezone());
			case URL:
				return Objects.equals(term,user.getUrl());
			case TAGS:
				return user.getTags().contains(term);
			default:
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
		
	}

}
