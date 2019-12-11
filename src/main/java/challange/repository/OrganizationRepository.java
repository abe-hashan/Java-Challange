package challange.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import challange.constants.OrganizationEnum;
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
		try {
			OrganizationEnum orgField = OrganizationEnum.valueOf(field);
			switch (orgField) {
			case _ID:
				return Objects.equals(term, organization.get_id());
			case URL:
				return Objects.equals(term, organization.getUrl());
			case CREATED_AT:
				return Objects.equals(term, organization.getCreated_at());
			case EXTERNAL_ID:
				return Objects.equals(term, organization.getExternal_id());
			case NAME:
				return Objects.equals(term, organization.getName());
			case DOMAIN_NAMES:
				return organization.getDomain_names().contains(term);
			case DETAILS:
				return Objects.equals(term, organization.getDetails());
			case SHARED_TICKETS:
				return Objects.equals(term, Boolean.toString(organization.isShared_tickets()));
			case TAGS:
				return organization.getTags().contains(term);
			default:
				return false;
			}
		}catch (Exception e) {
			return false;
		}
	}

}
