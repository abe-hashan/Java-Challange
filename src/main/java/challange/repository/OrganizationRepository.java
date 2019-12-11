package challange.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import challange.domain.Organization;

public class OrganizationRepository implements IRepository<Organization> {

	private List<Organization> data = new ArrayList<Organization>();
	private static OrganizationRepository instance = null;

	private OrganizationRepository(List<Organization> organizations) {
		data = organizations;
	}

	public static OrganizationRepository getRepository(List<Organization> organizations) {
		if (instance == null) {
			instance = new OrganizationRepository(organizations);
		}
		return instance;
	}

	public List<Organization> search(String term, String field) {
		List<Organization> organizations = this.data.stream()
				.filter(organization -> isMatch(term, field, organization))
				.collect(Collectors.toList());
		return organizations;
	}

	private boolean isMatch(String term, String field, Organization organization) {
		switch (field) {
		case "_ID":
			return term.equals(organization.get_id());
		case "URL":
			return term.equals(organization.getUrl());
		case "CREATED_AT":
			return term.equals(organization.getCreated_at());
		case "EXTERNAL_ID":
			return term.equals(organization.getExternal_id());
		case "NAME":
			return term.equals(organization.getName());
		case "DOMAIN_NAMES":
			return organization.getDomain_names().contains(term);
		case "DETAILS":
			return term.equals(organization.getDetails());
		case "SHARED_TICKETS":
			return term.equals(Boolean.toString(organization.isShared_tickets()));
		case "TAGS":
			return organization.getTags().contains(term);
		default:
			return false;
		}
	}

}
